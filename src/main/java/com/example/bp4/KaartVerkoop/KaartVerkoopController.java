package com.example.bp4.KaartVerkoop;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bp4.Cabaretier.Cabaretier;
import com.example.bp4.Concert.Concert;
import com.example.bp4.Gebruikers.GebruikerService;
import com.example.bp4.Theater.Theater;
import com.example.bp4.Theatervoortstelling.Theatervoorstelling;
import com.example.bp4.Theaterzaal.TheaterzaalService;

@Controller
public class KaartVerkoopController {
	

	@Autowired
    private KaartVerkoopService kaartVerkoopService;
	
	@Autowired
    private GebruikerService gebruikerService;
	
}
