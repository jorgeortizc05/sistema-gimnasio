/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.view;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * JFrame VentanaPrincipal
 * Llama a todos los paneles
 * @author Ing. Jorge Luis Ortiz Cáceres
 * @since 31/08/2021
 * @version 0.0.1
 */
public class MainView extends javax.swing.JFrame {

    private CategoryView categoryView;
    private TypePersonView typePersonView;
    private TypeVoucherView typeVoucherView;
    private TypeSuscriptionView typeSuscriptionView;
    private PersonView personView;
    private CheckSuscriptionView checkSuscriptionView;
    
    public MainView() {
        initComponents();
        categoryView = new CategoryView();
        typePersonView = new TypePersonView(personView);
        typeVoucherView = new TypeVoucherView();
        typeSuscriptionView = new TypeSuscriptionView();
        personView = new PersonView();
        checkSuscriptionView = new CheckSuscriptionView(this);
        
        
        jTabbedPane1.add(checkSuscriptionView);
        jTabbedPane1.add(typeSuscriptionView);
        jTabbedPane1.add(personView);
        jTabbedPane1.add(categoryView);
        jTabbedPane1.add(typePersonView);
        jTabbedPane1.add(typeVoucherView);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miCheckSuscription = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miTypePerson = new javax.swing.JMenuItem();
        miPerson = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        miTypeVoucher = new javax.swing.JMenuItem();
        miTypeSuscription = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        miInventario = new javax.swing.JMenu();
        miCategory = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GIMNASIOSOLIZ");
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(new java.awt.CardLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1366, 771));

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1366, 768));
        jScrollPane1.setViewportView(jTabbedPane1);

        getContentPane().add(jScrollPane1, "card2");

        jMenu1.setText("Control Acceso");
        jMenu1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N

        miCheckSuscription.setText("Verificar Suscripción");
        miCheckSuscription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCheckSuscriptionActionPerformed(evt);
            }
        });
        jMenu1.add(miCheckSuscription);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Gestión de Clientes");
        jMenu2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N

        miTypePerson.setText("Tipo de Clientes");
        miTypePerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTypePersonActionPerformed(evt);
            }
        });
        jMenu2.add(miTypePerson);

        miPerson.setText("Clientes");
        miPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPersonActionPerformed(evt);
            }
        });
        jMenu2.add(miPerson);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Caja");
        jMenu3.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N

        miTypeVoucher.setText("Tipo de Comprobante");
        miTypeVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTypeVoucherActionPerformed(evt);
            }
        });
        jMenu3.add(miTypeVoucher);

        miTypeSuscription.setText("Tipo de Suscripción");
        miTypeSuscription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTypeSuscriptionActionPerformed(evt);
            }
        });
        jMenu3.add(miTypeSuscription);

        jMenuItem1.setText("Forma de Pago");
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        miInventario.setText("Inventarios");
        miInventario.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N

        miCategory.setText("Categoría");
        miCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCategoryActionPerformed(evt);
            }
        });
        miInventario.add(miCategory);

        jMenuBar1.add(miInventario);

        jMenu4.setText("Acerca de");
        jMenu4.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCategoryActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedComponent(categoryView);
        categoryView.loadCategories();
        
    }//GEN-LAST:event_miCategoryActionPerformed

    private void miTypePersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTypePersonActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedComponent(typePersonView);
    }//GEN-LAST:event_miTypePersonActionPerformed

    private void miPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPersonActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedComponent(personView);
    }//GEN-LAST:event_miPersonActionPerformed

    private void miTypeSuscriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTypeSuscriptionActionPerformed
        // TODO add your handling code here:
        typeSuscriptionView.loadTypeSuscription();
        jTabbedPane1.setSelectedComponent(typeSuscriptionView);
    }//GEN-LAST:event_miTypeSuscriptionActionPerformed

    private void miTypeVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTypeVoucherActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedComponent(typeVoucherView);
        typeVoucherView.loadTypeVouchers();
    }//GEN-LAST:event_miTypeVoucherActionPerformed

    private void miCheckSuscriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCheckSuscriptionActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedComponent(checkSuscriptionView);
    }//GEN-LAST:event_miCheckSuscriptionActionPerformed

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
    //}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem miCategory;
    private javax.swing.JMenuItem miCheckSuscription;
    private javax.swing.JMenu miInventario;
    private javax.swing.JMenuItem miPerson;
    private javax.swing.JMenuItem miTypePerson;
    private javax.swing.JMenuItem miTypeSuscription;
    private javax.swing.JMenuItem miTypeVoucher;
    // End of variables declaration//GEN-END:variables

}
