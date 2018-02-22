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

import start.Weather;
import start.modules.RestApi;
import start.modules.Utils;

@Controller
public class IndexController {
	

	@RequestMapping("/index")
	public String weather(Model model,

		@RequestParam(value = "city", required = false, defaultValue = "Bologna") String city,
		@RequestParam(value = "id", required = false, defaultValue = "3181928") int id) throws RestClientException, URISyntaxException, Exception
	{
		Weather weather = new RestTemplate().getForObject(RestApi.getWeatherURIbyID(id), Weather.class);
		Timestamp stamp = new Timestamp(System.currentTimeMillis());
		Date date = new Date(stamp.getTime());
		
		model.addAttribute("weather", weather);
		model.addAttribute("date", date);
		model.addAttribute("position", Utils.getPosition());
    	
		return "index";
	}

}
