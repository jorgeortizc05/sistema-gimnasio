/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.view.components;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.casaortiz.dao.TypeSuscriptionDao;
import org.casaortiz.model.Category;
import org.casaortiz.model.Notes;
import org.casaortiz.model.Person;
import org.casaortiz.model.Product;
import org.casaortiz.model.Suscription;
import org.casaortiz.model.TypePerson;
import org.casaortiz.model.TypeSuscription;
import org.casaortiz.model.TypeSuscriptionSuscriptionR;
import org.casaortiz.model.TypeVoucher;

/**
 *
 * @author jorge
 */
public class TableModels {
    public static DefaultTableModel getModelCategories(JTable table, List<Category> categories){
        cleanTable(table);
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        Object rowData[] = new Object[3];
        for (Category c : categories) {
            rowData[0] = c.getId();
            rowData[1] = c.getName();
            rowData[2] = c.getDescription();
            modelo.addRow(rowData);
        }
        return modelo;
    }
    
    public static DefaultTableModel getModelProducts(JTable table, List<Product> products){
        cleanTable(table);
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        Object rowData[] = new Object[7];
        for (Product prod : products) {
            rowData[0] = prod.getId();
            rowData[1] = prod.getName();
            rowData[2] = prod.getDescription();
            rowData[3] = prod.getPrice();
            rowData[4] = prod.getSerial();
            rowData[5] = prod.getPhoto();
            rowData[6] = prod.getCategoryId();
            modelo.addRow(rowData);
        }
        return modelo;
    }
    
    public static DefaultTableModel getModelNotes(JTable table, List<Notes> notes){
        cleanTable(table);
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        Object rowData[] = new Object[2];
        for (Notes n : notes) {
            rowData[0] = n.getId();
            rowData[1] = n.getName();
            modelo.addRow(rowData);
        }
        return modelo;
    }
    
    public static DefaultTableModel getModelPerson(JTable table, List<Person> people){
        cleanTable(table);
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        Object rowData[] = new Object[6];
        for (Person p : people) {
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
        Object rowData[] = new Object[3];
        for (TypePerson c : typePeople) {
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
        Object rowData[] = new Object[5];
        for(TypeSuscription ts: typeSuscriptions){
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
    
    public static DefaultTableModel getModelSuscription(JTable table, List<TypeSuscriptionSuscriptionR> suscriptions) throws Exception{
        cleanTable(table);
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        Object rowData[] = new Object[5];
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        for(TypeSuscriptionSuscriptionR c: suscriptions){
            rowData[0] = c.getId();
            rowData[1] = simpleDateFormat.format(c.getDateFrom());
            rowData[2] = simpleDateFormat.format(c.getDateTo());
            rowData[3] = c.getTotal();
            rowData[4] = c.getNameTypeSus();
            modelo.addRow(rowData);
        }
        return modelo;
    }
    
    public static DefaultTableModel getModelTypeVoucher(JTable table, List<TypeVoucher> typeVouchers){
        cleanTable(table);
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        Object rowData[] = new Object[3];
        for(TypeVoucher c: typeVouchers){
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
