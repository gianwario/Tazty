<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>
<!doctype html>
<html>

<head>
<title>Menu</title>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Balsamiq+Sans:wght@400;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="css/mainpage.style/main.css"
	type="text/css">
<link rel="stylesheet" href="css/mainpage.style/navbar.css"
	type="text/css">
<link rel="stylesheet" href="css/menu.style/shopping.css"
	type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Pangolin&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&display=swap"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="header">
			<div class="home_redirect">
		  		<a href=<%= response.encodeURL("index.jsp")%> title="Ritorna alla home">
		  		<img src="images/logo2.png" alt="Torna alla home" width="100%" height="90%">
		  		</a>
		  	</div>
		  	<div class="wrap">
					<form class="search" action=<%= response.encodeURL("Ricerca")%> method="GET">
						<input class="searchTerm" type="text" placeholder="Cerca.."
							name="cerca" onkeyup="ricercaAjax(this.value)" list="ricerca-datalist">
						<button class="searchButton" type="submit">
							<i class="fa fa-search"></i>
						</button>
						<datalist id="ricerca-datalist"></datalist>
					</form>
			</div>
			<% Carrello c = (Carrello)session.getAttribute("carrello"); %>
			<div id="order">
				<a href=<%= response.encodeURL("cart.jsp")%> id="order-link"><i class="fa fa-shopping-cart" style="height:100%;margin-right:10%;"></i>Carrello <%if(c!=null){ %>(<%= c.getprodotto().size() %>)<%} %></a>
			</div>
		</div>
		
		<div class="sbrody">
			<% if(request.getAttribute("cercato")==null){ %>
			<div id="menus">
				<fieldset>
				<legend>Panini</legend>
					
					<div class="griglia">
					<% ArrayList<PaninoBean> panini2 = (ArrayList<PaninoBean>)request.getAttribute("panini");
					for(PaninoBean p : panini2) {
					%>
						<div class="card">
							<h1><img src="images/Menu/Paninoshopping.jpg" style="width: 40%; padding-top:2%;"></h1>
							<h1 class="nome_prodotto"><%= p.getNome() %></h1>
							<p class="descrizione"><%= p.getDescrizione() %></p>
							<p class="descrizione">Tipo pane: <%= p.getTipo() %></p>
							<p class="prezzo">€ <%= p.getPrezzo() %></p>
							<div>
								<form action="<%= response.encodeURL("CarrelloServlet") %>" method="POST">
									<input type="text" value="<%= p.getCod_prodotto() %>" name="codice" style="display:none">
									<button class="carrellobutton"><i class="fa fa-shopping-cart" style="margin-right: 5%;"></i>Aggiungi al carrello</button>
								</form>
							</div>
						</div>
					<% } %>
					</div>
				</fieldset>
				<fieldset>
				<legend>Stuzzicherie</legend>
					
					<div class="griglia">
					<% ArrayList<StuzzicheriaBean> stuzzicherie = (ArrayList<StuzzicheriaBean>)request.getAttribute("stuzzicherie");
					for(StuzzicheriaBean s : stuzzicherie) {
					%>
						<div class="card">
							<h1><img src="images/Menu/Patatineshopping.jpg" style="width: 40%; padding-top:2%;"></h1>
							<h1 class="nome_prodotto"><%= s.getNome() %></h1>
							<p class="descrizione"><%= s.getDescrizione() %></p>
							<p class="descrizione">Tipo: <%= s.getTipo() %></p>
							<p class="prezzo">€ <%= s.getPrezzo() %></p>
							<div>
								<form action="<%= response.encodeURL("CarrelloServlet") %>" method="POST">
									<input type="text" value="<%= s.getCod_prodotto() %>" name="codice" style="display:none">
									<button class="carrellobutton"><i class="fa fa-shopping-cart" style="margin-right: 5%;"></i>Aggiungi al carrello</button>
								</form>							
							</div>
						</div>
					<% } %>
					</div>
				</fieldset>
				<fieldset>
					<legend>Birre</legend>
					
					<div class="griglia">
					<% ArrayList<BirraBean> birre = (ArrayList<BirraBean>)request.getAttribute("birre");
					for(BirraBean b : birre) {
					%>
						<div class="card">
							<h1><img src="images/Menu/Beershopping.png" style="width: 40%; padding-top:2%;"></h1>
							<h1 class="nome_prodotto"><%= b.getNome() %></h1>
							<p class="descrizione"><%= b.getDescrizione() %></p>
							<p class="descrizione">Colore: <%= b.getColore() %></p>
							<p class="descrizione">Gradazione: <%= b.getGradi() %></p>
							<p class="prezzo">€ <%= b.getPrezzo() %></p>
							<div>
								<form action="<%= response.encodeURL("CarrelloServlet") %>" method="POST">
									<input type="text" value="<%= b.getCod_prodotto() %>" name="codice" style="display:none">
									<button class="carrellobutton"><i class="fa fa-shopping-cart" style="margin-right: 5%;"></i>Aggiungi al carrello</button>
								</form>
							</div>
						</div>
					<% } %>
					</div>
				</fieldset>
			</div>
			<% } else { %>
				<fieldset>
					<legend>Prodotti trovati</legend>
					
					<div class="griglia">
					<% ArrayList<ProductBean> prodotti = (ArrayList<ProductBean>)request.getAttribute("prodotti");
					for(ProductBean b : prodotti) {
					%>
						<div class="card">
							<h1><img src="images/Menu/Beershopping.png" style="width: 40%; padding-top:2%;"></h1>
							<h1 class="nome_prodotto"><%= b.getNome() %></h1>
							<p class="descrizione"><%= b.getDescrizione() %></p>
							<p class="prezzo">€ <%= b.getPrezzo() %></p>
							<div>
								<form action="<%= response.encodeURL("CarrelloServlet") %>" method="POST">
									<input type="text" value="<%= b.getCod_prodotto() %>" name="codice" style="display:none">
									<button class="carrellobutton"><i class="fa fa-shopping-cart" style="margin-right: 5%;"></i>Aggiungi al carrello</button>
								</form>							
							</div>
						</div>
					<% } %>
					</div>
				</fieldset>
			
			<% } %>
			
		</div>
	</div>
	<script>
	function ricercaAjax(str) {
		var dataList = document.getElementById('ricerca-datalist');
		if (str.length == 0) {
			// rimuove elementi <option> (suggerimenti) esistenti
			dataList.innerHTML = ' ';
			return;
		}

		var xmlHttpReq = new XMLHttpRequest();
		xmlHttpReq.responseType = 'json';
		xmlHttpReq.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				// rimuove elementi <option> (suggerimenti) esistenti
				dataList.innerHTML = ' ';

				for ( var i in this.response) {
				
					// crea un elemento option
					var option = document.createElement('option');
					// setta il valore
					option.value = this.response[i];
					// aggiunge elemento <option> a datalist
					dataList.appendChild(option);
				}
			}
		}
		xmlHttpReq.open("GET", "RicercaAJAX?q=" + encodeURIComponent(str), true);
		xmlHttpReq.send();
	}
	</script>
</body>
</html>