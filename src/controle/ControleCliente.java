package controle;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import modelo.Cliente;

/**
 * A classe <b>ControleCliente</b> define uma relação com a classe Cliente (model) com a TelaCliente (view). 
 * 
 * <p>
 * Essa classe é responsável por gerenciar a lista de cliente junto com os métodos necessários.
 * </p>
 *  
 * @see Cliente
 * @version 1.0
 * @since 1.0
 * @author Lucas L. Frazão - 211031771
 */
public class ControleCliente {
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	/**
	 * O construtor default da classe, onde entramos com dados mocados na lista. 
	 */
	public ControleCliente() {
		clientes.add(new Cliente(1, "Marcelo Otávio Assis", "marcelo78@hersa.com.br", "264.162.494-05", "41306-065",
				"Salvador", "Vila das Margaridas", "229", "Nova Brasília de Valéria", "BA"));
		
		clientes.add(new Cliente(2, "Isadora Elaine", "isadora-elaine@foar.unesp.br", "619.021.645-55", "79790-970",
				"Deodápolis", "Avenida Dom Pedro II 530", "229", "Centro", "MS"));
		
		clientes.add(new Cliente(3, "Vera Brenda Barros", "vera_barros@leanclean.com.br", "428.047.520-20", "63901-110",
				"Quixadá", "Planalto Renascer", "865", "Rua da Criança", "CE"));
		
		clientes.add(new Cliente(4, "Luiz César Nelson da Costa", "luizcesardacosta@companhiadigital.net", "577.468.789-97", "96830-060",
				"Santa Cruz do Sul", "Rua Iguaçu", "963", "Bonfim", "RS"));
		
		clientes.add(new Cliente(5, "Bruna Francisca Rebeca Assis", "bruna.francisca@agencia10.com.br", "007.938.968-60", "68905-170",
				"Macapá", "Rua Santa Maria", "814", "Cidade Nova", "AP"));
		
		clientes.add(new Cliente(6, "Eliane Lara Sales", "eliane-sales80@arbitral.com", "775.729.750-89", "78551-308",
				"Sinop", "CondomíniO Camping Club", "516", "Rua da Corvina", "MT"));
		
		clientes.add(new Cliente(7, "Bruno Roberto Freitas", "bruno_freitas@trilhavitoria.com.br", "591.590.805-58", "27110-110",
				"Barra do Piraí", "Rua Maria Luiza Rodrigues", "3559", "Ponte Preta", "RJ"));
		
		clientes.add(new Cliente(8, "Thomas Lorenzo Galvão", "thomas.lorenzo.galvao@unicamp.br", "983.467.257-87", "77416-055",
				"Gurupi", "Rua 10", "117", "Jardim Guanabara", "TO"));
		
		clientes.add(new Cliente(9, "Alícia Gabriela Fogaça", "alicia.marli.fogaca@51hotmail.com", "346.403.030-09", "76906-627",
				"Ji-Paraná", "Avenida José Carlos Martins Vilela", "182", "Colina Park I", "RO"));
		
		clientes.add(new Cliente(10, "Analu Isadora Vanessa Campos", "analu_campos@cavalinho.srv.br", "677.174.865-04", "79002-212",
				"Campo Grande", "Rua Maracaju", "555", "Centro", "MS"));
	}
	
	/**
	 * Esse método retorna o último id do cliente adicionado na lista.
	 * @return Ultimo id do cliente da lista
	 */
	public Integer ultimoCodigoCadastrado() {		
		return clientes.get((clientes.size() - 1)).getId();
	}
	
	/**
	 * Esse método pesquisa um cliente na lista.
	 * @param cpf CPF a ser procurado na lista. 
	 * @return Retorna um Cliente.
	 * @see Cliente
	 */
	public Cliente pesquisarClientePorCPF(String cpf) {
		Cliente cliente = new Cliente();
		for(Cliente c: clientes) {
			if(c.getCpf().contains(cpf)) {
				cliente = c;
			}
		}
		return cliente;
	}
	
	/**
	 * Esse método exclui um cliente.
	 * @param cpf CPF do cliente a ser excluido .
	 */
	public void excluirCliente(String cpf) {
		int loop = 0;
		for(Cliente c: clientes) {
			if(c.getCpf().equals(cpf)) {
					clientes.remove(loop);					
					break;
			}
			loop += 1;
		}
	}
	
	/**
	 * Esse método adiociona um cliente na lista.
	 * @param cliente Cliente a ser adicionado.
	 * @see Cliente
	 */
	public void adicionarCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	/**
	 * Esse método obtêm a lista de clientes.
	 * @return Retorna uma Lista de Cliente
	 * @see Cliente
	 */
	public List<Cliente> obterTodosClientes(){
		return clientes;
	}
	
	/**
	 * Esse método checa se um determinado id existe na lista.
	 * @param id Id a ser checado.
	 * @return Retorna um boolean informando se o id existe ou não na lista.
	 */
	public boolean checarId(Integer id) {
		for(Cliente c: clientes) {
			if(c.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Este método recebe um cliente e reescreve os dados de um já existente.
	 * @param cliente Novo cliente com os dados a serem reescritos.
	 * @see Cliente
	 */
	public void editarCliente(Cliente cliente) {
		for(Cliente c: clientes) {
			if(c.getId() == cliente.getId()) {
				c.setId(cliente.getId());
				c.setNome(cliente.getNome());
				c.setEmail(cliente.getEmail());
				c.setCpf(cliente.getCpf());
				c.getEndereco().setCep(cliente.getEndereco().getCep());
				c.getEndereco().setCidade(cliente.getEndereco().getCidade());
				c.getEndereco().setEndereco(cliente.getEndereco().getEndereco());
				c.getEndereco().setNumero(cliente.getEndereco().getNumero());
				c.getEndereco().setBairro(cliente.getEndereco().getBairro());
				c.getEndereco().setUf(cliente.getEndereco().getUf());
				
			}
		}
	}
	
	/**
	 * Este método válida um CPF.
	 * @param CPF CPF a ser válidado.
	 * @return Retorna um boolean informando se o cpf é válido ou não.
	 */
	public boolean validarCPF(String CPF) {
		CPF = CPF.replace("-", "");
		CPF = CPF.replace(".", "");
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
	    if (CPF.equals("00000000000") ||
	        CPF.equals("11111111111") ||
	        CPF.equals("22222222222") || CPF.equals("33333333333") ||
	        CPF.equals("44444444444") || CPF.equals("55555555555") ||
	        CPF.equals("66666666666") || CPF.equals("77777777777") ||
	        CPF.equals("88888888888") || CPF.equals("99999999999") ||
	        (CPF.length() != 11))
	        return(false);
	
	    char dig10, dig11;
	    int sm, i, r, num, peso;
	
	    // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
	    try {
	    // Calculo do 1o. Digito Verificador
	        sm = 0;
	        peso = 10;
	        for (i=0; i<9; i++) {
	    // converte o i-esimo caractere do CPF em um numero:
	    // por exemplo, transforma o caractere '0' no inteiro 0
	    // (48 eh a posicao de '0' na tabela ASCII)
	        num = (int)(CPF.charAt(i) - 48);
	        sm = sm + (num * peso);
	        peso = peso - 1;
	        }
	
	        r = 11 - (sm % 11);
	        if ((r == 10) || (r == 11))
	            dig10 = '0';
	        else dig10 = (char)(r + 48); // converte no respectivo caractere numerico
	
	    // Calculo do 2o. Digito Verificador
	        sm = 0;
	        peso = 11;
	        for(i=0; i<10; i++) {
	        num = (int)(CPF.charAt(i) - 48);
	        sm = sm + (num * peso);
	        peso = peso - 1;
	        }
	
	        r = 11 - (sm % 11);
	        if ((r == 10) || (r == 11))
	             dig11 = '0';
	        else dig11 = (char)(r + 48);
	
	    // Verifica se os digitos calculados conferem com os digitos informados.
	        if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
	             return(true);
	        else return(false);
	    }catch (InputMismatchException erro) {
	    	return(false);
	    }
	}
	
	/**
	 * Este método válida um e-mail por meio do regex.
	 * @param email E-mail a ser válido.
	 * @return Retorna um boolean informando se o e-mail é válido ou não
	 */
	public boolean validarEmail(String email) {
	    boolean isEmailIdValid = false;
	    if (email != null && email.length() > 0) {
	        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
	        Matcher matcher = pattern.matcher(email);
	        if (matcher.matches()) {
	            isEmailIdValid = true;
	        }
	    }
	    return isEmailIdValid;
	}
	
	/**
	 * Este método verifica se um dado CPF existe na lista.
	 * @param cpf CPF a ser verificado.
	 * @return Retorna um boolean informando se o cpf existe ou não.
	 */
	public boolean cpfNoSistema(String cpf) {
		for(Cliente c: clientes) {
			if(c.getCpf().equals(cpf)) {
				return true;
			}
		}
		return false;
	}
}