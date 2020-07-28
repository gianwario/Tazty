<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>
<!doctype html>
<html>

<head>
<title>Gallery</title>
<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=Balsamiq+Sans:wght@400;700&display=swap"
	rel="stylesheet">
<script src="js/backtotop.js"></script>
<script src="js/slide.js"></script>
<link rel="stylesheet" href="css/mainpage.style/main.css"
	type="text/css">
<link rel="stylesheet" href="css/mainpage.style/gallery.css"
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
</head>
<body
	style="margin-left: 0px; margin-top: 0px; margin-right: 0px; margin-bottom: 0px; font-family: 'Balsamiq Sans', cursive;"
	onload="slide(); newsLoading();" onscroll="scrollFunction();">


	<div id="navbar">
		<div id="texts_box">
			<a class="nav-a" href=<%= response.encodeURL("index.jsp")%>>Home</a> <a class="nav-a" href=<%= response.encodeURL("index.jsp#news")%>>News</a>
			<a class="nav-a" href=<%= response.encodeURL("index.jsp#contact")%>>Contacts</a> <a class="nav-a"
				href=<%= response.encodeURL("gallery.jsp")%>>Gallery</a>
		</div>
		<div class="dropdown">
			<button onclick="myFunction()" class="dropbtn">
				<span class="fa fa-user" id="user-icon"></span> <span id="user-text">Area
					utente</span> <span class="fa fa-caret-down"
					style="font-size: 30px; padding-top: 2%;"></span>
			</button>
			<div id="myDropdown" class="dropdown-content">
				<%
					if (request.getSession().getAttribute("utente") == null) {
				%>
				<a href="login.html">Login</a> <a href="register.html">Registrati</a> <a href=<%= response.encodeURL("cart.jsp")%>>Carrello</a>
				<%
					} else {
					UserBean u = (UserBean) request.getSession().getAttribute("utente");
				%>
				<a id="logout" href="Logout">Logout</a> <a href=<%= response.encodeURL("User?username="+u.getUsername())%>>Profilo</a> <a href=<%= response.encodeURL("cart.jsp")%>>Carrello</a>
				<%
					if (u.getIsadmin() == 1) {
				%>
				<a href=<%= response.encodeURL("admin.jsp")%>>Pagina Admin</a>
				<%
					}
				}
				%>
			</div>
		</div>
		
		<div class="dropdown2">
		
  			<button onclick="myFunction2()" class="dropbtn2">
  				<span class="fa fa-bars" aria-hidden="true"></span>
  			</button>
  	
  			<div id="myDropdown2" class="dropdown-content2">
    			<a href="#">Home</a>
    			<a href="#news">News</a>
   				<a href="#contact">Contacts</a>
   				<a href=<%= response.encodeURL("gallery.jsp")%>> Gallery</a>
  			</div>
		</div>
		
	</div>



	<div class="gallery-div">
		<div id="titlecontainer">
			<div id="title">Gallery</div>
		</div>
		<p>Vieni a scoprire le nostre creazioni piú belle!</p>


		<div class="grid-container">

			<article class="article-box">
				<a class="article-title" href="#">American Burger</a>
				<div class="article-image">
					<a href="#"> <img
						src="images/Gallery/Panini/americanburger.jpg"
						alt="American Burger"> `
					</a>
				</div>
			</article>

			<article class="article-box">
				<a class="article-title" href="#">Suicide Burger</a>
				<div class="article-image">
					<a href="#"> <img src="images/Gallery/Panini/suicideburger.jpg"
						alt="Suicide Burger">
					</a>
				</div>
			</article>

			<article class="article-box">
				<a class="article-title" href="#">Il gigante</a>
				<div class="article-image">
					<a href="#"> <img src="images/Gallery/Panini/ilgigante.jpg"
						alt="Il Gigante">
					</a>
				</div>
			</article>

			<article class="article-box">
				<a class="article-title" href="#">Rotolo Burger</a>
				<div class="article-image">
					<a href="#"> <img src="images/Gallery/Panini/rotoloburger.jpg"
						alt="Rotolo Burger">
					</a>
				</div>
			</article>

			<article class="article-box">
				<a class="article-title" href="#">Nerano Burger</a>
				<div class="article-image">
					<a href="#"> <img src="images/Gallery/Panini/neranoburger.jpg"
						alt="Nerano Burger">
					</a>
				</div>
			</article>

			<article class="article-box">
				<a class="article-title" href="#">Chips</a>
				<div class="article-image">
					<a href="#"> <img src="images/Gallery/Panini/chips.jpg"
						alt="Chips">
					</a>
				</div>
			</article>

			<article class="article-box">
				<a class="article-title" href="#">Burrata</a>
				<div class="article-image">
					<a href="#"> <img src="images/Gallery/Panini/burrata.jpg"
						alt="Burrata">
					</a>
				</div>
			</article>

			<article class="article-box">
				<a class="article-title" href="#">Crispy Burger</a>
				<div class="article-image">
					<a href="#"> <img src="images/Gallery/Panini/crispyburger.jpg"
						alt="Crispy Burger">
					</a>
				</div>
			</article>

			<article class="article-box">
				<a class="article-title" href="#">Crocche Cheddar e Pistacchio</a>
				<div class="article-image">
					<a href="#"> <img
						src="images/Gallery/Panini/crocchecheddarepistacchio.jpg"
						alt="Crocche Cheddar & Pistacchio">
					</a>
				</div>
			</article>

			<article class="article-box">
				<a class="article-title" href="#">Hamburgher Gluten Free</a>
				<div class="article-image">
					<a href="#"> <img
						src="images/Gallery/Panini/hamburgerglutenfree.jpg"
						alt="Hamburgher Gluten Free">
					</a>
				</div>
			</article>

			<article class="article-box">
				<a class="article-title" href="#">Burro Burger</a>
				<div class="article-image">
					<a href="#"> <img src="images/Gallery/Panini/burroburger.jpg"
						alt="Burro Burger">
					</a>
				</div>
			</article>

			<article class="article-box">
				<a class="article-title" href="#">Frittatina Pistacchio</a>
				<div class="article-image">
					<a href="#"> <img
						src="images/Gallery/Panini/fittatinapistacchio.jpg"
						alt="Frittatina Pistacchio">
					</a>
				</div>
			</article>

			<article class="article-box">
				<a class="article-title" href="#">Lasagna Fritta</a>
				<div class="article-image">
					<a href="#"> <img src="images/Gallery/Panini/lasagnafritta.jpg"
						alt="Lasagna Fritta">
					</a>
				</div>
			</article>

			<article class="article-box">
				<a class="article-title" href="#">Pavone Burger</a>
				<div class="article-image">
					<a href="#"> <img src="images/Gallery/Panini/pavoneburger.jpg"
						alt="Pavone Burger">
					</a>
				</div>
			</article>

			<article class="article-box">
				<a class="article-title" href="#">Pistacchio Burger</a>
				<div class="article-image">
					<a href="#"> <img
						src="images/Gallery/Panini/pistacchioburger.jpg"
						alt="Pistacchio Burger">
					</a>
				</div>
			</article>
		</div>
		<!-- end grid container -->
	</div>

	<div class="gallery-div">
		<div id="titlecontainer2">
			<div id="title">Birre</div>
		</div>
		<p>Scopri anche le nostre birre artigianali piú gustose!</p>

		<div class="grid-container">

			<article class="article-box">
				<a class="article-title" href="#">Birra Artigianale</a>
				<div class="article-image">
					<a href="#"> <img
						src="images/Gallery/Birre/Birraartigianale.jpg"
						alt="Birra Artigianale">
					</a>
				</div>
			</article>

			<article class="article-box">
				<a class="article-title" href="#">Birra Chiara Rossa Scura</a>
				<div class="article-image">
					<a href="#"> <img src="images/Gallery/Birre/birra2.jpg"
						alt="Birra  Chiara Rossa Scura">
					</a>
				</div>
			</article>

			<article class="article-box">
				<a class="article-title" href="#">Birra GB</a>
				<div class="article-image">
					<a href="#"> <img src="images/Gallery/Birre/birra3.jpg"
						alt="Birra GB">
					</a>
				</div>
			</article>

			<article class="article-box">
				<a class="article-title" href="#">Birra Nygarda</a>
				<div class="article-image">
					<a href="#"> <img src="images/Gallery/Birre/birra4.jpg"
						alt="Birra Nygarda">
					</a>
				</div>
			</article>

			<article class="article-box">
				<a class="article-title" href="#">Birra Brewdog</a>
				<div class="article-image">
					<a href="#"> <img src="images/Gallery/Birre/birra5.jpg"
						alt="Birra Brewdog">
					</a>
				</div>
			</article>

		</div>
		<!-- end grid container -->
	</div>
	
		<!-- FOOTER -->
	<%@include file="footer.jsp" %>
	
	
	<button onclick="topFunction()" id="myBtn" title="Torna su">
		<i class="fa fa-chevron-up"></i>
	</button>
</body>
</html>