package br.unesp.rc.classificaclientes.dao;
import br.unesp.rc.classificaclientes.model.Login;
import br.unesp.rc.classificaclientes.utils.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAOImpl implements LoginDAO{
    
    
    private String usuario;
        
    @Override
     public boolean save(Login login){
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
                 * O trecho abaixo permite a inserção de uma classe Login na tabela Login
                 */
                pstm = con.prepareStatement(INSERT_LOGIN);
                pstm.setLong(1, login.getIdLogin());
                pstm.setString(2, login.getUsuario());
                pstm.setString(3, login.getSenha());
                pstm.setBoolean(4, login.getAdmin());
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
     
     @Override
      public int consultaLogin(String usuario, String senha){
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        
        int resultado = 0;
        
        con = FabricaConexao.getConexao();
        
        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                String frase = "SELECT * FROM login "
                        + "where usuario = '" + usuario +"'";
                pstm = con.prepareStatement(frase);
                res = pstm.executeQuery();
                /**
                 *
                 */
                if(res != null && res.next()){ 
                 
                 if (res.getNString("senha").equals(senha)){
                     
                    if (res.getBoolean("admin")){
                        resultado = 2;
                    }else{
                        resultado = 1;
                    }
                     
                 }        
                }
                con.close();
                
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }
        return resultado;
      }
}
