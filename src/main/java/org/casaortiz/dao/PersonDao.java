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
import org.casaortiz.model.Person;

/**
 * CRUD a Person
 *
 * @author Ing. Jorge Luis Ortiz Cáceres
 * @since 31/08/2021
 * @version 0.0.1
 */
public class PersonDao implements ICrud<Person>{

    ConnectionDBOracle connectionDBOracle;

    public PersonDao() {
        connectionDBOracle = new ConnectionDBOracle();
    }

    /**
     * Call procedure PERSON_API.INS(p_name, p_description): Inserta un
     * registro a person
     *
     * @param item Person
     * @throws SQLException
     * @throws Exception
     */
    public void insert(Person item) throws SQLException, Exception {
        Connection conn = null;
        CallableStatement cstmt = null;
        conn = connectionDBOracle.getConnection();
        try {

            cstmt = conn.prepareCall("{call PERSON_API.INS(?,?,?,?,?,?,?,?,?,?)}");
            cstmt.setString(1, item.getFirstName());
            cstmt.setString(2, item.getLastName());
            cstmt.setString(3, item.getIdentificationId());
            cstmt.setString(4, item.getAddress());
            cstmt.setString(5, item.getEmail());
            cstmt.setDate(6, new java.sql.Date(item.getBirthday().getTime()));
            cstmt.setString(7, item.getPhone());
            cstmt.setString(8, item.getActive());
            cstmt.setString(9, item.getPhoto());
            cstmt.setInt(10, item.getTypePersonId());
            cstmt.execute();
        } catch (Exception e) {
            cstmt.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al insertar Person: \n" + e.getMessage());
        } finally {
            cstmt.close();
            connectionDBOracle.closeConnection(conn);
        }
    }

    /**
     * Call procedure PERSON_API.UPD(p_id, p_name, p_description) Actualiza
     * un registro de la Person
     *
     * @param item Person
     * @throws SQLException
     * @throws Exception
     */
    public void update(Person item) throws SQLException, Exception {
        Connection conn = null;
        CallableStatement cstmt = null;

        try {
            conn = connectionDBOracle.getConnection();
            cstmt = conn.prepareCall("{call PERSON_API.UPD(?,?,?,?,?,?,?,?,?,?,?)}");
            cstmt.setInt(1, item.getId());
            cstmt.setString(2, item.getFirstName());
            cstmt.setString(3, item.getLastName());
            cstmt.setString(4, item.getIdentificationId());
            cstmt.setString(5, item.getAddress());
            cstmt.setString(6, item.getEmail());
            cstmt.setDate(7, new java.sql.Date(item.getBirthday().getTime()));
            cstmt.setString(8, item.getPhone());
            cstmt.setString(9, item.getActive());
            cstmt.setString(10, item.getPhoto());
            cstmt.setInt(11, item.getTypePersonId());
            cstmt.execute();
        } catch (Exception e) {
            cstmt.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al actualizar: \n" + e.getMessage());
        } finally {
            cstmt.close();
            connectionDBOracle.closeConnection(conn);
        }
    }

    /**
     * Call procedure PERSON_API.DEL(p_id) Elimina un registro de la Person
     *
     * @param id - Id de la Person
     * @throws SQLException
     * @throws Exception
     */
    public void delete(int id) throws SQLException, Exception {
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = connectionDBOracle.getConnection();
            cstmt = conn.prepareCall("{call Person_API.DEL(?)}");
            cstmt.setInt(1, id);
            cstmt.execute();
        } catch (Exception e) {
            connectionDBOracle.closeConnection(conn);
            cstmt.close();
            throw new Exception(e.getMessage());
        } finally {
            connectionDBOracle.closeConnection(conn);
            cstmt.close();
        }
    }

    /**
     * Call procedure PERSON_API.getPerson(p_id, Person_c) Obtengo un
     * registro a partir del id
     *
     * @param id - Id Person
     * @return Person
     * @throws SQLException
     * @throws Exception
     */
    @Override
    public Person get(int id) throws SQLException, Exception {
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        Person item = null;
        try {
            conn = connectionDBOracle.getConnection();
            cs = conn.prepareCall("{call Person_API.getPerson(?,?)}");
            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            while (rs.next()) {
                item = new Person();
                item.setId(rs.getInt("id"));
                item.setFirstName(rs.getString("first_name"));
                item.setLastName(rs.getString("last_name"));
                item.setIdentificationId(rs.getString("identification_id"));
                item.setAddress(rs.getString("address"));
                item.setEmail(rs.getString("email"));
                item.setBirthday(rs.getDate("birthday"));
                item.setPhone(rs.getString("phone"));
                item.setActive(rs.getString("active"));
                item.setPhoto(rs.getString("photo"));
                item.setTypePersonId(rs.getInt("type_person_id"));
            }

            return item;
        } catch (Exception e) {
            System.out.println("Error al obtener la Person: " + e.getMessage());
            rs.close();
            cs.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al obtener la Person: \n" + e.getMessage());
        } finally {
            rs.close();
            cs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }

    /**
     * call procedure PERSON_API.LIST(Person_c) Recupero una lista de People
     *
     * @return List<Person>
     * @throws SQLException
     * @throws Exception
     */
    public List<Person> getList() throws SQLException, Exception {
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        List<Person> people;
        Person item;
        try {
            people = new ArrayList<Person>();
            conn = connectionDBOracle.getConnection();
            cs = conn.prepareCall("{call Person_API.LIST(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            while (rs.next()) {
                item = new Person();
                item.setId(rs.getInt("id"));
                item.setFirstName(rs.getString("first_name"));
                item.setLastName(rs.getString("last_name"));
                item.setIdentificationId(rs.getString("identification_id"));
                item.setAddress(rs.getString("address"));
                item.setEmail(rs.getString("email"));
                item.setBirthday(rs.getDate("birthday"));
                item.setPhone(rs.getString("phone"));
                item.setActive(rs.getString("active"));
                item.setPhoto(rs.getString("photo"));
                item.setTypePersonId(rs.getInt("type_person_id"));
                people.add(item);
            }
            rs.close();
            return people;
        } catch (Exception e) {
            System.out.println("Error al obtener Person: " + e.getMessage());
            rs.close();
            cs.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al obtener Person: \n" + e.getMessage());
        } finally {
            rs.close();
            cs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }

    /**
     * call procedure PERSON_API.SEARCH(texto) Para realizar busquedas en
     * los registros Person
     *
     * @param texto - Lo que va a buscar
     * @return List<Person>
     * @throws Exception
     */
    public List<Person> searchList(String texto) throws Exception {
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        List<Person> people;
        Person item;
        try {
            people = new ArrayList<Person>();
            conn = connectionDBOracle.getConnection();
            cs = conn.prepareCall("{call Person_API.SEARCH(?,?)}");
            cs.setString(1, texto);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            while (rs.next()) {
                item = new Person();
                item.setId(rs.getInt("id"));
                item.setFirstName(rs.getString("first_name"));
                item.setLastName(rs.getString("last_name"));
                item.setIdentificationId(rs.getString("identification_id"));
                item.setAddress(rs.getString("address"));
                item.setEmail(rs.getString("email"));
                item.setBirthday(rs.getDate("birthday"));
                item.setPhone(rs.getString("phone"));
                item.setActive(rs.getString("active"));
                item.setPhoto(rs.getString("photo"));
                item.setTypePersonId(rs.getInt("type_person_id"));
                people.add(item);
            }
            return people;
        } catch (Exception e) {
            System.out.println("Error al obtener People: " + e.getMessage());
            rs.close();
            cs.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al buscar People: \n" + e.getMessage());
        } finally {
            rs.close();
            cs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }
}
