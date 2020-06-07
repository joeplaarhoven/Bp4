package com.example.bp4.Eigenaar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
public class EigenaarController {
    @Autowired
    EigenaarService eigenaarService;

    @RequestMapping("/eigenaar/acceptence")
    public String viewEigenaarAcceptence(Model model) {
        List<Eigenaar> listEigenaar = eigenaarService.listAll();
        model.addAttribute("listEigenaar", listEigenaar);

        return "eigenaarAcceptence";
    }


    @RequestMapping("/eigenaar/{id}")
    public ModelAndView viewEigenaar(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("eigenaarProfile");
        Eigenaar eigenaar = eigenaarService.get(id);
        mav.addObject("eigenaar", eigenaar);

        return mav;
    }



    @RequestMapping("/eigenaar/accept/{id}")
    public String editAcceptEigenaar(@PathVariable(name = "id") int id) {
        eigenaarService.setVerifiedForEigenaar(true, id);

        return "redirect:/";
    }

    @RequestMapping("/eigenaar/deny/{id}")
    public String editDenyEigenaar(@PathVariable(name = "id") int id) {
        eigenaarService.setVerifiedForEigenaar(false, id);

        return "redirect:/";
    }


    @RequestMapping("/eigenaar/aanvraag")
    public String showNewProductPage(Model model) {
    	Eigenaar eigenaar = new Eigenaar();
        model.addAttribute("eigenaar", eigenaar);

        return "eigenaarAanvraag";
    }

    @RequestMapping(value = "/eigenaar/save", method = RequestMethod.POST)
    public String saveProduct(@RequestParam("eigenaar_voornaam") String eigenaar_voornaam,
                              @RequestParam("eigenaar_achternaam") String eigenaar_achternaam,
                              @RequestParam("woonplaats") String woonplaats,
                              @RequestParam("telefoonnummer") String telefoonnummer,
                              @RequestParam("emailadres") String emailadres,
                              @RequestParam("wachtwoord") String wachtwoord) {
    	Eigenaar eigenaar = new Eigenaar(eigenaar_voornaam, eigenaar_achternaam, woonplaats, telefoonnummer, emailadres, encryptWachtwoord(wachtwoord), false);
        eigenaarService.save(eigenaar);

        return "redirect:/";
    }
    
    /**
     * Encrypt het wachtwoord met SHA-256
     * @param wachtwoord String om te encrypten
     * @return String encryptie
     */
    public static String encryptWachtwoord(String wachtwoord) {
    	try {
	    	MessageDigest digest = MessageDigest.getInstance("SHA-256");
	    	byte[] encodedhash = digest.digest(
	    			wachtwoord.getBytes(StandardCharsets.UTF_8));
	        StringBuffer hexString = new StringBuffer();
	        for (int i = 0; i < encodedhash.length; i++) {
	        String hex = Integer.toHexString(0xff & encodedhash[i]);
	        if(hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
	        }
	        return hexString.toString();
    	} catch (Exception e) {
    		return wachtwoord;
		}
    }
    
    @RequestMapping(value = "/eigenaar/login/confirm", method = RequestMethod.POST)
    public String loginEigenaar(@RequestParam("emailadres") String emailadres,
            					@RequestParam("wachtwoord") String wachtwoord) {
    	String str = eigenaarService.checkEigenaarLogin(emailadres, encryptWachtwoord(wachtwoord));
    	if (str.equals(emailadres+","+encryptWachtwoord(wachtwoord))) {
    		System.out.println("FLakka je bent ingelogd met : " + encryptWachtwoord(wachtwoord));
    		return "redirect:/";
    	} else {
    		System.out.println("leer inloggen fzo");
    		return "redirect:/eigenaar/login";
    	}    
    }
    
    @RequestMapping("/eigenaar/login")
    public String showNewEigenaarLoginPage(Model model) {
    	Eigenaar eigenaar = new Eigenaar();
    	model.addAttribute("eigenaar", eigenaar);
        return "eigenaarLogin";
    }
    
}
