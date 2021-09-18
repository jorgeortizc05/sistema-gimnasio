/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.dao.interfaces;

/**
 *
 * @author jorge
 */
public interface ICrud<T> extends IInsert<T>, IUpdate<T>, IDelete, IGet, IGetList<T>, IGetSearch<T>{
    
}
