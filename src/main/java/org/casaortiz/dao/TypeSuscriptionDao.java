/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.casaortiz.dao.interfaces.ICrud;
import org.casaortiz.db.ConnectionDBPostgres;
import org.casaortiz.model.TypeSuscription;

/**
 * CRUD a TypeSuscription
 * @author Ing. Jorge Luis Ortiz Cáceres
 * @since 31/08/2021
 * @version 0.0.1
 */
public class TypeSuscriptionDao implements ICrud<TypeSuscription>{
    ConnectionDBPostgres connectionDBOracle;
    
    public TypeSuscriptionDao(){
        connectionDBOracle = new ConnectionDBPostgres();
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
        conn = connectionDBOracle.getConnection();
        try {
            
            PreparedStatement st = conn.prepareStatement("insert into Type_Suscription (name, num_days, price, description) values (?, ?, ?, ?)");
            st.setString(1, item.getName());
            st.setInt(2, item.getNum_days());
            st.setDouble(3, item.getPrice());
            st.setString(4, item.getDescription());
            st.execute();
            st.close();
        } catch (Exception e ) {
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al insertar Type_Suscription: \n" + e.getMessage());
        }finally{
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
        conn = connectionDBOracle.getConnection();
        try {
            
            PreparedStatement st = conn.prepareStatement("update Type_Suscription set name = ?, num_days = ?, price = ?, description = ? where id = ?");
            st.setString(1, item.getName());
            st.setInt(2, item.getNum_days());
            st.setDouble(3, item.getPrice());
            st.setString(4, item.getDescription());
            st.setInt(5, item.getId());
            st.execute();
            st.close();
        } catch (Exception e ) {
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al insertar Type_Suscription: \n" + e.getMessage());
        }finally{
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
        try {
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("delete from Type_Suscription where id = "+id);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            connectionDBOracle.closeConnection(conn);
            throw new Exception(e.getMessage());
        }finally{
            connectionDBOracle.closeConnection(conn);
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
        ResultSet rs = null;
        TypeSuscription item = null;
        try {
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from Type_Suscription c where c.id ="+id);
            rs = st.executeQuery();
            if(rs.next()){
                item = new TypeSuscription();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setNum_days(rs.getInt("num_days"));
                item.setPrice(rs.getDouble("price"));
                item.setDescription(rs.getString("description"));
            }
            rs.close();
            return item;
        } catch (Exception e) {
            System.out.println("Error al obtener la TypeSuscription: " + e.getMessage());
            connectionDBOracle.closeConnection(conn);
            rs.close();
            throw new Exception("Error al obtener la TypeSuscription: \n" +e.getMessage());
        }finally{
            rs.close();
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
        ResultSet rs = null;
        List<TypeSuscription> items;
        TypeSuscription item;
        try {
            items = new ArrayList<TypeSuscription>();
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from Type_Suscription");
            rs = st.executeQuery();
            while(rs.next()){
                item = new TypeSuscription();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setNum_days(rs.getInt("num_days"));
                item.setPrice(rs.getDouble("price"));
                item.setDescription(rs.getString("description"));
                items.add(item);
            }
            rs.close();
            return items;
        } catch (Exception e) {
            System.out.println("Error al obtener TypeSuscriptions: " + e.getMessage());
            rs.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al obtener TypeSuscriptions: \n" + e.getMessage());
        }finally{
            rs.close();
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
        ResultSet rs = null;
        List<TypeSuscription> items;
        TypeSuscription item;
        try {
            items = new ArrayList<TypeSuscription>();
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from Type_Suscription where upper(name ||' '||description) like upper('%"+texto+"%')");
            rs = st.executeQuery();
            while(rs.next()){
                item = new TypeSuscription();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setNum_days(rs.getInt("num_days"));
                item.setPrice(rs.getDouble("price"));
                item.setDescription(rs.getString("description"));
                items.add(item);
            }
            return items;
        } catch (Exception e) {
            System.out.println("Error al obtener TypeSuscriptions: " + e.getMessage());
            rs.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al buscar TypeSuscriptions: \n" + e.getMessage());
        }finally{
            rs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }
}
