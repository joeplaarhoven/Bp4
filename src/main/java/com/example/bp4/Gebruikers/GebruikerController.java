package com.example.bp4.Gebruikers;

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

    @RequestMapping("/profile/{id}")
    public ModelAndView viewProfileGebruiker(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("profile");
        Gebruiker gebruiker = gebruikerService.get(id);
        mav.addObject("gebruiker", gebruiker);

        return mav;
    }

    @RequestMapping("/registreren")
    public String showNewProductPage(Model model) {
        Gebruiker gebruiker = new Gebruiker();
        model.addAttribute("gebruiker", gebruiker);

        return "register";
    }

    @RequestMapping(value = "/gebruiker/save", method = RequestMethod.POST)
    public String saveGebruiker(@RequestParam("gebruiker_voornaam") String gebruiker_voornaam,
                              @RequestParam("gebruiker_achternaam") String gebruiker_achternaam,
                              @RequestParam("geboortedatum") String geboortedatum,
                              @RequestParam("leeftijdscategorie") String leeftijdscategorie,
                              @RequestParam("afkomst") String afkomst,
                              @RequestParam("gebruikersnaam") String gebruikersnaam,
                              @RequestParam("wachtwoord") String wachtwoord) {
        Gebruiker gebruiker = new Gebruiker(gebruiker_voornaam, gebruiker_achternaam, geboortedatum, leeftijdscategorie, afkomst, gebruikersnaam, wachtwoord);
        gebruikerService.save(gebruiker);

        return "redirect:/";
    }
    
//    @RequestMapping("/gebruiker/aanpassen")
//    public String showNewGebruikerAanpassen(Model model) {
//        Gebruiker gebruiker = new Gebruiker();
//        model.addAttribute("gebruiker", gebruiker);
//
//        return "GebruikerUpdaten";
//    }
//
//    @RequestMapping(value = "/gebruiker/aanpassen/save", method = RequestMethod.POST)
//    public String updateGebruiker(@RequestParam("gebruiker_voornaam") String g_gebruiker_voornaam,
//                              @RequestParam("gebruiker_achternaam") String g_gebruiker_achternaam,
//                              @RequestParam("geboortedatum") String g_geboortedatum,
//                              @RequestParam("leeftijdscategorie") String g_leeftijdscategorie,
//                              @RequestParam("afkomst") String g_afkomst,
//                              @RequestParam("gebruikersnaam") String g_gebruikersnaam,
//                              @RequestParam("wachtwoord") String g_wachtwoord, 
//                              @RequestParam("gebruiker_id") int g_gebruiker_id) {
//        gebruikerService.updateGebruiker(g_gebruiker_voornaam, g_gebruiker_achternaam, g_geboortedatum, g_leeftijdscategorie, g_afkomst, g_gebruikersnaam, g_wachtwoord, g_gebruiker_id);
//        
//        return "redirect:/";
//    }
    
    @RequestMapping("/gebruiker/aanpassen/{id}")
    public ModelAndView showAanpassenGebruikerPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("GebruikerAanpassen");
        Gebruiker gebruiker = gebruikerService.get(id);
        mav.addObject("gebruiker", gebruiker);

        return mav;
    }

    @RequestMapping(value = "/gebruiker/aanpassen/{id}/save", method = RequestMethod.POST)
    public String editGebruiker(@RequestParam("gebruiker_id") Integer gebruiker_id, 
    		@RequestParam("gebruiker_voornaam") String gebruiker_voornaam, @RequestParam("gebruiker_achternaam") String gebruiker_achternaam, 
    		@RequestParam("geboortedatum") String geboortedatum, @RequestParam("leeftijdscategorie") String leeftijdscategorie, @RequestParam("afkomst") String afkomst, 
    		@RequestParam("gebruikersnaam") String gebruikersnaam, @RequestParam("wachtwoord") String wachtwoord) {
        Gebruiker gebruiker = new Gebruiker(gebruiker_id, gebruiker_voornaam, gebruiker_achternaam, geboortedatum, leeftijdscategorie, afkomst, gebruikersnaam, wachtwoord);
        gebruikerService.save(gebruiker);

        return "redirect:/";
    }
    
    @RequestMapping(value = "/gebruiker/login/confirm", method = RequestMethod.POST)
    public String loginGebruiker(@RequestParam("gebruikersnaam") String gebruikersnaam,
            					@RequestParam("wachtwoord") String wachtwoord) {
    	String str = gebruikerService.checkGebruikerLogin(gebruikersnaam, wachtwoord);
    	if (str.equals(gebruikersnaam+","+wachtwoord)) {
    		return "redirect:/";
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
