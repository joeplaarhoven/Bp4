$( document ).ready(function() {
	$("#voorstellingSoortId").hide()
	$( ".theaterDD" ).change(function() {
		 var value = $(this).children("option:selected").val();
		 $("#hiddenTheater").val(value)
		 $("#theaterSel").submit();
		});
	
	try{
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
		
	}
	catch(error){
		console.log(error)
	}
	
	
	$('input[type=radio][name=voorstellingsoort]').change(function() {
		$("#voorstellingSoortId").show()
	    if (this.value == 'Cabaretier') {    	     
    	     $("#cabaretier_id").show();
    	     $("#concert_id").hide();
    	     $("#theatervoorstelling_id").hide();
	    }
	    else if (this.value == 'Concert') {
   	     $("#cabaretier_id").hide();
	     $("#concert_id").show();
	     $("#theatervoorstelling_id").hide();
   	     	
	    }
	    else if (this.value == 'Theatervoorstelling') {
   	     $("#cabaretier_id").hide();
	     $("#concert_id").hide();
	     $("#theatervoorstelling_id").show();
	    }
	});
	
	
});

