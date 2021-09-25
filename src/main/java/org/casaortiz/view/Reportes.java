/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.view;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.casaortiz.db.ConnectionDBPostgres;
import org.casaortiz.model.Person;

/**
 *
 * @author jorge
 */
public class Reportes {
    
    public void generarTarjetaGimnasio(Person person){
        String ubicacionJrxml = FileLocation.pathReports+"tarjetaGimnasioPersona.jrxml"; //System.getProperty("user.dir")+File.separator+File.separator+"src"+File.separator+"main"+File.separator+"resources" +File.separator+"tarjetaGimnasioPersona.jrxml";
        ConnectionDBPostgres conector = new ConnectionDBPostgres();
        Connection connect = null;
        try {
            // TODO add your handling code here:
            if(person == null){
                JOptionPane.showMessageDialog(null, "Primero debes seleccionar un cliente de la tabla");
            }else{
                JasperReport reporte;
                connect = conector.getConnection();
                Map<String, Object> parametros = new HashMap<String, Object>();
                parametros.put("pv_cedula", person.identificationId());
                parametros.put("pv_nombres", person.firstName()+" "+person.lastName());

                reporte = JasperCompileManager.compileReport(ubicacionJrxml);
                JasperPrint jp = JasperFillManager.fillReport(reporte, parametros, connect);
                JasperViewer.viewReport(jp, false);
                conector.closeConnection(connect);
            }
        } catch (JRException ex) {
            Logger.getLogger(CheckSuscriptionView.class.getName()).log(Level.SEVERE, null, ex);
            conector.closeConnection(connect);
        }
    }
    
}
