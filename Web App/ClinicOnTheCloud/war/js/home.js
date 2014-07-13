/**
 * 
 */
var viewingSeeAll = false, findPatient = false;
$(function() {
    $( "#pickdate" ).datepicker({
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
 
 function revealSeeAllDiv(div){
	 if(viewingSeeAll){
		 $("#see_all_div").hide(500);
		 viewingSeeAll = false;
		 $(div).val("See All Stored Patients");
		 clearGrid();
	 } else {
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
		 $("#find_patient_div").hide(500);
	 } else {
		 findPatient = true;
		 $(div).val("Hide Search");
		 $("#find_patient_div").show(500);
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
	 var dob = $("#find_patient div #dob").val();
	 var id = createID(name, dob);
	 sendPatientRequest(id);
 }