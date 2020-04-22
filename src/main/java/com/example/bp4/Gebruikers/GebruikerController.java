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
    public String saveProduct(@RequestParam("gebruikerVoornaam") String gebruikerVoornaam,
                              @RequestParam("gebruikerAchternaam") String gebruikerAchternaam,
                              @RequestParam("leeftijd") Integer leeftijd,
                              @RequestParam("afkomst") String afkomst,
                              @RequestParam("leeftijdsCategorie") String leeftijdsCategorie,
                              @RequestParam("gebruikersnaam") String gebruikersnaam,
                              @RequestParam("wachtwoord") String wachtwoord) {
        Gebruiker gebruiker = new Gebruiker(gebruikerVoornaam, gebruikerAchternaam, leeftijd, afkomst, leeftijdsCategorie, gebruikersnaam, wachtwoord);
        gebruikerService.save(gebruiker);

        return "redirect:/";
    }

}
