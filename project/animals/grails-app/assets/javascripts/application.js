// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better 
// to create separate JavaScript files as needed.
//
//= require jquery
//= require_tree .
//= require_self

if (typeof jQuery !== 'undefined') {
	(function($) {
		$(document).ajaxStart(function(){
			$('#spinner').fadeIn();
		}).ajaxStop(function(){
			$('#spinner').fadeOut();
		});
	})(jQuery);
}

function validateForm(){
	var message = "", field = "";
	if ($('#animal').val() != undefined && allowOnlyLetters("#animal") == "") {
		field = "#animal";
		message = "Ops.. não esqueça de informar o animal!";
	}

	if ($('#feature').val() != undefined && allowOnlyLetters("#feature") == "") {
		field = "#feature";
		message = "Ops.. não esqueça de informar uma característica do animal!";
	}

	if(message !== "") {
		$("#clientSideErrors").html(message);
		$("#clientSideErrors").show();
		$("#clientSideErrors").fadeOut(7200);
		$(field).val("");
		return false;
	} else {
		$("#clientSideErrors").html("");
		return true;
	}
}

function allowOnlyLetters(fieldSeletor) {
	var value = $(fieldSeletor).val();
	value = value? value.replace(/[^a-zA-Z.]/g,'') : "";

	return value;
}

