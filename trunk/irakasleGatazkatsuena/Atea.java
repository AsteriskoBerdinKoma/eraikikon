package irakasleGatazkatsuena;

import java.util.*;

//Momentuz ez dugu, behar beraz ez dago osatuta
public class Atea {

	private int id;
	private String egoera;
	private boolean nagusia;
	private Vector<Gunea> guneak;
	
	//Eraikitzailea
	public Atea (int ateId, String ateEgoera, boolean ateNagusia)
	{
		this.id = ateId;
		this.egoera = ateEgoera;
		this.nagusia = ateNagusia;
	}
	
	//Atearen ID-a itzultzen du.
	public int getId()
	{
		return this.id;
	}
	
	public String getEgoera()
	{
		return this.egoera;
	}
	
	public boolean isNagusia()
	{
		return this.nagusia;
	}
	
	public Vector<Gunea> getGuneak()
	{
		return this.guneak;
	}
}
