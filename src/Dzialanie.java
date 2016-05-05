import java.util.concurrent.Callable;

public class Dzialanie implements Callable<Integer> {
	static volatile int znalezione=0;
	int numer_watku;
	int ilosc_watkow;
	int zakres;
	Dzialanie(int i, int j)
	{
		numer_watku=i;
		ilosc_watkow=j;
	//	System.out.println("LENGHT :"+Glowna.tab.length);
		
		zakres=(Glowna.tab.length-1)/j;
	}
	@Override
	public Integer call() throws Exception {
	//	pokarz_info();
		int test=0;
		int koniec_tablicy;
		int tab[] = new int [Glowna.tab.length] ;
		System.arraycopy( Glowna.tab, 0, tab, 0, Glowna.tab.length );
		if(numer_watku==ilosc_watkow)
		{
			koniec_tablicy=tab.length;
		}else
		{
			koniec_tablicy=(numer_watku*zakres);
		}
		for(int i=((numer_watku-1)*zakres) ; i<koniec_tablicy ; i++ )
		{	//System.out.println("Watek : "+numer_watku+":"+i);
			//dopisz(tab ,i ,test);
			if(tab[i] == -100) // nie wiem czy to dobrze sprawdzam
			{	
				test++;
		//	System.out.println("\nWatek : "+numer_watku+":"+i+"TUJEST"); //<--- to czasem warto odznaczyc
			//	System.out.println("Watek " + numer_watku + " znalaz³ "+k+" Dolara");
			}
			
			
			
			if(znalezione == Glowna.ilosc_odpowiedzi)
			{
		//		return 0;
			//	return "znalazlem";
			}
		}
		return test;
	}
	synchronized void dopisz(int [] tab,int i, int test) {
		
		
	}
	private void pokarz_info() {
		System.out.print("Watek" + numer_watku+"LENGHT-1 :"+(Glowna.tab.length-1));
		System.out.println(" zakres :"+zakres);
		// TODO Auto-generated method stub
		
	}

}