/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfacez;

import buffete.MYSQLConexion;
import buffete.grados;
import java.sql.Connection;
import java.util.ArrayList;
import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jared
 */
public  class Abogados extends javax.swing.JInternalFrame {
MYSQLConexion cc = new MYSQLConexion();
        Connection con = cc.conexion();
    /**
     * Creates new form Abogados
     */
    public Abogados() {
        initComponents();
         llenarcombo();
        mostrardatos();
        
       
        
    }
    
  public void llenarcombo(){
      
      MYSQLConexion grdos = new MYSQLConexion();
      ArrayList<grados> gdos = grdos.Grados();
       for (int i = 0; i < gdos.size(); i++) {
             jComboBox1.addItem(
                     new grados(gdos.get(i).getId(), gdos.get(i).getDescripcion())
             );
             
         }
      
//     MYSQLConexion.conexion();
//        ArrayList<String> lista = new ArrayList<String>();
//        lista = MYSQLConexion.llenar_Combo();
//       for (int i = 0; i < lista.size(); i++){
//           jComboBox1.addItem(lista.get(i));
//       }

        }
  
  
  
  public void mostrardatos(){
      
      DefaultTableModel Tabgdo = new DefaultTableModel();
      Tabgdo.addColumn("id_abogado");
      Tabgdo.addColumn("nombre");
      Tabgdo.addColumn("paterno");
      Tabgdo.addColumn("materno");
      Tabgdo.addColumn("cedula");
      Tabgdo.addColumn("RFC");
      Tabgdo.addColumn("id_grado");
  
      jTable1.setModel(Tabgdo);
      
      
      String []abogados = new String[7];
      
      try {
            String sql = ("SELECT * from abogado");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            
             
         
           while(rs.next()){
               abogados[0] = rs.getString("id_abogado");
               abogados[1] = rs.getString("nombre");
               abogados[2] = rs.getString("paterno");
               abogados[3] = rs.getString("materno");
               abogados[4] = rs.getString("cedula");
               abogados[5] = rs.getString("rfc");
               abogados[6] = rs.getString("id_grado");
               
               
               Tabgdo.addRow(abogados);
           }
           jTable1.setModel(Tabgdo);
        
      } catch (HeadlessException | SQLException e) {
          JOptionPane.showMessageDialog(null, e);
      }
      
      
  
  }
  
    public void RegistrarAbogados(){
       String ID = Integer.toString(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()).getId());
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO abogado (nombre, paterno, materno, cedula, rfc, id_grado ) VALUES (?,?,?,?,?,?)");
            pst.setString(1, nombre.getText().trim());
            pst.setString(2, paterno.getText().trim());
            pst.setString(3, materno.getText().trim());
            pst.setString(4, cedula.getText().trim());
            pst.setString(5, rfc.getText().trim());
            pst.setString(6, (String) Integer.toString(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()).getId()));
            pst.executeUpdate();
            clean();
              JOptionPane.showMessageDialog(null, "Empleado Registrado con exito!");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
         clean();
        mostrardatos();
       
    }
   public void buscarabogados(){
       int busqueda = 0;
       String  patern;
       String matern;
       String cedule; 
       String RFC;
       
       try {
           
           String nomb = jTextField1Name.getText(); 
           String sql = ("SELECT * FROM abogado" + " WHERE nombre='" + nomb + "'");
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(sql);
           
           if (rs.next()) {
               busqueda = 1;
               patern = rs.getString("paterno");
               matern = rs.getString("materno");
               cedule = rs.getString("cedula");
               RFC = rs.getString("rfc");
               
               if(busqueda == 1){
                   JOptionPane.showMessageDialog(null, "Abogado Encontrado");
                   nombre.setText(nomb);
                   paterno.setText(patern);
                   materno.setText(matern);
                   cedula.setText(cedule);
                   rfc.setText(RFC);
                   
               }else{
               
               }
               
               
               
           } else {
          JOptionPane.showMessageDialog(null, "Abogado No Encontrado");
           }
            
           
       } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
       

   
   }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cedula = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        paterno = new javax.swing.JTextField();
        materno = new javax.swing.JTextField();
        rfc = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1Name = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Abogados");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Grado");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombre");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Paterno");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Materno");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Buscar por Nombre");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Cedula");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 70, -1));

        cedula.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaActionPerformed(evt);
            }
        });
        jPanel1.add(cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 90, 30));

        nombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 90, -1));

        paterno.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        paterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paternoActionPerformed(evt);
            }
        });
        jPanel1.add(paterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 90, -1));

        materno.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(materno, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 100, -1));

        rfc.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPanel1.add(rfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 90, 30));

        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 100, 30));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Abogados");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, 200));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("RFC");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/003-add 1.png"))); // NOI18N
        jButton1.setText("Registrar");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 130, -1));

        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/045-third quarter 1.png"))); // NOI18N
        jButton2.setText("Buscar");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 120, -1));

        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/016-delete 1.png"))); // NOI18N
        jButton3.setText("Eliminar");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 130, -1));
        jPanel1.add(jTextField1Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 340, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    
    public void delete(){
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM abogado WHERE  nombre=?");
            pst.setString(1, nombre.getText().trim());
            int res = pst.executeUpdate();
            
            if (res > 0){
                 JOptionPane.showMessageDialog(null, "Abogado eliminado");
                clean();
                mostrardatos();
                
            } else{
            JOptionPane.showMessageDialog(null, "Ingrese el Nombre, realize la busqueda y luego elimine");
            }
            
           
            
        } catch (Exception e) {
        }
    }
    
    public void clean(){
            nombre.setText("");
            paterno.setText("");
            materno.setText("");
            cedula.setText("");
            rfc.setText("");
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        

        RegistrarAbogados();
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        buscarabogados();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void paternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paternoActionPerformed

    private void cedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cedula;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<grados> jComboBox1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1Name;
    private javax.swing.JTextField materno;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField paterno;
    private javax.swing.JTextField rfc;
    // End of variables declaration//GEN-END:variables
}
