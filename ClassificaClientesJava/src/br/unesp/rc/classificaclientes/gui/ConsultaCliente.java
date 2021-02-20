/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.classificaclientes.gui;

import br.unesp.rc.classificaclientes.model.Suporte;
import br.unesp.rc.classificaclientes.model.TipoSuporte;
import br.unesp.rc.classificaclientes.service.ClienteCidadeService;
import br.unesp.rc.classificaclientes.service.ServiceFactory;
import br.unesp.rc.classificaclientes.service.TipoSuporteService;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author PICHAU
 */
public class ConsultaCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form ConsultaCliente
     */
    public ConsultaCliente() {
        initComponents();

    }

    private static int contarCategoria(List<Suporte> listaSuporte, String categoria) {
        int j = 0;
        Suporte o;
        TipoSuporte to;
        String temp;
        TipoSuporteService entity2 = ServiceFactory.getTipoSuporteService();

        for (int i = 0; i < listaSuporte.size(); i++) {
            o = listaSuporte.get(i);
            to = entity2.recuperaTipoOcorrencia(o.getIdTipoSuporte());
            temp = to.getCategoria();

            if (temp.equals(categoria)) {
                j++;
            }
        }
        return j;
    }

    public void exibir() {

        ClienteCidadeService entity = ServiceFactory.getClienteCidadeService();
        TipoSuporteService entity2 = ServiceFactory.getTipoSuporteService();

        TipoSuporte to;
        List<Suporte> listaSuporte = null;

        java.util.Date d = new java.util.Date();
        d.getTime();
        Calendar cal = new GregorianCalendar();
        cal.setTime(d);
        java.sql.Date data5 = new java.sql.Date(cal.getTimeInMillis());
        cal.add(Calendar.MONTH, -1);
        java.sql.Date data6 = new java.sql.Date(cal.getTimeInMillis());

        long idCliente = entity.verifica(farmacia.getText());

        String[][] dados;

        if (idCliente != -1) {
            listaSuporte = entity.recuperaSuportes(idCliente, data6, data5);

            Suporte o;
            dados = new String[listaSuporte.size()][5];

            String temp;

            for (int i = 0; i < listaSuporte.size(); i++) {
                o = listaSuporte.get(i);
                to = entity2.recuperaTipoOcorrencia(o.getIdTipoSuporte());
                temp = to.getCategoria();

                dados[i][0] = " " + o.getIdSuporte();
                dados[i][2] = " " + o.getDataSuporte();
                dados[i][3] = " " + o.getHora();
                dados[i][4] = " " + o.getDescricaoOcorrido();
                dados[i][1] = " " + temp;
            }
        } else {
            dados = new String[1][5];
        }
        tabelasuporte = new javax.swing.JTable();

        tabelasuporte.setModel(new javax.swing.table.DefaultTableModel(
                dados,
                new String[]{
                    "ID", "Categoria", "Data", "Hora", "descrição"
                }
        ));

        jScrollPane1.setViewportView(tabelasuporte);

        /**
         * ------------------------------------- imprime o status
         * -------------------------------------*
         */
        status.setFont(new java.awt.Font("Tahoma", 1, 18));
        status.setForeground(new java.awt.Color(51, 55, 0));
        if (status.getText().equals("vermelho")) {
            status.setForeground(new java.awt.Color(204, 0, 51));
        }
        if (status.getText().equals("verde")) {
            status.setForeground(new java.awt.Color(0, 153, 0));
        }
        if (status.getText().equals("amarelo")) {
            status.setForeground(new java.awt.Color(255, 255, 51));
        }

        /**
         * ------------------------------------- imprime o c
         * -------------------------------------*
         */
        pontuacao.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        if (status.getText().equals("vermelho")) {
            pontuacao.setForeground(new java.awt.Color(204, 0, 51));
        }
        if (status.getText().equals("verde")) {
            pontuacao.setForeground(new java.awt.Color(0, 153, 0));
        }
        if (status.getText().equals("amarelo")) {
            pontuacao.setForeground(new java.awt.Color(255, 255, 51));
        }
        
        adm.setText(" "+contarCategoria(listaSuporte,"AdministracaoSistema"));
        compra.setText(" "+contarCategoria(listaSuporte,"Compra"));
        venda.setText(" "+contarCategoria(listaSuporte,"Venda"));
        transferencia.setText(" "+contarCategoria(listaSuporte,"Transferencia"));
        estoque.setText(" "+contarCategoria(listaSuporte,"Estoque"));
        financeiro.setText(" "+contarCategoria(listaSuporte,"Financeiro"));
        fiscal.setText(" "+contarCategoria(listaSuporte,"Fiscal"));
        relatorio.setText(" "+contarCategoria(listaSuporte,"Relatorio"));
        sngpc.setText(" "+contarCategoria(listaSuporte,"SNGPC"));
        integracao.setText(" "+contarCategoria(listaSuporte,"Integracao"));
        client.setText(" "+contarCategoria(listaSuporte,"Client"));
        crediario.setText(" "+contarCategoria(listaSuporte,"Crediario"));
        ecommerce.setText(" "+contarCategoria(listaSuporte,"Ecommerce"));
        pbm.setText(" "+contarCategoria(listaSuporte,"PBM"));
        servidor.setText(" "+contarCategoria(listaSuporte,"Servidor"));
        geral.setText(" "+contarCategoria(listaSuporte,"Geral"));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        farmacia = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        telefone = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cpf = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pontuacao = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelasuporte = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        compra = new javax.swing.JLabel();
        adm = new javax.swing.JLabel();
        venda = new javax.swing.JLabel();
        transferencia = new javax.swing.JLabel();
        financeiro = new javax.swing.JLabel();
        estoque = new javax.swing.JLabel();
        fiscal = new javax.swing.JLabel();
        relatorio = new javax.swing.JLabel();
        integracao = new javax.swing.JLabel();
        sngpc = new javax.swing.JLabel();
        client = new javax.swing.JLabel();
        crediario = new javax.swing.JLabel();
        pbm = new javax.swing.JLabel();
        ecommerce = new javax.swing.JLabel();
        servidor = new javax.swing.JLabel();
        geral = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Cliente:");

        jLabel2.setText("Farmacia");

        jLabel3.setText("Telefones");

        jLabel4.setText("E-mail");

        jLabel5.setText("CPF");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("STATUS");

        pontuacao.setBackground(new java.awt.Color(51, 255, 0));
        pontuacao.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        if( status.getText() == "vermelho"){
            pontuacao.setForeground(new java.awt.Color(204, 0, 51));
        }
        if(status.getText() == "verde"){
            pontuacao.setForeground(new java.awt.Color(51, 55, 0));
        }
        if (status.getText() == "amarelo"){
            pontuacao.setForeground(new java.awt.Color(255, 255, 51));
        }

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("PONTUAÇÂO");

        status.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jScrollPane1.setViewportView(tabelasuporte);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Suporte do Cliente:");

        jLabel9.setText("AdministracaoSistema (1)");

        jLabel10.setText("Venda (6)");

        jLabel11.setText("Compra (4)");

        jLabel12.setText("Financeiro (5)");

        jLabel13.setText("Estoque (5)");

        jLabel14.setText("Transferencia (3)");

        jLabel15.setText("Relatorio (4)");

        jLabel16.setText("Fiscal (8)");

        jLabel17.setText("SNGPC (8)");

        jLabel18.setText("Integracao (2)");

        jLabel19.setText("Client (10)");

        jLabel20.setText("Crediario (7)");

        jLabel21.setText("Ecommerce (3)");

        jLabel22.setText("PBM (10)");

        jLabel23.setText("Servidor (9)");

        jLabel24.setText("Geral (10)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(5, 5, 5))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addGap(33, 33, 33)
                                        .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(farmacia, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(pontuacao, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(compra, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(transferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(venda, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(28, 28, 28)
                                .addComponent(adm, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel13))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(financeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(relatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(estoque, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(integracao, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(crediario, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(client, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sngpc, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pbm, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(geral, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(servidor, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ecommerce, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(405, 405, 405))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(farmacia, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5))
                            .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pontuacao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel9)
                                                .addComponent(jLabel13)
                                                .addComponent(jLabel17)
                                                .addComponent(jLabel21))
                                            .addComponent(adm, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel12)
                                                .addComponent(jLabel18)
                                                .addComponent(jLabel11)
                                                .addComponent(jLabel22))
                                            .addComponent(compra, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel16)
                                                .addComponent(jLabel10)
                                                .addComponent(jLabel19)
                                                .addComponent(jLabel23))
                                            .addComponent(venda, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(estoque, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(financeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(sngpc, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(integracao, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(client, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(relatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel20)
                                        .addComponent(jLabel24))
                                    .addComponent(crediario, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(transferencia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(ecommerce, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pbm, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(servidor, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(geral, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel adm;
    public javax.swing.JLabel client;
    public javax.swing.JLabel compra;
    public javax.swing.JLabel cpf;
    public javax.swing.JLabel crediario;
    public javax.swing.JLabel ecommerce;
    public javax.swing.JLabel email;
    public javax.swing.JLabel estoque;
    public javax.swing.JLabel farmacia;
    public javax.swing.JLabel financeiro;
    public javax.swing.JLabel fiscal;
    public javax.swing.JLabel geral;
    public javax.swing.JLabel integracao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel nome;
    public javax.swing.JLabel pbm;
    public javax.swing.JLabel pontuacao;
    public javax.swing.JLabel relatorio;
    public javax.swing.JLabel servidor;
    public javax.swing.JLabel sngpc;
    public javax.swing.JLabel status;
    private javax.swing.JTable tabelasuporte;
    public javax.swing.JLabel telefone;
    public javax.swing.JLabel transferencia;
    public javax.swing.JLabel venda;
    // End of variables declaration//GEN-END:variables
}
