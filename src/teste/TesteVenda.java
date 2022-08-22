package teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import application.Main;
import controle.ControleCliente;
import controle.ControleProduto;
import controle.ControleVenda;
import controle.ControleVendedor;
import modelo.Pedido;
import modelo.Venda;

class TesteVenda {

    ControleCliente controleCliente = Main.controleCliente;
    ControleVendedor controleVendedor = Main.controleVendedor;
    ControleProduto controleProduto = Main.controleProduto;
    ControleVenda controleVenda = Main.controleVenda;
    
	@Test
	void adicionarVenda() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			List<Pedido> pedidosVenda = new ArrayList<>();
			pedidosVenda.add(new Pedido(controleProduto.pesquisarProdutoId(1), 1, controleProduto.pesquisarProdutoId(1).getPreco()*1));
			pedidosVenda.add(new Pedido(controleProduto.pesquisarProdutoId(11), 1, controleProduto.pesquisarProdutoId(11).getPreco()*1));
			pedidosVenda.add(new Pedido(controleProduto.pesquisarProdutoId(19), 2, controleProduto.pesquisarProdutoId(19).getPreco()*2));
			controleVenda.adicionarVenda(new Venda(11, sdf.parse("18/05/2022"), 11789.96, controleVendedor.pesquisarPorNome("Raf"), controleCliente.pesquisarClientePorCPF("264.162.494-05"), pedidosVenda));
		} catch (ParseException e) {

		}
		assertEquals(11, controleVenda.ultimoCodigoCadastrado());
	}
}
