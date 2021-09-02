/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author jorge
 */
public interface IGetSearch<T> {
    public List<T> searchList(String texto) throws SQLException, Exception;
}
