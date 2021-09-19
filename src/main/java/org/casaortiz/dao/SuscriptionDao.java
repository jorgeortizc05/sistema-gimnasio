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
import org.casaortiz.model.Suscription;

/**
 * CRUD a Suscription
 *
 * @author Ing. Jorge Luis Ortiz Cáceres
 * @since 19/09/2021
 * @version 0.0.1
 */
public class SuscriptionDao implements ICrud<Suscription> {

    ConnectionDBPostgres connectionDBOracle;

    public SuscriptionDao() {
        connectionDBOracle = new ConnectionDBPostgres();
    }

    /**
     * Inserta un registro a Suscription
     *
     * @param item Suscription
     * @throws SQLException
     * @throws Exception
     */
    @Override
    public void insert(Suscription item) throws SQLException, Exception {
        Connection conn = null;
        conn = connectionDBOracle.getConnection();
        try {

            PreparedStatement st = conn.prepareStatement("insert into Suscription (receipt_number, date_suscription, date_from, date_to, price, discount, total, comment, person_id, type_suscription_id) values (?,?, ?, ?, ?, ?, ?, ?, ?, ?)");
            st.setString(1, item.getReceipt_number());
            st.setDate(2, new java.sql.Date(item.getDateSuscription().getTime()));
            st.setDate(3, new java.sql.Date(item.getDateFrom().getTime()));
            st.setDate(4, new java.sql.Date(item.getDateTo().getTime()));
            st.setDouble(5, item.getPrice());
            st.setDouble(6, item.getDiscount());
            st.setDouble(7, item.getTotal());
            st.setString(8, item.getComment());
            st.setInt(9, item.getPersonId());
            st.setInt(10, item.getTypeSuscriptionId());

            st.execute();
            st.close();
        } catch (Exception e) {
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al insertar Suscription: \n" + e.getMessage());
        } finally {
            connectionDBOracle.closeConnection(conn);
        }
    }

    /**
     *
     * Actualiza un registro de la Suscription
     *
     * @param item Suscription
     * @throws SQLException
     * @throws Exception
     */
    public void update(Suscription item) throws SQLException, Exception {
        Connection conn = null;
        try {
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("update Suscription set date_suscription=?, date_from=?, date_to=?, price=?, discount=?, total=?, comment=?, person_id=?, type_suscription_id=? where id = ?");
            st.setString(1, item.getReceipt_number());
            st.setDate(2, new java.sql.Date(item.getDateSuscription().getTime()));
            st.setDate(3, new java.sql.Date(item.getDateFrom().getTime()));
            st.setDate(4, new java.sql.Date(item.getDateTo().getTime()));
            st.setDouble(5, item.getPrice());
            st.setDouble(6, item.getDiscount());
            st.setDouble(7, item.getTotal());
            st.setString(8, item.getComment());
            st.setInt(9, item.getPersonId());
            st.setInt(10, item.getTypeSuscriptionId());
            st.setInt(11, item.getId());
            st.execute();
            st.close();
        } catch (Exception e) {
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al actualizar Suscription: \n" + e.getMessage());
        } finally {
            connectionDBOracle.closeConnection(conn);
        }
    }

    /**
     * Elimina un registro de la Suscription
     *
     * @param id - Id de la Suscription
     * @throws SQLException
     * @throws Exception
     */
    public void delete(int id) throws SQLException, Exception {
        Connection conn = null;
        try {
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("delete from Suscription where id = " + id);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            connectionDBOracle.closeConnection(conn);
            throw new Exception(e.getMessage());
        } finally {
            connectionDBOracle.closeConnection(conn);
        }
    }

    /**
     * Obtengo un registro a partir del id
     *
     * @param id - Id Suscription
     * @return Suscription
     * @throws SQLException
     * @throws Exception
     */
    public Suscription get(int id) throws SQLException, Exception {
        Connection conn = null;
        ResultSet rs = null;
        Suscription item = null;
        try {
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from Suscription c where c.id =" + id);
            rs = st.executeQuery();
            if (rs.next()) {
                item = new Suscription();
                item.setId(rs.getInt("id"));
                item.setReceipt_number(rs.getString("receipt_number"));
                item.setDateSuscription(rs.getDate("date_suscripcion"));
                item.setDateFrom(rs.getDate("date_deom"));
                item.setDateTo(rs.getDate("date_to"));
                item.setPrice(rs.getDouble("price"));
                item.setDiscount(rs.getDouble("discount"));
                item.setTotal(rs.getDouble("total"));
                item.setComment(rs.getString("comment"));
                item.setPersonId(rs.getInt("person_id"));
                item.setTypeSuscriptionId(rs.getInt("type_suscripcion_id"));

            }
            rs.close();
            return item;
        } catch (Exception e) {
            System.out.println("Error al obtener la Suscription: " + e.getMessage());
            connectionDBOracle.closeConnection(conn);
            rs.close();
            throw new Exception("Error al obtener la Suscription: \n" + e.getMessage());
        } finally {
            rs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }

    /**
     *
     * @return List<Suscription>
     * @throws SQLException
     * @throws Exception
     */
    public List<Suscription> getList() throws SQLException, Exception {
        Connection conn = null;
        ResultSet rs = null;
        List<Suscription> items;
        Suscription item;
        try {
            items = new ArrayList<Suscription>();
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from Suscription");
            rs = st.executeQuery();
            while (rs.next()) {
                item = new Suscription();
                item.setId(rs.getInt("id"));
                item.setReceipt_number(rs.getString("receipt_number"));
                item.setDateSuscription(rs.getDate("date_suscripcion"));
                item.setDateFrom(rs.getDate("date_deom"));
                item.setDateTo(rs.getDate("date_to"));
                item.setPrice(rs.getDouble("price"));
                item.setDiscount(rs.getDouble("discount"));
                item.setTotal(rs.getDouble("total"));
                item.setComment(rs.getString("comment"));
                item.setPersonId(rs.getInt("person_id"));
                item.setTypeSuscriptionId(rs.getInt("type_suscripcion_id"));
                items.add(item);
            }
            rs.close();
            return items;
        } catch (Exception e) {
            System.out.println("Error al obtener Suscriptions: " + e.getMessage());
            rs.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al obtener Suscriptions: \n" + e.getMessage());
        } finally {
            rs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }

    /**
     *
     * @param texto - Lo que va a buscar
     * @return List<Suscription>
     * @throws Exception
     */
    public List<Suscription> searchList(String texto) throws SQLException, Exception {
        Connection conn = null;
        ResultSet rs = null;
        List<Suscription> items;
        Suscription item;
        try {
            items = new ArrayList<Suscription>();
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from Suscription where upper(id ||' '|| name ||' '||description) like upper('%" + texto + "%')");
            rs = st.executeQuery();
            while (rs.next()) {
                item = new Suscription();
                item.setId(rs.getInt("id"));
                item.setReceipt_number(rs.getString("receipt_number"));
                item.setDateSuscription(rs.getDate("date_suscripcion"));
                item.setDateFrom(rs.getDate("date_deom"));
                item.setDateTo(rs.getDate("date_to"));
                item.setPrice(rs.getDouble("price"));
                item.setDiscount(rs.getDouble("discount"));
                item.setTotal(rs.getDouble("total"));
                item.setComment(rs.getString("comment"));
                item.setPersonId(rs.getInt("person_id"));
                item.setTypeSuscriptionId(rs.getInt("type_suscripcion_id"));
                items.add(item);
            }
            return items;
        } catch (Exception e) {
            System.out.println("Error al obtener Suscriptions: " + e.getMessage());
            rs.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al buscar Suscriptions: \n" + e.getMessage());
        } finally {
            rs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }
}
