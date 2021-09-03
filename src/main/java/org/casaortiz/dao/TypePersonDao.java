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
import oracle.jdbc.OracleTypes;
import org.casaortiz.dao.interfaces.ICrud;
import org.casaortiz.db.ConnectionDBOracle;
import org.casaortiz.model.Category;
import org.casaortiz.model.TypePerson;

/**
 * CRUD a TypePerson
 * @author Ing. Jorge Luis Ortiz Cáceres
 * @since 31/08/2021
 * @version 0.0.1
 */
public class TypePersonDao implements ICrud<TypePerson>{
    ConnectionDBOracle connectionDBOracle;
    
    public TypePersonDao(){
        connectionDBOracle = new ConnectionDBOracle();
    }

    /**
     * Call procedure TYPE_PERSON_API.INS(p_name, p_description):
     * Inserta un registro a typeperson
     * @param item TypePerson
     * @throws SQLException
     * @throws Exception 
     */
    public void insert(TypePerson item) throws SQLException, Exception{
        Connection conn = null;
        conn = connectionDBOracle.getConnection();
        try {
            
            PreparedStatement st = conn.prepareStatement("insert into Type_Person (name, description) values (?,?)");
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
            st.execute();
            st.close();
        } catch (Exception e ) {
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al insertar TypePerson: \n" + e.getMessage());
        }finally{
            connectionDBOracle.closeConnection(conn);
        }
    }
    
    /**
     * Call procedure TYPE_PERSON_API.UPD(p_id, p_name, p_description)
     * Actualiza un registro de la TypePerson
     * @param item TypePerson
     * @throws SQLException
     * @throws Exception 
     */
    public void update(TypePerson item) throws SQLException, Exception{
        Connection conn = null;
        
        try {
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("update Type_Person set name = ?, description = ? where id = ?");
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
            st.setInt(3, item.getId());
            st.execute();
            st.close();
        } catch (Exception e) {
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al actualizar TypePerson: \n" + e.getMessage());
        }finally{
            
            connectionDBOracle.closeConnection(conn);
        }
    }
    
    /**
     * Call procedure TYPE_PERSON_API.DEL(p_id)
     * Elimina un registro de la TypePerson
     * @param id - Id de la TypePerson
     * @throws SQLException
     * @throws Exception 
     */
    public void delete(int id) throws SQLException, Exception{
        Connection conn = null;
        try {
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("delete from Type_Person where id = "+id);
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
     * Call procedure TYPE_PERSON_API.getTypePerson(p_id, Type_Person_c)
     * Obtengo un registro a partir del id
     * @param id - Id TypePerson
     * @return TypePerson
     * @throws SQLException
     * @throws Exception 
     */
    public TypePerson get(int id) throws SQLException, Exception{
        Connection conn = null;
        ResultSet rs = null;
        TypePerson item = null;
        try {
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from Type_Person c where c.id ="+id);
            rs = st.executeQuery();
            if(rs.next()){
                item = new TypePerson();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
            }
            rs.close();
            return item;
        } catch (Exception e) {
            System.out.println("Error al obtener la TypePerson: " + e.getMessage());
            connectionDBOracle.closeConnection(conn);
            rs.close();
            throw new Exception("Error al obtener la TypePerson: \n" +e.getMessage());
        }finally{
            rs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }
    
    /**
     * call procedure TYPE_PERSON_API.LIST(Type_Person_c)
     * Recupero una lista de TypePeople
     * @return List<TypePerson>
     * @throws SQLException
     * @throws Exception 
     */
    public List<TypePerson> getList() throws SQLException, Exception{
        Connection conn = null;
        ResultSet rs = null;
        List<TypePerson> items;
        TypePerson item;
        try {
            items = new ArrayList<TypePerson>();
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from Type_Person");
            rs = st.executeQuery();
            while(rs.next()){
                item = new TypePerson();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                items.add(item);
            }
            rs.close();
            return items;
        } catch (Exception e) {
            System.out.println("Error al obtener TypePerson: " + e.getMessage());
            rs.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al obtener TypePerson: \n" + e.getMessage());
        }finally{
            rs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }
    
    /**
     * call procedure TYPE_PERSON_API.SEARCH(texto)
     * Para realizar busquedas en los registros TypePerson
     * @param texto - Lo que va a buscar
     * @return List<TypePerson>
     * @throws Exception 
     */
    public List<TypePerson> searchList(String texto) throws Exception{
        Connection conn = null;
        ResultSet rs = null;
        List<TypePerson> items;
        TypePerson item;
        try {
            items = new ArrayList<TypePerson>();
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from Type_Person where upper(name ||' '||description) like upper('%"+texto+"%')");
            rs = st.executeQuery();
            while(rs.next()){
                item = new TypePerson();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                items.add(item);
            }
            return items;
        } catch (Exception e) {
            System.out.println("Error al obtener TypePerson: " + e.getMessage());
            rs.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al buscar TypePerson: \n" + e.getMessage());
        }finally{
            rs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }
}
