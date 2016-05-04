import java.util.concurrent.Callable;

public class Dzialanie implements Callable<String> {
	static int znalezione;
	int numer_watku;
	Dzialanie(int i)
	{
		numer_watku=i;
	}
	@Override
	public String call() throws Exception {
		int tab[] =Glowna.tab;
		int k=0;
		for(int i=numer_watku ; i<tab.length ; i=i+numer_watku )
		{	
			if(tab[i] == -100) // nie wiem czy to dobrze sprawdzam
			{	++k;
				znalezione++;
			//	System.out.println("Watek " + numer_watku + " znalaz³ "+k+" Dolara");
			}
			if(znalezione == Glowna.ilosc_odpowiedzi)
			{
	///			System.out.println("ZWRACAMMMMM !!!");
				return "znalazlem";
				
			}
		}
		return "zakonczylem";
	}

}