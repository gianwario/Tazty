<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>
<!doctype HTML>
<html>

<head>
<meta charset="UTF-8">
<title>Tazty</title>
<link rel="stylesheet" href="css/composition.style/selection.css"
	type="text/css">
<link rel="stylesheet" href="css/composition.style/instructions.css"
	type="text/css">
<link rel="stylesheet" href="css/composition.style/panino-pics.css"
	type="text/css">
<link rel="stylesheet" href="css/mainpage.style/footer.css"
	type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body
	style="margin-left: 0px; margin-top: 0px; margin-right: 0px; margin-bottom: 0px; font-family: 'Balsamiq Sans', cursive; background-color: #f6f6f6;">

	<div id="instruction_container">

		<div id="pic_container">
			<div class="title">Componi qui il tuo panino</div>
			<div class="subtitle">
				Visita anche il nostro <a
					href="https://www.youtube.com/watch?v=FzG4uDgje3M" target="blank"
					id="menu">menù</a>!
			</div>
		</div>
		<a href="index.jsp"> <img src="images/logo.png" id="logo"></a>

		<div id="icons_container">

			<div class="image_box">
				<div class="titles">
					1 <span class="steps"> Scegli il tipo di pane</span>
				</div>
				<img src="images/image0.png"
					onmouseover="this.src='images/image7.png';"
					onmouseout="this.src='images/image0.png';" />
			</div>

			<div class="image_box">
				<div class="titles">
					2 <span class="steps"> Scegli la carne</span>
				</div>
				<img src="images/image3.png"
					onmouseover="this.src='images/image5.png';"
					onmouseout="this.src='images/image3.png';" />
			</div>

			<div class="image_box">
				<div class="titles">
					3 <span class="steps"> Aggiungi altri ingredienti</span>
				</div>
				<img src="images/image2.png"
					onmouseover="this.src='images/image6.png';"
					onmouseout="this.src='images/image2.png';" />
			</div>

			<div class="image_box">
				<div class="titles">
					4 <span class="steps"> Aggiungi le salse</span>
				</div>
				<img src="images/image1.png"
					onmouseover="this.src='images/image4.png';"
					onmouseout="this.src='images/image1.png';" />
			</div>

		</div>

	</div>
	<form action="CarrelloCustom" method="POST" onSubmit="return fieldCheck()">
	<div id="container">
		<div id="panino_container">
			<div class="panino_pics" id="pane-top-pic"></div>
			<div class="panino_pics" id="salsa-pic"></div>
			<div class="panino_pics" id="add1-pic"></div>
			<div class="panino_pics" id="add2-pic"></div>
			<div class="panino_pics" id="carne-pic"></div>
			<div class="panino_pics" id="pane-bottom-pic"></div>
		</div>
		
		<div id="selection_container">
			
				<fieldset style="width: 90%;">
					<legend class="legends">1. Pane</legend>
					<div class="ingredient_container">
						<select class="ing_select" id="bread-select" name="pane"
							onchange="breadChange(this); breadComposer()">
							<%
								ArrayList<IngredientBean> pani = (ArrayList<IngredientBean>) request.getAttribute("pane");
							%>
							<option value="0" disabled selected>Seleziona</option>
							<%
								for (IngredientBean ib : pani) {
							%>
							<option value=<%=ib.getPrezzo()%>>
								<%=ib.getNome()%></option>
							<%
								}
							%>
						</select>
						<div id="bread-price" class="price-container">--</div>
					</div>
				</fieldset>

				<fieldset style="width: 90%">
					<legend class="legends">2. Carne</legend>
					<div class="ingredient_container">
						<select class="ing_select" id="meat-select" name="carne"
							onchange="meatChange(this); meatComposer()">
							<%
								ArrayList<IngredientBean> carni = (ArrayList<IngredientBean>) request.getAttribute("carne");
							%>
							<option value="0" disabled selected>Seleziona</option>
							<%
								for (IngredientBean ib : carni) {
							%>
							<option value=<%=ib.getPrezzo()%>>
								<%=ib.getNome()%></option>
							<%
								}
							%>
						</select>
						<div id="meat-price" class="price-container">--</div>
					</div>
				</fieldset>
				<fieldset style="width: 90%">
					<legend class="legends">3. Contorni</legend>
					<div class="ingredient_container">
						<select class="ing_select" id="add-select1" name="add1"
							onchange="addChange(this); add1Composer()">
							<option value="0" selected>Seleziona</option>
							<%
								ArrayList<IngredientBean> adds = (ArrayList<IngredientBean>) request.getAttribute("condimento");
							%>
							<%
								for (IngredientBean ib : adds) {
							%>
							<option value=<%=ib.getPrezzo()%>>
								<%=ib.getNome()%></option>
							<%
								}
							%>
						</select> <select class="ing_select" id="add-select2"
							onchange="addChange(this); add2Composer()" name="add2"
							style="margin-left: 20px">
							<option value="0" selected>Seleziona</option>
							<%
								ArrayList<IngredientBean> adds2 = (ArrayList<IngredientBean>) request.getAttribute("condimento");
							%>
							<%
								for (IngredientBean ib : adds2) {
							%>
							<option value=<%=ib.getPrezzo()%>>
								<%=ib.getNome()%></option>
							<%
								}
							%>
						</select>

						<div id="add-price" class="price-container"
							style="margin-left: 2%">--</div>
					</div>
				</fieldset>
				<fieldset style="width: 90%">
					<legend class="legends">4. Salse</legend>
					<div class="ingredient_container">
						<select class="ing_select" id="sauce-select" name="salse"
							onchange="sauceChange(this); sauceComposer()">
							<option value="0" selected>Seleziona</option>
							<%
								ArrayList<IngredientBean> salse = (ArrayList<IngredientBean>) request.getAttribute("salsa");
							%>
							<%
								for (IngredientBean ib : salse) {
							%>
							<option value=<%=ib.getPrezzo()%>>
								<%=ib.getNome()%></option>
							<%
								}
							%>
						</select>
						<div id="sauce-price" class="price-container">--</div>
					</div>
				</fieldset>
			
		</div>
	</div>
	<div id="price_container">
		<div id="totale">Totale:</div>
		<div id="total-price">--</div>
	</div>
	<button type="submit" id="confirm">
		<i class="fa fa-shopping-cart" aria-hidden="true"
			style="margin-right: 10px;"></i>Aggiungi al carrello
	</button></form>
	
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



	<script>
		function breadChange(selectObject) {

			$('#bread-price').text("€" + selectObject.value);
			totalCount();
		}

		function meatChange(selectObject) {

			$('#meat-price').text("€" + selectObject.value);
			totalCount();
		}

		function addChange(selectObject) {

			var e1 = document.getElementById("add-select1");
			var e2 = document.getElementById("add-select2");
			var p1 = parseFloat(e1.options[e1.selectedIndex].value);
			var p2 = parseFloat(e2.options[e2.selectedIndex].value);
			var sum = p1 + p2 + 0;
			$('#add-price').text("€" + sum);
			totalCount();
		}

		function sauceChange(selectObject) {

			$('#sauce-price').text("€" + selectObject.value);
			totalCount();
		}

		function totalCount() {

			var e1 = document.getElementById("sauce-select");
			var e2 = document.getElementById("meat-select");
			var e3 = document.getElementById("bread-select");
			var e4 = document.getElementById("add-select1");
			var e5 = document.getElementById("add-select2");
			var p1 = parseFloat(e1.options[e1.selectedIndex].value);
			var p2 = parseFloat(e2.options[e2.selectedIndex].value);
			var p3 = parseFloat(e3.options[e3.selectedIndex].value);
			var p4 = parseFloat(e4.options[e4.selectedIndex].value);
			var p5 = parseFloat(e5.options[e5.selectedIndex].value);
			var sum = p1 + p2 + p3 + p4 + p5 + 0;
			console.log(sum);
			$('#total-price').text("€" + sum);

		}

		function fieldCheck() {			
			
			var e1 = document.getElementById("bread-select");
			var e2 = document.getElementById("meat-select");			
			var p1 = parseFloat(e1.options[e1.selectedIndex].value);
			var p2 = parseFloat(e2.options[e2.selectedIndex].value);

			if (p1 == 0) {
				$('#bread-select').css("border", "2px solid red");
				return false;
			} else {
				$('#bread-select').css("border", "none");
				$('#bread-select').css("border-bottom", "3px solid #ffd801");
			}
			if (p2 == 0) { 
				$('#meat-select').css("border", "2px solid red");
				return false;
			} else {
				$('#meat-select').css("border", "none");
				$('#meat-select').css("border-bottom", "3px solid #ffd801");
			}			
			return true;			
		}

		function sauceComposer() {
			var e1 = document.getElementById("sauce-select");
			var p1 = (e1.options[e1.selectedIndex].text);
			var string = '<img src="images/composition-pic/' + p1 + '.PNG">';
			console.log(string);
			if (p1 == "Seleziona")
				$("#salsa-pic").html("");
			else
				$("#salsa-pic").html(string);
		}

		function meatComposer() {
			var e1 = document.getElementById("meat-select");
			var p1 = (e1.options[e1.selectedIndex].text);
			var string = '<img src="images/composition-pic/' + p1 + '.PNG">';
			console.log(string);
			if (p1 == "Seleziona")
				$("#carne-pic").html("");
			else
				$("#carne-pic").html(string);
		}

		function breadComposer() {
			var e1 = document.getElementById("bread-select");
			var p1 = (e1.options[e1.selectedIndex].text);
			var string1 = '<img src="images/composition-pic/' + p1 + '-top.PNG">';
			var string2 = '<img src="images/composition-pic/' + p1 + '-bottom.PNG">';
			console.log(string1);
			$("#pane-top-pic").html(string1);
			$("#pane-bottom-pic").html(string2);
		}

		function add1Composer() {
			var e1 = document.getElementById("add-select1");
			var p1 = (e1.options[e1.selectedIndex].text);
			var string = '<img src="images/composition-pic/' + p1 + '.PNG">';
			console.log(string);
			if (p1 == "Seleziona")
				$("#add1-pic").html("");
			else
				$("#add1-pic").html(string);
		}

		function add2Composer() {
			var e1 = document.getElementById("add-select2");
			var p1 = (e1.options[e1.selectedIndex].text);
			var string = '<img src="images/composition-pic/' + p1 + '.PNG">';
			console.log(string);
			if (p1 == "Seleziona")
				$("#add2-pic").html("");
			else
				$("#add2-pic").html(string);
		}
	</script>

</body>

</html>