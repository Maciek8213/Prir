import java.util.ArrayList;
import java.util.List;

public class Watek {
	int liczba;
	
	
	
	Watek(int licz)
	{
		liczba=licz;
		generuj_watki();
	}



	private void generuj_watki() {
		
		List<Thread> lista_watkow = new  ArrayList<Thread>();
		
		for(int j=1; j<=liczba ;j++)
		{	System.out.print("uruchomilem watkow: ");
			long current = System.currentTimeMillis();
			for(int i= 1 ; i <=j ; i++)
			{
				
				new Thread(new Dzialanie()).start();
				
				
				System.out.print(i+", ");
			}
			
			System.out.println();
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
