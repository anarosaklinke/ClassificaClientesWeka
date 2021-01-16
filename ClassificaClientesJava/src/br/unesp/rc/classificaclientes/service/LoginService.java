package br.unesp.rc.classificaclientes.service;
import br.unesp.rc.classificaclientes.model.Login;

public interface LoginService {
 boolean save(Login login);        
 public long recuperaUltimoId(); 
 public int consultaLogin(String usuario, String senha);
 /**0 - nao cadastrado
  * 1 - usuario comun
  * 2 - adm
  */
}
