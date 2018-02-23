/*package start.tests;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.json.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.json.*;
import org.springframework.test.context.junit4.*;

import static org.assertj.core.api.Assertions.*;

import start.modules.Procedures;

@RunWith(SpringRunner.class)
@JsonTest
public class JSONtest
{
	@Test
	public void testPosition()
	{
		JSONObject data = getRESTData("/json/position_180223.json");
		
		String expected =
		"{\n" + 
		"	\"ip\":\"95.224.118.211\",\n" + 
		"	\"country_code\":\"IT\",\n" + 
		"	\"country_name\":\"Italy\",\n" + 
		"	\"region_code\":\"45\",\n" + 
		"	\"region_name\":\"Emilia-Romagna\",\n" + 
		"	\"city\":\"Bologna\",\n" + 
		"	\"zip_code\":\"40100\",\n" + 
		"	\"time_zone\":\"Europe/Rome\",\n" + 
		"	\"latitude\":44.4833,\n" + 
		"	\"longitude\":11.3333,\n" + 
		"	\"metro_code\":0\n" + 
		"}\n";
		
		JSONAssert.assertEquals(expected, data, false);
	}
}*/