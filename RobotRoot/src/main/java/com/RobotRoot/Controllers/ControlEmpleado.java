package com.RobotRoot.Controllers;

import com.RobotRoot.Entities.Empleado;
import com.RobotRoot.Entities.Empresa;
import com.RobotRoot.Services.ServiceEmpleado;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
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
    @GetMapping("/empleados")
    public List<Empleado> ControlarEmpleados(){
        return this.sem1.getRepositorioEmp();
    }
    @PostMapping("/empleados")
    public Empleado crearEmpleado(@RequestBody Empleado empl){return this.sem1.CrearRegistro(empl);}

    @PutMapping("/empleados/{id}")
    public Empleado actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado actEmpleado){
        return this.sem1.empleadoActual(id,actEmpleado);
    }

    @DeleteMapping("/empleados/{id}")
    public Empleado eliminarEmpleado(@PathVariable(value = "id") Long id){
        return this.sem1.eliminEmpleado(id);
    }
}
