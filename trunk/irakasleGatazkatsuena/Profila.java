package irakasleGatazkatsuena;

import java.util.*;

public class Profila {

	//Iruzkin moduan dauden atributuak edo metodoak ez ditugu oraindik erabili
	private int id;
	private String mota;
	private String deskribapena;
	private Vector<Erabiltzailea> erabiltzaileak;
	//private Vector<Gunea> guneak;
	//private Vector<Ordutegia> ordutegiak;

	//Eraikitzailea	
	public Profila (int profilId, String profilMota, String profilDeskribapena)
	{
		this.id = profilId;
		this.mota = profilMota;
		this.deskribapena = profilDeskribapena;
		this.erabiltzaileak = new Vector<Erabiltzailea>();
	}
	
	//Profilaren IDa itzultzen du
	public int getId()
	{
		return this.id;
	}
	
	//Profilaren Mota itzultzen du
	public String getMota()
	{
		return this.mota;
	}

	//Profilaren Deskribapena itzultzen du	
	public String getDeskribapena()
	{
		return this.deskribapena;
	}
	
	//Profilaren Erabiltzaileak itzultzen ditu bektore batean
	public Vector<Erabiltzailea> getErabiltzaileak()
	{
		return this.erabiltzaileak;
	}
	
	/*public Vector getGuneak()
	{
		return this.guneak;
	}*/
	
	/*public Vector getOrdutegiak()
	{
		return this.ordutegiak;
	}*/
	
	//Erabiltzailea gehitzen dio profilari	
	public void addErabiltzailea(Erabiltzailea erab)
	{
		this.erabiltzaileak.addElement(erab);
	}
}