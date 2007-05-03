package irakasleGatazkatsuena;

import java.util.*;

public class Txartela {

	private int id;
	private Calendar gaituData;
	private Calendar desgaituData;
	private Erabiltzailea erabiltzailea;
	private Vector<SarbideEskaera> sarbideEskaerak;
	
	//Eraikitzailea	
	public Txartela(int txartelId, Erabiltzailea txartelErabiltzailea, Calendar txGaituData)
	{
		this.id = txartelId;
		this.gaituData = txGaituData;
		this.erabiltzailea = txartelErabiltzailea;
		this.erabiltzailea.setTxartela(this);
		this.sarbideEskaerak = new Vector<SarbideEskaera>();
	}
	
	//Txartelaren IDa itzultzen du
	public int getId()
	{
		return id;
	}
	
	//Txartelaren gaitu data itzultzen du
	public Calendar getGaituData()
	{
		return gaituData;
	}

	//Txartelaren desgaitu data itzultzen du	
	public Calendar getDesgaituData()
	{
		return this.desgaituData;
	}

	//Txartelaren erabiltzailea itzultzen du	
	public Erabiltzailea getErabiltzailea()
	{
		return this.erabiltzailea;
	}

	//Txartelaren sarbide eskaerak itzultzen ditu bektore batetan
	public Vector<SarbideEskaera> getSarbideEskaerak()
	{
		return sarbideEskaerak;
	}
	
	//Sarbide eskaera bat gehitzen dio txartelari
	public void addSarbideEskaerak(SarbideEskaera txartelSarbideEskaera)
	{
		sarbideEskaerak.add(txartelSarbideEskaera);
	}
}
