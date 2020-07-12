function formValidation() {
	var password = document.registration.password;
	var email = document.registration.email;
	
	var uname = document.registration.username;
	var uadd = document.registration.address;
	var ucountry = document.registration.country;
	var uzip = document.registration.zip;
	
	var umsex = document.registration.msex;
	var ufsex = document.registration.fsex;
	if(password_validation(password)&&email_validation(email)) 
	{
		return true;
	}
	return false;
}

function password_validation(password) {
	var passpattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[#$^+=!*()@%&]).{8,}$/;
	if (!password.value.match(passpattern)) {
		password.focus();
		$("#password").val('');
		$("#password").attr('placeholder','Almeno 1 carattere maiuscolo,1 minuscolo,1 numero,1 carattere speciale.');
		$("#errorepass").removeClass("hidden");
		$("#password").focusin(function () {
			$("#tip").addClass("hidden");
		});

		return false;
	}
	return true;
}


function email_validation(email) {
	var emailpattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if (!email.value.match(emailpattern)) {
		email.focus();
		$("#email").val('');
		$("#email").attr('placeholder','L email inserita non valida.');
		return false;
	}
	return true;
}


function allLetter(uname) {
	var letters = /^[A-Za-z]+$/;
	if (uname.value.match(letters)) {
		return true;
	} else {
		alert('Username must have alphabet characters only');
		uname.focus();
		return false;
	}
}
function alphanumeric(uadd) {
	var letters = /^[0-9a-zA-Z]+$/;
	if (uadd.value.match(letters)) {
		return true;
	} else {
		alert('User address must have alphanumeric characters only');
		uadd.focus();
		return false;
	}
}
function countryselect(ucountry) {
	if (ucountry.value == "Default") {
		alert('Select your country from the list');
		ucountry.focus();
		return false;
	} else {
		return true;
	}
}
function allnumeric(uzip) {
	var numbers = /^[0-9]+$/;
	if (uzip.value.match(numbers)) {
		return true;
	} else {
		alert('ZIP code must have numeric characters only');
		uzip.focus();
		return false;
	}
}

function validateForm() {
	var x = uemail.value;
	var atpos = x.indexOf("@");
	var dotpos = x.lastIndexOf(".");
	if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= x.length) {
		alert("Not a valid e-mail address");
		return false;
	}
}
function ValidateEmail(uemail) {

	var x = uemail.value;
	var atpos = x.indexOf("@");
	var dotpos = x.lastIndexOf(".");
	if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= x.length) {
		alert("Not a valid e-mail address");
		uemail.focus();
		return false;
	} else {
		return true;
	}

}
function validsex(umsex, ufsex) {
	x = 0;

	if (umsex.checked) {
		x++;
	}
	if (ufsex.checked) {
		x++;
	}
	if (x == 0) {
		alert('Select Male/Female');
		umsex.focus();
		return false;
	} else {
		alert('Form Succesfully Submitted');
		window.location.reload()
		return true;
	}
}
