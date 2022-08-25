package application;

import controle.ControleVenda;
import controle.ControleCliente;
import controle.ControleProduto;
import controle.ControleVendedor;
import view.TelaPrincipal;

/**
 * Classe principal do programa, responsável por iniciar a main da view principal e também iniciar uma instanciação de cada controle para existir apenas 1 "Banco de dados" para cada controle.
 * 
 * @see ControleProduto
 * @see ControleCliente
 * @see ControleVenda
 * @see ControleVendedor
 * @version 1.0
 * @since 1.0
 * @author Lucas L. Frazão - 211031771
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
