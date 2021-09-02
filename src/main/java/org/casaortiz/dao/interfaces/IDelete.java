/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.dao.interfaces;

import java.sql.SQLException;

/**
 *
 * @author jorge
 */
public interface IDelete {
    public void delete(int id) throws SQLException, Exception;
}
