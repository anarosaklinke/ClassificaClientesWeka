package br.unesp.rc.classificaclientes.dao;
import br.unesp.rc.classificaclientes.model.Contato;

public interface ContatoDAO {
    final String INSERT_CONTATO= "INSERT INTO Contato(idContato, "
            + "telefoneResidencial, telefoneComercial, email, celular) "
            + "VALUES(?, ?, ?, ?, ?)";
    final String RECUPERA_CONTATO = "SELECT * FROM contato WHERE idContato = ";
    final String RECUPERA_ID = "select Max(idContato) from contato";
    
    public boolean save(Contato contato);
    public Contato recuperaContato(long idContato);
    public long recuperaUltimoId();
}
