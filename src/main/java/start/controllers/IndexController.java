package start.controllers;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import start.classes.Forecast;
import start.classes.Weather;
import start.modules.RestApi;
import start.modules.Utils;

@Controller
public class IndexController {
	

	@RequestMapping("/index")
	public String weather(Model model,

		@RequestParam(value = "city", required = false, defaultValue = "bologna") String city,
		@RequestParam(value = "id", required = false, defaultValue = "3181928") int id) throws Exception
	{
		Weather weather = new RestTemplate().getForObject(RestApi.getWeatherURIbyID(id), Weather.class);
		Timestamp stamp = new Timestamp(System.currentTimeMillis());
		Date date = new Date(stamp.getTime());
		Forecast forecast = new RestTemplate().getForObject(RestApi.getWeatherURIbyID(id), Forecast.class);
		forecast.getGiorno();
		forecast.trovaTemp();
		
		model.addAttribute("weather", weather);
		model.addAttribute("date", date);
		model.addAttribute("position", Utils.getPosition());
    	model.addAttribute("forecast", forecast);
		
		return "index";
	}

}
