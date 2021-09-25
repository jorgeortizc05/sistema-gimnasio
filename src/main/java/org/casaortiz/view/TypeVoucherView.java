/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.view;

import org.casaortiz.view.components.ButtonsColors;
import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.casaortiz.dao.TypeVoucherDao;
import org.casaortiz.model.TypeVoucher;
import org.casaortiz.view.components.TableModels;

/**
 * JPanel TypeVoucherView
 * Para manejar el CRUD de TypeVoucher
 * @author Ing. Jorge Luis Ortiz Cáceres
 * @since 31/08/2021
 * @version 0.0.1
 */
public class TypeVoucherView extends javax.swing.JPanel {

    private TypeVoucherDao typeVoucherDao;
    private TypeVoucher typeVoucher;
    public TypeVoucherView() {
        initComponents();
        typeVoucherDao = new TypeVoucherDao();
        loadTypeVouchers();
        btnSaveChanges.setVisible(false);
        btnDelete.setVisible(false);
        addImageButtons();
    }
    
    private void addImageButtons() {
        btnDelete.setIcon(new ButtonsColors().addIconButton(FileLocation.pathIconBtnDelete));
        btnSave.setIcon(new ButtonsColors().addIconButton(FileLocation.pathIconBtnSave));
        btnCleanForm.setIcon(new ButtonsColors().addIconButton(FileLocation.pathIconBtnClean));
        btnSaveChanges.setIcon(new ButtonsColors().addIconButton(FileLocation.pathIconBtnEdit));
        lblSearch.setIcon(new ButtonsColors().addIconButton(FileLocation.pathIconBtnSearch));
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
        tListTypeVoucher = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        txtTypeVoucher = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnSaveChanges = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCleanForm = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblWarning = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "CATEGORIA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 11))); // NOI18N

        tListTypeVoucher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Categoría", "Descripción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tListTypeVoucher.getTableHeader().setReorderingAllowed(false);
        tListTypeVoucher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tListTypeVoucherMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tListTypeVoucher);
        if (tListTypeVoucher.getColumnModel().getColumnCount() > 0) {
            tListTypeVoucher.getColumnModel().getColumn(0).setResizable(false);
            tListTypeVoucher.getColumnModel().getColumn(0).setPreferredWidth(5);
            tListTypeVoucher.getColumnModel().getColumn(1).setResizable(false);
            tListTypeVoucher.getColumnModel().getColumn(1).setPreferredWidth(300);
            tListTypeVoucher.getColumnModel().getColumn(2).setResizable(false);
            tListTypeVoucher.getColumnModel().getColumn(2).setPreferredWidth(300);
        }

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lblSearch.setPreferredSize(new java.awt.Dimension(30, 30));

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel1.setText("ID:");

        lblID.setPreferredSize(new java.awt.Dimension(5, 20));

        btnSave.setBackground(new java.awt.Color(0, 128, 129));
        btnSave.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnSaveChanges.setBackground(new java.awt.Color(53, 152, 219));
        btnSaveChanges.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnSaveChanges.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveChanges.setText("Guardar Cambios");
        btnSaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangesActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(212, 105, 89));
        btnDelete.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCleanForm.setBackground(new java.awt.Color(252, 246, 214));
        btnCleanForm.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnCleanForm.setText("Limpiar Formulario");
        btnCleanForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanFormActionPerformed(evt);
            }
        });

        lblWarning.setColumns(20);
        lblWarning.setLineWrap(true);
        lblWarning.setRows(5);
        lblWarning.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Advertencia"));
        jScrollPane2.setViewportView(lblWarning);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel2.setText("Tipo de Comprobante:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel3.setText("Descripción:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                            .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTypeVoucher)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveChanges)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCleanForm)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTypeVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnSaveChanges)
                    .addComponent(btnDelete)
                    .addComponent(btnCleanForm))
                .addContainerGap())
            .addComponent(jScrollPane2)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Call TypeVoucherDao.insert()
     * Envia datos para guardar una TypeVoucher
     * @param evt - ActionPerformed: Al hacer clic en btnSave
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        
        
        try {
            if(!txtTypeVoucher.getText().equals("")){
                TypeVoucher cat = new TypeVoucher(txtTypeVoucher.getText(),txtDescription.getText());
                typeVoucherDao.insert(cat);
                JOptionPane.showMessageDialog(btnSave, "Guardado correctamente");
                cleanForm();
                loadTypeVouchers();
            }else{
                lblWarning.setText("TypeVoucher no puede estar vacio");
                lblWarning.setForeground(Color.red);
            }
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(btnSave, "SQLException: Error al guardar: "+ex.toString());
        }catch(Exception e){
           JOptionPane.showMessageDialog(btnSave, "Exception: Error al guardar: "+e.getMessage()); 
        }
    }//GEN-LAST:event_btnSaveActionPerformed
    
    /**
     * Call loadSearchTypeVouchers(txt)
     * Carga datos segun la busqueda
     * @param evt - KeyReleased: despues de escribir en el teclado busca
     */
    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        loadSearchTypeVouchers(txtSearch.getText());
    }//GEN-LAST:event_txtSearchKeyReleased
    
    private void tListTypeVoucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tListTypeVoucherMouseClicked
        // TODO add your handling code here:
        int fila = tListTypeVoucher.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        }else{
            btnDelete.setVisible(true);
            btnSave.setVisible(false);
            btnSaveChanges.setVisible(true);
            try {
                typeVoucher = typeVoucherDao.get(Integer.parseInt(tListTypeVoucher.getValueAt(fila, 0).toString()));
                lblID.setText(String.valueOf(typeVoucher.id()));
                txtTypeVoucher.setText(typeVoucher.name());
                txtDescription.setText(typeVoucher.description());
            } catch (SQLException ex) {
                Logger.getLogger(TypeVoucherView.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error al eliminar: " +ex.getMessage());
            } catch (Exception ex) {
                Logger.getLogger(TypeVoucherView.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error al eliminar: " +ex.getMessage());
            }
            
            
        }
    }//GEN-LAST:event_tListTypeVoucherMouseClicked
    
    /**
     * Call TypeVoucherDao.update(TypeVoucher cat)
     * Envia datos para actualizar una TypeVoucher
     * @param evt - ActionPerformed: Al hacer clic en btnSaveChanges
     */
    private void btnSaveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChangesActionPerformed
        // TODO add your handling code here:
        
        try {
            if(!txtTypeVoucher.getText().equals("")){
                TypeVoucher cat = new TypeVoucher(Integer.parseInt(lblID.getText()),txtTypeVoucher.getText(),txtDescription.getText());
                typeVoucherDao.update(cat);
                JOptionPane.showMessageDialog(btnSave, "Cambios guardados correctamente");
                cleanForm();
                loadTypeVouchers();
            }else{
                lblWarning.setText("TypeVoucher no puede estar vacio");
                lblWarning.setForeground(Color.red);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TypeVoucherView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(btnSave, "Error al guardar los cambios: "+ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(TypeVoucherView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(btnSave, "Error al guardar los cambios: "+ex.getMessage());
        }
    }//GEN-LAST:event_btnSaveChangesActionPerformed
    
   
    /**
     * Limpia el formulario del jPanel
     * @param evt - ActionPerformed: Click en btnCleanForm
     */
    private void btnCleanFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanFormActionPerformed
        // TODO add your handling code here:
        cleanForm();
    }//GEN-LAST:event_btnCleanFormActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            int fila = tListTypeVoucher.getSelectedRow();
            if(fila == -1){
                JOptionPane.showConfirmDialog(tListTypeVoucher, "Debe seleccionar una fila");
            }else{
                int estadoEliminacionDialog = JOptionPane.showConfirmDialog(btnDelete, 
                        "Seguro que desea eliminar "+typeVoucher.name()+" ?",
                        "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(estadoEliminacionDialog == 0){
                    typeVoucherDao.delete(typeVoucher.id());
                    JOptionPane.showMessageDialog(btnDelete, "Se elimino correctamente la TypeVoucher: " + typeVoucher);
                    loadTypeVouchers();
                    cleanForm();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TypeVoucherView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(btnDelete, "Error al eliminar la TypeVoucher: " + typeVoucher +" Error: "+ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(TypeVoucherView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(btnDelete, "Error al eliminar la TypeVoucher: " + typeVoucher +" Error: "+ex.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed
    
    /**
     * Vacia datos del jTable tListTypeVoucher
     */
    private void cleanTable(){
        DefaultTableModel modelo = (DefaultTableModel) tListTypeVoucher.getModel();
        modelo.setRowCount(0);
        tListTypeVoucher.setModel(modelo);
    }
    
    /**
     * Call TypeVoucherDao.getTypeVoucher()
     * Recupera datos TypeVoucher y lo carga al jTable
     */
    public void loadTypeVouchers(){
        try {
            loadTable(typeVoucherDao.getList());
        } catch (Exception ex) {
            Logger.getLogger(TypeVoucherView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al obtener datos de TypeVoucher: " +ex.getMessage());
        }
    }
    
    /**
     * Obtiene datos de TypeVoucherDao.searchTypeVouchers(text) y lo 
     * carga al jTable
     * @param text 
     */
    private void loadSearchTypeVouchers(String text){
        try {
            loadTable(typeVoucherDao.searchList(text));
        } catch (Exception ex) {
            Logger.getLogger(TypeVoucherView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al buscar: " +ex.getMessage());
        }
    }
    
    /**
     * Template para cargar datos al jTable tListTypeVoucher
     * @param List<TypeVoucher>
     */
    private void loadTable(List<TypeVoucher> typeVouchers){
        
        tListTypeVoucher.setModel(TableModels.getModelTypeVoucher(tListTypeVoucher, typeVouchers));
    }
    
    /**
     * Limpia todo el formulario del jPanel
     */
    private void cleanForm(){
        lblID.setText("");
        lblWarning.setText("");
        txtTypeVoucher.setText("");
        txtDescription.setText("");
        btnSave.setVisible(true);
        btnSaveChanges.setVisible(false);
        btnDelete.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCleanForm;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveChanges;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JTextArea lblWarning;
    private javax.swing.JTable tListTypeVoucher;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTypeVoucher;
    // End of variables declaration//GEN-END:variables
}
