/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.classificaclientes.gui;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author PICHAU
 */
public class Sistema extends javax.swing.JFrame {

    /**
     * @return the usuario
     */
    public static String getUsuario() {
        return usuario;
    }

    /**
     * @param aUsuario the usuario to set
     */
    public static void setUsuario(String aUsuario) {
        usuario = aUsuario;
    }

    /**
     * @return the senha
     */
    public static String getSenha() {
        return senha;
    }

    /**
     * @param aSenha the senha to set
     */
    public static void setSenha(String aSenha) {
        senha = aSenha;
    }

    /**
     * @return the admin
     */
    public static int getAdmin() {
        return admin;
    }

    /**
     * @param aAdmin the admin to set
     */
    public static void setAdmin(int aAdmin) {
        admin = aAdmin;
    }

    private static String usuario;
    private static String senha;
    private static int admin;

    /**
     * Creates new form Cadastro
     */
    public Sistema() {
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

        jddPrincipal = new javax.swing.JDesktopPane();
        jMenuBar2 = new javax.swing.JMenuBar();
        cliente = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        lista = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        administracao = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        javax.swing.GroupLayout jddPrincipalLayout = new javax.swing.GroupLayout(jddPrincipal);
        jddPrincipal.setLayout(jddPrincipalLayout);
        jddPrincipalLayout.setHorizontalGroup(
            jddPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        jddPrincipalLayout.setVerticalGroup(
            jddPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        getContentPane().add(jddPrincipal);
        jddPrincipal.setBounds(0, 0, 1200, 530);

        jMenuBar2.setToolTipText("");
        jMenuBar2.setName(""); // NOI18N

        cliente.setText("Clientes");

        jMenuItem1.setText("Cadastro");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        cliente.add(jMenuItem1);

        lista.setText("Lista de Clientes / Consulta");
        lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaActionPerformed(evt);
            }
        });
        cliente.add(lista);

        jMenuBar2.add(cliente);

        jMenu4.setText("Suporte");

        jMenuItem2.setText("Cadastrar Suporte");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuBar2.add(jMenu4);

        administracao.setText("Administração");

        jMenuItem4.setText("Consultar Categorias Mais Incidentes");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        administracao.add(jMenuItem4);

        jMenuItem5.setText("Atualizar Classificação");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        administracao.add(jMenuItem5);

        jMenuItem6.setText("Gerar Suporte");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        administracao.add(jMenuItem6);

        jMenuBar2.add(administracao);

        setJMenuBar(jMenuBar2);

        setBounds(0, 0, 1228, 596);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        CadastrarUsuario cadUs = new CadastrarUsuario();
        jddPrincipal.add(cadUs);
        cadUs.setVisible(true);


    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        CadastroSuporte cadSup = new CadastroSuporte();
        jddPrincipal.add(cadSup);
        cadSup.setVisible(true);


    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaActionPerformed
        // TODO add your handling code here:
        ListaClientes lista = new ListaClientes();
        jddPrincipal.add(lista);
        lista.setVisible(true);
    }//GEN-LAST:event_listaActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        Consulta10Mais c10mais = new Consulta10Mais();
        jddPrincipal.add(c10mais);
        c10mais.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:

        AtualizarClassificacao classifica = new AtualizarClassificacao();
        jddPrincipal.add(classifica);
        classifica.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        GerarSuporte gerarSuporte = new GerarSuporte();
        jddPrincipal.add(gerarSuporte);
        gerarSuporte.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

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
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                final JFrame frame = new JFrame("Login");

                JDialog login = new JDialogLogin(frame, true);
                
                login.setVisible(true);
                
                Sistema sistema = new Sistema();        
                System.out.println(admin);
                
                if (admin == 0){
                    sistema.administracao.setVisible(false);
                    sistema.cliente.setVisible(false);
                }
                
                
                sistema.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu administracao;
    private javax.swing.JMenu cliente;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    public javax.swing.JDesktopPane jddPrincipal;
    private javax.swing.JMenuItem lista;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the usuarioLogado
     */
}
