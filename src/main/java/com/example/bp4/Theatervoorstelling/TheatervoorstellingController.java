package com.example.bp4.Theatervoorstelling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TheatervoorstellingController {
	
    @Autowired
    private TheatervoorstellingService theatervoorstellingService;

	@RequestMapping("/theatervoorstelling/toevoegen")
    public String showNewProductPage(Model model) {
		Theatervoorstelling theatervoorstelling = new Theatervoorstelling();
        model.addAttribute("theatervoorstelling", theatervoorstelling);

        return "TheatervoorstellingToevoegen";
    }
	
	@RequestMapping(value = "/theatervoorstelling/save", method = RequestMethod.POST)
	public String saveTheatervoorstelling(@RequestParam("theatervoorstelling_naam") String theatervoorstelling_naam,
            @RequestParam("acteurs") String acteurs,
            @RequestParam("productieafkomst") String productieafkomst) {
		Theatervoorstelling theatervoorstelling = new Theatervoorstelling(theatervoorstelling_naam, acteurs, productieafkomst);
		theatervoorstellingService.save(theatervoorstelling);

		return "redirect:/";
	}
	
}
