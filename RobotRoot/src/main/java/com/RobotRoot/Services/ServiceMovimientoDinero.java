package com.RobotRoot.Services;

import com.RobotRoot.Entities.Empresa;
import com.RobotRoot.Entities.MovimientoDinero;
import com.RobotRoot.Repositories.RepositorioMovimientoDinero;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class ServiceMovimientoDinero {

    private ServiceEmpresa serviceEmpresa;

    private RepositorioMovimientoDinero repositorioMovimientoDinero ;
    public ServiceMovimientoDinero(RepositorioMovimientoDinero repositorioMovimientoDinero, ServiceEmpresa serviceEmpresa) {
        this.repositorioMovimientoDinero = repositorioMovimientoDinero;
        this.serviceEmpresa = serviceEmpresa;
    }

    /*public Set<MovimientoDinero> ListaMovimiento(Long id){
        Empresa emp = this.empresaServicios.buscarEmpresa(id).get();
        return emp.getMovimientoDineros();
    }*/

    public List<MovimientoDinero> ListaMovimientos(Long id){
        Empresa emp = this.serviceEmpresa.buscarEmpresa(id).get();
        return (List<MovimientoDinero>) emp.getMovimientoDineros();
    }

    public Float totalAcum(Long id){
        Empresa empresa = this.serviceEmpresa.buscarEmpresa(id).get();
        float acum = 0;
        for(MovimientoDinero mov: empresa.getMovimientoDineros()){
            acum += mov.getMonto();
        }

        return acum;
    }


    public MovimientoDinero BuscarP(Long id, int index) {
        Empresa emp = this.serviceEmpresa.buscarEmpresa(id).get();
        MovimientoDinero mov = null;
        for (MovimientoDinero p : emp.getMovimientoDineros()) {
            if (p.getId() == index) {
                mov = new MovimientoDinero(p.getId(), p.getConcepto(), p.getMonto(), p.getEmpleado(), emp);
                break;
            }
        }

        return mov;
    }

    public String crearMD(MovimientoDinero movimiento, Long id) {
        Empresa emp = this.serviceEmpresa.buscarEmpresa(id).get();

        movimiento.setEmpresa(emp);

        this.repositorioMovimientoDinero.save(movimiento);

        return "Se creó el movimiento";
    }

    public String eliminarMovimiento(int index, Long id) {
        Empresa emp = this.serviceEmpresa.buscarEmpresa(id).get();
        MovimientoDinero mov = null;
        for(MovimientoDinero p: emp.getMovimientoDineros()){
            if (p.getId() == index){
                mov = new MovimientoDinero(p.getId(), p.getConcepto(), p.getMonto(), p.getEmpleado(), emp);

            }
        }

        if (mov != null){
            emp.getMovimientoDineros().remove(mov);
            this.repositorioMovimientoDinero.deleteById(index);
            return"Se elimina el movimiento exitosamente";

        }
        else{
            return"No se elimino el movimiento";
        }

    }


    public MovimientoDinero actualizarMovimientos(int index, Map<Object,Object> p) {
        MovimientoDinero mov = repositorioMovimientoDinero.findById(index).get();
        p.forEach((key,value)->{
            Field campo= ReflectionUtils.findField(MovimientoDinero.class,(String)key);
            campo.setAccessible(true);
            ReflectionUtils.setField(campo,mov,value);
        });
        return repositorioMovimientoDinero.save(mov);


    }

    public MovimientoDinero actualizarMov(int id, MovimientoDinero mov){
        MovimientoDinero movimientoDinero = BuscarP((long)1,id);

        movimientoDinero.setConcepto(mov.getConcepto());
        movimientoDinero.setMonto(mov.getMonto());
        movimientoDinero.setEmpleado(mov.getEmpleado());

        return repositorioMovimientoDinero.save(movimientoDinero);
    }
}

