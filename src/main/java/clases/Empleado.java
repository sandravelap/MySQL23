package clases;

import java.sql.Date;


public class Empleado {
    private String apellido;
    private Integer numEmp;
    private double sueldo;
    private Integer agnoNac;

    private Date antig;

    private Integer idDep;

    public Empleado() {
    }

    public Empleado(String nombre, double sueldo, Integer agnoNac, Date antig) {
        this.apellido = nombre;
        this.sueldo = sueldo;
        this.agnoNac = agnoNac;
        this.antig = antig;
    }

    public Integer getNumEmp() {
        return numEmp;
    }

    public void setNumEmp(Integer numEmp) {
        this.numEmp = numEmp;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Integer getAgnoNac() {
        return agnoNac;
    }

    public void setAgnoNac(Integer agnoNac) {
        this.agnoNac = agnoNac;
    }

    public Date getAntig() {
        return antig;
    }

    public void setAntig(Date antig) {
        this.antig = antig;
    }

    public Integer getIdDep() {
        return idDep;
    }

    public void setIdDep(Integer idDep) {
        this.idDep = idDep;
    }
}
