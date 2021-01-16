package br.unesp.rc.classificaclientes.service;
import br.unesp.rc.classificaclientes.model.ClassificacaoCliente;

public interface ClassificacaoClienteService {
    boolean save(ClassificacaoCliente classificacaoCliente); 
    boolean update(ClassificacaoCliente classificacaoCliente); 
    long recuperaUltimoId();
}
