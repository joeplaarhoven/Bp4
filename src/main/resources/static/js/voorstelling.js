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
	
	$('input[type=radio][name=voorstellingsoort]').change(function() {
	    if (this.value == 'Caberatier') {
	    	 var action = /*[[@{/cabaretier/save}]]*/ '/cabaretier/save';
    	     $("#voorstellingForm").attr("action", action);
	    }
	    else if (this.value == 'Concert') {
	    	var action = /*[[@{/concert/save}]]*/ '/concert/save';
   	     	$("#voorstellingForm").attr("action", action);
	    }
	    else if (this.value == 'Theatervoorstelling') {
	    	var action = /*[[@{/theatervoorstelling/save}]]*/ '/theatervoorstelling/save';
   	     	$("#voorstellingForm").attr("action", action);
	    }
	});
});