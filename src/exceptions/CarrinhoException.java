package exceptions;

/**
 * A classe exception <b>CarrinhoException</b> é responsável por gerar exceptions relacionadas ao carrinho de vendas.
 * @version 1.0
 * @author Lucas L. Frazão - 211031771
 * @see Exception
 * @since 1.0
 */
public class CarrinhoException extends Exception{
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor padrão da classe.
	 * @param msg Mensagem a ser mostrada quando o erro for gerado
	 */
	public CarrinhoException(String msg) {
		super(msg);
	}
}
