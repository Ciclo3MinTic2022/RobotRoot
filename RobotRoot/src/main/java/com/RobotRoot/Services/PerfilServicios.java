package com.RobotRoot.Services;

import com.RobotRoot.Entities.Perfil;
import com.RobotRoot.Repositories.PerfilRepositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PerfilServicios {

    private PerfilRepositorio repositorio;

    public PerfilServicios(PerfilRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public ArrayList<Perfil> verPefiles(){
        return (ArrayList<Perfil>)this.repositorio.findAll();
    }

    public Optional<Perfil> buscarPerfil(String id){
        return this.repositorio.findById(id);
    }

    public String crearPerfil(Perfil perfil){
        if(buscarPerfil(perfil.getId()).isEmpty()){
            this.repositorio.save(perfil);
            return "Se creó el perfil.";
        }else{
            return "No se creó el perfil, ya existe.";
        }
    }

    public String actualizarPerfil(Perfil perfil){
        if(buscarPerfil(perfil.getId()).isPresent()){
            this.repositorio.save(perfil);
            return "Se actualizó el perfil.";
        }else{
            return "No se actualizó el perfil, no existe.";
        }
    }

    public String eliminarPerfil(String id){
        if(buscarPerfil(id).isPresent()){
            this.repositorio.deleteById(id);;
            return "Se eliminó el perfil.";
        }else{
            return "No se eliminó el perfil, no existe.";
        }
    }


}
