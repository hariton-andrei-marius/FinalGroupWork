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
public class CityImagesRestController {

	
	@RequestMapping("/rest/images")
	public Object weather(Model model,

		@RequestParam(value = "city", required = false, defaultValue = "bologna") String city)
	{
		Object results = null;
		
		try
		{
			results = new RestTemplate().getForObject(RestApi.getImagesURI(city), Object.class);
		}
		catch (RestClientException | URISyntaxException e)
		{
			results = e.getMessage();
		}
    	
		return results;
	}
	
}
