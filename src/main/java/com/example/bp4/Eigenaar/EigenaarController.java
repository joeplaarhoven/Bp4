package com.example.bp4.Eigenaar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EigenaarController {
    @Autowired
    EigenaarService eigenaarService;

    @RequestMapping("/eigenaar/acceptence")
    public String viewEigenaarAcceptence(Model model) {
        List<Eigenaren> listEigenaar = eigenaarService.listAll();
        model.addAttribute("listEigenaar", listEigenaar);

        return "eigenaarAcceptence";
    }


    @RequestMapping("/eigenaar/{id}")
    public ModelAndView viewEigenaar(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("eigenaarProfile");
        Eigenaren eigenaren = eigenaarService.get(id);
        mav.addObject("eigenaar", eigenaren);

        return mav;
    }



    @RequestMapping("/eigenaar/accept/{id}")
    public String editAcceptEigenaar(@PathVariable(name = "id") int id) {
        eigenaarService.setVerifiedForEigenaar(true, id);

        return "redirect:/";
    }

    @RequestMapping("/eigenaar/deny/{id}")
    public String editDenyEigenaar(@PathVariable(name = "id") int id) {
        eigenaarService.setVerifiedForEigenaar(false, id);

        return "redirect:/";
    }


    @RequestMapping("/eigenaar/aanvraag")
    public String showNewProductPage(Model model) {
        Eigenaren eigenaren = new Eigenaren();
        model.addAttribute("eigenaar", eigenaren);

        return "eigenaarAanvraag";
    }

    @RequestMapping(value = "/eigenaar/save", method = RequestMethod.POST)
    public String saveProduct(@RequestParam("eigenaar_voornaam") String eigenaar_voornaam,
                              @RequestParam("eigenaar_achternaam") String eigenaar_achternaam,
                              @RequestParam("woonplaats") String woonplaats,
                              @RequestParam("telefoonnummer") String telefoonnummer,
                              @RequestParam("emailadres") String emailadres,
                              @RequestParam("wachtwoord") String wachtwoord) {
        Eigenaren eigenaren = new Eigenaren(eigenaar_voornaam, eigenaar_achternaam, woonplaats, telefoonnummer, emailadres, wachtwoord, false);
        eigenaarService.save(eigenaren);

        return "redirect:/";
    }
}
