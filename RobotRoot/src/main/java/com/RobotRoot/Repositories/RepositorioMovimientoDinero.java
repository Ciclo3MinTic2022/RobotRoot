package com.RobotRoot.Repositories;

import com.RobotRoot.Entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioMovimientoDinero extends JpaRepository<MovimientoDinero, Long> {

}
