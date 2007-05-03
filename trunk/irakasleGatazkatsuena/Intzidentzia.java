package irakasleGatazkatsuena;

import java.util.*;

public class Intzidentzia {

	private int id;
	private Calendar data;
	private String larritasuna;
	private String mota;
	private String deskribapena;
	private int idTxartela;
	private int idAtea;
	private int idTxartelIrakurgailua;
	private boolean gaituta;
	
	//Eraikitzailea
	public Intzidentzia(int intziId, Calendar intziData, String intziLarritasuna, String intziMota, String intziDeskr, int intziIdTxart, int intziIdAtea, int intziIdTxartIrak, boolean intziGaituta)
	{
		this.id = intziId;
		this.data = intziData;
		this.larritasuna = intziLarritasuna;
		this.mota = intziMota;
		this.deskribapena = intziDeskr;
		this.idTxartela = intziIdTxart;
		this.idAtea = intziIdAtea;
		this.idTxartelIrakurgailua = intziIdTxartIrak;
		this.gaituta = intziGaituta;
	}
	
	//Intzidentziaren IDa itzultzen du
	public int getId()
	{
		return this.id;
	}
	
	//Intzidentziaren Data itzultzen du
	public Calendar getData()
	{
		return this.data;
	}
	
	//Intzidentziaren Larritasuna itzultzen du	
	public String getLarritasuna()
	{
		return this.larritasuna;
	}
	
	//Intzidentziaren Mota itzultzen du	
	public String getMota()
	{
		return this.mota;
	}
	
	//Intzidentziaren Deskribapena itzultzen du	
	public String getDeskribapena()
	{
		return this.deskribapena;
	}
	
	//Intzidentziaren Txartelaren IDa itzultzen du	
	public int getIdTxatela()
	{
		return this.idTxartela;
	}
	
	//Intzidentziaren Atearen IDa itzultzen du	
	public int getIdAtea()
	{
		return this.idAtea;
	}
	
	//Intzidentziaren Txartel Irakurgailuaren IDa itzultzen du	
	public int getIdTxartelIrakurgailua()
	{
		return this.idTxartelIrakurgailua;
	}
	
	//Intzidentzia gaituta dagoen edo ez itzultzen du	
	public boolean isGaituta()
	{
		return this.gaituta;
	}
	
	//Intzidentzia inprimatzen du
	public void print()
	{
		System.out.println("INTZIDENTZIA: " + this.id);
		System.out.println("------------------");
		System.out.println("Data: " + this.data.getTime());
		System.out.println("Larritasuna: " + this.larritasuna);
		System.out.println("Mota: " + this.mota);
		System.out.println("Deskribapena: " + this.deskribapena);
		System.out.println("IdTxartela: " + this.idTxartela);
		System.out.println("IdTxartelIrakurgailua: " + this.idTxartelIrakurgailua);
		System.out.println("Gaituta: " + this.gaituta);
	}
}
