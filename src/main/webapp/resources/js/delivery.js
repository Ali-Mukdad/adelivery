$(function() {
	initDatePicker();
});

function initDatePicker() {

	$('.my-datepicker').datepicker({
		format: 'dd-mm-yyyy',
		clearBtn: true,
		todayHighlight: true,
	});
}

function reinit(){
	$('.my-datepicker').datepicker('destroy');
	initDatePicker();
}
