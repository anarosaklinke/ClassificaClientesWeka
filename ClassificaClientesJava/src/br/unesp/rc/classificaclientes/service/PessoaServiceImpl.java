package br.unesp.rc.classificaclientes.service;
import br.unesp.rc.classificaclientes.dao.DaoFactory;
import br.unesp.rc.classificaclientes.model.Pessoa;
import br.unesp.rc.classificaclientes.dao.PessoaDAO;


public class PessoaServiceImpl implements PessoaService{
    private PessoaDAO pessoaDAO;

    public PessoaServiceImpl() {
        this.pessoaDAO = DaoFactory.getClienteDAO();
    }

    @Override
    public boolean save(Pessoa entity) {
        boolean b = false;

        if (entity != null) {
            b = this.pessoaDAO.save(entity);
        }

        return b;
    }
    
    @Override
    public Pessoa recuperaPessoa(long idpessoa){
    Pessoa c = null;
        if(idpessoa > 0)
        {c = this.pessoaDAO.recuperaPessoa(idpessoa);
        }
    return c;
    }
    
    @Override
    public long recuperaUltimoId(){
    long id;
    id = this.pessoaDAO.recuperaUltimoId();
    return id;
    }
}
