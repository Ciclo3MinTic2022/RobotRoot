package com.RobotRoot.Controllers;

import com.RobotRoot.Entities.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import com.RobotRoot.Services.ServiceEmpleado;
import com.RobotRoot.Services.ServiceEmpresa;
import com.RobotRoot.Services.ServiceMovimientoDinero;
import com.RobotRoot.Services.UserServicio;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class vistaControlador {
    private ServiceMovimientoDinero serviceMovimientoDinero;
    private ServiceEmpleado servicioEmpleado;
    private ServiceEmpresa servicioEmpresa;
    private UserServicio sercivioUsuario;


    public vistaControlador(ServiceMovimientoDinero serviceMovimientoDinero, ServiceEmpleado servicioEmpleado, ServiceEmpresa servicioEmpresa, UserServicio sercivioUsuario) {
        this.serviceMovimientoDinero = serviceMovimientoDinero;
        this.servicioEmpleado = servicioEmpleado;
        this.servicioEmpresa = servicioEmpresa;
        this.sercivioUsuario = sercivioUsuario;
    }

    @GetMapping("/")
    public String principal(Model model, @AuthenticationPrincipal OidcUser principal){
        if(principal != null){
            Usuarios usuario = this.sercivioUsuario.mapeoUsuario(principal.getClaims());
            model.addAttribute("usuario", usuario);
        }
        return "index";
    }



    @GetMapping("/home")
    public String home(){
        return "home";
    }

    // ---------------------------------------- M O V I M I E N T O S ----------------------------------------
    @GetMapping("/enterprises/movements")
    public String listaMovimientos(Model model, Model model2){
        long id = 1;
        List<MovimientoDinero> lista =  this.serviceMovimientoDinero.ListaMovimientos(id);
        model.addAttribute("lista",lista);
        Float total = this.serviceMovimientoDinero.totalAcum(id);
        model2.addAttribute("total",total);

        return "movimientos";
    }

    @GetMapping("/movements/new")
    public String mostrarVentana(Model model, Model model2){
        model.addAttribute("movimientodinero", new MovimientoDinero());
        List<Empleado> lista = this.servicioEmpleado.listarEmpleados();
        model2.addAttribute("lista", lista);

        return "numovimiento";
    }

    @GetMapping("/eliminarMov/{id}")
    public String eliminarMovimiento(@PathVariable("id") int id){
        this.serviceMovimientoDinero.eliminarMovimiento(id, (long)1);

        return "redirect:/enterprises/movements";
    }

    @GetMapping("/editarMov/{id}")
    public String transcribirMovimiento(@PathVariable("id") int id, Model model, Model model2){
        model.addAttribute("movimientodinero",this.serviceMovimientoDinero.BuscarP((long)1, id));
        List<Empleado> lista = this.servicioEmpleado.listarEmpleados();
        model2.addAttribute("lista", lista);

        return "/editMovimiento";
    }

    @PostMapping("/registerMov")
    public String nuevoMovimiento(@ModelAttribute("movimientodinero") MovimientoDinero mov, Model model){
        mov.setEmpresa(this.servicioEmpresa.buscarEmpresa1((long)1));
        this.serviceMovimientoDinero.crearMD(mov, (long)1);

        return "redirect:/enterprises/movements";
    }

    @PostMapping("/save/{id}")
    public String guardarEditado(@PathVariable("id") int id, @ModelAttribute("movimientodinero") MovimientoDinero mov, Model model){
        MovimientoDinero movimiento = this.serviceMovimientoDinero.BuscarP((long)1, id);
        movimiento.setMonto(mov.getMonto());
        movimiento.setConcepto(mov.getConcepto());
        movimiento.setEmpleado(mov.getEmpleado());
        this.serviceMovimientoDinero.actualizarMov(id, movimiento);

        return "redirect:/enterprises/movements";
    }

    // --------------------------------------------- U S U A R I O S ----------------------------------------
    @GetMapping("/users")
    public String listaUsuarios(Model model){
        List<Empleado> lista =  this.servicioEmpleado.listarEmpleados();
        model.addAttribute("lista",lista);

        return "usuarios";
    }

    @GetMapping("/users/new")
    public String mostrarVentanaUser(Model model, Model model2){
        model.addAttribute("perfil", new Perfil());
        model2.addAttribute("empleado", new Empleado());

        return "nuusuario";
    }

    @GetMapping("/eliminarUser/{id}")
    public String eliminarUser(@PathVariable("id") Long id){
        this.servicioEmpleado.eliminarEmpleado(id);

        return "redirect:/users";
    }

    @GetMapping("/editarUser/{id}")
    public String transcribirUsuario(@PathVariable("id") long id, Model model){
        model.addAttribute("empleado", this.servicioEmpleado.buscarEmpleado1(id));

        return "/editUsuario";
    }

    @PostMapping("/saveUser/{id}")
    public String guardarUser(@PathVariable("id") long id, @ModelAttribute("empleado") Empleado empleado, Model model){
        Empleado emp = this.servicioEmpleado.buscarEmpleado1(id);
        emp.getPerfil().setTelefono(empleado.getPerfil().getTelefono());
        emp.setEmail(empleado.getEmail());
        emp.setRol(empleado.getRol());
        this.servicioEmpleado.actualizarEmpl(id, emp);

        return "redirect:/users";
    }

    @PostMapping("/registerUser")
    public String nuevoUsuario(@ModelAttribute("empleado") Empleado empleado, Model model){
        long empre = 1;
        empleado.setEmpresa(this.servicioEmpresa.buscarEmpresa1(empre));
        this.servicioEmpleado.crearEmpleado(empleado);

        return "redirect:/users";
    }

    // --------------------------------------------- E M P R E S A S -----------------------------------------
    @GetMapping("/enterprises")
    public String listaEmpresas(Model model){
        List<Empresa> lista = this.servicioEmpresa.listarEmpresa1();
        model.addAttribute("lista", lista);

        return "/empresas";
    }

    @GetMapping("/enterprise/new")
    public String mostrarVentanaEmpre(Model model){
        model.addAttribute("empresa", new Empresa());

        return "/nuempresa";
    }

    @GetMapping("/editarEmp/{id}")
    public String transcribirEmp(@PathVariable("id") long id, Model model){
        model.addAttribute("empresa", this.servicioEmpresa.buscarEmpresa1(id));

        return "/editEmpresa";
    }

    @GetMapping("/eliminarEmp/{id}")
    public String eliminarEmp(@PathVariable("id") long id){
        this.servicioEmpresa.eliminarEmpresa(id);

        return "redirect:/enterprises";
    }

    @PostMapping("/saveEmp/{id}")
    public String actualizarEmp(@PathVariable("id") long id, @ModelAttribute("empresa") Empresa empresa, Model model){
        Empresa emp = this.servicioEmpresa.buscarEmpresa1(id);
        emp.setDireccion(empresa.getDireccion());
        emp.setNit(empresa.getNit());
        emp.setNombre(empresa.getNombre());
        emp.setTelefono(empresa.getTelefono());
        this.servicioEmpresa.actualizarEmp(id, emp);

        return "redirect:/enterprises";
    }

    @PostMapping("/registerEmpr")
    public String crearEmpresa(@ModelAttribute("empresa") Empresa emp, Model model){
        this.servicioEmpresa.crearEmpresa(emp);

        return "redirect:/enterprises";
    }


}
