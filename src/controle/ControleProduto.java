package controle;

import java.util.ArrayList;
import java.util.List;

import exceptions.EstoqueException;
import exceptions.IdProdutoException;
import modelo.Produto;

/**
 * A classe <b>ControleProduto</b> define uma relação com a classe Produto (model) com a TelaProduto (view). 
 * 
 * <p>
 * Essa classe é responsável por gerenciar a lista de produto junto com os métodos necessários
 * </p>
 * 
 * @see Produto
 * @version 1.0
 * @since 1.0
 * @author Lucas L. Frazão - 211031771
 */
public class ControleProduto {
	List<Produto> produtos = new ArrayList<>();
	
	/**
	 * O construtor default da classe, onde entramos com dados mocados na lista.
	 */
	public ControleProduto() {
		
		//CELULARES
		produtos.add(new Produto(1, 8549.00, 100, "Galaxy S22 Ultra 5G Preto 256GB"));
		produtos.add(new Produto(2, 11519.00, 50, "Galaxy Z Fold3 5G Preto 512GB"));
		produtos.add(new Produto(3, 2699.00, 25, "Galaxy S21 FE 5G 128GB"));
		produtos.add(new Produto(4, 3319.00, 75, "iPhone 11 Apple (64GB) Preto"));
		produtos.add(new Produto(5, 9176.00, 15, "Iphone 13 PRO"));
		
		//MÓVEIS
		produtos.add(new Produto(6, 573.89, 5, "Mesa de Escritório Miguel Preta 190 cm"));
		produtos.add(new Produto(7, 869.90, 3, "Cadeira Gamer Donek Preta"));
		produtos.add(new Produto(8, 1069.90, 3, "Guarda-Roupa Casal Madesa Reno 3 Portas"));
		produtos.add(new Produto(9, 1069.90, 10, "Painel com suporte para Tv até 47\""));
		produtos.add(new Produto(10, 1449.00, 10, "Cama Box Com Baú Casal"));
		
		//ELETRODOMESTICOS
		produtos.add(new Produto(11, 2969.10, 15, "Geladeira/Refrigerador Brastemp Frost Free Duplex"));
		produtos.add(new Produto(12, 2599.99, 50, "SAMSUNG TV smart 50"));
		produtos.add(new Produto(13, 2229.00, 10, "Lavadoura de roupa 17KG BRASTEMP"));
		produtos.add(new Produto(14, 1089.90, 40, "Mini System LG Xboom"));
		produtos.add(new Produto(15, 1380.50, 10, "Fogão Itatiaia Dream"));
		
		//JARDINAGEM
		produtos.add(new Produto(16, 539.99, 5, "Cortador de grama elétrico TRAMONTINA"));
		produtos.add(new Produto(17, 214.70, 10, "Aparador de grama elétrico TRAMONTINA"));
		produtos.add(new Produto(18, 69.90, 50, "Mangueira magica compacta retrátil"));
		produtos.add(new Produto(19, 135.93, 35, "Vaso Autoirrigável para plantas"));
		produtos.add(new Produto(20, 387.90, 15, "Motoserra Eletroserra Elétrica 1600w"));
		
		//AUTOMOTIVO
		produtos.add(new Produto(21, 1119.97, 80, "Kit 4 pneus aro 15 Westlake"));
		produtos.add(new Produto(22, 354.90, 15, "Bateria Moura"));
		produtos.add(new Produto(23, 8.35, 30, "Limpa vidros autocraft"));
		produtos.add(new Produto(24, 329.90, 45, "Som automotivo Roadstar"));
		produtos.add(new Produto(25, 379.99, 15, "GPS VATINE Bluetooth WIFI"));
	}
	
	/**
	 * Esse método retorna o ultimo id do produto adicionado na lista.
	 * @return Ultimo id do cliente da lista.
	 */
	public Integer ultimoCodigoCadastrado() {
		return produtos.get((produtos.size() - 1)).getId();
	}
	
	/**
	 * Esse método obtêm a lista de produtos.
	 * @return Retorna uma Lista de Produto.
	 * @see Produto
	 */
	public List<Produto> obterTodosProdutos(){
		return produtos;
	}
	
	/**
	 * Esse método checa se um determinado id existe na lista. 
	 * @param id Id a ser checado.
	 * @return Retorna um boolean informando se o id existe ou não na lista.
	 */
	public boolean checarId(Integer id) {
		for(Produto p: produtos) {
			if(p.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Este método recebe um produto e reescreve os dados de um já existente.
	 * @param produto Novo produto com os dados a serem reescritos.
	 * @see Produto
	 */
	public void editarProduto(Produto produto) {
		for(Produto p: produtos) {
			if(p.getId() == produto.getId()) {
				p.setId(produto.getId());
				p.setNome(produto.getNome());
				p.setPreco(produto.getPreco());
				p.setQtdEstoque(produto.getQtdEstoque());
			}
		}
	}
	
	/**
	 * Esse método adiociona um produto na lista.
	 * @param produto Produto a ser adicionado.
	 * @see Produto
	 */
	public void adicionarProduto(Produto produto) {
		produtos.add(produto);
	}
	
	
	/**
	 * Esse método pesquisa um produto na lista pelo nome.
	 * @param nome Nome a ser procurado na lista .
	 * @return Retorna um Produto.
	 * @see Produto
	 */
	public Produto pesquisarProduto(String nome) {
		for(Produto p: produtos) {
			if(p.getNome().toUpperCase().contains(nome.toUpperCase())) {
				return p;
			}
		}
		return new Produto();
	}
	
	/**
	 * Esse método pesquisa um produto na lista pelo id.
	 * @param id Id a ser procurado na lista .
	 * @return Retorna um Produto.
	 * @see Produto
	 */
	public Produto pesquisarProdutoId(Integer id) {
		for(Produto p: produtos) {
			if(p.getId() == id) {
				return p;
			}
		}
		return new Produto();
	}
	
	/**
	 * Esse método exclui um produto..
	 * @param id id do produto a ser excluido.
	 */
	public void excluirProduto(Integer id) {
		int loop = 0;
		for(Produto p: produtos) {
			if(p.getId() == id) {
				produtos.remove(loop);
				break;
			}
			loop += 1;
		}
	}
	
	/**
	 * Este método diminui o estoque de um produto na lista.
	 * @param id Id do produto a ter o estoque diminuido.
	 * @param qtd Quantidade a ser diminuida do estoque.
	 * @throws EstoqueException Quantidade a ser retirada deixa o produto com menos de 0 unidades.
	 */
	public void diminuirEstoque(Integer id, Integer qtd) throws EstoqueException {
		for(Produto p: produtos) {
			if(p.getId() == id) {
				if((p.getQtdEstoque() - qtd) < 0) {
					throw new EstoqueException("Quantidade em estoque insuficiente");
				}else {
					p.setQtdEstoque(p.getQtdEstoque() - qtd);					
				}
			}
		}
	}
	
	/**
	 * Este método aumenta o estoque de um produto na lista.
	 * @param id Id do produto a ter o estoque aumentado.
	 * @param qtd Quantidade a ser aumentada do estoque.
	 */
	public void aumentarEstoque(Integer id, Integer qtd){
		for(Produto p: produtos) {
			if(p.getId() == id) {
				p.setQtdEstoque(p.getQtdEstoque() + qtd);					
			}
		}
	}
	
	/**
	 * Este método verifica se um dado id existe na lista.
	 * @param id Id a ser checado.
	 * @return Retorna um boolean informando se o id existe ou não.
	 * @throws IdProdutoException Não exista um produto com o id.
	 */
	public boolean checarIdNoSistema(Integer id) throws IdProdutoException {
		for(Produto p: produtos) {
			if(p.getId() == id) {
				return true;
			}
		}
		throw new IdProdutoException("Código inválido!");
	}
}
