package start.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
	
	private Lista[] list;

	public Lista[] getList() {
		
		return list;
	}
}
