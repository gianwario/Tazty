package model;

public class IngredientBean {
	
	private String nome, tipo;
	private double prezzo;
	private int codice;
	
	public IngredientBean() {
		
		this.nome= "";
		this.prezzo = 0;
		this.tipo = "";
		this.codice = 0;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	public String toString() {
		
		return "CODICE: " + codice + ", " + nome + ", tipo: " + tipo + ", €" + prezzo;
	}
	
	public boolean equals(Object ob) {
		
		return super.equals(ob);
	}

}
