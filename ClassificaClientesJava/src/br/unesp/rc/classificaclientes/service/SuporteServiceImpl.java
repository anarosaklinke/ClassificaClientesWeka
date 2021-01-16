package br.unesp.rc.classificaclientes.service;
import br.unesp.rc.classificaclientes.dao.DaoFactory;
import br.unesp.rc.classificaclientes.model.Suporte;
import java.sql.Date;
import br.unesp.rc.classificaclientes.dao.SuporteDAO;

public class SuporteServiceImpl implements SuporteService{
    private SuporteDAO suporteDAO;

    public SuporteServiceImpl() {
        this.suporteDAO = DaoFactory.getOcorrenciasDAO();
    }

    @Override
    public boolean save(Suporte entity) {
        boolean b = false;

        if (entity != null) {
            b = this.suporteDAO.save(entity);
        }

        return b;
    }
    
    @Override
    public boolean verificaId(long id){
        boolean b = false;

        if (id > 0) {
            b = this.suporteDAO.verificaId(id);
        }

        return b;
    }
    
    @Override
    public long recuperaUltimoId(){
        long b;
        b = this.suporteDAO.recuperaUltimoId();
        return b;
    }
    
    @Override
    public long numerodesuporte(long idcliente, long idtipo, Date data, Date data2){
        long b;
        b = this.suporteDAO.numerodesuporte(idcliente, idtipo, data, data2);
        return b; 
    }
}
