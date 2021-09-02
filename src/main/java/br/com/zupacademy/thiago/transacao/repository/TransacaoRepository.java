package br.com.zupacademy.thiago.transacao.repository;

import br.com.zupacademy.thiago.transacao.model.Cartao;
import br.com.zupacademy.thiago.transacao.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    List<Transacao> findFirst10ByCartaoOrderByEfetivadaEmDesc(Cartao cartao);
}
