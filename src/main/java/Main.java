import database.EstructuraDB;
import org.w3c.dom.CDATASection;

import static libs.Leer.pedirCadena;

public class Main {
    public static void main(String[] args) {
        boolean salir = false;
        String opcion = "";
        do {
            System.out.println("0. Salir \n" +
                    "1. Crear Base de Datos \n" +
                    "2. Crear tablas y cargar datos de inicio \n"+
                    "3. Insertar nuevo departamento \n"+
                    "4. Insertar nuevo empleado \n"+
                    "5. Leer empleados de un departamento");

            opcion = pedirCadena("Introduce una opción");
            switch (opcion) {
                case "0" -> salir = true;
                case "1" -> EstructuraDB.crearDB();
                case "2" -> {
                    EstructuraDB.crearTablaDeps();
                    EstructuraDB.crearTablaEmps();}
                case "3" -> database.insNuevoDep.insertarDep();
                case "4" -> database.InsNuevoEmpleado.insertarEmpleado();
                case "5" -> database.LeerEmpleado.empleadosDepartamento();
                default -> System.out.println("Opción incorrecta");
            }
        } while (!salir);
    }
}
