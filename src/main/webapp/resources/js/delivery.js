$(function() {
	initDatePicker();
});

function initDatePicker() {

	$('.datepicker').datepicker({
		format: 'dd-mm-yyyy',
		clearBtn: true,
	});
}

function reinit(){
	$('.datepicker').datepicker('destroy');
	initDatePicker();
}
