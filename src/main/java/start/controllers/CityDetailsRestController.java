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
public class CityDetailsRestController {
	
	@RequestMapping("/rest/city_details")
	public Object cityDetails(Model model,

		@RequestParam(value = "city", required = false) String city) throws RestClientException, URISyntaxException
	{
		Object results = null;
		
		results = new RestTemplate().getForObject(RestApi.getCityDetailsURI(city), Object.class);
    	
		return results;
	}

}