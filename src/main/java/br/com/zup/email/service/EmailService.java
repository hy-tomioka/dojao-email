package br.com.zup.email.service;

import br.com.zup.email.domain.Transacao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    public void envia(Transacao transacao) {
        LOGGER.info(transacao.formataComoEmail());
    }
}
