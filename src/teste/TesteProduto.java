package teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import controle.ControleProduto;
import exceptions.EstoqueException;
import modelo.Produto;

class TesteProduto {

	ControleProduto controleProduto = new ControleProduto();
	
	@Test
	void ultimoCodigoCadastrado() {
		Integer ultimoId = controleProduto.ultimoCodigoCadastrado();
		assertEquals(25, ultimoId);
	}
	
	@Test
	void adicionarProduto() {
		controleProduto.adicionarProduto(new Produto(controleProduto.ultimoCodigoCadastrado()+1, 99.99, 50, "Mouse Multilaser"));
		Integer ultimoProduto = controleProduto.ultimoCodigoCadastrado();
		assertEquals(26, ultimoProduto);
	}
	
	@Test
	void excluirProduto() {
		controleProduto.excluirProduto(1);
		assertEquals(24, controleProduto.obterTodosProdutos().size());
	}
	
	@Test
	void diminuirEstoqueProduto() throws EstoqueException {
		controleProduto.diminuirEstoque(6, 4);
		Integer estoque = controleProduto.pesquisarProduto(6).getQtdEstoque();
		assertEquals(1, estoque);
	}
	
	@Test
	void aumentarEstoqueProduto() throws EstoqueException {
		controleProduto.aumentarEstoque(6, 5);
		Integer estoque = controleProduto.pesquisarProduto(6).getQtdEstoque();
		assertEquals(10, estoque);
	}
	
	@Test
	void pesquisarProduto() {
		Produto p = controleProduto.pesquisarProduto("iphone");
		assertEquals(p.getNome(), "iPhone 11 Apple (64GB) Preto");
	}
}
