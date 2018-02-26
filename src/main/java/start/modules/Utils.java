package start.modules;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import start.classes.Position;

public class Utils
{
	public static Position getPosition() throws Exception, RestClientException, URISyntaxException
	{
		URL whatismyip = new URL(RestApi.getExternalIPuri().toString());
		
		BufferedReader in = new BufferedReader(
			new InputStreamReader(whatismyip.openStream())
		);

		String ip = in.readLine();
		
		Position results = new RestTemplate().getForObject(RestApi.getPositionURI(ip), Position.class);

		return results;
	}
}
