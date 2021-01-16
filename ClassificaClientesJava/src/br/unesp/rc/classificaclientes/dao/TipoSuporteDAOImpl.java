package br.unesp.rc.classificaclientes.dao;
import br.unesp.rc.classificaclientes.model.Suporte;
import br.unesp.rc.classificaclientes.model.TipoSuporte;
import br.unesp.rc.classificaclientes.utils.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TipoSuporteDAOImpl implements TipoSuporteDAO{
     @Override
     public boolean save(TipoSuporte tipoSuporte){
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
                 * O trecho abaixo permite a inserção de uma classe TipoSuporte na tabela TipoSuporte
                 */
                pstm = con.prepareStatement(INSERT_TIPOSUPORTE);
                pstm.setLong(1, tipoSuporte.getIdTipoSuporte());
                pstm.setString(2, tipoSuporte.getCategoria());
                pstm.setString(3, tipoSuporte.getDescricao());
                pstm.setInt(4, tipoSuporte.getGravidade());
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
     public TipoSuporte recuperaTipoSuporte(long idTipoSuporte){
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        TipoSuporte temp = new TipoSuporte(idTipoSuporte);
        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                String frase = RECUPERA_TIPO + idTipoSuporte;
                pstm = con.prepareStatement(frase);
                res = pstm.executeQuery();
                /**
                 * recupera classificacao pelo id e retorna classificacao
                 */
                if(res != null && res.next()){ 
                temp.setCategoria(res.getNString("categoria"));
                temp.setDescricao(res.getNString("decricao"));
                temp.setGravidade(res.getInt("gravidade"));
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
     public List<Suporte> recuperaSuporte(long idTipoSuporte){
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        List<Suporte> temp = new ArrayList<Suporte>();
        con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                String frase = RECUPERA_SUPORTE + idTipoSuporte;
                pstm = con.prepareStatement(frase);
                res = pstm.executeQuery();
                /**
                 * recupera ocorrencais pelo id de TipoOcorrencia e retorna ocorrecias
                 */
                Suporte ocorrencia;
                while(res != null && res.next())
                {ocorrencia = new Suporte(res.getLong("idSuporte"));
                 ocorrencia.setDataSuporte(res.getDate("dataSuporte"));
                 ocorrencia.setDescricaoOcorrido(res.getNString("descricaoOcorrido"));
                 ocorrencia.setHora(res.getNString("hora"));
                 ocorrencia.setIdPessoa(res.getLong("Pessoa_idPessoa"));
                 ocorrencia.setIdClienteCidade(res.getLong("ClienteCidade_idClienteCidade"));
                 ocorrencia.setIdTipoSuporte(res.getLong("TipoSuporte_idTipoSuporte"));
                 temp.add(ocorrencia);
                }
                con.close();
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }

        return temp;

     }
     
     @Override
     public long recuperaIdTipoSuporte(String nome){
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        long temp = -1;
        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                String frase = "SELECT * FROM tiposuporte "
                        + "where categoria = \"" + nome + "\"";
                pstm = con.prepareStatement(frase);
                res = pstm.executeQuery();
                /**
                 * recupera classificacao pelo id e retorna classificacao
                 */
                if(res != null && res.next()){ 
                temp = res.getLong("idTipoSuporte");
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
