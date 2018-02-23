package start.modules;

import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.ui.Model;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import start.classes.Weather;

public class Procedures
{
	public static void indexCreateWeather(Model model, String language, int id) throws RestClientException, URISyntaxException
	{
		Weather weather = new RestTemplate().getForObject(RestApi.getWeatherURIbyID(id, language), Weather.class);
		model.addAttribute("weather", weather);
	}
	
	public static void indexCreateDate(Model model, Locale locale)
	{
		Timestamp stamp = new Timestamp(System.currentTimeMillis());
		Date date = new Date(stamp.getTime());
		
		SimpleDateFormat dayFormat = new SimpleDateFormat("dd", locale);
		SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM", locale);
		
		int day = Integer.parseInt(dayFormat.format(date));
		String month = monthFormat.format(date);
		
		model.addAttribute("day", day);
		model.addAttribute("month", month);
	}
}
