package br.unesp.rc.classificaclientes.model;
import java.sql.Date;

public class ClassificacaoCliente {  
    private final long idClassificacaoCliente;
    private String status;
    private int numDias;
    private int pontuacao;
    private Date dataUltimaAtualização;
    
    public ClassificacaoCliente(long idClassificacaoBairro){
        this.idClassificacaoCliente = idClassificacaoBairro;
    }
    
    public long getIdClassificacaoCliente() {
        return idClassificacaoCliente;
    }
     
    public String getStatus() {
      return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public int getNumDias() {
      return numDias;
    }

    public void setNumDias(int numDias) {
        this.numDias = numDias;
    }
  
    public int getPontuacao() {
      return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
    
    public Date getDataUltimaAtualização() {
      return dataUltimaAtualização;
    }

    public void setDataUltimaAtualização(Date dataUltimaAtualização) {
        this.dataUltimaAtualização = dataUltimaAtualização;
    }
}
