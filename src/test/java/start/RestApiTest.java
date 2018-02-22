package start.tests;

import static org.junit.Assert.*;

import java.net.URISyntaxException;

import org.junit.Test;

import start.modules.RestApi;

public class RestApiTest
{
	@Test
	public void testWeatherURI()
	{
		try
		{
			assert(RestApi.getWeatherURIbyCity("bologna").toString().length() == 13);
		}
		catch (URISyntaxException e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCityDetailsURI()
	{
		try
		{
			assert(RestApi.getCityDetailsURI("bologna").toString().length() != 0);
		}
		catch (URISyntaxException e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void testImagesURI()
	{
		try
		{
			assert(RestApi.getImagesURI("bologna").toString().length() == 17);
		}
		catch (URISyntaxException e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testForecastURI()
	{
		try
		{
			assert(RestApi.getForecastURIbyCity("bologna").toString().length() == 13);
		}
		catch (URISyntaxException e)
		{
			e.printStackTrace();
		}
	}
}
