package model;

public class StuzzicheriaBean {
	
	private String nome, descrizione, tipo;
	private double prezzo;
	private int cod_stuzzicheria;
	
	public StuzzicheriaBean() {
		cod_stuzzicheria=0;
		nome= "";
		descrizione= "";
		tipo= "";
		prezzo= 0;
	}
	

	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public int getCodice() {
		return cod_stuzzicheria;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	

}
