package start.controllers;

import java.net.URISyntaxException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import start.classes.Forecast;
import start.classes.Language;
import start.modules.RestApi;
import start.modules.Utils;

@RestController
public class ForecastRestController {

	
	@RequestMapping("/rest/forecast")
	public Forecast weather(Model model,

		@RequestParam(value = "city", required = false, defaultValue = "Bologna,it") String city) throws RestClientException, URISyntaxException, Exception
	{
		// Language
		String language = new Language().getLanguage(Utils.getPosition().getCountry_code());
		
		Forecast results = null;
		
		try
		{
			results = new RestTemplate().getForObject(RestApi.getForecastURIbyCity(city, language), Forecast.class);
		}
		catch (RestClientException | URISyntaxException e)
		{
			e.printStackTrace();
		}
    	
		return results;
	}

}
