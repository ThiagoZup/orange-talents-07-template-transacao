package br.com.zupacademy.thiago.transacao.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String idLegado;

    @NotBlank
    @Email
    private String email;

    @OneToMany(mappedBy = "cartao", cascade = CascadeType.MERGE)
    private List<Transacao> transacoes = new ArrayList<>();

    public Cartao(){
    }

    public Cartao(String idLegado, String email) {
        this.idLegado = idLegado;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getIdLegado() {
        return idLegado;
    }

    public String getEmail() {
        return email;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cartao cartao = (Cartao) o;
        return idLegado.equals(cartao.idLegado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLegado);
    }
}