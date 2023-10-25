package clases;

import java.util.ArrayList;

public class Departamento {
    private Integer id;
    private String nombre;
    private String localidad;
    private ArrayList<Empleado> empleadosDep;

    public Departamento() {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public ArrayList<Empleado> getEmpleadosDep() {
        return empleadosDep;
    }

    public void setEmpleadosDep(ArrayList<Empleado> empleadosDep) {
        this.empleadosDep = empleadosDep;
    }
}
