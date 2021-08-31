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
import org.casaortiz.db.ConnectionDBOracle;
import org.casaortiz.model.TypePerson;

/**
 * CRUD a TypePerson
 * @author Ing. Jorge Luis Ortiz Cáceres
 * @since 31/08/2021
 * @version 0.0.1
 */
public class TypePersonDao {
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
        CallableStatement cstmt = null;
        conn = connectionDBOracle.getConnection();
        try {
            
            cstmt = conn.prepareCall("{call TYPE_PERSON_API.INS(?,?)}");
            cstmt.setString(1, item.getName());
            cstmt.setString(2, item.getDescription());
            cstmt.execute();
        } catch (Exception e ) {
            cstmt.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al insertar TypePerson: \n" + e.getMessage());
        }finally{
            cstmt.close();
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
        CallableStatement cstmt = null;
        
        try {
            conn = connectionDBOracle.getConnection();
            cstmt = conn.prepareCall("{call Type_Person_API.UPD(?,?,?)}");
            cstmt.setInt(1, item.getId());
            cstmt.setString(2, item.getName());
            cstmt.setString(3, item.getDescription());
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
     * Call procedure TYPE_PERSON_API.DEL(p_id)
     * Elimina un registro de la TypePerson
     * @param id - Id de la TypePerson
     * @throws SQLException
     * @throws Exception 
     */
    public void delete(int id) throws SQLException, Exception{
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = connectionDBOracle.getConnection();
            cstmt = conn.prepareCall("{call Type_Person_API.DEL(?)}");
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
     * Call procedure TYPE_PERSON_API.getTypePerson(p_id, Type_Person_c)
     * Obtengo un registro a partir del id
     * @param id - Id TypePerson
     * @return TypePerson
     * @throws SQLException
     * @throws Exception 
     */
    public TypePerson getTypePerson(int id) throws SQLException, Exception{
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        TypePerson typePerson = null;
        try {
            conn = connectionDBOracle.getConnection();
            cs = conn.prepareCall("{call Type_Person_API.getTypePerson(?,?)}");
            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            while(rs.next()){
                typePerson = new TypePerson();
                typePerson.setId(rs.getInt("id"));
                typePerson.setName(rs.getString("name"));
                typePerson.setDescription(rs.getString("description"));
            }
            
            return typePerson;
        } catch (Exception e) {
            System.out.println("Error al obtener la TypePerson: " + e.getMessage());
            rs.close();
            cs.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al obtener la TypePerson: \n" +e.getMessage());
        }finally{
            rs.close();
            cs.close();
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
    public List<TypePerson> getTypePeople() throws SQLException, Exception{
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        List<TypePerson> typePeople;
        TypePerson typePerson;
        try {
            typePeople = new ArrayList<TypePerson>();
            conn = connectionDBOracle.getConnection();
            cs = conn.prepareCall("{call Type_Person_API.LIST(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            while(rs.next()){
                typePerson = new TypePerson();
                typePerson.setId(rs.getInt("id"));
                typePerson.setName(rs.getString("name"));
                typePerson.setDescription(rs.getString("description"));
                typePeople.add(typePerson);
            }
            rs.close();
            return typePeople;
        } catch (Exception e) {
            System.out.println("Error al obtener TypePerson: " + e.getMessage());
            rs.close();
            cs.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al obtener TypePerson: \n" + e.getMessage());
        }finally{
            rs.close();
            cs.close();
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
    public List<TypePerson> searchTypePeople(String texto) throws Exception{
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        List<TypePerson> typePeople;
        TypePerson typePerson;
        try {
            typePeople = new ArrayList<TypePerson>();
            conn = connectionDBOracle.getConnection();
            cs = conn.prepareCall("{call Type_Person_API.SEARCH(?,?)}");
            cs.setString(1, texto);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            while(rs.next()){
                typePerson = new TypePerson();
                typePerson.setId(rs.getInt("id"));
                typePerson.setName(rs.getString("name"));
                typePerson.setDescription(rs.getString("description"));
                typePeople.add(typePerson);
            }
            return typePeople;
        } catch (Exception e) {
            System.out.println("Error al obtener TypePeople: " + e.getMessage());
            rs.close();
            cs.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al buscar TypePeople: \n" + e.getMessage());
        }finally{
            rs.close();
            cs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }
}
