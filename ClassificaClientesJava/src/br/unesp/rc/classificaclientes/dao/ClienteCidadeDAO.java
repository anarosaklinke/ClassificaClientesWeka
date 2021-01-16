package br.unesp.rc.classificaclientes.dao;
import br.unesp.rc.classificaclientes.model.ClienteCidade;
import br.unesp.rc.classificaclientes.model.ClassificacaoCliente;
import br.unesp.rc.classificaclientes.model.Suporte;
import java.sql.Date;
import java.util.List;

public interface ClienteCidadeDAO {
    final String INSERT_CLIENTECIDADE = "INSERT INTO ClienteCidade(idClienteCidade, nome, cidade, "
            + "ClassificacaoCliente_idClassificacaoCliente, Pessoa_idPessoa"
            + ") VALUES(?, ?, ?, ?, ?)";
    final String RECUPERA_ID="select Max(idClassificacaoCliente) from ClassificacaoCliente";
    final String RECUPERA_CLIENTES="select * from clientecidade";
    final String RECUPERA_CLASSIFICACAO = "SELECT * FROM classificacaocliente "
                        + "where idClassificacaoCliente = ";
    final String RECUPERA_CLIENTE = "SELECT * FROM ClienteCidade WHERE idClienteCidade = " ;
    
     public boolean save(ClienteCidade clienteCidade);
     public long verifica(String cliente);
     public List<ClienteCidade> recuperaClientes();
     public List<Suporte> recuperaSuportes(long idcliente, Date data1, Date data2);
     /*recupera informações de um cliente*/
     public ClienteCidade recuperaCliente(long idcliente);
     public ClassificacaoCliente recuperaClassificacao(long idclassificacao);
     public long recuperaUltimoId();
}
