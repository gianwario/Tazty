package model;

import java.util.ArrayList;

public class Carrello {
	private ArrayList<ProductBean> prodotto;
	public Carrello() {
		prodotto = new ArrayList<>();
	}
	public void remove(int codice) {
		for(ProductBean p : prodotto) {
			if(p.getCod_prodotto() == codice) {
				prodotto.remove(p);
				return;
			}
		}
	}
	public ArrayList<ProductBean> getprodotto() {
		return prodotto;
	}
	public void setprodotto(ArrayList<ProductBean> prodotto) {
		this.prodotto = prodotto;
	}
	public void add(ProductBean c) {
		prodotto.add(c);
	}
	
	public String getPrezzoTotale() {
		long totale = 0;
		for(ProductBean c : prodotto)
			totale+=c.getPrezzo();
		return String.format("%.2f", totale / 10000.);
	}
}