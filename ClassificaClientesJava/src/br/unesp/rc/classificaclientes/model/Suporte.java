package br.unesp.rc.classificaclientes.model;

import java.sql.Date;

public class Suporte {
    private final long idSuporte;
    private long idPessoa;
    private long idTipoSuporte;
    private long idClienteCidade;
    private Date dataSuporte;
    private String descricaoOcorrido;
    private String hora;
    
    public Suporte(long idSuporte){
        this.idSuporte = idSuporte;
    }
    
    public long getIdSuporte() {
        return idSuporte;
    }   
    
    public long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(long idPessoa) {
        this.idPessoa = idPessoa;
    }
    
    public long getIdTipoSuporte() {
        return idTipoSuporte;
    }

    public void setIdTipoSuporte(long idTipoSuporte) {
        this.idTipoSuporte = idTipoSuporte;
    }
    
    public long getIdClienteCidade() {
        return idClienteCidade;
    }

    public void setIdClienteCidade(long idClienteCidade) {
        this.idClienteCidade = idClienteCidade;
    }
    
    public Date getDataSuporte() {
        return dataSuporte;
    }

    public void setDataSuporte(Date dataSuporte) {
        this.dataSuporte = dataSuporte;
    }
    
    public String getDescricaoOcorrido() {
        return descricaoOcorrido;
    }

    public void setDescricaoOcorrido(String descricaoOcorrido) {
        this.descricaoOcorrido = descricaoOcorrido;
    }    
    
    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }   
    

}
