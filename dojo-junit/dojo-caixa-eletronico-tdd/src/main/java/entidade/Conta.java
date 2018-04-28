package entidade;

public class Conta {

	private Pessoa pessoa;
	private String numAgencia;
	private String numConta;
	private TipoConta tipo;
	private Integer saldo;

	public Conta(String numConta, String numAgencia, TipoConta tipo, int saldo, Pessoa pessoa) {
		setNumConta(numConta);
		setNumAgencia(numAgencia);
		setTipo(tipo);
		this.saldo = saldo;
		setPessoa(pessoa);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		if(pessoa == null){
			throw new IllegalArgumentException("Pessoa obrigatorio");
		}
		this.pessoa = pessoa;
	}
	public String getNumAgencia() {
		return numAgencia;
	}
	public void setNumAgencia(String numAgencia) {
		if(numAgencia == null || numAgencia.isEmpty()){
			throw new IllegalArgumentException("Numero da agencia obrigatorio");
		}
		this.numAgencia = numAgencia;
	}
	public String getNumConta() {
		return numConta;
	}
	public void setNumConta(String numConta) {
		if(numConta == null || numConta.isEmpty()){
			throw new IllegalArgumentException("Numero da agencia obrigatorio");
		}
		this.numConta = numConta;
	}
	public TipoConta getTipo() {
		return tipo;
	}
	public void setTipo(TipoConta tipo) {
		if(tipo == null) {
			throw new IllegalArgumentException("Tipo da conta obrigatorio");
		}
		this.tipo = tipo;
	}
	public Integer getSaldo() {
		return saldo;
	}
	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "{pessoa=" + pessoa + ", agencia=" + numAgencia + ", conta=" + numConta + "}";
	}
	
}