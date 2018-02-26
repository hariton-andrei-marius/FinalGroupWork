package start.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public class ForecastWrapper {
	
	private Lista[] list;
	private String dataGiorno, formato;
	private LinkedList<LinkedList> listaGiorni;
	private LinkedList<Double> mediaMin, mediaMax;
	private LinkedList<Icone> icone;
	private String [] iconeDefinitive;
	private String [] arrayGiorni;
	
	public ForecastWrapper() {
		mediaMin = new LinkedList<Double>();
		mediaMax = new LinkedList<Double>();
	}
	
	public void setLista (Lista [] list) {
		
		this.list = list;
	}
	
	public Lista[] getList() {
		
		return list;
	}
	
	public LinkedList<Double> getMediaMin() {
		
		return mediaMin;
	}
	
	public LinkedList<Double> getMediaMax() {
		
		return mediaMax;
	}
	
	public String getDataGiorno() {
		
		return dataGiorno;
	}
	

	public LinkedList<LinkedList> getListaGiorni() {
		
		return listaGiorni;
	}
	
	public String[] getIconeDefinitive() {
		
		return iconeDefinitive;
	}
	
	public String[] getArrayGiorni() {
		
		return arrayGiorni;
	}
	
	public void getGiorno() throws ParseException {
		
		listaGiorni = new LinkedList<LinkedList>();
		String temp;
		
		for(int i = 0; i < list.length; i++) {
			
			dataGiorno = list[i].getDt_txt();
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dataGiorno);
			temp = new SimpleDateFormat("dd").format(date);
			LinkedList<Lista> listaPerGiorno = new LinkedList<Lista>();
			formato = temp;
			
			while((i< list.length) && (formato.equals(temp)) ) {
				
				listaPerGiorno.add(list[i]);
				dataGiorno = list[i].getDt_txt();
				Date datenew = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dataGiorno);
				formato = new SimpleDateFormat("dd").format(datenew);
				i++;
			}
			
			listaGiorni.add(listaPerGiorno);
			
			if(i< list.length) i--;	
		}
	}
	
	public void setMediaMin(LinkedList<Double> mediaMin) {
		this.mediaMin = mediaMin;
	}
	
	public void setMediaMax(LinkedList<Double> mediaMax) {
		this.mediaMax = mediaMax;
	}
	
	public void trovaTemp() {
		
		Iterator<LinkedList> iterator = listaGiorni.iterator();

		
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
	
	public void cercaIcona() {
		
		Iterator<LinkedList> iterator = listaGiorni.iterator();
		icone = new LinkedList<Icone>();
		int contGiorno = 0;
		
		while(iterator.hasNext()) {
			
			LinkedList corrente = iterator.next();
			Iterator<Lista> it = corrente.iterator();
			int cont = 0;
			String [] listaIcone = new String[listaGiorni.get(contGiorno).size()];
			
			while(it.hasNext()) {
				
				Lista corr = it.next();
				ForecastWeather weather = corr.getWeather()[0];
				
				listaIcone[cont] = weather.getIcon();
				
				cont++;
			}
			
			icone.add(iconaRipetuta(listaIcone));

			contGiorno++;
		}

	}
	
	public Icone iconaRipetuta(String [] listaIcone) {
		
		int[] conto = new int[listaIcone.length];
		
		for(int i = 0; i<listaIcone.length; i++ ) {
			
			String temp = listaIcone[i];
			conto[i] = 0;
			
			for(int j = 0; j<listaIcone.length; j++) {

				if(temp.equals(listaIcone[j])) {
					
					conto[i]++;
				}
			}
		}
		
		Icone objIcon = new Icone();
		objIcon.setArray(listaIcone, conto);
		
		return objIcon;
	}
	
	public void salvaIcona() {
		
		iconeDefinitive = new String[mediaMin.size()];
		Iterator<Icone> iterator = icone.iterator();
		int cont = 0;
		
		while(iterator.hasNext()) {
			
			Icone corrente = iterator.next();
			iconeDefinitive[cont] = corrente.trovaIconaMaggiore();
			cont++;
		}
	}
	
	public void setData() throws ParseException {
		
		String giornoFix;
		String corrente = "";
		int cont = 0;
		arrayGiorni = new String[mediaMin.size()];
		
		for(int i = 0; i < list.length; i++) {
			
			dataGiorno = list[i].getDt_txt();
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dataGiorno);
			giornoFix = new SimpleDateFormat("dd MMMM").format(date);
			
			if(!(giornoFix.equals(corrente))) {
				
				arrayGiorni[cont] = giornoFix;
				corrente = giornoFix;
				cont++;
			}
		}
	}
}
