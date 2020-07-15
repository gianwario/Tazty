package model;

public class BirraBean {
	
	private String nome, descrizione, colore;
	private double prezzo;
	private int cod_birra,gradi;
	
	public BirraBean() {
		cod_birra=0;
		nome= "";
		descrizione= "";
		colore= "";
		gradi= 0;
		prezzo= 0;
	}
	
	public String getColore() {
		return colore;
	}
	
	public void setColore(String colore) {
		this.colore = colore;
	}

	public int getGradi() {
		return gradi;
	}

	public void setGradi(int gradi) {
		this.gradi = gradi;
	}

	public int getCodice() {
		return cod_birra;
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
