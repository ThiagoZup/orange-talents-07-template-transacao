package br.com.zupacademy.thiago.transacao.model;

import br.com.zupacademy.thiago.transacao.listener.EventoCartao;
import br.com.zupacademy.thiago.transacao.listener.EventoEstabelecimento;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String idLegado;

    private BigDecimal valor;

    @Embedded
    private Estabelecimento estabelecimento;

    @ManyToOne
    private Cartao cartao;

    private LocalDateTime efetivadaEm;

    public Transacao(){
    }

    public Transacao(String idLegado, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
        this.idLegado = idLegado;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public Long getId() {
        return id;
    }

    public String getIdLegado() {
        return idLegado;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
