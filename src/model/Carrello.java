package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Carrello {
	private ArrayList<ProductBean> prodotto;
	public Carrello() {
		prodotto = new ArrayList<>();
	}
	public void remove(int codice) {
		Iterator<ProductBean> iterator = prodotto.iterator();
		while(iterator.hasNext()) {
			ProductBean pr = iterator.next();
			if(pr.getCod_prodotto()==codice)
				iterator.remove();
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