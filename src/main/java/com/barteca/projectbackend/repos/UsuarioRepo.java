package com.barteca.projectbackend.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barteca.projectbackend.models.Usuario;

@Repository
public interface UsuarioRepo extends JpaRepository <Usuario , Long>{
    public Usuario findByCorreo(String correo);
}
