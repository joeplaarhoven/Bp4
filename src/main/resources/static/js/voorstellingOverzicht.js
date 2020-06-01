$( document ).ready(function() {
	$("select#voorstellingSoort").change(function(){

        var selectedSoort = $(this).children("option:selected").val();
        
        if(selectedSoort == "Cabaretier"){
        	$("#cabaretier").show();
        	$("#concert").hide();
        	$("#theatervoorstelling").hide();
        }
        else if(selectedSoort == "Concert"){
        	$("#cabaretier").hide();
        	$("#concert").show();
        	$("#theatervoorstelling").hide();
        }
        else if(selectedSoort == "Theatervoorstelling"){
        	$("#cabaretier").hide();
        	$("#concert").hide();
        	$("#theatervoorstelling").show();
        }
    });
})