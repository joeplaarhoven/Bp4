$( document ).ready(function() {
	$("#cabaretierPref").hide();
	$("#concertPref").hide();
	$("#theatervoorstellingPref").hide();
	
	$('#prefrence').change(function() {
        console.log(this.checked)
        if(this.checked == true){
        	$("#cabaretierPref").show();
        	$("#concertPref").show();
        	$("#theatervoorstellingPref").show();
        	
        	$("#cabaretier").hide();
        	$("#concert").hide();
        	$("#theatervoorstelling").hide();
        }
        else{
        	$("#cabaretierPref").hide();
        	$("#concertPref").hide();
        	$("#theatervoorstellingPref").hide();
        	
        	$("#cabaretier").show();
        	$("#concert").show();
        	$("#theatervoorstelling").show();
        }
        
    });
	
	
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
        else{
        	$("#cabaretier").show();
        	$("#concert").show();
        	$("#theatervoorstelling").show();
        }
        
    });
	
	$("select#leeftijdscategorie").change(function(){
		
        var selectedLeeftijd = $(this).children("option:selected").val();
        $("#cabaretier tr:gt(0)").each(function () {
            var this_row = $(this);
            var leeftijdsCategorie = $.trim(this_row.find('td:eq(2)').html())
            if (leeftijdsCategorie != selectedLeeftijd){
             $(this).hide()
            }
            else{
            	$(this).show()
            }
        });
        
        
    });
	
	$("select#afkomst").change(function(){
		
        var selectedAfkomst = $(this).children("option:selected").val();
        $("#cabaretier tr:gt(0)").each(function () {
            var this_row = $(this);
            var afkomst = $.trim(this_row.find('td:eq(3)').html())
            
            if (afkomst != selectedAfkomst){
            	$(this).hide()
            }
            else{
            	$(this).show()
            }
        });
        
        
    });
	
	
})