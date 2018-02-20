package start.controllers;

import java.net.URISyntaxException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import start.modules.RestApi;

@RestController
public class WeatherRestController {
	
	@RequestMapping("/rest/weather")
	public Object weather(Model model,

		@RequestParam(value = "city", required = false, defaultValue = "Bologna,it") String city)
	{
		Object results = null;
		
		try
		{
			results = new RestTemplate().getForObject(RestApi.getWeatherURIbyCity(city), Object.class);
		}
		catch (RestClientException | URISyntaxException e)
		{
			results = e.getMessage();
		}
    	
		return results;
	}

}
