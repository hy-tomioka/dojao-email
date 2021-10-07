package br.com.zup.email.kafka.message;

import br.com.zup.email.domain.TipoOperacao;
import br.com.zup.email.domain.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoMessage {

    private TipoOperacao operacao;

    private BigDecimal valor;

    private LocalDateTime data;

    private String idCliente;

    private String numeroConta;

    public TransacaoMessage(TipoOperacao operacao, BigDecimal valor, LocalDateTime data, String idCliente, String numeroConta) {
        this.operacao = operacao;
        this.valor = valor;
        this.data = data;
        this.idCliente = idCliente;
        this.numeroConta = numeroConta;
    }

    public TipoOperacao getOperacao() {
        return operacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public Transacao messageToDomain(){
        return new Transacao(this.operacao, this.valor, this.data, this.idCliente, this.numeroConta);
    }
}