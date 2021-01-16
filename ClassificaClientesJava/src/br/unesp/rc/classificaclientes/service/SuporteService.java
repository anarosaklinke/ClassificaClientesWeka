package br.unesp.rc.classificaclientes.service;
import br.unesp.rc.classificaclientes.model.Suporte;
import java.sql.Date;

public interface SuporteService {
    boolean save(Suporte suporte);    
    public boolean verificaId(long id);
     public long numerodesuporte(long idsuporte, long idtipo, Date data, Date data2);
    public long recuperaUltimoId();
}
