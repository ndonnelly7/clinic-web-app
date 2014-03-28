$(document).ready(function() {
	 
	$("#clinic_list").append('<option value="DCU">DCU Clinic</option>');
	$("#clinic_list").append('<option value="Mayo">Mayo Clinic</option>');
	$("#clinic_list").append('<option value="Waterford">Waterford Clinic</option>');
	$("#clinic_list").append('<option value="Kerry">Kerry Clinic</option>');
});
  
function newClinicChosen(){
	var clinicN = $('#clinic_list').val() + " Clinic";
	if(clinicN.indexOf("Choose") != -1){
		$("#clinician_options").slideUp(1000);
		$('#peer_list option').each(function() {
			if ( $(this).val() != 'invalid' ) {
				$(this).remove();
			}
		});
		return;
	} else {
		$("#infotext").append("<div>"+clinicN+"</div>");
		$.ajax('/webrtceval.do', {
			method:'GET',
			dataType:'text',
			data: {
				type:"ClientsFromClinic",
				clinic:clinicN
			},
			success:function(response) {
				$("#infotext").append("<div>Response from ClientsFromClinic Request: </div>");
				$("#infotext").append("<div>"+response+"</div>");
				$('#clinician_options').slideDown(1000);
				if(response != "") {
					var arr = $.parseJSON(response);
					arr.map( function(item){
						$("#peer_list").append('<option value=' + item.replace(" ", "_") + '>' + item + '</option>');
					});
				}
				$("#peer_list").append('<option value="new">New User</option>');
			}
		}); 
	}
}
  
function clientChosen(){
	var clientPick = $('#peer_list').val();
	if(clientPick=="invalid"){
		$('#name_field').prop('disabled', true);
		$('#newUser').prop('disabled', true);
		$('#userChosen').prop('disabled',true);
		$('#newUser').hide();
		$('#userChosen').hide();
	} else if(clientPick=="new"){
		$('#name_field').prop('disabled', false);
		$('#newUser').prop('disabled', false);
		$('#userChosen').prop('disabled',true);
		$('#newUser').slideDown(1000);
		$('#userChosen').hide();
	} else {
		$('#name_field').prop('disabled', true);
		$('#newUser').prop('disabled', true);
		$('#userChosen').prop('disabled',false);
		$('#newUser').hide();
		$('#userChosen').slideDown(1000);
	}
}