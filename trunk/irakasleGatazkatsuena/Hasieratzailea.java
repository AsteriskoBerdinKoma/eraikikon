package irakasleGatazkatsuena;

import java.util.*;

//Datuak memorian kargatzen dira guk esleitutako balioekin
public class Hasieratzailea {
	
	private Vector<Profila> vProf;

	//Eraikitzailea
	public Hasieratzailea() {
		
	    //Erabiltzaileak sortu	    
	    Erabiltzailea e1 = new Erabiltzailea(10, "Pepe", "sareak2");
	    Erabiltzailea e2 = new Erabiltzailea(11,"Jon","sistemaEragileak");
	    Erabiltzailea e3 = new Erabiltzailea(12,"Arantxa","programazioa");
	    Erabiltzailea e4 = new Erabiltzailea(13, "Jon", "DEA");
	    Erabiltzailea e5 = new Erabiltzailea(14,"Itziar","estadistika");
	    Erabiltzailea e6 = new Erabiltzailea(15,"Xabier","programazio2");
	    Erabiltzailea e7 = new Erabiltzailea(16,"Juanan","software");
	    Erabiltzailea e8 = new Erabiltzailea(17,"Txelo","elektronika");
	    Erabiltzailea e9 = new Erabiltzailea(18,"Patxi","analisis");
	    Erabiltzailea e10 = new Erabiltzailea(19,"Luis","fisika");
	    Erabiltzailea e11 = new Erabiltzailea(110,"Iñaki","sistemenkud");
	    Erabiltzailea e12 = new Erabiltzailea(111,"Alex","sareak");
	    Erabiltzailea e13 = new Erabiltzailea(112,"Josune","analisi");
	    Erabiltzailea e14 = new Erabiltzailea(113,"Aiztiber","iza");
	    Erabiltzailea e15 = new Erabiltzailea(114,"Beñat","lizarazu");
	    Erabiltzailea e16 = new Erabiltzailea(115,"Inko","perurena");
	    Erabiltzailea e17 = new Erabiltzailea(116,"Idoia","lertxundi");
	    Erabiltzailea e18 = new Erabiltzailea(117,"Dani","Campos");
	    Erabiltzailea e19 = new Erabiltzailea(118,"Amagoia","Agirre");
	    Erabiltzailea e20 = new Erabiltzailea(119,"Janire","lasheras");
	    Erabiltzailea e21 = new Erabiltzailea(120,"Garazi","nirea");
	    
	    //Profilak sortu eta bektorean sartu
	    Profila p1 = new Profila(20,"Ikaslea","ikasleen gelak");
	    Profila p2 = new Profila(21,"Irakaslea","irakasleen buleagoak");
	    Profila p3 = new Profila(22,"Arduraduna","laborategiak");
	    vProf= new Vector<Profila>();
	    vProf.add(p1);
	    vProf.add(p2);
	    vProf.add(p3);
	    
	    //Erabiltzaileei profilak esleitu
	    e1.setProfila(p2);
	    e2.setProfila(p2);
	    e3.setProfila(p2); 
	    e4.setProfila(p2);
	    e5.setProfila(p2);
	    e6.setProfila(p2);
	    e7.setProfila(p2);
	    e8.setProfila(p2);
	    e9.setProfila(p2);
	    e10.setProfila(p2);
	    e11.setProfila(p2);
	    e12.setProfila(p2);
	    e13.setProfila(p2);
	    e14.setProfila(p1);
	    e15.setProfila(p1);
	    e16.setProfila(p1);
	    e17.setProfila(p1);
	    e18.setProfila(p1);
	    e19.setProfila(p1);
	    e20.setProfila(p1);
	    e21.setProfila(p3);
	    
	    //Txartelak sortu
	    //GregorianCalendar-en hilabeteak 0-tik hasita sartu behar dira,
	    //hau da 0=urtarrila da eta 11=abendua.
	    Calendar d1 = new GregorianCalendar(2005,1,20,12,13,59);
	    Calendar d2 = new GregorianCalendar(2004,0,8,8,29,04);
	    Calendar d3 = new GregorianCalendar(2006,0,1,12,12,12);
	    Calendar d4 = new GregorianCalendar(2004,8,4,20,56,45);
	    Calendar d5 = new GregorianCalendar(2003,0,26,16,6,49);
	    
	    Txartela t1 = new Txartela(30,e1,d1);
	    Txartela t2 = new Txartela(31,e2,d2);
	    Txartela t3 = new Txartela(32,e3,d3);
	    Txartela t4 = new Txartela(33,e4,d2);
	    Txartela t5 = new Txartela(34,e5,d5);
	    Txartela t6 = new Txartela(35,e6,d4);
	    Txartela t7 = new Txartela(36,e7,d1);
	    Txartela t8 = new Txartela(37,e8,d2);
	    Txartela t9 = new Txartela(38,e9,d4);
	    Txartela t10 = new Txartela(39,e10,d3);
	    Txartela t11 = new Txartela(310,e11,d2);
	    Txartela t12 = new Txartela(311,e12,d2);
	    Txartela t13 = new Txartela(312,e13,d1);
	    Txartela t14 = new Txartela(313,e14,d5);
	    Txartela t15 = new Txartela(314,e15,d5);
	    Txartela t16 = new Txartela(315,e16,d1);
	    Txartela t17 = new Txartela(316,e17,d1);
	    Txartela t18 = new Txartela(317,e18,d4);
	    Txartela t19 = new Txartela(318,e19,d5);
	    Txartela t20 = new Txartela(319,e20,d1);
	    Txartela t21 = new Txartela(320,e21,d4);
	    
	    //Txartel Irakurgailuak sortu
	    TxartelIrakurgailua ti1 = new TxartelIrakurgailua(50);
	    TxartelIrakurgailua ti2 = new TxartelIrakurgailua(51);
	    TxartelIrakurgailua ti3 = new TxartelIrakurgailua(53);
	    TxartelIrakurgailua ti4 = new TxartelIrakurgailua(54);
	    TxartelIrakurgailua ti5 = new TxartelIrakurgailua(55);
	    TxartelIrakurgailua ti6 = new TxartelIrakurgailua(56);
	    TxartelIrakurgailua ti7 = new TxartelIrakurgailua(57);
	    TxartelIrakurgailua ti8 = new TxartelIrakurgailua(58);
	    TxartelIrakurgailua ti9 = new TxartelIrakurgailua(59);
	    TxartelIrakurgailua ti10 = new TxartelIrakurgailua(510);
	    
	    //Sarbide eskaerak sortzen dira
	    Calendar dat1 = new GregorianCalendar(2007,1,20,12,13,59);
	    Calendar dat2 = new GregorianCalendar(2007,0,8,8,29,04);
	    Calendar dat3 = new GregorianCalendar(2007,1,13,9,2,43);
	    Calendar dat4 = new GregorianCalendar(2007,0,1,12,12,12);
	    Calendar dat5 = new GregorianCalendar(2006,8,4,20,56,45);
	    Calendar dat6 = new GregorianCalendar(2007,0,30,18,47,02);
	    Calendar dat7 = new GregorianCalendar(2007,1,13,17,34,26);
	    Calendar dat8 = new GregorianCalendar(2007,0,26,16,6,49);
	    Calendar dat9 = new GregorianCalendar(2007,1,8,10,45,22);
	    Calendar dat10 = new GregorianCalendar(2006,11,13,00,59,43);
	    Calendar dat11 = new GregorianCalendar(2006,1,15,13,28,28);
	    Calendar dat12 = new GregorianCalendar(2007,0,28,1,00,06);
	    Calendar dat13 = new GregorianCalendar(2007,1,10,15,30,34);
	    Calendar dat14 = new GregorianCalendar(2007,0,8,13,35,05);
	    Calendar dat15 = new GregorianCalendar(2007,1,8,18,11,43);
	    Calendar dat16 = new GregorianCalendar(2007,0,4,24,17,43);
	    Calendar dat17 = new GregorianCalendar(2007,0,8,23,56,07);
	    Calendar dat18 = new GregorianCalendar(2007,1,15,23,45,06);
	    Calendar dat19 = new GregorianCalendar(2007,0,23,9,30,00);
	    Calendar dat20 = new GregorianCalendar(2007,1,21,11,45,32);
	    Calendar dat21 = new GregorianCalendar(2006,10,11,11,11,11);
	    Calendar dat22 = new GregorianCalendar(2006,11,4,15,26,49);
	    Calendar dat23 = new GregorianCalendar(2007,0,7,4,56,37);
	    Calendar dat24 = new GregorianCalendar(2007,0,19,17,19,23);
	    Calendar dat25 = new GregorianCalendar(2007,1,23,16,15,34);
	    Calendar dat26 = new GregorianCalendar(2007,0,4,13,45,23);
	    Calendar dat27 = new GregorianCalendar(2007,0,4,13,58,04);
	    Calendar dat28 = new GregorianCalendar(2007,1,19,15,16,17);
	    
	    new SarbideEskaera(dat1,false, "Baimenik ez",ti1, t1);
	    new SarbideEskaera(dat2,false, "errore ezezaguna", ti2, t2);
	    new SarbideEskaera(dat3,false, "Atea puxkatuta", ti1, t3);;  
	    new SarbideEskaera(dat4,false,"Baimenik ez",ti2,t4);
	    new SarbideEskaera(dat5,false,"",ti2,t5);
	    new SarbideEskaera(dat6,true,null,ti3,t6);
	    new SarbideEskaera(dat7,true,null,ti5,t7);
	    new SarbideEskaera(dat7,false,"Baimenik ez",ti7,t8);
	    new SarbideEskaera(dat8,false,"Baimenik ez",ti9,t9);
	    new SarbideEskaera(dat8,false,"errore ezezaguna",ti10,t10);
	    new SarbideEskaera(dat9,true,null,ti8,t11);
	    new SarbideEskaera(dat10,true,null,ti4,t12);
	    new SarbideEskaera(dat10,false,"Baimenik ez",ti1,t13);
	    new SarbideEskaera(dat11,false,"Baimenik ez",ti7,t14);
	    new SarbideEskaera(dat12,false,"errore ezezaguna",ti5,t14);
	    new SarbideEskaera(dat13,true,null,ti7,t15);
	    new SarbideEskaera(dat14,true,null,ti9,t15);
	    new SarbideEskaera(dat14,false,"Atea puxkatuta",ti4,t16);
	    new SarbideEskaera(dat15,true,null,ti9,t15);
	    new SarbideEskaera(dat16,false,"errore ezezaguna",ti10,t15);
	    new SarbideEskaera(dat17,false,"Atea puxkatuta",ti7,t15);
	    new SarbideEskaera(dat17,false,"errore ezezaguna",ti2,t7);
	    new SarbideEskaera(dat18,false,"",ti6,t17);
	    new SarbideEskaera(dat19,false,"Baimenik ez",ti1,t18);
	    new SarbideEskaera(dat19,true,null,ti4,t19);
	    new SarbideEskaera(dat19,false,"Atea puxkatuta",ti8,t20);
	    new SarbideEskaera(dat20,true,null,ti9,t21);
	    new SarbideEskaera(dat21,true,null,ti3,t8);
	    new SarbideEskaera(dat22,false,"Baimenik ez",ti7,t8);
	    new SarbideEskaera(dat22,true,null,ti2,t5);
	    new SarbideEskaera(dat23,false,"Baimenik ez",ti8,t8);
	    new SarbideEskaera(dat23,true,null,ti1,t6);
	    new SarbideEskaera(dat24,false,"errore ezezaguna",ti5,t9);
	    new SarbideEskaera(dat25,false,"errore ezezaguna",ti2,t12);
	    new SarbideEskaera(dat26,false,"",ti6,t1);
	    new SarbideEskaera(dat27,true,null,ti4,t8);
	    new SarbideEskaera(dat28,false,"Atea puxkatuta",ti1,t6);
	    new SarbideEskaera(dat23,false,"errore ezezaguna",ti6,t12);
	    new SarbideEskaera(dat8,true,null,ti8,t12);
	    new SarbideEskaera(dat19,false,"Baimenik ez",ti4,t7);
	    new SarbideEskaera(dat10,true,null,ti5,t3);
	    new SarbideEskaera(dat2,true,null,ti10,t3);
	    new SarbideEskaera(dat4,false,"Baimenik ez",ti1,t5);
	    new SarbideEskaera(dat3,false, "Baimenik ez",ti3, t1);
	    new SarbideEskaera(dat12,false, "Baimenik ez",ti2, t1);
	    new SarbideEskaera(dat7,false, "Baimenik ez",ti2, t1);
	    new SarbideEskaera(dat20,false, "Baimenik ez",ti2, t1);
	    new SarbideEskaera(dat8,false, "Baimenik ez",ti3, t1);
	}
	
	//Profilen bektorea itzultzen du
	public Vector<Profila> getProfilak()
	{
		return this.vProf;
	}
	
}
