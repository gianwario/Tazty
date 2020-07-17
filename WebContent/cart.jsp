<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>

<!doctype html>
<html>

<head>
<title>Carrello</title>
<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=Balsamiq+Sans:wght@400;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="css/user.style/cart.css" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Pangolin&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href=" https://fonts.googleapis.com/css?family=Open+Sans:400,700,600">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
	type="text/javascript"></script>
<script src="js/cart.js"></script>
</head>
<body>
	<%
		Carrello carrello = (Carrello) request.getSession().getAttribute("carrello");

	if (carrello == null || carrello.getprodotto().isEmpty()) {
	%>
	<h1 style="text-align:center;color:red;font-size:20px;">Carrello vuoto</h1>
	<%
		} else {
		ArrayList<ProductBean> prodotti = carrello.getprodotto();
	%>


	<div class="row">
		<div class="basket">
			<div class="basket-labels">
				<ul>
					<li class="item item-heading">Articolo</li>
					<li class="price">Prezzo</li>
					<li class="quantity">Quantitá</li>
					<li class="subtotal">Totale</li>
				</ul>
			</div>
			<%
				for (ProductBean prodotto : prodotti)
				if (prodotto != null) {
			%>

			<div class="basket-product">
				<div class="item">
					<div class="product-details">
						<h1 class="item-title">
							<strong><span>QUANTITÁ QUI</span> <%=prodotto.getNome()%></strong>
						</h1>
						<p>
							<strong>DESCRIZIONE QUI</strong>
						</p>
						<p>CODICE PRODOTTO QUI</p>
					</div>
				</div>
				<div class="price">22</div>
				<div class="quantity">
					<input type="number" value="4" min="1" class="quantity-field">
				</div>
				<div class="subtotal">TOTALE</div>
				<div class="remove">
					<button>Rimuovi</button>
				</div>
			</div>
			<%
				}
			}
			%>

		</div>
	</div>




	<div class="row2">
		<div class="summary">
			<div class="summary-total-items">
				<span class="total-items"></span> Articoli nel carrello
			</div>
			<div class="summary-subtotal">
				<div class="subtotal-title">Sub-Totale</div>
				<div class="subtotal-value final-value" id="basket-subtotal">
					Sub TOTALE QUI</div>
			</div>

			<div class="summary-total">
				<div class="total-title">Totale</div>
				<div class="total-value final-value" id="basket-total">130.00</div>
			</div>
			<div class="summary-checkout">
				<button class="checkout-cta">Procedi all'ordine</button>
			</div>
		</div>
	</div>
</body>

</html>