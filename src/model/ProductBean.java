package model;

public class ProductBean {

	private String nome, descrizione;
	private double prezzo;
	int cod_prodotto;

	public ProductBean() {

		cod_prodotto = 0;
		nome = "";
		descrizione = "";
		prezzo = 0;

	}

	public int getCod_prodotto() {
		return cod_prodotto;
	}
	
	public void setCod_prodotto(int cod_prodotto) {
		this.cod_prodotto = cod_prodotto;
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
