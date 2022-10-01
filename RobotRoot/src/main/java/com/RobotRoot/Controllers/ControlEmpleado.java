package com.RobotRoot.Controllers;

import com.RobotRoot.Entities.Empleado;
import com.RobotRoot.Entities.Empresa;
import com.RobotRoot.Services.ServiceEmpleado;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class ControlEmpleado {
/*
    ServiceEmpleado trabajadores;

    public ControlEmpleado() {
        this.trabajadores = new ServiceEmpleado();
    }

    @GetMapping("/Empleados")
    public Empleado ControlarEmpleados(){
        return this.trabajadores.getEmpleado();
    }
*/
    ServiceEmpleado sem1;

    public ControlEmpleado(ServiceEmpleado sem1){
        this.sem1 = sem1;
    }

    @GetMapping("/empleado")
    private String informacion(Model model){
        model.addAttribute("empleado", sem1.getRepositorioEmp());
        return "empleado";
    }

    @GetMapping("/agregar-empleado")
    private String verFormDeRegistroEmpl(Empleado empleado){
        return "agregar-empleado";
    }

    @PostMapping("/empleado")
    private String crearEmpleado(Empleado empl){
        sem1.CrearRegistro(empl);
        return "redirect:/empleado";
    }

//    @GetMapping("/empleados/editar/{id}")
//    private String actualEmpleado(@PathVariable("id") Long id, Model model){
//        Empleado empleado = sem1.empleadoActual(id);
//        model.addAttribute("empresa", empleado);
//        return "actualizar-registro-empresa";
//    }

    @PostMapping("/empleado/actualizar/{id}")
    private String actualizarEmpleado(@PathVariable("id") Long id, Empleado actEmpleado){
        sem1.empleadoActual(id,actEmpleado);
        return "redirect:/empleado";
    }

    @GetMapping("empleado/borrar/{id}")
    private String eliminarEmpleado(@PathVariable("id") Long id){
        sem1.eliminEmpleado(id);
        return "redirect:/empleado";
    }

//    @GetMapping("/empleados")
//    public String ControlarEmpleados(){
//        return this.sem1.getRepositorioEmp();
//    }
//    @PostMapping("/empleados")
//    public Empleado crearEmpleado(@RequestBody Empleado empl){return this.sem1.CrearRegistro(empl);}
//
//    @PutMapping("/empleados/{id}")
//    public Empleado actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado actEmpleado){
//        return this.sem1.empleadoActual(id,actEmpleado);
//    }
//
//    @DeleteMapping("/empleados/{id}")
//    public Empleado eliminarEmpleado(@PathVariable(value = "id") Long id){
//        return this.sem1.eliminEmpleado(id);
//    }
}
