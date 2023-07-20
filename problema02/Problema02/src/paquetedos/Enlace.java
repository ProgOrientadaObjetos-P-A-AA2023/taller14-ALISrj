/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetedos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import paqueteuno.Estudiante;
/**
 *
 * @author reroes
 */
public class Enlace {
    private Connection conn;
    private ArrayList<Estudiante> lista;  
    
    public void establecerConexion() {  

        try {  
            // db parameters  
            String url = "jdbc:sqlite:db/base001.base";  
            // create a connection to the database  
            conn = DriverManager.getConnection(url);  
            // System.out.println(conn.isClosed());
            // System.out.println("Connection to SQLite has been established.");  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }   
        
    } 
    
    public Connection obtenerConexion(){
        return conn;
    }
    
    public void insertarEstudiante(Estudiante e) {  
  
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO estudiante (nombre,"
                    + "apellido,calificaion1,calificaion2,calificaion3) "
                    + "values ('%s', '%s', %.2f,%.2f, %.2f)", 
                    e.obtenerNombre(), 
                    e.obtenerApellido(),
                    e.obtenerCalificacion1(),
                    e.obtenerCalificacion2(),
                    e.obtenerCalificacion3());
            System.out.println(data);
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException ex) {  
             System.out.println("Exception:");
             System.out.println(ex.getMessage());  
             
        }  
    }
    
    public void establecerListaDataEstudiante() {  
        lista = new ArrayList<>();
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from estudiante";
            
            ResultSet rs = statement.executeQuery(data);
            while(rs.next()){
                Estudiante t = new Estudiante();
                t.establecerNombre(rs.getString("nombre"));
                t.establecerApellido(rs.getString("apellido"));
                t.establecerCalificacion1(rs.getDouble("calificacion1"));
                t.establecerCalificacion2(rs.getDouble("calificacion2"));
                t.establecerCalificacion3(rs.getDouble("calificacion3"));
                t.establecerPromedio();
                lista.add(t);
            }
            
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception: insertarEstudiante");
             System.out.println(e.getMessage());  
             
        }  
    }
    
    public ArrayList<Estudiante> obtenerLista(){
        return lista;
    }
     
}
    

