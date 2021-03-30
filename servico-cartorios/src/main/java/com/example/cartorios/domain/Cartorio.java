package com.example.cartorios.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@SequenceGenerator(name = "cartorioSequence", sequenceName = "SQ_CARTORIO", allocationSize = 1)
@JsonIgnoreProperties(ignoreUnknown = true) //ignora o erro ao serializar o objeto nulo
public class Cartorio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cartorioSequence")
    private Long codigo;
    private String nome;
    private String endereco;

    @OneToMany(mappedBy = "cartorio", cascade = CascadeType.ALL )
    private List<Certidao> certidoes = new ArrayList<Certidao>(); // inicializar lista

    public Cartorio() {
    }

    public Cartorio(String nome, String endereco, List<Certidao> certidoes) {
        this.nome = nome;
        this.endereco = endereco;
        this.certidoes = certidoes;
    }

    // Getters and Setters
    public List<Certidao> getCertidoes() {
        return certidoes;
    }

    public void setCertidoes(List<Certidao> certidoes) {
        this.certidoes = certidoes;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}

