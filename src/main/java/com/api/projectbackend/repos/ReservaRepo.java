package com.api.projectbackend.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.projectbackend.models.Reserva;

@Repository
public interface ReservaRepo extends JpaRepository<Reserva , Long>{
    
}
