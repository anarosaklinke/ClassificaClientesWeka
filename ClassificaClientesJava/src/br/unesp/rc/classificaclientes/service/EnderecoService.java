package br.unesp.rc.classificaclientes.service;
import br.unesp.rc.classificaclientes.model.Endereco;

public interface EnderecoService {
    boolean save(Endereco endereco);    
    public long recuperaUltimoId();
}
