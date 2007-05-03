package irakasleGatazkatsuena;

import java.util.Calendar;

public class SarbideEskaera {
	
	private Calendar data;
	private boolean baimenduta;
	private String ukapenarenArrazoia;
	private TxartelIrakurgailua txartelIrak;
	private Txartela txartela;
	
	//Eraikitzailea	
	public SarbideEskaera(Calendar sarbDat,boolean sarbBaim,String sarbUk,TxartelIrakurgailua sarbEskTxartIrak,Txartela sarbEskTxart){
		this.data=sarbDat;
		this.baimenduta=sarbBaim;
		this.ukapenarenArrazoia=sarbUk;
		this.txartelIrak=sarbEskTxartIrak;
		this.txartelIrak.addSarbideEskaera(this);
		this.txartela=sarbEskTxart;
		this.txartela.addSarbideEskaerak(this);
	}
	
	//Sarbide Eskaeraren data itzultzen du
	public Calendar getData(){
		return this.data;
	}	 
	
	//Sarbide Eskaera baimendua edo ez izan den itzultzen du	
	public boolean isBaimenduta(){
		return this.baimenduta;
	}

	//Sarbide Eskaeraren ukapenaren arrazoia itzultzen du	
	public String getUkapenarenArrazoia(){
		return this.ukapenarenArrazoia;
	}
	
	//Sarbide Eskaeraren txartela itzultzen du
	public Txartela getTxartela(){
		return this.txartela;
	}
	
	//Sarbide Eskaeraren txartel irakurgailua itzultzen du
	public TxartelIrakurgailua getTxartelIrakurgailua(){
		return this.txartelIrak;
	}
}
