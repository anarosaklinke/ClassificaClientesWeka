package br.unesp.rc.classificaclientes.service;
import br.unesp.rc.classificaclientes.dao.DaoFactory;
import br.unesp.rc.classificaclientes.model.Suporte;
import br.unesp.rc.classificaclientes.model.TipoSuporte;
import java.util.List;
import br.unesp.rc.classificaclientes.dao.TipoSuporteDAO;

public class TipoSuporteServiceImpl implements TipoSuporteService{
    private TipoSuporteDAO tipoOcorrenciaDAO;

    public TipoSuporteServiceImpl() {
        this.tipoOcorrenciaDAO = DaoFactory.getTipoOcorrenciaDAO();
    }

    @Override
    public boolean save(TipoSuporte entity) {
        boolean b = false;

        if (entity != null) {
            b = this.tipoOcorrenciaDAO.save(entity);
        }

        return b;
    }
    
    @Override
    public TipoSuporte recuperaTipoOcorrencia(long idTipoOcorrencia){
        TipoSuporte t = null;

        if (idTipoOcorrencia > 0) {
            t = this.tipoOcorrenciaDAO.recuperaTipoSuporte(idTipoOcorrencia);
        }

        return t;
    }
    
    @Override
    public List<Suporte> recuperaSuporte(long idTipoOcorrencia){
        List<Suporte> t = null;

        if (idTipoOcorrencia > 0) {
            t = this.tipoOcorrenciaDAO.recuperaSuporte(idTipoOcorrencia);
        }
        return t;
    }
    
    @Override
    public long recuperaIdTipoSuporte(String nome){
        long id = -1;

        if (nome != null) {
            id = this.tipoOcorrenciaDAO.recuperaIdTipoSuporte(nome);
        }

        return id;
    }
    
    @Override
    public long recuperaUltimoId(){
        long id;
        id = this.tipoOcorrenciaDAO.recuperaUltimoId();
        return id;
    }
}
