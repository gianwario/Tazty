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
		  		<a href="index.jsp" title="Ritorna alla home">
		  		<img src="images/logo2.png" alt="Torna alla home" width="100%" height="80%">
		  		</a>
		  	</div>
		  	<div class="wrap">
					<div class="search">
						<input class="searchTerm" type="text" placeholder="Cerca.."
							name="cerca">
						<button class="searchButton" type="submit">
							<i class="fa fa-search"></i>
						</button>
					</div>
			</div>
			<div id="order">
				<a href="#" id="order-link"><i class="fa fa-shopping-cart" style="height:100%;margin-right:10%;"></i>Carrello</a>
			</div>
		</div>
		<div id="filters-container">
		</div>
		<div class="sbrody">
			
			<fieldset>
			<legend>Panini</legend>
				<
				<div class="griglia">
					<div class="card">
						<img src="images/Paninoshopping.jpg" style="width: 100%">
						<h1 class="nome_prodotto">Panino Sasicc e friariell</h1>
						<p class="descrizione">Descrizione panino qui</p>
						<p class="prezzo">â¬19.99</p>
						<div>
							<button class="carrellobutton"><i class="fa fa-shopping-cart" style="margin-right: 5%;"></i>Aggiungi al carrello</button>
						</div>
					</div>
				</div>
			</fieldset>
		</div>
	</div>
</body>
</html>