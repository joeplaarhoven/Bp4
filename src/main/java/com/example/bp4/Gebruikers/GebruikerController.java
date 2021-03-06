package com.example.bp4.Gebruikers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GebruikerController {

    @Autowired
    private GebruikerService gebruikerService;

    //profiel ophalen van bepaalde ID
    @RequestMapping("/profiel/{id}")
    public ModelAndView viewProfileGebruiker(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("profile");
        Gebruiker gebruiker = gebruikerService.get(id);
        mav.addObject("gebruiker", gebruiker);

        return mav;
    }

    //registreren pagina ophalen
    @RequestMapping("/registreren")
    public String showNewProductPage(Model model) {
        Gebruiker gebruiker = new Gebruiker();
        model.addAttribute("gebruiker", gebruiker);

        return "register";
    }

    //opslaan van een nieuwe gebruiker
    @RequestMapping(value = "/gebruiker/save", method = RequestMethod.POST)
    public String saveGebruiker(@RequestParam("gebruiker_voornaam") String gebruiker_voornaam,
                              @RequestParam("gebruiker_achternaam") String gebruiker_achternaam,
                              @RequestParam("geboortedatum") String geboortedatum,
                              @RequestParam("leeftijdscategorie") String leeftijdscategorie,
                              @RequestParam("afkomst") String afkomst,
                              @RequestParam("gebruikersnaam") String gebruikersnaam,
                              @RequestParam("wachtwoord") String wachtwoord) {
        Gebruiker gebruiker = new Gebruiker(gebruiker_voornaam, gebruiker_achternaam, geboortedatum, leeftijdscategorie,
        									afkomst, gebruikersnaam, wachtwoord);
        gebruikerService.save(gebruiker);

        return "redirect:/";
    }

    //aanpassen van gebruiker
    @RequestMapping("/gebruiker/aanpassen/{id}")
    public ModelAndView showAanpassenGebruikerPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("GebruikerAanpassen");
        Gebruiker gebruiker = gebruikerService.get(id);
        mav.addObject("gebruiker", gebruiker);

        return mav;
    }

    //opslaan van aanpassing van gebruiker
    @RequestMapping(value = "/gebruiker/aanpassen/{id}/save", method = RequestMethod.POST)
    public String editGebruiker(@RequestParam("gebruiker_id") Integer gebruiker_id,
    		@RequestParam("gebruiker_voornaam") String gebruiker_voornaam, @RequestParam("gebruiker_achternaam") String gebruiker_achternaam,
    		@RequestParam("geboortedatum") String geboortedatum, @RequestParam("leeftijdscategorie") String leeftijdscategorie, @RequestParam("afkomst") String afkomst,
    		@RequestParam("gebruikersnaam") String gebruikersnaam, @RequestParam("wachtwoord") String wachtwoord) {
        Gebruiker gebruiker = new Gebruiker(gebruiker_id, gebruiker_voornaam, gebruiker_achternaam, geboortedatum, leeftijdscategorie, afkomst, gebruikersnaam, wachtwoord);
        gebruikerService.save(gebruiker);
        
        Integer gebruikersId = gebruikerService.getGebruikerId(gebruikersnaam);
        
        return "redirect:/profiel/" + gebruikersId;
    }

    //login 
    @RequestMapping(value = "/gebruiker/login/confirm", method = RequestMethod.POST)
    public String loginGebruiker(@RequestParam("gebruikersnaam") String gebruikersnaam,
            					@RequestParam("wachtwoord") String wachtwoord,
            					HttpServletResponse response) {
    	String str = gebruikerService.checkGebruikerLogin(gebruikersnaam, wachtwoord);
    	if (str.equals(gebruikersnaam+","+wachtwoord)) {
    		Integer gebruikersId = gebruikerService.getGebruikerId(gebruikersnaam);
    		
    		//set cookies
    		Cookie user = new Cookie("gebruiker", gebruikersnaam);
    		Cookie userId = new Cookie("gebruikerCabaretier", gebruikersId.toString());
    		Cookie userIdMijnKaarten = new Cookie("mijnKaarten", gebruikersnaam);
    		user.setPath("/voorstellingen");
    		userId.setPath("/voorstellingen/kaartverkoop/");
    		userIdMijnKaarten.setPath("/mijnKaarten");
    		
    		response.addCookie(user);
    		response.addCookie(userId);
    		response.addCookie(userIdMijnKaarten);
    		return "redirect:/profiel/" + gebruikersId;
    	} else {
    		return "redirect:/login";
    	}
    }

    @RequestMapping("/login")
    public String showNewLoginPage(Model model) {
    	Gebruiker gebruiker = new Gebruiker();
    	model.addAttribute("gebruiker", gebruiker);
        return "login";
    }

}
