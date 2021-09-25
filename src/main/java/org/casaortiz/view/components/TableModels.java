/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.view.components;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.casaortiz.model.Category;
import org.casaortiz.model.Person;
import org.casaortiz.model.Suscription;
import org.casaortiz.model.TypePerson;
import org.casaortiz.model.TypeSuscription;
import org.casaortiz.model.TypeVoucher;

/**
 *
 * @author jorge
 */
public class TableModels {
    
    public static DefaultTableModel getModelCategories(JTable table, List<Category> categories){
        cleanTable(table);
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        List<Category> items = categories;
        Object rowData[] = new Object[3];
        for (Category c : items) {
            rowData[0] = c.getId();
            rowData[1] = c.getName();
            rowData[2] = c.getDescription();
            modelo.addRow(rowData);
        }
        return modelo;
    }
    
    public static DefaultTableModel getModelPerson(JTable table, List<Person> people){
        cleanTable(table);
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        List<Person> items = people;
        Object rowData[] = new Object[6];
        for (Person p : items) {
            rowData[0] = p.getId();
            rowData[1] = p.getFirstName();
            rowData[2] = p.getLastName();
            rowData[3] = p.getEmail();
            rowData[4] = p.getPhone();
            rowData[5] = p.getActive();

            modelo.addRow(rowData);
        }
        return modelo;
    }
    
    public static DefaultTableModel getModelPersonForCheckSuscription(JTable table, List<Person> people){
        cleanTable(table);
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        Object rowData[] = new Object[4];
        for (Person p : people) {
            rowData[0] = p.getIdentificationId();
            rowData[1] = p.getFirstName();
            rowData[2] = p.getLastName();
            rowData[3] = p.getPhone();
            modelo.addRow(rowData);
        }
        return modelo;
    }
    
    public static DefaultTableModel getModelTypePerson(JTable table, List<TypePerson> typePeople){
        cleanTable(table);
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        List<TypePerson> items = typePeople;
        Object rowData[] = new Object[3];
        for (TypePerson c : items) {
            System.out.println(c);
            rowData[0] = c.getId();
            rowData[1] = c.getName();
            rowData[2] = c.getDescription();
            modelo.addRow(rowData);
        }
        return modelo;
    }
    
    public static DefaultTableModel getModelTypeSuscription(JTable table, List<TypeSuscription> typeSuscriptions){
        cleanTable(table);
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        List<TypeSuscription> items = typeSuscriptions;
        Object rowData[] = new Object[5];
        for(TypeSuscription ts: items){
            System.out.println(ts);
            rowData[0] = ts.getId();
            rowData[1] = ts.getName();
            rowData[2] = ts.getNum_days();
            rowData[3] = ts.getPrice();
            rowData[4] = ts.getDescription();
            modelo.addRow(rowData);
        }
        return modelo;
    }
    
    public static DefaultTableModel getModelSuscription(JTable table, List<Suscription> suscriptions){
        cleanTable(table);
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        List<Suscription> items = suscriptions;
        Object rowData[] = new Object[4];
        for(Suscription c: items){
            System.out.println(c);
            rowData[0] = c.getId();
            rowData[1] = c.getDateFrom();
            rowData[2] = c.getDateTo();
            rowData[3] = c.getTotal();
            modelo.addRow(rowData);
        }
        return modelo;
    }
    
    public static DefaultTableModel getModelTypeVoucher(JTable table, List<TypeVoucher> typeVouchers){
        cleanTable(table);
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        List<TypeVoucher> items = typeVouchers;
        Object rowData[] = new Object[3];
        for(TypeVoucher c: items){
            System.out.println(c);
            rowData[0] = c.getId();
            rowData[1] = c.getName();
            rowData[2] = c.getDescription();
            modelo.addRow(rowData);
        }
        return modelo;
    }
    
    public static DefaultTableModel cleanTable(JTable table) {
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        modelo.setRowCount(0);
        return modelo;
    }
    
    
}
