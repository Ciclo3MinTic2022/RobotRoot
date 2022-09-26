package com.RobotRoot.Controllers;

import com.RobotRoot.Entities.Empresa;
import com.RobotRoot.Entities.MovimientoDinero;
import com.RobotRoot.Services.ServiceMovimientoDinero;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ControlMovimientoDinero {
/*
    ServiceMovimientoDinero ServiMovDin = new ServiceMovimientoDinero();

    public ControlMovimientoDinero(ServiceMovimientoDinero serviMovDin) {
        this.ServiMovDin =  new ServiceMovimientoDinero();
    }

    @GetMapping("/movimiento")
    public MovimientoDinero ConstrolarMovimientoDinero(){
        return this.ServiMovDin.getMovimiento1();
    }
 */
ServiceMovimientoDinero ServiMovDin;

    public ControlMovimientoDinero(ServiceMovimientoDinero serviMovDin) {
        this.ServiMovDin =  serviMovDin;
    }
    @GetMapping("/movimiento")
    public List<MovimientoDinero> ConstrolarMovimientoDinero(){
        return this.ServiMovDin.getRepositorioMovDine();
    }

    @PostMapping("/movimiento")
    public MovimientoDinero crearMovimiento(@RequestBody MovimientoDinero mov){return this.ServiMovDin.CrearRegistro(mov);}

    @PutMapping("/movimiento/{id}")
    public MovimientoDinero actualizarMovimiento(@PathVariable Long id, @RequestBody MovimientoDinero actMovimiento){
        return this.ServiMovDin.actualMovimiento(id,actMovimiento);
    }

    @DeleteMapping("/movimiento/{id}")
    public MovimientoDinero eliminarMovimiento(@PathVariable(value = "id") Long id){
        return this.ServiMovDin.eliminMovimiento(id);
    }
}
