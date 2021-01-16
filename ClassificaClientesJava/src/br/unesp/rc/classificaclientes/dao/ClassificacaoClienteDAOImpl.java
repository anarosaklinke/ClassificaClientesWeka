
package br.unesp.rc.classificaclientes.dao;
import br.unesp.rc.classificaclientes.model.ClassificacaoCliente;
import br.unesp.rc.classificaclientes.utils.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClassificacaoClienteDAOImpl implements ClassificacaoClienteDAO{
    @Override
     public boolean save(ClassificacaoCliente classificacaoCliente){
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
                 * O trecho abaixo permite a inserção de uma classe ClassificacaoCliente na tabela ClassificacaoCliente
                 */
                pstm = con.prepareStatement(INSERT_CLASSIFICACAOCLIENTE);
                pstm.setLong(1, classificacaoCliente.getIdClassificacaoCliente());
                pstm.setString(2, classificacaoCliente.getStatus());
                pstm.setInt(3, classificacaoCliente.getNumDias());
                pstm.setInt(4, classificacaoCliente.getPontuacao());
                pstm.setDate(5, classificacaoCliente.getDataUltimaAtualização());
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
     public boolean update(ClassificacaoCliente classificacaoCliente){
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
                 * O trecho abaixo permite a inserção de uma classe ClassificacaoCliente na tabela ClassificacaoCliente
                 */
                pstm = con.prepareStatement(UPDATE_CLASSIFICACAOCLIENTE);
                pstm.setString(1, classificacaoCliente.getStatus());
                pstm.setInt(2, classificacaoCliente.getNumDias());
                pstm.setInt(3, classificacaoCliente.getPontuacao());
                pstm.setDate(4, classificacaoCliente.getDataUltimaAtualização());
                pstm.setLong(5, classificacaoCliente.getIdClassificacaoCliente());
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



