package com.example.bp4.KaartVerkoop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bp4.Theater.Theater;
import com.example.bp4.Theaterzaal.TheaterzaalService;

public class KaartVerkoopController {
	

	@Autowired
    private KaartVerkoopService kaartVerkoopService;
	
}
