package com.example.bp4.Concert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class ConcertController {
	
	@Autowired
    private ConcertService concertService;

    @RequestMapping("/concert")
    public String viewHomePage(Model model) {
        List<Concert> listConcert = concertService.listAll();
        model.addAttribute("listConcert", listConcert);

        return "index";
    }
    
    @RequestMapping("/concert/toevoegen")
    public String showNewProductPage(Model model) {
        Concert concert = new Concert();
        model.addAttribute("concert", concert);

        return "ConcertToevoegen";
    }

    @RequestMapping(value = "/concert/save", method = RequestMethod.POST)
    public String saveConcert(@RequestParam("concert_naam") String concert_naam,
            @RequestParam("genre") String genre,
            @RequestParam("artiest") String artiest) {
    	Concert concert = new Concert(concert_naam, genre, artiest, 0);
    	concertService.save(concert);

    	return "redirect:/";
    }
	
}
