package irakasleGatazkatsuena;

import java.util.*;

import objektuak.*;


public class Kudeatzailea {
	private Vector<Profila> proVector;
	private Vector<Intzidentzia> intzVector;
	
	//Eraikitzailea	
	public Kudeatzailea(Vector<Profila> vProfilak, Vector<Intzidentzia> vIntzidentzia)
	{
			this.proVector = vProfilak;
			this.intzVector = vIntzidentzia;
	}
	
	//Irakasleak diren erabiltzaileak bektore baten itzultzen ditu
	public Vector<Erabiltzailea> getIrakasleak(){
		for(Profila prof: proVector)
		{
			if (prof.getMota().compareTo("Irakaslea") == 0)
				return prof.getErabiltzaileak();
		}
		return null;
	}
	
	//Erabiltzailearen txartela bi urte baino gehiago baditu txartel hori itzultzen du
	//bestela null itzultzen du
	public Txartela getTxartel2Urte(Erabiltzailea erab){
		Txartela tx = erab.getTxartela();
		//Txartelak behin bakarrik gaitu daitezkenez, gaitu data begiratzen badugu
		//txartela noiz sortu zen jakingo dugu eta bi urte baino gehiago dituen jakingo dugu.
		Calendar txGaituData = tx.getGaituData();
		Calendar data = new GregorianCalendar();
		data.setTime(new Date());
		data.add(Calendar.YEAR, -2);
		if (txGaituData.getTime().before(data.getTime()))
			return tx;
		else
			return null;
	}
	
	//Txartel bati dagozkion azken hilabeteko sarbide eskaera ukatu guztiak itzultzen ditu
	public Vector<SarbideEskaera> getSarbideEskaerak(Txartela tx)
	{
		Vector<SarbideEskaera> vTxSarbEsk = tx.getSarbideEskaerak();
		Vector<SarbideEskaera> hilSarbEskUk = new Vector<SarbideEskaera>();
		Calendar data = new GregorianCalendar();
		data.setTime(new Date());
		data.add(Calendar.MONTH, -1);
		for (SarbideEskaera txSarbEsk:vTxSarbEsk)
		{
			if (txSarbEsk.getData().getTime().after(data.getTime()) && !txSarbEsk.isBaimenduta())
				hilSarbEskUk.add(txSarbEsk);
		}
		return hilSarbEskUk;
	}
	
	//Erabiltzaile baten izena itzultzen du
	public String getIzena(Erabiltzailea erab)
	{
		return erab.getIzena();
	}
	
	//Erabiltzaile baten izena itzultzen du
	public int getIdentifikatzailea(Erabiltzailea erab)
	{
		return erab.getId();
	}
	
	//Txartel baten IDa itzultzen du
	public int getTxartelId(Txartela tx)
	{
		return tx.getId();
	}
	
	//Sarbide eskaera baten Txartel Irakurgailua itzultzen du
	public TxartelIrakurgailua getTxartelIrakurgailua(SarbideEskaera se)
	{
		return se.getTxartelIrakurgailua();
	}
	
	//Txartel Irakurgailu baten IDa itzultzen du
	public int getTxartelIrakurgailuId(TxartelIrakurgailua ti)
	{
		return ti.getId();
	}
	
	//Intzidentzia bat sortzen du eta intzidentzia bektorean sartzen du
	public void createIntzidentzia(int txartelId, int txartelIrakId, String mota)
	{
		if (this.intzVector == null)
			this.intzVector = new Vector<Intzidentzia>();
		String id = "8" + this.intzVector.size();
		int intziId = Integer.parseInt(id);
		Calendar data = new GregorianCalendar();
		data.setTime(new Date());		
		Intzidentzia intz = new Intzidentzia(intziId, data, null, mota, null, txartelId, -1, txartelIrakId, true, null);
		this.intzVector.addElement(intz);
	}
	
	//Intzidentzia guztiak inprimatzen ditu
	public void printIntzidentziak()
	{
		for (Intzidentzia intz: intzVector)
			intz.print();
	}
}
