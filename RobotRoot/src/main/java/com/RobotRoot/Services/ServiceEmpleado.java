package com.RobotRoot.Services;

import com.RobotRoot.Entities.Empleado;
import com.RobotRoot.Entities.Empresa;
import com.RobotRoot.Repositories.RepositorioEmpleado;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class ServiceEmpleado {
/*

    Empleado emp1;
    ServiceMovimientoDinero smd1 = new ServiceMovimientoDinero();
    public ServiceEmpleado(){
        MovimientoDinero MovimientoRealizado = this.smd1.movimiento1;
        this.emp1= new Empleado("Adan", "adan12345@misena.edu.co","Cocacola","administrador", MovimientoRealizado);
    }

    public Empleado getEmpleado() {
        return this.emp1;
    }

 */
    private RepositorioEmpleado repositorioemp;
    public ServiceEmpleado(RepositorioEmpleado repositorioemp){
        this.repositorioemp = repositorioemp;
    }
    public List<Empleado> getRepositorioEmp(){
        return this.repositorioemp.findAll();
    }
    public Empleado CrearRegistro(Empleado empleado1){
        return this.repositorioemp.save(empleado1);
    }
    public Empleado empleadoActual (Long id, Empleado EmpleActualiza){
        Empleado empleadoActual = repositorioemp.findById(id).orElseThrow();
        empleadoActual.setNombre(EmpleActualiza.getNombre());
        empleadoActual.setRolEmpleado(EmpleActualiza.getRolEmpleado());
        empleadoActual.setEmpresaEmpleadoPertenece(EmpleActualiza.getEmpresaEmpleadoPertenece());
        empleadoActual.setCorreo(EmpleActualiza.getCorreo());
        empleadoActual.setMovimiento1(EmpleActualiza.getMovimiento1());
        return this.repositorioemp.save(empleadoActual);
    }
    public Empleado eliminEmpleado(Long id){
        Empleado empleadoActual = repositorioemp.findById(id).orElseThrow();
        this.repositorioemp.deleteById(id);
        return empleadoActual;
    }
}
