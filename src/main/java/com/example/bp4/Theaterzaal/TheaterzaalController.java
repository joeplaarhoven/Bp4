package com.example.bp4.Theaterzaal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TheaterzaalController {
	
	@Autowired
	private TheaterzaalService theaterzaalService;
	
	@RequestMapping("/toevoegenTheaterzaal")
    public String showNewProductPage(Model model) {
        Theaterzaal theaterzaal = new Theaterzaal();
        model.addAttribute("theaterzaal", theaterzaal);

        return "TheaterzaalToevoegen";
    }
	
	@RequestMapping(value = "/theaterzaal/save", method = RequestMethod.POST)
	public String saveTheaterzaal(@RequestParam("theaterID") Integer theaterID,
            @RequestParam("zaalnaam") String zaalnaam,
            @RequestParam("zitplaatsen") Integer zitplaatsen) {
		Theaterzaal theaterzaal = new Theaterzaal(theaterID, zaalnaam, zitplaatsen);
		theaterzaalService.save(theaterzaal);

		return "redirect:/";
	}

}
