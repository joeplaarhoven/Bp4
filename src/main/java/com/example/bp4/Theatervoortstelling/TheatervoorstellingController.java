package com.example.bp4.Theatervoortstelling;

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
public class TheatervoorstellingController {
	
	@Autowired
    private TheatervoorstellingService theatervoorstellingService;

    @RequestMapping("/theatervoorstelling")
    public String viewHomePage(Model model) {
        List<Theatervoorstelling> listTheatervoorstelling = theatervoorstellingService.listAll();
        model.addAttribute("listTheatervoorstelling", listTheatervoorstelling);

        return "index";
    }
    
    @RequestMapping("/theatervoorstelling/{theatervoorstelling_id}")
    public ModelAndView viewProfileTheatervoorstelling(@PathVariable(name = "theatervoorstelling_id") int theatervoorstelling_id) {
        ModelAndView mav = new ModelAndView("TheatervoorstellingWeergeven");
        Theatervoorstelling theatervoorstelling = theatervoorstellingService.getOneTheatervoorstelling(theatervoorstelling_id);
        mav.addObject("theatervoorstelling", theatervoorstelling);

        return mav;
    }
    
    @RequestMapping("/theatervoorstelling/toevoegen")
    public String showNewProductPage(Model model) {
        Theatervoorstelling theatervoorstelling = new Theatervoorstelling();
        model.addAttribute("theatervoorstelling", theatervoorstelling);

		return "TheatervoorstellingToevoegen";
    }

    @RequestMapping(value = "/theatervoorstelling/save", method = RequestMethod.POST)
    public String saveTheatervoorstelling(@RequestParam("theatervoorstelling_naam") String theatervoorstelling_naam,
            @RequestParam("acteurs") String acteurs,
            @RequestParam("productie_afkomst") String productie_afkomst) {
    	Theatervoorstelling theatervoorstelling = new Theatervoorstelling(theatervoorstelling_naam, acteurs, productie_afkomst, 0);
    	theatervoorstellingService.save(theatervoorstelling);

    	return "redirect:/";
    }
	
}
