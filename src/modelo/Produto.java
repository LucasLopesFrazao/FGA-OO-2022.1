package modelo;

/**
 * Classe utilizada no controleProduto, � apenas uma classe pra modelar um produto.
 * 
 * @version 1.0
 * @since 1.0
 * @author Lucas L. Fraz�o - 211031771
 */

public class Produto {
	
	//ATRIBUTOS
	private Integer id;
	private Double preco;
	private Integer qtdEstoque;
	private String nome;
	
	//CONSTRUTORES
	public Produto() {
		
	}

	public Produto(Integer id, Double preco, Integer qtdEstoque, String nome) {
		this.id = id;
		this.preco = preco;
		this.qtdEstoque = qtdEstoque;
		this.nome = nome;
	}
	
	public Produto(Integer id, Double preco, String nome) {
		this.id = id;
		this.preco = preco;
		this.nome = nome;
	}

	//GETTERS E SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void adicionarEstoque(Integer quantidade) {
		this.qtdEstoque += quantidade;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", preco=" + preco + ", qtdEstoque=" + qtdEstoque + ", nome=" + nome + "]";
	}
}