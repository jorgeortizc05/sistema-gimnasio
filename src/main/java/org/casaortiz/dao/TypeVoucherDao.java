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
import org.casaortiz.model.TypeVoucher;

/**
 * CRUD a TypeVoucher
 * @author Ing. Jorge Luis Ortiz Cáceres
 * @since 31/08/2021
 * @version 0.0.1
 */
public class TypeVoucherDao implements ICrud<TypeVoucher>{
    ConnectionDBPostgres connectionDBOracle;
    
    public TypeVoucherDao(){
        connectionDBOracle = new ConnectionDBPostgres();
    }

    /**
     * Call procedure Type_Voucher_API.INS(p_name, p_description):
     * Inserta un registro a TypeVoucher
     * @param item TypeVoucher
     * @throws SQLException
     * @throws Exception 
     */
    public void insert(TypeVoucher item) throws SQLException, Exception{
        Connection conn = null;
        conn = connectionDBOracle.getConnection();
        try {
            
            PreparedStatement st = conn.prepareStatement("insert into type_voucher (name, description) values (?,?)");
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
            st.execute();
            st.close();
        } catch (Exception e ) {
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al insertar TypeVoucher: \n" + e.getMessage());
        }finally{
            connectionDBOracle.closeConnection(conn);
        }
    }
    
    /**
     * Call procedure Type_Voucher_API.UPD(p_id, p_name, p_description)
     * Actualiza un registro de la TypeVoucher
     * @param item TypeVoucher
     * @throws SQLException
     * @throws Exception 
     */
    public void update(TypeVoucher item) throws SQLException, Exception{
        Connection conn = null;
        try {
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("update Type_Voucher set name = ?, description = ? where id = ?");
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
            st.setInt(3, item.getId());
            st.execute();
            st.close();
        } catch (Exception e) {
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al actualizar TypeVoucher: \n" + e.getMessage());
        }finally{
            connectionDBOracle.closeConnection(conn);
        }
    }
    
    /**
     * Call procedure Type_Voucher_API.DEL(p_id)
     * Elimina un registro de la TypeVoucher
     * @param id - Id de la TypeVoucher
     * @throws SQLException
     * @throws Exception 
     */
    public void delete(int id) throws SQLException, Exception{
        Connection conn = null;
        try {
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("delete from Type_Voucher where id = "+id);
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
     * Call procedure Type_Voucher_API.getTypeVoucher(p_id, Type_Person_c)
     * Obtengo un registro a partir del id
     * @param id - Id TypeVoucher
     * @return TypeVoucher
     * @throws SQLException
     * @throws Exception 
     */
    public TypeVoucher get(int id) throws SQLException, Exception{
        Connection conn = null;
        ResultSet rs = null;
        TypeVoucher item = null;
        try {
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from Type_Voucher c where c.id ="+id);
            rs = st.executeQuery();
            if(rs.next()){
                item = new TypeVoucher();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
            }
            rs.close();
            return item;
        } catch (Exception e) {
            System.out.println("Error al obtener la TypeVoucher: " + e.getMessage());
            connectionDBOracle.closeConnection(conn);
            rs.close();
            throw new Exception("Error al obtener la TypeVoucher: \n" +e.getMessage());
        }finally{
            rs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }
    
    /**
     * call procedure Type_Voucher_API.LIST(Type_Person_c)
     * Recupero una lista de TypeVoucher
     * @return List<TypeVoucher>
     * @throws SQLException
     * @throws Exception 
     */
    public List<TypeVoucher> getList() throws SQLException, Exception{
        Connection conn = null;
        ResultSet rs = null;
        List<TypeVoucher> items;
        TypeVoucher item;
        try {
            items = new ArrayList<TypeVoucher>();
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from Type_Voucher");
            rs = st.executeQuery();
            while(rs.next()){
                item = new TypeVoucher();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                items.add(item);
            }
            rs.close();
            return items;
        } catch (Exception e) {
            System.out.println("Error al obtener TypeVouchers: " + e.getMessage());
            rs.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al obtener TypeVouchers: \n" + e.getMessage());
        }finally{
            rs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }
    
    /**
     * call procedure Type_Voucher_API.SEARCH(texto)
     * Para realizar busquedas en los registros TypeVoucher
     * @param texto - Lo que va a buscar
     * @return List<TypeVoucher>
     * @throws Exception 
     */
    public List<TypeVoucher> searchList(String texto) throws Exception{
        Connection conn = null;
        ResultSet rs = null;
        List<TypeVoucher> items;
        TypeVoucher item;
        try {
            items = new ArrayList<TypeVoucher>();
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from Type_Voucher where upper(name ||' '||description) like upper('%"+texto+"%')");
            rs = st.executeQuery();
            while(rs.next()){
                item = new TypeVoucher();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                items.add(item);
            }
            return items;
        } catch (Exception e) {
            System.out.println("Error al obtener TypeVouchers: " + e.getMessage());
            rs.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al buscar TypeVouchers: \n" + e.getMessage());
        }finally{
            rs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }
}
