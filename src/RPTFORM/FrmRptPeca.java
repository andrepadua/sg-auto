package RPTFORM;

import BEAN.appBean;
import BUS.PecaBUS;
import MODELS.Peca;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Claudio
 */
public class FrmRptPeca extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmConsPeca
     *
     * @throws java.lang.Exception
     */
    public FrmRptPeca() throws Exception {
        initComponents();
        this.PreencherTabela();
    }

    PecaBUS pBus = new PecaBUS();

    private void PreencherTabela()
            throws Exception {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Código");
        dtm.addColumn("Nome");
        dtm.addColumn("Fornecedor");
        dtm.addColumn("Prod. na Montadora");
        try {
            ArrayList<Peca> lista = pBus.Consultar();
            for (Peca p : lista) {
                dtm.addRow(new String[]{
                    String.valueOf(p.getSEQ_PECA()),
                    p.getNOM_PECA(),
                    p.getNOM_FORNECEDOR(),
                    p.getPROD_MONTADORA()
                });
            }
            tblResult.setModel(dtm);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public static Connection establishConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        try {
            appBean ab = new appBean();
            Class.forName(ab.getClassforname());
            connection = DriverManager.getConnection(ab.getUrl(), ab.getUsername(), ab.getPassword());
            connection.setAutoCommit(false);
        } catch (SQLException exception) {
        }
        return connection;
    }

    public void gerar(String layout) throws JRException, SQLException, ClassNotFoundException {
        //gerando o jasper design
        JasperDesign desenho = JRXmlLoader.load(layout);

        //compila o relatório
        JasperReport relatorio = JasperCompileManager.compileReport(desenho);

        //estabelece conexão
        Connection connection = establishConnection();
        Statement stm = connection.createStatement();
        String query = "SELECT P.SEQ_PECA, P.NOM_PECA, F.NOM_FORNECEDOR, CASE P.FLG_PROD_MONT WHEN 1 THEN 'Sim' WHEN 0 THEN 'Não' END PROD_MONTADORA FROM SGA.PECA P INNER JOIN SGA.FORNECEDOR F ON (P.SEQ_FORNECEDOR = F.SEQ_FORNECEDOR)";
        ResultSet rs = stm.executeQuery(query);

        //implementação da interface JRDataSource para DataSource ResultSet
        JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);

        //executa o relatório
        Map parametros = new HashMap();
        parametros.put("PAR1", "Teste de Parâmetro");
        JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, jrRS);

        //exibe o resultado
        JasperViewer viewer = new JasperViewer(impressao, false);
        viewer.setTitle(title);
        viewer.show();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblResult = new javax.swing.JTable();
        btnPrint = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Relatório de Peça");

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
        jScrollPane2.setViewportView(tblResult);

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/printer.png"))); // NOI18N
        btnPrint.setText("Imprimir");
        btnPrint.setPreferredSize(new java.awt.Dimension(133, 60));
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        try {
            gerar("C:\\sg-auto\\src\\REPORTS\\RptPeca.jrxml");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        } catch (JRException | SQLException ex) {
            Logger.getLogger(FrmRptAcessorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnPrint;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblResult;
    // End of variables declaration//GEN-END:variables
}
