package Demo;

import br.unesp.rc.classificaclientes.model.ClienteCidade;
import br.unesp.rc.classificaclientes.model.ClassificacaoCliente;
import br.unesp.rc.classificaclientes.service.ServiceFactory;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import br.unesp.rc.classificaclientes.service.ClienteCidadeService;

public class ConsulatarClassificacaoCliente {
    public void ConsutarZona(String zona){
    ClienteCidadeService entity = ServiceFactory.getClienteCidadeService();
    ClienteCidade cliente;
    ClassificacaoCliente cb;
    String status;
    List<ClienteCidade> lb;
    /*recupera todos os bairros*/
    lb = entity.recuperaClientes();
    Iterator iterator = lb.iterator();
    
     while(iterator.hasNext())
     {cliente = (ClienteCidade) iterator.next();
      cb = entity.recuperaClassificacao(cliente.getIdClassificacaoCliente());
      status = cb.getStatus();
      if(status.equals(zona))
      {System.out.println("Cliente " + cliente.getNome() 
              + " da cidade " + cliente.getCidade() + " na Classificação " + zona + ":");
       System.out.println("Nome: " + cliente.getNome());
       System.out.println("Pontuacao: " + cb.getPontuacao());
       System.out.println("Numero de dias no Status: " + cb.getNumDias());
       System.out.println("Data da ultima atualização: " + cb.getDataUltimaAtualização());
      }
     }
    }
    
    public static void main(String[] args){
    Scanner entrada = new Scanner(System.in);
    String resp;
    System.out.println("Digite o tipo da Classificação a ser consultada: ");
    resp = entrada.nextLine();
    ConsulatarClassificacaoCliente a = new ConsulatarClassificacaoCliente();
    a.ConsutarZona(resp);
    }
}
