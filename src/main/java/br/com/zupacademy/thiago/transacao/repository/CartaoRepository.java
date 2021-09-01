package br.com.zupacademy.thiago.transacao.repository;

import br.com.zupacademy.thiago.transacao.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {

    Optional<Cartao> findByIdLegado(String idLegado);
}
