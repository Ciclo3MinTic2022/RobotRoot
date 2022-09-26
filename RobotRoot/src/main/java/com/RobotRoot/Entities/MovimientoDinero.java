package com.RobotRoot.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Movimientodinero")
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "montoMovimiento")
    private double montoMovimiento;
    @Column(name = "conceptoMovimiento")
    private String conceptoMovimiento;

    public MovimientoDinero(){
    }
    public MovimientoDinero(double montoMovimiento, String conceptoMovimiento) {
        this.montoMovimiento = montoMovimiento;
        this.conceptoMovimiento = conceptoMovimiento;
    }

    public double getMontoMovimiento() {
        return montoMovimiento;
    }

    public void setMontoMovimiento(double montoMovimiento) {
        this.montoMovimiento = montoMovimiento;
    }

    public String getConceptoMovimiento() {
        return conceptoMovimiento;
    }

    public void setConceptoMovimiento(String conceptoMovimiento) {
        this.conceptoMovimiento = conceptoMovimiento;
    }

    public double crearMonto(){
        return -1;
    }
    public String usuarioEncargadoRegistrarMovimiento(){
        return "-1";
    }

    @Override
    public String toString() {
        return "MovimientoDinero{" +
                "id=" + id +
                ", montoMovimiento=" + montoMovimiento +
                ", conceptoMovimiento='" + this.conceptoMovimiento + '\'' +
                '}';
    }
}
