package entidade;

import java.util.Objects;

public class Conta {

	private Pessoa pessoa;
	private String numAgencia;
	private String numConta;
	private TipoConta tipo;
	private Integer saldo = 0;

	public Conta(String numConta, String numAgencia, TipoConta tipo, Pessoa pessoa) {
		setNumConta(numConta);
		setNumAgencia(numAgencia);
		setTipo(tipo);
		setPessoa(pessoa);
	}

    public static Conta of(Conta conta) {
		return new Conta(conta.getNumConta(), conta.getNumAgencia(), conta.getTipo(), conta.getPessoa());
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

	@Override
	public String toString() {
		return "{pessoa=" + pessoa + ", agencia=" + numAgencia + ", conta=" + numConta + "}";
	}

	public void depositar(Integer valor) {
		Objects.requireNonNull(valor);
        if(valor < 1){
            throw new IllegalArgumentException("valor invalido");
        }
		this.saldo += valor;
	}

    public void sacar(Integer valor) {
        Objects.requireNonNull(valor);
        if(this.saldo < valor){
            throw new IllegalArgumentException("saldo menor que o saque");
        }
        this.saldo -= valor;
    }
}