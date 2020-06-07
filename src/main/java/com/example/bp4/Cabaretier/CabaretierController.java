package com.example.bp4.Cabaretier;

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
public class CabaretierController {
	
    @Autowired
    private CabaretierService cabaretierService;

    @RequestMapping("/cabaretier")
    public String viewHomePage(Model model) {
        List<Cabaretier> listCabaretier = cabaretierService.listAll();
        model.addAttribute("listCabaretier", listCabaretier);

        return "index";
    }
    
    //De pagina van cabaretier toevoegen ophalen
    @RequestMapping("/cabaretier/toevoegen")
    public String showNewProductPage(Model model) {
        Cabaretier cabaretier = new Cabaretier();
        model.addAttribute("cabaretier", cabaretier);

        return "CabaretierToevoegen";
    }
    
    //Opslaan van een cabaretier
    @RequestMapping(value = "/cabaretier/save", method = RequestMethod.POST)
    public String saveCabaretier(@RequestParam("cabaretier_voornaam") String cabaretier_voornaam,
            @RequestParam("cabaretier_achternaam") String cabaretier_achternaam,
            @RequestParam("geboortedatum") String geboortedatum,
            @RequestParam("geslacht") String geslacht) {
    	Cabaretier cabaretier = new Cabaretier(cabaretier_voornaam, cabaretier_achternaam, geboortedatum, geslacht, 0);
    	cabaretierService.save(cabaretier);

    	return "redirect:/";
    }
    
    //Het weergeven van een cabaretier
    @RequestMapping("/cabaretier/{cabaretier_id}")
    public ModelAndView viewProfileCabaretier(@PathVariable(name = "cabaretier_id") int cabaretier_id) {
        ModelAndView mav = new ModelAndView("CabaretierWeergeven");
        Cabaretier cabaretier = cabaretierService.getOneCabaretier(cabaretier_id);
        mav.addObject("cabaretier", cabaretier);

        return mav;
    }
    
    //Het wijzigen van een cabaretier
    @RequestMapping("/cabaretier/{cabaretier_id}/bijwerken")
    public ModelAndView showCabaretierBijwerkenPage(@PathVariable(name = "cabaretier_id") int cabaretier_id) {
        ModelAndView mav = new ModelAndView("CabaretierBijwerken");
        Cabaretier cabaretier = cabaretierService.getOneCabaretier(cabaretier_id);
        mav.addObject("cabaretier", cabaretier);

        return mav;
    }
    
    //De wijzigen van de cabaretier opslaan
    @RequestMapping(value = "/cabaretier/{cabaretier_id}/bijwerken/save", method = RequestMethod.POST)
    public String cabaretierBijwerken(@RequestParam("cabaretier_id") Integer c_cabaretier_id, 
    		@RequestParam("cabaretier_voornaam") String c_cabaretier_voornaam, 
    		@RequestParam("cabaretier_achternaam") String c_cabaretier_achternaam, 
    		@RequestParam("geboortedatum") String c_geboortedatum, 
    		@RequestParam("geslacht") String c_geslacht) {
    	cabaretierService.cabaretierBijwerken(c_cabaretier_voornaam, c_cabaretier_achternaam, c_geboortedatum, c_geslacht, c_cabaretier_id);

        return "redirect:/";
    }
    
}