import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import controle.ControleCliente;
import modelo.Cliente;

class Teste {

	// Testando controleCliente
	ControleCliente controleCliente = new ControleCliente();
	@Test
	void adicionarCliente() {
		controleCliente.adicionarCliente(new Cliente(11, "Yasmin Nicole Sebastiana", "yasmin_farias@papayacomunicacao.com.br", "866.322.195-94", "49008-321",
				"Aracaju", "Zona de Expansão", "357", "Rua F", "SE"));
		Integer ultimoCliente = controleCliente.ultimoCodigoCadastrado();
		assertEquals(11, ultimoCliente);
	}
	
	@Test
	void excluirCliente() {
		controleCliente.excluirCliente("264.162.494-05");
		assertEquals(9, controleCliente.obterTodosClientes().size());
	}
	
	@Test
	void validarUmCPF() {
		assertFalse(controleCliente.validarCPF("356.440.458-13"));
	}
	
	@Test
	void validarEmail() {
		assertFalse(controleCliente.validarEmail("luc@s@gmail.com"));
	}

	@Test
	void cpfNoSistema() {
		assertTrue(controleCliente.cpfNoSistema("428.047.520-20"));
	}
}
