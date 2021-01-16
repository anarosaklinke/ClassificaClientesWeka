package br.unesp.rc.classificaclientes.dao;
import br.unesp.rc.classificaclientes.model.Suporte;
import br.unesp.rc.classificaclientes.model.TipoSuporte;
import java.util.List;

public interface TipoSuporteDAO {
    final String INSERT_TIPOSUPORTE = "INSERT INTO TipoSuporte("
            + "idTipoSuporte, categoria, decricao, gravidade) "
            + "VALUES(?, ?, ?, ?)";
    final String RECUPERA_ID = "select Max(idTipoSuporte) from tiposuporte";
    final String RECUPERA_SUPORTE = "SELECT * FROM suporte where TipoSuporte_idTipoSuporte = " ;
    final String RECUPERA_TIPO = "SELECT * FROM tiposuporte where idTipoSuporte = ";
     public boolean save(TipoSuporte tipoSuporte);    
     public TipoSuporte recuperaTipoSuporte(long idTipoSuporte);
     public long recuperaIdTipoSuporte(String nome);
     public List<Suporte> recuperaSuporte(long idTipoSuporte);
     public long recuperaUltimoId();
}
