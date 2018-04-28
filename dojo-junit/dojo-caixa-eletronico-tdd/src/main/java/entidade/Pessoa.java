package entidade;

public class Pessoa {

	private String nome;
	private TipoPessoa tipo;
	private String numeroCPF;
	
	public Pessoa(String nome) {
		setNome(nome);
		this.tipo = TipoPessoa.Fisica;
	}
	public Pessoa(String nome, String numeroCPF, TipoPessoa tipo) {
		setNome(nome);
		setTipo(tipo);
		setNumeroCPF(numeroCPF);
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome == null || nome.isEmpty()){
			throw new IllegalArgumentException("Nome obrigatorio");
		}
		this.nome = nome;
	}
	public TipoPessoa getTipo() {
		return tipo;
	}
	public void setTipo(TipoPessoa tipo) {
		if(tipo == null){
			throw new IllegalArgumentException("tipo obrigatorio");
		}
		this.tipo = tipo;
	}
	public String getNumeroCPF() {
		return numeroCPF;
	}
	public void setNumeroCPF(String numeroCPF) {
		if(numeroCPF == null || numeroCPF.isEmpty()){
			throw new IllegalArgumentException("cpf obrigatorio");
		}
		this.numeroCPF = numeroCPF;
	}
	
	@Override
	public String toString() {
		return "{nome=" + nome + ", tipo=" + tipo + ", cpf=" + numeroCPF + "}";
	}
	
}