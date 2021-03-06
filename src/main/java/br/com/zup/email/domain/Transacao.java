package br.com.zup.email.domain;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private UUID uuid = UUID.randomUUID();

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoOperacao operacao;

    @NotNull
    @Column(nullable = false)
    private BigDecimal valor;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime data;

    @NotEmpty
    @Column(nullable = false)
    private String idCliente;

    @NotNull
    @Column(nullable = false)
    private String numeroConta;

    @Deprecated
    public Transacao(){}

    public Transacao(TipoOperacao operacao, BigDecimal valor, LocalDateTime data, String idCliente, String numeroConta) {
        this.operacao = operacao;
        this.valor = valor;
        this.data = data;
        this.idCliente = idCliente;
        this.numeroConta = numeroConta;
    }

    public UUID getUuid() {
        return uuid;
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

    public String formataComoEmail() {
        return String.format("Operação: %s\nValor: %s\nData: %s", operacao, valor, data);
    }
}
