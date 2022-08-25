package exceptions;

/**
 * A classe exception <b>CampoEmBrancoException</b> é responsável por gerar exceptions relacionadas a campos vazios.
 * @version 1.0
 * @author Lucas L. Frazão - 211031771
 * @see Exception
 * @since 1.0
 * 
 */
public class CampoEmBrancoException extends Exception{
	static final long serialVersionUID = 1L;
	
	/**
	 * Construtor padrão da classe.
	 * @param msg Mensagem a ser mostrada quando o erro for gerado.
	 */
	public CampoEmBrancoException(String msg) {
		super(msg);
	}

}