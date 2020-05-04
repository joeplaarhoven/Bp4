package com.example.bp4.Theater;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bp4.Gebruikers.Gebruiker;
import com.example.bp4.Theater.Theater;
import com.example.bp4.Theater.TheaterService;

public class TheaterController {
	
	private TheaterService theaterService;
	
	@RequestMapping("/registrerenTheater")
    public String showNewProductPage(Model model) {
        Theater theater = new Theater();
        model.addAttribute("theater", theater);

        return "index";
    }
	
	@RequestMapping(value = "/theater/save", method = RequestMethod.POST)
	public String saveTheater(@RequestParam("theaterNaam") String theaterNaam,
            @RequestParam("straatNaam") String straatNaam,
            @RequestParam("vestiging") Integer vestiging,
            @RequestParam("huisnummer") String huisnummer) {
Theater theater = new Theater(theaterNaam, straatNaam, huisnummer, vestiging);
theaterService.save(theater);

return "redirect:/";
}
}
