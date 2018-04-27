package entidade;

public class Pessoa {

	private String nome;

	/**
	 * Tipos: F = Fisica; J = Juridica
	 */
	private Character tipoPessoJuridica;

	private String numeroCPF;

	public Pessoa(String nome, String cpf, char tipo) {
		this.nome = nome;
		numeroCPF = cpf;
		tipoPessoJuridica = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Character getTipoPessoJuridica() {
		return tipoPessoJuridica;
	}

	public void setTipoPessoJuridica(Character tipoPessoJuridica) {
		this.tipoPessoJuridica = tipoPessoJuridica;
	}

	public String getNumeroCPF() {
		return numeroCPF;
	}

	public void setNumeroCPF(String numeroCPF) {
		this.numeroCPF = numeroCPF;
	}

}