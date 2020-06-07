package com.example.bp4.Theater;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bp4.Gebruikers.Gebruiker;
import com.example.bp4.Gebruikers.GebruikerService;

@Controller
public class TheaterController {

	@Autowired
	private TheaterService theaterService;

	@Autowired
	private GebruikerService gebruikerService;
	
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

	@RequestMapping("/theater/aanpassen")
	public String showNewGebruikerAanpassen(Model model) {
		Theater theater = new Theater();
		model.addAttribute("theater", theater);

		return "TheaterUpdaten";
	}

	@RequestMapping(value = "/theater/aanpassen/save", method = RequestMethod.POST)
	public String updateTheater(@RequestParam("theaternaam") String t_theaternaam,
			@RequestParam("straatnaam") String t_straatnaam,
			@RequestParam("huisnummer") int t_huisnummer,
			@RequestParam("postcode") String t_postcode,
			@RequestParam("plaats") String t_plaats,
			@RequestParam("theater_id") int t_theater_id) {
		theaterService.updateTheater(t_theaternaam, t_straatnaam, t_huisnummer, t_postcode, t_plaats, t_theater_id);

		return "redirect:/";
	}

  @RequestMapping("/theater/aanpassen/{id}")
  public ModelAndView showAanpassenGebruikerPage(@PathVariable(name = "id") int id) {
      ModelAndView mav = new ModelAndView("TheaterUpdaten");
      Theater theater = theaterService.get(id);
      mav.addObject("theater", theater);

      return mav;
  }

	@RequestMapping("/theaters")
    public String viewAllTheaters(Model model) {
		List<Theater> listTheaters = theaterService.listAll();
	    model.addAttribute("listTheaters", listTheaters);

	    return "Theaters";
    }
	
}
