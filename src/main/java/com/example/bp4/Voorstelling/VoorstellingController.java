package com.example.bp4.Voorstelling;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bp4.Cabaretier.Cabaretier;
import com.example.bp4.Cabaretier.CabaretierService;
import com.example.bp4.Concert.Concert;
import com.example.bp4.Concert.ConcertService;
import com.example.bp4.Gebruikers.GebruikerService;
import com.example.bp4.KaartVerkoop.KaartVerkoop;
import com.example.bp4.KaartVerkoop.KaartVerkoopService;
import com.example.bp4.Theater.Theater;
import com.example.bp4.Theater.TheaterService;
import com.example.bp4.Theatervoortstelling.Theatervoorstelling;
import com.example.bp4.Theatervoortstelling.TheatervoorstellingService;
import com.example.bp4.Theaterzaal.Theaterzaal;
import com.example.bp4.Theaterzaal.TheaterzaalService;


@Controller
public class VoorstellingController {
	 
	@Autowired
    private VoorstellingService voorstelligService;
	
	@Autowired
    private TheaterService theaterService;
	
	@Autowired
    private TheaterzaalService theaterzaalService;
	
	@Autowired
    private GebruikerService gebruikerService;
	
	@Autowired
    private CabaretierService cabaretierService;
	
	@Autowired
    private ConcertService concertService;
	
	@Autowired
    private KaartVerkoopService kaartVerkoopService;
	
	@Autowired
    private TheatervoorstellingService theaterVoorstellingService;
	
	String gebruikersnaam;
	
	//onderscheppen als de pagina met de link hier onder geladen wordt, zodat de functie uitgevoerdt word
	@RequestMapping("/voorstellingen")
    public String viewHomePage(Model model, HttpServletRequest request, @CookieValue(name = "gebruiker", defaultValue="") String gebruiker) {
		
		//kijken of de gebruiker is ingelogd
		if(!gebruiker.equals("")) {
			//data ophalen met persoonlijke voorkeur
			List<Cabaretier> listCabaretiers = voorstelligService.getCabaretierVoorstellingenWithPrefrence(gebruiker);
	        model.addAttribute("listCabaretiersPref", listCabaretiers);
	       
	        List<Concert> listConcert = voorstelligService.getConcertVoorstellingenWithPrefrence(gebruiker);
	        model.addAttribute("listConcertPref", listConcert);
	        
	        List<Theatervoorstelling> listTheatervoorstelling = voorstelligService.getTheaterVoorstellingenWithPrefrence(gebruiker);
	        model.addAttribute("listTheatervoorstelling Pref", listTheatervoorstelling);
	        
		}
		//alle voorstellingen ophalen
		List<Cabaretier> listCabaretiers = voorstelligService.getCabaretierVoorstellingen();
        model.addAttribute("listCabaretiers", listCabaretiers);
       

        List<Concert> listConcert = voorstelligService.getConcertVoorstellingen();
        model.addAttribute("listConcert", listConcert);
        
        List<Theatervoorstelling> listTheatervoorstelling = voorstelligService.getTheaterVoorstellingen();
        model.addAttribute("listTheatervoorstelling", listTheatervoorstelling);
	
    
        //cookies ophalen
        Cookie[] test = request.getCookies();
        model.addAttribute("gebruiker", gebruiker);
        
        gebruikersnaam = gebruiker;
        Integer gebruikersId = gebruikerService.getGebruikerId(gebruikersnaam);
        
        return "overzichtVoorstellingen";
    }
	
	//onderscheppen als de pagina met de link hier onder geladen wordt, zodat de functie uitgevoerdt word
	@RequestMapping("/mijnKaarten")
    public String viewMijnKaarten(Model model, HttpServletRequest request, @CookieValue(name = "mijnKaarten", defaultValue="") String gebruiker) {
		Integer gebruikersId = gebruikerService.getGebruikerId(gebruiker);
		
		//voorstellingen ophalen waar een gebruiker kaartjes voor heeft
		List<Cabaretier> listCabaretiers = voorstelligService.getCabaretierKaart(gebruikersId);
        model.addAttribute("listCabaretiers", listCabaretiers);
       

        List<Concert> listConcert = voorstelligService.getConcertKaart(gebruikersId);
        model.addAttribute("listConcert", listConcert);
        
        List<Theatervoorstelling> listTheatervoorstelling = voorstelligService.getTheatervoorstellingenKaart(gebruikersId);
        model.addAttribute("listTheatervoorstelling", listTheatervoorstelling);
        
        Cookie[] test = request.getCookies();
        model.addAttribute("gebruiker", gebruiker);
        
        
        
        
        return "mijnKaarten";
    }
	
	
	
	//onderscheppen als de pagina met de link hier onder geladen wordt, zodat de functie uitgevoerdt word
	@RequestMapping(value = "/voorstellingen/kaartverkoop/{id}")
	public String kaartverkoop(ModelMap model, @PathVariable(name = "id") int voorstellingId, @CookieValue(name = "gebruiker", defaultValue="") String gebruiker) {
		
		
		Integer gebruikersId = gebruikerService.getGebruikerId(gebruiker);
		//kaartverkoop aanmaken
		KaartVerkoop kaartVerkoop = new KaartVerkoop(gebruikersId, voorstellingId);
		//kaart opslaan in kaartverkoop
		Boolean succes = kaartVerkoopService.save(kaartVerkoop);
		//checken of opslaan gelukt is
		if(succes.equals(true)) {
			return "redirect:/mijnKaarten";
		}
		else {
			return "redirect:/voorstellingen";
		}
		
    }
	
	//onderscheppen als de pagina met de link hier onder geladen wordt, zodat de functie uitgevoerdt word
	@RequestMapping(value = "/voorstellingen/kaartverkoop/annuleren/{id}")
	public String kaartverkoopAnnuleren(ModelMap model, @PathVariable(name = "id") int voorstellingId, @CookieValue(name = "gebruiker", defaultValue="") String gebruiker) {
		
		Integer gebruikersId = gebruikerService.getGebruikerId(gebruiker);
		KaartVerkoop kaartVerkoop = new KaartVerkoop(gebruikersId, voorstellingId);
		//kaart verwijderen zodat hij niet meer in de database staat.
		kaartVerkoopService.delete(gebruikersId, voorstellingId);
		
		return "redirect:/mijnKaarten";
		
    }
	
	//onderscheppen als de pagina met de link hier onder geladen wordt, zodat de functie uitgevoerdt word
	@RequestMapping("/voorstelling/inplannen")
    public String showNewVoorstellingPage(Model model, HttpServletRequest request, @RequestParam(required = false) String theaternaam) {
		
		
		Voorstelling voorstelling = new Voorstelling();
        model.addAttribute("voorstelling", voorstelling);
        
        Theater theater = new Theater();
        model.addAttribute("theater", theater);
        
        //ophalen van theaters
        List<Theater> theaterList = theaterService.listAll();
        model.addAttribute("theaterList", theaterList);
        
        

        model.addAttribute("theaternaam", theaternaam);
        
        //ophalen van theaterzalen als theater is geselecteerd
        if(theaternaam != null) {
        	List<Theaterzaal> theaterZaalList = theaterzaalService.alltheaterzalen(theaternaam);
            model.addAttribute("theaterZaalList", theaterZaalList);
        }
        

        return "voorstellingCreate";
    }
	
	
	
	
	//onderscheppen als de pagina met de link hier onder geladen wordt, zodat de functie uitgevoerdt word
	@RequestMapping(value = "/voorstelling/theater/save", method = RequestMethod.POST)
	public ModelAndView redirectWithUsingRedirectPrefix(ModelMap model, @RequestParam("theaternaam") String theaternaam) {
        model.addAttribute("theaternaam", theaternaam);
        return new ModelAndView("redirect:/voorstelling/inplannen/", model);
    }
	
	//onderscheppen als de pagina met de link hier onder geladen wordt, zodat de functie uitgevoerdt word
	@RequestMapping(value = "/voorstellingsoort/get", method = RequestMethod.POST)
	public ModelAndView getSelectedVoorstellingSoort(ModelMap model, @RequestParam("theaternaam") String theaternaam) {
        model.addAttribute("theaternaam", theaternaam);
        return new ModelAndView("redirect:/voorstelling/inplannen/", model);
    }
	
	
	
	
	//onderscheppen als de pagina met de link hier onder geladen wordt, zodat de functie uitgevoerdt word
	@RequestMapping(value = "/voorstelling/save", method = RequestMethod.POST)
	//variabelen ophalen vanuit HTML
    public String saveProduct(@RequestParam("theaterzaal_id") String theaterzaalnaam,
                              @RequestParam("voorstellingsoort") String voorstellingSoort,
                              @RequestParam("v_leeftijdscategorie") String leeftijdsCat,
                              @RequestParam("afkomst") String afkomst,
                              @RequestParam("datum") String datum,
                              @RequestParam("tijd") String tijd,
                              @RequestParam(value = "cabaretier_id", required =false) Integer cabaretier_id,
                              @RequestParam(value = "concert_id", required =false) Integer concert_id,
                              @RequestParam(value = "theatervoorstelling_id", required =false) Integer theatervoorstelling_id) {
		
		Voorstelling voorstelling;
		
		Integer theaterzaal_id = theaterzaalService.findTheaterzaalId(theaterzaalnaam);
	
		if(voorstellingSoort.equals("Cabaretier")) {
			//cabaretier data ophalen
			Cabaretier cabaretier = cabaretierService.getOneCabaretier(cabaretier_id);
			
			//cabaretier inplannen
			voorstelling = new Cabaretier(theaterzaal_id, voorstellingSoort, leeftijdsCat, afkomst, datum, tijd, cabaretier_id);
			voorstelligService.saveCabaretierVoorstelling(voorstelling);
		}
		else if(voorstellingSoort.equals("Concert")) {
			//concert data ophalen
			Concert concert = concertService.getOneConcert(concert_id);
			
			//concert inplannen
			voorstelling = new Concert(theaterzaal_id, voorstellingSoort, leeftijdsCat, afkomst, datum, tijd, concert_id);
			voorstelligService.saveConcertVoorstelling(voorstelling);
		}
		else {
			//theatervoorstellingen data ophalen
			Theatervoorstelling theaterVoorstelling = theaterVoorstellingService.getOneTheatervoorstelling(theatervoorstelling_id);
			
			//theatervoorstelling inplannen
			voorstelling = new Theatervoorstelling(theaterzaal_id, voorstellingSoort, leeftijdsCat, afkomst, datum, tijd, theatervoorstelling_id);
			voorstelligService.saveTheaterVoorstelling(voorstelling);
		}
		 

        return "redirect:/";
    }
}
