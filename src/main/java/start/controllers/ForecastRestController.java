package start.controllers;

import java.net.URISyntaxException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import start.classes.Forecast;
import start.classes.ForecastWrapper;
import start.modules.RestApi;

@RestController
public class ForecastRestController {

	
	@RequestMapping("/rest/forecast")
	public ForecastWrapper weather(Model model,

		//@RequestParam(value = "city", required = false, defaultValue = "Bologna,it") String city)
		@RequestParam(value = "id", required = false, defaultValue = "3181928") int id) throws Exception
		{
		Forecast results = null;
		ForecastWrapper wrapper= null;
		try
		{
			results = new RestTemplate().getForObject(RestApi.getForecastURIbyID(id), Forecast.class);
			wrapper = new ForecastWrapper();
			wrapper.setLista(results.getList());
			wrapper.getGiorno();
			wrapper.trovaTemp();
//			wrapper.cercaIcona();
			
		}
		catch (RestClientException | URISyntaxException e)
		{
			e.printStackTrace();
		}
    	
		return wrapper;
	}

}
