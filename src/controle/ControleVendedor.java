package controle;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import modelo.Vendedor;

/**
 * A classe <b>ControleVendedor</b> define uma relação com a classe Vendedor (model) com a TelaVendedor (view). 
 * <p>
 * Essa classe é responsável por gerenciar a lista de vendedor junto com os métodos necessários
 * </p>
 * @version 1.0
 */
public class ControleVendedor {
	
	private List<Vendedor> vendedores = new ArrayList<Vendedor>();
	
	/**
	 * O construtor default da classe
	 */
	public ControleVendedor() {
		vendedores.add(new Vendedor(1, "Vicente Paulo Tomás Nunes", "marcelo78@hersa.com.br", "Celulares"));
		vendedores.add(new Vendedor(2, "Rafael Augusto Baptista", "rafael_augusto_baptista@callan.com.br", "Móveis"));
		vendedores.add(new Vendedor(3, "Carla Gabrielly Vera Ramos", "carla_gabi@yahoo.com.br", "Eletrodomésticos"));
		vendedores.add(new Vendedor(4, "Giovana Mirella Priscila", "giovana_mirella@grupompe.com.br", "Jardinagem"));
		vendedores.add(new Vendedor(5, "Tânia Bruna Malu Carvalho", "tania_carvalho@casaarte.com.br", "Automotivo"));		
	}
	
	/**
	 * Esse método retorna o ultimo id do cliente adicionado na lista
	 * @return Ultimo id do cliente da lista
	 */
	public Integer ultimoCodigoCadastrado() {
		return vendedores.get((vendedores.size() - 1)).getId();
	}
	
	/**
	 * Esse método adiociona um vendedor na lista
	 * @param vendedor Vendedor a ser adicionado 
	 */
	public void adicionarVendedor(Vendedor vendedor) {
		vendedores.add(vendedor);
	}
	
	/**
	 * Esse método obtêm a lista de vendedores
	 * @return Retorna uma Lista de Vendedor
	 */
	public List<Vendedor> obterTodosVendedores(){
		return vendedores;
	}

	/**
	 * Esse método pesquisa um vendedor na lista
	 * @param nome Nome a ser procurado na lista 
	 * @return Retorna um Vendedor
	 */
	public Vendedor pesquisarPorNome(String nome) {
		if(nome.equals("")) {
			return new Vendedor();			
		}
		for(Vendedor v: vendedores) {
			if(v.getNome().toUpperCase().contains(nome.toUpperCase())) {
				return v;
			}
		}
		return new Vendedor();
	}
	
	/**
	 * Esse método checa se um determinado id existe na lista 
	 * @param id Id a ser checado
	 * @return Retorna um boolean informando se o id existe ou não na lista
	 */
	public boolean checarId(Integer id) {
		for(Vendedor v: vendedores) {
			if(v.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Este método recebe um vendedor e reescreve os dados de um já existente
	 * @param vendedor Novo vendedor com os dados a serem reescritos
	 */
	public void editarVendedor(Vendedor vendedor) {
		for(Vendedor v: vendedores) {
			if(v.getId() == vendedor.getId()) {
				v.setId(vendedor.getId());
				v.setNome(vendedor.getNome());
				v.setEmail(vendedor.getEmail());
				v.setDepartamento(vendedor.getDepartamento());
			}
		}
	}
	
	/**
	 * Esse método exclui um vendedor
	 * @param id Id do vendedor a ser excluido 
	 */
	public void apagarVendedor(Integer id) {
		int loop = 0;
		for(Vendedor v: vendedores) {
			if(v.getId() == id) {
				vendedores.remove(loop);
				break;
			}
			loop += 1;
		}
	}
	
	/**
	 * Este método válida um e-mail por meio do regex
	 * @param email E-mail a ser válido
	 * @return Retorna um boolean informando se o e-mail é válio ou não
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
}
