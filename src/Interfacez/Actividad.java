
package Interfacez;

import buffete.MYSQLConexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class Actividad extends javax.swing.JInternalFrame {

    MYSQLConexion cc = new MYSQLConexion();
    Connection con = cc.conexion();

    public Actividad() {
        initComponents();

    }

    public void AuditaAs() {
        DefaultTableModel As = new DefaultTableModel();
        As.addColumn("Operacion");
        As.addColumn("Usuario");
        As.addColumn("fecha");
        As.addColumn("Fecha");
        As.addColumn("Tema");
        As.addColumn("Hora");
        As.addColumn("ID Asunto");
        As.addColumn("Asesor");
        As.addColumn("Asesorado");
        As.addColumn("old_Fecha");
        As.addColumn("old_tema");
        As.addColumn("old_hora");
        As.addColumn("old_id_asunto");
        As.addColumn("old_id_asesor");
        As.addColumn("old_id_asesorado");

        auditoria_cliente.setModel(As);
        String[] asesor = new String[15];

        try {
            String sql = ("SELECT * from audita_asesora");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                asesor[0] = rs.getString("operacion");
                asesor[1] = rs.getString("usuario");
                asesor[2] = rs.getString("fecha");
                asesor[3] = rs.getString("new_fecha");
                asesor[4] = rs.getString("new_tema");
                asesor[5] = rs.getString("new_hora");
                asesor[6] = rs.getString("new_id_asunto");
                asesor[7] = rs.getString("new_asesor");
                asesor[8] = rs.getString("new_asesorado");
                asesor[9] = rs.getString("old_fecha");
                asesor[10] = rs.getString("old_tema");
                asesor[11] = rs.getString("old_hora");
                asesor[12] = rs.getString("old_id_asunto");
                asesor[13] = rs.getString("old_asesor");
                asesor[14] = rs.getString("old_asesorado");

                As.addRow(asesor);

            }
            auditoria_cliente.setModel(As);
        } catch (Exception e) {
        }
    }

    public void AuditaAB() {
        DefaultTableModel AB = new DefaultTableModel();
        AB.addColumn("operacion");
        AB.addColumn("usuario");
        AB.addColumn("fecha");
        AB.addColumn("abogado");
        AB.addColumn("paterno");
        AB.addColumn("materno");
        AB.addColumn("nombre");
        AB.addColumn("RFC");
        AB.addColumn("id_grado");
        AB.addColumn("old_id_abogado");
        AB.addColumn("old_paterno");
        AB.addColumn("old_materno");
        AB.addColumn("old_nombre");
        AB.addColumn("old_RFC");
        AB.addColumn("old_id_grado");

        auditoria_cliente.setModel(AB);
        String[] abogados = new String[15];

        try {
            String sql = ("SELECT * from audita_abogado");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                abogados[0] = rs.getString("operacion");
                abogados[1] = rs.getString("usuario");
                abogados[2] = rs.getString("fecha");
                abogados[3] = rs.getString("new_id_abogado");
                abogados[4] = rs.getString("new_paterno");
                abogados[5] = rs.getString("new_materno");
                abogados[6] = rs.getString("new_nombre");
                abogados[7] = rs.getString("new_RFC");
                abogados[8] = rs.getString("new_id_grado");
                abogados[9] = rs.getString("old_id_abogado");
                abogados[10] = rs.getString("old_paterno");
                abogados[11] = rs.getString("old_materno");
                abogados[12] = rs.getString("old_nombre");
                abogados[13] = rs.getString("old_RfC");
                abogados[14] = rs.getString("old_id_grado");

                AB.addRow(abogados);

            }
            auditoria_cliente.setModel(AB);
        } catch (Exception e) {
        }
    }

    public void AuditaA() {
        DefaultTableModel AD = new DefaultTableModel();
        AD.addColumn("operacion");
        AD.addColumn("usuario");
        AD.addColumn("fecha");
        AD.addColumn("audiencia");
        AD.addColumn("id_lugar");
        AD.addColumn("hora");
        AD.addColumn("resolucion");
        AD.addColumn("id_asunto");
        AD.addColumn("old_id_audiencia");
        AD.addColumn("old_id_lugar");
        AD.addColumn("old_fecha");
        AD.addColumn("old_hora");
        AD.addColumn("old_resolucion");
        AD.addColumn("old_id_asunto");

        auditoria_cliente.setModel(AD);
        String[] ADA = new String[14];

        try {
            String sql = ("SELECT * from audita_audiencia");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                ADA[0] = rs.getString("operacion");
                ADA[1] = rs.getString("usuario");
                ADA[2] = rs.getString("fecha");
                ADA[3] = rs.getString("new_id_audiencia");
                ADA[4] = rs.getString("new_id_lugar");
                ADA[5] = rs.getString("new_hora");
                ADA[6] = rs.getString("new_resolucion");
                ADA[7] = rs.getString("new_id_asunto");
                ADA[8] = rs.getString("old_id_audiencia");
                ADA[9] = rs.getString("old_id_lugar");
                ADA[10] = rs.getString("old_fecha");
                ADA[11] = rs.getString("old_hora");
                ADA[12] = rs.getString("old_resolucion");
                ADA[13] = rs.getString("old_id_asunto");

                AD.addRow(ADA);

            }
            auditoria_cliente.setModel(AD);
        } catch (Exception e) {
        }

    }

    public void AuditaD() {
        DefaultTableModel Dm = new DefaultTableModel();
        Dm.addColumn("operacion");
        Dm.addColumn("usuario");
        Dm.addColumn("fecha");
        Dm.addColumn("new_id_demandado");
        Dm.addColumn("new_direccion");
        Dm.addColumn("new_id_tipo");
        Dm.addColumn("old_id_demandado");
        Dm.addColumn("old_direccion");
        Dm.addColumn("old_id_tipo");

        auditoria_cliente.setModel(Dm);
        String[] demandados = new String[9];

        try {
            String sql = ("SELECT * from audita_demandado");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                demandados[0] = rs.getString("operacion");
                demandados[1] = rs.getString("usuario");
                demandados[2] = rs.getString("fecha");
                demandados[3] = rs.getString("new_id_demandado");
                demandados[4] = rs.getString("new_direccion");
                demandados[5] = rs.getString("new_id_tipo");
                demandados[6] = rs.getString("old_id_demandado");
                demandados[7] = rs.getString("old_direccion");
                demandados[8] = rs.getString("old_id_tipo");

                Dm.addRow(demandados);

            }
            auditoria_cliente.setModel(Dm);
        } catch (Exception e) {
        }
    }

    public void AuditoriaC() {
        DefaultTableModel Ac = new DefaultTableModel();
        Ac.addColumn("operacion");
        Ac.addColumn("usuario");
        Ac.addColumn("fecha");
        Ac.addColumn("new_id_cliente");
        Ac.addColumn("new_paterno");
        Ac.addColumn("new_materno");
        Ac.addColumn("new_nombre");
        Ac.addColumn("new_CURP");
        Ac.addColumn("new_RFC");
        Ac.addColumn("old_id_cliente");
        Ac.addColumn("old_paterno");
        Ac.addColumn("old_materno");
        Ac.addColumn("old_nombre");
        Ac.addColumn("old_CURP");
        Ac.addColumn("old_RFC");
        auditoria_cliente.setModel(Ac);

        String[] clientes = new String[15];

        try {
            String sql = ("SELECT * from audita_cliente");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                clientes[0] = rs.getString("operacion");
                clientes[1] = rs.getString("usuario");
                clientes[2] = rs.getString("fecha");
                clientes[3] = rs.getString("new_id_cliente");
                clientes[4] = rs.getString("new_paterno");
                clientes[5] = rs.getString("new_materno");
                clientes[6] = rs.getString("new_nombre");
                clientes[7] = rs.getString("new_CURP");
                clientes[8] = rs.getString("new_RFC");
                clientes[9] = rs.getString("old_id_cliente");
                clientes[10] = rs.getString("old_paterno");
                clientes[11] = rs.getString("old_materno");
                clientes[12] = rs.getString("old_nombre");
                clientes[13] = rs.getString("old_CURP");
                clientes[14] = rs.getString("old_RFC");
                Ac.addRow(clientes);

            }
            auditoria_cliente.setModel(Ac);
        } catch (Exception e) {
        }

    }

    public void AuditaAsunto() {
        DefaultTableModel As = new DefaultTableModel();
        As.addColumn("Operacion");
        As.addColumn("Usuario");
        As.addColumn("fecha");
        As.addColumn("new_id_asunto");
        As.addColumn("new_id_cliente");
        As.addColumn("new_id_demandado");
        As.addColumn("new_id_estado");
        As.addColumn("new_id_tipo_asu");
        As.addColumn("new_id_abogado");
        As.addColumn("new_f_inicio");
        As.addColumn("new_f_final");
        As.addColumn("old_id_asunto");
        As.addColumn("old_id_cliente");
        As.addColumn("old_id_demandado");
        As.addColumn("old_id_estado");
        As.addColumn("old_id_tipo_asu");
        As.addColumn("old_id_abogado");
        As.addColumn("old_f_inicio");
        As.addColumn("old_f_final");

        auditoria_cliente.setModel(As);
        String[] asesor = new String[20];

        try {
            String sql = ("SELECT * from audita_asunto");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                asesor[0] = rs.getString("operacion");
                asesor[1] = rs.getString("usuario");
                asesor[2] = rs.getString("fecha");
                asesor[3] = rs.getString("new_id_asunto");
                asesor[4] = rs.getString("new_id_cliente");
                asesor[5] = rs.getString("new_id_demandado");
                asesor[6] = rs.getString("new_id_estado");
                asesor[7] = rs.getString("new_id_tipo_asu");
                asesor[8] = rs.getString("new_id_abogado");
                asesor[9] = rs.getString("new_f_inicio");
                asesor[10] = rs.getString("new_f_final");
                asesor[11] = rs.getString("old_id_asunto");
                asesor[12] = rs.getString("old_id_cliente");
                asesor[13] = rs.getString("old_id_demandado");
                asesor[14] = rs.getString("old_id_estado");
                asesor[15] = rs.getString("old_id_tipo_asu");
                asesor[16] = rs.getString("old_id_abogado");
                asesor[18] = rs.getString("old_f_inicio");
                asesor[19] = rs.getString("old_f_final");

                As.addRow(asesor);

            }
            auditoria_cliente.setModel(As);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        auditoria_cliente = new javax.swing.JTable();
        jLabel1Title = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        Asunto = new javax.swing.JButton();

        setClosable(true);
        setTitle("Actividad Reciente");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        auditoria_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(auditoria_cliente);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 970, 320));

        jLabel1Title.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1Title.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1Title.setText("Actividad Reciente");
        jPanel1.add(jLabel1Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 110, 50));

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, 50));

        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregar-archivo 1.png"))); // NOI18N
        jButton3.setText("Audiencias");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, 50));

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
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, -1, 50));

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
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 62, -1, 50));

        Asunto.setForeground(new java.awt.Color(0, 0, 0));
        Asunto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/asunto 1.png"))); // NOI18N
        Asunto.setText("Asunto");
        Asunto.setBorder(null);
        Asunto.setBorderPainted(false);
        Asunto.setContentAreaFilled(false);
        Asunto.setFocusPainted(false);
        Asunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsuntoActionPerformed(evt);
            }
        });
        jPanel1.add(Asunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, 100, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jLabel1Title.setText("Acrividad Reciente Clientes");
        AuditoriaC();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        AuditaD();
        jLabel1Title.setText("Acrividad Reciente Demandado");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jLabel1Title.setText("Acrividad Reciente Audiencia");
        AuditaA();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jLabel1Title.setText("Acrividad Reciente Abogado");
        AuditaAB();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        jLabel1Title.setText("Acrividad Reciente Asesorias");
        AuditaAs();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void AsuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsuntoActionPerformed
        // TODO add your handling code here:
        jLabel1Title.setText("Acrividad Reciente Asuntos");
        AuditaAsunto();
    }//GEN-LAST:event_AsuntoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Asunto;
    private javax.swing.JTable auditoria_cliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1Title;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
