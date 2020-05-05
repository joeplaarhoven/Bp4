$( document ).ready(function() {
	$( ".theaterDD" ).change(function() {
		 var value = $(this).children("option:selected").val();
		 $("#hiddenTheater").val(value)
		 alert(value);
		 $("#theaterSel").submit();
		});
	
	$.urlParam = function(name){
	    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
	    if (results==null) {
	       return null;
	    }
	    return decodeURI(results[1]) || 0;
	}
	
	var selectedTheater = $.urlParam('theaternaam')
	selectedTheater = selectedTheater.replace("+", " ");
	$('#span_id select option[value="' + selectedTheater + '"]').prop('selected', true);
	//selectedTheater = $(".theaterDD").prop('selected', true);.text(selectedTheater.replace('+', ' ')); 
	console.log(selectedTheater)
	
	//$("#selectedItem").val(selectedTheater);
	
	
});