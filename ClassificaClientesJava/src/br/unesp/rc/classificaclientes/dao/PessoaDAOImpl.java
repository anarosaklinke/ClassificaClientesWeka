package br.unesp.rc.classificaclientes.dao;
import br.unesp.rc.classificaclientes.model.Pessoa;
import br.unesp.rc.classificaclientes.utils.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PessoaDAOImpl implements PessoaDAO{
     @Override
     public boolean save(Pessoa pessoa){
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
                 * O trecho abaixo permite a inserção de uma classe Pessoa na tabela Pessoa
                 */
                pstm = con.prepareStatement(INSERT_PESSOA);
                pstm.setLong(1, pessoa.getIdPessoa());
                pstm.setString(2, pessoa.getNome());
                pstm.setInt(3, pessoa.getIdade());
                pstm.setDate(4, pessoa.getDataNascimento());
                pstm.setString(5, pessoa.getCpf());
                pstm.setString(6, pessoa.getSexo());
                pstm.setLong(7, pessoa.getIdContato());
                pstm.setLong(8, pessoa.geIdLogin());
                pstm.setLong(9, pessoa.getIdEndereco());
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
     public Pessoa recuperaPessoa(long idpessoa){
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        Pessoa temp = new Pessoa(idpessoa);
        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                String frase = RECUPERA_PESSOA + idpessoa;
                pstm = con.prepareStatement(frase);
                res = pstm.executeQuery();
                /**
                 * recupera cliente pelo id e retorna cliente
                 */
                if(res != null && res.next()){ 
                temp.setNome(res.getNString("nome"));
                temp.setIdade(res.getInt("idade"));
                temp.setSexo(res.getNString("sexo"));
                temp.setDataNascimento(res.getDate("dataNascimento"));
                temp.setCpf(res.getNString("cpf"));
                temp.setIdContato(res.getLong("Contato_idContato"));
                temp.setLogin(res.getLong("Login_idLogin"));
                temp.setEndereco(res.getLong("Endereco_idEndereco"));
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
