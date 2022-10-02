package com.RobotRoot.Controllers;


import com.RobotRoot.Entities.Perfil;
import com.RobotRoot.Services.PerfilServicios;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class PerfilControlador {
    private PerfilServicios servicio;

    public PerfilControlador(PerfilServicios servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/MostrarPerfiles")
    public ArrayList<Perfil> verPerfiles(){
        return this.servicio.verPefiles();
    }

    @GetMapping("/BuscarPerfil/{nombre}")
    public Optional<Perfil> buscarPerfil(@PathVariable("nombre") String nombre){
        return this.servicio.buscarPerfil(nombre);
    }

    @PostMapping("/CrearPerfil")
    public String crearPefil(@RequestBody Perfil perfil){
        return this.servicio.crearPerfil(perfil);
    }

    @PutMapping("/ActualizarPerfil")
    public String actualizarPerfil(@RequestBody Perfil perfil){
        return this.servicio.actualizarPerfil(perfil);
    }

    @DeleteMapping("/EliminarPerfil/{id}")
    public String eliminarPerfil(@PathVariable("id") String id){
        return this.servicio.eliminarPerfil(id);
    }


}
