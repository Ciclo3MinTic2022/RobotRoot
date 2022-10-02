package com.RobotRoot.Controllers;

import com.RobotRoot.Entities.Empresa;
import com.RobotRoot.Entities.MovimientoDinero;
import com.RobotRoot.Services.ServiceMovimientoDinero;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ControlMovimientoDinero {

    private ServiceMovimientoDinero ServiMovDin;

    public ControlMovimientoDinero(ServiceMovimientoDinero serviMovDin) {
        this.ServiMovDin =  serviMovDin;
    }
    @GetMapping("/enterprises/{id}/movements/{index}")
    public MovimientoDinero ConsultarMD(@PathVariable("id") Long id, @PathVariable("index") Integer index){
        return this.ServiMovDin.BuscarP(id,index);
    }

    @PostMapping("/enterprises/{id}/movements")
    public String crearMD(@RequestBody MovimientoDinero x, @PathVariable("id") Long id){
        return  this.ServiMovDin.crearMD(x, id);
    }

    @PatchMapping("/enterprises/movements/{id}")
    public MovimientoDinero actualizarMovimientos(@PathVariable("id")int id, @RequestBody Map<Object,Object> p){
        return  this.ServiMovDin.actualizarMovimientos(id,p);
    }

    @DeleteMapping("/enterprises/{id}/movements/{index}")
    public  String eliminarMovimiento(@PathVariable("id") Long id, @PathVariable("index") Integer index){
        return this.ServiMovDin.eliminarMovimiento(index, id);
    }
}
