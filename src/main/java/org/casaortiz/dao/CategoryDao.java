/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.dao;
import org.casaortiz.dao.interfaces.ICrud;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;
import org.casaortiz.db.ConnectionDBOracle;
import org.casaortiz.model.Category;

/**
 * CRUD a Category
 * @author Ing. Jorge Luis Ortiz Cáceres
 * @since 31/08/2021
 * @version 0.0.1
 */
public class CategoryDao implements ICrud<Category>{
    ConnectionDBOracle connectionDBOracle;
    
    public CategoryDao(){
        connectionDBOracle = new ConnectionDBOracle();
    }

    /**
     * Call procedure CATEGORY_API.INS(p_name, p_description):
     * Inserta un registro a categoria
     * @param item Category
     * @throws SQLException
     * @throws Exception 
     */
    @Override
    public void insert(Category item) throws SQLException, Exception{
        item = new Category();
        Connection conn = null;
        CallableStatement cstmt = null;
        conn = connectionDBOracle.getConnection();
        try {
            
            cstmt = conn.prepareCall("{call CATEGORY_API.INS(?,?)}");
            cstmt.setString(1, item.getName());
            cstmt.setString(2, item.getDescription());
            cstmt.execute();
        } catch (Exception e ) {
            cstmt.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al insertar Category: \n" + e.getMessage());
        }finally{
            cstmt.close();
            connectionDBOracle.closeConnection(conn);
        }
    }
    
    /**
     * Call procedure CATEGORY_API.UPD(p_id, p_name, p_description)
     * Actualiza un registro de la category
     * @param item Category
     * @throws SQLException
     * @throws Exception 
     */
    public void update(Category item) throws SQLException, Exception{
        Connection conn = null;
        CallableStatement cstmt = null;
        
        try {
            conn = connectionDBOracle.getConnection();
            cstmt = conn.prepareCall("{call CATEGORY_API.UPD(?,?,?)}");
            cstmt.setInt(1, item.getId());
            cstmt.setString(2, item.getName());
            cstmt.setString(3, item.getDescription());
            cstmt.execute();
        } catch (Exception e) {
            cstmt.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al actualizar Category: \n" + e.getMessage());
        }finally{
            cstmt.close();
            connectionDBOracle.closeConnection(conn);
        }
    }
    
    /**
     * Call procedure CATEGORY_API.DEL(p_id)
     * Elimina un registro de la category
     * @param id - Id de la category
     * @throws SQLException
     * @throws Exception 
     */
    public void delete(int id) throws SQLException, Exception{
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = connectionDBOracle.getConnection();
            cstmt = conn.prepareCall("{call CATEGORY_API.DEL(?)}");
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
     * Call procedure CATEGORY_API.getcategory(p_id, category_c)
     * Obtengo un registro a partir del id
     * @param id - Id Category
     * @return Category
     * @throws SQLException
     * @throws Exception 
     */
    public Category get(int id) throws SQLException, Exception{
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        Category category = null;
        try {
            conn = connectionDBOracle.getConnection();
            cs = conn.prepareCall("{call CATEGORY_API.getcategory(?,?)}");
            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            while(rs.next()){
                category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setDescription(rs.getString("description"));
            }
            
            return category;
        } catch (Exception e) {
            System.out.println("Error al obtener la categoria: " + e.getMessage());
            rs.close();
            cs.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al obtener la categoria: \n" +e.getMessage());
        }finally{
            rs.close();
            cs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }
    
    /**
     * call procedure CATEGORY_API.LIST(category_c)
     * Recupero una lista de categories
     * @return List<Category>
     * @throws SQLException
     * @throws Exception 
     */
    public List<Category> getList() throws SQLException, Exception{
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        List<Category> categories;
        Category category;
        try {
            categories = new ArrayList<Category>();
            conn = connectionDBOracle.getConnection();
            cs = conn.prepareCall("{call CATEGORY_API.LIST(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            while(rs.next()){
                category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setDescription(rs.getString("description"));
                categories.add(category);
            }
            rs.close();
            return categories;
        } catch (Exception e) {
            System.out.println("Error al obtener categorias: " + e.getMessage());
            rs.close();
            cs.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al obtener categorias: \n" + e.getMessage());
        }finally{
            rs.close();
            cs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }
    
    /**
     * call procedure CATEGORY_API.SEARCH(texto)
     * Para realizar busquedas en los registros category
     * @param texto - Lo que va a buscar
     * @return List<Category>
     * @throws Exception 
     */
    public List<Category> searchList(String texto) throws SQLException, Exception{
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        List<Category> categories;
        Category category;
        try {
            categories = new ArrayList<Category>();
            conn = connectionDBOracle.getConnection();
            cs = conn.prepareCall("{call CATEGORY_API.SEARCH(?,?)}");
            cs.setString(1, texto);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            while(rs.next()){
                category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setDescription(rs.getString("description"));
                categories.add(category);
            }
            return categories;
        } catch (Exception e) {
            System.out.println("Error al obtener categorias: " + e.getMessage());
            rs.close();
            cs.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al buscar categorias: \n" + e.getMessage());
        }finally{
            rs.close();
            cs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }
}
