package com.RobotRoot.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String nombre, nit, telefono, direccion;

    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Empleado> empleados;

    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<MovimientoDinero> movimientoDineros;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @PrePersist
    public void fechaActual(){
        this.fecha = new Date();
    }


    //Constructores
    public Empresa(long id, String nombre, String nit, String telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Empresa(){
    }

    //Getters y setters
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Set<Empleado>  getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set<Empleado>  empleados) {
        this.empleados = empleados;
    }

    public List<MovimientoDinero> getMovimientoDineros() {
        return movimientoDineros;
    }

    public void setMovimientoDineros(List<MovimientoDinero> movimientoDineros) {
        this.movimientoDineros =  movimientoDineros;
    }
}
