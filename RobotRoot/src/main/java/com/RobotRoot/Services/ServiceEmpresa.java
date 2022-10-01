package com.RobotRoot.Services;

import com.RobotRoot.Entities.Empresa;
import com.RobotRoot.Repositories.RepositorioEmpresa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ServiceEmpresa {
/*
    Empresa ep1;
    ServiceEmpleado se1 = new ServiceEmpleado();
    public ServiceEmpresa (){
        Empleado emple1 = this.se1.getEmpleado();
        this.ep1=new Empresa("Cocalola", "Cr50#20-25", 3012251, "1235478-NIT", emple1);
    }

    public Empresa getEmpresa(){
        return this.ep1;
    }
*/
    private RepositorioEmpresa repositorio;
    public ServiceEmpresa(RepositorioEmpresa repositorio){
        this.repositorio = repositorio;
    }
    public List<Empresa> getRepositorio(){
        return this.repositorio.findAll();
    }

    public Empresa CrearRegistro(Empresa empresa1){
        return this.repositorio.save(empresa1);
    }

    public Empresa actualEmpresa (Long id, Empresa EmprActualiza){
        Empresa empresaActual = repositorio.findById(id).orElseThrow();
        empresaActual.setNombre(EmprActualiza.getNombre());
        empresaActual.setDireccion(EmprActualiza.getDireccion());
        empresaActual.setTelefono(EmprActualiza.getTelefono());
        empresaActual.setNit(EmprActualiza.getNit());
        return this.repositorio.save(empresaActual);
    }

    public Empresa eliminEmpresa(long id){
        Empresa empresaActual = repositorio.findById(id).orElseThrow();
        this.repositorio.deleteById(id);
        return empresaActual;

    }

}
