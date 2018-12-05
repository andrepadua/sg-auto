/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MDIFORMS;

import BUS.ConcessionariaBUS;
import BUS.TipoVeiculoBUS;
import BUS.VeiculoBUS;
import FORM.frmLogin;
import MODELS.Concessionaria;
import MODELS.TipoVeiculo;
import MODELS.Veiculo;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Claudio
 */
public class FrmCadVeiculo extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmCadVeiculo
     *
     * @throws java.lang.Exception
     */
    public FrmCadVeiculo() throws Exception {
        initComponents();
        this.PreencherTabela();
        this.pCheckMenu();
        this.PreencherComboConc();
        this.PreencherComboTV();
    }

    VeiculoBUS vBus = new VeiculoBUS();
    ConcessionariaBUS cBus = new ConcessionariaBUS();
    TipoVeiculoBUS tvBus = new TipoVeiculoBUS();

    private void PreencherTabela()
            throws Exception {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Código");
        dtm.addColumn("Nome");
        dtm.addColumn("Tipo Veículo");
        dtm.addColumn("Concessionária");
        try {
            ArrayList<Veiculo> lista = vBus.Consultar();
            for (Veiculo v : lista) {
                dtm.addRow(new String[]{
                    String.valueOf(v.getSEQ_VEICULO()),
                    v.getNOM_VEICULO(),
                    v.getNOM_TIPOVEICULO(),
                    v.getNOM_CONCESSIONARIA()
                });
            }
            tblResult.setModel(dtm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void pCheckMenu() {
        if (frmLogin.PerfUsu != 1) {
            btnCadastrar.setEnabled(false);
            btnAtualizar.setEnabled(false);
            btnExcluir.setEnabled(false);
        }
    }

    private void PreencherComboConc() throws ClassNotFoundException {
        DefaultComboBoxModel modelConc = new DefaultComboBoxModel();
        ArrayList<Concessionaria> lista = cBus.Consultar();
        for (Concessionaria c : lista) {
            modelConc.addElement(c.getNOM_CONCESSIONARIA());
        }
        cboConcessionaria.removeAllItems();
        cboConcessionaria.setModel(modelConc);
    }

    private void PreencherComboTV() throws ClassNotFoundException {
        DefaultComboBoxModel modelTV = new DefaultComboBoxModel();
        ArrayList<TipoVeiculo> lista = tvBus.Consultar();
        for (TipoVeiculo tv : lista) {
            modelTV.addElement(tv.getNOM_TIPOVEICULO());
        }
        cboTV.removeAllItems();
        cboTV.setModel(modelTV);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblResult = new javax.swing.JTable();
        lblSeq = new javax.swing.JLabel();
        txtSeq = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cboTV = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        cboConcessionaria = new javax.swing.JComboBox();

        setClosable(true);
        setTitle("Cadastrar Veículo");

        tblResult.setModel(new javax.swing.table.DefaultTableModel(
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
        tblResult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblResultMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblResult);

        lblSeq.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        lblSeq.setText("Código:");

        txtSeq.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel8.setText("Nome:");

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Add.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setPreferredSize(new java.awt.Dimension(133, 60));
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/edit.png"))); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.setPreferredSize(new java.awt.Dimension(133, 60));
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/delete.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setPreferredSize(new java.awt.Dimension(133, 60));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel9.setText("Tipo de Veículo:");

        cboTV.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel10.setText("Concessionária:");

        cboConcessionaria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNome))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSeq)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSeq, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel10))
                                    .addComponent(jLabel9))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboTV, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboConcessionaria, 0, 253, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSeq)
                    .addComponent(txtSeq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cboTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cboConcessionaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblResultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultMouseClicked
        int a = tblResult.getSelectedRow();
        txtSeq.setText(String.valueOf(tblResult.getValueAt(a, 0)));
        txtNome.setText(String.valueOf(tblResult.getValueAt(a, 1)));
    }//GEN-LAST:event_tblResultMouseClicked

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (fc_verif_campos() == 1) {
            int Seq = 0;
            int SeqConc = 0;
            try {
                SeqConc = cBus.fc_get_seq(cboConcessionaria.getSelectedItem().toString());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmCadVeiculo.class.getName()).log(Level.SEVERE, null, ex);
            }
            int SeqTV = 0;
            try {
                SeqTV = tvBus.fc_get_seq(cboTV.getSelectedItem().toString());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmCadVeiculo.class.getName()).log(Level.SEVERE, null, ex);
            }

            Veiculo v = new Veiculo();
            v.setSEQ_VEICULO(0);
            v.setNOM_VEICULO(txtNome.getText());
            v.setSEQ_TIPOVEICULO(SeqTV);
            v.setSEQ_CONCESSIONARIA(SeqConc);

            try {
                Seq = vBus.Incluir(v);
                if (Seq > 0) {
                    JOptionPane.showMessageDialog(rootPane, "Registro: " + Seq + " incluído com sucesso!");
                    this.PreencherTabela();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao incluir");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,
                        ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Verifique campos nulos!");
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        if (fc_verif_campos() == 1) {
            int Seq = 0;
            int SeqConc = 0;
            try {
                SeqConc = cBus.fc_get_seq(cboConcessionaria.getSelectedItem().toString());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmCadVeiculo.class.getName()).log(Level.SEVERE, null, ex);
            }
            int SeqTV = 0;
            try {
                SeqTV = tvBus.fc_get_seq(cboTV.getSelectedItem().toString());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmCadVeiculo.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!txtSeq.getText().isEmpty()) {
                Veiculo v = new Veiculo();
                v.setSEQ_VEICULO(Integer.parseInt(txtSeq.getText()));
                v.setNOM_VEICULO(txtNome.getText());
                v.setSEQ_TIPOVEICULO(SeqTV);
                v.setSEQ_CONCESSIONARIA(SeqConc);
                try {
                    Seq = vBus.Alterar(v);
                    if (Seq > 0) {
                        JOptionPane.showMessageDialog(rootPane, "Registro alterado com sucesso!");
                        this.PreencherTabela();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Erro ao atualizar.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,
                            ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Não há registro para atualização.");
            }
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (!txtSeq.getText().isEmpty()) {
            int Seq = 0;
            if (txtSeq.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Não há registro para excluir.");
            } else {
                try {
                    Seq = vBus.Excluir(Integer.parseInt(txtSeq.getText()));
                    if (Seq > 0) {
                        JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso!");
                        this.PreencherTabela();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Erro ao excluir registro.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,
                            ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um Registro para excluir");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private int fc_verif_campos() {

        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Não possui Nome do Veículo. Favor Preecher!");
            return 0;
        }

        return 1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JComboBox cboConcessionaria;
    private javax.swing.JComboBox cboTV;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSeq;
    private javax.swing.JTable tblResult;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSeq;
    // End of variables declaration//GEN-END:variables
}
