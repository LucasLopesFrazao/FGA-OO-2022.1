package controle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import application.Main;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;
import modelo.Venda;
import modelo.Vendedor;

/**
 * A classe <b>ControleVenda</b> define uma relação com a classe {@link Produto}, {@link Cliente}, {@link Vendedor} e {@link Venda} (models) com as telas de vendas.
 * 
 * <p>
 * Essa classe é responsável por gerenciar a lista de venda junto com os métodos necessários
 * </p>
 * 
 * @see ControleCliente
 * @see ControleProduto
 * @see ControleVendedor
 * @see Venda
 * @see Pedido
 * 
 * @author Lucas L. Frazão - 211031771
 * @version 1.0
 * @since 1.0
 */
public class ControleVenda {
	ControleVendedor controleVendedor = Main.controleVendedor;
	ControleCliente controleCliente = Main.controleCliente;
	ControleProduto controleProduto = Main.controleProduto;
	
	List<Venda> vendas = new ArrayList<>();
	
	/**
	 * O construtor default da classe, onde entramos com dados mocados na lista.
	 */
	public ControleVenda() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			// VENDA 1
			List<Pedido> pedidosVenda1 = new ArrayList<>();
			pedidosVenda1.add(new Pedido(controleProduto.pesquisarProduto(1), 1, controleProduto.pesquisarProduto(1).getPreco()*1, controleProduto.pesquisarProduto(1).getPreco()));
			pedidosVenda1.add(new Pedido(controleProduto.pesquisarProduto(11), 1, controleProduto.pesquisarProduto(11).getPreco()*1, controleProduto.pesquisarProduto(11).getPreco()));
			pedidosVenda1.add(new Pedido(controleProduto.pesquisarProduto(19), 2, controleProduto.pesquisarProduto(19).getPreco()*2, controleProduto.pesquisarProduto(19).getPreco()));
			vendas.add(new Venda(1, sdf.parse("18/05/2022"), 11789.96, controleVendedor.pesquisarPorNome("Raf"), controleCliente.pesquisarClientePorCPF("264.162.494-05"), pedidosVenda1));
			
			// VENDA 2
			List<Pedido> pedidosVenda2 = new ArrayList<>();
			pedidosVenda2.add(new Pedido(controleProduto.pesquisarProduto(12), 1, controleProduto.pesquisarProduto(12).getPreco()*1, controleProduto.pesquisarProduto(12).getPreco()));
			pedidosVenda2.add(new Pedido(controleProduto.pesquisarProduto(21), 1, controleProduto.pesquisarProduto(21).getPreco()*1, controleProduto.pesquisarProduto(21).getPreco()));
			pedidosVenda2.add(new Pedido(controleProduto.pesquisarProduto(15), 1, controleProduto.pesquisarProduto(15).getPreco()*1, controleProduto.pesquisarProduto(15).getPreco()));
			pedidosVenda2.add(new Pedido(controleProduto.pesquisarProduto(10), 1, controleProduto.pesquisarProduto(10).getPreco()*1, controleProduto.pesquisarProduto(10).getPreco()));
			vendas.add(new Venda(2, sdf.parse("19/05/2022"), 6549.46, controleVendedor.pesquisarPorNome("Vic"), controleCliente.pesquisarClientePorCPF("619.021.645-55"), pedidosVenda2));
			
			// VENDA 3
			List<Pedido> pedidosVenda3 = new ArrayList<>();
			pedidosVenda3.add(new Pedido(controleProduto.pesquisarProduto(5), 1, controleProduto.pesquisarProduto(5).getPreco()*1, controleProduto.pesquisarProduto(5).getPreco()));
			vendas.add(new Venda(3, sdf.parse("19/05/2022"), 9176.00, controleVendedor.pesquisarPorNome("Carla"), controleCliente.pesquisarClientePorCPF("428.047.520-20"), pedidosVenda3));
			
			// VENDA 4
			List<Pedido> pedidosVenda4 = new ArrayList<>();
			pedidosVenda4.add(new Pedido(controleProduto.pesquisarProduto(6), 1, controleProduto.pesquisarProduto(6).getPreco()*1, controleProduto.pesquisarProduto(6).getPreco()));
			pedidosVenda4.add(new Pedido(controleProduto.pesquisarProduto(7), 1, controleProduto.pesquisarProduto(7).getPreco()*1, controleProduto.pesquisarProduto(7).getPreco()));
			vendas.add(new Venda(4, sdf.parse("01/06/2022"), 1443.79, controleVendedor.pesquisarPorNome("Gio"), controleCliente.pesquisarClientePorCPF("577.468.789-97"), pedidosVenda4));
			
			// VENDA 5
			List<Pedido> pedidosVenda5 = new ArrayList<>();
			pedidosVenda5.add(new Pedido(controleProduto.pesquisarProduto(21), 1, controleProduto.pesquisarProduto(21).getPreco()*1, controleProduto.pesquisarProduto(21).getPreco()));
			pedidosVenda5.add(new Pedido(controleProduto.pesquisarProduto(22), 1, controleProduto.pesquisarProduto(22).getPreco()*1, controleProduto.pesquisarProduto(22).getPreco()));
			pedidosVenda5.add(new Pedido(controleProduto.pesquisarProduto(23), 3, controleProduto.pesquisarProduto(23).getPreco()*3, controleProduto.pesquisarProduto(23).getPreco()));
			vendas.add(new Venda(5, sdf.parse("09/06/2022"), 1499.92, controleVendedor.pesquisarPorNome("Tânia"), controleCliente.pesquisarClientePorCPF("007.938.968-60"), pedidosVenda5));
			
			// VENDA 6
			List<Pedido> pedidosVenda6 = new ArrayList<>();
			pedidosVenda6.add(new Pedido(controleProduto.pesquisarProduto(13), 1, controleProduto.pesquisarProduto(13).getPreco()*1, controleProduto.pesquisarProduto(13).getPreco()));
			pedidosVenda6.add(new Pedido(controleProduto.pesquisarProduto(15), 1, controleProduto.pesquisarProduto(15).getPreco()*1, controleProduto.pesquisarProduto(15).getPreco()));
			vendas.add(new Venda(6, sdf.parse("13/06/2022"), 3609.5, controleVendedor.pesquisarPorNome("Carla"), controleCliente.pesquisarClientePorCPF("775.729.750-89"), pedidosVenda6));
			
			// VENDA 7
			List<Pedido> pedidosVenda7 = new ArrayList<>();
			pedidosVenda7.add(new Pedido(controleProduto.pesquisarProduto(1), 1, controleProduto.pesquisarProduto(1).getPreco()*1, controleProduto.pesquisarProduto(1).getPreco()));
			vendas.add(new Venda(7, sdf.parse("05/07/2022"), 8549.00, controleVendedor.pesquisarPorNome("Vic"), controleCliente.pesquisarClientePorCPF("591.590.805-58"), pedidosVenda7));
			
			// VENDA 8
			List<Pedido> pedidosVenda8 = new ArrayList<>();
			pedidosVenda8.add(new Pedido(controleProduto.pesquisarProduto(2), 1, controleProduto.pesquisarProduto(2).getPreco()*1, controleProduto.pesquisarProduto(2).getPreco()));
			pedidosVenda8.add(new Pedido(controleProduto.pesquisarProduto(8), 1, controleProduto.pesquisarProduto(8).getPreco()*1, controleProduto.pesquisarProduto(8).getPreco()));
			vendas.add(new Venda(8, sdf.parse("26/07/2022"), 12588.9, controleVendedor.pesquisarPorNome("Tânia"), controleCliente.pesquisarClientePorCPF("983.467.257-87"), pedidosVenda8));
			
			// VENDA 9
			List<Pedido> pedidosVenda9 = new ArrayList<>();
			pedidosVenda9.add(new Pedido(controleProduto.pesquisarProduto(16), 1, controleProduto.pesquisarProduto(16).getPreco()*1, controleProduto.pesquisarProduto(16).getPreco()));
			pedidosVenda9.add(new Pedido(controleProduto.pesquisarProduto(17), 1, controleProduto.pesquisarProduto(17).getPreco()*1, controleProduto.pesquisarProduto(17).getPreco()));
			pedidosVenda9.add(new Pedido(controleProduto.pesquisarProduto(18), 1, controleProduto.pesquisarProduto(18).getPreco()*1, controleProduto.pesquisarProduto(18).getPreco()));
			vendas.add(new Venda(9, sdf.parse("01/08/2022"), 824.59, controleVendedor.pesquisarPorNome("Gio"), controleCliente.pesquisarClientePorCPF("346.403.030-09"), pedidosVenda9));
			
			// VENDA 10
			List<Pedido> pedidosVenda10 = new ArrayList<>();
			pedidosVenda10.add(new Pedido(controleProduto.pesquisarProduto(11), 1, controleProduto.pesquisarProduto(11).getPreco()*1, controleProduto.pesquisarProduto(11).getPreco()));
			pedidosVenda10.add(new Pedido(controleProduto.pesquisarProduto(12), 1, controleProduto.pesquisarProduto(12).getPreco()*1, controleProduto.pesquisarProduto(12).getPreco()));
			pedidosVenda10.add(new Pedido(controleProduto.pesquisarProduto(13), 1, controleProduto.pesquisarProduto(13).getPreco()*1, controleProduto.pesquisarProduto(13).getPreco()));
			vendas.add(new Venda(10, sdf.parse("08/08/2022"), 7798.09, controleVendedor.pesquisarPorNome("Carla"), controleCliente.pesquisarClientePorCPF("677.174.865-04"), pedidosVenda10));
	} catch (ParseException e) {
			
		}
	}
	
	/**
	 * Esse método adiociona uma venda na lista.
	 * @param venda Venda a ser adicionado .
	 * @see Venda
	 */
	public void adicionarVenda(Venda venda) {
		vendas.add(venda);	
	}
	
	/**
	 * Esse método retorna o ultimo id do cliente adicionado na lista.
	 * @return Ultimo id do cliente da lista.
	 */
	public Integer ultimoCodigoCadastrado() {
		return vendas.get((vendas.size() - 1)).getId();
	}
	
	/**
	 * Este método retorna o total de uma venda.
	 * @param pedidos Lista de pedidos com os produtos.
	 * @return Total da venda do pedido.
	 */
	public Double totalVenda(List<Pedido> pedidos) {
		Double total = 0.0;
		for(Pedido p: pedidos) {
			total += p.getPrecoTotal();
		}
		return total;
	}
	
	/**
	 * Este método retorna todas as vendas feitas dentro de um período de datas.
	 * @param dataInicial Data inicial do período.
	 * @param dataFinal Data final do período.
	 * @return Retorna todas as compras entre a data inicial e a data final.
	 * @see Venda
	 */
	public List<Venda> consultarVendaComData(Date dataInicial, Date dataFinal){
		List<Venda> vendasConsultadas = new ArrayList<>();
		for(Venda v: vendas) {
			if(v.getDataVenda().after(dataInicial) && v.getDataVenda().before(dataFinal)) {
				vendasConsultadas.add(v);
			}
		}
		return vendasConsultadas;
	}
	
	/**
	 * Este método retorna uma venda
	 * @param id Id a ser consultado na lista
	 * @return retorna uma Venda ou null
	 * @see Venda
	 */
	public Venda consultarVenda(Integer id) {
		for(Venda v:vendas) {
			if(v.getId()==id) {
				return v;
			}
		}
		return null;
	}
}
