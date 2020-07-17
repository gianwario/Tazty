package model;

public class BirraBean extends ProductBean{
	
	private String colore;
	private int gradi;
	
	public BirraBean() {
		
		colore= "";
		gradi= 0;
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

}
