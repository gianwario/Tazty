<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Completa ordine</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/user.style/order.css" type="text/css">
</head>


<body>
	<% Carrello cart = (Carrello) request.getSession().getAttribute("carrello"); 
	   UserBean user = (UserBean) request.getSession().getAttribute("utente");
	   
	   double sum = 5;
	   for(ProductBean p : cart.getprodotto())
	   		sum+= p.getPrezzo();%>
		
	  <div id="confirmation"> <span> CONFERMA ORDINE </span> </div>
	  <div id="user-infos"> 
	  	
	  	<div id="user-name"> <b><%=user.getNome() + " " + user.getCognome()%></b></div>
	  	<div class="infos">
	  		<span><i class="fa fa-envelope-o"> </i> Email:</span>  <%=user.getEmail() %>
	  	</div>
	  	<div class="infos"> 
	  		<i class="fa fa-map-marker"> </i> Indirizzo di spedizione: <input type="text" class="fields" value="<%=user.getIndirizzo() %>">
	  	</div>
	  	<div class="infos"> 
	  		<i class="fa fa-phone"> </i> Recapito telefonico: <input type="text" class="fields" value="<%=user.getCellulare() %>">
	  	</div>
	  	<div class="infos"> 
	  		<span>Importo totale:</span> <span style= "font-size: 22px"> <b>€<%=sum%></b> </span>
	  	</div>
	  	<form action="CompletaOrdine" method="POST">
	  	<div> Seleziona metodo di pagamento: </div>
	  		<div id="payment">		  			
	  			<div class="payments-sons"> 
	  				<input type="radio" name="pagamento" value="poste-pay" checked="checked"> 
	  				<img src="images/postepay.png" alt="poste-pay">
	  			</div>
	  			<div class="payments-sons"> 
	  				<input type="radio" name="pagamento" value="visa"> 
	  				<img src="images/visa.png" alt="visa">
	  			</div>
	  		</div>
	  		<input type="submit" id="submit" value="EFFETTUA ORDINE">
	   </form>
	  </div>
</body>
</html>