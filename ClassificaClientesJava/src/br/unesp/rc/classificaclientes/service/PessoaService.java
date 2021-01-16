package br.unesp.rc.classificaclientes.service;
import br.unesp.rc.classificaclientes.model.Pessoa;

public interface PessoaService {
    boolean save(Pessoa pessoa);    
    public Pessoa recuperaPessoa(long idcliente);
    public long recuperaUltimoId();
}
