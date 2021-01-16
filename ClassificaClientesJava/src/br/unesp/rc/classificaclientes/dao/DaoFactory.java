package br.unesp.rc.classificaclientes.dao;

public class DaoFactory {
    private DaoFactory(){        
    }
    
     final static ClienteCidadeDAOImpl clienteCidadeDAOImpl = new ClienteCidadeDAOImpl();
    
    public static ClienteCidadeDAO getBairroCidadeDAO(){
      
        return clienteCidadeDAOImpl;
    }
    
    public static ClassificacaoClienteDAO getClassificacaoClienteDAO(){
        return new ClassificacaoClienteDAOImpl();
    }
    
    public static TipoSuporteDAO getTipoOcorrenciaDAO(){
        return new TipoSuporteDAOImpl();
    }
    
    public static LoginDAO getLoginDAO(){
        return new LoginDAOImpl();
    }
    
    public static ContatoDAO getContatoDAO(){
        return new ContatoDAOImpl();
    }
    
    public static EnderecoDAO getEnderecoDAO(){
        return new EnderecoDAOImpl();
    }
    
    public static PessoaDAO getClienteDAO(){
        return new PessoaDAOImpl();
    }
    
    public static SuporteDAO getOcorrenciasDAO(){
        return new SuporteDAOImpl();
    }
    

}