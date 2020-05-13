/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alocamentoreserva;

import conexao.ConexaoException;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class GuardaBuscarPainel extends javax.swing.JPanel {
    List<Guarda> guardas = new ArrayList<>();
    GuardaDAO guardaDAO = new GuardaDAO();
    /**
     * Creates new form VendaBuscarData
     */
    public GuardaBuscarPainel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pesquisarBt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        guardaTable = new javax.swing.JTable();

        pesquisarBt.setText("Buscar");
        pesquisarBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarBtActionPerformed(evt);
            }
        });

        guardaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Nome de usuário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        guardaTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                guardaTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(guardaTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pesquisarBt, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pesquisarBt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pesquisarBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarBtActionPerformed
        // TODO add your handling code here:
        try {
            guardas = guardaDAO.findAll();

            DefaultTableModel model = (DefaultTableModel) guardaTable.getModel();
            model.setRowCount(0);

            for(Guarda guarda : guardas){
                model.addRow(new Object[]{
                        guarda.id,
                        guarda.nome,
                        guarda.nomeDeUsuario
                        // senha está hashada, não faz sentido
                        // além disso o que importa
                        // é que o administrador possa alterar
                        // a senha, não necessariamente conhecer ela
//                        guarda.senha
                });
            } 
        } catch (ConexaoException ex) {
            Logger.getLogger(GuardaBuscarPainel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pesquisarBtActionPerformed

    private void abrirJanela(JFrame jframe){
//        double x = this.getLocationOnScreen().getX();
//        double y = this.getLocationOnScreen().getY();
//        double dx = this.getSize().getWidth();
//        double dy = this.getSize().getHeight();
//        double xx = x + (dx / 2);
//        double yy = y + (dy / 2);
//        double dxx = jframe.getSize().getWidth() / 2;
//        double dyy = jframe.getSize().getHeight() / 2;
//        
//        jframe.setLocation(new Point((int) xx - (int) dxx, (int) yy - (int) dyy));
        
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    
    private void guardaTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardaTableMousePressed
        // TODO add your handling code here:
        if(evt.getClickCount() == 2){
            System.out.println("entrou");
            
            int linhaSlc = guardaTable.getSelectedRow();
            
            Guarda.selecionado = guardas.get(linhaSlc);
            ( new JanelaWrapper() ).setVisible(true);
            
//                abrirJanela(new VendaDetalhesJanela(this, gerenciador, vendas.get(linhaSlc)));
//
        }
    }//GEN-LAST:event_guardaTableMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable guardaTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pesquisarBt;
    // End of variables declaration//GEN-END:variables
}