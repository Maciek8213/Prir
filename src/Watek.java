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
	
	
	
	Watek(int licz)
	{
		liczba=licz;
		generuj_watki();
	}



	private void generuj_watki() {

		    
		ExecutorService exe = Executors.newFixedThreadPool(10);
		
		for(int j=1; j<=liczba ;j++)
			
		{	//System.out.print("uruchomilem watkow: ");
			Integer maciek=0;
			List<Future> lista_watkow = new  ArrayList<Future>();
			Dzialanie.znalezione=0;
			long current = System.currentTimeMillis(); 
			long koniec = 0;
			//rozpoczecie pracy watkow
			for(int i= 1 ; i <=j ; i++)
			{
				lista_watkow.add(exe.submit( new Dzialanie(i , j) ));
			//	System.out.print(i+", ");
			}
			int sumuj=0;
			//czekanie na zwroty z watkow
			for(Future<Integer> x : lista_watkow)
			{
				
				try {
					 sumuj=sumuj+x.get();
					
					 if(sumuj == Glowna.ilosc_odpowiedzi)
					 {
						 koniec = System.currentTimeMillis();
						 break;
					 }
					 //{
				//		 koniec = System.currentTimeMillis();
				//		break;
				//	 }
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			if(Dzialanie.znalezione == Glowna.ilosc_odpowiedzi)
			{
				System.out.println(j+"Watkow zakonczylo prace po : " + (koniec-current) + " sekundach");
			}else
			{
				
				System.out.print(j+"Nie znalazło odpowiedzi :(  " + (koniec-current) + " sekundach");
				System.out.println("\tznal:" +sumuj+"\tilos:"+Glowna.ilosc_odpowiedzi);
			}
			System.out.println();
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
