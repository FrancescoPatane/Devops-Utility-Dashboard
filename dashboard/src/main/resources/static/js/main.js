var serviceList = [];


function getAppServices(){
	console.log(app)
//	let endpoint = getEndpointSelected();
//	let payload = document.getElementById("inputBox").value;
//	let data = {"path":endpoint.path,"payload":payload};
//	let result;
	fetch("/app/" + app + "/services", {
	  method: 'GET',
	})
	.then(response => response.json()) 
	.then(json => renderEndpointSelection(json))
	.catch(err => console.log(err));
	
}

function renderEndpointSelection(endpoints){
	serviceList = endpoints;
	let endpointSelection = document.getElementById("endpointSelection");
	let options = "";
	endpoints.forEach(e => {
		options += "<option>"+ e.path +"</option>";
		options += "<option>"+ 'xxx' +"</option>";
	});
	endpointSelection.innerHTML = options;
	selectEndPoint()

}

function callService(){
	let selectedService = getEndpointSelected();
		switch (selectedService.interfaceType) {
	  case 'PARAMS_TO_JSON':
		callServiceParamsToJsonOutput();
	    break;
	  case 'JSON_TO_JSON':
		callServiceJsonToJsonOutput();
	    break;
	  default:
	    console.log("ERROR - UNKNOWN INTERFACE TYPE");
	}
}

function callServiceJsonToJsonOutput(){
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

function callServiceParamsToJsonOutput(){
//	resetInput()
	let endpoint = getEndpointSelected();
	let inputs = document.getElementsByTagName("input");
	let payload = JSON.stringify(prepareParams(inputs));
//	let payload = document.getElementById("inputBox").value;
	let data = {"path":endpoint.path,"payload":payload};
//	let result;
	fetch("/call", {
	  method: endpoint.requestType,
	  body: JSON.stringify(data),
	  headers: {"Content-type": "application/json; charset=UTF-8"}
	})
	.then(response => response.json()) 
	.then(json => manageResponseFromServer(json))
	.catch(err => console.log(err));
	
}

function prepareParams(inputs){
	let paramData = {};
	for(let i=0; i<inputs.length; i++){
		paramData[inputs[i].id] = inputs[i].value
	}
	return paramData;
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
	let selected = document.getElementById("endpointSelection").value;
	let selectedService = serviceList.filter(s => s.path === selected)[0];
	return selectedService;
}

function selectEndPoint() {
	let selectedService = getEndpointSelected();
	let rendering = "";
	console.log(selectedService);
	switch (selectedService.interfaceType) {
	  case 'PARAMS_TO_JSON':
//	    		rendering = '<div class="row m-top"> <div class="col-5"> <div class="input-group"> <span class="input-group-text">Parameters</span> <textarea id="inputBox" class="form-control" aria-label="With textarea"></textarea> </div> </div> <div class="col-2"></div> <div class="col-5"> <div class="input-group"> <span class="input-group-text">Result</span> <textarea id="outputBox" class="form-control" aria-label="With textarea"></textarea> </div> </div> </div>';
			let inputs = '';
			selectedService.inputParams.forEach(e => {
		inputs += '<div class="row"> <div class="input-group mb-3"> <div class="input-group-prepend"> <span class="input-group-text" >'+e+'</span> </div> <input id="'+e+'" type="text" class="form-control"> </div> </div>';
	});
			rendering = '<div class="row m-top"> <div class="col-5">'+inputs+'</div> <div class="col-2"></div> <div class="col-5"> <div class="input-group"> <span class="input-group-text">Result</span> <textarea id="outputBox" class="form-control" ></textarea> </div> </div> </div>';
	    break;
	  case 'JSON_TO_JSON':
		rendering = '<div class="row m-top"> <div class="col-5"> <div class="input-group"> <span class="input-group-text">Parameters</span> <textarea id="inputBox" class="form-control" aria-label="With textarea"></textarea> </div> </div> <div class="col-2"></div> <div class="col-5"> <div class="input-group"> <span class="input-group-text">Result</span> <textarea id="outputBox" class="form-control" aria-label="With textarea"></textarea> </div> </div> </div>';
	    break;
	  default:
	    console.log("ERROR - UNKNOWN INTERFACE TYPE");
	}
	document.getElementById("servicePanel").innerHTML = rendering;
//  return  JSON.parse(selectedValue = document.getElementById("endpointSelection").value);
}