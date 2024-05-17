package com.barteca.projectbackend.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barteca.projectbackend.models.Bar;

@Repository
public interface BarRepo extends JpaRepository<Bar, Long>{
    
}
