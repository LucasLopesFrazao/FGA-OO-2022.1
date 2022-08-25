package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe utilizada no controleVenda, é apenas uma classe para modelar uma venda.
 * 
 * @version 1.0
 * @since 1.0
 * @author Lucas L. Frazão - 211031771
 */
public class Venda {

	//ATRIBUTOS
	private Integer id;
	private Date dataVenda;
	private Double valorVenda;
	private Vendedor vendedor;
	private Cliente cliente;
	private List<Pedido> carrinho = new ArrayList<Pedido>();
	
	//CONSTRUTORES
	public Venda() {
		
	}

	public Venda(Integer id, Date dataVenda, Double valorVenda, Vendedor vendedor, Cliente cliente, List<Pedido> carrinho) {
		this.id = id;
		this.dataVenda = dataVenda;
		this.valorVenda = valorVenda;
		this.vendedor = vendedor;
		this.cliente = cliente;
		this.carrinho = carrinho;
	}

	//GETTERS E SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void adicionarAoCarrinho(Pedido pedido) {
		carrinho.add(pedido);
	}

	public List<Pedido> getCarrinho() {
		return carrinho;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", dataVenda=" + dataVenda + ", valorVenda=" + valorVenda + ", vendedor=" + vendedor
				+ ", cliente=" + cliente + ", carrinho=" + carrinho + "]";
	}	
}
