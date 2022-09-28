package com.RobotRoot.Services;

import com.RobotRoot.Entities.Empresa;
import com.RobotRoot.Entities.MovimientoDinero;
import com.RobotRoot.Repositories.RepositorioMovimientoDinero;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceMovimientoDinero {
/*
    MovimientoDinero movimiento1;

    public ServiceMovimientoDinero() {
        this.movimiento1 = new MovimientoDinero(214,"Pago");
    }
    public MovimientoDinero getMovimiento1(){
        return this.movimiento1;
    }
 */
    private RepositorioMovimientoDinero repositorioMovDine;
    public ServiceMovimientoDinero(RepositorioMovimientoDinero repositorioMovDine){
        this.repositorioMovDine = repositorioMovDine;
    }

    public List<MovimientoDinero> getRepositorioMovDine(){
        return this.repositorioMovDine.findAll();
    }

    public MovimientoDinero CrearRegistro(MovimientoDinero movimiento1){
        return this.repositorioMovDine.save(movimiento1);
    }

    public MovimientoDinero actualMovimiento (Long id, MovimientoDinero MovActualiza){
        MovimientoDinero movimientoActual = repositorioMovDine.findById(id).orElseThrow();
        movimientoActual.setConceptoMovimiento(MovActualiza.getConceptoMovimiento());
        movimientoActual.setMontoMovimiento(MovActualiza.getMontoMovimiento());
        return this.repositorioMovDine.save(movimientoActual);
    }

    public MovimientoDinero eliminMovimiento(Long id){
        MovimientoDinero movimientoActual = repositorioMovDine.findById(id).orElseThrow();
        this.repositorioMovDine.deleteById(id);
        return movimientoActual;

    }
}
