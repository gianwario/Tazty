package model;

public class RelativoABean {
	
	private int cod_ordine;
	private int cod_prodotto;
	private int quantita;
	
	public int getCod_ordine() {
		return cod_ordine;
	}

	public void setCod_ordine(int cod_ordine) {
		this.cod_ordine = cod_ordine;
	}

	public int getCod_prodotto() {
		return cod_prodotto;
	}

	public void setCod_prodotto(int cod_prodotto) {
		this.cod_prodotto = cod_prodotto;
	}

	public RelativoABean() {
		
		cod_ordine = 0;
		cod_prodotto = 0;
		quantita = 1;
	}

}
