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
<link rel="stylesheet" href="css/mainpage.style/footer.css"
	type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body style="margin-left: 0px; margin-top: 0px; margin-right: 0px; 
	margin-bottom: 0px; font-family: 'Balsamiq Sans', cursive; 
	background-color:#f6f6f6;">
	
	<div id="instruction_container">	
		
		<div id="pic_container">								
			<div class="title"> Componi qui il tuo panino</div>
			<div class="subtitle"> Visita anche il nostro <a href="https://www.youtube.com/watch?v=FzG4uDgje3M" target="blank" id="menu">menù</a>!</div>
		</div>	
		<a href="index.jsp"> <img src="images/logo.png" id="logo"></a>
		
		<div id="icons_container">
			
			<div class="image_box"> 
				<div class="titles"> 1 <span class="steps"> Scegli il tipo di pane</span></div>
				<img src="images/image0.png" onmouseover="this.src='images/image7.png';" 
					onmouseout="this.src='images/image0.png';"/>
			</div>
			
			<div class="image_box">
				<div class="titles"> 2 <span class="steps"> Scegli la carne</span></div>
				<img src="images/image3.png" onmouseover="this.src='images/image5.png';" 
					onmouseout="this.src='images/image3.png';"/> 
			</div>
			
			<div class="image_box">
				<div class="titles"> 3 <span class="steps"> Aggiungi altri ingredienti</span></div>
				<img src="images/image2.png" onmouseover="this.src='images/image6.png';" 
					onmouseout="this.src='images/image2.png';"/> 
			</div>
			
			<div class="image_box"> 
				<div class="titles"> 4 <span class="steps"> Aggiungi le salse</span></div>
				<img src="images/image1.png" onmouseover="this.src='images/image4.png';" 
					onmouseout="this.src='images/image1.png';"/> 
			</div>
			
		 </div>
		 
	</div>
	
	<div id="container">
		<div id="panino_container">
		</div>
		<div id="selection_container">
			<fieldset style="width: 90%;">
				<legend class="legends">1. Pane</legend>
				 <div class="ingredient_container">
					<select class="ing_select" id="bread-select" onchange="breadChange(this)">
					<% ArrayList<IngredientBean> pani = (ArrayList<IngredientBean>)request.getAttribute("pane"); %>
						<option value="" disabled selected>Seleziona</option>
						<%for(IngredientBean ib : pani) { %>
						<option value=<%=ib.getPrezzo()%>> <%=ib.getNome()%></option>
						<% }%>
					</select> 
					<div id="bread-price" class="price-container">
						--
					</div>
				</div>
			</fieldset>
			
			<fieldset style="width: 90%">
				<legend class="legends">2. Carne</legend>
				<div class="ingredient_container">
					<select class="ing_select" id="meat-select" onchange="meatChange(this)">
					<% ArrayList<IngredientBean> carni = (ArrayList<IngredientBean>)request.getAttribute("carne"); %>
						<option value="" disabled selected>Seleziona</option>
						<%for(IngredientBean ib : carni) { %>
						<option value=<%=ib.getPrezzo()%>> <%=ib.getNome()%></option>
						<% }%>						
					</select>
					<div id="meat-price" class="price-container">
						--
					</div>
				</div>
			</fieldset>
			<fieldset style="width: 90%">
				<legend class="legends">3. Contorni</legend>
				<div class="ingredient_container">
					<select class="ing_select" id="add-select1" onchange="addChange(this)">
						<option value="0" selected>Seleziona</option>
						<% ArrayList<IngredientBean> adds = (ArrayList<IngredientBean>)request.getAttribute("condimento"); %>
						<%for(IngredientBean ib : adds) { %>
						<option value=<%=ib.getPrezzo()%>> <%=ib.getNome()%></option>
						<% }%>	
					</select>
					
					<select class="ing_select" id="add-select2" onchange="addChange(this)" style="margin-left: 20px">
						<option value="0" selected>Seleziona</option>
						<% ArrayList<IngredientBean> adds2 = (ArrayList<IngredientBean>)request.getAttribute("condimento"); %>
						<%for(IngredientBean ib : adds2) { %>
						<option value=<%=ib.getPrezzo()%>> <%=ib.getNome()%></option>
						<% }%>
					</select>
					
					<div id="add-price" class="price-container" style="margin-left: 2%">
						--
					</div>
				</div>
			</fieldset>
			<fieldset style="width: 90%">
				<legend class="legends">4. Salse</legend>
				<div class="ingredient_container">
					<select class="ing_select" id="sauce-select" onchange="sauceChange(this)">
						<option value="0" selected>Seleziona</option>
						<% ArrayList<IngredientBean> salse = (ArrayList<IngredientBean>)request.getAttribute("salsa"); %>
						<%for(IngredientBean ib : salse) { %>
						<option value=<%=ib.getPrezzo()%>> <%=ib.getNome()%></option>
						<% }%>	
					</select>
					<div id="sauce-price" class="price-container">
						--
					</div>
				</div>
			</fieldset>
		</div>	
	</div>
	<div id="price_container">
		
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
		
		
	
	<script>
		function breadChange(selectObject) {
			 
			$('#bread-price').text("€" + selectObject.value);
		}
		
		function meatChange(selectObject) {
			 
			$('#meat-price').text("€" + selectObject.value);
		}
		
		function addChange(selectObject) {
			
			var e1 = document.getElementById("add-select1");
			var e2 = document.getElementById("add-select2");
			var p1 = parseFloat(e1.options[e1.selectedIndex].value);
			var p2 = parseFloat(e2.options[e2.selectedIndex].value);
			var sum = p1+p2+0;
			$('#add-price').text("€" + sum);
		}
		
		function sauceChange(selectObject) {
			 
			$('#sauce-price').text("€" + selectObject.value);
		}
	</script>

</body>

</html>