package br.unesp.rc.classificaclientes.service;
import br.unesp.rc.classificaclientes.model.ClienteCidade;
import br.unesp.rc.classificaclientes.model.ClassificacaoCliente;
import br.unesp.rc.classificaclientes.model.Suporte;
import java.sql.Date;
import java.util.List;

public interface ClienteCidadeService {
    boolean save(ClienteCidade clienteCidade);    
    long verifica(String cliente);
    /*recupera informações de um bairro*/
    public ClienteCidade recuperaCliente(long idcliente);
    public ClassificacaoCliente recuperaClassificacao(long idclassificacao);
    public List<ClienteCidade> recuperaClientes();
    public List<Suporte> recuperaSuportes(long idcliente, Date data1, Date data2);    
    public long recuperaUltimoId(); 

}
