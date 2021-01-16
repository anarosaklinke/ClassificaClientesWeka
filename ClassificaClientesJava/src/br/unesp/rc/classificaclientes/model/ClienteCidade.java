package br.unesp.rc.classificaclientes.model;

public class ClienteCidade {
    private final long idClienteCidade;
    private long idClassificacaoCliente;
    private long idPessoa;
    private String nome;
    private String cidade;

    public ClienteCidade(long idClienteCidade){
        this.idClienteCidade = idClienteCidade;
    }
   
    public long getIdClienteCidade() {
        return idClienteCidade;
    }

    public long getIdClassificacaoCliente() {
        return idClassificacaoCliente;
    }

    public void setIdClassificacaoCliente(long idClassificacaoCliente) {
       this.idClassificacaoCliente = idClassificacaoCliente;
    }
    
    public long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(long idPessoa) {
       this.idPessoa = idPessoa;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
       this.nome = nome;
    }
    
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
       this.cidade = cidade;
    }   
}
