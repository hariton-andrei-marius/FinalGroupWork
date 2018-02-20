package start.modules;

import java.net.URI;
import java.net.URISyntaxException;

import start.services.ApiConfiguration;

public class RestApi
{
	public static URI getWeatherURIbyCity(String cityToSearch) throws URISyntaxException
	{
		return new URI(
				ApiConfiguration.getGlobalScheme(),
				ApiConfiguration.getWeatherAuthority(),
				ApiConfiguration.getWeatherPath(),
				ApiConfiguration.getWeatherQueryByCity() + cityToSearch,
				""
		);
	}
	
	public static URI getWeatherURIbyID(int cityID) throws URISyntaxException
	{
		return new URI(
				ApiConfiguration.getGlobalScheme(),
				ApiConfiguration.getWeatherAuthority(),
				ApiConfiguration.getWeatherPath(),
				ApiConfiguration.getWeatherQueryByID() + cityID,
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
	
	public static URI getForecastURIbyCity(String cityToSearch) throws URISyntaxException
	{
		return new URI(
				ApiConfiguration.getGlobalScheme(),
				ApiConfiguration.getWeatherAuthority(),
				ApiConfiguration.getForecastPath(),
				ApiConfiguration.getWeatherQueryByCity() + cityToSearch,
				""
		);
	}
	
	public static URI getForecastURIbyID(int cityID) throws URISyntaxException
	{
		return new URI(
				ApiConfiguration.getGlobalScheme(),
				ApiConfiguration.getWeatherAuthority(),
				ApiConfiguration.getForecastPath(),
				ApiConfiguration.getWeatherQueryByID() + cityID,
				""
		);
	}
}

