package br.unesp.rc.classificaclientes.dao;
import br.unesp.rc.classificaclientes.model.ClassificacaoCliente;
import java.util.List;

public interface ClassificacaoClienteDAO {
        final String INSERT_CLASSIFICACAOCLIENTE = "INSERT INTO ClassificacaoCliente"
            + "(idClassificacaoCliente, status, numDiasStatus, pontuacaoCliente, dataUltimaAtualização)"
            + "VALUES(?, ?, ?, ?,?)";    
        final String UPDATE_CLASSIFICACAOCLIENTE = "UPDATE ClassificacaoCliente "
            + "SET status = ?, numDiasStatus = ?, pontuacaoCliente = ?, "
            + "dataUltimaAtualização = ? WHERE idClassificacaoCliente = ?";    
        final String RECUPERA_ID="select Max(idClassificacaoCliente) from ClassificacaoCliente ";
     public boolean save(ClassificacaoCliente classificacaoBairro);
     public boolean update(ClassificacaoCliente classificacaoBairro); 
     public long recuperaUltimoId();
}
