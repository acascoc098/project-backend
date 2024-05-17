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
public class Bar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String provincia;
    
    @Column
    private String ciudad;
    
    @Column(length = 30)
    private String direccion;

    @Column(length =  2)
    private Integer calificacion;

    @Column(length = 9, nullable = false)
    private String telefono;

    @Column(unique = true, length = 70, nullable = false)
    private String correo;


}
