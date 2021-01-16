package Demo;

import br.unesp.rc.classificaclientes.model.ClienteCidade;
import br.unesp.rc.classificaclientes.model.ClassificacaoCliente;
import br.unesp.rc.classificaclientes.model.Suporte;
import br.unesp.rc.classificaclientes.model.TipoSuporte;
import br.unesp.rc.classificaclientes.service.ServiceFactory;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import weka.classifiers.trees.J48;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import br.unesp.rc.classificaclientes.service.ClassificacaoClienteService;
import br.unesp.rc.classificaclientes.service.TipoSuporteService;
import br.unesp.rc.classificaclientes.service.ClienteCidadeService;
import weka.classifiers.trees.REPTree;
//import weka.core.converters.ArffSaver;
//import weka.core.converters.CSVLoader;
//import java.io.File;

public class AtualizarClass {

    public AtualizarClass() {
    }

    public void AtualizaClass() throws Exception {

        ClienteCidadeService entity = ServiceFactory.getClienteCidadeService();

        TipoSuporteService entity2 = ServiceFactory.getTipoSuporteService();

        ClassificacaoClienteService entity3 = ServiceFactory.getClassificacaoClienteService();

        /*armazena quantas ocorrencias do tipo ocorreu*/
        int EAD = 0,
                LeituradoBancodeDados = 0,
                UnidadedeNegocio = 0,
                EstaçãoAtiva = 0,
                PessoaProdutoUsuario = 0,
                Cotacao = 0,
                CustoDoProduto = 0,
                DevolucaoDeCompra = 0,
                Fornecedor = 0,
                PedidoDeCompra = 0,
                RecebimentoFisico = 0,
                SugestaoDeCompra = 0,
                Geral = 0,
                CadernoDeOferta = 0,
                DevolucaoDeVenda = 0,
                Encomenda = 0,
                Entrega = 0,
                Fidelidade = 0,
                ImpressoraEcf = 0,
                ImpressoraNaoFiscal = 0,
                Orcamento = 0,
                Remuneracao = 0,
                Sat = 0,
                Tef = 0,
                VendaDeCredito = 0,
                Geral1 = 0,
                Operacoes = 0,
                SugestaoDeTransferencia = 0,
                Geral2 = 0,
                BaixaDeEstoque = 0,
                ColetorDeDados = 0,
                Inventario = 0,
                Geral3 = 0,
                Boleto = 0,
                ConciliacaoBancaria = 0,
                ConciliacaoDeCartao = 0,
                ContaAPagar = 0,
                Dda = 0,
                Extrato = 0,
                PagamentoEletronico = 0,
                Geral4 = 0,
                Integracoes = 0,
                NotaEntrada = 0,
                EmissaoNfe = 0,
                Sped = 0,
                Tributação = 0,
                Cfe = 0,
                Geral5 = 0,
                Dre = 0,
                FluxoDeCaixa = 0,
                RelatorioPai = 0,
                Fiscal = 0,
                AlteracaoDePreco = 0,
                CloseupIms = 0,
                Email = 0,
                Etiqueta = 0,
                GuiaDeMedicamentos = 0,
                PainelDeAtendimentoSenha = 0,
                Geral6 = 0,
                Covisa = 0,
                Inventario2 = 0,
                Operacoes2 = 0,
                Transmissoes = 0,
                Relatorio = 0,
                Geral7 = 0,
                FarmaciaEmCasa = 0,
                Nexxera = 0,
                Plugpharma = 0,
                Procfit = 0,
                Solus = 0,
                Trier = 0,
                Ultrafarma = 0,
                WebDecisor = 0,
                Integrafarma = 0,
                CosmosPro = 0,
                Rappi = 0,
                A7pharma = 0,
                Pdv = 0,
                Fatura = 0,
                Layout = 0,
                WebConvenio = 0,
                Geral8 = 0,
                CafeDigital = 0,
                Ciashop = 0,
                Ezcommerce = 0,
                Magento = 0,
                Big = 0,
                Epharma = 0,
                FarmaciaPopular = 0,
                Funcionalcard = 0,
                Pharmasystem = 0,
                Siscred = 0,
                SystemFarma = 0,
                Trncentr = 0,
                Ultracard = 0,
                Vidalink = 0,
                MonitorPbm = 0,
                Geral9 = 0,
                Pharmalink = 0,
                Geral10 = 0,
                Atualizacao = 0,
                BaseDeDados = 0,
                Instalação = 0,
                Sincronizacao = 0,
                TrocaDeServidor = 0,
                Geral11 = 0,
                Internet = 0,
                Rede = 0,
                Hardware = 0,
                SistemaOperacional = 0,
                Geral12 = 0;

        String temp;
        ClienteCidade b;
        ClassificacaoCliente c;
        TipoSuporte to;
        List<Suporte> lo;
        List<ClienteCidade> lb;
        /*recupera todos os bairros*/
        lb = entity.recuperaClientes();
        Iterator iterator = lb.iterator();

        while (iterator.hasNext() == true) {
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
            cal.add(Calendar.MONTH, -1);
            java.sql.Date data6 = new java.sql.Date(cal.getTimeInMillis());
            lo = entity.recuperaSuportes(b.getIdClienteCidade(), data6, data5);
            Suporte o;
            /*para cada ocorrencia recupera-se sua gravidade e conta quantas ocorrencias de cada tipo existe*/
            for (int i = 0; i < lo.size(); i++) {/*recupera uma ocorrecia da lista*/
                o = lo.get(i);
                to = entity2.recuperaTipoOcorrencia(o.getIdTipoSuporte());
                temp = to.getCategoria();
                pontuacaoTotal = pontuacaoTotal + to.getGravidade();

                switch (temp) {

                    case "EAD":
                        EAD++;
                        break;
                    case "LeituradoBancodeDados":
                        LeituradoBancodeDados++;
                        break;
                    case "UnidadedeNegocio":
                        UnidadedeNegocio++;
                        break;
                    case "EstaçãoAtiva":
                        EstaçãoAtiva++;
                        break;
                    case "PessoaProdutoUsuário":
                        PessoaProdutoUsuario++;
                        break;
                    case "Cotação":
                        Cotacao++;
                        break;
                    case "CustoDoProduto":
                        CustoDoProduto++;
                        break;
                    case "DevoluçãoDeCompra":
                        DevolucaoDeCompra++;
                        break;
                    case "Fornecedor":
                        Fornecedor++;
                        break;
                    case "PedidoDeCompra":
                        PedidoDeCompra++;
                        break;
                    case "RecebimentoFísico":
                        RecebimentoFisico++;
                        break;
                    case "SugestãoDeCompra":
                        SugestaoDeCompra++;
                        break;
                    case "Geral":
                        Geral++;
                        break;
                    case "CadernoDeOferta":
                        CadernoDeOferta++;
                        break;
                    case "DevoluçãoDeVenda":
                        DevolucaoDeVenda++;
                        break;
                    case "Encomenda":
                        Encomenda++;
                        break;
                    case "Entrega":
                        Entrega++;
                        break;
                    case "Fidelidade":
                        Fidelidade++;
                        break;
                    case "ImpressoraEcf":
                        ImpressoraEcf++;
                        break;
                    case "ImpressoraNãoFiscal":
                        ImpressoraNaoFiscal++;
                        break;
                    case "Orçamento":
                        Orcamento++;
                        break;
                    case "Remuneração":
                        Remuneracao++;
                        break;
                    case "Sat":
                        Sat++;
                        break;
                    case "Tef":
                        Tef++;
                        break;
                    case "VendaDeCredito":
                        VendaDeCredito++;
                        break;
                    case "Geral1":
                        Geral1++;
                        break;
                    case "Operacoes":
                        Operacoes++;
                        break;
                    case "SugestãoDeTransferência":
                        SugestaoDeTransferencia++;
                        break;
                    case "Geral2":
                        Geral2++;
                        break;
                    case "BaixaDeEstoque":
                        BaixaDeEstoque++;
                        break;
                    case "ColetorDeDados":
                        ColetorDeDados++;
                        break;
                    case "Inventário":
                        Inventario++;
                        break;
                    case "Geral3":
                        Geral3++;
                        break;
                    case "Boleto":
                        Boleto++;
                        break;
                    case "ConciliaçãoBancária":
                        ConciliacaoBancaria++;
                        break;
                    case "ConciliaçãoDeCartão":
                        ConciliacaoDeCartao++;
                        break;
                    case "ContaAPagar":
                        ContaAPagar++;
                        break;
                    case "Dda":
                        Dda++;
                        break;
                    case "Extrato":
                        Extrato++;
                        break;
                    case "PagamentoEletrônico":
                        PagamentoEletronico++;
                        break;
                    case "Geral4":
                        Geral4++;
                        break;
                    case "Integrações":
                        Integracoes++;
                        break;
                    case "NotaEntrada":
                        NotaEntrada++;
                        break;
                    case "EmissãoNfe":
                        EmissaoNfe++;
                        break;
                    case "Sped":
                        Sped++;
                        break;
                    case "Tributação":
                        Tributação++;
                        break;
                    case "Cfe":
                        Cfe++;
                        break;
                    case "Geral5":
                        Geral5++;
                        break;
                    case "Dre":
                        Dre++;
                        break;
                    case "FluxoDeCaixa":
                        FluxoDeCaixa++;
                        break;
                    case "RelatórioPai":
                        RelatorioPai++;
                        break;
                    case "Fiscal":
                        Fiscal++;
                        break;
                    case "AlteraçãoDePreço":
                        AlteracaoDePreco++;
                        break;
                    case "CloseupIms":
                        CloseupIms++;
                        break;
                    case "Email":
                        Email++;
                        break;
                    case "Etiqueta":
                        Etiqueta++;
                        break;
                    case "GuiaDeMedicamentos":
                        GuiaDeMedicamentos++;
                        break;
                    case "PainelDeAtendimentoSenha":
                        PainelDeAtendimentoSenha++;
                        break;
                    case "Geral6":
                        Geral6++;
                        break;
                    case "Covisa":
                        Covisa++;
                        break;
                    case "Inventário2":
                        Inventario2++;
                        break;
                    case "Operações2":
                        Operacoes2++;
                        break;
                    case "Transmissões":
                        Transmissoes++;
                        break;
                    case "Relatório":
                        Relatorio++;
                        break;
                    case "Geral7":
                        Geral7++;
                        break;
                    case "FarmáciaEmCasa":
                        FarmaciaEmCasa++;
                        break;
                    case "Nexxera":
                        Nexxera++;
                        break;
                    case "Plugpharma":
                        Plugpharma++;
                        break;
                    case "Procfit":
                        Procfit++;
                        break;
                    case "Solus":
                        Solus++;
                        break;
                    case "Trier":
                        Trier++;
                        break;
                    case "Ultrafarma":
                        Ultrafarma++;
                        break;
                    case "WebDecisor":
                        WebDecisor++;
                        break;
                    case "Integrafarma":
                        Integrafarma++;
                        break;
                    case "CosmosPro":
                        CosmosPro++;
                        break;
                    case "Rappi":
                        Rappi++;
                        break;
                    case "A7pharma":
                        A7pharma++;
                        break;
                    case "Pdv":
                        Pdv++;
                        break;
                    case "Fatura":
                        Fatura++;
                        break;
                    case "Layout":
                        Layout++;
                        break;
                    case "WebConvenio":
                        WebConvenio++;
                        break;
                    case "Geral8":
                        Geral8++;
                        break;
                    case "CafeDigital":
                        CafeDigital++;
                        break;
                    case "Ciashop":
                        Ciashop++;
                        break;
                    case "Ezcommerce":
                        Ezcommerce++;
                        break;
                    case "Magento":
                        Magento++;
                        break;
                    case "Big":
                        Big++;
                        break;
                    case "Epharma":
                        Epharma++;
                        break;
                    case "FarmaciaPopular":
                        FarmaciaPopular++;
                        break;
                    case "Funcionalcard":
                        Funcionalcard++;
                        break;
                    case "Pharmasystem":
                        Pharmasystem++;
                        break;
                    case "Siscred":
                        Siscred++;
                        break;
                    case "SystemFarma":
                        SystemFarma++;
                        break;
                    case "Trncentr":
                        Trncentr++;
                        break;
                    case "Ultracard":
                        Ultracard++;
                        break;
                    case "Vidalink":
                        Vidalink++;
                        break;
                    case "MonitorPbm":
                        MonitorPbm++;
                        break;
                    case "Geral9":
                        Geral9++;
                        break;
                    case "Pharmalink":
                        Pharmalink++;
                        break;
                    case "Geral10":
                        Geral10++;
                        break;
                    case "Atualização":
                        Atualizacao++;
                        break;
                    case "BaseDeDados":
                        BaseDeDados++;
                        break;
                    case "Instalação":
                        Instalação++;
                        break;
                    case "Sincronização":
                        Sincronizacao++;
                        break;
                    case "TrocaDeServidor":
                        TrocaDeServidor++;
                        break;
                    case "Geral11":
                        Geral11++;
                        break;
                    case "Internet":
                        Internet++;
                        break;
                    case "Rede":
                        Rede++;
                        break;
                    case "Hardware":
                        Hardware++;
                        break;
                    case "SistemaOperacional":
                        SistemaOperacional++;
                        break;
                    case "Geral12":
                        Geral12++;
                        break;
                }
            }

            // importa os dados
            ConverterUtils.DataSource source = new ConverterUtils.DataSource("dados.arff");
            //Instances D = source.getDataSet();
            Instances D = new Instances(source.getDataSet());

            // espeficicação do atributo classe 
            // ajusta o classidex para o atributo a ser previsto
            if (D.classIndex() == -1) {
                D.setClassIndex(D.numAttributes() - 1);
            }

            // Construção do modelo classificador
            J48 k3 = new J48();
            REPTree k4 = new REPTree();
            
            k3.buildClassifier(D);

            // criação de uma nova instância
            Instance newInst = new DenseInstance(113);
            newInst.setDataset(D);
            newInst.setValue(0, EAD);
            newInst.setValue(1, LeituradoBancodeDados);
            newInst.setValue(2, UnidadedeNegocio);
            newInst.setValue(3, EstaçãoAtiva);
            newInst.setValue(4, PessoaProdutoUsuario);
            newInst.setValue(5, Cotacao);
            newInst.setValue(6, CustoDoProduto);
            newInst.setValue(7, DevolucaoDeCompra);
            newInst.setValue(8, Fornecedor);
            newInst.setValue(9, PedidoDeCompra);
            newInst.setValue(10, RecebimentoFisico);
            newInst.setValue(11, SugestaoDeCompra);
            newInst.setValue(12, Geral);
            newInst.setValue(13, CadernoDeOferta);
            newInst.setValue(14, DevolucaoDeVenda);
            newInst.setValue(15, Encomenda);
            newInst.setValue(16, Entrega);
            newInst.setValue(17, Fidelidade);
            newInst.setValue(18, ImpressoraEcf);
            newInst.setValue(19, ImpressoraNaoFiscal);
            newInst.setValue(20, Orcamento);
            newInst.setValue(21, Remuneracao);
            newInst.setValue(22, Sat);
            newInst.setValue(23, Tef);
            newInst.setValue(24, VendaDeCredito);
            newInst.setValue(25, Geral1);
            newInst.setValue(26, Operacoes);
            newInst.setValue(27, SugestaoDeTransferencia);
            newInst.setValue(28, Geral2);
            newInst.setValue(29, BaixaDeEstoque);
            newInst.setValue(30, ColetorDeDados);
            newInst.setValue(31, Inventario);
            newInst.setValue(32, Geral3);
            newInst.setValue(33, Boleto);
            newInst.setValue(34, ConciliacaoBancaria);
            newInst.setValue(35, ConciliacaoDeCartao);
            newInst.setValue(36, ContaAPagar);
            newInst.setValue(37, Dda);
            newInst.setValue(38, Extrato);
            newInst.setValue(39, PagamentoEletronico);
            newInst.setValue(40, Geral4);
            newInst.setValue(41, Integracoes);
            newInst.setValue(42, NotaEntrada);
            newInst.setValue(43, EmissaoNfe);
            newInst.setValue(44, Sped);
            newInst.setValue(45, Tributação);
            newInst.setValue(46, Cfe);
            newInst.setValue(47, Geral5);
            newInst.setValue(48, Dre);
            newInst.setValue(49, FluxoDeCaixa);
            newInst.setValue(50, RelatorioPai);
            newInst.setValue(51, Fiscal);
            newInst.setValue(52, AlteracaoDePreco);
            newInst.setValue(53, CloseupIms);
            newInst.setValue(54, Email);
            newInst.setValue(55, Etiqueta);
            newInst.setValue(56, GuiaDeMedicamentos);
            newInst.setValue(57, PainelDeAtendimentoSenha);
            newInst.setValue(58, Geral6);
            newInst.setValue(59, Covisa);
            newInst.setValue(60, Inventario2);
            newInst.setValue(61, Operacoes2);
            newInst.setValue(62, Transmissoes);
            newInst.setValue(63, Relatorio);
            newInst.setValue(64, Geral7);
            newInst.setValue(65, FarmaciaEmCasa);
            newInst.setValue(66, Nexxera);
            newInst.setValue(67, Plugpharma);
            newInst.setValue(68, Procfit);
            newInst.setValue(69, Solus);
            newInst.setValue(70, Trier);
            newInst.setValue(71, Ultrafarma);
            newInst.setValue(72, WebDecisor);
            newInst.setValue(73, Integrafarma);
            newInst.setValue(74, CosmosPro);
            newInst.setValue(75, Rappi);
            newInst.setValue(76, A7pharma);
            newInst.setValue(77, Pdv);
            newInst.setValue(78, Fatura);
            newInst.setValue(79, Layout);
            newInst.setValue(80, WebConvenio);
            newInst.setValue(81, Geral8);
            newInst.setValue(82, CafeDigital);
            newInst.setValue(83, Ciashop);
            newInst.setValue(84, Ezcommerce);
            newInst.setValue(85, Magento);
            newInst.setValue(86, Big);
            newInst.setValue(87, Epharma);
            newInst.setValue(88, FarmaciaPopular);
            newInst.setValue(89, Funcionalcard);
            newInst.setValue(90, Pharmasystem);
            newInst.setValue(91, Siscred);
            newInst.setValue(92, SystemFarma);
            newInst.setValue(93, Trncentr);
            newInst.setValue(94, Ultracard);
            newInst.setValue(95, Vidalink);
            newInst.setValue(96, MonitorPbm);
            newInst.setValue(97, Geral9);
            newInst.setValue(98, Pharmalink);
            newInst.setValue(99, Geral10);
            newInst.setValue(100, Atualizacao);
            newInst.setValue(101, BaseDeDados);
            newInst.setValue(102, Instalação);
            newInst.setValue(103, Sincronizacao);
            newInst.setValue(104, TrocaDeServidor);
            newInst.setValue(105, Geral11);
            newInst.setValue(106, Internet);
            newInst.setValue(107, Rede);
            newInst.setValue(108, Hardware);
            newInst.setValue(109, SistemaOperacional);
            newInst.setValue(110, Geral12);

            // classificação de uma nova instância
            k3.setReducedErrorPruning(true);
            double pred = k3.classifyInstance(newInst);
            
            System.out.println(pontuacaoTotal);

            // imprime a string correspondente ao valor de pred 
            Attribute a = D.attribute(112);
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
    }

    public static void main(String[] args) throws Exception {
        AtualizarClass a = new AtualizarClass();
        a.AtualizaClass();
    }
}
