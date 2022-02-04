
package Interfacez;

import buffete.Abogatos;
import buffete.MYSQLConexion;
import buffete.idClientes;
import buffete.Demandado;
import buffete.TAsuntos;
import buffete.items;
import com.mysql.jdbc.MySQLConnection;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Asuntos extends javax.swing.JInternalFrame {

    MYSQLConexion cc = new MYSQLConexion();
    Connection con = cc.conexion();

    public Asuntos() {
        initComponents();
        llenarcombo();
        mostrarDatos();
    }

    public void llenarcombo() {
        MYSQLConexion esdos = new MYSQLConexion();
        ArrayList<items> estados = esdos.Estado();
        for (int i = 0; i < estados.size(); i++) {
            jComboBox4.addItem(
                    new items(estados.get(i).getId(), estados.get(i).getDescripcion())
            );

        }
        
        MYSQLConexion idclientes = new MYSQLConexion();
        ArrayList<idClientes> clientes = idclientes.Clientes();
        for (int i = 0; i < clientes.size(); i++) {
            jComboBoxCLientes.addItem(
            new idClientes(clientes.get(i).getId(), clientes.get(i).getNombre())
            );
            
        }
        MYSQLConexion idDemandado = new MYSQLConexion();
        ArrayList<Demandado> demandado = idDemandado.IDDemandado();
        for (int i = 0; i < demandado.size(); i++) {
            jComboBoxDemandado.addItem(
            new Demandado(demandado.get(i).getId(), demandado.get(i).getNombre())
            );
            
        }
        MYSQLConexion Abogadoss = new MYSQLConexion();
        ArrayList<Abogatos> abogados = Abogadoss.Abogado();
        for (int i = 0; i < abogados.size(); i++) {
            jComboBox6Abogado.addItem(
            new Abogatos(abogados.get(i).getId(), abogados.get(i).getNombre())
            );
            
        }
        
        MYSQLConexion Tipos_Asuntos = new MYSQLConexion();
        ArrayList<TAsuntos> asuntos = Tipos_Asuntos.Asuntos();
        for (int i = 0; i < asuntos.size(); i++) {
            jComboBoxTipoAsunto.addItem(
            new TAsuntos(asuntos.get(i).getId(), asuntos.get(i).getDescripcion())
            );
        }
        
        
        
        
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBoxCLientes = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxDemandado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxTipoAsunto = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jComboBox6Abogado = new javax.swing.JComboBox<>();
        jDateChooserInicio = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jDateChooserFinal = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Asuntos");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.add(jComboBoxCLientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 110, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("ID Cliente");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Fecha Final");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, -1));

        jPanel1.add(jComboBoxDemandado, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 110, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("ID Demandado");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("ID Estado");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jComboBoxTipoAsunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoAsuntoActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxTipoAsunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 110, 30));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("ID Tipo Asunto");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        jPanel1.add(jComboBox6Abogado, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 120, 30));

        jDateChooserInicio.setDateFormatString("yyyy/MM/d");
        jPanel1.add(jDateChooserInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 120, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("ID Abogado");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Fecha Inicio");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jDateChooserFinal.setDateFormatString("yyyy/MM/d");
        jPanel1.add(jDateChooserFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 120, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Asuntos");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 480, 230));

        jPanel1.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 120, 30));

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 140, -1));

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 140, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void mostrarDatos(){
        DefaultTableModel Atos = new DefaultTableModel();
        Atos.addColumn("ID Asunto");
         Atos.addColumn("ID Cliente");
         Atos.addColumn("ID Demandado");
         Atos.addColumn("ID Estado");
         Atos.addColumn("ID Tipo A");
         Atos.addColumn("ID Abogado");
         Atos.addColumn("Fecha I");
         Atos.addColumn("Fecha F");
         jTable1.setModel(Atos);
         
         String []asuntos = new String[8];
         
         try {
            String sql = "SELECT * From asunto";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
             while (rs.next()) {                 
                 asuntos[0] = rs.getString("id_asunto");
                 asuntos[1] = rs.getString("id_cliente");
                 asuntos[2] = rs.getString("id_demandado");
                 asuntos[3] = rs.getString("id_estado");
                 asuntos[4] = rs.getString("id_tipo_asu");
                  asuntos[5] = rs.getString("id_abogado");
                 asuntos[6] = rs.getString("F_inicio");
                 asuntos[7] = rs.getString("F_final");
                 
                 Atos.addRow(asuntos);
              
                 
             }
             
             jTable1.setModel(Atos);
            
        } catch (Exception e) {
        }
         
         
    
    }
   
    
    public void InsertarAsuntos(){
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO asunto (id_cliente, id_demandado, id_estado, id_tipo_asu, id_abogado, F_inicio, F_final ) VALUES (?,?,?,?,?,?,?)");
            pst.setString(1, (String) Integer.toString(jComboBoxCLientes.getItemAt(jComboBoxCLientes.getSelectedIndex()).getId()));
            pst.setString(2, (String) Integer.toString(jComboBoxDemandado.getItemAt(jComboBoxDemandado.getSelectedIndex()).getId()));
            pst.setString(3, (String) Integer.toString(jComboBox4.getItemAt(jComboBox4.getSelectedIndex()).getId()));
            pst.setString(4, (String) Integer.toString(jComboBoxTipoAsunto.getItemAt(jComboBoxTipoAsunto.getSelectedIndex()).getId()));
            pst.setString(5,(String) Integer.toString(jComboBox6Abogado.getItemAt(jComboBox6Abogado.getSelectedIndex()).getId()));
            pst.setString(6,  ((JTextField)jDateChooserInicio.getDateEditor().getUiComponent()).getText());
            pst.setString(7,  ((JTextField)jDateChooserFinal.getDateEditor().getUiComponent()).getText());
            pst.executeUpdate();
            
             JOptionPane.showMessageDialog(null, " Registro Exitoso!");
        } catch (HeadlessException | SQLException e) {
             JOptionPane.showMessageDialog(null, e);
        }
        mostrarDatos();
    
    }
    private void jComboBoxTipoAsuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoAsuntoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoAsuntoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        InsertarAsuntos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<items> jComboBox4;
    private javax.swing.JComboBox<Abogatos> jComboBox6Abogado;
    private javax.swing.JComboBox<idClientes> jComboBoxCLientes;
    private javax.swing.JComboBox<Demandado> jComboBoxDemandado;
    private javax.swing.JComboBox<TAsuntos> jComboBoxTipoAsunto;
    private com.toedter.calendar.JDateChooser jDateChooserFinal;
    private com.toedter.calendar.JDateChooser jDateChooserInicio;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
