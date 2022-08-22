package teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import controle.ControleVendedor;
import modelo.Vendedor;

class TesteVendedor {

	ControleVendedor controleVendedor = new ControleVendedor();
	
	@Test
	void ultimoCodigoCadastrado() {
		Integer ultimoId = controleVendedor.ultimoCodigoCadastrado();
		assertEquals(5, ultimoId);
	}
	
	@Test
	void adicionarVendedor() {
		controleVendedor.adicionarVendedor(new Vendedor(controleVendedor.ultimoCodigoCadastrado()+1, "Luan Anthony Costa", 
				"luan.anthony.costa@tcotecnologia.com.br", "Livros"));
		Integer ultimoVendedor = controleVendedor.ultimoCodigoCadastrado();
		assertEquals(6, ultimoVendedor);
	}
	
	@Test
	void excluirVendedor() {
		controleVendedor.apagarVendedor(3);
		assertEquals(4, controleVendedor.obterTodosVendedores().size());
	}
	
	@Test
	void pesquisarNome() {
		assertEquals("Vicente Paulo Tomás Nunes", controleVendedor.pesquisarPorNome("Vic").getNome());
	}
}
