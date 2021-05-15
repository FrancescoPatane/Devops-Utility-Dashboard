function callServiceJsonOutput(){
	resetInput()
	let endpoint = getEndpointSelected();
	let payload = document.getElementById("inputBox").value;
	let data = {"path":endpoint.path,"payload":payload};
	let result;
	fetch("/call", {
	  method: endpoint.requestType,
	  body: JSON.stringify(data),
	  headers: {"Content-type": "application/json; charset=UTF-8"}
	})
	.then(response => response.json()) 
	.then(json => manageResponseFromServer(json))
	.catch(err => console.log(err));
	
}

function manageResponseFromServer(jsonResponse){
	if (jsonResponse.succesfull){
		document.getElementById("outputBox").innerHTML = JSON.stringify(JSON.parse(jsonResponse.payload))
	}else{
		alert(jsonResponse.message)
	} 
}

function resetInput(){
	document.getElementById("outputBox").innerHTML = null;
}


function getEndpointSelected() {
  return  JSON.parse(selectedValue = document.getElementById("endpointSelection").value);
}