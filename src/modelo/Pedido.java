/**
 * Classe utilizada para complementar a classe Venda e Produto, é apenas uma model que tem vários produtos e é usada pelo ControleVenda.
 * @version 1.0.0
 */
package modelo;

public class Pedido {

	//ATRIBUTOS
	private Produto produto;
	private Integer quantidade;
	private Double  precoTotal;
	
	//CONSTRUTORES
	public Pedido() {
		
	}

	public Pedido(Produto produto, Integer quantidade, Double precoTotal) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.precoTotal = precoTotal;
	}

	//GETTERS E SETTERS
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}
	
	public void subtotal() {
		// TODO
		this.precoTotal = produto.getPreco() * quantidade;
	}
	
	public void adicionarProduto(Produto produto) {
		setProduto(produto);
	}

	@Override
	public String toString() {
		return "Pedido [produto=" + produto + ", quantidade=" + quantidade + ", precoTotal=" + precoTotal + "]";
	}
}
