
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>

<!doctype html>
<html>

<head>
<title>Tazty</title>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Balsamiq+Sans:wght@400;700&display=swap"
	rel="stylesheet">
<script src="js/slide.js"></script>
<script src="js/backtotop.js"></script>
<link rel="stylesheet" href="css/mainpage.style/slide.css"
	type="text/css">
<link rel="stylesheet" href="css/mainpage.style/main.css"
	type="text/css">
<link rel="stylesheet" href="css/mainpage.style/navbar.css"
	type="text/css">
<link rel="stylesheet" href="css/mainpage.style/news.css"
	type="text/css">
<link rel="stylesheet" href="css/mainpage.style/contacts.css"
	type="text/css">
<link rel="stylesheet" href="css/mainpage.style/footer.css"
	type="text/css">
	<link rel="stylesheet" href="css/mainpage.style/backtotop.css" type="text/css">
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
	onload="slide();" onscroll="scrollFunction();">


	<div id="navbar">
		<div id="texts_box">
			<a class="nav-a" href="#">Home</a> <a class="nav-a" href="#news">News</a>
			<a class="nav-a" href="#contact">Contacts</a> <a class="nav-a"
				href="gallery.jsp">Gallery</a>
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
				<a href="login.html">Login</a> <a href="register.html">Registrati</a>
				<%
					} else {
					UserBean u = (UserBean) request.getSession().getAttribute("utente");
				%>
				<a id="logout" href="Logout">Logout</a> <a href="#">Profilo</a>
				<%
					if (u.getIsadmin() == 1) {
				%>
				<a href="admin.jsp">Pagina Admin</a>
				<%
					}
				}
				%>
			</div>
		</div>
	</div>



	<div id="home">
		<div class="slideshow-container">
			<div class="mySlides fade">
				<img src="images/Slideshow/Slide1.jpg" style="width: 100%">
			</div>

			<div class="mySlides fade">
				<img src="images/Slideshow/Slide2.jpg" style="width: 100%">
			</div>

			<a class="prev" onclick="plusSlides(-1)">&#10094;</a> <a class="next"
				onclick="plusSlides(1)">&#10095;</a>
		</div>
		<div class="mainpanel">
			<img src="images/logo2.png">
			<div class="text">L'Hamburgeria dove sei tu lo Chef!</div>

			<div id="buttons-box">
				<div class="div-button-slide-menu">
					<a href="Menu" style="text-decoration: none"
						class="button-slide-menu">Menu</a>
				</div>
				<div class="div-button-slide-componi">
					<a href="Composition" style="text-decoration: none"
						class="button-slide-componi">Componi il tuo panino</a>
				</div>
			</div>
		</div>
	</div>


	<div id="news">
		<div id="titlecontainer">
			<div id="title">News</div>
		</div>
		<div class="news-wrapper">
			<div class="news-container">
				<a class="project" href="#">
					<figure>
						<img src="images/01.jpg" alt="Spain building">
						<figcaption>
							<div>
								<h3>The City</h3>
								<p class="desc_news">View project</p>
							</div>
						</figcaption>
					</figure>
				</a> <a class="project" href="#">
					<figure>
						<img src="images/02.jpg" alt="a Kiwi, lime, pear"
							title="Juicy Fruit">
						<figcaption>
							<div>
								<h3>Juicy Fruit</h3>
								<p class="desc_news">View project</p>
							</div>
						</figcaption>
					</figure>
				</a> <a class="project" href="#">
					<figure>
						<img src="images/04.jpg" alt="Yellow roller coaster track"
							title="Roller Track">
						<figcaption>
							<div>
								<h3>Roller Track</h3>
								<p class="desc_news">View project</p>
							</div>
						</figcaption>
					</figure>
				</a> <a class="project" href="#">
					<figure>
						<img src="images/05.jpg" alt="Yellow play balls" title="Yellow">
						<figcaption>
							<div>
								<h3>Yellow</h3>
								<p class="desc_news">View project</p>
							</div>
						</figcaption>
					</figure>
				</a>
			</div>
		</div>
	</div>

	<div id="contact">
		<div id="titlecontainer">
			<div id="title">Contacts</div>
		</div>
		<div class="box">
			<div class="box_sx">
				<div class="innerbox_dx">
					<h2>Informazioni</h2>
					<p class="info">Per qualsiasi informazione, siamo reperibili ai
						seguenti recapiti:</p>
					<div class="contact">
						<p class="strong">
							<i class="fa fa-phone"> </i> +39 331 872 9868
						</p>
						<p class="strong">
							<i class="fa fa-envelope-o"> </i> v.pentangelo4@studenti.unisa.it
						</p>
						<p class="strong">
							<i class="fa fa-map-marker"> </i> Somma Vesuviana, bocca del
							vesuvio (NA)
						</p>
					</div>
					<h2>Orari</h2>
					<p class="info">
						<b>Lunedi - Venerdi</b> 17:00 - 00:00
					</p>
					<p class="info">
						<b>Sabato</b> 18:00 - 02:00
					</p>
					<p class="info">
						<b>Domenica</b> 12:00 - 15:00 18:00 - 00:00
					</p>
				</div>
			</div>
			<div class="box_dx">
				<div id="google-maps">
					<iframe
						src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d6625.405687820863!2d14.40151002901647!3d40.89585125930813!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x133bafb0d7a5f879%3A0x950861277aca3f18!2s80049%20Somma%20Vesuviana%20NA!5e0!3m2!1sit!2sit!4v1593024221562!5m2!1sit!2sit"
						style="border: 0;" allowfullscreen></iframe>
				</div>
			</div>
		</div>
	</div>


	<!-- FOOTER -->
	<div class="footer">
		<div class="iconsbox">
			<a href="https://www.facebook.com/dinfunisa" target="_blank"> <span
				class="fa fa-facebook"> </span>
			</a> <a href="https://www.instagram.com/dinfunisa/" target="_blank">
				<span class="fa fa-instagram"> </span>
			</a> <a href="https://www.youtube.com/watch?v=Ds6sDzuCqbQ"
				target="_blank"> <span class="fa fa-youtube"> </span>
			</a>
		</div>
		<div id="names_box">
			<div id="mark">Tazty&copy;</div>
			<div class="names">
				Alessio Casolaro<br> Viviana Pentangelo <br> Gianmario
				Voria
			</div>
		</div>

	</div>




	<button onclick="topFunction()" id="myBtn" title="Torna su">
		<i class="fa fa-chevron-up"></i>
	</button>

</body>
</html>
