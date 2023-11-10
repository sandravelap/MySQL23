package database;

import clases.Empleado;
import libs.Leer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LeerEmpleado {
    public static void empleadosDepartamento(){
        Empleado empAux = new Empleado();
        ArrayList<Empleado> listaEmpsDep= new ArrayList<Empleado>();
        String nombreDep;
        Integer idDepRec=0;
        nombreDep = Leer.pedirCadena("Inserte el nombre del departamento: ").toUpperCase();
        try(Connection miCon = ConexionBD.conectar("miBD")){
            //montamos la sentencia SQL de comprobación de que el departamento existe
            //nos devuelve el id del departamento si existe.
            PreparedStatement pstmt = miCon.prepareStatement("SELECT dept_no FROM departamentos  WHERE dnombre = ?");
            pstmt.setString(1,nombreDep);
            //ejecutamos la sentencia y almacenamos el resultado en un resultset
            ResultSet rs = pstmt.executeQuery();
            //rs.next nos devolverá nulo cuando no haya resultados, para recorrerlo mientras haya resultados usamos el while
            while (rs.next()){
                idDepRec = rs.getInt("dept_no");
            }
            //si el departamento no existe, el valor de idDepRec no se habrá actualizado porque no habrá ningún resultado y no entra en el while
            if (idDepRec == 0){
                System.out.println("El departamento indicado no existe y no hay empleados que listar.");
            }else {
                //si el valor se ha actualizado el departamento existe y podemos utilizar su id para la consulta de empleados:
                PreparedStatement leerEmp = miCon.prepareStatement("SELECT * FROM empleados WHERE dept_no = ?");
                leerEmp.setInt(1, idDepRec);
                ResultSet rsEmps = leerEmp.executeQuery();
                //volvemos a recorrer los resultados del ResultSet con while y almacenamos los datos en un arraylist
                while (rsEmps.next()){
                    empAux = new Empleado();
                    empAux.setNumEmp(rsEmps.getInt("emp_no"));
                    empAux.setApellido(rsEmps.getString("apellido"));
                    empAux.setIdDep(rsEmps.getInt("dept_no"));
                    empAux.setAntig(rsEmps.getDate("fecha_alt"));
                    empAux.setSueldo(rsEmps.getDouble("salario"));
                    listaEmpsDep.add(empAux);
                }
                //printeamos para comprobar que se ha ejecutado correctamente.
                System.out.println("Los empleados del departamento " + nombreDep + " son:");
                for (Empleado e : listaEmpsDep){
                    System.out.println(e.getApellido());
                }
            }
            System.out.println(empAux.getIdDep());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
