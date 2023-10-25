package database;

import clases.Departamento;

import java.sql.*;

public class insNuevoDep {
    public static void insertarDep(){
        //datos a insertar
        Departamento newDep = new Departamento();
        newDep.setId(50);
        newDep.setNombre("IT");
        newDep.setLocalidad("Sabi");
        try(Connection miCon = ConexionBD.conectar("miBD")){
            PreparedStatement pstmt = miCon.prepareStatement("INSERT INTO departamentos VALUES (?,?,?)");
            pstmt.setInt(1, newDep.getId());
            pstmt.setString(2, newDep.getNombre());
            pstmt.setString(3, newDep.getLocalidad());
            pstmt.execute();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("No se cumple una condición de integridad de la base de datos");;
        } catch (SQLSyntaxErrorException e){
            System.out.println("Hay un error de sintaxis" + e.getMessage());
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
