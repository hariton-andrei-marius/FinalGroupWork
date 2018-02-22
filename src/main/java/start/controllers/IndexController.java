package start.controllers;

import java.net.URISyntaxException;
import java.sql.Timestamp;
//import java.util.Calendar;
import java.util.Date;

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
		//Object images = null;
		Object weather = null;
		//Object forecast = null;
		
		try
		{
			//images = new RestTemplate().getForObject(RestApi.getImagesURI(city), Object.class);
			weather = new RestTemplate().getForObject(RestApi.getWeatherURIbyID(id), Object.class);
			//forecast = new RestTemplate().getForObject(RestApi.getForecastURIbyID(id), Object.class);
		}                     
		catch (RestClientException | URISyntaxException e)
		{
			//	images = e.getMessage();
			weather = e.getMessage();
			//	forecast = e.getMessage();
		}

		// ---
		Timestamp stamp = new Timestamp(System.currentTimeMillis()); // DA METTERE 'weather.dt'
		Date date = new Date(stamp.getTime());
		
		//model.addAttribute("images", images);
		model.addAttribute("weather", weather);
		//model.addAttribute("forecast", forecast);
		model.addAttribute("date", date);                                
    	
		return "index";
	}

}
