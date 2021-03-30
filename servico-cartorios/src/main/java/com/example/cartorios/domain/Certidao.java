package com.example.cartorios.domain;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "certidaoSequence", sequenceName = "SQ_CERTIDAO", allocationSize = 1)
public class Certidao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "certidaoSequence")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Cartorio cartorio;
    private String descricao;

    public Certidao() {
    }

    public Certidao(String descricao) {
        this.descricao = descricao;
    }

    // getters and setters
    public Cartorio getCartorio() {
        return cartorio;
    }

    public void setCartorio(Cartorio cartorio) {
        this.cartorio = cartorio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
