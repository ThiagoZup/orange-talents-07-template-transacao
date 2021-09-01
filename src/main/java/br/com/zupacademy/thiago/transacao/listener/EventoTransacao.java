package br.com.zupacademy.thiago.transacao.listener;

import br.com.zupacademy.thiago.transacao.model.Cartao;
import br.com.zupacademy.thiago.transacao.model.Transacao;
import br.com.zupacademy.thiago.transacao.repository.CartaoRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class EventoTransacao {

    private String id;
    private BigDecimal valor;
    private EventoEstabelecimento estabelecimento;
    private EventoCartao cartao;
    private LocalDateTime efetivadaEm;

    public EventoTransacao(){
    }

    public EventoTransacao(String id, BigDecimal valor, EventoEstabelecimento estabelecimento, EventoCartao cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EventoEstabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public EventoCartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Transacao toModel(Cartao cartao){
        return new Transacao(this.id, this.valor, this.estabelecimento.toModel(), cartao, this.efetivadaEm);
    }

    public void persist(CartaoRepository cartaoRepository){

        Cartao cartao;
        Optional<Cartao> optional = cartaoRepository.findByIdLegado(this.cartao.getId());
        if(optional.isPresent()){
            cartao = optional.get();
        }else{
            cartao = this.cartao.toModel();
        }
        Transacao transacao = toModel(cartao);
        cartao.getTransacoes().add(transacao);
        cartaoRepository.save(cartao);
    }
}
