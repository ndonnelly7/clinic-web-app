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