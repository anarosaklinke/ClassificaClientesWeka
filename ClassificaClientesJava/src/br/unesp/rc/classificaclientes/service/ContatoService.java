package br.unesp.rc.classificaclientes.service;
import br.unesp.rc.classificaclientes.model.Contato;

public interface ContatoService {
    boolean save(Contato contato);    
    public Contato recuperaContato(long idContato);
    public long recuperaUltimoId();
}
