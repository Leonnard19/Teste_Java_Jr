package com.example.cartorios.repository;

import com.example.cartorios.domain.Cartorio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartorioRepository extends JpaRepository<Cartorio, Long> {
    //List<Cartorio> findByContainingId(Long codigo);

}

