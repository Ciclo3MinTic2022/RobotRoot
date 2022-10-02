package com.RobotRoot.Controllers;

import com.RobotRoot.Entities.Empresa;
import com.RobotRoot.Services.ServiceEmpresa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@RestController
public class ControlEmpresa {

    private ServiceEmpresa se1;

    public ControlEmpresa(ServiceEmpresa se1){
        this.se1 = se1;
    }

    @GetMapping("/enterprisess")
    public ArrayList<Empresa> listarEmpresas(){
        return this.se1.listarEmpresas();
    }

    @GetMapping("/enterprises/{id}")
    public Optional<Empresa> buscarEmpresa(@PathVariable("id") Long id){
        return this.se1.buscarEmpresa(id);
    }

    @PostMapping("enterprises")
    public String crearEmpresa(@RequestBody Empresa empresa){
        return this.se1.crearEmpresa(empresa);
    }

    @PatchMapping("/enterprises/{id}")
    public Empresa actualizarCampo(@PathVariable("id") Long id, @RequestBody Map<Object,Object> mapeoEmp){
        return this.se1.actualizarCampo(id, mapeoEmp);
    }

    @DeleteMapping("enterprises/{id}")
    public String eliminarEmpresa(@PathVariable Long id){
        return this.se1.eliminarEmpresa(id);
    }


//    @GetMapping("/enterprise")
//    private String informacion(Model model){
//        model.addAttribute("empresas", se1.getRepositorio());
//        return "empresa";
//    }
//    @GetMapping("/agregar-empresa")
//        private String verFormDeRegistroEmp(Empresa empresa){
//            return "agregar-empresa";
//        }
//
//    @PostMapping("/enterprise")
//    private String crearEmpresa(Empresa emp){
//        se1.CrearRegistro(emp);
//        return "redirect:/enterprise";
//    }
//
////    @GetMapping("/enterprise/editar/{id}")
////    private String actualEmpresa(@PathVariable("id") Long id, Model model){
////        Empresa empresa = se1.actualEmpresa(id);
////        model.addAttribute("empresa", empresa);
////        return "actualizar-registro-empresa";
////    }
//
//    @PostMapping("/enterprise/actualizar/{id}")
//    private String actualizarEmpresa(@PathVariable("id") Long id, Empresa actEmpresa){
//        se1.actualEmpresa(id,actEmpresa);
//        return "redirect:/enterprise";
//    }
//
//    @GetMapping("enterprise/borrar/{id}")
//    private String eliminarEmpresa(@PathVariable("id") Long id){
//        se1.eliminEmpresa(id);
//        return "redirect:/enterprise";
//    }

}
