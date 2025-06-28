package com.example.recursos.com.example.recursos.repository;

import com.example.recursos.com.example.recursos.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RepositoryReserva extends JpaRepository<Reserva, Long> {

}
