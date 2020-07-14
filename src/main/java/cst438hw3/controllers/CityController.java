package cst438hw3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cst438hw3.domain.CityInfo;
import cst438hw3.service.CityService;

@Controller
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	@GetMapping("/cities/{city}")
	public String getWeather(@PathVariable("city") String cityName, Model model) {

		CityInfo result = cityService.getCityInfo(cityName);
		if(result == null) {
			return "noCity";
		} else {
			model.addAttribute("city", result);
			return "city";
		}
	}	
}
