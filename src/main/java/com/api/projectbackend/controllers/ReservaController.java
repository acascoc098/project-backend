package com.api.projectbackend.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.api.projectbackend.models.Reserva;
import com.api.projectbackend.repos.ReservaRepo;
import com.api.projectbackend.repos.UsuarioRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/barteca")
public class ReservaController {
    @Autowired
    ReservaRepo repositorioReserva;
    @Autowired
    UsuarioRepo repositorioUsuario;

    @GetMapping("reserva")
    List<Reserva> findAll() {
        return repositorioReserva.findAll();
    }

    @GetMapping("reserva/{id}")
    Reserva findById(@PathVariable(value = "id") Long id) {
        return repositorioReserva.findById(id).get();
    }

    

    @PostMapping("reserva")
    Reserva create(@RequestBody Reserva reservaBody) {

        return repositorioReserva.save(reservaBody);
    }

    @DeleteMapping("reserva/{id}")
    void delete(@PathVariable(value = "id") Long id) {
        repositorioReserva.deleteById(id);     
    }

    @PutMapping("reserva/{id}")
    Reserva update(@PathVariable(value = "id") Long id, @RequestBody Reserva nReserva) {

        Reserva reservaModificada = findById(id);
        if (reservaModificada != null) {
            reservaModificada.setComensales(nReserva.getComensales());
            reservaModificada.setFecha(nReserva.getFecha());
            reservaModificada.setHora(nReserva.getHora());
            reservaModificada.setUsuario(nReserva.getUsuario());
            reservaModificada.setBar(nReserva.getBar());
            
            return repositorioReserva.save(reservaModificada);
        } else
            return reservaModificada;
    }
}