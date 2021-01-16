package br.unesp.rc.classificaclientes.service;
import br.unesp.rc.classificaclientes.dao.DaoFactory;
import br.unesp.rc.classificaclientes.dao.LoginDAO;
import br.unesp.rc.classificaclientes.model.Login;

public class LoginServiceImpl implements LoginService{
    private final LoginDAO loginDAO;

    public LoginServiceImpl() {
        this.loginDAO = DaoFactory.getLoginDAO();
    }

    @Override
    public boolean save(Login entity) {
        boolean b = false;

        if (entity != null) {
            b = this.loginDAO.save(entity);
        }

        return b;
    }
    
    @Override
    public long recuperaUltimoId(){
    long id;
    id = this.loginDAO.recuperaUltimoId();
    return id;
    }
    
    @Override
    public int consultaLogin(String usuario, String senha){
        int result =0;
        
        if ( usuario != null && senha != null  ) {
            result = this.loginDAO.consultaLogin(usuario, senha);
        }
        return result;
    }
}
