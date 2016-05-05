import java.util.concurrent.Callable;

public class Dzialanie implements Callable<Integer> {
	static int znalezione;
	static boolean koniec=false;
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
		pokarz_info();
	
		int koniec_tablicy;
		int tab[] =Glowna.tab;
		int k=0;
		if(numer_watku==ilosc_watkow)
		{
			koniec_tablicy=(tab.length-1);
		}else
		{
			koniec_tablicy=(numer_watku*zakres);
		}
		for(int i=((numer_watku-1)*zakres) ; i<koniec_tablicy ; i++ )
		{	System.out.println("Watek : "+numer_watku+":"+i);
			if(tab[i] == -100) // nie wiem czy to dobrze sprawdzam
			{	++k;
				
				System.out.println("Watek : "+numer_watku+":"+i+"TUJEST");
			//	System.out.println("Watek " + numer_watku + " znalaz³ "+k+" Dolara");
			}
			if(znalezione == Glowna.ilosc_odpowiedzi)
			{
				break;
	///			System.out.println("ZWRACAMMMMM !!!");
				
			//	return "znalazlem";
				
			}
		}
		return k;
	}
	private void pokarz_info() {
		System.out.print("Watek" + numer_watku+"LENGHT-1 :"+(Glowna.tab.length-1));
		System.out.println(" zakres :"+zakres);
		// TODO Auto-generated method stub
		
	}

}