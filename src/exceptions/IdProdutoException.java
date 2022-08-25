package exceptions;

/**
 * A classe exception <b>IdProdutoException</b> � respons�vel por gerar exceptions relacionadas a ids.
 * @version 1.0
 * @author Lucas L. Fraz�o - 211031771
 * @see Exception
 * @since 1.0
 */
public class IdProdutoException extends Exception{
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor padr�o da classe.
	 * @param msg Mensagem a ser mostrada quando o erro for gerado
	 */
	public IdProdutoException(String msg) {
		super(msg);
	}
}
