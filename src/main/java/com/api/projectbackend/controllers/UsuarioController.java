package com.api.projectbackend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.projectbackend.models.Usuario;
import com.api.projectbackend.repos.UsuarioRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/barteca")
public class UsuarioController {
    @Autowired
    UsuarioRepo repositorioUsuario;

    @GetMapping("usuario")
    List<Usuario> findAll(){
        return repositorioUsuario.findAll();
    }

    @GetMapping("usuario/{id}")
    Usuario findById(@PathVariable (value = "id") Long id){
        return repositorioUsuario.findById(id).get();
    }
    @GetMapping("usuario/correo/{correo}")
    Usuario findByEmail(@PathVariable (value = "correo") String correo){
        return repositorioUsuario.findByCorreo(correo);
    }
    
    @PostMapping("usuario")
    Usuario create(@RequestBody Usuario usuarioBody){
      return repositorioUsuario.save(usuarioBody);
    }
    
    @DeleteMapping("usuario/{id}")
    void delete(@PathVariable (value = "id")Long id){
        repositorioUsuario.deleteById(id);
    }

    @PutMapping("usuario/{id}")
    Usuario update(@PathVariable(value= "id")Long id , @RequestBody Usuario nUsuario){

        Usuario usuarioModificado = findById(id);

        if(usuarioModificado != null){
            usuarioModificado.setCorreo(nUsuario.getCorreo());
            usuarioModificado.setNombre(nUsuario.getNombre());
            usuarioModificado.setPassword(nUsuario.getPassword());
            usuarioModificado.setTelefono(nUsuario.getTelefono());
            return repositorioUsuario.save(usuarioModificado);
        }
        return usuarioModificado;
    }
    
}
