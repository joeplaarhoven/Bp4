package com.example.bp4.Gebruikers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
