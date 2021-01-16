package br.unesp.rc.classificaclientes.dao;
import br.unesp.rc.classificaclientes.model.Suporte;
import br.unesp.rc.classificaclientes.utils.FabricaConexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SuporteDAOImpl implements SuporteDAO{
     @Override
     public boolean save(Suporte suporte){
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
                 * O trecho abaixo permite a inserção de uma classe Ocorrencia na tabela Ocorrencia
                 */
                pstm = con.prepareStatement(INSERT_SUPORTE);
                pstm.setLong(1, suporte.getIdSuporte());
                pstm.setDate(2, suporte.getDataSuporte());
                pstm.setString(3, suporte.getDescricaoOcorrido());
                pstm.setString(4, suporte.getHora());
                pstm.setLong(5, suporte.getIdPessoa());
                pstm.setLong(6, suporte.getIdClienteCidade());
                pstm.setLong(7, suporte.getIdTipoSuporte());
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
    public boolean verificaId(long id){
     Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        boolean temp = false;
        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                String frase = VERIFICA_ID + id;
                pstm = con.prepareStatement(frase);
                res = pstm.executeQuery();
                /**
                 * verifica ocorrencias pelo id
                 */
                if(res != null && res.next()){ 
                 temp = true;
                }
                else
                {temp = false;
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
                 * verifica ocorrencias pelo id
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
    
    
    @Override
    public long numerodesuporte(long idcliente,long idtipo, Date data, Date data2){
     Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        long temp = -1;
        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                String frase = "select count('TipoSuporte_idTipoSuporte') "
                + "from suporte where ClienteCidade_idClienteCidade = " + idcliente +
                " and TipoSuporte_idTipoSuporte = " + idtipo 
                + " and dataSuporte BETWEEN '" + data + "' AND '" + data2 + "'";
                pstm = con.prepareStatement(frase);
                res = pstm.executeQuery();
                /**
                 * verifica ocorrencias pelo id
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
