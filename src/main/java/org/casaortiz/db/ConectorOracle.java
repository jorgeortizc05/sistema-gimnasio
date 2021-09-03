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
 *
 * @author jorge
 */
public class ConectorOracle {
    private String url = "jdbc:oracle:thin:@oracleexpress18c-centos7:1521:xe";
    private String user = "jorge";
    private String pass = "jorge";
    private Connection connect;
    /**
     * Obtengo la conexion hacia la base de datos
     * @return Objeto Connection
     */
    public Connection getConnection() throws SQLException{
        try {
            connect = DriverManager.getConnection(url, user, pass);
            if (connect!=null) {
                System.out.println("Conectado");
                return connect;
            }
        }catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
            throw new SQLException(ex.getMessage());
        }
        return null;
    }
    
    /**
     * Metodo para cerrar la conexion
     * @param connect Objeto Connection
     */
    public void closeConnection(Connection connect) throws SQLException{
        try {
            if(connect!=null){
                connect.close();
                System.out.println("Conexion cerrada");
            }else{
                System.out.println("Error al cerrar la conexion");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDBOracle.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex.getMessage());
        }
    } 
}
