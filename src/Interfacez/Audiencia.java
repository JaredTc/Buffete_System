/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfacez;

import buffete.MYSQLConexion;
import buffete.TAsuntos;
import buffete.lugares;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jared
 */
public class Audiencia extends javax.swing.JInternalFrame {
    MYSQLConexion cc = new MYSQLConexion();
Connection con = cc.conexion();

    Calendar hora = new GregorianCalendar();
    /**
     * Creates new form Audiencia
     */
    public Audiencia() {
        initComponents();
        llenarCombox();
        mostrardata();
          jDateChooserHora.setCalendar(hora);
    }

    
    public void mostrardata(){
        DefaultTableModel data = new DefaultTableModel();
        data.addColumn("ID Audiencia");
        data.addColumn("ID Lugar");
        data.addColumn("Fecha");
        data.addColumn("Hora");
        data.addColumn("Resolucion");
        data.addColumn("ID Asunto");
        jTable1.setModel(data);
        
        String []datos = new String[6];
        
        try {
            String sql = ("SELECT * from audiencia");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {                
                 datos[0] = rs.getString("id_audiencia");
                datos[1] = rs.getString("id_lugar");
                datos[2] = rs.getString("fecha");
                datos[3] = rs.getString("hora");
                datos[4] = rs.getString("resolucion");
                datos[5] = rs.getString("id_asunto");
                data.addRow(datos);
   
                
            }
            
            jTable1.setModel(data);
        } catch (Exception e) {
        }
        
    }
     public void llenarCombox(){
      MYSQLConexion Tipos_lugar = new MYSQLConexion();
        ArrayList<lugares> lugares= Tipos_lugar.Lugares();
        for (int i = 0; i < lugares.size(); i++) {
            jComboBoxLugar.addItem(
            new lugares(lugares.get(i).getId(), lugares.get(i).getDescripcion())
            );
        }
        MYSQLConexion.conexion();
        ArrayList<String> asuntoII = new ArrayList<String>();
        asuntoII = MYSQLConexion.llenar_Asunto();
        for (int i = 0; i < asuntoII.size(); i++) {
            jComboBoxAsunto.addItem(asuntoII.get(i));
        }
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
     
     public void Registrar(){
         try {
             PreparedStatement pst = con.prepareStatement("INSERT INTO audiencia (id_lugar, fecha, hora, resolucion, id_asunto) VALUES (?,?,?,?,?)");
               pst.setString(1, (String) jComboBoxAsunto.getSelectedItem());
               pst.setString(2, ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText());
                pst.setString(3, ((JTextField)jDateChooserHora.getDateEditor().getUiComponent()).getText() );
                pst.setString(4,    resolucion.getText().trim());
                 pst.setString(5, (String) Integer.toString(jComboBoxLugar.getItemAt(jComboBoxLugar.getSelectedIndex()).getId()));
                pst.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Registro Exitoso");
         } catch (Exception e) {
         }
      mostrardata();
     }
     
     public void borrar(){
         try {
            MYSQLConexion conex = new MYSQLConexion();
            conex.conexion();
            String ide = jTable1.getValueAt(jTable1.getSelectedRow(),0).toString();
            String slq = "DELETE FROM audiencia WHERE id_audiencia='" + ide +"'";
           conex.sentencia.execute(slq);
           
           
           JOptionPane.showMessageDialog(null, "Registro Eliminado");

        } catch (Exception e) {
        }
         
     mostrardata();
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxLugar = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooserHora = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        resolucion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxAsunto = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Audiencia");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("ID Asunto");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jPanel1.add(jComboBoxLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 160, 30));

        jDateChooser1.setDateFormatString("yyyy/MM/d");
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 140, -1));

        jDateChooserHora.setDateFormatString("HH:mm:ss");
        jPanel1.add(jDateChooserHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 130, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Fecha");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));
        jPanel1.add(resolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 140, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Hora");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, -1, -1));

        jPanel1.add(jComboBoxAsunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 120, 30));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Resolucion");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 490, 160));

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 120, -1));

        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/016-delete 1.png"))); // NOI18N
        jButton2.setText("Eliminar");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 120, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Audiencia");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("ID Lugar");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Registrar();
        resolucion.setText("");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        borrar();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxAsunto;
    private javax.swing.JComboBox<lugares> jComboBoxLugar;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooserHora;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField resolucion;
    // End of variables declaration//GEN-END:variables
}
