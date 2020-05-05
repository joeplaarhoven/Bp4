package com.example.bp4.Theater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bp4.Gebruikers.Gebruiker;
import com.example.bp4.Theater.Theater;
import com.example.bp4.Theater.TheaterService;

@Controller
public class TheaterController {
	
	@Autowired
	private TheaterService theaterService;
	
	@RequestMapping("/theater/registreren")
    public String showNewProductPage(Model model) {
        Theater theater = new Theater();
        model.addAttribute("theater", theater);

        return "TheaterToev";
    }
	
	@RequestMapping(value = "/theater/save", method = RequestMethod.POST)
	public String saveTheater(@RequestParam("theaternaam") String theaternaam,
            @RequestParam("straatnaam") String straatnaam,
            @RequestParam("vestiging") String vestiging,
            @RequestParam("huisnummer") Integer huisnummer) {
		Theater theater = new Theater(theaternaam, straatnaam, vestiging, huisnummer);
		theaterService.save(theater);

		return "redirect:/";
	}
}
