package com.RobotRoot.Entities;

import javax.persistence.*;

@Entity
@Table(name="empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "correo")
    private String correo;
    @Column(name = "empresaEmpleadoPertenece")
    private String empresaEmpleadoPertenece;
    @Column(name = "rolEmpleado")
    private String rolEmpleado;

    @Transient
    private MovimientoDinero movimiento1;

    public Empleado(){

    }

    public Empleado(String nombre, String correo, String empresaEmpleadoPertenece, String rolEmpleado, MovimientoDinero movimiento1) {
        this.nombre = nombre;
        this.correo = correo;
        this.empresaEmpleadoPertenece = empresaEmpleadoPertenece;
        this.rolEmpleado = rolEmpleado;
        this.movimiento1 = movimiento1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEmpresaEmpleadoPertenece() {
        return empresaEmpleadoPertenece;
    }

    public void setEmpresaEmpleadoPertenece(String empresaEmpleadoPertenece) {
        this.empresaEmpleadoPertenece = empresaEmpleadoPertenece;
    }

    public String getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(String rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

    public MovimientoDinero getMovimiento1() {
        return movimiento1;
    }

    public void setMovimiento1(MovimientoDinero movimiento1) {
        this.movimiento1 = movimiento1;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", empresaEmpleadoPertenece='" + empresaEmpleadoPertenece + '\'' +
                ", rolEmpleado='" + rolEmpleado + '\'' +
                ", movimiento1=" + this.movimiento1 +
                '}';
    }
}
