package br.com.zupacademy.thiago.transacao.listener;

import br.com.zupacademy.thiago.transacao.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class TransacaoListener {

    @Autowired
    private CartaoRepository cartaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    @Transactional
    public void ouvir(EventoTransacao eventoTransacao) {
        System.out.println(eventoTransacao);
        eventoTransacao.persist(cartaoRepository);
    }
}