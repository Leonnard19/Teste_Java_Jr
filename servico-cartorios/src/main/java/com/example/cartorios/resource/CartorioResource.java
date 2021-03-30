package com.example.cartorios.resource;

import com.example.cartorios.domain.Cartorio;
import com.example.cartorios.domain.Certidao;
import com.example.cartorios.domain.dto.CartorioDTO;
import com.example.cartorios.repository.CartorioRepository;

import com.example.cartorios.repository.CertidoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cartorios")
public class CartorioResource {

    // cria automaticamente todos os metodos para utilização referente ao tarefaRepository
    @Autowired
    CartorioRepository cartorioRepository;

    @Autowired
    CertidoesRepository certidoesRepository;

    // list all
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Cartorio> getCartorios() {

        List<Cartorio> cartorios = cartorioRepository.findAll();

        return cartorios;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Transactional
    public List<Cartorio> create(@RequestBody @Valid Cartorio cartorio) {

        cartorioRepository.save(cartorio);

        List<Cartorio> cartorios = cartorioRepository.findAll();

        return cartorios;
    }

    @GetMapping("{id}")
    public ResponseEntity<CartorioDTO> getCartorioById(@PathVariable(value = "id") Long codigo) { // parse da variavel id para Long codigo

        Optional<Cartorio> cartorio = cartorioRepository.findById(codigo);

        return cartorio.map(t -> ResponseEntity.ok(new CartorioDTO(t)))
                .orElse(ResponseEntity.notFound().build());

    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<CartorioDTO> update(@PathVariable Long id,
                                              @RequestBody @Valid Cartorio cartorioUpdated) {

        Optional<Cartorio> cartorio = cartorioRepository.findById(id);

        return cartorio.map(t -> {
            t.setNome(cartorioUpdated.getNome());
            t.setEndereco(cartorioUpdated.getEndereco());
            cartorioRepository.save(t);
            return ResponseEntity.ok(new CartorioDTO(t));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<?> remove(@PathVariable Long id) {  // ? retorna o tipo que o metodo escolher melhor
        Optional<Cartorio> cartorio = cartorioRepository.findById(id);
        return cartorio.map(t -> {
            cartorioRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

}
