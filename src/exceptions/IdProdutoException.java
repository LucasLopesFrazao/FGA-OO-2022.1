package exceptions;

/**
 * A classe exception <b>IdProdutoException</b> é responsável por gerar exceptions relacionadas a ids 
 * @version 1.0
 */
public class IdProdutoException extends Exception{
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor padrão
	 * @param msg Mensagem a ser mostrada quando o erro for gerado
	 */
	public IdProdutoException(String msg) {
		super(msg);
	}
}
