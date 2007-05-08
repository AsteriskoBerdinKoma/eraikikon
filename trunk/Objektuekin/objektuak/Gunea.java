package objektuak;

import java.util.*;

//Momentuz ez dugu, behar beraz ez dago osatuta
public class Gunea {

	private int id;
	private String izena;
	private Vector<Atea> ateak;
	
	//Eraikitzailea
	public Gunea(int guneId, String guneIzena)
	{
		this.id = guneId;
		this.izena = guneIzena;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public String getIzena()
	{
		return this.izena;
	}
	
	
	public Vector<Atea> getAteak()
	{
		return this.ateak;
	}
}
