/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Clase para manejar la conexiones a la base de datos Postgresql
 * @author Ing. Jorge Luis Ortiz Caceres
 * @since 30/08/2021
 * @version 1.0.0
 */
public class ConnectionDBPostgres {
    private String url = "jdbc:postgresql://localhost:5432/gimnasio";
    private String user = "jorge";
    private String pass = "jorge";
    private Connection connect;
    
    /**
     * Obtengo la conexion hacia la base de datos
     * @return Objeto Connection
     */
    public Connection getConnection(){
        try {
            connect = DriverManager.getConnection(url, user, pass);
            if (connect!=null) {
                System.out.println("Conectado");
            }
        }catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
        }
        
        return connect;
    }
    
    /**
     * Metodo para cerrar la conexion
     * @param connect Objeto Connection
     */
    public void closeConnection(Connection connect){
        try {
            connect.close();
            System.out.println("Conexion cerrada");
        } catch (SQLException ex) {
            //Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
