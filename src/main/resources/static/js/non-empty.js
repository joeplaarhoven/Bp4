function required() {
	var empt = document.forms["CabaretierForm"]["text1"].value;
	if (empt == "") {
		alert("Please input a Value");
		return false;
	} else {
		alert('Code has accepted : you can try another');
		return true;
	}
}