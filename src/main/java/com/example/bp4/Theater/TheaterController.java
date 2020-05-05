package com.example.bp4.Theater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TheaterController {
	
	@Autowired
	private TheaterService theaterService;
	
	@RequestMapping("/theater/toevoegen")
    public String showNewProductPage(Model model) {
        Theater theater = new Theater();
        model.addAttribute("theater", theater);

        return "TheaterToevoegen";
    }
	
	@RequestMapping(value = "/theater/save", method = RequestMethod.POST)
	public String saveTheater(@RequestParam("theaternaam") String theaternaam,
            @RequestParam("straatnaam") String straatnaam,
            @RequestParam("huisnummer") Integer huisnummer,
            @RequestParam("postcode") String postcode,
            @RequestParam("plaats") String plaats) {
		Theater theater = new Theater(theaternaam, straatnaam, huisnummer, postcode, plaats);
		theaterService.save(theater);

		return "redirect:/";
	}
}
