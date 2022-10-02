package com.RobotRoot.Services;

import com.RobotRoot.Entities.Empleado;
import com.RobotRoot.Entities.Empresa;
import com.RobotRoot.Repositories.RepositorioEmpleado;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ServiceEmpleado {

    private RepositorioEmpleado repositorioemp;
    public ServiceEmpleado(RepositorioEmpleado repositorioemp){
        this.repositorioemp = repositorioemp;
    }
    public List<Empleado> listarEmpleados(){
        return  this.repositorioemp.findAll();
    }

    public Optional<Empleado> buscarEmpleado(long id){
        return this.repositorioemp.findById(id);
    }

    public Empleado buscarEmpleado1(long id){
        return this.repositorioemp.findById(id).get();
    }

    public String crearEmpleado(Empleado empleado){
        if (empleado.getId() == null || !this.repositorioemp.existsById(empleado.getId())){
            this.repositorioemp.save(empleado);
            return "Se crea el empleado exitosamente";
        }else{
            return "Ya existe un empleado con ese Id";
        }
    }


    public Empleado actualizarCampo(long id, Map<Object, Object> empleadoMapeo){
        Empleado empleado = this.repositorioemp.findById(id).get();

        empleadoMapeo.forEach((key,value)->{
            Field campo = ReflectionUtils.findField(Empleado.class, (String) key);
            campo.setAccessible(true);
            ReflectionUtils.setField(campo, empleado, value);
        });
        return this.repositorioemp.save(empleado);
    }

    public String eliminarEmpleado(long id){
        if (this.repositorioemp.existsById(id)){
            this.repositorioemp.deleteById(id);
            return "Se eliminó exitosamente el empleado";
        }else{
            return "No existe un empleado con tal Id para ser eliminado";
        }
    }


    public Empleado actualizarEmpl(long id, Empleado empleado){
        Empleado emp = buscarEmpleado1(id);

        emp.getPerfil().setTelefono(empleado.getPerfil().getTelefono());
        emp.setEmail(empleado.getEmail());
        emp.setRol(empleado.getRol());

        return repositorioemp.save(emp);
    }
}
