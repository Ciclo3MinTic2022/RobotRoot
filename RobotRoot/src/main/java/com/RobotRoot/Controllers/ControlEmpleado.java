package com.RobotRoot.Controllers;

import com.RobotRoot.Entities.Empleado;
import com.RobotRoot.Entities.Empresa;
import com.RobotRoot.Services.ServiceEmpleado;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ControlEmpleado {

    private ServiceEmpleado sem1;

    public ControlEmpleado(ServiceEmpleado sem1){
        this.sem1 = sem1;
    }
    @GetMapping("/userss")
    public List<Empleado> listarEmpleados(){
        return this.sem1.listarEmpleados();
    }

    @GetMapping("/user/{id}")
    public Optional<Empleado> buscarEmpleado(@PathVariable("id") Long id){
        return this.sem1.buscarEmpleado(id);
    }

    @PostMapping("/users")
    public String crearEmpleado(@RequestBody Empleado empleado){
        return this.sem1.crearEmpleado(empleado);
    }

    @PatchMapping("/user/{id}")
    public Empleado actualizarCampo(@PathVariable("id") Long id, @RequestBody Map<Object, Object> mapeoEmpleado){
        return this.sem1.actualizarCampo(id, mapeoEmpleado);
    }

    @DeleteMapping("/user/{id}")
    public String eliminarEmpleado(@PathVariable("id") Long id){
        return this.sem1.eliminarEmpleado(id);
    }
}

//    @GetMapping("/empleado")
//    private String informacion(Model model){
//        model.addAttribute("empleado", sem1.getRepositorioEmp());
//        return "empleado";
//    }
//
//    @GetMapping("/agregar-empleado")
//    private String verFormDeRegistroEmpl(Empleado empleado){
//        return "agregar-empleado";
//    }
//
//    @PostMapping("/empleado")
//    private String crearEmpleado(Empleado empl){
//        sem1.CrearRegistro(empl);
//        return "redirect:/empleado";
//    }
//
////    @GetMapping("/empleados/editar/{id}")
////    private String actualEmpleado(@PathVariable("id") Long id, Model model){
////        Empleado empleado = sem1.empleadoActual(id);
////        model.addAttribute("empresa", empleado);
////        return "actualizar-registro-empresa";
////    }
//
//    @PostMapping("/empleado/actualizar/{id}")
//    private String actualizarEmpleado(@PathVariable("id") Long id, Empleado actEmpleado){
//        sem1.empleadoActual(id,actEmpleado);
//        return "redirect:/empleado";
//    }
//
//    @GetMapping("empleado/borrar/{id}")
//    private String eliminarEmpleado(@PathVariable("id") Long id){
//        sem1.eliminEmpleado(id);
//        return "redirect:/empleado";
//    }
//
////    @GetMapping("/empleados")
////    public String ControlarEmpleados(){
////        return this.sem1.getRepositorioEmp();
////    }
////    @PostMapping("/empleados")
////    public Empleado crearEmpleado(@RequestBody Empleado empl){return this.sem1.CrearRegistro(empl);}
////
////    @PutMapping("/empleados/{id}")
////    public Empleado actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado actEmpleado){
////        return this.sem1.empleadoActual(id,actEmpleado);
////    }
////
////    @DeleteMapping("/empleados/{id}")
////    public Empleado eliminarEmpleado(@PathVariable(value = "id") Long id){
////        return this.sem1.eliminEmpleado(id);
////    }
//}
