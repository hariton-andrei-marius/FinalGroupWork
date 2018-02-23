/*package start.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.ui.Model;

import start.modules.Procedures;

public class ProceduresTest
{
	@Test
	public void testIndexCreateWeather()
	{
		Model model = new Model();
		
		Procedures.indexCreateWeather(model, "", 1);
		
		assert(model.containsAttribute("weather"));
	}
	
	@Test
	public void testIndexCreateDate()
	{
		Model model = new Model();
		
		Procedures.indexCreateDate(model, new Locale());
		
		assert(model.containsAttribute("month"));
	}
}*/