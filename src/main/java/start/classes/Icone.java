package start.classes;

public class Icone {
	
	private String [] nomeIcona;
	private int [] numeroIconaRipetuta;
	
	public String trovaIconaMaggiore() {
		
		int cont=0;
		String temp = "";
		
		for(int i = 0; i < numeroIconaRipetuta.length; i++) {
			
			if(numeroIconaRipetuta[i]> cont) {
				
				cont = numeroIconaRipetuta[i];
				temp = nomeIcona[i];
			}
		}
		
		return temp; 
	}
	
	public String[] getNomeIcona() {
		
		return nomeIcona;
	}
	
	public int[] getNumeroIconaRipetuta() {
		
		return numeroIconaRipetuta;
	}
	
	public void setArray(String[] nomeIcona, int[] numeroIconaRipetuta) {
		
		this.nomeIcona = nomeIcona;
		this.numeroIconaRipetuta = numeroIconaRipetuta;
	}
}
