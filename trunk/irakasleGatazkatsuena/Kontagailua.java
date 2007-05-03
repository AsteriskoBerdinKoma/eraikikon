package irakasleGatazkatsuena;

//Irakasle gatazkatsuenak txartel irakurgailu bakoitzarekin 
//zenbat gatzaka izan dituen gordetzeko erabili dugun klase laguntzailea 
public class Kontagailua implements Comparable<Kontagailua>{

	private int id;
	private int kop;

	//Eraikitzailea
	public Kontagailua (int objId)
	{
		this.id = objId;
		this.kop = 0;
	}

	//IDa itzultzen du
	public int getId()
	{
		return this.id;
	}

	//Kopurua itzultzen du
	public int getKop()
	{
		return this.kop;
	}
	
	//Kopurua aldatzen du
	public void setKop(int objKop)
	{
		this.kop = objKop;
	}
	
	//Kontagailua inkerementatzen du
	public void inkrementatu()
	{
		this.kop++;
	}
	
	//Kontagailua dekrementatzen du
	public void dekrementatu()
	{
		this.kop--;
	}
	
	//Objektu hau emandako objektua baino haundiagoa bada integer negatiboa itzuliko
	//berdinak badira 0 eta bestela integer positiboa.
	//Hau horrela egin dugu kontagailuaren bektorea kopuruaren arabera
	//orden beherakorrean ordenatu behar dugulako.
	public int compareTo(Kontagailua kont) {
		return -(this.kop - kont.kop);
	}
}
