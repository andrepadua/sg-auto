package FORM;

import CLASS.SegSistema;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Class.ClsConn;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author andreferreira
 */
public class frmLogin extends javax.swing.JFrame {

    /**
     * Creates new form frmConn
     */
    public frmLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.PreencherComboServer();
        this.PreencherComboSid();
        URL iconURL = getClass().getResource("/ICON/login.png");
        this.setIconImage(new ImageIcon(iconURL).getImage());
        this.setTitle("Login");
    }

    private void PreencherComboServer() {
        DefaultComboBoxModel modelCategoria = new DefaultComboBoxModel();
        modelCategoria.addElement("192.168.0.7");
        modelCategoria.addElement("localhost");
        cboServidor.removeAllItems();
        cboServidor.setModel(modelCategoria);
    }

    private void PreencherComboSid() {
        DefaultComboBoxModel modelCategoria = new DefaultComboBoxModel();
        modelCategoria.addElement("saaed");
        modelCategoria.addElement("xe");
        cboSid.removeAllItems();
        cboSid.setModel(modelCategoria);
    }

    public static String username;
    public static String password;
    public static String server;
    public static String sid;
    public static String msg;
    public static int PerfUsu;

    private void pChekSegSist() throws ClassNotFoundException {
        SegSistema objSeg = new SegSistema();
        PerfUsu = objSeg.fc_get_perf_usu();
    }

    private int pCheckUsuCadSis() throws ClassNotFoundException, ClassNotFoundException {
        int v_count;
        SegSistema objSeg = new SegSistema();

        v_count = objSeg.fc_get_usu_cad();
        if (v_count > 0) {
            return 1;
        } else {
            return 0;
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

        btnConnect = new javax.swing.JButton();
        txtLoginName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        lblLoginName = new javax.swing.JLabel();
        lblServidor = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        cboServidor = new javax.swing.JComboBox();
        lblPassword = new javax.swing.JLabel();
        lblSid = new javax.swing.JLabel();
        cboSid = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnConnect.setText("Conectar");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        lblLoginName.setText("Usuário:");

        lblServidor.setText("Servidor:");

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        cboServidor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboServidorActionPerformed(evt);
            }
        });

        lblPassword.setText("Senha:");

        lblSid.setText("Sid:");

        cboSid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConnect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(btnCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblLoginName)
                            .addComponent(lblServidor)
                            .addComponent(lblPassword)
                            .addComponent(lblSid))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboServidor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtLoginName, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(txtPassword)
                            .addComponent(cboSid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLoginName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLoginName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblServidor))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSid)
                    .addComponent(cboSid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConnect)
                    .addComponent(btnCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        username = txtLoginName.getText();
        password = txtPassword.getText();
        server = (String) cboServidor.getSelectedItem();
        sid = (String) cboSid.getSelectedItem();
        msg = null;
        try {
            ClsConn conn = new ClsConn();
            conn.Connect();
            conn.Disconnect();
            if (pCheckUsuCadSis() > 0) {
                this.pChekSegSist();
                MDIApp frm = new MDIApp();
                frm.setVisible(true);
                frm.setExtendedState(frm.getExtendedState() | JFrame.MAXIMIZED_BOTH);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(btnConnect, "Usuário não Cadastrado na Aplicação");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, msg);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnConnectActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void cboServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboServidorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboServidorActionPerformed

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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConnect;
    private javax.swing.JComboBox cboServidor;
    private javax.swing.JComboBox cboSid;
    private javax.swing.JLabel lblLoginName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblServidor;
    private javax.swing.JLabel lblSid;
    private javax.swing.JTextField txtLoginName;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
