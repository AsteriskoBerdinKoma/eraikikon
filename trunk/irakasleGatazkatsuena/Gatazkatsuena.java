package irakasleGatazkatsuena;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Vector;

//Interfaze grafikoaren ordez erabiltzen dugun klasea
public class Gatazkatsuena {

	public static void main(String[] args) {
		//Datuak memorian kargatzen dira
		Hasieratzailea has = new Hasieratzailea();
		//Kudeatzaileari datuen erreferentziekin hasieratzen da
		Kudeatzailea kud = new Kudeatzailea(has.getProfilak(), null);
		Vector<IrakasleGatazkatsua> vIrakGataz = new Vector<IrakasleGatazkatsua>();
		Vector<SarbideEskaera> vSE = null;
		System.out.println("Irakasle gatazkatsuena");
		System.out.println();
		//Irakasle profila duten erabiltzaileak bektore batean gordetzen dira
		Vector<Erabiltzailea> vIrak = kud.getIrakasleak();
		//Irakasle bakoitzaren txartela bi urte baino gehiago dituen begiratzen du
		//eta horrela bada txartel horren azken hilabeteko sarbide eskaera ukatuak
		//bektore baten gordeko ditu eta amaieran  IrakazleGatazkatsuen betore bat
		//itzuliko du.
		for (Erabiltzailea erab: vIrak)
		{
			Txartela tx = kud.getTxartel2Urte(erab);
			if (tx != null)
			{
				vSE = kud.getSarbideEskaerak(tx);
				if (vSE.size()!=0)
					vIrakGataz.add(new IrakasleGatazkatsua(erab, tx, vSE));
			}
		}
		//Irakasle gatazkatsuen bektorea ordenatu sarbide eskaera ukatuen kopuruaren
		//arabera modu beherakorrean eta lehenengo hamarrak bakarrik aukeratzen ditu.
		Collections.sort(vIrakGataz);
		if (vIrakGataz.size() > 10)
			vIrakGataz.setSize(10);
		System.out.println("ID " + " Izena " + " TxartZenb " + " Sarbide-Eskaera Ukatu Kopurua");
		System.out.println("----------------------------------------------------");
		Erabiltzailea erab;
		for (IrakasleGatazkatsua irakGatazk: vIrakGataz)
		{
			erab = irakGatazk.getErabiltzailea();
			System.out.println(erab.getId() + "  " + erab.getIzena() + "    " + irakGatazk.getTxartela().getId() + "             " + irakGatazk.getSarbideEskaerak().size());
		}
		//exekuzioarekin jarraitzeko (intzidentzia sortu) ENTER sakatu behar da
		System.out.println();
		System.out.print("Sakatu ENTER intzidentzia berri bat sortzeko irakasle gatazkatsuenarekin.");
		System.out.println();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// ohizko sarrera/irteera eragiketak egindakoan, salbuespenak kudeatzea ezinbestekoa da
		try {
		br.readLine();
		} catch (IOException ioe) {
		System.out.println("Errorea!!");
		System.exit(1);
		}
		//Irakasle gatazkatsuenak zein txartel irakurgailuareki izan dituen arazo gehien bilatzen da
		Vector<SarbideEskaera> vSarbEsk = vIrakGataz.firstElement().getSarbideEskaerak();
		Vector<Kontagailua> vKont = new Vector<Kontagailua>();
		int txartIrakId;
		Kontagailua txIrKont;
		boolean aurkitua = false;
		//Irasle gatazkatsuenaren sarbide eskaera guztiak begiratzen dira bakoitzaren txartel irakurgailuaren
		//IDa lortzeko.
		for (SarbideEskaera sarbEsk: vSarbEsk)
		{
			txartIrakId = sarbEsk.getTxartelIrakurgailua().getId();
			//Kontagailu bakoitzean irkasleak txartel irakurgailu horretan izan dituen ukapen kopurua gordetzen da
			for (Kontagailua kont: vKont)
			{
				if (kont.getId() == txartIrakId)
				{
					kont.inkrementatu();
					aurkitua = true;
					break;
				}
			}
			if (aurkitua == false)
			{
				txIrKont = new Kontagailua(txartIrakId);
				txIrKont.inkrementatu();
				vKont.add(txIrKont);
			}
		}
		//Kontagailuen bektorea ordenatzen du orden beherakorrean eta lehenengoaren (gatazkatsuena)
		//txartel irakurgailuaren IDa hartzen du
		Collections.sort(vKont);
		int txartIrakGatazk = vKont.firstElement().getId();
		int txId = vIrakGataz.firstElement().getTxartela().getId();
		//Intzidentzia sortzen da eta intzidentzia guztiak (orain sartutakoa barne) inprimatzen ditu
		kud.createIntzidentzia(txId, txartIrakGatazk, "irakasleGatazkatsua");
		kud.printIntzidentziak();
	}

}
