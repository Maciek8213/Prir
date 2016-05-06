

public class Dzialanie implements Runnable {
	
	private int numer_watku;
	private int ilosc_watkow;
	private int zakres;
	private int tab[];
	Dzialanie(int i, int j)
	{
		numer_watku=i;
		ilosc_watkow=j;
	//	System.out.println("LENGHT :"+Glowna.tab.length);
		tab=Glowna.tab;
		//System.arraycopy( Glowna.tab, 0, tab, 0, Glowna.tab.length );
		zakres=(Glowna.tab.length-1)/j;
	}
	@Override
	public void run() {
	//	pokarz_info();
	
		int koniec_tablicy;
		if(numer_watku==ilosc_watkow)
		{
			koniec_tablicy=tab.length;
		}else
		{
			koniec_tablicy=(numer_watku*zakres);
		}
		for(int i=((numer_watku-1)*zakres) ; i<koniec_tablicy ; i++ )
		{	//System.out.println("Watek : "+numer_watku+":"+i);
			//jezeli dodawaj;
			sprawdz(tab, i);
		}
	
	}
	
	
	public synchronized void sprawdz(int [] tab,int i) {
		if(tab[i] == -100) // nie wiem czy to dobrze sprawdzam
		{	
		
			Watek.znalezione_add();
	//	System.out.println("\nWatek : "+numer_watku+":"+i+"TUJEST"); //<--- to czasem warto odznaczyc
		//	System.out.println("Watek " + numer_watku + " znalaz³ "+k+" Dolara");
		}
		
		
	}
	private void pokarz_info() {
		System.out.print("Watek" + numer_watku+"LENGHT-1 :"+(Glowna.tab.length-1));
		System.out.println(" zakres :"+zakres);
		// TODO Auto-generated method stub
		
	}

}