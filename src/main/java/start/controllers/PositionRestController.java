package start.controllers;

import java.net.URISyntaxException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import start.modules.Utils;

@RestController
public class PositionRestController {
	
	@RequestMapping("/rest/position")
	public Object weather(Model model) throws Exception, RestClientException, URISyntaxException
	{
		return Utils.getPosition();
	}

}
