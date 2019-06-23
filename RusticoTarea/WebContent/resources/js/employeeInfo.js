$( document ).ready(function() {
	console.log("entro aqui");
    $('#employee-birth').val($('#birth-hidden').val());
   
	$( "#employee-birth" ).on('change', function() {
		$('#birth-hidden').val($(this).val()); 
	});
});