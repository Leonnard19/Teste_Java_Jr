package com.example.cartorios.domain.dto;

import com.example.cartorios.domain.Cartorio;
import com.example.cartorios.domain.Certidao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartorioDTO {

    private Long codigo;
    private String nome;
    private String endereco;
    private List<Certidao> certidoes = new ArrayList<Certidao>();

    public CartorioDTO(Cartorio cartorio) {
        this.codigo = cartorio.getCodigo();
        this.nome = cartorio.getNome();
        this.endereco = cartorio.getEndereco();
        this.certidoes = cartorio.getCertidoes();
    }

    public static List<CartorioDTO> convert(List<Cartorio> cartorios) {
        return cartorios.stream()
                .map(CartorioDTO::new)
                .collect(Collectors.toList());    //para cada elemento do map ele vai
        // gerar um construtor e retornar essa instancia
    }

    //getters and setters
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

    public List<Certidao> getCertidoes() {
        return certidoes;
    }

    public void setCertidoes(List<Certidao> certidoes) {
        this.certidoes = certidoes;
    }
}
