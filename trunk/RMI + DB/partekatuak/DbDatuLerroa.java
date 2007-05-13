package partekatuak;

import java.io.Serializable;

public class DbDatuLerroa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int ateId;
	private String sarbideData;
	private int txartelId;
	private int txartelIrakId;
	private int hasieraGune;
	private int helburuGune;
	private String baimenduta;
	private String ukapenarenArrazoia;

	public DbDatuLerroa(int a,String s, int t, int ti, int ha, int he,int b,String u){
		ateId=a;
		sarbideData=s;
		txartelId=t;
		txartelIrakId=ti;
		hasieraGune=ha;
		helburuGune=he;
		if(b==0)
			baimenduta="Ez";
		else
			baimenduta="Bai";
		ukapenarenArrazoia=u;
		
	}
	
	public DbDatuLerroa(){
		
	}
	
	public int getAteId(){return ateId;}
	public String getSarbideData(){return sarbideData;}
	public int getTxartelId(){return txartelId;}
	public int getTxartelIrakId(){return txartelIrakId;}
	public int getHasieraGune(){return hasieraGune;}
	public int getHelburuGune(){return helburuGune;}
	public String getBaimenduta(){return baimenduta;}
	public String getUkapenarenArrazoia(){return ukapenarenArrazoia;}
	
	public void setAteId(int a){ateId=a;}
	public void setSarbideData(String s){sarbideData=s;}
	public void setTxartelId(int t){txartelId=t;}
	public void setTxartelIrakId(int t){txartelIrakId=t;}
	public void setHasieraGune(int h){hasieraGune=h;}
	public void setHelburuGune(int h){helburuGune=h;}
	public void setBaimenduta(int b){if (b==0) baimenduta="Ez"; else baimenduta="Bai";}
	public void setUkapenarenArrazoia(String u){ukapenarenArrazoia=u;}
}
