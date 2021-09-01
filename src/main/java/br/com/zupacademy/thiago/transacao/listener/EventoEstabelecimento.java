package br.com.zupacademy.thiago.transacao.listener;

import br.com.zupacademy.thiago.transacao.model.Estabelecimento;

public class EventoEstabelecimento {

    private String nome;
    private String cidade;
    private String endereco;

    public EventoEstabelecimento(){
    }

    public EventoEstabelecimento(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public Estabelecimento toModel(){
        return new Estabelecimento(this.nome, this.cidade, this.endereco);
    }
}
