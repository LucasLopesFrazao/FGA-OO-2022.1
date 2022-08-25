package modelo;

/**
 * Classe abstrata para auxiliar a criação da classe Cliente e classe Vendedor.
 *
 * @see Cliente
 * @see Vendedor 
 * @version 1.0
 * @since 1.0
 * @author Lucas L. Frazão - 211031771
 */

public abstract class PessoaAbstrata {
	
	private Integer id;
	private String nome;
	private String email;
	
	// GETTERS E SETTERS
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
