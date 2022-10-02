package com.RobotRoot.Repositories;

import com.RobotRoot.Entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface RepositorioMovimientoDinero extends JpaRepository<MovimientoDinero, Integer> {

}
