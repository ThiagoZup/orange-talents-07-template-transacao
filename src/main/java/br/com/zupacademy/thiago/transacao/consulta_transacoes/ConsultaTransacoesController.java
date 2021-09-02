package br.com.zupacademy.thiago.transacao.consulta_transacoes;

import br.com.zupacademy.thiago.transacao.exception.ObjectNotFoundException;
import br.com.zupacademy.thiago.transacao.model.Cartao;
import br.com.zupacademy.thiago.transacao.model.Transacao;
import br.com.zupacademy.thiago.transacao.repository.CartaoRepository;
import br.com.zupacademy.thiago.transacao.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cartoes")
public class ConsultaTransacoesController {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping("/{id}/transacoes")
    public ResponseEntity<ConsultaDto> consulta(@PathVariable("id") Long id){

        Optional<Cartao> optional = cartaoRepository.findById(id);
        if(optional.isEmpty()){
            throw new ObjectNotFoundException("Cartão não encontrado");
        }
        Cartao cartao = optional.get();
        List<Transacao> transacoes = transacaoRepository.findFirst10ByCartaoOrderByEfetivadaEmDesc(cartao);

        return ResponseEntity.ok().body(new ConsultaDto(transacoes));
    }
}
