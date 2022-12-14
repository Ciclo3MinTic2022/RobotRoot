package com.RobotRoot.Services;

import com.RobotRoot.Entities.Usuarios;
import com.RobotRoot.Repositories.UserRepositorio;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServicio {
    private UserRepositorio repositorio;

    public UserServicio(UserRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Usuarios crearUsuario(Usuarios nuevoUsuario){
        return this.repositorio.save(nuevoUsuario);
    }

    public Usuarios buscarPorEmail(String email){
        return this.repositorio.findByEmail(email);
    }

    public Usuarios mapeoUsuario(Map<String, Object> userData){
        String email = (String) userData.get("email");
        String name = (String) userData.get("nickname");
        String image = (String) userData.get("picture");
        String auth0Id = (String) userData.get("sub");

        Usuarios user = buscarPorEmail(email);
        if(user == null){
            return crearUsuario(new Usuarios( email, image, auth0Id, name));
        }

        return user;
    }


}
