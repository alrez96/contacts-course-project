//signin

function callCheckWhoSignin(){
	const Http = new XMLHttpRequest();
	const url='contacts/rest/checkwho/check/'+document.getElementById('username').value;
	Http.open("GET", url, false);
	Http.send();
	Http.onreadystatechange=stateRecognition(Http);

}
function stateRecognition(Http){
	var returnedObject = Http.responseText;
	if (returnedObject == "actor") {
		checkActorPass();
	}
	else if (returnedObject == "student") {
		checkStudentPass();
	}
	else if (returnedObject == "none") {
		document.getElementById("error1").style.display = "block";
	}

}
function checkActorPass(){
	var obj = { 
		username: document.getElementById('username').value, 
		pass:document.getElementById('password').value
	};
	var sentJSON = JSON.stringify(obj);
	const Http = new XMLHttpRequest();
	const url='contacts/rest/student/checkpass';
	Http.open("POST", url, false);
	Http.setRequestHeader("Content-type", "application/json");
	Http.send(sentJSON);
	Http.onreadystatechange=checkActorState(Http);

}
function checkActorState(Http){
	var returnedObject = JSON.parse(Http.responseText);
	if (returnedObject.success) {
		window.location.href = "../actor/actor-wait.html";
	}
	else{
		document.getElementById("error2").style.display = "block";
	}
}
function checkStudentPass(){
var obj = { 
		username: document.getElementById('username').value, 
		pass:document.getElementById('password').value
	};
	var sentJSON = JSON.stringify(obj);
	const Http = new XMLHttpRequest();
	const url='contacts/rest/student/checkpass/'+document.getElementById('password').value;
	Http.open("POST", url, false);
	Http.setRequestHeader("Content-type", "application/json");
	Http.send(sentJSON);
	Http.onreadystatechange=checkStudentState(Http);
}
function checkStudentState(Http){
	var returnedObject = JSON.parse(Http.responseText);
	if (returnedObject.success) {
		window.location.href = "homepage.html";
	}
	else{
		document.getElementById("error2").style.display = "block";
	}
}

// signup

function callCheckSignup(){
	const Http = new XMLHttpRequest();
	const url='contacts/rest/checkwho/check/'+document.getElementById('username').value;
	Http.open("GET", url, false);
	Http.send();
	Http.onreadystatechange=userAuthentication(Http);
}
function userAuthentication(Http){
	var returnedObject = Http.responseText;
	if (returnedObject == "actor" || returnedObject == "student") {
		document.getElementById("error6").style.display = "block";
	}else if(returnedObject == "none"){
		var user = document.getElementById("inputRef").value;
		if (user == "کارمند/استاد") {
			saveActor();
		}else if(user == "دانشجو"){
			saveStudent();
		}
	}
}

function saveStudent(){
	var obj = { 
		username: document.getElementById('username').value, 
		pass: document.getElementById('password-box').value,
		emailAddress: document.getElementById('email-box').value
	};
	var sentJSON = JSON.stringify(obj);
	const Http = new XMLHttpRequest();
	const url='contacts/rest/student/save';
	Http.open("POST", url, false);
	Http.setRequestHeader("Content-type", "application/json");
	Http.send(sentJSON);
	Http.onreadystatechange=failOrPass(Http);
}
function failOrPass(Http){
	var returnedObject = JSON.parse(Http.responseText);
	if (returnedObject.success) {
		window.location.href = "homepage.html";
	}else{
		document.getElementById("error7").style.display = "block";
	}
}
function saveActor(){
	var obj = { 
		username: document.getElementById('username').value, 
		pass: document.getElementById('password-box').value,
		emailAddress: document.getElementById('email').value,
	};
	var sentJSON = JSON.stringify(obj);
	const Http = new XMLHttpRequest();
	const url='contacts/rest/actor/save';
	Http.open("POST", url, false);
	Http.setRequestHeader("Content-type", "application/json");
	Http.send(sentJSON);
	Http.onreadystatechange=failOrPassActor(Http);
}
function failOrPassActor(Http){
	var returnedObject = JSON.parse(Http.responseText);
	if (returnedObject.success) {
		window.location.href = "../actor/actor-wait.html";
	}else{
		document.getElementById("error7").style.display = "block";
	}
}

//case-submit
function callCaseSubmit(){
	const Http = new XMLHttpRequest();
	const url='contacts/rest/case/save';
	Http.open("GET", url, false);
	Http.send();
	Http.onreadystatechange=saveSubmit(Http);
}
function saveCase(Http){
	var obj = { 
		subject: document.getElementById('inputIssue').value, 
		title: document.getElementById('title').value,
		description: document.getElementById('description').value
	};
	var sentJSON = JSON.stringify(obj);
	const Http = new XMLHttpRequest();
	const url='contacts/rest/student/save';
	Http.open("POST", url, false);
	Http.setRequestHeader("Content-type", "application/json");
	Http.send(sentJSON);
	Http.onreadystatechange=failOrPass(Http);
}

function failOrPassCase(Http){
	var returnedObject = JSON.parse(Http.responseText);
	if (returnedObject.success) {
		window.location.href = "../user/homepage.html";
	}else{
		document.getElementById("error1").style.display = "block";
	}
} 