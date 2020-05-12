/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alocamentoreserva;

import conexao.ConexaoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class JanelaPrincipal extends javax.swing.JFrame {
    /**
     * Creates new form JanelaPrincipal
     */
    public JanelaPrincipal() {
        initComponents();
    }

    private void trocarPainel(JPanel painel){
        painelPrincipal.removeAll();
        painelPrincipal.add(painel, "painel");
        java.awt.CardLayout painelPrincipalLayout = (java.awt.CardLayout)(painelPrincipal.getLayout());
        painelPrincipalLayout.show(painelPrincipal, "painel");
        
        pack();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        painelPrincipal = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        usuarioCadastrarMenuItem = new javax.swing.JMenuItem();
        usuarioBuscarMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        reservaCadastrarMenuItem = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        guardaCadastrarMenuItem = new javax.swing.JMenuItem();
        guardaBuscarMenuItem = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        contaAlterarMenuItem = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painelPrincipal.setLayout(new java.awt.CardLayout());

        jMenu1.setText("Iniciar");

        jMenu4.setText("Usuario");

        usuarioCadastrarMenuItem.setText("Cadastrar");
        usuarioCadastrarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioCadastrarMenuItemActionPerformed(evt);
            }
        });
        jMenu4.add(usuarioCadastrarMenuItem);

        usuarioBuscarMenuItem.setText("Buscar");
        usuarioBuscarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioBuscarMenuItemActionPerformed(evt);
            }
        });
        jMenu4.add(usuarioBuscarMenuItem);

        jMenu1.add(jMenu4);

        jMenu2.setText("Ambiente");
        jMenu1.add(jMenu2);

        jMenu5.setText("Reserva");

        reservaCadastrarMenuItem.setText("Cadastrar");
        reservaCadastrarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservaCadastrarMenuItemActionPerformed(evt);
            }
        });
        jMenu5.add(reservaCadastrarMenuItem);

        jMenu1.add(jMenu5);

        jMenu7.setText("Guarda");

        guardaCadastrarMenuItem.setText("Cadastrar");
        guardaCadastrarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardaCadastrarMenuItemActionPerformed(evt);
            }
        });
        jMenu7.add(guardaCadastrarMenuItem);

        guardaBuscarMenuItem.setText("Buscar");
        guardaBuscarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardaBuscarMenuItemActionPerformed(evt);
            }
        });
        jMenu7.add(guardaBuscarMenuItem);

        jMenu1.add(jMenu7);

        jMenu6.setText("Conta");

        contaAlterarMenuItem.setText("Alterar");
        contaAlterarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contaAlterarMenuItemActionPerformed(evt);
            }
        });
        jMenu6.add(contaAlterarMenuItem);

        jMenu1.add(jMenu6);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioCadastrarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioCadastrarMenuItemActionPerformed

    }//GEN-LAST:event_usuarioCadastrarMenuItemActionPerformed

    private void usuarioBuscarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioBuscarMenuItemActionPerformed
        trocarPainel(new ProfessorBuscarPainel());
    }//GEN-LAST:event_usuarioBuscarMenuItemActionPerformed

    private void reservaCadastrarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservaCadastrarMenuItemActionPerformed
        trocarPainel(new ReservaCadastrarPainel());
    }//GEN-LAST:event_reservaCadastrarMenuItemActionPerformed

    private void contaAlterarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contaAlterarMenuItemActionPerformed
        // TODO add your handling code here:
        trocarPainel(new ContaAdministradorPainel());
    }//GEN-LAST:event_contaAlterarMenuItemActionPerformed

    private void guardaCadastrarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardaCadastrarMenuItemActionPerformed
        // TODO add your handling code here:
        trocarPainel(new GuardaCadastrarPainel());
    }//GEN-LAST:event_guardaCadastrarMenuItemActionPerformed

    private void guardaBuscarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardaBuscarMenuItemActionPerformed
        // TODO add your handling code here:
        trocarPainel(new GuardaBuscarPainel());
    }//GEN-LAST:event_guardaBuscarMenuItemActionPerformed

    private void vendaCadastrarBtActionPerformedOrFail(java.awt.event.ActionEvent evt) {                                                 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem contaAlterarMenuItem;
    private javax.swing.JMenuItem guardaBuscarMenuItem;
    private javax.swing.JMenuItem guardaCadastrarMenuItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JMenuItem reservaCadastrarMenuItem;
    private javax.swing.JMenuItem usuarioBuscarMenuItem;
    private javax.swing.JMenuItem usuarioCadastrarMenuItem;
    // End of variables declaration//GEN-END:variables
}
