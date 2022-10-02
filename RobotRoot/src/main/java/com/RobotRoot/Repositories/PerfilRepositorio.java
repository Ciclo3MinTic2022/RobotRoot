package com.RobotRoot.Repositories;

import com.RobotRoot.Entities.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepositorio extends JpaRepository<Perfil, String> {

}
