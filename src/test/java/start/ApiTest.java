package start;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApiTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testWeather() throws Exception {
		mockMvc.perform(get("/rest/weather").param("id", "3181928"))
				.andExpect(content().string(containsString("Bologna")));
	}
	
	@Test
	public void testForecast() throws Exception {
		mockMvc.perform(get("/rest/forecast").param("city", "Bologna"))
				.andExpect(content().string(containsString("temp_max")));
	}
	
	@Test
	public void testImages() throws Exception {
		mockMvc.perform(get("/rest/images").param("city", "bologna"))
				.andExpect(content().string(containsString("photos")));
	}
	
	@Test
	public void testCityDetails() throws Exception {
		mockMvc.perform(get("/rest/city_details").param("city", "bologna"))
				.andExpect(content().string(containsString("Bologna")));
	}
	
	@Test
	public void testPosition() throws Exception {
		mockMvc.perform(get("/rest/position"))
				.andExpect(content().string(containsString("country_code")));
	}

}