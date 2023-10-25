package database;

import clases.Empleado;
import libs.Leer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsNuevoEmpleado {
    public static void insertarEmpleado(){
        Empleado nuevoEmpleado = new Empleado();
        String nombreDep;
        Integer idDepRec=0;
        nuevoEmpleado.setNumEmp(Leer.pedirEntero("Inserte el número del nuevo empleado:"));
        nuevoEmpleado.setApellido(Leer.pedirCadena("Inserte el apellido del nuevo empleado:"));
        nombreDep = Leer.pedirCadena("Inserte el nombre del departamento al que pertenece: ").toUpperCase();
        try(Connection miCon = ConexionBD.conectar("miBD")){
            //montamos la sentencia SQL de comprobación de que el departamento existe
            //nos devuelve el id del departamento si existe.
            PreparedStatement pstmt = miCon.prepareStatement("SELECT dept_no FROM departamentos  WHERE dnombre = ?");
            pstmt.setString(1,nombreDep);
            //ejecutamos la sentencia y almacenamos el resultado
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                idDepRec = rs.getInt("dept_no");
            }
            if (idDepRec == 0){
                System.out.println("El departamento indicado no existe y el empleado no se insertará.");
            }else {
                nuevoEmpleado.setIdDep(idDepRec);
                PreparedStatement insEmp = miCon.prepareStatement("INSERT INTO empleados (emp_no,apellido,dept_no)  VALUES(?, ? ,?)");
                insEmp.setInt(1,nuevoEmpleado.getNumEmp());
                insEmp.setString(2, nuevoEmpleado.getApellido());
                insEmp.setInt(3,nuevoEmpleado.getIdDep());
                insEmp.execute();
            }
            System.out.println(nuevoEmpleado.getIdDep());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
