/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aseguradora;

import controladror.conexionaseg;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class tbautomotores extends javax.swing.JFrame {

    conexionaseg con=new conexionaseg();
    Connection cnn=con.Conexionasebd();
    PreparedStatement ps=null;
    ResultSet rs=null;
    public tbautomotores() {
        initComponents();
        tablaautomotor();
        cargarcombo();
   }
     public void tablaautomotor(){
     DefaultTableModel tabla=new DefaultTableModel ();
      tabla.addColumn(" PLACA");
      tabla.addColumn("MARCA ");
      tabla.addColumn(" TIPO");
      tabla.addColumn("MODELO ");
      tabla.addColumn("NUMERO DE PASAJEROS ");
      tabla.addColumn("CILINDRAJE ");
      tabla.addColumn("NUMERO CHASIS ");
      automo.setModel(tabla);
      String datos[]=new String[7];
      tabla.addRow(datos);
      
       try {
       ps=cnn.prepareStatement("SELECT *FROM AUTOMOTORES");
        rs=ps.executeQuery();
        while (rs.next()){
         datos[0]=rs.getString(1);
         datos[1]=rs.getString(2);
         datos[2]=rs.getString(3);
         datos[3]=rs.getString(4);
         datos[4]=rs.getString(5);
         datos[5]=rs.getString(6);
         datos[6]=rs.getString(7);

       tabla.addRow(datos);
        }
       } catch (Exception e) {
        System.out.print(e);

    
       }
     }
    
    
     public void registrar(){
         try {
          ps=cnn.prepareStatement("INSERT INTO AUTOMOTORES (auto_placa , Auto_marca , Auto_tipo , Auto_modelo , Auto_num_pasajeros , Auto_cilindraje , Auto_numchasis )VALUES(?,?,?)");  
          ps.setString(1,jComboBoxplaca.getSelectedItem().toString());
          ps.setString(2,jTextFieldAMARCA.getText());
          ps.setString(3,jTextFieldTIPO.getText());
          ps.setString(4,jTextFieldMODELO.getText());
          ps.setString(5,jTextFieldNUMPASAJ.getText());
          ps.setString(6,jTextFieldCILINDRA.getText());
          ps.setString(7,jTextFieldNUMCHASIS.getText());
          ps.executeUpdate();
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"DATOS GUARDADOS");
             
         }
    }
     public void eliminar(String dat){
         try {
          ps=cnn.prepareStatement("DELETE from AUTOMOTORES where auto_placa ='"+dat+"'"); 
          ps.executeUpdate();
          JOptionPane.showMessageDialog(rootPane, dat);
         } catch (Exception e) {
         }
        
         
     }
    public void modificar ( String plac,String mar,String tipo,String mode,String nump,String cilin,String numcha){
         
        try {
           ps=cnn.prepareStatement("UPDATE automotores set automotores=marca='"+mar+"',tip='"+tipo+"',modelo='"+mode+"',numeropas='"+nump+"',cilindraje='"+cilin+"' where auto_placa='"+plac+"'"); 
          ps.setString(1,jComboBoxplaca.getSelectedItem().toString());
          ps.setString(2,jTextFieldAMARCA.getText());
          ps.setString(3,jTextFieldTIPO.getText());
          ps.setString(4,jTextFieldMODELO.getText());
          ps.setString(5,jTextFieldNUMPASAJ.getText());
          ps.setString(6,jTextFieldCILINDRA.getText());
          ps.setString(7,jTextFieldNUMCHASIS.getText());
          rs=ps.executeQuery();    
        } catch (Exception e) {
             
        }
        
    
    }
    public void cargarcombo(){
         try {
           jComboBoxplaca.removeAll();
            jComboBoxplaca.addItem("seleccione la placa");
          ps=cnn.prepareStatement("select automotores Ase_placa from automotores");
          rs=ps.executeQuery(); 
          while(rs.next()){
              String aux=rs.getString("Ase_codigo");
              this.jComboBoxplaca.addItem(aux); 
          }
         } catch (Exception e) {
         }
    
               
     
     
     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        automo = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextFieldAMARCA = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldMODELO = new javax.swing.JTextField();
        jTextFieldNUMPASAJ = new javax.swing.JTextField();
        jTextFieldCILINDRA = new javax.swing.JTextField();
        jTextFieldNUMCHASIS = new javax.swing.JTextField();
        jTextFieldTIPO = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jComboBoxplaca = new javax.swing.JComboBox<>();

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jRadioButton1.setText("jRadioButton1");

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        automo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(automo);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(12, 290, 640, 170);

        jButton1.setText("TIPO AUTOMOTORES");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(480, 490, 180, 46);

        jTextFieldAMARCA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAMARCAActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldAMARCA);
        jTextFieldAMARCA.setBounds(180, 90, 120, 20);

        jLabel2.setText("PLACA");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 70, 70, 14);

        jLabel1.setText("MARCA");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 90, 52, 30);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(41, 87, 0, 0);

        jLabel4.setText("TIPO");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 140, 24, 14);

        jLabel5.setText("MODELO");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 170, 60, 14);

        jLabel6.setText("NUMERO DE PASAJEROS");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 200, 120, 14);

        jLabel7.setText("CILINDRAJE");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(40, 230, 80, 10);

        jLabel8.setText("NUMERO CHASIS");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(40, 260, 100, 14);

        jTextFieldMODELO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMODELOActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldMODELO);
        jTextFieldMODELO.setBounds(180, 160, 120, 20);

        jTextFieldNUMPASAJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNUMPASAJActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNUMPASAJ);
        jTextFieldNUMPASAJ.setBounds(180, 200, 120, 20);
        getContentPane().add(jTextFieldCILINDRA);
        jTextFieldCILINDRA.setBounds(180, 230, 130, 20);
        getContentPane().add(jTextFieldNUMCHASIS);
        jTextFieldNUMCHASIS.setBounds(180, 260, 120, 20);
        getContentPane().add(jTextFieldTIPO);
        jTextFieldTIPO.setBounds(180, 130, 120, 20);

        jLabel9.setText("TABLA AUTOMOTORES");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(210, 0, 150, 14);

        jButton2.setText("REGISTRAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(450, 60, 140, 23);

        jButton3.setText("MODIFICAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(450, 100, 140, 23);

        jButton4.setText("ELIMINAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(450, 140, 140, 23);

        jButton5.setText("LIMPIAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(450, 180, 140, 23);

        getContentPane().add(jComboBoxplaca);
        jComboBoxplaca.setBounds(180, 50, 110, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     tbtipoautomotores op=new tbtipoautomotores();
      op.setLocationRelativeTo(null);
       op.setVisible(true);
       dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextFieldAMARCAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAMARCAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAMARCAActionPerformed

    private void jTextFieldMODELOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMODELOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMODELOActionPerformed

    private void jTextFieldNUMPASAJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNUMPASAJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNUMPASAJActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      registrar();
      tablaautomotor();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     String pl,ma,ti,mo,numpa,ci,numch;
      pl=jComboBoxplaca.getSelectedItem().toString();
      ma=jTextFieldAMARCA.getText();
      ti=jTextFieldTIPO.getText();
      mo=jTextFieldMODELO.getText();
      numpa=jTextFieldNUMPASAJ.getText();
      ci=jTextFieldCILINDRA.getText();
      numch=jTextFieldNUMCHASIS.getText();
      modificar(pl, ma, ti, mo, numpa, ci, numch);
       tablaautomotor();
      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       String dat=jComboBoxplaca.getSelectedItem().toString();
        eliminar(dat);
        tablaautomotor();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(tbautomotores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tbautomotores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tbautomotores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tbautomotores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tbautomotores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable automo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBoxplaca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldAMARCA;
    private javax.swing.JTextField jTextFieldCILINDRA;
    private javax.swing.JTextField jTextFieldMODELO;
    private javax.swing.JTextField jTextFieldNUMCHASIS;
    private javax.swing.JTextField jTextFieldNUMPASAJ;
    private javax.swing.JTextField jTextFieldTIPO;
    // End of variables declaration//GEN-END:variables
}
