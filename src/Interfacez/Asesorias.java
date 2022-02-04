/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfacez;

import buffete.Abogatos;
import buffete.MYSQLConexion;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Jared
 */
public class Asesorias extends javax.swing.JInternalFrame {
    Calendar hora = new GregorianCalendar();
    MYSQLConexion cc = new MYSQLConexion();
    Connection con = cc.conexion();

    /**
     * Creates new form Asesorias
     */
    public Asesorias() {
        initComponents();
        llenarcombox();
        mostrarAsesora();
        
        
        jDateChooserHora.setCalendar(hora);
        
        
//        Date date = new Date();
//        SpinnerDateModel sm =
//         new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
//        jSpinner1 = new javax.swing.JSpinner(sm);
//        jSpinner2 = new javax.swing.JSpinner();
//        JSpinner.DateEditor de = new JSpinner.DateEditor(jSpinner1, "HH:mm:ss");
//        jSpinner1.setEditor(de);

   
        

    }

    public void mostrarAsesora() {
        DefaultTableModel asesora = new DefaultTableModel();
        asesora.addColumn("id_asesoria");
        asesora.addColumn("Asesor");
        asesora.addColumn("Asesorado");
        asesora.addColumn("Asunto");
        asesora.addColumn("Tema");
        asesora.addColumn("Hora");
        asesora.addColumn("Fecha");

        jTableAsesora.setModel(asesora);
        String[] Asesora = new String[7];
        try {
            String sql = ("SELECT * from asesora");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Asesora[0] = rs.getString("id_asesoria");
                Asesora[1] = rs.getString("asesor");
                Asesora[2] = rs.getString("asesorado");
                Asesora[3] = rs.getString("id_asunto");
                Asesora[4] = rs.getString("tema");
                Asesora[5] = rs.getString("hora");
                Asesora[6] = rs.getString("fecha");
                
                asesora.addRow(Asesora);
            }
            
            jTableAsesora.setModel(asesora);
        } catch (Exception e) {
        }

    }

    public void llenarcombox() {
        MYSQLConexion Abogadoss = new MYSQLConexion();
        ArrayList<Abogatos> abogados = Abogadoss.Abogado();
        for (int i = 0; i < abogados.size(); i++) {
            jComboBoxAbogados.addItem(
                    new Abogatos(abogados.get(i).getId(), abogados.get(i).getNombre())
            );

        }
        MYSQLConexion Abogadoss2 = new MYSQLConexion();
        ArrayList<Abogatos> abogadoss = Abogadoss2.Abogado();
        for (int i = 0; i < abogadoss.size(); i++) {
            Abogados.addItem(
                    new Abogatos(abogadoss.get(i).getId(), abogadoss.get(i).getNombre())
            );

        }

        MYSQLConexion.conexion();
        ArrayList<String> asuntoII = new ArrayList<String>();
        asuntoII = MYSQLConexion.llenar_Asunto();
        for (int i = 0; i < asuntoII.size(); i++) {
            jComboBoxAsunto.addItem(asuntoII.get(i));
        }

    }

    public void RegistrarAsesoria(){
        try {
            
            

        PreparedStatement pst = con.prepareStatement("INSERT INTO asesora (fecha, tema, hora, id_asunto, asesor, asesorado ) VALUES (?,?,?,?,?,?)");
        pst.setString(1, ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText());
        pst.setString(2, jTextFieldTema.getText().trim());
        pst.setString(3, ((JTextField)jDateChooserHora.getDateEditor().getUiComponent()).getText() );
        pst.setString(4, (String) jComboBoxAsunto.getSelectedItem());
        pst.setString(5, (String) Integer.toString(jComboBoxAbogados.getItemAt(jComboBoxAbogados.getSelectedIndex()).getId()));
        pst.setString(6, (String) Integer.toString(Abogados.getItemAt(Abogados.getSelectedIndex()).getId()));
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Registro Exitoso");
       } catch (HeadlessException | SQLException e) {
             JOptionPane.showMessageDialog(null, e);
        }
        mostrarAsesora();
        jTextFieldTema.setText("");
    }
    public void DeleteAsesoria(){
    
     try {
            MYSQLConexion conex = new MYSQLConexion();
            conex.conexion();
            String ide = jTableAsesora.getValueAt(jTableAsesora.getSelectedRow(),0).toString();
            String slq = "DELETE FROM asesora WHERE id_asesoria='" + ide +"'";
           conex.sentencia.execute(slq);
           
           
           JOptionPane.showMessageDialog(null, "Registro Eliminado");

        } catch (Exception e) {
        }
     mostrarAsesora();
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
        jComboBoxAbogados = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxAsunto = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        Abogados = new javax.swing.JComboBox<>();
        jTextFieldTema = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAsesora = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jDateChooserHora = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setTitle("Asesorias");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.add(jComboBoxAbogados, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 110, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Asesoria");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Fecha");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Asesor");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jPanel1.add(jComboBoxAsunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 110, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Asesorado");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, -1));

        jPanel1.add(Abogados, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 100, -1));
        jPanel1.add(jTextFieldTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 110, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("ID Asunto");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Tema");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jDateChooser1.setDateFormatString("yyy/MM/d");
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 110, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Hora");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, -1, -1));

        jTableAsesora.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableAsesora);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 550, 200));

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 130, -1));

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 120, -1));

        jDateChooserHora.setDateFormatString("HH:mm:ss");
        jPanel1.add(jDateChooserHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        RegistrarAsesoria();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        DeleteAsesoria();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Abogatos> Abogados;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<Abogatos> jComboBoxAbogados;
    private javax.swing.JComboBox<String> jComboBoxAsunto;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooserHora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAsesora;
    private javax.swing.JTextField jTextFieldTema;
    // End of variables declaration//GEN-END:variables
}
