/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfacez;

import buffete.Demandas;
import buffete.MYSQLConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jared
 */
public class Demandado extends javax.swing.JInternalFrame {
    MYSQLConexion cc = new MYSQLConexion();
Connection con = cc.conexion();

 String ID ;

    /**
     * Creates new form Demandado
     */
    public Demandado() {
        initComponents();
        llenarcombox();
        mostrarDatos();
        mostrarEmpresa();
        mostrarDemandado();
    }
    public void mostrarEmpresa(){
    DefaultTableModel empresa = new DefaultTableModel();
    empresa.addColumn("ID Demandado");
    empresa.addColumn("Razon Social");
    
    jTable2Empresa.setModel(empresa);
    String []empresas = new String[2];
        try {
            String send = "SELECT * FROM empresa";
             Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(send);
            while (rs.next()) {  
                empresas[0] = rs.getString("id_demandado");
                empresas[1] = rs.getString("razon_social");
                empresa.addRow(empresas);
            }
            jTable2Empresa.setModel(empresa);
        } catch (Exception e) {
        }
    }
    public void mostrarDemandado(){
    DefaultTableModel dmado = new DefaultTableModel();
    dmado.addColumn("id_demandado");
    dmado.addColumn("Direccion");
    dmado.addColumn("id_tipo");
    jTableDemandado.setModel(dmado);
    String []dmandado = new String [3];
        try {
            String busqueda = "Select * from demandado";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(busqueda);
            while (rs.next()) {                
                dmandado[0] = rs.getString("id_Demandado");
                dmandado[1] = rs.getString("direccion");
                dmandado[2] = rs.getString("id_tipo");
                dmado.addRow(dmandado);
            }
            jTableDemandado.setModel(dmado);
        } catch (Exception e) {
        }
    
    }
    public void mostrarDatos(){
       DefaultTableModel Tabgdo = new DefaultTableModel();
      Tabgdo.addColumn("id_demandado");
      Tabgdo.addColumn("nombre");
      Tabgdo.addColumn("paterno");
      Tabgdo.addColumn("materno");
      Tabgdo.addColumn("Direccion");
      Tabgdo.addColumn("Tipo");
      
      
      jTable1.setModel(Tabgdo);
      
      String []demandas = new String[6];
      
        try {
            String sql = ("SELECT  d.id_demandado, d.direccion, d.id_tipo, p.nombre, p.paterno, p.materno  FROM demandado d, persona p WHERE p.id_demandado = d.id_demandado ORDER BY id_demandado ASC");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {                
                demandas[0] = rs.getString("id_demandado");
                demandas[1] = rs.getString("nombre");
                demandas[2] = rs.getString("paterno");
                demandas[3] = rs.getString("materno");
                demandas[4] = rs.getString("direccion");
                demandas[5] = rs.getString("id_tipo");
               
                
                Tabgdo.addRow(demandas);
                
                
            }
            jTable1.setModel(Tabgdo);
        } catch (Exception e) {
        }
        
    
        
    }
    
    public void Cleaner(){
      nombre.setText("");
            paterno.setText("");
            materno.setText("");
            direccion.setText("");
            RazonSocial.setText("");
    }

    public void llenarcombox(){
        MYSQLConexion combodemandas = new MYSQLConexion();
        ArrayList<Demandas> demandas = combodemandas.TipoDemandas();
        for (int i = 0; i < demandas.size(); i++) {
            jComboBoxTiposDemandas.addItem(
            new Demandas(demandas.get(i).getId(),demandas.get(i).getDescripcion())
            );
            
        }
    }
    public void RegistrarDemandados(){
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO demandado (direccion, id_tipo) VALUES (?,?) ");
            pst.setString(1, direccion.getText().trim());
            pst.setString(2, (String) Integer.toString(jComboBoxTiposDemandas.getItemAt(jComboBoxTiposDemandas.getSelectedIndex()).getId()) );
            pst.executeUpdate();
            
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
       
        
        
    }
    public void RegistrarPersona(){
        try {
            String SQ = "SELECT id_demandado FROM demandado ORDER BY id_demandado DESC LIMIT 1";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQ);
            while(rs.next()) {
                  ID = rs.getString("id_demandado");
                
                PreparedStatement pst = con.prepareStatement("INSERT INTO persona (id_demandado, paterno, materno, nombre) VALUES (?,?,?,?) ");
                pst.setString(1, ID);
                pst.setString(2, paterno.getText().trim());
                pst.setString(3, materno.getText().trim());
                pst.setString(4, nombre.getText().trim());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro Exitoso!");
        
            }
            
          
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        Cleaner();
        mostrarDatos();
        mostrarEmpresa();
        mostrarDemandado();
        
    }
    public void RegistrarEmpresa(){
        try {
             
            String SQL = "SELECT id_demandado FROM demandado ORDER BY id_demandado DESC LIMIT 1";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {                
                String ultimoid = rs.getString("id_demandado").trim();
                 String reason = RazonSocial.getText().trim();
                 PreparedStatement pst = con.prepareStatement("INSERT INTO empresa (id_demandado, razon_social) VALUES (?,?) ");
                 pst.setString(1, ultimoid);
                 pst.setString(2, reason);
                 pst.executeUpdate(); 
                
            }
            
               

             
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        materno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        paterno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jComboBoxTiposDemandas = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        direccion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2Empresa = new javax.swing.JTable();
        RazonSocial = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableDemandado = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Demandado");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Materno");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Demandado");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));
        jPanel1.add(materno, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 90, 30));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Paterno");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));
        jPanel1.add(paterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 110, 30));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Nombre");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 90, 30));

        jPanel1.add(jComboBoxTiposDemandas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 110, 30));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Direccion");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));
        jPanel1.add(direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 90, 30));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("ID Tipo");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 460, 170));

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 120, 70));

        Eliminar.setForeground(new java.awt.Color(0, 0, 0));
        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/016-delete 1.png"))); // NOI18N
        Eliminar.setText("Eliminar");
        Eliminar.setBorder(null);
        Eliminar.setBorderPainted(false);
        Eliminar.setContentAreaFilled(false);
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        jPanel1.add(Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 120, 70));

        jTable2Empresa.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2Empresa);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 220, 80));
        jPanel1.add(RazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 90, 30));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Razon Social");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, -1, -1));

        jTableDemandado.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTableDemandado);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 220, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        RegistrarDemandados();
         RegistrarPersona();
        RegistrarEmpresa();
        Cleaner();
        if (RazonSocial.getText().length() > 0) {
            
        } else {
        } if(nombre.getText().length() > 0 ){
       
        } else{
        } 
        
    
      
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
   
    
    public void deleteEmpresa(){
        try {
            MYSQLConexion conex = new MYSQLConexion();
            conex.conexion();
            String i = jTable2Empresa.getValueAt(jTable2Empresa.getSelectedRow(),0).toString();
            String sl = "DELETE FROM empresa WHERE id_demandado='" + i +"'";
           conex.sentencia.execute(sl);
               JOptionPane.showMessageDialog(null, "Registro Eliminado");
        } catch (Exception e) {
        }
        mostrarEmpresa();
    }
     public void delete(){
        try {
            MYSQLConexion conex = new MYSQLConexion();
            conex.conexion();
            String ide = jTable1.getValueAt(jTable1.getSelectedRow(),0).toString();
            String slq = "DELETE FROM persona WHERE id_demandado='" + ide +"'";
           conex.sentencia.execute(slq);
           
           
           JOptionPane.showMessageDialog(null, "Registro Eliminado");

        } catch (Exception e) {
        }
        mostrarDatos();
    }
    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        // TODO add your handling code here:
        delete();
        deleteEmpresa();
        deleteDemandado();
    }//GEN-LAST:event_EliminarActionPerformed
 
    public void deleteDemandado(){
    try {
            MYSQLConexion conex = new MYSQLConexion();
            conex.conexion();
            String ide = jTableDemandado.getValueAt(jTableDemandado.getSelectedRow(),0).toString();
            String slq = "DELETE FROM demandado WHERE id_demandado='" + ide +"'";
           conex.sentencia.execute(slq);
           
           
           JOptionPane.showMessageDialog(null, "Registro Eliminado");

        } catch (Exception e) {
        }
    mostrarDemandado();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Eliminar;
    private javax.swing.JTextField RazonSocial;
    private javax.swing.JTextField direccion;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<Demandas> jComboBoxTiposDemandas;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2Empresa;
    private javax.swing.JTable jTableDemandado;
    private javax.swing.JTextField materno;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField paterno;
    // End of variables declaration//GEN-END:variables
}
