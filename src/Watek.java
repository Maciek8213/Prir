import java.util.ArrayList;
import java.util.HashSet;
import java.util.IllformedLocaleException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Watek {
	int liczba;
	static int ilosc_odp=Glowna.ilosc_odpowiedzi;
	static volatile int znalezione=0;
	
	Watek(int licz)
	{
		liczba=licz;
		generuj_watki();
	}
	public synchronized static void znalezione_add()
	{
		znalezione++;
	}
	public synchronized static int znalezione_get()
	{
		return znalezione;
	}
	public synchronized static void znalezione_zeruj()
	{
		znalezione=0;
	}
	
	public synchronized static int ilosc_odpowiedzi_get()
	{
		return ilosc_odp;
	}


	private void generuj_watki() {

		    
	//	ExecutorService exe = Executors.newFixedThreadPool(10);
		
		for(int j=1; j<=liczba ;j++)
			
		{	//System.out.print("uruchomilem watkow: ");
			ExecutorService exe = Executors.newFixedThreadPool(liczba);
		
			//List<Executors> lista_watkow = new  ArrayList<Executors>();
			znalezione_zeruj();
			long current = 0;//System.currentTimeMillis(); 
			long koniec = 0;
			//rozpoczecie pracy watkow
			
			for(int i= 1 ; i <=j ; i++)
			{
				exe.execute(new Dzialanie(i , j));
				
				
				//lista_watkow.add(exe.submit( new Dzialanie(i , j) ));
			//	System.out.print(i+", ");
			}
			current = System.currentTimeMillis(); 
			int sumuj=0;
			//czekanie na zwroty z watkow
			while(true)
			{			
				if(znalezione_get() == ilosc_odpowiedzi_get())
				{
					koniec =  System.currentTimeMillis();
					break;
				}
			}	
			
			
			exe.shutdown();
			
			
			if(koniec > 0)
			{
				System.out.println(j+"Watkow zakonczylo prace po : " + (koniec-current) + " milisekundach");
			}else
			{
				
				System.out.print(j+"Nie znalazło odpowiedzi :(  " + (koniec-current) + " mlilisekundach");
				System.out.println("\tznal:" +sumuj+"\tilos:"+Glowna.ilosc_odpowiedzi);
			}
			System.out.println();
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
