/**
 * Classe abstrata para auxiliar a classe Cliente e classe Vendedor.
 * @version 1.0.0
 */
package modelo;

public abstract class PessoaAbstrata {
	
	/**
	 * O atributo id é utilizado para conseguir identificar uma pessoa
	 */
	private Integer id;
	/**
	 * O atributo nome é utilizado para nomear uma pessoa
	 */
	private String nome;
	/**
	 * O atributo email é utilizado para uma pessoa ter um email
	 */
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
