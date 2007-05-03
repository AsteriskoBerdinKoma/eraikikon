package irakasleGatazkatsuena;

import java.util.Vector;

//Irakazle gatazkatsuenak gordetzeko erabili dugun klase laguntzaile bat da 
public class IrakasleGatazkatsua implements Comparable<IrakasleGatazkatsua> {
	private Erabiltzailea erabiltzailea;
	private Txartela txartela;
	private Vector<SarbideEskaera> sarbideEskaerak;

	//Eraikitzailea
	public IrakasleGatazkatsua(Erabiltzailea irakaslea, Txartela irakTxartela, Vector<SarbideEskaera> vSarbEsk)
	{
		this.erabiltzailea = irakaslea;
		this.txartela = irakTxartela;
		this.sarbideEskaerak = vSarbEsk;
	}
	
	//Erabiltzailea itzultzen du
	public Erabiltzailea getErabiltzailea()
	{
		return this.erabiltzailea;
	}
	
	//Txartela itzultzen du	
	public Txartela getTxartela()
	{
		return this.txartela;
	}
	
	//Sarbide eskaeren bektorea itzultzen du	
	public Vector<SarbideEskaera> getSarbideEskaerak()
	{
		return this.sarbideEskaerak;
	}

	//Objektu hau emandako objektua baino haundiagoa bada integer negatiboa itzuliko
	//berdinak badira 0 eta bestela integer positiboa.
	//Hau horrela egin dugu IrakasleGatazkatsuak SarbideEskaera kopuruaren arabera
	//orden beherakorrean ordenatu behar dugulako.
	public int compareTo(IrakasleGatazkatsua vSarbEsk) {
		return -(this.sarbideEskaerak.size() - vSarbEsk.getSarbideEskaerak().size());
	}
}
