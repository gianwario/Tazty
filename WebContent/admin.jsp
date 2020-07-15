
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>

<!doctype html>
<html>

<head>
	<title>Admin</title>
	<meta charset="UTF-8">
	<link href="https://fonts.googleapis.com/css2?family=Balsamiq+Sans:wght@400;700&display=swap" rel="stylesheet">
	<script src="js/slide.js"></script>
	<link rel="stylesheet" href="css/user.style/admin.css" type="text/css">
	<link rel="stylesheet" href="css/mainpage.style/main.css" type="text/css">
	<link rel="stylesheet" href="css/mainpage.style/navbar.css" type="text/css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/css2?family=Pangolin&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&display=swap" rel="stylesheet">
	<script>
	  function hideandshow(elementID) {
			    var x = document.getElementById(elementID);
			    if (x.style.display == 'none') {
			        x.style.display = 'block';
			    } else {
			        x.style.display = 'none';
			    }
			    window.scrollTo(0,document.body.scrollHeight);
		  }
	  function redirect()
	  {
		  <%
		  UserBean u = (UserBean)request.getSession().getAttribute("utente"); 	
			if(request.getSession().getAttribute("utente")==null){
		  
		  %>window.location.href="index.jsp";
		  <%}%>
	  }
	  
	</script>
</head>
<body onload="redirect()">

			<%
			if(u!=null&&u.getIsadmin() !=1)
		 	{	
		 		out.println("<script type=\"text/javascript\">");
		 		out.println("alert('Non sei un amministratore');");
		 		out.println("window.location.href = \"index.jsp\";");
			 	out.println("</script>");
			}
			%>
	
		<div id="container">
		
	  		<div class="column_left">
	  			<div id="home_redirect">
	  				<a href="index.jsp" title="Ritorna alla home">
	  					<img src="images/logo-scritta.png" alt="Torna alla home" width="40%">
	  				</a>
	  			</div>
	  			<div class="info_admin">
	  			<h1 class="utente">Benvenuto</h1>
	  			<%
	  			if(u!=null&&u.getIsadmin() ==1)
			 	{
	  				out.println("<p class='info'>"+u.getNome()+" "+u.getCognome()+"</p>");
			 	}
	  			%>
	  			</div>
  			</div>
	
  
  		<div class="column_right">
  			<div class="pulsante_container">
  				<button onclick="hideandshow('hidden_element_panino')" class="pulsante">Aggiungi Panino</button>
  				<button onclick="hideandshow('hidden_element_bibita')" class="pulsante">Aggiungi Birra</button>
  				<button onclick="hideandshow('hidden_element_stuzzicheria')" class="pulsante">Aggiungi Stuzzicheria</button>
  			</div>
    		<fieldset id="hidden_element_panino" style="display:none">
  				<legend>Aggiungi panino al menu</legend>
  				<form class="form" action="AddPanino" method="POST">
       				<div class="inputfield">
          				<label>Nome</label>
          				<input type="text" class="input" name="nome" id="nome" required>
       				</div> 
       
       				<div class="inputfield">
          				<label>Descrizione</label>
          				<textarea class="input" name="descrizione" id="descrizione" required></textarea>
       				</div>
       				
       				<div class="inputfield">
          				<label>Prezzo</label>
          				<input type="number" class="input" name="prezzo" id="prezzo" required>
       				</div>
       				
       				<div class="inputfield">
          				<label>Tipo pane</label>
						<select class="custom_select" name="tipo_pane" id="tipo_pane">
  							<option value="Classico">Classico</option>
  							<option value="Integrale">Integrale</option>
						</select> 
       				</div>
       				
       				<div class="inputfield">
        				<input type="submit" value="invia" class="pulsante" >
     	 			</div>
       			</form>
			</fieldset>
			
			<fieldset id="hidden_element_bibita" style="display:none">
  				<legend>Aggiungi birra al menu</legend>
  				<form class="form" action="AddBirra" method="POST">
       				<div class="inputfield">
          				<label>Nome</label>
          				<input type="text" class="input" name="nome" id="nome" required>
       				</div> 
       
       				<div class="inputfield">
          				<label>Descrizione</label>
          				<textarea class="input" name="descrizione" id="descrizione" required></textarea>
       				</div>
       				
       				<div class="inputfield">
          				<label>Prezzo</label>
          				<input type="number" class="input" name="prezzo" id="prezzo" required>
       				</div>
       				
       				<div class="inputfield">
          				<label>Gradi</label>
          				<input type="number" class="input" name="gradi" id="gradi" required>
       				</div>
       				
       				<div class="inputfield">
          				<label>Colore</label>
						<select class="custom_select" name="colore" id="colore">
  							<option value="chiare">Chiare</option>
  							<option value="rosse">Rosse</option>
  							<option value="scure">Scure</option>
						</select> 
       				</div>
       				
       				<div class="inputfield">
        				<input type="submit" value="invia" class="pulsante" >
     	 			</div>
       			</form>
			</fieldset>
			
			<fieldset id="hidden_element_stuzzicheria" style="display:none">
  				<legend>Aggiungi stuzzicherie al menu</legend>
  				<form class="form" action="AddStuzzicheria" method="POST">
       				<div class="inputfield">
          				<label>Nome</label>
          				<input type="text" class="input" name="nome" id="nome" required>
       				</div> 
       
       				<div class="inputfield">
          				<label>Descrizione</label>
          				<textarea class="input" name="descrizione" id="descrizione" required></textarea>
       				</div>
       				
       				<div class="inputfield">
          				<label>Prezzo</label>
          				<input type="number" class="input" name="prezzo" id="prezzo" required>
       				</div>
       				
       				<div class="inputfield">
          				<label>Tipo</label>
						<select class="custom_select" name="tipo" id="tipo">
  							<option value="antipasto">Antipasto</option>
  							<option value="aperitivo">Aperitivo</option>
  							<option value="sfizi">Sfizi</option>
						</select> 
       				</div>
       				
       				<div class="inputfield">
        				<input type="submit" value="invia" class="pulsante" >
     	 			</div>
       			</form>
			</fieldset>
  		</div>
  	
  	</div>

</body>
</html>