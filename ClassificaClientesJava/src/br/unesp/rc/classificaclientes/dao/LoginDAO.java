package br.unesp.rc.classificaclientes.dao;
import br.unesp.rc.classificaclientes.model.Login;

public interface LoginDAO {
    
    
    
    
    final String INSERT_LOGIN= "INSERT INTO Login(idLogin, "
        + "usuario, senha, admin) VALUES(?, ?, ?, ?)";
    final String RECUPERA_ID = "select Max(idLogin) from login";
    final String CONSULTA_LOGIN = "SELECT * FROM login where usuario = '";
    public boolean save(Login login);
    public long recuperaUltimoId();
    
    public int consultaLogin(String usuario, String senha);
}

