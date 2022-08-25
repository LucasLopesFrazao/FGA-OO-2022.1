package modelo;

/**
 * Classe utilizada no controleVendedor, é apenas uma classe para modelar um vendedor.
 *
 * @version 1.0
 * @since 1.0
 * @author Lucas L. Frazão - 211031771
 */

public class Vendedor extends PessoaAbstrata{
	
	private String departamento;
	
	//CONSTRUTORES
	public Vendedor() {
		
	}
	
	public Vendedor(Integer id, String nome, String email, String departamento) {
		super.setId(id);
		super.setNome(nome);
		super.setEmail(email);
		this.departamento = departamento;
	}

	//GETTERS E SETTERS
	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Vendedor [departamento=" + departamento + ", getId()=" + getId() + ", getNome()=" + getNome()
				+ ", getEmail()=" + getEmail() + "]";
	}
}