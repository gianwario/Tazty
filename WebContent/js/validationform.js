function formValidation() {
	var password = document.registration.password;
	var email = document.registration.email;
	var phone = document.registration.phone;
	if(password_validation(password)&&email_validation(email)&&phone_validation(phone)) 
	{
		return true;
	}
	return false;
}

function password_validation(password) {
	var passpattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[#$^+=!*()@%&]).{6,}$/;
	if (!password.value.match(passpattern)) {
		password.focus();
		$("#password").val('');
		$("#password").attr('placeholder','Errore password');
		$("#errorepass").removeClass("hidden");
		$('#password').on('input',function () { 
			$("#errorepass").addClass("hidden");
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
		$("#email").attr('placeholder','Errore email.');
		$("#erroreemail").removeClass("hidden");
		$('#email').on('input',function () { 
			$("#erroreemail").addClass("hidden");
		});
		return false;
	}
	return true;
}


function phone_validation(phone) {
	var phonepattern = /^(([+])39)?((3[1-6][0-9]))(\d{7})$/;
	if (!phone.value.match(phonepattern)) {
		phone.focus();
		$("#phone").val('');
		$("#phone").attr('placeholder','Errore numero di telefono.');
		$("#errorephone").removeClass("hidden");
		$('#phone').on('input',function () { 
			$("#errorephone").addClass("hidden");
		});
		return false;
	}
	return true;
}