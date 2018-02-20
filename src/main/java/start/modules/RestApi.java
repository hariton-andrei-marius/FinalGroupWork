package start.modules;

import java.net.URI;
import java.net.URISyntaxException;

import start.services.ApiConfiguration;

public class RestApi
{
	public static URI getWeatherURI(String cityToSearch) throws URISyntaxException
	{
		return new URI(
				ApiConfiguration.getGlobalScheme(),
				ApiConfiguration.getWeatherAuthority(),
				ApiConfiguration.getWeatherPath(),
				ApiConfiguration.getWeatherQuery() + cityToSearch,
				""
		);
	}

	public static URI getCityDetailsURI(String cityToSearch) throws URISyntaxException
	{
		return new URI(
				ApiConfiguration.getGlobalScheme(),
				ApiConfiguration.getCityDetailsAuthority(),
				ApiConfiguration.getCityDetailsPathCities(),
				ApiConfiguration.getCityDetailsQuery() + cityToSearch,
				""
		);
	}
	
	public static URI getImagesURI(String cityToSearch) throws URISyntaxException
	{
		return new URI(
				ApiConfiguration.getGlobalScheme(),
				ApiConfiguration.getCityDetailsAuthority(),
				ApiConfiguration.getCityDetailsPathImages()
				+cityToSearch+ApiConfiguration.getCityDetailsImageUrl(),
				"",
				""
		);
	}
	
	public static URI getForecastURI(String cityToSearch) throws URISyntaxException
	{
		return new URI(
				ApiConfiguration.getGlobalScheme(),
				ApiConfiguration.getWeatherAuthority(),
				ApiConfiguration.getForecastPath(),
				ApiConfiguration.getWeatherQuery() + cityToSearch,
				""
		);
	}
	
	
}

