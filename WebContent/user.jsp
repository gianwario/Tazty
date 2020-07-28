
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>

<!doctype html>
<html>

<head>
<title>User</title>
<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=Balsamiq+Sans:wght@400;700&display=swap"
	rel="stylesheet">
<script src="js/backtotop.js"></script>
<link rel="stylesheet" href="css/user.style/admin.css" type="text/css">
<link rel="stylesheet" href="css/user.style/user.css" type="text/css">
<link rel="stylesheet" href="css/mainpage.style/main.css"
	type="text/css">
<link rel="stylesheet" href="css/mainpage.style/navbar.css"
	type="text/css">
<link rel="stylesheet" href="css/mainpage.style/backtotop.css"
	type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Pangolin&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&display=swap"
	rel="stylesheet">
<script>
	function hideandshow(elementID) {
		var x = document.getElementById(elementID);
		if (x.style.display == 'none') {
			x.style.display = 'block';
		} else {
			x.style.display = 'none';
		}
		window.scrollTo(0, document.body.scrollHeight);
	}

</script>
</head>
<body onscroll="scrollFunction();">

	<%
			 UserBean u = (UserBean)request.getSession().getAttribute("utente"); 	
			if(u==null){
				
			 		out.println("<script type=\"text/javascript\">");
			 		out.println("alert('Errore. Effettuare il login');");
			 		out.println("window.location.href = \"login.html\";");
				 	out.println("</script>");
				} else {
			%>

	<div id="container">

		<div class="column_left">
			<div id="home_redirect">
				<a href=<%= response.encodeURL("index.jsp")%> title="Ritorna alla home"> <img
					src="images/logo2.png" alt="Torna alla home" width="40%">
				</a>
			</div>
			<div class="info_admin">
				<h1 class="utente">Benvenuto</h1>
				<%
					if (u != null) {
					out.println("<p class='info'>" + u.getNome() + " " + u.getCognome() + "</p>");
				}
				%>
			</div>
		</div>


		<div class="column_right">
			<div class="titlecontainer">
				<div class="title">I tuoi ordini</div>
			</div>
			<%
				ArrayList<OrdineBean> ordin = (ArrayList<OrdineBean>) request.getAttribute("ordini");
				
			for (OrdineBean o : ordin) {
				double totOrdine = o.getTotale();
			%>
			<table id="ordini_tab">
				<thead>
					<tr>

						<th>N. Ordine</th>
						<th><%=o.getCod_ordine()%></th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				<%
					ArrayList<ProductBean> prod = (ArrayList<ProductBean>) o.getProductList();
				double sum = 5;
				for (ProductBean p : prod) {
					sum+=p.getPrezzo();
				%>
				
					<tr>
						<td><strong>Nome prodotto</strong></td>
						<td><%=p.getNome()%></td>
						<td><strong>Prezzo prodotto</strong></td>
						<td><%=p.getPrezzo()%></td>
					</tr>
					<%}
					if(sum!=totOrdine){
					%>
					<tr>
						<td><strong>Prodotti personalizzati</strong></td>
						<td> </td>
						<td><strong>Prezzo</strong></td>
						<td>--</td>
					</tr>
					<%} %>
					<tr>
						<th class="vuoto"></th>
						<th class="vuoto"></th>
						<th class="totale">Totale ordine</th>
						<th class="totale"><%=o.getTotale()%></th>
					</tr>
				</tbody>
				<%}%>
			</table>
			</div>

		</div>

				<button onclick="topFunction()" id="myBtn" title="Torna su">
					<i class="fa fa-chevron-up"></i>
				</button>
	<% } %>
</body>
</html>