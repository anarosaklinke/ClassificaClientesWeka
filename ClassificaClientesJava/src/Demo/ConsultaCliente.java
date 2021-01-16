package Demo;
import br.unesp.rc.classificaclientes.model.ClienteCidade;
import br.unesp.rc.classificaclientes.model.ClassificacaoCliente;
import br.unesp.rc.classificaclientes.model.Pessoa;
import br.unesp.rc.classificaclientes.model.Suporte;
import br.unesp.rc.classificaclientes.model.TipoSuporte;
import br.unesp.rc.classificaclientes.service.ServiceFactory;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import br.unesp.rc.classificaclientes.service.SuporteService;
import br.unesp.rc.classificaclientes.service.TipoSuporteService;
import br.unesp.rc.classificaclientes.service.ClienteCidadeService;
import br.unesp.rc.classificaclientes.service.PessoaService;


public class ConsultaCliente {
    public ConsultaCliente(){}
    
    public void Consulta(){
            int i;
        /*armazena quantas ocorrencias do tipo ocorreu*/
        long numero,cont;
        /*Acessa camada Service*/
        ClienteCidadeService entity = ServiceFactory.getClienteCidadeService();
        SuporteService entity2 = ServiceFactory.getSuporteService();
        TipoSuporteService entity3 = ServiceFactory.getTipoSuporteService();
        
        
        PessoaService entity4 = ServiceFactory.getPessoaService();
        List<ClienteCidade> clienteCidade = entity.recuperaClientes();
        
        
        ClienteCidade clienteTemp;
        Pessoa pessoa;
        ClassificacaoCliente classificacao;
        
        for( i = 0; i < clienteCidade.size(); i++){
            clienteTemp = clienteCidade.get(i);
            System.out.println(clienteTemp.getNome());
            clienteTemp.getIdPessoa();
            pessoa = entity4.recuperaPessoa(clienteTemp.getIdPessoa());
            System.out.println(pessoa.getNome());
            classificacao = entity.recuperaClassificacao(clienteTemp.getIdClassificacaoCliente());
        }
        
        /*variaveis e classes utilizadas*/
        Scanner entrada = new Scanner(System.in);
        List<Suporte> lo;
        Suporte o;
        TipoSuporte to;
        String temp;
        
        long idCliente;
        System.out.println("Digite o nome do cliente a ser procurado");
        String cliente = entrada.nextLine();
        idCliente = entity.verifica(cliente);
        if(idCliente == -1)
        {System.out.println("Cliente não existe");
        }
        else
        {ClienteCidade b;
         b = entity.recuperaCliente(idCliente);
         java.util.Date d = new java.util.Date();
         d.getTime();
         Calendar cal = new GregorianCalendar();
         cal.setTime(d);
         java.sql.Date data = new java.sql.Date(cal.getTimeInMillis());
         
         cal.add(Calendar.MONTH, -3);
         java.sql.Date data2 = new java.sql.Date(cal.getTimeInMillis());
         
         System.out.println("Nome = " + b.getNome() + "\ncidade = " + b.getCidade());
         ClassificacaoCliente c;
         c = entity.recuperaClassificacao(b.getIdClassificacaoCliente());
         System.out.println("Status = " + c.getStatus() + "\nNumero de Dias no Status = " + c.getNumDias() + 
         "\nPontuaçao do Bairro = " + c.getPontuacao() + "\nData da Ultima atualização = " + c.getDataUltimaAtualização());
         
         System.out.println("\nSuporte do Cliente \n");  
         /*recupera quantas ocorrencias de cada tipo existem*/
         cont = 1;
         for(i=1; i<=entity3.recuperaUltimoId();i++)
         {to = entity3.recuperaTipoOcorrencia(i);
          numero = entity2.numerodesuporte(idCliente, cont, data2, data);
          System.out.println(to.getCategoria() + ": " + numero);
          cont++;
         }
     

        }
    }
    
    public static void main(String[] args){
        ConsultaCliente a = new ConsultaCliente();
        a.Consulta();
    }
}
