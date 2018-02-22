package start.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import groovyjarjarantlr.collections.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
	private Lista[] list;
	private String dataGiorno;
	private LinkedList<LinkedList> listaGiorni;
	private LinkedList<Double> mediaMin, mediaMax;
	
	public Lista[] getList() {
		return list;
	}
	
	public LinkedList<Double> getMediaMin() {
		return mediaMin;
	}
	
	public LinkedList<Double> getMediaMax() {
		return mediaMax;
	}
	
	public void getGiorno() throws ParseException {
		listaGiorni = new LinkedList<LinkedList>();
		String temp;
		for(int i = 0; i < list.length; i++) {
			dataGiorno = list[i].getDt_txt();
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dataGiorno);
			temp = new SimpleDateFormat("dd").format(date);
			LinkedList<Lista> listaPerGiorno = new LinkedList<Lista>();
			while((list[i].getDt_txt().substring(8, 11) == temp) && (i< list.length)) {
				listaPerGiorno.add(list[i]);
				i++;
			}
			listaGiorni.add(listaPerGiorno);
			i--;
		}
	}
	
	public void trovaTemp() {
		Iterator<LinkedList> iterator = listaGiorni.iterator();
		mediaMin = new LinkedList<Double>();
		mediaMax = new LinkedList<Double>();
		while(iterator.hasNext()) {
			LinkedList corrente = iterator.next();
			Iterator<Lista> it = corrente.iterator();
			LinkedList<Double> listaTempMax = new LinkedList<Double>();
			LinkedList<Double> listaTempMin = new LinkedList<Double>();
			int cont = 0;
			while(it.hasNext()) {
				Lista corr = it.next();
				listaTempMin.add(corr.getMain().getTemp_min());
				listaTempMax.add(corr.getMain().getTemp_max());
				cont++;
			}
			mediaMin.add(mediaTemp(listaTempMin, cont));
			mediaMax.add(mediaTemp(listaTempMax, cont));

		}
	}
	
	public double mediaTemp(LinkedList<Double> temperature, int cont) {
		Iterator<Double> iterTemp = temperature.iterator();
		double somma = 0;
		while(iterTemp.hasNext()) {
			Double corrente = iterTemp.next();
			somma += corrente; 
		}
		return (somma/cont);
	}
}
