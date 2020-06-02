package com.example.bp4.voorstelling;

import java.text.dateformat;
import java.text.simpledateformat;
import java.util.date;
import java.util.list;
import java.util.locale;

import javax.servlet.http.httpservletrequest;

import org.springframework.beans.factory.annotation.autowired;
import org.springframework.stereotype.controller;
import org.springframework.ui.model;
import org.springframework.ui.modelmap;
import org.springframework.web.bind.annotation.pathvariable;
import org.springframework.web.bind.annotation.requestmapping;
import org.springframework.web.bind.annotation.requestmethod;
import org.springframework.web.bind.annotation.requestparam;
import org.springframework.web.servlet.modelandview;

import com.example.bp4.caberetier.caberetier;
import com.example.bp4.caberetier.caberetierservice;
import com.example.bp4.concert.concert;
import com.example.bp4.concert.concertservice;
import com.example.bp4.theater.theater;
import com.example.bp4.theater.theaterservice;
import com.example.bp4.theatervoortstelling.theatervoorstelling;
import com.example.bp4.theatervoortstelling.theatervoorstellingservice;
import com.example.bp4.theaterzaal.theaterzaal;
import com.example.bp4.theaterzaal.theaterzaalservice;


@controller
public class voorstellingcontroller {
	
	@autowired
    private voorstellingservice voorstelligservice;
	
	@autowired
    private theaterservice theaterservice;
	
	@autowired
    private theaterzaalservice theaterzaalservice;
	
	@autowired
    private caberetierservice caberetierservice;
	
	@autowired
    private concertservice concertservice;
	
	@autowired
    private theatervoorstellingservice theatervoorstellingservice;
	
	@requestmapping("/voorstelling/inplannen")
    public string shownewvoorstellingpage(model model, httpservletrequest request, @requestparam(required = false) string theaternaam) {
		voorstelling voorstelling = new voorstelling();
        model.addattribute("voorstelling", voorstelling);
        
        theater theater = new theater();
        model.addattribute("theater", theater);
        
        list<theater> theaterlist = theaterservice.listall();
        model.addattribute("theaterlist", theaterlist);
        
        
        
        system.out.println(theaternaam);
        model.addattribute("theaternaam", theaternaam);
        if(theaternaam != null) {
        	list<theaterzaal> theaterzaallist = theaterzaalservice.alltheaterzalen(theaternaam);
            model.addattribute("theaterzaallist", theaterzaallist);
        }
        

        return "voorstellingcreate";
    }
	
	
	
	@requestmapping(value = "/voorstelling/theater/save", method = requestmethod.post)
	public modelandview redirectwithusingredirectprefix(modelmap model, @requestparam("theaternaam") string theaternaam) {
        model.addattribute("theaternaam", theaternaam);
        return new modelandview("redirect:/voorstelling/inplannen/", model);
    }
	
	
	
	
	
	@requestmapping(value = "/voorstelling/save", method = requestmethod.post)
    public string saveproduct(@requestparam("theaterzaal_id") string theaterzaalnaam,
                              @requestparam("voorstellingsoort") string voorstellingsoort,
                              @requestparam("v_leeftijdscategorie") string leeftijdscat,
                              @requestparam("afkomst") string afkomst,
                              @requestparam("datum") string datum,
                              @requestparam("tijd") string tijd,
                              @requestparam(value = "caberatier_id", required =false) integer caberetier_id,
                              @requestparam(value = "concert_id", required =false) integer concert_id,
                              @requestparam(value = "theatervoorstelling_id", required =false) integer theatervoorstelling_id) {
		
		voorstelling voorstelling;
		
		integer theaterzaal_id = theaterzaalservice.findtheaterzaalid(theaterzaalnaam);
		system.out.print(voorstellingsoort);
		if(voorstellingsoort.equals("caberatier")) {
			caberetier caberetier = caberetierservice.getonecaberetier(caberetier_id);
			
			voorstelling = new caberetier(theaterzaal_id, voorstellingsoort, leeftijdscat, afkomst, datum, tijd, caberetier_id);
		}
		else if(voorstellingsoort.equals("concert")) {
			concert concert = concertservice.getoneconcert(concert_id);
			
			voorstelling = new concert(theaterzaal_id, voorstellingsoort, leeftijdscat, afkomst, datum, tijd, concert_id);
	       
		}
		else {
			theatervoorstelling theatervoorstelling = theatervoorstellingservice.getonetheatervoorstelling(theatervoorstelling_id);
			
			voorstelling = new theatervoorstelling(theaterzaal_id, voorstellingsoort, leeftijdscat, afkomst, datum, tijd, theatervoorstelling_id);
	       
		}
		 voorstelligservice.save(voorstelling);

        return "redirect:/";
    }
}
