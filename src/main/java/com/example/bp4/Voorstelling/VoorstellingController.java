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
import com.example.bp4.Eigenaar.Eigenaar;
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
	
	@RequestMapping("/voorstelling/annuleren")
    public String viewVoorstellingAnnuleren(Model model) {
        List<Voorstelling> listVoorstelling = voorstelligService.listAll();
        model.addAttribute("listVoorstelling", listVoorstelling);

        return "voorstellingGeannuleerd";
    }


    @RequestMapping("/voorstelling/annuleren/{id}")
    public String editVoorstelling(@PathVariable(name = "id") int id) {
    	voorstelligService.setGeannuleerdForVoorstelling(true, id);

        return "redirect:/";
    }
	
	@RequestMapping("/voorstellingen")
    public String viewHomePage(Model model, HttpServletRequest request, @CookieValue(name = "gebruiker", defaultValue="") String gebruiker) {
        List<Cabaretier> listCabaretiers = voorstelligService.getCabaretierVoorstellingen(gebruiker);
        model.addAttribute("listCabaretiers", listCabaretiers);
       

        List<Concert> listConcert = voorstelligService.getConcertVoorstellingen(gebruiker);
        model.addAttribute("listConcert", listConcert);
        
        List<Theatervoorstelling> listTheatervoorstelling = voorstelligService.getTheaterVoorstellingen(gebruiker);
        model.addAttribute("listTheatervoorstelling", listTheatervoorstelling);
        
        Cookie[] test = request.getCookies();
        model.addAttribute("gebruiker", gebruiker);
        
        gebruikersnaam = gebruiker;
        Integer gebruikersId = gebruikerService.getGebruikerId(gebruikersnaam);
        
        return "overzichtVoorstellingen";
    }
	
	@RequestMapping("/mijnKaarten")
    public String viewMijnKaarten(Model model, HttpServletRequest request, @CookieValue(name = "mijnKaarten", defaultValue="") String gebruiker) {
		Integer gebruikersId = gebruikerService.getGebruikerId(gebruiker);
		
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
	
	
	
	@RequestMapping(value = "/voorstellingen/kaartverkoop/{id}")
	public String kaartverkoop(ModelMap model, @PathVariable(name = "id") int voorstellingId, @CookieValue(name = "gebruiker", defaultValue="") String gebruiker) {
		Integer gebruikersId = gebruikerService.getGebruikerId(gebruiker);
		KaartVerkoop kaartVerkoop = new KaartVerkoop(gebruikersId, voorstellingId);
		kaartVerkoopService.save(kaartVerkoop);
		return "redirect:/voorstellingen";
    }
	
	
	@RequestMapping("/voorstelling/inplannen")
    public String showNewVoorstellingPage(Model model, HttpServletRequest request, @RequestParam(required = false) String theaternaam) {
		Voorstelling voorstelling = new Voorstelling();
        model.addAttribute("voorstelling", voorstelling);
        
        Theater theater = new Theater();
        model.addAttribute("theater", theater);
        
        List<Theater> theaterList = theaterService.listAll();
        model.addAttribute("theaterList", theaterList);
        
        
        
        System.out.println(theaternaam);
        model.addAttribute("theaternaam", theaternaam);
        if(theaternaam != null) {
        	List<Theaterzaal> theaterZaalList = theaterzaalService.alltheaterzalen(theaternaam);
            model.addAttribute("theaterZaalList", theaterZaalList);
        }
        

        return "voorstellingCreate";
    }
	
	
	
	
	
	@RequestMapping(value = "/voorstelling/theater/save", method = RequestMethod.POST)
	public ModelAndView redirectWithUsingRedirectPrefix(ModelMap model, @RequestParam("theaternaam") String theaternaam) {
        model.addAttribute("theaternaam", theaternaam);
        return new ModelAndView("redirect:/voorstelling/inplannen/", model);
    }
	
	@RequestMapping(value = "/voorstellingsoort/get", method = RequestMethod.POST)
	public ModelAndView getSelectedVoorstellingSoort(ModelMap model, @RequestParam("theaternaam") String theaternaam) {
        model.addAttribute("theaternaam", theaternaam);
        return new ModelAndView("redirect:/voorstelling/inplannen/", model);
    }
	
	
	
	
	
	@RequestMapping(value = "/voorstelling/save", method = RequestMethod.POST)
    public String saveProduct(@RequestParam("theaterzaal_id") String theaterzaalnaam,
                              @RequestParam("voorstellingsoort") String voorstellingSoort,
                              @RequestParam("v_leeftijdscategorie") String leeftijdsCat,
                              @RequestParam("afkomst") String afkomst,
                              @RequestParam("datum") String datum,
                              @RequestParam("tijd") String tijd,
                              @RequestParam(value =  "geannuleerd", required = false) boolean geannuleerd,
                              @RequestParam(value = "cabaretier_id", required =false) Integer cabaretier_id,
                              @RequestParam(value = "concert_id", required =false) Integer concert_id,
                              @RequestParam(value = "theatervoorstelling_id", required =false) Integer theatervoorstelling_id) {
		
		Voorstelling voorstelling;
		
		Integer theaterzaal_id = theaterzaalService.findTheaterzaalId(theaterzaalnaam);
		System.out.print(voorstellingSoort);
		if(voorstellingSoort.equals("Cabaretier")) {
			Cabaretier cabaretier = cabaretierService.getOneCabaretier(cabaretier_id);
			
			voorstelling = new Cabaretier(theaterzaal_id, voorstellingSoort, leeftijdsCat, afkomst, datum, tijd, false, cabaretier_id);
			voorstelligService.saveCabaretierVoorstelling(voorstelling);
		}
		else if(voorstellingSoort.equals("Concert")) {
			Concert concert = concertService.getOneConcert(concert_id);
			
			voorstelling = new Concert(theaterzaal_id, voorstellingSoort, leeftijdsCat, afkomst, datum, tijd, false, concert_id);
			voorstelligService.saveConcertVoorstelling(voorstelling);
		}
		else {
			Theatervoorstelling theaterVoorstelling = theaterVoorstellingService.getOneTheatervoorstelling(theatervoorstelling_id);
			
			voorstelling = new Theatervoorstelling(theaterzaal_id, voorstellingSoort, leeftijdsCat, afkomst, datum, tijd, false, theatervoorstelling_id);

			voorstelligService.saveTheaterVoorstelling(voorstelling);
		}
		 

        return "redirect:/";
    }
}
