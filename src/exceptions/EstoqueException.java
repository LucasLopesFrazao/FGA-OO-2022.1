package exceptions;

/**
 * A classe exception <b>EstoqueException</b> � respons�vel por gerar exceptions relacionadas ao estoque de produtos.
 * @version 1.0
 * @author Lucas L. Fraz�o - 211031771
 * @see Exception
 * @since 1.0
 */
public class EstoqueException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor padr�o da classe.
	 * @param msg Mensagem a ser mostrada quando o erro for gerado
	 */
	public EstoqueException(String msg) {
		super(msg);
	}
}
