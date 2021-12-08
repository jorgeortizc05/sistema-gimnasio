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
import org.casaortiz.model.Product;

/**
 * CRUD a Product
 *
 * @author Ing. Jorge Luis Ortiz Cáceres
 * @since 31/08/2021
 * @version 0.0.1
 */
public class ProductDao implements ICrud<Product> {

    ConnectionDBPostgres connectionDBOracle;

    public ProductDao() {
        connectionDBOracle = new ConnectionDBPostgres();
    }

    @Override
    public void insert(Product item) throws SQLException, Exception {
        Connection conn = null;
        conn = connectionDBOracle.getConnection();
        try {

            PreparedStatement st = conn.prepareStatement("insert into Product (name, description, price, serial, photo, category_id) values (?,?,?,?,?,?) RETURNING ID");
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
            st.setDouble(3, item.getPrice());
            st.setString(4, item.getSerial());
            st.setString(5, item.getPhoto());
            st.setInt(6, item.getCategoryId());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                item.setId(rs.getInt(1));//recupero mi id autogenerado y seteo
                //System.out.println("Inserted ID -" + item.getId()); // display inserted record
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al insertar Product: \n" + e.getMessage());
        } finally {
            connectionDBOracle.closeConnection(conn);
        }
    }

    public void update(Product item) throws SQLException, Exception {
        Connection conn = null;
        try {
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("update Product set name = ?, description = ?, price = ?, serial = ?, photo = ?, category_id = ? where id = ?");
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
            st.setDouble(3, item.getPrice());
            st.setString(4, item.getSerial());
            st.setString(5, item.getPhoto());
            st.setInt(6, item.getCategoryId());
            st.setInt(7, item.getId());
            st.execute();
            st.close();
        } catch (Exception e) {
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al actualizar Product: \n" + e.getMessage());
        } finally {
            connectionDBOracle.closeConnection(conn);
        }
    }

    public void delete(int id) throws SQLException, Exception {
        Connection conn = null;
        try {
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("delete from Product where id = " + id);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            connectionDBOracle.closeConnection(conn);
            throw new Exception(e.getMessage());
        } finally {
            connectionDBOracle.closeConnection(conn);
        }
    }

    public Product get(int id) throws SQLException, Exception {
        Connection conn = null;
        ResultSet rs = null;
        Product item = null;
        try {
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from Product c where c.id =" + id);
            rs = st.executeQuery();
            if (rs.next()) {
                item = new Product(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getDouble("price"),
                rs.getString("serial"),rs.getString("photo"),rs.getInt("category_id"));
            }
            rs.close();
            return item;
        } catch (Exception e) {
            System.out.println("Error al obtener la producto: " + e.getMessage());
            connectionDBOracle.closeConnection(conn);
            rs.close();
            throw new Exception("Error al obtener la producto: \n" + e.getMessage());
        } finally {
            rs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }

    public List<Product> getList() throws SQLException, Exception {
        Connection conn = null;
        ResultSet rs = null;
        List<Product> items;
        Product item;
        try {
            items = new ArrayList<Product>();
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from Product");
            rs = st.executeQuery();
            while (rs.next()) {
                item = new Product(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getDouble("price"),
                rs.getString("serial"),rs.getString("photo"),rs.getInt("category_id"));
                items.add(item);
            }
            rs.close();
            return items;
        } catch (Exception e) {
            System.out.println("Error al obtener productos: " + e.getMessage());
            rs.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al obtener productos: \n" + e.getMessage());
        } finally {
            rs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }

    /**
     * Para realizar busquedas en los
     * registros Product
     *
     * @param texto - Lo que va a buscar
     * @return List<Product>
     * @throws Exception
     */
    public List<Product> searchList(String texto) throws SQLException, Exception {
        Connection conn = null;
        ResultSet rs = null;
        List<Product> items;
        Product item;
        try {
            items = new ArrayList<Product>();
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from Product where upper(id ||' '|| name ||' '||description) like upper('%" + texto + "%')");
            rs = st.executeQuery();
            while (rs.next()) {
                item = new Product(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getDouble("price"),
                rs.getString("serial"),rs.getString("photo"),rs.getInt("category_id"));
                items.add(item);
            }
            return items;
        } catch (Exception e) {
            System.out.println("Error al buscar productos: " + e.getMessage());
            rs.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al buscar productos: \n" + e.getMessage());
        } finally {
            rs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }
}
