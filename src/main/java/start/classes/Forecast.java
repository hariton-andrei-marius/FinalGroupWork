package start.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
	private Lista[] list;
	private String dataGiorno;
	
	public Lista[] getList() {
		return list;
	}
	
	public void getGiorno() throws ParseException {
		for(int i = 0; i < list.length; i++) {
			dataGiorno = list[i].getDt_txt();
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dataGiorno);
			String newString = new SimpleDateFormat("dd").format(date); 
		}
	
	}
	

}
