package application;

import controle.ControleVenda;
import controle.ControleCliente;
import controle.ControleProduto;
import controle.ControleVendedor;
import view.TelaPrincipal;

/**
 * Classe Main do programa, responsável por iniciar a tela principal e também iniciar uma instanciação de cada controle
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) {
		TelaPrincipal.main(args); // INICIANDO TELA PRINCIPAL
	}
	
	// INSTANCIAÇÕES DOS BANCOS DE DADOS
	public static ControleCliente controleCliente = new ControleCliente();
	public static ControleVendedor controleVendedor = new ControleVendedor();
	public static ControleProduto controleProduto = new ControleProduto();
	public static ControleVenda controleVenda = new ControleVenda();
}
