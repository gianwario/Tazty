
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
	onload="slide(); newsLoading();" onscroll="scrollFunction();">


	<div id="navbar">
		<div id="texts_box">
			<a class="nav-a" href="#">Home</a> <a class="nav-a" href="#news">News</a>
			<a class="nav-a" href="#contact">Contacts</a> <a class="nav-a"
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
					<a href=<%= response.encodeURL("Menu")%> style="text-decoration: none"
						class="button-slide-menu">Menu</a>
				</div>
				<div class="div-button-slide-componi">
					<a href=<%= response.encodeURL("Composition")%> style="text-decoration: none"
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
				<a class="project">
					<figure>
						<div id="pic1">
						<img src="images/news_blank.png" alt="Notizia 1"></div>
						<figcaption>
							<div>
								<h3 id="news-name1">--</h3>
								<p class="desc_news" id="news-body1">body</p>
							</div>
						</figcaption>
					</figure>
				</a> <a class="project">
					<figure>
					<div id="pic2">
						<img src="images/news_blank.png" alt="Notizia 2"></div>
						<figcaption>
							<div>
								<h3 id="news-name2">--</h3>
								<p class="desc_news" id="news-body2">body</p>
							</div>
						</figcaption>
					</figure>
				</a> <a class="project">
					<figure>
					<div id="pic3">
						<img src="images/news_blank.png" alt="Notizia 3"></div>
						<figcaption>
							<div>
								<h3 id="news-name3">--</h3>
								<p class="desc_news" id="news-body3">body</p>
							</div>
						</figcaption>
					</figure>
				</a> <a class="project">
					<figure>
					<div id="pic4">
						<img src="images/news_blank.png" alt="Notizia 4"></div>
						<figcaption>
							<div>
								<h3 id="news-name4">--</h3>
								<p class="desc_news" id="news-body4">body</p>
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
							<i class="fa fa-map-marker"> </i> Somma Vesuviana, Via Milano 23(NA)
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
	<%@include file="footer.jsp" %>




	<button onclick="topFunction()" id="myBtn" title="Torna su">
		<i class="fa fa-chevron-up"></i>
	</button>
	
<script>

	function myFunction2() {
  	document.getElementById("myDropdown2").classList.toggle("show");
	}

	window.onclick = function(event) {
 		if (!event.target.matches('.dropbtn2')) {
   			var dropdowns = document.getElementsByClassName("dropdown-content2");
    		var i;
    		for (i = 0; i < dropdowns.length; i++) {
      			var openDropdown = dropdowns[i];
      			if (openDropdown.classList.contains('show')) {
        			openDropdown.classList.remove('show');
      			}
    		}
  		}
	}
</script>

<script> 
	function newsLoading() {		
		var xmlHttpReq = new XMLHttpRequest();
		
		xmlHttpReq.responseType = 'json';
		xmlHttpReq.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				
				var titles = [ document.getElementById('news-name1'), document.getElementById('news-name2'),
					document.getElementById('news-name3'), document.getElementById('news-name4')];
				var bodies = [ document.getElementById('news-body1'), document.getElementById('news-body2'),
					document.getElementById('news-body3'), document.getElementById('news-body4')];
				var pics = [ document.getElementById('pic1'), document.getElementById('pic2'),
					document.getElementById('pic3'), document.getElementById('pic4')];
				for(var i = 0; i<4; i++) {
					
					titles[i].innerHTML = this.response[i].titolo;
					bodies[i].innerHTML = "Da:  " + this.response[i].username + " alle: " +
						this.response[i].dataora + "<br>" + this.response[i].corpo;
					pics[i].innerHTML = '<img src="data:image/jpg;base64,' + this.response[i].foto + '">'
				}
			}
		}
		
		xmlHttpReq.open("GET", "News", true);
		xmlHttpReq.send();
	}
</script>
	

</body>
</html>
