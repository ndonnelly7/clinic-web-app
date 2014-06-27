/**
 * 
 */
$(function() {
    $( "#pickdate" ).datepicker({
      changeMonth: true,
      changeYear: true,
      yearRange: "1900:" + (new Date()).getFullYear(),
      dateFormat: "dd/MM/yy"
    });
    
    
  });
  
  function revealReviewDiv(){
	  $("#review").show(500);
  }
  
 function sendReview(){
	 var name = $("#name").val();
	 var dob = $("#pickdate").val();
	 var id = createID(name, dob);
	$("#id").val(id);
	$("#review").submit();
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
 
 function revealClinic(){
	 $("#clinic").show();
 }