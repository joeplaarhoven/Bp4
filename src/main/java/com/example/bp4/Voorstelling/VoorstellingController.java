package com.example.bp4.Voorstelling;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bp4.Theater.Theater;
import com.example.bp4.Theater.TheaterService;

import com.example.bp4.Theaterzaal.Theaterzaal;
import com.example.bp4.Theaterzaal.TheaterzaalService;


@Controller
public class VoorstellingController {
	
	@Autowired
    private VoorstellingService voorstelligService;
	
	@Autowired
    private TheaterService theaterService;
	
	@Autowired
    private TheaterzaalService theaterzaalService;
	
	@RequestMapping("/voorstelling/inplannen")
    public String showNewVoorstellingPage(Model model, HttpServletRequest request, @RequestParam(required = false) String theaternaam) {
        Voorstelling voorstelling = new Voorstelling();
        model.addAttribute("voorstelling", voorstelling);
        
        Theater theater = new Theater();
        model.addAttribute("theater", theater);
        
        List<Theater> theaterList = theaterService.listAll();
        model.addAttribute("theaterList", theaterList);
        
        
        
        System.out.println(theaternaam);
        model.addAttribute("theaternaam", theaternaam);
        if(theaternaam != null) {
        	List<Theaterzaal> theaterZaalList = theaterzaalService.alltheaterzalen(theaternaam);
            model.addAttribute("theaterZaalList", theaterZaalList);
        }
        

        return "voorstellingCreate";
    }
	
	
	
	@RequestMapping(value = "/voorstelling/theater/save", method = RequestMethod.POST)
	public ModelAndView redirectWithUsingRedirectPrefix(ModelMap model, @RequestParam("theaternaam") String theaternaam) {
        model.addAttribute("theaternaam", theaternaam);
        return new ModelAndView("redirect:/voorstelling/inplannen/", model);
    }
	
	
	
	
	
	@RequestMapping(value = "/voorstelling/save", method = RequestMethod.POST)
    public String saveProduct(@RequestParam("theaterzaal_id") Integer theaterzaal_id,
                              @RequestParam("voorstellingSoort") String voorstellingSoort,
                              @RequestParam("leeftijdsCat") String leeftijdsCat,
                              @RequestParam("afkomst") String afkomst,
                              @RequestParam("datum") String datum,
                              @RequestParam("tijd") String tijd) {
		
		
        Voorstelling voorstelling = new Voorstelling(theaterzaal_id, voorstellingSoort, leeftijdsCat, afkomst, datum, tijd);
        voorstelligService.save(voorstelling);

        return "redirect:/";
    }
}
