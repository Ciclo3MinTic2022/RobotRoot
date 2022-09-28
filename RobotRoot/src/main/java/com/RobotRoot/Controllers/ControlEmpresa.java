package com.RobotRoot.Controllers;

import com.RobotRoot.Entities.Empresa;
import com.RobotRoot.Services.ServiceEmpresa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@Controller
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
    private String informacion(Model model){
        model.addAttribute("empresas", se1.getRepositorio());
        return "empresa";
    }
    @GetMapping("/agregar-empresa")
        private String verFormDeRegistroEmp(Empresa empresa){
            return "agregar-empresa";
        }

    @PostMapping("/enterprise")
    private String crearEmpresa(Empresa emp){
        se1.CrearRegistro(emp);
        return "redirect:/enterprise";
    }

    @GetMapping("/enterprise/editar/{id}")
    private String actualEmpresa(@PathVariable("id") Long id, Model model){
        Empresa empresa = se1.actualEmpresa(id);
        model.addAttribute("empresa", empresa);
        return "actualizar-registro-empresa";
    }

    @PostMapping("/enterprise/actualizar/{id}")
    private String actualizarEmpresa(@PathVariable("id") Long id, Empresa actEmpresa){
        se1.actualEmpresa(id,actEmpresa);
        return "redirect:/enterprise";
    }

    @GetMapping("enterprise/borrar/{id}")
    private String eliminarEmpresa(@PathVariable("id") Long id){
        se1.eliminEmpresa(id);
        return "redirect:/enterprise";
    }

}
