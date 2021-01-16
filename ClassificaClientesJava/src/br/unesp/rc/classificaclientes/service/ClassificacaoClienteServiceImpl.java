package br.unesp.rc.classificaclientes.service;
import br.unesp.rc.classificaclientes.dao.DaoFactory;
import br.unesp.rc.classificaclientes.model.ClassificacaoCliente;
import br.unesp.rc.classificaclientes.dao.ClassificacaoClienteDAO;

public class ClassificacaoClienteServiceImpl implements ClassificacaoClienteService{
    private ClassificacaoClienteDAO classificacaoClienteDAO;

    public ClassificacaoClienteServiceImpl() {
        this.classificacaoClienteDAO = DaoFactory.getClassificacaoClienteDAO();
    }

    @Override
    public boolean save(ClassificacaoCliente entity) {
        boolean b = false;

        if (entity != null) {
            b = this.classificacaoClienteDAO.save(entity);
        }

        return b;
    }

    @Override
    public boolean update(ClassificacaoCliente entity) {
        boolean b = false;

        if (entity != null) {
            b = this.classificacaoClienteDAO.update(entity);
        }

        return b;
    }    
    
    
    @Override
    public long recuperaUltimoId(){
    long id;
    id = this.classificacaoClienteDAO.recuperaUltimoId();
    return id;
    }
    
}
