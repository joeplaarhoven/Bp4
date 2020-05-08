package com.example.bp4.Cabaretier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class CabaretierController {
	
    @Autowired
    private CabaretierService cabaretierService;

    @RequestMapping("/cabaretier")
    public String viewHomePage(Model model) {
        List<Cabaretier> listCabaretier = cabaretierService.listAll();
        model.addAttribute("listCabaretier", listCabaretier);

        return "index";
    }
    
    @RequestMapping("/cabaretier/toevoegen")
    public String showNewProductPage(Model model) {
        Cabaretier cabaretier = new Cabaretier();
        model.addAttribute("cabaretier", cabaretier);

        return "CabaretierToevoegen";
    }

    @RequestMapping(value = "/cabaretier/save", method = RequestMethod.POST)
    public String saveCabaretier(@RequestParam("cabaretier_voornaam") String cabaretier_voornaam,
            @RequestParam("cabaretier_achternaam") String cabaretier_achternaam,
            @RequestParam("geboortedatum") String geboortedatum,
            @RequestParam("geslacht") String geslacht) {
    	Cabaretier cabaretier = new Cabaretier(cabaretier_voornaam, cabaretier_achternaam, geboortedatum, geslacht, 0);
    	cabaretierService.save(cabaretier);

    	return "redirect:/";
    }
    
}