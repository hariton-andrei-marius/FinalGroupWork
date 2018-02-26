package start.modules;

import java.net.URI;
import java.net.URISyntaxException;

import start.services.ApiConfiguration;

public class RestApi
{
	public static URI getWeatherURIbyCity(String cityToSearch, String language) throws URISyntaxException
	{
		return new URI(
			"https",
			ApiConfiguration.getWeatherAuthority(),
			ApiConfiguration.getWeatherPath(),
			ApiConfiguration.getWeatherQueryByCity()
				+ cityToSearch + "&lang=" + language,
			""
		);
	}
	
	public static URI getWeatherURIbyID(int cityID, String language) throws URISyntaxException
	{
		return new URI(
			"https",
			ApiConfiguration.getWeatherAuthority(),
			ApiConfiguration.getWeatherPath(),
			ApiConfiguration.getWeatherQueryByID()
			+ cityID + "&lang=" + language,
			""
		);
	}

	public static URI getCityDetailsURI(String cityToSearch) throws URISyntaxException
	{
		return new URI(
			"https",
			ApiConfiguration.getCityDetailsAuthority(),
			ApiConfiguration.getCityDetailsPathCities(),
			ApiConfiguration.getCityDetailsQuery() + cityToSearch  + "&limit=10",
			""
		);
	}
	
	public static URI getImagesURI(String cityToSearch) throws URISyntaxException
	{
		return new URI(
			"https",
			ApiConfiguration.getCityDetailsAuthority(),
			ApiConfiguration.getCityDetailsPathImages()
			+cityToSearch+ApiConfiguration.getCityDetailsImageUrl(),
			"",
			""
		);
	}
	
	public static URI getForecastURIbyCity(String cityToSearch, String language) throws URISyntaxException
	{
		return new URI(
			"https",
			ApiConfiguration.getWeatherAuthority(),
			ApiConfiguration.getForecastPath(),
			ApiConfiguration.getWeatherQueryByCity()
			+ cityToSearch + "&lang=" + language,
			""
		);
	}
	
	public static URI getForecastURIbyID(int cityID, String language) throws URISyntaxException
	{
		return new URI(
			"https",
			ApiConfiguration.getWeatherAuthority(),
			ApiConfiguration.getForecastPath(),
			ApiConfiguration.getWeatherQueryByID()
			+ cityID + "&lang=" + language,
			""
		);
	}
	
	public static URI getPositionURI(String ip) throws URISyntaxException
	{
		return new URI(
			"http",
			ApiConfiguration.getGeoIPauthority(),
			ApiConfiguration.getGeoIPpath() + ip,
			"",
			""
		);
	}
	
	public static URI getExternalIPuri() throws URISyntaxException
	{
		return new URI(
			"http",
			ApiConfiguration.getExternalIP(),
			"",
			"",
			""
		);
	}
}

