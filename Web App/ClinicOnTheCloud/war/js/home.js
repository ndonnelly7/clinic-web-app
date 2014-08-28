/**
 * 
 */
var viewingSeeAll = false, findPatient = false;
var statusTick = 0, patientBeingSearched = null;
$(function() {
    $( ".pickdate" ).datepicker({
      changeMonth: true,
      changeYear: true,
      yearRange: "1900:" + (new Date()).getFullYear(),
      dateFormat: "dd/MM/yy"
    });
    
	CommInit();
	
	if(typeof(Storage) !== 'undefined'){
		if(sessionStorage.newpatient && sessionStorage.newpatient != "na"){
			$.ajax('/cliniconthecloud.do', {
				method:'GET',
				dataType:'text',
				data: {
					type:"ADDED_PATIENT",
					PatientID:sessionStorage.newpatient
				},
				success:function(response) {
					$("#infotext").append("<div>"+response+"</div>");
					sessionStorage.newpatient = "na";
				}
			});
		}
	}
  });
  
  function revealReviewDiv(div){
	  $("#review").show(500);
  }
  
 function sendReview(){
	 var name = $("#name").val();
	 var dob = $("#pickdate").val();
	 var id = createID(name, dob);
	$("#id").val(id);
	$("#review").submit();
 }
 
 function deleteThisPatient(delBtn){
	 var f = delBtn.parentElement.parentElement;
	 
	 var name = $(f).find("#name").val();
	 var dob = $(f).find("#dob").val();
	 $("#infotext").append("Deleting " + id);
	 
	 var id = createID(name, dob);
	 
	 $.ajax('/cliniconthecloud.do', {
		method:'GET',
		dataType:'text',
		data: {
			type:"DELETE",
			DeleteID:id
		},
		success:function(response) {
			console.log(response);
			if(response.indexOf("Error:") >= 0)
				$("#infotext").append("Delete Response:" + response);
			else {
				$("#infotext").append("Removed: " + id);
				removePatient(id);
				$(f).find("#message").html("Deleted");
			}
		}
	});
 }
 
 function revealSeeAllDiv(div){
	 if(viewingSeeAll){
		 $("#see_all_div").hide(500);
		 viewingSeeAll = false;
		 $(div).val("See All Stored Patients");
		 clearGrid();
	 } else {
		 clearGrid();
		 loadPatients();
		 $("#see_all_div").show(500);
		 viewingSeeAll = true;
		 $(div).val("Hide All Stored Patients");
	 }
 }
 
 function revealFindPatientDiv(div){
	 if(findPatient){
		 findPatient = false;
		 $(div).val("Find Patient");
		 $("#find_patient").hide(500);
	 } else {
		 findPatient = true;
		 $(div).val("Hide Search");
		 $("#find_patient").show(500);
	 }
 }
 
 function addClinic(){
	 var cname = $("#cname").val();
	 var pass = $("#pass").val();
	 $("#clinic").append("<div id='loading_clinic'>Adding Clinic</div>");
	 $.ajax('/cliniconthecloud.do', {
		method:'GET',
		dataType:'text',
		data: {
			type:"NEW_CLINIC",
			name:cname,
			password:pass
		},
		success:function(response) {
			$("#clinic").remove("#loading_clinic");
			console.log(response);
		},
		error:function(request, status, error) {
			console.log(request);
			console.log(status);
			console.log(error);
			$("#loading_clinic").html("");
			$("#loading_clinic").html(error);
		}
	});
 }
 
 function revealClinic(div){
	 $("#clinic").show();
 }
 
 function showInfoText(){
	 $("#infotext").toggle(500);
 }
 
 function hideResult(){
	 $("#find_patient_result").hide(500);
 }
 
 function fillFindPatient(patient){
	 $("#find_patient_result").show(500);
	 $("#find_patient_result div #name").val(patient[name]);
	 $("#find_patient_result div #dob").val(patient[dob]);
	 $("#find_patient_result div #address").val(patient[address]);
	 $("#find_patient_result div #home_number").val(patient[home_number]);
	 $("#find_patient_result div #mob_number").val(patient[mob_number]);
	 $("#find_patient_result div #id").val(patient[p_id]);
 }
 
 function makePatientRequest(){
	 var name= $("#find_patient div #name").val();
	 var dob = $("#find_patient div #dob_find").val();
	 var id = createID(name, dob);
	 sendPatientRequest(id);
	 $("#search_status").html("Searching...");
	 statusTick = 15;
	 patientBeingSearched = id;
	 setTimeout(statusTicker, 2000);
 }
 
 function statusTicker(){
	 if(patientBeingSearched == null)
		 return;
	 getPatient(patientBeingSearched, function(p){
		if(p == null){
			if(statusTick > 0){
				statusTick--;
				setTimeout(statusTicker,2000);
				var status_string = $("#search_status").html();
				if(status_string.indexOf(".....") > 0)
					$("#search_status").html("Searching.");
				else $("#search_status").html(status_string + ".");
			} else {
				 $("#search_status").html("Search Failed. Possibly no online peers with that patient");
			}
		} else {
			statusTick = 0;
			$("#search_status").html("Patient Added Successfully");
			fillFindPatient(p);
		}
	 });
 }
 
 function getPatientsManually(){
	 $("#manual_get_patients").show(500);
	 getAllPatients(function(patients){
		 var patients_json = JSON.stringify(patients);
		 $("#get_patients_area").val(patients_json);
	 });
 }
 
 function writePatientsManually(){	 
	 var input = $("#store_patients_area").val();
	 if(input != null){
			var arr = $.parseJSON(input);
			$("#infotext").append("<div>Info under \"patients\""+arr+"</div>");
			$("manual_add_status").html("Starting to add...");
			for(var i = 0; i < arr.length; i++){
				$("manual_add_status").html("Adding " + i + " of " + arr.length + "...");
				addPatientToDB(arr[i]);			
			}			
			$("manual_add_status").html("Finished Adding");
		}
 }
 
 function openPatientsManually(){
	 $("#manual_store_patients").show(500);
 }