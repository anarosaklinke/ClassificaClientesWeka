package br.unesp.rc.classificaclientes.dao;
import br.unesp.rc.classificaclientes.model.ClienteCidade;
import br.unesp.rc.classificaclientes.model.ClassificacaoCliente;
import br.unesp.rc.classificaclientes.model.Suporte;
import br.unesp.rc.classificaclientes.utils.FabricaConexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteCidadeDAOImpl implements ClienteCidadeDAO{
     @Override
     public boolean save(ClienteCidade clienteCidade){
        boolean b = false;
        Connection con = null;
        PreparedStatement pstm = null;
        
        con = FabricaConexao.getConexao();
        if (con != null) {
            try{
                /*
                 * Setando a conexão para falso, que representa o start da transação
                 */
                con.setAutoCommit(false);

                /*
                 * O trecho abaixo permite a inserção de uma classe ClienteCidade na tabela ClienteCidade
                 */
                pstm = con.prepareStatement(INSERT_CLIENTECIDADE);
                pstm.setLong(1, clienteCidade.getIdClienteCidade());
                pstm.setString(2, clienteCidade.getNome());
                pstm.setString(3, clienteCidade.getCidade());
                pstm.setLong(4, clienteCidade.getIdClassificacaoCliente());
                pstm.setLong(5, clienteCidade.getIdPessoa());
                pstm.executeUpdate();
                /*
                 * Executando o commit da transação.  
                 */
                con.commit();
                con.close();
                b = true;
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }
        return b;
     }
     @Override
     public long verifica(String cliente){
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        long result = -1;
        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                String frase = "SELECT idclienteCidade FROM ClienteCidade "
                        + "WHERE nome = \"" + cliente + "\"";
                pstm = con.prepareStatement(frase);
                res = pstm.executeQuery();
                /**
                 * recupera idclienteCidade, sendo que:
                 * result = -1 - id não encontrado
                 */
                if(res != null && res.next()){ 
                result = res.getLong("idClienteCidade");
                }
                else
                {result = -1;
                }
                con.close();
                
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }

        return result;
     }
     
     @Override
     public ClienteCidade recuperaCliente(long idcliente){
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        ClienteCidade temp = new ClienteCidade(idcliente);
        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                String frase = RECUPERA_CLIENTE + idcliente;
                pstm = con.prepareStatement(frase);
                res = pstm.executeQuery();
                /**
                 * recupera cliente pelo id e retorna cliente
                 */
                if(res != null && res.next()){ 
                temp.setNome(res.getNString("nome"));
                temp.setCidade(res.getNString("cidade"));
                temp.setIdClassificacaoCliente(res.getLong("ClassificacaoCliente_idClassificacaoCliente"));
                temp.setIdPessoa(res.getLong("Pessoa_idPessoa"));
                
                }
                else
                {temp = null;
                }
                con.close();
                
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }

        return temp;
     }
     
     @Override
     public ClassificacaoCliente recuperaClassificacao(long idclassificacao){
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        ClassificacaoCliente temp = new ClassificacaoCliente(idclassificacao);
        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                String frase = RECUPERA_CLASSIFICACAO + idclassificacao;
                pstm = con.prepareStatement(frase);
                res = pstm.executeQuery();
                /**
                 * recupera classificacao pelo id e retorna classificacao
                 */
                if(res != null && res.next()){ 
                temp.setStatus(res.getNString("status"));
                temp.setNumDias(res.getInt("numDiasStatus"));
                temp.setPontuacao(res.getInt("pontuacaoCliente"));
                temp.setDataUltimaAtualização(res.getDate("dataUltimaAtualização"));
                }
                else
                {temp = null;
                }
                con.close();
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }

        return temp;
     }
       
     @Override
     public List<Suporte> recuperaSuportes(long idcliente, Date data1, Date data2){
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        List<Suporte> temp = new ArrayList<Suporte>();
        con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                String frase = "SELECT * FROM suporte WHERE "
                + "ClienteCidade_idClienteCidade = " + idcliente + " and dataSuporte "
                + "BETWEEN '" + data1 + "' AND '" + data2 + "'";
                pstm = con.prepareStatement(frase);
                res = pstm.executeQuery();
                /**
                 * recupera ocorrencias pelo id de cliente e retorna ocorrencias
                 */
                Suporte suporte;
                while(res != null && res.next())
                {suporte = new Suporte(res.getLong("idSuporte"));
                 suporte.setDataSuporte(res.getDate("dataSuporte"));
                 suporte.setDescricaoOcorrido(res.getNString("descricaoOcorrido"));
                 suporte.setHora(res.getNString("hora"));
                 suporte.setIdPessoa(res.getLong("Pessoa_idPessoa"));
                 suporte.setIdClienteCidade(res.getLong("ClienteCidade_idClienteCidade"));
                 suporte.setIdTipoSuporte(res.getLong("TipoSuporte_idTipoSuporte"));
                 temp.add(suporte);
                }
                con.close();
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }

        return temp;

     }
     
     @Override
     public List<ClienteCidade> recuperaClientes(){
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        List<ClienteCidade> temp = new ArrayList<ClienteCidade>();
        con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                pstm = con.prepareStatement(RECUPERA_CLIENTES);
                res = pstm.executeQuery();
                /**
                 * recupera ocorrencias pelo id de cliente e retorna ocorrencias
                 */
                ClienteCidade cliente;
                while(res != null && res.next())
                {cliente = new ClienteCidade(res.getLong("idClienteCidade"));
                 cliente.setNome(res.getNString("nome"));
                 cliente.setCidade(res.getNString("cidade"));
                 cliente.setIdClassificacaoCliente(res.getLong("ClassificacaoCliente_idClassificacaoCliente"));
                 cliente.setIdPessoa(res.getLong("Pessoa_idPessoa"));
                 temp.add(cliente);
                }
                con.close();
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }

        return temp;

     } 
     
     
    @Override
     public long recuperaUltimoId(){
     Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        long temp = -1;
        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                pstm = con.prepareStatement(RECUPERA_ID);
                res = pstm.executeQuery();
                /**
                 *
                 */
                if(res != null && res.next()){ 
                 temp = res.getLong(1);
                }
                else
                {temp = -1;
                }
                con.close();
                
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }

        return temp;
     }
     
}
