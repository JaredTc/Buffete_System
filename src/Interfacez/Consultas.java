/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfacez;

import buffete.MYSQLConexion;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jared
 */
public class Consultas extends javax.swing.JInternalFrame {

    MYSQLConexion cc = new MYSQLConexion();
    Connection con = cc.conexion();

    /**
     * Creates new form Consultas
     */
    public Consultas() {
        initComponents();
    }

    public void mostrarClientes() {

        DefaultTableModel Tabgdo = new DefaultTableModel();
        Tabgdo.addColumn("Id_cliente");
        Tabgdo.addColumn("Nombre");
        Tabgdo.addColumn("Paterno");
        Tabgdo.addColumn("Materno");
        Tabgdo.addColumn("RFC");
        Tabgdo.addColumn("Curp");
        Tabgdo.addColumn("Facebook");
        Tabgdo.addColumn("Correo");
        Tabgdo.addColumn("Telefono");

        jTable1.setModel(Tabgdo);
        String[] clientes = new String[9];
        try {
            String sql = ("SELECT cl.id_cliente, cl.nombre, cl.paterno, cl.materno , cl.RFC, cl.CURP, fb.usuario, em.cuenta, tl.numero\n"
                    + " from cliente cl, contacto cn , facebook fb, correo em, telefono tl \n"
                    + "WHERE cl.id_cliente = cn.id_cliente\n"
                    + "AND cn.id_contacto = fb.id_contacto\n"
                    + "AND cn.id_contacto = em.id_contacto\n"
                    + "AND cn.id_contacto = tl.id_contacto\n"
                    + "GROUP BY cl.id_cliente");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                clientes[0] = rs.getString("id_cliente");
                clientes[1] = rs.getString("nombre");
                clientes[2] = rs.getString("paterno");
                clientes[3] = rs.getString("materno");
                clientes[4] = rs.getString("rfc");
                clientes[5] = rs.getString("curp");
                clientes[6] = rs.getString("usuario");
                clientes[7] = rs.getString("cuenta");
                clientes[8] = rs.getString("numero");

                Tabgdo.addRow(clientes);
            }

            jTable1.setModel(Tabgdo);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void mostrarDemandado() {
        DefaultTableModel dmado = new DefaultTableModel();
        dmado.addColumn("ID Demandado");
        dmado.addColumn("Nombre");
        dmado.addColumn("Paterno");
        dmado.addColumn("Materno");
        dmado.addColumn("Direccion");
        dmado.addColumn("Tipo");
        dmado.addColumn("Razon Social");
        jTable1.setModel(dmado);
        String[] dmandado = new String[7];
        try {
            String busqueda = "Select d.id_demandado, p.nombre, p.paterno, p.materno, d.direccion, t.descripcion , ep.razon_social from demandado d, persona p, tipo t , empresa ep WHERE d.id_demandado = p.id_demandado AND t.id_tipo = d.id_tipo AND ep.id_demandado = d.id_demandado";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(busqueda);
            while (rs.next()) {
                dmandado[0] = rs.getString("id_Demandado");
                dmandado[1] = rs.getString("nombre");
                dmandado[2] = rs.getString("paterno");
                dmandado[3] = rs.getString("materno");
                dmandado[4] = rs.getString("direccion");
                dmandado[5] = rs.getString("descripcion");
                dmandado[6] = rs.getString("razon_social");
                dmado.addRow(dmandado);
            }
            jTable1.setModel(dmado);
        } catch (Exception e) {
        }

    }

    public void mostrarAbogadoz() {

        DefaultTableModel Tabgdo = new DefaultTableModel();
        Tabgdo.addColumn("id_abogado");
        Tabgdo.addColumn("nombre");
        Tabgdo.addColumn("paterno");
        Tabgdo.addColumn("materno");
        Tabgdo.addColumn("cedula");
        Tabgdo.addColumn("RFC");
        Tabgdo.addColumn("id_grado");

        jTable1.setModel(Tabgdo);

        String[] abogados = new String[7];

        try {
            String sql = ("SELECT ab.*, e.descripcion  \n"
                    + "from abogado ab, estudio e\n"
                    + "where ab.id_grado = e.id_grado\n"
                    + "ORDER BY id_abogado");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                abogados[0] = rs.getString("id_abogado");
                abogados[1] = rs.getString("nombre");
                abogados[2] = rs.getString("paterno");
                abogados[3] = rs.getString("materno");
                abogados[4] = rs.getString("cedula");
                abogados[5] = rs.getString("rfc");
                abogados[6] = rs.getString("descripcion");

                Tabgdo.addRow(abogados);
            }
            jTable1.setModel(Tabgdo);

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

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

        jTable1.setModel(asesora);
        String[] Asesora = new String[7];
        try {
            String sql = ("SELECT ase.id_asesoria, ase.asesor, ab.nombre as asesorado, ase.id_asunto, ase.tema, ase.hora, ase.fecha\n"
                    + "FROM asesora ase, abogado ab\n"
                    + "WHERE ase.asesorado = ab.id_abogado;");
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

            jTable1.setModel(asesora);
        } catch (Exception e) {
        }

    }

    public void mostrarAudiencia() {
        DefaultTableModel data = new DefaultTableModel();
        data.addColumn("ID Audiencia");
        data.addColumn("ID Lugar");
        data.addColumn("Fecha");
        data.addColumn("Hora");
        data.addColumn("Resolucion");
        data.addColumn("ID Asunto");
        jTable1.setModel(data);

        String[] datos = new String[6];

        try {
            String sql = ("SELECT au.id_audiencia, lg.descripcion, au.fecha, au.hora, au.resolucion, au.id_asunto \n"
                    + "from audiencia au, lugar lg\n"
                    + "Where au.id_lugar = lg.id_lugar\n"
                    + "ORDER BY id_audiencia ASC");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                datos[0] = rs.getString("id_audiencia");
                datos[1] = rs.getString("descripcion");
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

    public void mostrarAsuntos() {
        DefaultTableModel Atos = new DefaultTableModel();
        Atos.addColumn("ID Asunto");
        Atos.addColumn("Cliente");
        Atos.addColumn("Demandado");
        Atos.addColumn(" Estado");
        Atos.addColumn("Tipo Asunto");
        Atos.addColumn("Abogado");
        Atos.addColumn("Fecha I");
        Atos.addColumn("Fecha F");
        jTable1.setModel(Atos);

        String[] asuntos = new String[8];

        try {
            String sql = "SELECT asn.id_asunto as Asuntos, cl.nombre ,  ps.nombre as demandado, st.descripcion as estado, ta.descripcion, ab.nombre as abogado, asn.F_inicio, asn.F_final \n"
                    + "FROM asunto asn , cliente cl, estado st, abogado ab, tipo_asunto ta , persona ps\n"
                    + "WHERE asn.id_cliente = cl.id_cliente\n"
                    + "AND asn.id_estado = st.id_estado\n"
                    + "AND asn.id_tipo_asu = ta.id_tipo_asunto\n"
                    + "AND asn.id_abogado = ab.id_abogado\n"
                    + "AND asn.id_demandado = ps.id_demandado\n"
                    + "GROUP BY Asuntos;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                asuntos[0] = rs.getString("Asuntos");
                asuntos[1] = rs.getString("nombre");
                asuntos[2] = rs.getString("demandado");
                asuntos[3] = rs.getString("estado");
                asuntos[4] = rs.getString("descripcion");
                asuntos[5] = rs.getString("abogado");
                asuntos[6] = rs.getString("F_inicio");
                asuntos[7] = rs.getString("F_final");

                Atos.addRow(asuntos);

            }

            jTable1.setModel(Atos);

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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Consultas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Consultar Informacion Almacenada");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 800, 280));

        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/objetivo 1.png"))); // NOI18N
        jButton1.setText(" Clientes");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 110, 50));

        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/boy 1.png"))); // NOI18N
        jButton2.setText("Demandado");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, -1, 50));

        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregar-archivo 1.png"))); // NOI18N
        jButton3.setText("Audiencia");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, -1, 50));

        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregar-usuario 1.png"))); // NOI18N
        jButton4.setText("Abogado");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, -1, 50));

        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/programmer 1.png"))); // NOI18N
        jButton5.setText("Asesora");
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, -1, 50));

        jButton6.setForeground(new java.awt.Color(0, 0, 0));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/asunto 1.png"))); // NOI18N
        jButton6.setText("Asuntos");
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setFocusPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 150, 110, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        mostrarClientes();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:}mostr+
        mostrarDemandado();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        mostrarAudiencia();


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        mostrarAbogadoz();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        mostrarAsesora();

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        mostrarAsuntos();
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
