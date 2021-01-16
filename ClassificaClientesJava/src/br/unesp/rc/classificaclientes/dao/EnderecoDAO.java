package br.unesp.rc.classificaclientes.dao;
import br.unesp.rc.classificaclientes.model.Endereco;

public interface EnderecoDAO {
    final String INSERT_ENDERECO= "INSERT INTO Endereco(idEndereco, rua, "
            + "numero, bairro, cidade, estado, pais, cep) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    final String RECUPERA_ID = "select Max(idEndereco) from endereco";
    public boolean save(Endereco endereco);    
    public long recuperaUltimoId();
}
