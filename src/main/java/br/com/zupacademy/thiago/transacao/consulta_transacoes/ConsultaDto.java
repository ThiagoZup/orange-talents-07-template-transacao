package br.com.zupacademy.thiago.transacao.consulta_transacoes;

import br.com.zupacademy.thiago.transacao.model.Transacao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConsultaDto {

    private List<TransacaoDto> transacoes = new ArrayList<>();

    public ConsultaDto(List<Transacao> transacoes) {
        List<TransacaoDto> dtos = transacoes.stream().map(TransacaoDto :: new).collect(Collectors.toList());
        this.transacoes.addAll(dtos);
    }

    public List<TransacaoDto> getTransacoes() {
        return transacoes;
    }
}
