const createAccBtn = document.getElementById("create-acc");

function validateForm() {
	let fname = document.getElementById("fName").value;
	let lname = document.getElementById("lName").value;
	let email = document.getElementById("email").value;
	let password = document.getElementById("password").value;

	
	if(fname==""){
		alert("Please enter your first name");
		return false;
	}
	if(lname==""){
		alert("Please enter last name");
		return false;
	}
	if(email==""){
		alert("Please enter email");
		return false;
	}

	if(password==""){
		alert("Please enter password");
		return false;
	}
	
}

function showAlert() {
    alert("Your account has been created");
}
//createAccBtn.addEventListener("click",validateForm);
