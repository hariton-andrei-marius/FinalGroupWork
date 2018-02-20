package start.controllers;

import java.net.URISyntaxException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import start.modules.RestApi;

@Controller
public class IndexController {
	

	@RequestMapping("/index")
	public String weather(Model model,

		@RequestParam(value = "city", required = false, defaultValue = "bologna") String city)
	{
		Object weather = null , images = null;
		
		try
		{
			weather = new RestTemplate().getForObject(RestApi.getWeatherURI(city), Object.class);
			images = new RestTemplate().getForObject(RestApi.getCityDetailsURI(city), Object.class);

		}
		catch (RestClientException | URISyntaxException e)
		{
			weather = e.getMessage();
			images = e.getMessage();

		}
		
		model.addAttribute("weather", weather);
		model.addAttribute("images", images);
    	
		return "index";
	}

}
