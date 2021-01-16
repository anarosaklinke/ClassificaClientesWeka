package br.unesp.rc.classificaclientes.service;

public class ServiceFactory {
    private ServiceFactory(){
    }
    
    public static ClienteCidadeService getClienteCidadeService(){
        return new ClienteCidadeServiceImpl();
    }
 
    public static ClassificacaoClienteService getClassificacaoClienteService(){
        return new ClassificacaoClienteServiceImpl();
    }
    
    public static PessoaService getPessoaService(){
        return new PessoaServiceImpl();
    }
    
    public static ContatoService getContatoService(){
        return new ContatoServiceImpl();
    }
    
    public static EnderecoService getEnderecoService(){
        return new EnderecoServiceImpl();
    }
    
    public static LoginService getLoginService(){
        return new LoginServiceImpl();
    }
    
    public static SuporteService getSuporteService(){
        return new SuporteServiceImpl();
    }    
    
        public static TipoSuporteService getTipoSuporteService(){
        return new TipoSuporteServiceImpl();
    }    
    
}
