package Demo;

import br.unesp.rc.classificaclientes.model.ClienteCidade;
import br.unesp.rc.classificaclientes.model.Pessoa;
import br.unesp.rc.classificaclientes.model.Contato;
import br.unesp.rc.classificaclientes.model.Login;
import br.unesp.rc.classificaclientes.model.Endereco;
import br.unesp.rc.classificaclientes.model.ClassificacaoCliente;

import br.unesp.rc.classificaclientes.service.ContatoService;
import br.unesp.rc.classificaclientes.service.EnderecoService;
import br.unesp.rc.classificaclientes.service.LoginService;
import br.unesp.rc.classificaclientes.service.ServiceFactory;
import br.unesp.rc.classificaclientes.service.ClienteCidadeService;
import br.unesp.rc.classificaclientes.service.ClassificacaoClienteService;

import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Scanner;
import br.unesp.rc.classificaclientes.service.PessoaService;

public class CadastrarUsuario {
    
    public CadastrarUsuario(){};
    
    public void CadastrarCliente() throws ParseException
    {  PessoaService entity = ServiceFactory.getPessoaService();
       LoginService entity2 = ServiceFactory.getLoginService();
       EnderecoService entity3 = ServiceFactory.getEnderecoService();
       ContatoService entity4 = ServiceFactory.getContatoService();  
       ClienteCidadeService entity5 = ServiceFactory.getClienteCidadeService();
       ClassificacaoClienteService entity6 = ServiceFactory.getClassificacaoClienteService();
       
       
       Scanner entrada = new Scanner(System.in);
       long idPessoa;
        
       /*seta id de cliente*/
       idPessoa = entity.recuperaUltimoId();
       
       if(idPessoa == -1)
       {idPessoa = 1;
       }
       else
       {idPessoa++;
       }
       Pessoa pessoa = new Pessoa(idPessoa);

        String nome, cpf, sexo, resp;
        Date dataNascimento;
        int idade;
        
        String d;
        
        System.out.println("Digite o nome: ");
        nome = entrada.nextLine();
        
        System.out.println("Digite o sexo: ");
        sexo = entrada.nextLine();
        
        System.out.println("Digite o cpf: ");
        cpf = entrada.nextLine();
        
        /*seta data de nascimento*/
        System.out.println("Digite a data de nascimento: ");
        d = entrada.nextLine();
        String[] lista;
        lista =  d.split("/");
        Calendar cal = Calendar.getInstance();
        int temp = Integer.parseInt(lista[0]);
        
        cal.set(Calendar.DAY_OF_MONTH,  temp);
        temp = Integer.parseInt(lista[1]);
        temp--;
        cal.set(Calendar.MONTH, temp);
        temp = Integer.parseInt(lista[2]);
        cal.set(Calendar.YEAR, temp);
        dataNascimento = new java.sql.Date(cal.getTimeInMillis());        
        
        
        /*recupera data atual*/
         cal = Calendar.getInstance();
         java.sql.Date data2 = new java.sql.Date(cal.getTimeInMillis());
         
         /*descobre a idade*/
         LocalDate data3 = data2.toLocalDate();
         LocalDate data4 = dataNascimento.toLocalDate();
         Period p = Period.between(data4, data3);         
         idade = p.getYears();
         System.out.println("idade = " + idade);
         
         pessoa.setSexo(sexo);
         pessoa.setCpf(cpf);
         pessoa.setDataNascimento(dataNascimento);
         pessoa.setIdade(idade);
         pessoa.setNome(nome);
        
        String usuario;
        String senha;
        
        System.out.println("Digite o usuario: ");
        usuario = entrada.nextLine();
        
        System.out.println("Digite a senha: ");
        senha = entrada.nextLine();
        
        
        /*recupera id de Login*/
        long idLogin = entity2.recuperaUltimoId();
        if(idLogin == -1)
        {idLogin = 1;
        }
        else
        {idLogin++;
        }
        
        
        /*seta informações de Login endereco login não é administrador*/
        Login login = new Login(idLogin, false);
        login.setSenha(senha);
        login.setUsuario(usuario);
     
        pessoa.setLogin(login.getIdLogin());
        
        /*recupera id de endereco*/
        long idEndereco = entity3.recuperaUltimoId();
        if(idEndereco == -1)
        {idEndereco = 1;
        }
        else
        {idEndereco++;
        }
        
        String cliente;
        String cidadeC;
        
        System.out.println("Digite o nome da farmácia: ");
        cliente = entrada.nextLine();
        System.out.println("Digite a cidade: ");
        cidadeC = entrada.nextLine();
        
        /*recupera id de Cliente*/
        long idCliente = entity5.recuperaUltimoId();
        if(idCliente == -1)
        {idCliente = 1;
        }
        else
        {idCliente++;
        }

        ClienteCidade clienteCidade = new ClienteCidade(idCliente);
        clienteCidade.setNome(cliente);
        clienteCidade.setCidade(cidadeC);
        clienteCidade.setIdPessoa(idPessoa);
        
        
        /*recupera id de ClassificacaoCliente*/
        long idClassifica = entity6.recuperaUltimoId();
        if(idClassifica == -1)
        {idClassifica = 1;
        }
        else
        {idClassifica++;
        }    
        
        ClassificacaoCliente classifica = new ClassificacaoCliente(idClassifica);
        clienteCidade.setIdClassificacaoCliente(idClassifica);
        
        classifica.setNumDias(0);
        classifica.setStatus("verde");
        classifica.setPontuacao(0);
        
        /*recupera data atual*/
         cal = Calendar.getInstance();
         data2 = new java.sql.Date(cal.getTimeInMillis());
         
        classifica.setDataUltimaAtualização(data2);
        
        /*cria endereço*/
        Endereco endereco = new Endereco(idEndereco);
        System.out.println("Deseja cadastrar endereço: ");
        resp = entrada.nextLine();
         
        if(resp.equals("sim"))
        {System.out.println("Cadastrar Endereço:");

         int numero;
         System.out.println("Digite o numero: ");
         numero = Integer.parseInt(entrada.nextLine());

         String rua;
         System.out.println("Digite a rua: ");
         rua = entrada.nextLine();

         String bairro;
         System.out.println("Digite o bairro: ");
         bairro = entrada.nextLine();

         String cidade;
         System.out.println("Digite a cidade: ");
         cidade = entrada.nextLine();

         String estado;
         System.out.println("Digite o estado: ");
         estado = entrada.nextLine();

         String pais;
         System.out.println("Digite o pais: ");
         pais = entrada.nextLine();

         String cep;
         System.out.println("Digite o cep: ");
         cep = entrada.nextLine();

         endereco.setBairro(bairro);
         endereco.setCep(cep);
         endereco.setCidade(cidade);
         endereco.setEstado(estado);
         endereco.setNumero(numero);
         endereco.setRua(rua);
         endereco.setPais(pais);
        
         pessoa.setEndereco(endereco.getIdEndereco());
        }
        else
        {endereco.setBairro(null);
         endereco.setCep(null);
         endereco.setCidade(null);
         endereco.setEstado(null);
         endereco.setNumero(0);
         endereco.setRua(null);
         endereco.setPais(null);
         pessoa.setEndereco(endereco.getIdEndereco());
        }
        
        /*cria Contato*/
        long idContato = entity4.recuperaUltimoId();
        if(idContato == -1)
        {idContato = 1;
        }
        else
        {idContato++;
        }
        Contato contato = new Contato(idContato);
        System.out.println("Deseja cadastrar contato: ");
        resp = entrada.nextLine();
         
        if(resp.equals("sim"))
        {/*seta telefone residencial*/
         System.out.println("Digite o telefone residencial: ");
         resp = entrada.nextLine();
         contato.setTelRes(resp);
         
         /*set telefone comercial*/
         System.out.println("Digite o telefone comercial: ");
         resp = entrada.nextLine();
         contato.setTelCom(resp);
         
         /*set celular*/
         System.out.println("Digite o celular: ");
         resp = entrada.nextLine();
         contato.setCelular(resp);
         
         /*set email*/
         System.out.println("Digite o email: ");
         resp = entrada.nextLine();
         contato.setEmail(resp);
         
         pessoa.setIdContato(contato.getIdContato());
        }
        else
        {contato.setCelular(null);
         contato.setEmail(null);
         contato.setTelCom(null);
         contato.setTelRes(null);
         pessoa.setIdContato(contato.getIdContato());
        }
        /*salva Login no banco de dados*/
        boolean b;
        b = entity2.save(login);
        if(b == false)
        {System.out.println("Erro: Login não foi salvo no banco de dados ");
        }
        
        /*salva Endereco no banco de dados*/
        b = entity3.save(endereco);
        if(b == false)
        {System.out.println("Erro: Endereco não foi salvo no banco de dados ");
        }
        
        /*salva Contato no banco de dados*/
        b = entity4.save(contato);
        if(b == false)
        {System.out.println("Erro: Contato não foi salvo no banco de dados ");
        }
        


       
        /*salva Pessoa no banco de dados*/
        b = entity.save(pessoa);
        if(b == false)
        {System.out.println("Erro: Cliente não foi salvo no banco de dados ");
        }
        else
        {System.out.println("Cliente cadastrado com sucesso ");
        }
        
        
        
        b = entity6.save(classifica);
        if(b == false)
        {System.out.println("Erro: classifica não foi salvo no banco de dados ");
        }        
        
        b = entity5.save(clienteCidade);
        if(b == false)
        {System.out.println("Erro: clienteCidade não foi salvo no banco de dados ");
        }
        
    }
    
    public static void main(String[] args) throws ParseException{
     CadastrarUsuario a = new CadastrarUsuario();
     long b = 1;
     a.CadastrarCliente();
    }
}
