/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.main;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Image;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.casaortiz.view.FileLocation;
import org.casaortiz.view.MainView;

/**
 *
 * @author jorge
 */
public class Main {

    public static void main(String[] args) throws SQLException {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Set cross-platform Java L&F (also called "Metal")
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                    //UIManager.setLookAndFeel( new FlatLightLaf());
                    //UIManager.setLookAndFeel(new FlatDarkLaf());
                    //UIManager.setLookAndFeel( new FlatIntelliJLaf() );

                } catch (UnsupportedLookAndFeelException e) {
                    // handle exception
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                /*catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                MainView v = new MainView();
                URL imgURL = getClass().getResource("/icons/system/logo_mini.png");

                if (imgURL != null) {
                    Image img = new ImageIcon(imgURL).getImage();
                    v.setIconImage(img);
                }
                v.setSize(1366, 768);
                
                v.setVisible(true);
            }
        });

    }

}
