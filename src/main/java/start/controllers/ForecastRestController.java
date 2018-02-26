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
import start.classes.Language;
import start.modules.RestApi;
import start.modules.Utils;

@RestController
public class ForecastRestController {


	@RequestMapping("/rest/forecast")
	public ForecastWrapper weather(Model model,
		@RequestParam(value = "id", required = false, defaultValue = "3181928") int id) throws RestClientException, URISyntaxException, Exception
	{
		// Language
		String language = new Language().getLanguage(Utils.getPosition().getCountry_code());

		Forecast results = null;
		ForecastWrapper wrapper= null;

		results = new RestTemplate().getForObject(RestApi.getForecastURIbyID(id, language), Forecast.class);
		wrapper = new ForecastWrapper();
		wrapper.setLista(results.getList());
		wrapper.getGiorno();
		wrapper.trovaTemp();
		wrapper.cercaIcona();
		wrapper.salvaIcona();
		wrapper.setData();

		return wrapper;
	}

}
