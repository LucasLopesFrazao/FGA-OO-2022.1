package exceptions;

/**
 * A classe exception <b>EstoqueException</b> é responsável por gerar exceptions relacionadas ao estoque de produtos
 * @version 1.0
 */
public class EstoqueException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor padrão
	 * @param msg Mensagem a ser mostrada quando o erro for gerado
	 */
	public EstoqueException(String msg) {
		super(msg);
	}
}
