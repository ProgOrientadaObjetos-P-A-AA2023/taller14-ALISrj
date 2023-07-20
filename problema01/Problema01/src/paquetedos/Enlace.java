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
import paqueteuno.Trabajador;
/**
 *
 * @author reroes
 */
public class Enlace {
    private Connection conn;
    private ArrayList<Trabajador> lista;  
    
    public void establecerConexion() {  

        try {  
            // db parameters  
            String url = "jdbc:sqlite:db/base01.db";  
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
    
    public void insertarTrabajador(Trabajador t) {  
  
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO trabajador (cedula,"
                    + "nombres,correo,sueldo,mesSueldo) "
                    + "values ('%s', '%s', '%s',%d, '%s')", 
                    t.obtenerCedula(), 
                    t.obtenerNombres(),
                    t.obtenerCorreo(),
                    t.obtenerSueldo(),
                    t.obtenerMesSueldo());
            System.out.println(data);
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception:");
             System.out.println(e.getMessage());  
             
        }  
    }
    
    public void establecerListaDataTrabajador() {  
        lista = new ArrayList<>();
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from trabajador;";
            
            ResultSet rs = statement.executeQuery(data);
            while(rs.next()){
                Trabajador t = new Trabajador();
                t.establecerCedula(rs.getString("cedula"));
                t.establecerNombres(rs.getString("nombres"));
                t.establecerCorreo(rs.getString("correo"));
                t.establecerSueldo(rs.getInt("sueldo"));
                t.establecerMesSueldo(rs.getString("mesSueldo"));
                lista.add(t);
            }
            
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception: insertarTrabajador");
             System.out.println(e.getMessage());  
             
        }  
    }
    
    public ArrayList<Trabajador> obtenerLista(){
        return lista;
    }
     
}
    

