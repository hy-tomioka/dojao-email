package br.com.zup.email.kafka;

import br.com.zup.email.domain.Transacao;
import br.com.zup.email.domain.repository.TransacaoRepository;
import br.com.zup.email.kafka.message.TransacaoMessage;
import br.com.zup.email.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class KafkaConsumer {

    private final TransacaoRepository transacaoRepository;

    private final EmailService emailService;

    private final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    public KafkaConsumer(TransacaoRepository transacaoRepository, EmailService emailService) {
        this.transacaoRepository = transacaoRepository;
        this.emailService = emailService;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}", containerFactory = "kafkaListenerContainerFactory")
    @Transactional
    public void consome(@Payload TransacaoMessage transacaoMessage) {
        try {
            Transacao transacao = transacaoRepository.save(transacaoMessage.messageToDomain());
            LOGGER.info("Registrando a transacao: {}",transacao.getUuid());
            emailService.envia(transacao);
        } catch (RuntimeException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
