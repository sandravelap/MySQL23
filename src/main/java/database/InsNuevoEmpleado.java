package database;

import clases.Empleado;
import libs.Leer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsNuevoEmpleado {
    static void insertarEmpleado(){
        Empleado nuevoEmpleado = new Empleado();
        String nombreDep;
        nuevoEmpleado.setNumEmp(Leer.pedirEntero("Inserte el número del nuevo empleado:"));
        nuevoEmpleado.setApellido(Leer.pedirCadena("Inserte el apellido del nuevo empleado:"));
        nombreDep = Leer.pedirCadena("Inserte el nombre del departamento al que pertenece: ");
        try(Connection miCon = ConexionBD.conectar("miBD")){
            PreparedStatement pstmt = miCon.prepareStatement("SELECT ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
