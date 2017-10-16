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

/**
 *
 * @author admin
 */
public class LoginAse extends javax.swing.JFrame {
    conexionaseg con=new conexionaseg();
    Connection cnn=con.Conexionasebd();
    public LoginAse() {
        initComponents();
    }

   public void validausuario(String us,String cla){
       PreparedStatement op=null;
        ResultSet rs=null;
        try {
            op=cnn.prepareStatement("SELECT *FROM compañia WHERE usuario='"+us+"'AND clave ='"+cla+"'");
        rs=op.executeQuery();
        if(rs.next()){  
          tbcompañia ca=new tbcompañia();
          ca.setVisible(true);
          dispose();
        }
         else{
          JOptionPane.showMessageDialog(null,"Datos no Validos"); 
           }
        } catch (Exception e) {
         System.out.print("Error"+e);   
        }
       }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldusu = new javax.swing.JTextField();
        jTextFieldcontra = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("ACCESO AL SISTEMA");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(125, 11, 102, 14);

        jLabel2.setText("USUARIO");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 89, 80, 14);

        jLabel3.setText("CONTRASEÑA");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 160, 80, 14);

        jTextFieldusu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldusuActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldusu);
        jTextFieldusu.setBounds(140, 80, 70, 20);

        jTextFieldcontra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldcontraActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldcontra);
        jTextFieldcontra.setBounds(140, 150, 70, 20);

        jButton1.setText("INGRESO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(140, 210, 77, 23);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 0, 0);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/wallpaper_roto2[1].jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 420, 330);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldcontraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldcontraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldcontraActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String u,c;
     u=jTextFieldusu.getText();
       c=jTextFieldcontra.getText();
        validausuario(u, c); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldusuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldusuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldusuActionPerformed

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
            java.util.logging.Logger.getLogger(LoginAse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginAse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginAse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginAse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginAse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextFieldcontra;
    private javax.swing.JTextField jTextFieldusu;
    // End of variables declaration//GEN-END:variables

    }
