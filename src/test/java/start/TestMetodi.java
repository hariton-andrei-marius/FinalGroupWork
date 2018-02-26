package start;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

import org.apache.catalina.LifecycleState;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import start.classes.Forecast;
import start.classes.ForecastWrapper;
import start.classes.Icone;
import start.classes.Language;
import start.modules.RestApi;
import start.modules.Utils;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestMetodi {

	@Autowired
	private MockMvc mockMvc;
	 
	public LinkedList<Double> listaValori() {
		LinkedList<Double> listaTemperature = new LinkedList<Double>();
		listaTemperature.add(1.52);
		listaTemperature.add(4.78);
		listaTemperature.add(-7.3);
		listaTemperature.add(0.45);
		listaTemperature.add(8.00);
		return listaTemperature;
		
	}
	
	@Test
	public void testForecastWrapper() throws Exception {
		
		// ForecastWrapper
		String language = new Language().getLanguage(Utils.getPosition().getCountry_code());
		Forecast results = new RestTemplate().getForObject(RestApi.getForecastURIbyID(3181928, language), Forecast.class);
		ForecastWrapper wrapper = new ForecastWrapper();
		double somma = wrapper.mediaTemp(listaValori(), 5);
		int prova = (int) somma;
		System.out.println("somma effettiva: " + somma);
		
		assert(prova == 1);
	}


}