package model;

public class NewBean {
	
	private int id;
	private String titolo, corpo, dataora, username;
	
	public NewBean() {
		id=0;
		titolo=corpo=dataora=username=null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public String getDataora() {
		return dataora;
	}

	public void setDataora(String dataora) {
		this.dataora = dataora;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String toString() {
		return id + " " + titolo + " " +corpo + " " + dataora + " " + username + " ";
	}

}
