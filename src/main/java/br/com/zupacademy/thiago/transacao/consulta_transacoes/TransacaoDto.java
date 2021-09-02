package br.com.zupacademy.thiago.transacao.consulta_transacoes;

import br.com.zupacademy.thiago.transacao.model.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoDto {

    private BigDecimal valor;
    private EstabelecimentoDto estabelecimento;
    private LocalDateTime efetivadaEm;

    public TransacaoDto(Transacao transacao) {
        this.valor = transacao.getValor();
        this.estabelecimento = new EstabelecimentoDto(transacao.getEstabelecimento());
        this.efetivadaEm = transacao.getEfetivadaEm();
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoDto getEstabelecimento() {
        return estabelecimento;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
