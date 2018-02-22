package start.controllers;

import java.net.URISyntaxException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import start.classes.Forecast;
import start.modules.RestApi;

@RestController
public class ForecastRestController {

	
	@RequestMapping("/rest/forecast")
	public Forecast weather(Model model,

		@RequestParam(value = "city", required = false, defaultValue = "Bologna,it") String city)
	{
		Forecast results = null;
		
		try
		{
			results = new RestTemplate().getForObject(RestApi.getForecastURIbyCity(city), Forecast.class);
		}
		catch (RestClientException | URISyntaxException e)
		{
			e.printStackTrace();
		}
    	
		return results;
	}

}
