/**
 * 
 */

$(function () {
	$("ul.form-tabs").tabs($("div.sections > div"));
	$("ul.date-tabs").tabs($("div.forms > div"));
	
	
});

$(document).ready(function() {
	var $window = $(window);
	
	function updateWidth() {
		var size = $window.width();
		if(size < 1360) {
			$("ul.tabs li a").addClass("s");
		} else {
			$("ul.tabs li a").removeClass("s");
		}
	}
	
	updateWidth();
	$(window).resize(updateWidth);
	resetTabs();
});

function resetTabs(){
	$("#det-tab").click(function() {
		loadDetails();
	});
	$("#his-tab").click(function() {
		loadHistory();
	});
}

function loadDetails(){
	$("#details").load("../admin/review-files/details.html #det_form", function(){
		console.log($("#details #det_form"));
		$("#det_form").show();
	});
	var id = $("#id_from_attr").val();
	$.ajax('/review.do', {
		method:'GET',
		dataType:'text',
		data: {
			page:"DETAILS",
			id:id
		},
		success:function(response) {
			console.log(response);
		}
	});
}

function loadHistory(){
	$("#history").load("../admin/review-files/history.html #test", function(){
		console.log($("#history #test").html());
	}).show();
}

function loadGP(){
	
}

function loadConcerns(){
	
}

function loadNeuro(){
	
}

function loadEvents(){
	
}

function loadLiving(){
	
}

function loadLifestyle(){
	
}

function loadTests(){
	
}

function loadAnalysis(){
	
}