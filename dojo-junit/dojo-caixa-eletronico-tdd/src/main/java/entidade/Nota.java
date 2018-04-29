package entidade;

import java.util.Objects;

public class Nota {

	private Integer qtde;
	private Integer especie;

	public Nota(Integer especie) {
		setEspecie(especie);
		this.qtde = 0;
	}
	public Nota(Integer especie, Integer qtde) {
		setEspecie(especie);
		setQtde(qtde);
	}
	
	public Integer getEspecie() {
		return especie;
	}
	private void setEspecie(Integer especie) {
		Objects.requireNonNull(especie);
		this.especie = especie;
	}
	public Integer getQtde() {
		return qtde;
	}
	public void setQtde(Integer qtde) {
		Objects.requireNonNull(qtde);
		this.qtde = qtde;
	}
	
	@Override
	public String toString() {
		return "{Qtde=" + qtde + ", Especie=" + especie + "}";
	}
	
}