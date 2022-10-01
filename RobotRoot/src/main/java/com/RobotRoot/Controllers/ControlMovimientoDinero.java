package com.RobotRoot.Controllers;

import com.RobotRoot.Entities.Empresa;
import com.RobotRoot.Entities.MovimientoDinero;
import com.RobotRoot.Services.ServiceMovimientoDinero;
import org.springframework.ui.Model;
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
    public String ConstrolarMovimientoDinero(Model model){
        model.addAttribute("movimientoDinero", ServiMovDin.getRepositorioMovDine());
        return "movimiento";

    }

    @GetMapping("/agregar-movimiento")
    private String verFormDeRegistroEmp(MovimientoDinero movimiento){
        return "agregar-movimiento";
    }

    @PostMapping("/movimiento")
    private String crearMovimiento(MovimientoDinero movimientoDinero){
        ServiMovDin.CrearRegistro(movimientoDinero);
        return "redirect:/movimiento";
    }

//    @GetMapping("/enterprise/editar/{id}")
//    private String actualEmpresa(@PathVariable("id") Long id, Model model){
//        Empresa empresa = se1.actualEmpresa(id);
//        model.addAttribute("empresa", empresa);
//        return "actualizar-registro-empresa";
//    }

    @PostMapping("/movimiento/actualizar/{id}")
    private String actualizarMovimiento(@PathVariable("id") Long id, MovimientoDinero actualMovimiento){
        ServiMovDin.actualMovimiento(id,actualMovimiento);
        return "redirect:/movimiento";
    }

    @GetMapping("movimiento/borrar/{id}")
    private String eliminarEmpresa(@PathVariable("id") Long id){
        ServiMovDin.eliminMovimiento(id);
        return "redirect:/movimiento";
    }

//
//    @PostMapping("/movimiento")
//    public MovimientoDinero crearMovimiento(@RequestBody MovimientoDinero mov){return this.ServiMovDin.CrearRegistro(mov);}
//
//    @PutMapping("/movimiento/{id}")
//    public MovimientoDinero actualizarMovimiento(@PathVariable Long id, @RequestBody MovimientoDinero actMovimiento){
//        return this.ServiMovDin.actualMovimiento(id,actMovimiento);
//    }
//
//    @DeleteMapping("/movimiento/{id}")
//    public MovimientoDinero eliminarMovimiento(@PathVariable(value = "id") Long id){
//        return this.ServiMovDin.eliminMovimiento(id);
//    }
}
