package modelo;

/**
 * Classe utilizada no controleCliente, � apenas uma classe para modelar um cliente.
 * 
 * @version 1.0
 * @since 1.0
 * @author Lucas L. Fraz�o - 211031771
 */

public class Cliente extends PessoaAbstrata{
	
	private String cpf;
	private Endereco endereco = new Endereco();
	
	public Cliente() {
		
	}
	
	public Cliente(Integer id, String nome, String email, String cpf, String cep, String cidade, String endereco, String numero, String bairro, String uf) {
		super.setId(id);
		super.setNome(nome);
		super.setEmail(email);
		this.cpf = cpf;
		this.endereco.setCep(cep);
		this.endereco.setCidade(cidade);
		this.endereco.setEndereco(endereco);
		this.endereco.setNumero(numero);
		this.endereco.setBairro(bairro);
		this.endereco.setUf(uf);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", endereco=" + endereco + ", getId()=" + getId() + ", getNome()=" + getNome()
				+ ", getEmail()=" + getEmail() + "]";
	}	
}