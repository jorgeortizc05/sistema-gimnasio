/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.view;

import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public MainView() {
        initComponents();
        categoryView = new CategoryView();
        typePersonView = new TypePersonView();
        typeVoucherView = new TypeVoucherView();
        typeSuscriptionView = new TypeSuscriptionView();
        personView = new PersonView();
        jTabbedPane1.add(categoryView);
        jTabbedPane1.add(typePersonView);
        jTabbedPane1.add(typeVoucherView);
        jTabbedPane1.add(typeSuscriptionView);
        jTabbedPane1.add(personView);
        
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
        miInventario = new javax.swing.JMenu();
        miCategoria = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miTypePerson = new javax.swing.JMenuItem();
        miClientes = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        miTypeVoucher = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GIMNASIOSOLIZ");
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setPreferredSize(new java.awt.Dimension(1366, 768));

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jScrollPane1.setViewportView(jTabbedPane1);

        miInventario.setText("Inventarios");

        miCategoria.setText("Categoría");
        miCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCategoriaActionPerformed(evt);
            }
        });
        miInventario.add(miCategoria);

        jMenuBar1.add(miInventario);

        jMenu2.setText("Clientes");

        miTypePerson.setText("Tipo de Clientes");
        miTypePerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTypePersonActionPerformed(evt);
            }
        });
        jMenu2.add(miTypePerson);

        miClientes.setText("Clientes");
        miClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miClientesActionPerformed(evt);
            }
        });
        jMenu2.add(miClientes);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ventas");

        miTypeVoucher.setText("Tipo de Comprobante");
        miTypeVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTypeVoucherActionPerformed(evt);
            }
        });
        jMenu3.add(miTypeVoucher);

        jMenuItem1.setText("Tipo de Suscripción");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1361, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCategoriaActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedComponent(categoryView);
        
    }//GEN-LAST:event_miCategoriaActionPerformed

    private void miTypePersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTypePersonActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedComponent(typePersonView);
    }//GEN-LAST:event_miTypePersonActionPerformed

    private void miTypeVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTypeVoucherActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedComponent(typeVoucherView);
    }//GEN-LAST:event_miTypeVoucherActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        typeSuscriptionView.loadTypeSuscription();
        jTabbedPane1.setSelectedComponent(typeSuscriptionView);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void miClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miClientesActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedComponent(personView);
    }//GEN-LAST:event_miClientesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
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
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                        // Set cross-platform Java L&F (also called "Metal")
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                } 
                catch (UnsupportedLookAndFeelException e) {
                   // handle exception
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                }
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem miCategoria;
    private javax.swing.JMenuItem miClientes;
    private javax.swing.JMenu miInventario;
    private javax.swing.JMenuItem miTypePerson;
    private javax.swing.JMenuItem miTypeVoucher;
    // End of variables declaration//GEN-END:variables
}
