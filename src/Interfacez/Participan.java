/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfacez;

import buffete.MYSQLConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jared
 */
public class Participan extends javax.swing.JInternalFrame {
    
    MYSQLConexion cc = new MYSQLConexion();
    Connection con = cc.conexion();


    /**
     * Creates new form Participan
     */
    public Participan() {
        initComponents();
        llenarcombo();
    }
    
    public void llenarcombo(){
     MYSQLConexion.conexion();
        ArrayList<String> asuntoII = new ArrayList<String>();
        asuntoII = MYSQLConexion.llenar_Audiencia();
        for (int i = 0; i < asuntoII.size(); i++) {
            jComboBoxAudiencia.addItem(asuntoII.get(i));
        }
     MYSQLConexion.conexion();
        ArrayList<String> asunto = new ArrayList<String>();
        asunto = MYSQLConexion.llenar_Gente();
        for (int i = 0; i < asunto.size(); i++) {
            jComboBoxPersona.addItem(asunto.get(i));
        }
    }
    
    public void registrar(){
        try {
             PreparedStatement pst = con.prepareStatement("INSERT INTO participan (id_audiencia, id_gente) VALUES (?,?)");
              pst.setString(1, (String) jComboBoxAudiencia.getSelectedItem());
               pst.setString(2, (String) jComboBoxPersona.getSelectedItem());
               pst.executeUpdate();
               
               JOptionPane.showMessageDialog(null, "Registro Exitoso");
        } catch (Exception e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxAudiencia = new javax.swing.JComboBox<>();
        jComboBoxPersona = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Participan");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Jurado / Personas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        jPanel1.add(jComboBoxAudiencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 130, 40));

        jPanel1.add(jComboBoxPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 130, 40));

        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/003-add 1.png"))); // NOI18N
        jButton1.setText("Registrar");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 130, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("ID Persona");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("ID Audiencia");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        registrar();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxAudiencia;
    private javax.swing.JComboBox<String> jComboBoxPersona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}