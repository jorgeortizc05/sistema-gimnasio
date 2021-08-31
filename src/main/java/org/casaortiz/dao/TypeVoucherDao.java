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
import org.casaortiz.model.TypeVoucher;

/**
 * CRUD a TypeVoucher
 * @author Ing. Jorge Luis Ortiz Cáceres
 * @since 31/08/2021
 * @version 0.0.1
 */
public class TypeVoucherDao {
    ConnectionDBOracle connectionDBOracle;
    
    public TypeVoucherDao(){
        connectionDBOracle = new ConnectionDBOracle();
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
        CallableStatement cstmt = null;
        conn = connectionDBOracle.getConnection();
        try {
            
            cstmt = conn.prepareCall("{call Type_Voucher_API.INS(?,?)}");
            cstmt.setString(1, item.getName());
            cstmt.setString(2, item.getDescription());
            cstmt.execute();
        } catch (Exception e ) {
            cstmt.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al insertar TypeVoucher: \n" + e.getMessage());
        }finally{
            cstmt.close();
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
        CallableStatement cstmt = null;
        
        try {
            conn = connectionDBOracle.getConnection();
            cstmt = conn.prepareCall("{call Type_Voucher_API.UPD(?,?,?)}");
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
     * Call procedure Type_Voucher_API.DEL(p_id)
     * Elimina un registro de la TypeVoucher
     * @param id - Id de la TypeVoucher
     * @throws SQLException
     * @throws Exception 
     */
    public void delete(int id) throws SQLException, Exception{
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = connectionDBOracle.getConnection();
            cstmt = conn.prepareCall("{call Type_Voucher_API.DEL(?)}");
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
     * Call procedure Type_Voucher_API.getTypeVoucher(p_id, Type_Person_c)
     * Obtengo un registro a partir del id
     * @param id - Id TypeVoucher
     * @return TypeVoucher
     * @throws SQLException
     * @throws Exception 
     */
    public TypeVoucher getTypeVoucher(int id) throws SQLException, Exception{
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        TypeVoucher typeVoucher = null;
        try {
            conn = connectionDBOracle.getConnection();
            cs = conn.prepareCall("{call Type_Voucher_API.getTypeVoucher(?,?)}");
            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            while(rs.next()){
                typeVoucher = new TypeVoucher();
                typeVoucher.setId(rs.getInt("id"));
                typeVoucher.setName(rs.getString("name"));
                typeVoucher.setDescription(rs.getString("description"));
            }
            
            return typeVoucher;
        } catch (Exception e) {
            System.out.println("Error al obtener la TypeVoucher: " + e.getMessage());
            rs.close();
            cs.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al obtener la TypeVoucher: \n" +e.getMessage());
        }finally{
            rs.close();
            cs.close();
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
    public List<TypeVoucher> getTypeVouchers() throws SQLException, Exception{
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        List<TypeVoucher> typeVouchers;
        TypeVoucher typeVoucher;
        try {
            typeVouchers = new ArrayList<TypeVoucher>();
            conn = connectionDBOracle.getConnection();
            cs = conn.prepareCall("{call Type_Voucher_API.LIST(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            while(rs.next()){
                typeVoucher = new TypeVoucher();
                typeVoucher.setId(rs.getInt("id"));
                typeVoucher.setName(rs.getString("name"));
                typeVoucher.setDescription(rs.getString("description"));
                typeVouchers.add(typeVoucher);
            }
            rs.close();
            return typeVouchers;
        } catch (Exception e) {
            System.out.println("Error al obtener TypeVoucher: " + e.getMessage());
            rs.close();
            cs.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al obtener TypeVoucher: \n" + e.getMessage());
        }finally{
            rs.close();
            cs.close();
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
    public List<TypeVoucher> searchTypeVouchers(String texto) throws Exception{
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        List<TypeVoucher> typeVouchers;
        TypeVoucher typeVoucher;
        try {
            typeVouchers = new ArrayList<TypeVoucher>();
            conn = connectionDBOracle.getConnection();
            cs = conn.prepareCall("{call Type_Voucher_API.SEARCH(?,?)}");
            cs.setString(1, texto);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            while(rs.next()){
                typeVoucher = new TypeVoucher();
                typeVoucher.setId(rs.getInt("id"));
                typeVoucher.setName(rs.getString("name"));
                typeVoucher.setDescription(rs.getString("description"));
                typeVouchers.add(typeVoucher);
            }
            return typeVouchers;
        } catch (Exception e) {
            System.out.println("Error al obtener TypeVouchers: " + e.getMessage());
            rs.close();
            cs.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al buscar TypeVouchers: \n" + e.getMessage());
        }finally{
            rs.close();
            cs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }
}
