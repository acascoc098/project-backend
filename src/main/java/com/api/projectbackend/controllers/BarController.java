package com.api.projectbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.api.projectbackend.repos.BarRepo;
import com.api.projectbackend.models.Bar;

@RestController
@RequestMapping("/barteca")
public class BarController {
    @Autowired
    BarRepo repositorioBar;

    @GetMapping("bar")
    List<Bar> findAll(){
        return repositorioBar.findAll();
    }
    
    @GetMapping("bar/{id}")
    Bar findById(@PathVariable(value = "id") Long id){
        return repositorioBar.findById(id).get();
    }

    @PostMapping("bar")
    Bar create(@RequestBody Bar barBody) {
        return repositorioBar.save(barBody);
    }

    @DeleteMapping("bar/{id}")
    void delete(@PathVariable(value = "id") Long id) {
        repositorioBar.deleteById(id);
    }

    @PutMapping("bar/{id}")
    Bar update(@PathVariable(value = "id") Long id, @RequestBody Bar nBar) {
        Bar barModify = findById(id);

        if (barModify != null) {
            barModify.setNombre(nBar.getNombre());
            barModify.setProvincia(nBar.getProvincia());
            barModify.setCalificacion(nBar.getCalificacion());
            barModify.setCiudad(nBar.getCiudad());
            barModify.setDireccion(nBar.getDireccion());
            barModify.setTelefono(nBar.getTelefono());
            barModify.setCorreo(nBar.getCorreo());

            return repositorioBar.save(barModify);
        } else {
            return barModify;
        }
    }
}
