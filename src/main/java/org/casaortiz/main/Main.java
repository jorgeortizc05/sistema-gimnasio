/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.main;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.sql.SQLException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.casaortiz.view.MainView;

/**
 *
 * @author jorge
 */
public class Main {
    
    public static void main(String[] args) throws SQLException{
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                        // Set cross-platform Java L&F (also called "Metal")
                    //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                    //UIManager.setLookAndFeel( new FlatLightLaf());
                    //UIManager.setLookAndFeel( new FlatDarkLaf());
                    UIManager.setLookAndFeel( new FlatIntelliJLaf() );
                    
                } 
                catch (UnsupportedLookAndFeelException e) {
                   // handle exception
                } /*catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                new MainView().setVisible(true);
            }
        });
        
    }
    
}
