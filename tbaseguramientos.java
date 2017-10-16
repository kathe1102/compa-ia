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
public class tbaseguramientos extends javax.swing.JFrame {

    conexionaseg con=new conexionaseg();
    Connection cnn=con.Conexionasebd();
    PreparedStatement ps=null;
    ResultSet rs=null;
    public tbaseguramientos() {
        initComponents();
        tablaaseguramientos();
        cargarcombo();
    }
    
     public void tablaaseguramientos(){
     DefaultTableModel tabla=new DefaultTableModel ();
      tabla.addColumn("CODIGO ");
      tabla.addColumn("FECHA INICIO  ");
      tabla.addColumn("FECHA EXPEDICION  ");
      tabla.addColumn("VALOR ASEGURADO  ");
      tabla.addColumn("ESTADO  ");
      tabla.addColumn("COSTO ");
      tabla.addColumn("PLACA ");
      
     ase.setModel(tabla);
      String datos[]=new String[7];
      tabla.addRow(datos);
      
       try {
       ps=cnn.prepareStatement("SELECT *FROM Aseguramientos");
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
          ps=cnn.prepareStatement("INSERT INTO  Aseguramientos(Ase_codigo,Ase_fecha_inicio ,Ase_fecha_expiracion, Ase_valor_asegurado , Ase_estado,Ase_costo,Ase_placa )VALUES(?,?,?,?,?,?,?)");  
         ps.setInt(1,Integer.parseInt(jTextFieldCOD.getText()));
              ps.setString(2,jTextFieldFECHAINI.getText());
              ps.setString(3,jTextFieldFECHAEXP.getText());
              ps.setInt(4,Integer.parseInt(jTextFieldVALORASEG.getText()));
             ps.setString(5,jTextFieldESTADO.getText());
              ps.setInt(6,Integer.parseInt(jTextFieldCOSTO.getText()));
               ps.setString(7,placa.getSelectedItem().toString());
             ps.executeUpdate();
             JOptionPane.showMessageDialog(null,"Datos Guardados");
             
        } catch (Exception e) {
            System.out.println("eee"+e);
        }
         
    }
     public void eliminar(String dat){
         try {
          ps=cnn.prepareStatement("DELETE from aseguramientos where ase_codigo ='"+dat+"'"); 
          ps.executeUpdate();
           JOptionPane.showMessageDialog(null,"Datos Eliminados");
         } catch (Exception e) {
           System.out.println("eee"+e); 
         }
        
         
     }
     public void modificar(String cod,String fechaini,String fechaex,String valorase,String es,String costo,String pla){
         try {
          ps=cnn.prepareStatement("UPDATE aseguramientos set Ase_fecha_inicio='"+fechaini+"',Ase_fecha_expiracion='"+fechaex+"', Ase_valor_asegurado='"+valorase+"' , Ase_estado='"+es+"' , Ase_costo='"+costo+"' , Ase_placa='"+pla+"' where Ase_codigo  ='"+cod+"'");  
          ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos modificados");
            
        } catch (Exception e) {
         System.out.println("eee"+e);  
        }
     
               
     
     
     }
      public void cargarcombo(){
        try {
           placa.removeAll();
           placa.addItem("SELECCIONE PLACA");
          ps=cnn.prepareStatement("Select auto_placa from Automotores ");
          rs=ps.executeQuery();
         while(rs.next()){
             String aux=rs.getString("auto_placa");
             this.placa.addItem(aux);
         }
  
        } catch (Exception e) {
        }
      }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ase = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldFECHAINI = new javax.swing.JTextField();
        jButton = new javax.swing.JButton();
        jButtonELIMINAR = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldFECHAEXP = new javax.swing.JTextField();
        jTextFieldVALORASEG = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldESTADO = new javax.swing.JTextField();
        jTextFieldCOSTO = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextFieldCOD = new javax.swing.JTextField();
        placa = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 204));
        getContentPane().setLayout(null);

        ase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(ase);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(43, 324, 600, 174);

        jButton1.setText("INCIDENTES");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(520, 500, 130, 50);

        jLabel2.setText("CODIGO");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 34, 100, 20);

        jLabel3.setText("VALOR ASEGURADO");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 124, 150, 20);

        jTextFieldFECHAINI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFECHAINIActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldFECHAINI);
        jTextFieldFECHAINI.setBounds(200, 60, 120, 20);

        jButton.setText("REGISTRAR");
        jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionPerformed(evt);
            }
        });
        getContentPane().add(jButton);
        jButton.setBounds(40, 273, 120, 40);

        jButtonELIMINAR.setText("ELIMINAR");
        jButtonELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonELIMINARActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonELIMINAR);
        jButtonELIMINAR.setBounds(190, 273, 110, 40);

        jButton4.setText("LIMPIAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(520, 273, 100, 40);

        jLabel4.setText("FECHA INICIO");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 64, 130, 20);

        jLabel5.setText("FECHA EXPEDICION");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 94, 140, 20);

        jTextFieldFECHAEXP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFECHAEXPActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldFECHAEXP);
        jTextFieldFECHAEXP.setBounds(200, 90, 120, 20);

        jTextFieldVALORASEG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldVALORASEGActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldVALORASEG);
        jTextFieldVALORASEG.setBounds(200, 120, 120, 20);

        jLabel1.setText("ESTADO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 154, 70, 20);

        jTextFieldESTADO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldESTADOActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldESTADO);
        jTextFieldESTADO.setBounds(200, 150, 120, 20);
        getContentPane().add(jTextFieldCOSTO);
        jTextFieldCOSTO.setBounds(200, 190, 130, 20);

        jLabel6.setText("TABLA ASEGURAMIENTOS");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(150, 0, 150, 14);

        jLabel7.setText("PLACA");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(40, 224, 60, 20);
        getContentPane().add(jLabel8);
        jLabel8.setBounds(200, 240, 0, 0);

        jLabel9.setText("COSTO");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(40, 194, 100, 20);

        jButton2.setText("MODIFICAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(330, 273, 130, 40);

        jTextFieldCOD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCODActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldCOD);
        jTextFieldCOD.setBounds(200, 30, 120, 20);

        getContentPane().add(placa);
        placa.setBounds(200, 220, 140, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     tbincidentes op=new tbincidentes();
     op.setLocationRelativeTo(null);
       op.setVisible(true);
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActionPerformed
    registrar();
    tablaaseguramientos();
    }//GEN-LAST:event_jButtonActionPerformed

    private void jTextFieldFECHAEXPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFECHAEXPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFECHAEXPActionPerformed

    private void jButtonELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonELIMINARActionPerformed
        String dat=jTextFieldCOD.getText();
        eliminar(dat);
        tablaaseguramientos();
    
    }//GEN-LAST:event_jButtonELIMINARActionPerformed

    private void jTextFieldESTADOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldESTADOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldESTADOActionPerformed

    private void jTextFieldVALORASEGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldVALORASEGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldVALORASEGActionPerformed

    private void jTextFieldFECHAINIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFECHAINIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFECHAINIActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    jTextFieldCOD.setText(null);
    jTextFieldFECHAINI.setText(null);
    jTextFieldFECHAEXP.setText(null);
    jTextFieldVALORASEG.setText(null);
    jTextFieldCOSTO.setText(null);
    jTextFieldESTADO.setText(null);
    placa.removeAllItems();
        cargarcombo();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      String c,fi,fex,vase,es,cos,pl;
      c=jTextFieldCOD.getText();
      fi=jTextFieldFECHAINI.getText();
      fex=jTextFieldFECHAEXP.getText();
      vase=jTextFieldVALORASEG.getText();
      es=jTextFieldESTADO.getText();
      cos=jTextFieldCOSTO.getText();
      pl=placa.getSelectedItem().toString();
     modificar(c, fi,fex, vase, es, cos, pl);
     tablaaseguramientos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextFieldCODActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCODActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCODActionPerformed

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
            java.util.logging.Logger.getLogger(tbaseguramientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tbaseguramientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tbaseguramientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tbaseguramientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tbaseguramientos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ase;
    private javax.swing.JButton jButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonELIMINAR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldCOD;
    private javax.swing.JTextField jTextFieldCOSTO;
    private javax.swing.JTextField jTextFieldESTADO;
    private javax.swing.JTextField jTextFieldFECHAEXP;
    private javax.swing.JTextField jTextFieldFECHAINI;
    private javax.swing.JTextField jTextFieldVALORASEG;
    private javax.swing.JComboBox<String> placa;
    // End of variables declaration//GEN-END:variables
}
