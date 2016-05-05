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
			for(int i= 1 ; i <=j ; i++)
			{
				lista_watkow.add(exe.submit( new Dzialanie(i , j) ));
			//	System.out.print(i+", ");
			}
			
			int sumuj=0;
			for(Future<Integer> x : lista_watkow)
			{
				
				try {
					 maciek =maciek+x.get();
					
					 if(maciek == Glowna.ilosc_odpowiedzi)
					 {
						Dzialanie.znalezione=Glowna.ilosc_odpowiedzi;
						break;
					 }
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			if(j==maciek)
			{
				System.out.println(j+"Watkow zakonczylo prace po : " + (System.currentTimeMillis()-current) + " sekundach");
			}else
			{
				System.out.print(sumuj);
				System.out.println(j+"Nie znalazło odpowiedzi :(  " + (System.currentTimeMillis()-current) + " sekundach");
				
			}
			System.out.println();
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
