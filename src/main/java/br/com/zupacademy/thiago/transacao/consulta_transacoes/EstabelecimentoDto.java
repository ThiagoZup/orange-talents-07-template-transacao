package br.com.zupacademy.thiago.transacao.consulta_transacoes;

import br.com.zupacademy.thiago.transacao.model.Estabelecimento;

public class EstabelecimentoDto {

    private String nome;
    private String cidade;

    public EstabelecimentoDto(Estabelecimento estabelecimento) {
        this.nome = estabelecimento.getNome();
        this.cidade = estabelecimento.getCidade();
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }
}
