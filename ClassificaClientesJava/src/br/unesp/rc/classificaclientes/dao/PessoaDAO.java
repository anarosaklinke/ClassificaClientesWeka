package br.unesp.rc.classificaclientes.dao;
import br.unesp.rc.classificaclientes.model.Pessoa;

public interface PessoaDAO {
        final String INSERT_PESSOA= "INSERT INTO Pessoa(idPessoa, nome, "
                + "idade, dataNascimento, cpf, sexo,Contato_idContato, "
                + "Login_idLogin, Endereco_idEndereco) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        final String RECUPERA_ID = "select Max(idPessoa) from pessoa";
        final String RECUPERA_PESSOA = "SELECT * FROM pessoa WHERE idPessoa = "; 
    public boolean save(Pessoa pessoa);  
    public Pessoa recuperaPessoa(long idpessoa);
    public long recuperaUltimoId();
}
