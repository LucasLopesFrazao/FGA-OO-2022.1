package application;

import controle.ControleCliente;
import controle.ControleProduto;
import controle.ControleVenda;
import controle.ControleVendedor;

/**
 * Classe principal do programa, respons�vel por iniciar a main da view principal e tamb�m iniciar uma instancia��o de cada controle para existir apenas 1 "Banco de dados" para cada controle.
 * 
 * @see ControleProduto
 * @see ControleCliente
 * @see ControleVenda
 * @see ControleVendedor
 * @version 1.0
 * @since 1.0
 * @author Lucas L. Fraz�o - 211031771
 */
public class Main {	
	// INSTANCIA��ES DOS BANCOS DE DADOS
	public static ControleCliente controleCliente = new ControleCliente();
	public static ControleVendedor controleVendedor = new ControleVendedor();
	public static ControleProduto controleProduto = new ControleProduto();
	public static ControleVenda controleVenda = new ControleVenda();
}
