package com.stefanini.entidade;

public class Nota {

	private Integer totalNota;
	
	private Integer qualNota;

	public Nota(int i, int j) {
		qualNota = i;
		totalNota = j;
	}

	public Integer getTotalNota() {
		return totalNota;
	}

	public void setTotalNota(Integer totalNota) {
		this.totalNota = totalNota;
	}

	public Integer getQualNota() {
		return qualNota;
	}

	public void setQualNota(Integer qualNota) {
		this.qualNota = qualNota;
	}

	@Override
	public String toString() {
		return "{tot=" + totalNota + ", not=" + qualNota + "}";
	}
	
}