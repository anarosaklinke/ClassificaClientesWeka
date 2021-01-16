package Demo;

import br.unesp.rc.classificaclientes.model.Suporte;
import br.unesp.rc.classificaclientes.model.TipoSuporte;
import br.unesp.rc.classificaclientes.service.ServiceFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import br.unesp.rc.classificaclientes.service.TipoSuporteService;

public class ConsultaCategoriasMaisIncidentes {
   public ConsultaCategoriasMaisIncidentes(){}
   public void Categorias(){
    TipoSuporteService entity = ServiceFactory.getTipoSuporteService();
    TipoSuporte categoria;
    int i;
    int cont = 0;
    long idTipoOcorrencia = 1;
    List<Suporte> lo;
    List<TipoSuporte> lista = new ArrayList<TipoSuporte>(); 
    TreeSet lista2 = new TreeSet();
    
    /*Cria lista com os tipos de ocorrencias e ordena o numero de ocorrencias*/
    do
    {categoria = entity.recuperaTipoOcorrencia(idTipoOcorrencia);
     if(categoria != null)
     {lo = entity.recuperaSuporte(idTipoOcorrencia);
      lista.add(categoria);
      lista2.add(lo.size());
     }
     idTipoOcorrencia++;
    }while(categoria != null);
    
    /*Checa se lista de numero de ocorrencias esta vazia */
    Iterator iterator = lista2.descendingIterator();
    int element = (int) iterator.next();
    if(element == 0)
    {System.out.println("Nenhuma ocorrencia cadastrada no sistema");
    }
    else
    {System.out.println("Categoria Mais Incidentes: ");  
     int tam = lista.size();
     while(cont != 10)
     {/*procura tipo que possui numero de ocorrencias igual ao maior*/
      for(i=0;i<tam-cont;i++)
      {categoria = lista.get(i);
       if(categoria != null)
       {lo = entity.recuperaSuporte(categoria.getIdTipoSuporte());
        if(element == lo.size())
        {lista.remove(categoria);
         System.out.println("Nome: " + categoria.getCategoria() + "\nDescrição: "
         + categoria.getDescricao() + "\nGravidade: " + categoria.getGravidade() + 
         "\nNumero de Ocorrencias: " + lo.size() + "\n");
         cont++;
         if(cont == 10)
         {i = tam-cont;
         }
        }
       }
      }
      /*coloca o proximo valor maior de numero de ocorrencias*/
      if(iterator.hasNext() == true)
      {element = (int) iterator.next();
      }
     }
    }
   } 
    
   public static void main(String[] args){
     ConsultaCategoriasMaisIncidentes a = new ConsultaCategoriasMaisIncidentes();
     a.Categorias();
   }

    
}
