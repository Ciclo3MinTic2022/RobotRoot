package com.RobotRoot.Repositories;

import com.RobotRoot.Entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositorio extends JpaRepository<Usuarios, Long> {

    Usuarios findByEmail(String email);
}
