package br.unesp.rc.classificaclientes.service;
import br.unesp.rc.classificaclientes.dao.DaoFactory;
import br.unesp.rc.classificaclientes.model.ClienteCidade;
import br.unesp.rc.classificaclientes.model.ClassificacaoCliente;
import br.unesp.rc.classificaclientes.model.Suporte;
import java.sql.Date;
import java.util.List;
import br.unesp.rc.classificaclientes.dao.ClienteCidadeDAO;

public class ClienteCidadeServiceImpl implements ClienteCidadeService{
    private final ClienteCidadeDAO clienteCidadeDAO;

    public ClienteCidadeServiceImpl() {
        this.clienteCidadeDAO = DaoFactory.getBairroCidadeDAO();
    }

    @Override
    public boolean save(ClienteCidade entity) {
        boolean b = false;

        if (entity != null) {
            b = this.clienteCidadeDAO.save(entity);
        }

        return b;
    }
    
    @Override
    public long verifica(String cliente){
    long result = -1;
    
        if (cliente != null) {
            result = this.clienteCidadeDAO.verifica(cliente);
        }

        return result;
    }
    
    @Override
    public ClienteCidade recuperaCliente(long idcliente){
    ClienteCidade result = null;
    
        if (idcliente > 0) {
            result = this.clienteCidadeDAO.recuperaCliente(idcliente);
        }

        return result;
    }
    
    @Override
    public ClassificacaoCliente recuperaClassificacao(long idClassificacao){
    ClassificacaoCliente result = null;
    
        if (idClassificacao > 0) {
            result = this.clienteCidadeDAO.recuperaClassificacao(idClassificacao);
        }

        return result;
    }
    

    
    @Override
    public List<Suporte> recuperaSuportes(long idcliente,Date data1, Date data2){
    List<Suporte> result = null;
    
        if (idcliente > 0) {
            result = this.clienteCidadeDAO.recuperaSuportes(idcliente, data1, data2);
        }
        return result;
    }
    
    @Override
    public List<ClienteCidade> recuperaClientes(){
    List<ClienteCidade> result = null;
    result = this.clienteCidadeDAO.recuperaClientes();
    return result;
    }
    
    @Override
    public long recuperaUltimoId(){
    long id;
    id = this.clienteCidadeDAO.recuperaUltimoId();
    return id;
    }

    
}
