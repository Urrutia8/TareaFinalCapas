$( document ).ready(function() {
	console.log("entro aqui");
	
	
    $('#opening-weekend-time').val($('#opening-weekend-time-hidden').val());
    $('#closing-weekend-time').val($('#closing-weekend-time-hidden').val());
    $('#opening-week-time').val($('#opening-week-time-hidden').val());
    $('#closing-week-time').val($('#closing-week-time-hidden').val());

	$( ".time-element" ).on('change', function() {
		$(this).next().val($(this).val() + ':00'); 
	});
});