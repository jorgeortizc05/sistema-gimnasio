/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.dao;

import org.casaortiz.dao.interfaces.ICrud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.casaortiz.db.ConnectionDBPostgres;
import org.casaortiz.model.Notes;

/**
 * CRUD a Notes
 *
 * @author Ing. Jorge Luis Ortiz Cáceres
 * @since 31/08/2021
 * @version 0.0.1
 */
public class NotesDao implements ICrud<Notes> {

    ConnectionDBPostgres connectionDBPostgres;

    public NotesDao() {
        connectionDBPostgres = new ConnectionDBPostgres();
    }

    @Override
    public void insert(Notes item) throws SQLException, Exception {
        Connection conn = null;
        conn = connectionDBPostgres.getConnection();
        try {

            PreparedStatement st = conn.prepareStatement("insert into notes (name) values (?)");
            st.setString(1, item.getName());
            st.execute();
            st.close();
        } catch (Exception e) {
            connectionDBPostgres.closeConnection(conn);
            throw new Exception("Error al insertar Notes: \n" + e.getMessage());
        } finally {
            connectionDBPostgres.closeConnection(conn);
        }
    }

    public void update(Notes item) throws SQLException, Exception {
        Connection conn = null;
        try {
            conn = connectionDBPostgres.getConnection();
            PreparedStatement st = conn.prepareStatement("update notes set name = ? where id = ?");
            st.setString(1, item.getName());
            st.setInt(2, item.getId());
            st.execute();
            st.close();
        } catch (Exception e) {
            connectionDBPostgres.closeConnection(conn);
            throw new Exception("Error al actualizar Notes: \n" + e.getMessage());
        } finally {
            connectionDBPostgres.closeConnection(conn);
        }
    }

    public void delete(int id) throws SQLException, Exception {
        Connection conn = null;
        try {
            conn = connectionDBPostgres.getConnection();
            PreparedStatement st = conn.prepareStatement("delete from notes where id = " + id);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            connectionDBPostgres.closeConnection(conn);
            throw new Exception(e.getMessage());
        } finally {
            connectionDBPostgres.closeConnection(conn);
        }
    }

    public Notes get(int id) throws SQLException, Exception {
        Connection conn = null;
        ResultSet rs = null;
        Notes item = null;
        try {
            conn = connectionDBPostgres.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from notes c where c.id =" + id);
            rs = st.executeQuery();
            if (rs.next()) {
                item = new Notes(rs.getInt("id"), rs.getString("name"));
            }
            rs.close();
            return item;
        } catch (Exception e) {
            System.out.println("Error al obtener la Notes: " + e.getMessage());
            connectionDBPostgres.closeConnection(conn);
            rs.close();
            throw new Exception("Error al obtener la Notes: \n" + e.getMessage());
        } finally {
            rs.close();
            connectionDBPostgres.closeConnection(conn);
        }
    }

    public List<Notes> getList() throws SQLException, Exception {
        Connection conn = null;
        ResultSet rs = null;
        List<Notes> items;
        Notes item;
        try {
            items = new ArrayList<Notes>();
            conn = connectionDBPostgres.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from notes");
            rs = st.executeQuery();
            while (rs.next()) {
                item = new Notes(rs.getInt("id"), rs.getString("name"));
                items.add(item);
            }
            rs.close();
            return items;
        } catch (Exception e) {
            System.out.println("Error al obtener notes: " + e.getMessage());
            rs.close();
            connectionDBPostgres.closeConnection(conn);
            throw new Exception("Error al obtener notes: \n" + e.getMessage());
        } finally {
            rs.close();
            connectionDBPostgres.closeConnection(conn);
        }
    }

    /**
     * Para realizar busquedas en los
     * registros Notes
     *
     * @param texto - Lo que va a buscar
     * @return List<Notes>
     * @throws Exception
     */
    public List<Notes> searchList(String texto) throws SQLException, Exception {
        Connection conn = null;
        ResultSet rs = null;
        List<Notes> items;
        Notes item;
        try {
            items = new ArrayList<Notes>();
            conn = connectionDBPostgres.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from notes where upper(id ||' '|| name) like upper('%" + texto + "%')");
            rs = st.executeQuery();
            while (rs.next()) {
                item = new Notes(rs.getInt("id"), rs.getString("name"));
                items.add(item);
            }
            return items;
        } catch (Exception e) {
            System.out.println("Error al obtener Notes: " + e.getMessage());
            rs.close();
            connectionDBPostgres.closeConnection(conn);
            throw new Exception("Error al buscar Notes: \n" + e.getMessage());
        } finally {
            rs.close();
            connectionDBPostgres.closeConnection(conn);
        }
    }
}
