package model;

import java.util.ArrayList;

public class OrdineBean {
	
	private String data_ora,pagamento;
	private int cod_ordine;
	private double totale;
	private String username;
	private ArrayList<ProductBean> pb;
	
	public OrdineBean() {
		
		cod_ordine=0;
		data_ora= "";
		totale= 0;
		pagamento="";
		username="";
		pb= new ArrayList<ProductBean>();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getData_ora() {
		return data_ora;
	}

	public void setData_ora(String data_ora) {
		this.data_ora = data_ora;
	}

	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}

	public int getCod_ordine() {
		return cod_ordine;
	}

	public void setCod_ordine(int cod_ordine) {
		this.cod_ordine = cod_ordine;
	}

	public double getTotale() {
		return totale;
	}

	public void setTotale(double totale) {
		this.totale = totale;
	}
	
	
	public ArrayList<ProductBean> getProductList(){
		return pb;
	}
	
	public void setProductList(ArrayList<ProductBean> list) {
		pb = list;		
	}
	public void addProduct(ProductBean p){
		pb.add(p);
	}
}
