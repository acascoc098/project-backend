package com.api.projectbackend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String nombre;
    
    @Column(length = 20, nullable = false)
    private String username;

    @Column(length = 75, nullable = false)
    private String password;

    @Column(unique = true, length = 70, nullable = false)
    private String correo;

    @Column(length = 9, nullable = false)
    private String telefono;
  
}
