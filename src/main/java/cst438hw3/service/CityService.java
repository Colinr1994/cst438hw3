package cst438hw3.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cst438hw3.domain.*;

@Service
public class CityService {
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private WeatherService weatherService;
	
	public CityInfo getCityInfo(String cityName) {
		
		List<City> city = cityRepository.findByName(cityName);
		
		if (city.size() == 0) return null;
		else {
			City tempCity = city.get(0);
			Country tempCountry = countryRepository.findByCode(tempCity.getCountryCode());
			TempAndTime tempAndTime = weatherService.getTempAndTime(cityName);
			return new CityInfo(tempCity, tempCountry.getName(), tempAndTime.getFormTemp(), tempAndTime.getFormTime());
		}
	}
	
}