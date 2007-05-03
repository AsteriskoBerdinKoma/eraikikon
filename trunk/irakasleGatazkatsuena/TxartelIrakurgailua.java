package irakasleGatazkatsuena;

import java.util.*;

public class TxartelIrakurgailua {

	private int id;
	private Atea atea;
	private Vector<SarbideEskaera> sarbideEskaerak;
	//private Gunea gunea;
	
	
	//Eraikitzailea	
	public TxartelIrakurgailua(int txartelIrakurgailuId)
	{
		this.id = txartelIrakurgailuId;
		this.sarbideEskaerak = new Vector<SarbideEskaera>();
	}
	
	//Txartel Irakurgailuaren IDa itzultzen du
	public int getId()
	{
		return id;
	}
	
	//Txartel Irakurgailuaren Atea itzultzen du	
	public Atea getAtea()
	{
		return atea;
	}

	//Txartel Irakurgailuaren Sarbide Eskaerak  itzultzen ditu bektore batean
	public Vector getSarbideEskaerak()
	{
		return this.sarbideEskaerak;
	}

	//Txartel Irakurgailuari Sarbide Eskaera bat gehitzen dio
	public void addSarbideEskaera(SarbideEskaera sarbEsk)
	{
		this.sarbideEskaerak.add(sarbEsk);
	}
}
