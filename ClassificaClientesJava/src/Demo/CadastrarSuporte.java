package Demo;

import br.unesp.rc.classificaclientes.model.Suporte;
import br.unesp.rc.classificaclientes.model.TipoSuporte;
import br.unesp.rc.classificaclientes.service.ClienteCidadeService;
import br.unesp.rc.classificaclientes.service.PessoaService;
import br.unesp.rc.classificaclientes.service.ContatoService;
import br.unesp.rc.classificaclientes.service.SuporteService;
import br.unesp.rc.classificaclientes.service.ServiceFactory;
import br.unesp.rc.classificaclientes.service.TipoSuporteService;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Scanner;

public class CadastrarSuporte {
    public CadastrarSuporte(){};
    
    public void CadastrarSuporte(long idPessoa,java.sql.Date data, String descricao,
    String hora, long idCliente, long idTipo) throws ParseException{
     SuporteService entity4 = ServiceFactory.getSuporteService();
     PessoaService entity8 = ServiceFactory.getPessoaService();
     ContatoService entity9 = ServiceFactory.getContatoService();
     
     Scanner entrada = new Scanner(System.in);
     String[] lista = new String[3];
     Calendar cal;
     String d;
     int temp;
     long id;
     boolean b;
     id = entity4.recuperaUltimoId();
     if(id == -1)
     {id = 1;
     }
     else
     {id++;
     }
     /*seta id de ocorrencia*/
     Suporte suporte = new Suporte(id);
     
     /*seta cliente*/
     suporte.setIdPessoa(idPessoa);
     
     /*seta data*/
     suporte.setDataSuporte(data);
     
     /*seta descrição*/
     suporte.setDescricaoOcorrido(descricao);
     
     /*seta hora*/
     suporte.setHora(hora);
     
     
     /*seta bairro*/
     suporte.setIdClienteCidade(idCliente);
     
    
     /*seta tipo*/
     suporte.setIdTipoSuporte(idTipo);
     
     /*salva ocorrencia*/
     b = entity4.save(suporte);
     if(b == false)
     {System.out.println("Erro: Ocorrencia não foi cadastrada ");
     }
       


       
      
    }
    
    public static void main(String[] args) throws ParseException{
     ClienteCidadeService entity = ServiceFactory.getClienteCidadeService();
     TipoSuporteService entity3 = ServiceFactory.getTipoSuporteService();
     CadastrarSuporte a = new CadastrarSuporte();
     Scanner entrada = new Scanner(System.in);
     long b = 1,idCliente,idrua,idTipo;
     String d;
     
     System.out.println("Digite a data da Ocorrencia: ");
     d = entrada.nextLine();
     String[] lista = new String[3];
     lista =  d.split("/");
     Calendar cal = Calendar.getInstance();
     int temp = Integer.parseInt(lista[0]);
     cal.set(Calendar.DAY_OF_MONTH,  temp);
     temp = Integer.parseInt(lista[1]);
     temp--;
     cal.set(Calendar.MONTH, temp);
     temp = Integer.parseInt(lista[2]);
     cal.set(Calendar.YEAR, temp);
     java.sql.Date data = new java.sql.Date(cal.getTimeInMillis());
     
     System.out.println("Digite o que ocorreu: ");
     String descricao = entrada.nextLine();
     System.out.println("Digite a hora que ocorreu: ");
     String hora = entrada.nextLine();

     do 
     {System.out.println("Digite qual seria o Cliente que ocorreu: ");
      d = entrada.nextLine();
      idCliente = entity.verifica(d);
      if(idCliente == -1)
      {System.out.println("Cliente não existe digite novamente\n");
      }
     }while(idCliente == -1);

     
     do
     {System.out.println("Tipos de Ocorrencias: ");
      /*recupera nome dos tipos*/
      TipoSuporte tipoSuporte = null;
      idTipo = 1;
      do
      {tipoSuporte = entity3.recuperaTipoOcorrencia(idTipo);
       if(tipoSuporte != null)
       {System.out.println(tipoSuporte.getCategoria());
       }
       idTipo++;
      }while(tipoSuporte != null);
      
      System.out.println("Digite qual seria o tipo de ocorrencia: ");
      d = entrada.nextLine();
      idTipo = entity3.recuperaIdTipoSuporte(d);
      if(idTipo == -1)
      {System.out.println("Tipo de Ocorrencia não existe\n");
      }
     }while(idTipo == -1);
     
     a.CadastrarSuporte(b,data, descricao, hora, idCliente,idTipo);
    }
}
