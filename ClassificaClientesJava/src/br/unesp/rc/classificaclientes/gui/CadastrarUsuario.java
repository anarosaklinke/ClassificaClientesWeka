/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.classificaclientes.gui;

import br.unesp.rc.classificaclientes.model.ClassificacaoCliente;
import br.unesp.rc.classificaclientes.model.ClienteCidade;
import br.unesp.rc.classificaclientes.model.Contato;
import br.unesp.rc.classificaclientes.model.Endereco;
import br.unesp.rc.classificaclientes.model.Login;
import br.unesp.rc.classificaclientes.model.Pessoa;
import br.unesp.rc.classificaclientes.service.ClassificacaoClienteService;
import br.unesp.rc.classificaclientes.service.ClienteCidadeService;
import br.unesp.rc.classificaclientes.service.ContatoService;
import br.unesp.rc.classificaclientes.service.EnderecoService;
import br.unesp.rc.classificaclientes.service.LoginService;
import br.unesp.rc.classificaclientes.service.PessoaService;
import br.unesp.rc.classificaclientes.service.ServiceFactory;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author PICHAU
 */
public class CadastrarUsuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form CadastrarUsuario
     */
    public CadastrarUsuario() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        MaskFormatter mascaraCpf = null;
        try{
            mascaraCpf = new MaskFormatter("#########-##");
        }
        catch(ParseException excp) {
            System.err.println("Erro na formatação: " + excp.getMessage());
            System.exit(-1);
        }
        cpf = new javax.swing.JFormattedTextField(mascaraCpf);
        sexo = new javax.swing.JComboBox<>();
        MaskFormatter mascaraData = null;
        try{
            mascaraData = new MaskFormatter("##/##/####");
            mascaraData.setPlaceholderCharacter('_');
        }
        catch(ParseException excp) {
            System.err.println("Erro na formatação: " + excp.getMessage());
            System.exit(-1);
        }
        dataNascimento = new javax.swing.JFormattedTextField(mascaraData);
        usuario = new javax.swing.JTextField();
        senha = new javax.swing.JPasswordField();
        farmacia = new javax.swing.JTextField();
        cidadeFarmacia = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        rua = new javax.swing.JTextField();
        bairro = new javax.swing.JTextField();
        cidade = new javax.swing.JTextField();
        estado = new javax.swing.JTextField();
        pais = new javax.swing.JTextField();
        //Define as máscaras
        MaskFormatter mascaraCep = null;

        try{
            mascaraCep = new MaskFormatter("#####-###");

            mascaraCep.setPlaceholderCharacter('_');

        }
        catch(ParseException excp) {
            System.err.println("Erro na formatação: " + excp.getMessage());
            System.exit(-1);
        }
        cep = new javax.swing.JFormattedTextField(mascaraCep);
        jButton1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        //Define as máscaras
        MaskFormatter mascaraTel = null;

        try{
            mascaraTel = new MaskFormatter("(##)####-####");
            mascaraTel.setPlaceholderCharacter('_');
        }
        catch(ParseException excp) {
            System.err.println("Erro na formatação: " + excp.getMessage());
            System.exit(-1);
        }
        residencial = new javax.swing.JFormattedTextField(mascaraTel);
        //Define as máscaras
        MaskFormatter mascaraCom = null;

        try{
            mascaraCom = new MaskFormatter("(##)####-####");
            mascaraCom.setPlaceholderCharacter('_');
        }
        catch(ParseException excp) {
            System.err.println("Erro na formatação: " + excp.getMessage());
            System.exit(-1);
        }
        comercial = new javax.swing.JFormattedTextField(mascaraCom);
        MaskFormatter mascaraCel = null;

        try{
            mascaraCel = new MaskFormatter("(##)#####-####");
            mascaraCel.setPlaceholderCharacter('_');
        }
        catch(ParseException excp) {
            System.err.println("Erro na formatação: " + excp.getMessage());
            System.exit(-1);
        }
        celular = new javax.swing.JFormattedTextField(mascaraCel);
        email = new javax.swing.JTextField();
        numero = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro de Usuário");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Cadastro de Usuário");

        jLabel2.setText("Nome*");

        jLabel3.setText("CPF*");

        jLabel4.setText("Sexo*");

        jLabel5.setText("Data de Nascimento*");

        jLabel6.setText("Usuário*");

        jLabel7.setText("Senha*");

        jLabel8.setText("Farmácia*");

        jLabel9.setText("Cidade*");

        cpf.setBounds(150,120,100,20);
        cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfActionPerformed(evt);
            }
        });

        sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feminino", "Masculino" }));
        sexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexoActionPerformed(evt);
            }
        });

        dataNascimento.setBounds(150,160,100,20);

        senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaActionPerformed(evt);
            }
        });

        farmacia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                farmaciaActionPerformed(evt);
            }
        });

        cidadeFarmacia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidadeFarmaciaActionPerformed(evt);
            }
        });

        jLabel10.setText("Rua");

        jLabel11.setText("Numero");

        jLabel12.setText("Bairro");

        jLabel13.setText("Cidade");

        jLabel14.setText("Estado");

        jLabel20.setText("Pais");

        jLabel15.setText("CEP");

        bairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bairroActionPerformed(evt);
            }
        });

        cidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidadeActionPerformed(evt);
            }
        });

        pais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paisActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 51));
        jButton1.setText("CADASTRAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel16.setText("Tel Residencial");

        jLabel17.setText("Tel Comercial");

        jLabel18.setText("Celular");

        jLabel19.setText("Email");

        comercial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comercialActionPerformed(evt);
            }
        });

        numero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nome)
                            .addComponent(cpf))
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cidadeFarmacia))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(10, 10, 10)
                                .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(16, 16, 16)
                                .addComponent(senha))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(farmacia, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pais, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                    .addComponent(cidade)
                                    .addComponent(rua)
                                    .addComponent(bairro, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(estado, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cep)
                                    .addComponent(numero, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(residencial)
                                    .addComponent(comercial)
                                    .addComponent(celular)
                                    .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel20)
                            .addComponent(jLabel11))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(178, 178, 178))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(201, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(284, 284, 284))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel16)
                    .addComponent(residencial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel11)
                            .addComponent(jLabel17)
                            .addComponent(comercial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cpf, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20)
                        .addComponent(pais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(farmacia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cidadeFarmacia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexoActionPerformed

    private void senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaActionPerformed

    private void farmaciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_farmaciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_farmaciaActionPerformed

    private void cidadeFarmaciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidadeFarmaciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cidadeFarmaciaActionPerformed

    private void bairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bairroActionPerformed

    private void cidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cidadeActionPerformed

    private void paisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paisActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        if ((nome.getText().isEmpty()) ||
            (cpf.getText().isEmpty()) ||
            (dataNascimento.getText().isEmpty()) ||
            (usuario.getText().isEmpty()) ||
            (senha.getText().isEmpty()) ||
            (farmacia.getText().isEmpty()) ||
            (cidadeFarmacia.getText().isEmpty())
        ) {
            JOptionPane.showMessageDialog(null, "Os campos com * são OBRIGATÒRIOS");
        }
        else {

            PessoaService entity = ServiceFactory.getPessoaService();
            LoginService entity2 = ServiceFactory.getLoginService();
            EnderecoService entity3 = ServiceFactory.getEnderecoService();
            ContatoService entity4 = ServiceFactory.getContatoService();
            ClienteCidadeService entity5 = ServiceFactory.getClienteCidadeService();
            ClassificacaoClienteService entity6 = ServiceFactory.getClassificacaoClienteService();

            Scanner entrada = new Scanner(System.in);
            long idPessoa;

            /*seta id de cliente*/
            idPessoa = entity.recuperaUltimoId();
            if(idPessoa == -1)
            {idPessoa = 1;
            }
            else
            {idPessoa++;
            }
            Pessoa pessoa = new Pessoa(idPessoa);

            Date data;
            int idade;

            String d;

            /*seta data de nascimento*/
            d = dataNascimento.getText();
            String[] lista;
            lista =  d.split("/");
            Calendar cal = Calendar.getInstance();
            int temp = Integer.parseInt(lista[0]);

            cal.set(Calendar.DAY_OF_MONTH,  temp);
            temp = Integer.parseInt(lista[1]);
            temp--;
            cal.set(Calendar.MONTH, temp);
            temp = Integer.parseInt(lista[2]);
            cal.set(Calendar.YEAR, temp);
            data = new java.sql.Date(cal.getTimeInMillis());

            /*recupera data atual*/
            cal = Calendar.getInstance();
            java.sql.Date data2 = new java.sql.Date(cal.getTimeInMillis());

            /*descobre a idade*/
            LocalDate data3 = data2.toLocalDate();
            LocalDate data4 = data.toLocalDate();
            Period p = Period.between(data4, data3);
            idade = p.getYears();
            System.out.println("idade = " + idade);

            pessoa.setSexo( (sexo.getSelectedItem()).toString() );
            pessoa.setCpf(cpf.getText());
            pessoa.setDataNascimento(data);
            pessoa.setIdade(idade);
            pessoa.setNome(nome.getText());

            /*recupera id de Login*/
            long idLogin = entity2.recuperaUltimoId();
            if(idLogin == -1)
            {idLogin = 1;
            }
            else
            {idLogin++;
            }

            /*seta informações de Login endereco login não é administrador*/
            Login login = new Login(idLogin, false);
            login.setSenha(senha.getText());
            login.setUsuario(usuario.getText());

            pessoa.setLogin(login.getIdLogin());

            /*recupera id de endereco*/
            long idEndereco = entity3.recuperaUltimoId();
            if(idEndereco == -1)
            {idEndereco = 1;
            }
            else
            {idEndereco++;
            }

            /*recupera id de Cliente*/
            long idCliente = entity5.recuperaUltimoId();
            if(idCliente == -1)
            {idCliente = 1;
            }
            else
            {idCliente++;
            }

            ClienteCidade clienteCidade = new ClienteCidade(idCliente);
            clienteCidade.setNome(farmacia.getText());
            clienteCidade.setCidade(cidadeFarmacia.getText());
            clienteCidade.setIdPessoa(idPessoa);

            /*recupera id de ClassificacaoCliente*/
            long idClassifica = entity6.recuperaUltimoId();
            if(idClassifica == -1)
            {idClassifica = 1;
            }
            else
            {idClassifica++;
            }

            ClassificacaoCliente classifica = new ClassificacaoCliente(idClassifica);
            clienteCidade.setIdClassificacaoCliente(idClassifica);

            classifica.setNumDias(0);
            classifica.setStatus("verde");
            classifica.setPontuacao(0);

            /*recupera data atual*/
            cal = Calendar.getInstance();
            data2 = new java.sql.Date(cal.getTimeInMillis());

            classifica.setDataUltimaAtualização(data2);

            /*cria endereço*/
            Endereco endereco = new Endereco(idEndereco);

            if (bairro.getText().isEmpty()){
                endereco.setCidade(null);
            }else{
                endereco.setCidade(bairro.getText());
            }
            if (cep.getText().isEmpty()){
                endereco.setCidade(null);
            }else{
                endereco.setCidade(cep.getText());
            }
            if (cidade.getText().isEmpty()){
                endereco.setCidade(null);
            }else{
                endereco.setCidade(cidade.getText());
            }
            if (estado.getText().isEmpty()){
                endereco.setEstado(null);
            }else{
                endereco.setEstado(estado.getText());
            }
            if (rua.getText().isEmpty()){
                endereco.setNumero(0);
            }else{
                endereco.setNumero(Integer.parseInt(rua.getText()));
            }
            if (numero.getText().isEmpty()){
                endereco.setRua(null);
            }else{
                endereco.setRua(numero.getText());
            }
            if (pais.getText().isEmpty()){
                endereco.setPais(null);
            }else{
                endereco.setPais(pais.getText());
            }

            pessoa.setEndereco(endereco.getIdEndereco());

            /*cria Contato*/
            long idContato = entity4.recuperaUltimoId();
            if(idContato == -1)
            {idContato = 1;
            }
            else
            {idContato++;
            }
            Contato contato = new Contato(idContato);

            if (residencial.getText().isEmpty()){
                residencial = null;
            }

            contato.setTelRes(residencial.getText());

            if (comercial.getText().isEmpty()){
                contato.setTelCom(null);
            }else{
                contato.setTelCom(comercial.getText());
            }

            if (celular.getText().isEmpty()){
                contato.setCelular(null);
            }else{
                contato.setCelular(celular.getText());
            }

            if (email.getText().isEmpty()){
                contato.setEmail(null);
            }else{
                contato.setEmail(email.getText());
            }

            pessoa.setIdContato(contato.getIdContato());

            /*salva Login no banco de dados*/
            boolean b;
            b = entity2.save(login);
            if(b == false)
            {System.out.println("Erro: Login não foi salvo no banco de dados ");
            }

            /*salva Endereco no banco de dados*/
            b = entity3.save(endereco);
            if(b == false)
            {System.out.println("Erro: Endereco não foi salvo no banco de dados ");
            }

            /*salva Contato no banco de dados*/
            b = entity4.save(contato);
            if(b == false)
            {System.out.println("Erro: Contato não foi salvo no banco de dados ");
            }

            /*salva Pessoa no banco de dados*/
            b = entity.save(pessoa);
            if(b == false)
            {System.out.println("Erro: Cliente não foi salvo no banco de dados ");
            }
            else
            {System.out.println("Cliente cadastrado com sucesso ");
            }

            b = entity6.save(classifica);
            if(b == false)
            {System.out.println("Erro: classifica não foi salvo no banco de dados ");
            }

            b = entity5.save(clienteCidade);
            if(b == false)
            {System.out.println("Erro: clienteCidade não foi salvo no banco de dados ");
            }

            nome.setText("");
            numero.setText("");
            rua.setText("");
            bairro.setText("");
            nome.setText("");
            cidade.setText("");
            cidadeFarmacia.setText("");
            cep.setText("");
            cpf.setText("");
            senha.setText("");
            usuario.setText("");
            estado.setText("");
            pais.setText("");
            comercial.setText("");
            residencial.setText("");
            celular.setText("");
            farmacia.setText("");
            dataNascimento.setText("");
            
            JOptionPane.showMessageDialog(null, "Cliente Cadastrado!");

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void comercialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comercialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comercialActionPerformed

    private void cpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfActionPerformed

    private void numeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bairro;
    private javax.swing.JFormattedTextField celular;
    private javax.swing.JFormattedTextField cep;
    private javax.swing.JTextField cidade;
    private javax.swing.JTextField cidadeFarmacia;
    private javax.swing.JFormattedTextField comercial;
    private javax.swing.JFormattedTextField cpf;
    private javax.swing.JFormattedTextField dataNascimento;
    private javax.swing.JTextField email;
    private javax.swing.JTextField estado;
    private javax.swing.JTextField farmacia;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField numero;
    private javax.swing.JTextField pais;
    private javax.swing.JFormattedTextField residencial;
    private javax.swing.JTextField rua;
    private javax.swing.JPasswordField senha;
    private javax.swing.JComboBox<String> sexo;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}