package cst438hw3.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cst438hw3.domain.*;

@Service
public class CityService {
	
	// ------------------ HW3 Addition Start ------------------
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private FanoutExchange fanout;
	
	public void requestReservation(
			String cityName,
			String level,
			String email) {
		String msg  = "{\"cityName\": \""+ cityName +
				"\" \"level\": \""+level+
				"\" \"email\": \""+email+"\"}" ;
		System.out.println("Sending message:" + msg);
		rabbitTemplate.convertSendAndReceive(
				fanout.getName(),
				"", msg);
	}
	
	
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