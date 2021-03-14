package br.unesp.rc.classificaclientes.gui;

import br.unesp.rc.classificaclientes.model.ClassificacaoCliente;
import br.unesp.rc.classificaclientes.model.ClienteCidade;
import br.unesp.rc.classificaclientes.model.Suporte;
import br.unesp.rc.classificaclientes.model.TipoSuporte;
import br.unesp.rc.classificaclientes.service.ClassificacaoClienteService;
import br.unesp.rc.classificaclientes.service.ClienteCidadeService;
import br.unesp.rc.classificaclientes.service.ServiceFactory;
import br.unesp.rc.classificaclientes.service.TipoSuporteService;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.REPTree;
import weka.classifiers.trees.RandomForest;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

/**
 *
 * AdministracaoSistema Compra Venda Transferencia Estoque Financeiro Fiscal
 * Relatorio SNGPC Integracao Client Crediario Ecommerce PBM Servidor Geral
 */
public class AtualizarClassificacao extends javax.swing.JInternalFrame {
    
    final private String aquivo = "C:\\Users\\PICHAU\\Documents\\NetBeansProjects\\ClassificaClientesWeka\\ClassificaClientesWeka\\"
            + "ClassificaClientesJava\\DadosTreinamento\\Dados.arff";

    /**
     * Creates new form AtualizarClassificacao
     */
    public AtualizarClassificacao() {
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

        REPtree = new javax.swing.JToggleButton();
        JK48 = new javax.swing.JToggleButton();
        RandomForest = new javax.swing.JToggleButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Atualizar Classificação");

        REPtree.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        REPtree.setForeground(new java.awt.Color(0, 0, 204));
        REPtree.setText("REPTree");
        REPtree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REPtreeActionPerformed(evt);
            }
        });

        JK48.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        JK48.setForeground(new java.awt.Color(0, 0, 204));
        JK48.setText("JK48");
        JK48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JK48ActionPerformed(evt);
            }
        });

        RandomForest.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        RandomForest.setForeground(new java.awt.Color(0, 0, 204));
        RandomForest.setText("RandomForest");
        RandomForest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RandomForestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JK48, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(REPtree, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(RandomForest)))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JK48, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(REPtree, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(RandomForest, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void REPtreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REPtreeActionPerformed
               ClienteCidadeService entity = ServiceFactory.getClienteCidadeService();

        TipoSuporteService entity2 = ServiceFactory.getTipoSuporteService();

        ClassificacaoClienteService entity3 = ServiceFactory.getClassificacaoClienteService();

        /*armazena quantas ocorrencias do tipo ocorreu*/
        int AdministracaoSistema = 0,
                Compra = 0,
                Venda = 0,
                Transferencia = 0,
                Estoque = 0,
                Financeiro = 0,
                Fiscal = 0,
                Relatorio = 0,
                SNGPC = 0,
                Integracao = 0,
                Client = 0,
                Crediario = 0,
                Ecommerce = 0,
                PBM = 0,
                Servidor = 0,
                Geral = 0;

        String temp;
        ClienteCidade b;
        ClassificacaoCliente c;
        TipoSuporte to;
        List<Suporte> lo;
        List<ClienteCidade> lb;
        /*recupera todos os bairros*/
        lb = entity.recuperaClientes();
        Iterator iterator = lb.iterator();

        while (iterator.hasNext() == true) {/*recupera bairro e atualiza sua classificação*/
            int pontuacaoTotal = 0;
            b = (ClienteCidade) iterator.next();
            /*recupera classificação do bairro*/
            c = entity.recuperaClassificacao(b.getIdClassificacaoCliente());
            /*recupera todas as ocorrecias desse bairro dos ultimos 3 meses*/
            java.util.Date d = new java.util.Date();
            d.getTime();
            Calendar cal = new GregorianCalendar();
            cal.setTime(d);
            java.sql.Date data5 = new java.sql.Date(cal.getTimeInMillis());
            cal.add(Calendar.MONTH, -3);
            java.sql.Date data6 = new java.sql.Date(cal.getTimeInMillis());
            lo = entity.recuperaSuportes(b.getIdClienteCidade(), data6, data5);
            Suporte o;
            /*para cada ocorrencia recupera-se sua gravidade e conta quantas ocorrencias de cada tipo existe*/
            for (int i = 0; i < lo.size(); i++) {/*recupera uma ocorrecia da lista*/
                o = lo.get(i);
                to = entity2.recuperaTipoOcorrencia(o.getIdTipoSuporte());

                //System.out.println( o.getIdSuporte() );
                //System.out.println(to.getCategoria());
                temp = to.getCategoria();
                pontuacaoTotal = pontuacaoTotal + to.getGravidade();

                switch (temp) {

                    case "AdministracaoSistema":
                        AdministracaoSistema++;
                        break;
                    case "Compra":
                        Compra++;
                        break;
                    case "Venda":
                        Venda++;
                        break;
                    case "Transferencia":
                        Transferencia++;
                        break;
                    case "Estoque":
                        Estoque++;
                        break;
                    case "Financeiro":
                        Financeiro++;
                        break;
                    case "Fiscal":
                        Fiscal++;
                        break;
                    case "Relatorio":
                        Relatorio++;
                        break;
                    case "SNGPC":
                        SNGPC++;
                        break;
                    case "Integracao":
                        Integracao++;
                        break;
                    case "Client":
                        Client++;
                        break;
                    case "Crediario":
                        Crediario++;
                        break;
                    case "Ecommerce":
                        Ecommerce++;
                        break;
                    case "PBM":
                        PBM++;
                        break;
                    case "Servidor":
                        Servidor++;
                        break;
                    case "Geral":
                        Geral++;
                        break;
                }

            }

            // importa os dados
            ConverterUtils.DataSource source = null;
            try {
                source = new ConverterUtils.DataSource(aquivo);
            } catch (Exception ex) {
                Logger.getLogger(AtualizarClassificacao.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Instances D = source.getDataSet();
            Instances D = null;
            try {
                D = new Instances(source.getDataSet());
            } catch (Exception ex) {
                Logger.getLogger(AtualizarClassificacao.class.getName()).log(Level.SEVERE, null, ex);
            }

            // espeficicação do atributo classe 
            // ajusta o classidex para o atributo a ser previsto
            if (D.classIndex() == -1) {
                D.setClassIndex(D.numAttributes() - 1);
            }

            REPTree k4 = new REPTree();
            try {
                k4.buildClassifier(D);
            } catch (Exception ex) {
                Logger.getLogger(AtualizarClassificacao.class.getName()).log(Level.SEVERE, null, ex);
            }

            // criação de uma nova instância
            Instance newInst = new DenseInstance(113);
            newInst.setDataset(D);
            newInst.setValue(0, AdministracaoSistema);
            newInst.setValue(1, Compra);
            newInst.setValue(2, Venda);
            newInst.setValue(3, Transferencia);
            newInst.setValue(4, Estoque);
            newInst.setValue(5, Financeiro);
            newInst.setValue(6, Fiscal);
            newInst.setValue(7, Relatorio);
            newInst.setValue(8, SNGPC);
            newInst.setValue(9, Integracao);
            newInst.setValue(10, Client);
            newInst.setValue(11, Crediario);
            newInst.setValue(13, Ecommerce);
            newInst.setValue(14, PBM);
            newInst.setValue(15, Servidor);
            newInst.setValue(16, Geral);

            // classificação de uma nova instância
            double pred = 0;
            try {
                pred = k4.classifyInstance(newInst);
            } catch (Exception ex) {
                Logger.getLogger(AtualizarClassificacao.class.getName()).log(Level.SEVERE, null, ex);
            }

            // imprime a string correspondente ao valor de pred 
            Attribute a = D.attribute(17);
            String predClass = a.value((int) pred);

            System.out.println("Predição: " + predClass);

            if (predClass.equals(c.getStatus())) {
                /*recupera data atual*/
                cal = Calendar.getInstance();
                java.sql.Date data = new java.sql.Date(cal.getTimeInMillis());

                /*descobre a diferença da data atual e a data da ultima atualização*/
                LocalDate data3 = data.toLocalDate();
                LocalDate data4 = c.getDataUltimaAtualização().toLocalDate();
                Period p = Period.between(data4, data3);
                int difDias = p.getDays();
                int difMes = p.getMonths();
                int difAnos = p.getYears();

                /*aproxima mes para 30 dias e ano para 365 dias*/
                difMes = difMes * 30;
                difAnos = difAnos * 365;
                int diferenca = difDias + difMes + difAnos;
                diferenca = diferenca + c.getNumDias();

                /*cria nova classificação de bairro*/
 /*melhorar diferença de datas e colocar con.close em todos os daos*/
                ClassificacaoCliente newclassificacao = new ClassificacaoCliente(c.getIdClassificacaoCliente());
                String novoPredClass = predClass;
                newclassificacao.setStatus(novoPredClass);
                newclassificacao.setNumDias(diferenca);
                newclassificacao.setPontuacao(pontuacaoTotal);
                newclassificacao.setDataUltimaAtualização(data);

                /*atualiza o banco de dados*/
                entity3.update(newclassificacao);
            } else {/*recupera data atual*/
                cal = Calendar.getInstance();
                java.sql.Date data = new java.sql.Date(cal.getTimeInMillis());

                /*cria nova classificação de bairro*/
                ClassificacaoCliente newclassificacao = new ClassificacaoCliente(c.getIdClassificacaoCliente());
                newclassificacao.setStatus(predClass);
                newclassificacao.setNumDias(1);
                newclassificacao.setPontuacao(pontuacaoTotal);
                newclassificacao.setDataUltimaAtualização(data);

                /*atualiza o banco de dados*/
                entity3.update(newclassificacao);
            }
        }
        JOptionPane.showMessageDialog(null, "Atualização Atualizada!");

    }//GEN-LAST:event_REPtreeActionPerformed

    private void JK48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JK48ActionPerformed
        ClienteCidadeService entity = ServiceFactory.getClienteCidadeService();

        TipoSuporteService entity2 = ServiceFactory.getTipoSuporteService();

        ClassificacaoClienteService entity3 = ServiceFactory.getClassificacaoClienteService();

        /*armazena quantas ocorrencias do tipo ocorreu*/
        int AdministracaoSistema = 0,
                Compra = 0,
                Venda = 0,
                Transferencia = 0,
                Estoque = 0,
                Financeiro = 0,
                Fiscal = 0,
                Relatorio = 0,
                SNGPC = 0,
                Integracao = 0,
                Client = 0,
                Crediario = 0,
                Ecommerce = 0,
                PBM = 0,
                Servidor = 0,
                Geral = 0;

        String temp;
        ClienteCidade b;
        ClassificacaoCliente c;
        TipoSuporte to;
        List<Suporte> lo;
        List<ClienteCidade> lb;
        /*recupera todos os bairros*/
        lb = entity.recuperaClientes();
        Iterator iterator = lb.iterator();

        while (iterator.hasNext() == true) {/*recupera bairro e atualiza sua classificação*/
            int pontuacaoTotal = 0;
            b = (ClienteCidade) iterator.next();
            /*recupera classificação do bairro*/
            c = entity.recuperaClassificacao(b.getIdClassificacaoCliente());
            /*recupera todas as ocorrecias desse bairro dos ultimos 3 meses*/
            java.util.Date d = new java.util.Date();
            d.getTime();
            Calendar cal = new GregorianCalendar();
            cal.setTime(d);
            java.sql.Date data5 = new java.sql.Date(cal.getTimeInMillis());
            cal.add(Calendar.MONTH, -3);
            java.sql.Date data6 = new java.sql.Date(cal.getTimeInMillis());
            lo = entity.recuperaSuportes(b.getIdClienteCidade(), data6, data5);
            Suporte o;
            /*para cada ocorrencia recupera-se sua gravidade e conta quantas ocorrencias de cada tipo existe*/
            for (int i = 0; i < lo.size(); i++) {/*recupera uma ocorrecia da lista*/
                o = lo.get(i);
                to = entity2.recuperaTipoOcorrencia(o.getIdTipoSuporte());

                //System.out.println( o.getIdSuporte() );
                //System.out.println(to.getCategoria());
                temp = to.getCategoria();
                pontuacaoTotal = pontuacaoTotal + to.getGravidade();

                switch (temp) {

                    case "AdministracaoSistema":
                        AdministracaoSistema++;
                        break;
                    case "Compra":
                        Compra++;
                        break;
                    case "Venda":
                        Venda++;
                        break;
                    case "Transferencia":
                        Transferencia++;
                        break;
                    case "Estoque":
                        Estoque++;
                        break;
                    case "Financeiro":
                        Financeiro++;
                        break;
                    case "Fiscal":
                        Fiscal++;
                        break;
                    case "Relatorio":
                        Relatorio++;
                        break;
                    case "SNGPC":
                        SNGPC++;
                        break;
                    case "Integracao":
                        Integracao++;
                        break;
                    case "Client":
                        Client++;
                        break;
                    case "Crediario":
                        Crediario++;
                        break;
                    case "Ecommerce":
                        Ecommerce++;
                        break;
                    case "PBM":
                        PBM++;
                        break;
                    case "Servidor":
                        Servidor++;
                        break;
                    case "Geral":
                        Geral++;
                        break;
                }

            }

            // importa os dados
            ConverterUtils.DataSource source = null;
            try {
                source = new ConverterUtils.DataSource(aquivo);
            } catch (Exception ex) {
                Logger.getLogger(AtualizarClassificacao.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Instances D = source.getDataSet();
            Instances D = null;
            try {
                D = new Instances(source.getDataSet());
            } catch (Exception ex) {
                Logger.getLogger(AtualizarClassificacao.class.getName()).log(Level.SEVERE, null, ex);
            }

            // espeficicação do atributo classe 
            // ajusta o classidex para o atributo a ser previsto
            if (D.classIndex() == -1) {
                D.setClassIndex(D.numAttributes() - 1);
            }

            // Construção do modelo classificador
            J48 k3 = new J48();
            try {
                k3.buildClassifier(D);
            } catch (Exception ex) {
                Logger.getLogger(AtualizarClassificacao.class.getName()).log(Level.SEVERE, null, ex);
            }

            // criação de uma nova instância
            Instance newInst = new DenseInstance(113);
            newInst.setDataset(D);
            newInst.setValue(0, AdministracaoSistema);
            newInst.setValue(1, Compra);
            newInst.setValue(2, Venda);
            newInst.setValue(3, Transferencia);
            newInst.setValue(4, Estoque);
            newInst.setValue(5, Financeiro);
            newInst.setValue(6, Fiscal);
            newInst.setValue(7, Relatorio);
            newInst.setValue(8, SNGPC);
            newInst.setValue(9, Integracao);
            newInst.setValue(10, Client);
            newInst.setValue(11, Crediario);
            newInst.setValue(13, Ecommerce);
            newInst.setValue(14, PBM);
            newInst.setValue(15, Servidor);
            newInst.setValue(16, Geral);

            // classificação de uma nova instância
            double pred = 0;
            try {
                pred = k3.classifyInstance(newInst);
            } catch (Exception ex) {
                Logger.getLogger(AtualizarClassificacao.class.getName()).log(Level.SEVERE, null, ex);
            }

            // imprime a string correspondente ao valor de pred 
            Attribute a = D.attribute(17);
            String predClass = a.value((int) pred);

            System.out.println("Predição: " + predClass);

            if (predClass.equals(c.getStatus())) {
                /*recupera data atual*/
                cal = Calendar.getInstance();
                java.sql.Date data = new java.sql.Date(cal.getTimeInMillis());

                /*descobre a diferença da data atual e a data da ultima atualização*/
                LocalDate data3 = data.toLocalDate();
                LocalDate data4 = c.getDataUltimaAtualização().toLocalDate();
                Period p = Period.between(data4, data3);
                int difDias = p.getDays();
                int difMes = p.getMonths();
                int difAnos = p.getYears();

                /*aproxima mes para 30 dias e ano para 365 dias*/
                difMes = difMes * 30;
                difAnos = difAnos * 365;
                int diferenca = difDias + difMes + difAnos;
                diferenca = diferenca + c.getNumDias();

                /*cria nova classificação de bairro*/
 /*melhorar diferença de datas e colocar con.close em todos os daos*/
                ClassificacaoCliente newclassificacao = new ClassificacaoCliente(c.getIdClassificacaoCliente());
                String novoPredClass = predClass;
                newclassificacao.setStatus(novoPredClass);
                newclassificacao.setNumDias(diferenca);
                newclassificacao.setPontuacao(pontuacaoTotal);
                newclassificacao.setDataUltimaAtualização(data);

                /*atualiza o banco de dados*/
                entity3.update(newclassificacao);
            } else {/*recupera data atual*/
                cal = Calendar.getInstance();
                java.sql.Date data = new java.sql.Date(cal.getTimeInMillis());

                /*cria nova classificação de bairro*/
                ClassificacaoCliente newclassificacao = new ClassificacaoCliente(c.getIdClassificacaoCliente());
                newclassificacao.setStatus(predClass);
                newclassificacao.setNumDias(1);
                newclassificacao.setPontuacao(pontuacaoTotal);
                newclassificacao.setDataUltimaAtualização(data);

                /*atualiza o banco de dados*/
                entity3.update(newclassificacao);
            }
        }
        JOptionPane.showMessageDialog(null, "Atualização Atualizada!");

    }//GEN-LAST:event_JK48ActionPerformed

    private void RandomForestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RandomForestActionPerformed
               ClienteCidadeService entity = ServiceFactory.getClienteCidadeService();

        TipoSuporteService entity2 = ServiceFactory.getTipoSuporteService();

        ClassificacaoClienteService entity3 = ServiceFactory.getClassificacaoClienteService();

        /*armazena quantas ocorrencias do tipo ocorreu*/
        int AdministracaoSistema = 0,
                Compra = 0,
                Venda = 0,
                Transferencia = 0,
                Estoque = 0,
                Financeiro = 0,
                Fiscal = 0,
                Relatorio = 0,
                SNGPC = 0,
                Integracao = 0,
                Client = 0,
                Crediario = 0,
                Ecommerce = 0,
                PBM = 0,
                Servidor = 0,
                Geral = 0;

        String temp;
        ClienteCidade b;
        ClassificacaoCliente c;
        TipoSuporte to;
        List<Suporte> lo;
        List<ClienteCidade> lb;
        /*recupera todos os bairros*/
        lb = entity.recuperaClientes();
        Iterator iterator = lb.iterator();

        while (iterator.hasNext() == true) {/*recupera bairro e atualiza sua classificação*/
            int pontuacaoTotal = 0;
            b = (ClienteCidade) iterator.next();
            /*recupera classificação do bairro*/
            c = entity.recuperaClassificacao(b.getIdClassificacaoCliente());
            /*recupera todas as ocorrecias desse bairro dos ultimos 3 meses*/
            java.util.Date d = new java.util.Date();
            d.getTime();
            Calendar cal = new GregorianCalendar();
            cal.setTime(d);
            java.sql.Date data5 = new java.sql.Date(cal.getTimeInMillis());
            cal.add(Calendar.MONTH, -3);
            java.sql.Date data6 = new java.sql.Date(cal.getTimeInMillis());
            lo = entity.recuperaSuportes(b.getIdClienteCidade(), data6, data5);
            Suporte o;
            /*para cada ocorrencia recupera-se sua gravidade e conta quantas ocorrencias de cada tipo existe*/
            for (int i = 0; i < lo.size(); i++) {/*recupera uma ocorrecia da lista*/
                o = lo.get(i);
                to = entity2.recuperaTipoOcorrencia(o.getIdTipoSuporte());

                //System.out.println( o.getIdSuporte() );
                //System.out.println(to.getCategoria());
                temp = to.getCategoria();
                pontuacaoTotal = pontuacaoTotal + to.getGravidade();

                switch (temp) {

                    case "AdministracaoSistema":
                        AdministracaoSistema++;
                        break;
                    case "Compra":
                        Compra++;
                        break;
                    case "Venda":
                        Venda++;
                        break;
                    case "Transferencia":
                        Transferencia++;
                        break;
                    case "Estoque":
                        Estoque++;
                        break;
                    case "Financeiro":
                        Financeiro++;
                        break;
                    case "Fiscal":
                        Fiscal++;
                        break;
                    case "Relatorio":
                        Relatorio++;
                        break;
                    case "SNGPC":
                        SNGPC++;
                        break;
                    case "Integracao":
                        Integracao++;
                        break;
                    case "Client":
                        Client++;
                        break;
                    case "Crediario":
                        Crediario++;
                        break;
                    case "Ecommerce":
                        Ecommerce++;
                        break;
                    case "PBM":
                        PBM++;
                        break;
                    case "Servidor":
                        Servidor++;
                        break;
                    case "Geral":
                        Geral++;
                        break;
                }

            }

            // importa os dados
            ConverterUtils.DataSource source = null;
            try {
                source = new ConverterUtils.DataSource(aquivo);
            } catch (Exception ex) {
                Logger.getLogger(AtualizarClassificacao.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Instances D = source.getDataSet();
            Instances D = null;
            try {
                D = new Instances(source.getDataSet());
            } catch (Exception ex) {
                Logger.getLogger(AtualizarClassificacao.class.getName()).log(Level.SEVERE, null, ex);
            }

            // espeficicação do atributo classe 
            // ajusta o classidex para o atributo a ser previsto
            if (D.classIndex() == -1) {
                D.setClassIndex(D.numAttributes() - 1);
            }

            // Construção do modelo classificador
            RandomForest k3 = new RandomForest();
            try {
                k3.buildClassifier(D);
            } catch (Exception ex) {
                Logger.getLogger(AtualizarClassificacao.class.getName()).log(Level.SEVERE, null, ex);
            }

            // criação de uma nova instância
            Instance newInst = new DenseInstance(113);
            newInst.setDataset(D);
            newInst.setValue(0, AdministracaoSistema);
            newInst.setValue(1, Compra);
            newInst.setValue(2, Venda);
            newInst.setValue(3, Transferencia);
            newInst.setValue(4, Estoque);
            newInst.setValue(5, Financeiro);
            newInst.setValue(6, Fiscal);
            newInst.setValue(7, Relatorio);
            newInst.setValue(8, SNGPC);
            newInst.setValue(9, Integracao);
            newInst.setValue(10, Client);
            newInst.setValue(11, Crediario);
            newInst.setValue(13, Ecommerce);
            newInst.setValue(14, PBM);
            newInst.setValue(15, Servidor);
            newInst.setValue(16, Geral);

            // classificação de uma nova instância
            double pred = 0;
            try {
                pred = k3.classifyInstance(newInst);
            } catch (Exception ex) {
                Logger.getLogger(AtualizarClassificacao.class.getName()).log(Level.SEVERE, null, ex);
            }

            // imprime a string correspondente ao valor de pred 
            Attribute a = D.attribute(17);
            String predClass = a.value((int) pred);

            System.out.println("Predição: " + predClass);

            if (predClass.equals(c.getStatus())) {
                /*recupera data atual*/
                cal = Calendar.getInstance();
                java.sql.Date data = new java.sql.Date(cal.getTimeInMillis());

                /*descobre a diferença da data atual e a data da ultima atualização*/
                LocalDate data3 = data.toLocalDate();
                LocalDate data4 = c.getDataUltimaAtualização().toLocalDate();
                Period p = Period.between(data4, data3);
                int difDias = p.getDays();
                int difMes = p.getMonths();
                int difAnos = p.getYears();

                /*aproxima mes para 30 dias e ano para 365 dias*/
                difMes = difMes * 30;
                difAnos = difAnos * 365;
                int diferenca = difDias + difMes + difAnos;
                diferenca = diferenca + c.getNumDias();

                /*cria nova classificação de bairro*/
 /*melhorar diferença de datas e colocar con.close em todos os daos*/
                ClassificacaoCliente newclassificacao = new ClassificacaoCliente(c.getIdClassificacaoCliente());
                String novoPredClass = predClass;
                newclassificacao.setStatus(novoPredClass);
                newclassificacao.setNumDias(diferenca);
                newclassificacao.setPontuacao(pontuacaoTotal);
                newclassificacao.setDataUltimaAtualização(data);

                /*atualiza o banco de dados*/
                entity3.update(newclassificacao);
            } else {/*recupera data atual*/
                cal = Calendar.getInstance();
                java.sql.Date data = new java.sql.Date(cal.getTimeInMillis());

                /*cria nova classificação de bairro*/
                ClassificacaoCliente newclassificacao = new ClassificacaoCliente(c.getIdClassificacaoCliente());
                newclassificacao.setStatus(predClass);
                newclassificacao.setNumDias(1);
                newclassificacao.setPontuacao(pontuacaoTotal);
                newclassificacao.setDataUltimaAtualização(data);

                /*atualiza o banco de dados*/
                entity3.update(newclassificacao);
            }
        }
        JOptionPane.showMessageDialog(null, "Atualização Atualizada!");

    }//GEN-LAST:event_RandomForestActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton JK48;
    private javax.swing.JToggleButton REPtree;
    private javax.swing.JToggleButton RandomForest;
    // End of variables declaration//GEN-END:variables
}
