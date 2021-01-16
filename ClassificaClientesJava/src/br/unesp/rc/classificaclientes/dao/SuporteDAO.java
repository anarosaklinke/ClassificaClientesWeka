package br.unesp.rc.classificaclientes.dao;
import br.unesp.rc.classificaclientes.model.Suporte;
import java.sql.Date;

public interface SuporteDAO {
    final String INSERT_SUPORTE= "INSERT INTO Suporte("
        + "idSuporte, dataSuporte, descricaoOcorrido, hora, "
        + "Pessoa_idPessoa, "
        + "ClienteCidade_idClienteCidade, "
        + "TipoSuporte_idTipoSuporte) "
        + "VALUES(?, ?, ?, ?, ?, ?, ?)";
    final String RECUPERA_ID = "select Max(idSuporte) from suporte";
    final String VERIFICA_ID = "SELECT * FROM suporte WHERE idSuporte = ";
    public boolean save(Suporte suporte); 
    public long numerodesuporte(long idcliente, long idtipo, Date data, Date data2);
    public boolean verificaId(long id);
    public long recuperaUltimoId();
}
