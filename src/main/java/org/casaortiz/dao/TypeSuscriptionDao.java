/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;
import org.casaortiz.dao.interfaces.ICrud;
import org.casaortiz.db.ConnectionDBOracle;
import org.casaortiz.model.TypeSuscription;

/**
 * CRUD a TypeSuscription
 * @author Ing. Jorge Luis Ortiz Cáceres
 * @since 31/08/2021
 * @version 0.0.1
 */
public class TypeSuscriptionDao implements ICrud<TypeSuscription>{
    ConnectionDBOracle connectionDBOracle;
    
    public TypeSuscriptionDao(){
        connectionDBOracle = new ConnectionDBOracle();
    }

    /**
     * Call procedure TypeSuscription_API.INS(p_name, p_description):
     * Inserta un registro a TypeSuscription
     * @param item TypeSuscription
     * @throws SQLException
     * @throws Exception 
     */
    public void insert(TypeSuscription item) throws SQLException, Exception{
        Connection conn = null;
        CallableStatement cstmt = null;
        conn = connectionDBOracle.getConnection();
        try {
            
            cstmt = conn.prepareCall("{call Type_Suscription_API.INS(?,?,?,?)}");
            cstmt.setString(1, item.getName());
            cstmt.setInt(2, item.getNum_days());
            cstmt.setDouble(3, item.getPrice());
            cstmt.setString(4, item.getDescription());
            cstmt.execute();
        } catch (Exception e ) {
            cstmt.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al insertar TypeSuscription: \n" + e.getMessage());
        }finally{
            cstmt.close();
            connectionDBOracle.closeConnection(conn);
        }
    }
    
    /**
     * Call procedure TypeSuscription_API.UPD(p_id, p_name, p_description)
     * Actualiza un registro de la TypeSuscription
     * @param item TypeSuscription
     * @throws SQLException
     * @throws Exception 
     */
    public void update(TypeSuscription item) throws SQLException, Exception{
        Connection conn = null;
        CallableStatement cstmt = null;
        
        try {
            conn = connectionDBOracle.getConnection();
            cstmt = conn.prepareCall("{call Type_Suscription_API.UPD(?,?,?,?,?)}");
            cstmt.setInt(1, item.getId());
            cstmt.setString(2, item.getName());
            cstmt.setInt(3, item.getNum_days());
            cstmt.setDouble(4, item.getPrice());
            cstmt.setString(5, item.getDescription());
            cstmt.execute();
        } catch (Exception e) {
            cstmt.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al actualizar: \n" + e.getMessage());
        }finally{
            cstmt.close();
            connectionDBOracle.closeConnection(conn);
        }
    }
    
    /**
     * Call procedure Type_Suscription_api.DEL(p_id)
     * Elimina un registro de la TypeSuscription
     * @param id - Id de la TypeSuscription
     * @throws SQLException
     * @throws Exception 
     */
    public void delete(int id) throws SQLException, Exception{
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = connectionDBOracle.getConnection();
            cstmt = conn.prepareCall("{call Type_Suscription_API.DEL(?)}");
            cstmt.setInt(1, id);
            cstmt.execute();
        } catch (Exception e) {
            connectionDBOracle.closeConnection(conn);
            cstmt.close();
            throw new Exception(e.getMessage());
        }finally{
            connectionDBOracle.closeConnection(conn);
            cstmt.close();
        }
    }
    
    /**
     * Call procedure Type_Suscription_API.getTypeSuscription(p_id, Type_Suscription_c)
     * Obtengo un registro a partir del id
     * @param id - Id TypeSuscription
     * @return TypeSuscription
     * @throws SQLException
     * @throws Exception 
     */
    public TypeSuscription get(int id) throws SQLException, Exception{
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        TypeSuscription typeSuscription = null;
        try {
            conn = connectionDBOracle.getConnection();
            cs = conn.prepareCall("{call Type_Suscription_API.getTypeSuscription(?,?)}");
            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            while(rs.next()){
                typeSuscription = new TypeSuscription();
                typeSuscription.setId(rs.getInt("id"));
                typeSuscription.setName(rs.getString("name"));
                typeSuscription.setNum_days(rs.getInt("num_days"));
                typeSuscription.setPrice(rs.getDouble("price"));
                typeSuscription.setDescription(rs.getString("description"));
            }
            
            return typeSuscription;
        } catch (Exception e) {
            System.out.println("Error al obtener la TypeSuscription: " + e.getMessage());
            rs.close();
            cs.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al obtener la TypeSuscription: \n" +e.getMessage());
        }finally{
            rs.close();
            cs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }
    
    /**
     * call procedure Type_Suscription_API.LIST(Type_Suscription_c)
     * Recupero una lista de TypeSuscription
     * @return List<TypeSuscription>
     * @throws SQLException
     * @throws Exception 
     */
    public List<TypeSuscription> getList() throws SQLException, Exception{
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        List<TypeSuscription> typeSuscriptions;
        TypeSuscription typeSuscription;
        try {
            typeSuscriptions = new ArrayList<TypeSuscription>();
            conn = connectionDBOracle.getConnection();
            cs = conn.prepareCall("{call Type_Suscription_API.LIST(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            while(rs.next()){
                typeSuscription = new TypeSuscription();
                typeSuscription.setId(rs.getInt("id"));
                typeSuscription.setName(rs.getString("name"));
                typeSuscription.setNum_days(rs.getInt("num_days"));
                typeSuscription.setPrice(rs.getDouble("price"));
                typeSuscription.setDescription(rs.getString("description"));
                typeSuscriptions.add(typeSuscription);
            }
            rs.close();
            return typeSuscriptions;
        } catch (Exception e) {
            System.out.println("Error al obtener TypeSuscription: " + e.getMessage());
            rs.close();
            cs.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al obtener TypeSuscription: \n" + e.getMessage());
        }finally{
            rs.close();
            cs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }
    
    /**
     * call procedure Type_Suscription_API.SEARCH(texto)
     * Para realizar busquedas en los registros TypeSuscription
     * @param texto - Lo que va a buscar
     * @return List<TypeSuscription>
     * @throws Exception 
     */
    public List<TypeSuscription> searchList(String texto) throws Exception{
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        List<TypeSuscription> typeSuscriptions;
        TypeSuscription typeSuscription;
        try {
            typeSuscriptions = new ArrayList<TypeSuscription>();
            conn = connectionDBOracle.getConnection();
            cs = conn.prepareCall("{call Type_Suscription_API.SEARCH(?,?)}");
            cs.setString(1, texto);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            while(rs.next()){
                typeSuscription = new TypeSuscription();
                typeSuscription.setId(rs.getInt("id"));
                typeSuscription.setName(rs.getString("name"));
                typeSuscription.setNum_days(rs.getInt("num_days"));
                typeSuscription.setPrice(rs.getDouble("price"));
                typeSuscription.setDescription(rs.getString("description"));
                typeSuscriptions.add(typeSuscription);
            }
            return typeSuscriptions;
        } catch (Exception e) {
            System.out.println("Error al obtener TypeSuscription: " + e.getMessage());
            rs.close();
            cs.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al buscar TypeSuscription: \n" + e.getMessage());
        }finally{
            rs.close();
            cs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }
}
