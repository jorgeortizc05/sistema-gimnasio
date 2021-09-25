/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.view;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.casaortiz.dao.SuscriptionDao;
import org.casaortiz.dao.TypeSuscriptionDao;
import org.casaortiz.model.Person;
import org.casaortiz.model.Suscription;
import org.casaortiz.model.TypeSuscription;
import org.casaortiz.view.components.TableModels;

/**
 *
 * @author jorge
 */
public class SuscriptionViewJD extends javax.swing.JDialog {

    private Person person;
    private TypeSuscriptionDao typeSuscriptionDao;
    private SuscriptionDao suscriptionDao;
    List<Suscription> suscriptions = null;
    public SuscriptionViewJD(java.awt.Frame parent, boolean modal, Person _person) {
        super(parent, modal);
        try {
            initComponents();
            typeSuscriptionDao = new TypeSuscriptionDao();
            suscriptionDao = new SuscriptionDao();
            person = _person;
            lblNames.setText(person.firstName() + " " + person.lastName());
            lblIdentificationId.setText(person.identificationId());
            txtReceipt_number.setText(String.valueOf(suscriptionDao.getDateMaxReceiptNumber()+1));
            loadTypeSuscription();
            loadSuscriptionFromPerson();
        } catch (Exception ex) {
            Logger.getLogger(SuscriptionViewJD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadSuscriptionFromPerson() {
        try {
            suscriptions = suscriptionDao.getListSuscriptionFromPerson(person);
            loadTable(suscriptions);
        } catch (Exception ex) {
            Logger.getLogger(SuscriptionViewJD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al obtener datos de suscripciones de las personas: " + ex.getMessage());
        }
    }

    private void loadTable(List<Suscription> suscription) {

        tSuscription.setModel(TableModels.getModelSuscription(tSuscription, suscription));
    }

    public void loadTypeSuscription() {
        try {
            var items = typeSuscriptionDao.getList();
            for (TypeSuscription i : items) {
                cbTypeSuscription.addItem(i);
            }
        } catch (Exception ex) {
            Logger.getLogger(SuscriptionViewJD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(tSuscription, "Error al cargar tipo de suscripciones: " + ex.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tSuscription = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtReceipt_number = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDiscount = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtComment = new javax.swing.JTextField();
        dDateFrom = new rojeru_san.componentes.RSDateChooser();
        dDateTo = new rojeru_san.componentes.RSDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbTypeSuscription = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        lblIdentificationId = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblNames = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblDays = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Historial Suscripciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 11))); // NOI18N

        tSuscription.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Fecha Desde", "Fecha Hasta", "Importe Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tSuscription);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Suscripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 11))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel1.setText("No. Recibo");

        txtReceipt_number.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel2.setText("Tipo Suscripción");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel3.setText("Fecha Desde:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel4.setText("Fecha Hasta:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel5.setText("Precio:");

        txtPrice.setEditable(false);
        txtPrice.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel6.setText("Descuento:");

        txtDiscount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDiscount.setText("0.00");
        txtDiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDiscountKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel7.setText("Importe Total:");

        txtTotal.setEditable(false);
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel8.setText("Observaciones:");

        dDateFrom.setColorBackground(new java.awt.Color(0, 0, 0));
        dDateFrom.setColorForeground(new java.awt.Color(0, 0, 0));
        dDateFrom.setFormatoFecha("dd/MM/yyyy");
        dDateFrom.setPlaceholder("");
        dDateFrom.setPreferredSize(new java.awt.Dimension(240, 19));
        dDateFrom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                dDateFromMouseReleased(evt);
            }
        });

        dDateTo.setColorBackground(new java.awt.Color(0, 0, 0));
        dDateTo.setColorForeground(new java.awt.Color(0, 0, 0));
        dDateTo.setFormatoFecha("dd/MM/yyyy");
        dDateTo.setPlaceholder("");
        dDateTo.setPreferredSize(new java.awt.Dimension(240, 19));

        jLabel9.setText("$");

        jLabel10.setText("$");

        jLabel11.setText("$");

        cbTypeSuscription.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTypeSuscriptionItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtComment)
                    .addComponent(txtReceipt_number)
                    .addComponent(dDateFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dDateTo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(txtDiscount, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(cbTypeSuscription, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtReceipt_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbTypeSuscription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(dDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(dDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtComment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(220, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 11))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel12.setText("Cédula:");

        lblIdentificationId.setPreferredSize(new java.awt.Dimension(0, 19));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel14.setText("Nombres:");

        lblNames.setPreferredSize(new java.awt.Dimension(0, 19));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel16.setText("Días Disponibles:");

        lblDays.setPreferredSize(new java.awt.Dimension(0, 19));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIdentificationId, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNames, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDays, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblIdentificationId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(lblNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(lblDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSave.setBackground(new java.awt.Color(0, 128, 129));
        btnSave.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(203, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbTypeSuscriptionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTypeSuscriptionItemStateChanged
        // TODO add your handling code here:
        var item = (TypeSuscription) cbTypeSuscription.getSelectedItem();
        txtPrice.setText(String.valueOf(item.getPrice()));
        var dateFrom = new Date();
        //Validaciones para facilitar al usuario al suscribirse con la fecha y
        //suma la fecha segun el elemento seleccionado en el tipo de suscripcion
        //Si el campo dDateFrom esta vacio pone la de hoy o el max
        if (dDateFrom.getDatoFecha() == null) {
            try {
                //Si no tiene suscripciones de la persona pone la fecha de hoy
                if(suscriptions == null){
                    dDateFrom.setDatoFecha(dateFrom);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(dateFrom);
                    calendar.add(Calendar.DAY_OF_YEAR, item.getNum_days());//sumo los dias desde la fecha de hoy
                    Date dateTo = calendar.getTime();
                    dDateTo.setDatoFecha(dateTo);
                }else{//caso contrario pone la fecha maxima de las suscripciones de la persona
                    Date fechaMaxima = suscriptionDao.getDateMaxFromPerson(person.id());
                    dDateFrom.setDatoFecha(fechaMaxima);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(fechaMaxima);
                    calendar.add(Calendar.DAY_OF_YEAR, item.getNum_days());//sumo los dias desde la fecha de hoy
                    Date dateTo = calendar.getTime();
                    dDateTo.setDatoFecha(dateTo);
                }
                
               
            } catch (Exception ex) {
                Logger.getLogger(SuscriptionViewJD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {//recupera la fecha del campo dDateFrom e incrementa
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dDateFrom.getDatoFecha());
            calendar.add(Calendar.DAY_OF_YEAR, item.getNum_days());//sumo los dias desde la fecha de hoy
            Date dateTo = calendar.getTime();
            dDateTo.setDatoFecha(dateTo);
        }

        calculateTotal();
    }//GEN-LAST:event_cbTypeSuscriptionItemStateChanged

    private void txtDiscountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiscountKeyReleased
        // TODO add your handling code here:
        if (txtDiscount.getText().equals("")) {
            txtDiscount.setText("0.00");
            calculateTotal();
        } else {
            calculateTotal();
        }

    }//GEN-LAST:event_txtDiscountKeyReleased

    private void dDateFromMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dDateFromMouseReleased
        // TODO add your handling code here:
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dDateFrom.getDatoFecha());
        calendar.add(Calendar.DAY_OF_YEAR, 7);//sumo los dias desde la fecha de hoy
        Date dateTo = calendar.getTime();
        dDateTo.setDatoFecha(dateTo);

        System.out.println("cambio");
    }//GEN-LAST:event_dDateFromMouseReleased

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:

        try {
            var suscription = new Suscription();
            suscription.setReceipt_number(txtReceipt_number.getText());
            suscription.setDateSuscription(new Date());
            suscription.setDateFrom(dDateFrom.getDatoFecha());
            suscription.setDateTo(dDateTo.getDatoFecha());
            suscription.setPrice(Double.parseDouble(txtPrice.getText()));
            suscription.setDiscount(Double.parseDouble(txtDiscount.getText()));
            suscription.setTotal(Double.parseDouble(txtTotal.getText()));
            suscription.setComment(txtComment.getText());
            suscription.setPersonId(person.id());

            TypeSuscription ts = (TypeSuscription) cbTypeSuscription.getSelectedItem();
            suscription.setTypeSuscriptionId(ts.getId());

            suscriptionDao.insert(suscription);
            JOptionPane.showMessageDialog(btnSave, "Guardado correctamente");
            cleanForm();
            loadSuscriptionFromPerson();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(btnSave, "SQLException: Error al guardar: " + ex.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(btnSave, "Exception: Error al guardar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cleanForm() {
        txtReceipt_number.setText("");
        dDateFrom.setDatoFecha(null);
        dDateTo.setDatoFecha(null);
        txtPrice.setText("0.00");
        txtDiscount.setText("0.00");
        txtTotal.setText("0.00");
        txtComment.setText("");
    }

    private void calculateTotal() {
        try {
            double total = Double.parseDouble(txtPrice.getText()) - Double.parseDouble(txtDiscount.getText());
            txtTotal.setText(total + "");
        } catch (Exception e) {
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<TypeSuscription> cbTypeSuscription;
    private rojeru_san.componentes.RSDateChooser dDateFrom;
    private rojeru_san.componentes.RSDateChooser dDateTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDays;
    private javax.swing.JLabel lblIdentificationId;
    private javax.swing.JLabel lblNames;
    private javax.swing.JTable tSuscription;
    private javax.swing.JTextField txtComment;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtReceipt_number;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
