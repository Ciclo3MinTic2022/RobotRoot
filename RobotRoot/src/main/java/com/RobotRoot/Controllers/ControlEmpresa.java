package com.RobotRoot.Controllers;

import com.RobotRoot.Entities.Empresa;
import com.RobotRoot.Services.ServiceEmpresa;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControlEmpresa {
/*
    ServiceEmpresa serviEmpresa;
    ServiceEmpresa se1 = new ServiceEmpresa();
    Empresa emp1;
    public ControlEmpresa(){
        this.emp1 = this.se1.getEmpresa();
    }
    @GetMapping("/informacion")
    public Empresa informacion(){
        return this.emp1;
    }
 */
    ServiceEmpresa se1;

    public ControlEmpresa(ServiceEmpresa se1){
        this.se1 = se1;
    }
    @GetMapping("/enterprise")
    public List<Empresa> informacion(){
        return this.se1.getRepositorio();
    }

    @PostMapping("/enterprise")
    public Empresa crearEmpresa(@RequestBody Empresa emp){return this.se1.CrearRegistro(emp);}

    @PutMapping("/Enterprise/{id}")
    public Empresa actualizarEmpresa(@PathVariable Long id, @RequestBody Empresa actEmpresa){
        return this.se1.actualEmpresa(id,actEmpresa);
    }

    @DeleteMapping("/enterprise/{id}")
    public Empresa eliminarEmpresa(@PathVariable(value = "id") Long id){
        return this.se1.eliminEmpresa(id);
    }

}
