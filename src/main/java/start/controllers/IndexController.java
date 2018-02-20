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

		@RequestParam(value = "city", required = false, defaultValue = "bologna") String city,
		@RequestParam(value = "id", required = false, defaultValue = "3181928") int id)
	{
		Object images = null;
		Object weather = null;
		Object forecast = null;
		
		try
		{
			images = new RestTemplate().getForObject(RestApi.getImagesURI(city), Object.class);
			weather = new RestTemplate().getForObject(RestApi.getWeatherURIbyID(id), Object.class);
			forecast = new RestTemplate().getForObject(RestApi.getForecastURIbyID(id), Object.class);
		}
		catch (RestClientException | URISyntaxException e)
		{
			images = e.getMessage();
			weather = e.getMessage();
			forecast = e.getMessage();
		}
		
		model.addAttribute("weather", weather);
		model.addAttribute("images", images);
    	
		return "index";
	}

}
