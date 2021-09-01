package br.com.zupacademy.thiago.transacao.listener;

import br.com.zupacademy.thiago.transacao.model.Cartao;

public class EventoCartao {

    private String id;
    private String email;

    public EventoCartao(){
    }

    public EventoCartao(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Cartao toModel(){
        return new Cartao(this.id, this.email);
    }
}
