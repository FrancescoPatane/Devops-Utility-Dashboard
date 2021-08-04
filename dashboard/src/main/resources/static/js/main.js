var serviceList = [];

const ALL_ENVS = ["rendiconti_svil","aml_svil","adapter_svil","sfe_svil","orchestrator_svil","swebs_svil","card_svil","rendiconti_test","aml_test","adapter_test","sfe_test","orchestrator_test","swebs_test","card_test","rendiconti_prod","aml_prod","adapter_prod","sfe_prod","orchestrator_prod","swebs_prod","card_prod","rendiconti_dr","aml_dr","adapter_dr","sfe_dr","orchestrator_dr","swebs_dr","card_dr"];

const SERVICES = ["adapter", "sfe", "orchestrator", "swebs", "card", "rendiconti", "aml"];

const SVIL_MACHINES = ["s1npspas01.sisalpay5group.local","s1npspas02.sisalpay5group.local","s1npspas03.sisalpay5group.local","s1npspas04.sisalpay5group.local"];
const TEST_MACHINES = ["t1npspas01.sisalpay5group.local","t1npspas02.sisalpay5group.local","t1npspas03.sisalpay5group.local","t1npspas04.sisalpay5group.local","t1npspas05.sisalpay5group.local","t1npspas06.sisalpay5group.local","t1npspas07.sisalpay5group.local","t1npspas08.sisalpay5group.local"];

function getAppServices() {
    fetch("/app/" + app + "/services", {
            method: 'GET',
        })
        .then(response => response.json())
        .then(json => renderEndpointSelection(json))
        .catch(err => console.log(err));
}

function renderEndpointSelection(endpoints) {
    serviceList = endpoints;
    let endpointSelection = document.getElementById("endpointSelection");
    let options = "";
    endpoints.forEach(e => {
        options += "<option>" + e.path + "</option>";
    });
    endpointSelection.innerHTML = options;
    selectEndPoint()
}

function callService() {
    let selectedService = getEndpointSelected();
    switch (selectedService.interfaceType) {
        case 'PARAMS_TO_FILE':
            callServiceParamsToJsonOutput();
            break;
        case 'HOSTS_TO_FILE':
            callServiceSelectionsToJsonOutput();
            break;
        case 'TEXT_TO_JSON':
            callServiceTextToJsonOutput();
            break;
		case 'ENV_REPORT':
			callServiceEnvReportOutput();
			break;
        default:
            console.log("ERROR - UNKNOWN INTERFACE TYPE " + selectedService.interfaceType);
    }
}

function callServiceTextToJsonOutput() {
    resetInput()
    let endpoint = getEndpointSelected();
    let payload = document.getElementById("inputBox").value;
    let data = {
        "path": endpoint.path,
        "payload": payload
    };
    let result;
    fetch("/call", {
            method: endpoint.requestType,
            body: JSON.stringify(data),
            headers: {
                "Content-type": "application/json; charset=UTF-8"
            }
        })
        .then(response => response.json())
        .then(json => manageResponseFromServer(json))
        .catch(err => console.log(err));
}

function callServiceParamsToJsonOutput() {
    let endpoint = getEndpointSelected();
    let inputs = document.getElementsByTagName("input");
    let payload = JSON.stringify(prepareParams(inputs));
    let data = {
        "path": endpoint.path,
        "payload": payload
    };
    fetch("/call", {
            method: endpoint.requestType,
            body: JSON.stringify(data),
            headers: {
                "Content-type": "application/json; charset=UTF-8"
            }
        })
        .then(response => response.json())
        .then(json => manageResponseFromServer(json))
        .catch(err => console.log(err));
}

function callServiceSelectionsToJsonOutput() {
	let endpoint = getEndpointSelected();
    let inputs = document.getElementsByTagName("select");
    let payload = JSON.stringify(prepareParams(inputs));
    let data = {
        "path": endpoint.path,
        "payload": payload
    };
    fetch("/call", {
            method: endpoint.requestType,
            body: JSON.stringify(data),
            headers: {
                "Content-type": "application/json; charset=UTF-8"
            }
        })
        .then(response => response.json())
        .then(json => manageResponseFromServer(json))
        .catch(err => console.log(err));
}

function callServiceEnvReportOutput(){
	
	
		let endpoint = getEndpointSelected();
    let inputs = document.getElementsByTagName("select");
    let payload = prepareParams(inputs);
	console.log(payload);
	let uri = payload.endpointSelection;
	endpoint.pathParams.forEach(e => {
		uri = uri.replace("{"+e+"}",payload[e]);
	});


    let data = {
        "path": uri,
//        "payload": payload,
		"httpMethod": endpoint.requestType
    };
    fetch("/call", {
            method: "POST",
            body: JSON.stringify(data),
            headers: {
                "Content-type": "application/json; charset=UTF-8"
            }
        })
        .then(response => response.json())
        .then(json => manageResponseFromServer(json))
        .catch(err => console.log(err));
}
	
	
	
	

function prepareParams(inputs) {
    let paramData = {};
    for (let i = 0; i < inputs.length; i++) {
        paramData[inputs[i].id] = inputs[i].value
    }
    return paramData;
}

function manageResponseFromServer(jsonResponse) {
    if (jsonResponse.succesfull) {
        let selectedService = getEndpointSelected();
        switch (selectedService.interfaceType) {
            case 'PARAMS_TO_FILE':
			case 'HOSTS_TO_FILE':
                manageFileResponse(jsonResponse);
                break;
            case 'TEXT_TO_JSON':
                manageJsonResponse(jsonResponse);
                break;
			case 'ENV_REPORT':
				manageEnvReportReponse(jsonResponse);
				break;
            default:
                console.log("ERROR - UNKNOWN INTERFACE TYPE " + selectedService.interfaceType);
        }
    } else {
        alert(jsonResponse.message)
    }
}

function manageEnvReportReponse(jsonResponse) {
	let payload = jsonResponse.payload;
	console.log(payload);
	let html = "<fieldset>";
	let header = '<div class="row"><div class="col-12"> <h4>HOST: '+ payload.OS_INFO.Name + ' - ' + payload.OS_INFO.HOST +'</h4></div></div>';
	html += header;
	let mem = '<div class="row"> <div class="col-3"> <div class="card"> <div class="card-body"> <h5 class="card-title">Memory</h5> <p class="card-text"> <ul> <li>Total: ' + payload.OS_INFO.MEM.Tot + '</li> <li>Used: '+payload.OS_INFO.MEM.Used+'</li> <li>Free: '+payload.OS_INFO.MEM.Free+'</li> <li>Available: '+payload.OS_INFO.MEM.Available+'</li> </ul> </p> </div> </div> </div> <div class="col-3"> <div class="card"> <div class="card-body"> <h5 class="card-title">SWAP</h5> <p class="card-text"> <ul> <li>Total: '+payload.OS_INFO.SWAP.Available+'</li> <li>Used: '+payload.OS_INFO.SWAP.Used+'</li> <li>Free: '+payload.OS_INFO.SWAP.Free+'</li> </ul> </p> </div> </div> </div> <div class="col-6"> <div class="card"> <div class="card-body"> <h5 class="card-title">Docker data-root</h5> <p class="card-text"> <ul> <li>File System: '+payload.OS_INFO['Docker data-root'].FS+'</li> <li>Dimensioni</li> <li>Used: '+payload.OS_INFO['Docker data-root'].Usati+'</li> <li>Available: '+payload.OS_INFO['Docker data-root']['Dispon.']+'</li> <li>Uso%: '+payload.OS_INFO['Docker data-root']['Uso%']+'</li> <li>Montato su: '+payload.OS_INFO['Docker data-root']['Montato su']+'</li> </ul> </p> </div> </div> </div> </div>';
	html += mem;
	let accordion = '<div class="accordion m-top" id="accordionReport">';
	let containersHtml = '<div class="accordion-item"> <h2 class="accordion-header"> <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" > Container Docker </button> </h2> <div id="collapseOne" class="accordion-collapse collapse"  data-bs-parent="#accordionReport"> <div class="accordion-body"> <ol class="list-group">';
	payload.DOCKER.CONTAINER_ALL.forEach(e => {
		containersHtml+= '<li class="list-group-item d-flex "><div class="ms-2 me-auto"><div class="fw-bold">' + e.NAME + '-' + e.IMAGES  + '-' +  e.STATUS + '</div>' + e.PORTS + ' </div></li>';

	});
	containersHtml+= '</ol></div></div>';
	html += containersHtml;
	
	payload.DOCKER.KARAF.SERVICES.forEach(function (e, i) {
		let karafWarning = '';
			if ( e.CAMEL_ROUTE_STOPPED.length>0 || BUNDLE_STATUS.length>0){
				karafWarning += '<i class="fa fa-exclamation-triangle"></i>';
			}
			let karafHtml = '<div class="accordion-item"> <h2 class="accordion-header" id="heading'+i+'"> <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo">Servizi Karaf'+karafWarning+'</button> </h2> <div id="collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionReport"> <div class="accordion-body">';
			
			karafHtml += '<div class="row m-top"> <div class="col-6"> <p>Container: Card</p> </div> <div class="col-6"> </div> </div> <div class="row"> <div class="col-6"> <div class="card" > <div class="card-header"> Bundle Status </div> <ul class="list-group list-group-flush">';
			e.BUNDLE_STATUS.forEach(e => {
				karafHtml += '<li class="list-group-item"> <span>'+ e.NAME +' - '+ e.VER +'1.3.2 - ' + e.STATUS +'</span> </li>';
			});
			karafHtml += '</ul></div></div><div class="col-6"> <div class="card" > <div class="card-header"> Stopped Camel Routes </div> <ul class="list-group list-group-flush">';
			e.CAMEL_ROUTE_STOPPED.forEach(e => {
				karafHtml += '<li class="list-group-item"> <span>'+ e.Name +' - ' + e.Context + '</span> <span>'+ e.Status +' - '+e.Total+' '+ e.Inflight+' '+ e.Failed + '</span> </li>';
			});	
			html += karafHtml;
		});
	
	html += "</div></fieldset>";
	console.log(html);
	document.getElementById("envReports").innerHTML = html;
	
}

function manageJsonResponse(jsonResponse) {
    document.getElementById("outputBox").innerHTML = JSON.stringify(JSON.parse(jsonResponse.payload))
}

function manageFileResponse(jsonResponse) {
    const byteCharacters = atob(jsonResponse.payload.base64);
    const byteNumbers = new Array(byteCharacters.length);
    for (let i = 0; i < byteCharacters.length; i++) {
        byteNumbers[i] = byteCharacters.charCodeAt(i);
    }
    let byteArray = new Uint8Array(byteNumbers);

    let blob = new Blob([byteArray], {
        type: 'application/octetstream'
    });
    let url = window.URL || window.webkitURL;
    link = url.createObjectURL(blob);
    let a = document.createElement("a");
    a.setAttribute("download", jsonResponse.payload.fileName);
    a.setAttribute("href", link);
    document.body.appendChild(a);
    a.click();
    document.body.removeChild(a);
}

function resetInput() {
    document.getElementById("outputBox").innerHTML = null;
}

function getEndpointSelected() {
    let selected = document.getElementById("endpointSelection").value;
    let selectedService = serviceList.filter(s => s.path === selected)[0];
    return selectedService;
}

function printAllHostsSelect(name){
	let select = '<select class="form-select" id="'+name+'">';
	ALL_ENVS.forEach(e => {
		select+='<option>'+e+'</option>';
	});
	select+='</select>';
	return select;
}

function printEnvSelection(){
	return '<div class="row"><div class="col-5"><div class="input-group input-group-lg form-group"><label class="input-group-text">Environment</label><select class="form-select" id="env" ><option>s1npspas01.sisalpay5group.local</option><option>s1npspas02.sisalpay5group.local</option><option>s1npspas03.sisalpay5group.local</option><option>s1npspas04.sisalpay5group.local</option><option>t1npspas01.sisalpay5group.local</option><option>t1npspas02.sisalpay5group.local</option><option>t1npspas03.sisalpay5group.local</option><option>t1npspas04.sisalpay5group.local</option><option>t1npspas05.sisalpay5group.local</option><option>t1npspas06.sisalpay5group.local</option><option>t1npspas07.sisalpay5group.local</option><option>t1npspas08.sisalpay5group.local</option><option>PROD</option><option>DR</option></select></div></div></div>';

}


function selectEndPoint() {
    let selectedService = getEndpointSelected();
    let rendering = "";
    let inputs = '';
    switch (selectedService.interfaceType) {
	 case 'HOSTS_TO_FILE':
            selectedService.inputParams.forEach(e => {
				let select = printAllHostsSelect(e);
				inputs += '<div class="row m-top"><div class="input-group input-group-lg form-group"><label class="input-group-text">'+ e +'</label>'+select+'</div></div>';   
	         });
            rendering = '<div class="row m-top"> <div class="col-5">' + inputs + '</div> <div class="col-2"></div> <div class="col-5">  </div> </div>';
            break;
        case 'PARAMS_TO_JSON':
            selectedService.inputParams.forEach(e => {
                inputs += '<div class="row"> <div class="input-group mb-3"> <div class="input-group-prepend"> <span class="input-group-text" >' + e + '</span> </div> <input id="' + e + '" type="text" class="form-control"> </div> </div>';
            });
            rendering = '<div class="row m-top"> <div class="col-5">' + inputs + '</div> <div class="col-2"></div> <div class="col-5"> <div class="input-group"> <span class="input-group-text">Result</span> <textarea id="outputBox" class="form-control" ></textarea> </div> </div> </div>';
            break;
        case 'PARAMS_TO_FILE':
            selectedService.inputParams.forEach(e => {
                inputs += '<div class="row"> <div class="input-group mb-3"> <div class="input-group-prepend"> <span class="input-group-text" >' + e + '</span> </div> <input id="' + e + '" type="text" class="form-control"> </div> </div>';
            });
            rendering = '<div class="row m-top"> <div class="col-5">' + inputs + '</div> <div class="col-2"></div> <div class="col-5">  </div> </div>';
            break;
        case 'TEXT_TO_JSON':
            rendering = '<div class="row m-top"> <div class="col-5"> <div class="input-group"> <span class="input-group-text">Parameters</span> <textarea id="inputBox" class="form-control" aria-label="With textarea"></textarea> </div> </div> <div class="col-2"></div> <div class="col-5"> <div class="input-group"> <span class="input-group-text">Result</span> <textarea id="outputBox" class="form-control" aria-label="With textarea"></textarea> </div> </div> </div>';
            break;
		case 'ENV_REPORT':
			rendering += printEnvSelection();
			rendering += "</div><br><br><br>";
			rendering += "<div id='envReports'></div>";
			break;
        default:
            console.log("ERROR - UNKNOWN INTERFACE TYPE " + selectedService.interfaceType);
    }
    document.getElementById("servicePanel").innerHTML = rendering;
}

