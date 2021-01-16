package br.unesp.rc.classificaclientes.service;
import br.unesp.rc.classificaclientes.model.Suporte;
import br.unesp.rc.classificaclientes.model.TipoSuporte;
import java.util.List;

public interface TipoSuporteService {
    boolean save(TipoSuporte tipoOcorrencia);               
    public TipoSuporte recuperaTipoOcorrencia(long idTipoSuporte);
    public List<Suporte> recuperaSuporte(long idTipoSuporte);
    public long recuperaIdTipoSuporte(String nome);
    public long recuperaUltimoId();
}
