package objektuak;

public class Erabiltzailea {
	private int id;
	private String izena;
	private String pasahitza;
	private Txartela txartela;
	private Profila profila;
	
	//Eraikitzailea
	public Erabiltzailea(int erabId, String erabIz, String erabPas) 
	{
		this.id = erabId;
		this.izena = erabIz;
		this.pasahitza = erabPas;
	}
	
	//Erabiltzailearen ID-a itzultzen du.
	public int getId()
	{
		return this.id;
	}
	
	//Erabiltzailearen izena itzultzen du.
	public String getIzena()
	{
		return this.izena;
	}

	//Erabiltzailearen pasahitza itzultzen du.
	public String getPasahitza()
	{
		return this.pasahitza;
	}

	//Erabiltzailearen txartela itzultzen du.
	public Txartela getTxartela()
	{
		return this.txartela;
	}

	//Erabiltzailearen profila itzultzen du.
	public Profila getProfila()
	{
		return this.profila;
	}

	//Erabiltzaileari txartela esleitzen dio.
	public void setTxartela(Txartela tx)
	{
		this.txartela = tx;
	}
	
	//Erabiltzaileari profila esleitzen dio.
	public void setProfila(Profila erabiltzaileProfila)
	{
		this.profila = erabiltzaileProfila;
		this.profila.addErabiltzailea(this);
	}
}