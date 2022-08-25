package modelo;

/**
 * Classe utilizada para ligar a classe Venda com a classe Produto.
 * 
 * <p>
 * Um pedido contém vários produtos e uma venda possui um pedido.
 * </p>
 * 
 * @see Produto
 * @see Venda
 * @version 1.0
 * @since 1.0
 * @author Lucas L. Frazão - 211031771
 */

public class Pedido {

	//ATRIBUTOS
	private Produto produto;
	private Integer quantidade;
	private Double  precoTotal;
	private Double precoAnterior;
	
	//CONSTRUTORES
	public Pedido() {
		
	}

	public Pedido(Produto produto, Integer quantidade, Double precoTotal) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.precoTotal = precoTotal;
	}

	public Pedido(Produto produto, Integer quantidade, Double precoTotal, Double precoAnterior) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.precoTotal = precoTotal;
		this.precoAnterior = precoAnterior;
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
		this.precoTotal = produto.getPreco() * quantidade;
	}
	
	public void adicionarProduto(Produto produto) {
		setProduto(produto);
	}
	
	public Double getPrecoAnterior() {
		return precoAnterior;
	}

	public void setPrecoAnterior(Double precoAnterior) {
		this.precoAnterior = precoAnterior;
	}

	@Override
	public String toString() {
		return "Pedido [produto=" + produto + ", quantidade=" + quantidade + ", precoTotal=" + precoTotal + "]";
	}
}
