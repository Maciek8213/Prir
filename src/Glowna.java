import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Glowna {
	static int [] tab;
	static int ilosc_odpowiedzi;
	public static void main(String[] args) {
		//inicjalizacja zmiennych
		
		String czy_generowac;
		
		
		System.out.println("Czy chcesz wygenerowac T/N");
		czy_generowac = new Scanner(System.in).next();
	
		if(czy_generowac.equals("T") || czy_generowac.equals("t"))
		{
		
		tab=inicjalizuj_generowanie();
		
		}else
		{
			tab=zczytaj_z_pliku();
			System.out.print("ilosc elemnetow : " +tab.length+ " ilosc odpowiedzi: " + ilosc_odpowiedzi+"\n");
		}
		if(tab!=null)
		{
			int ilosc_watkow;
			
			System.out.println("podaj maksymalna ilosc watkow :");
			ilosc_watkow = Integer.valueOf(new Scanner(System.in).next());
			//System.out.println("podaj ilosc odpowieddzi w pliku: ");
		//	ilosc_odpowiedzi = Integer.valueOf(new Scanner(System.in).next());
			 
			
			
			Watek maciek = new Watek(ilosc_watkow );
		}
		System.out.println("Program zakonczyl prace  ");
	
	}

	private static int[] zczytaj_z_pliku() {
	
		int iterator=0;
		Scanner in;
		try {
			
			
			
			in = new Scanner(new File("Liczby.txt"));
			//System.out.println("szu: "+in.next().substring(16)+"liczb: "+in.next().substring(12));
			ilosc_odpowiedzi = Integer.valueOf(in.next().substring(16));
			
			int tab [] = new int[Integer.valueOf(in.next().substring(12))];
			while(in.hasNext())
			{	
				
				String temp = in.next();
				String dupa = "";
				//przejscie po jednym wyrazie
				for (int i=0; i < temp.length() ; i++)
				{
					
					if (temp.charAt(i) == ':')
					{
						dupa = temp.substring(i+1);
						
					}
				}
				
				if(dupa.equals(""))
				{
					//nic nie rob
				}else if(dupa.equals("$"))
				{
					//wpisz -100
					tab[iterator] = -100;
					iterator++;
				}
				else
				{
					//wpisz normalnie
				//	System.out.println("PARS: "+dupa);
					tab[iterator] = Integer.valueOf(dupa);
					iterator++;
				}
			}		
//			
		//	int sprawdzacz=0;
			for(int x : tab)
			{
				//sprawdzacz++;
			//	System.out.println(":" + x);
			}
		//	System.out.println("JEST LICZB :" + sprawdzacz);
			return tab;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.err.println("Plik Liczby.txt nie istnieje");
			}
		
		return null;
	}

	private static int[] inicjalizuj_generowanie() {
		
		//Podawanie liczb
		int [] tab = null;
		int zczytana;	
		int szukane;
		System.out.println("Podaj ilosc liczb do wygenerowania : ");
		zczytana = Integer.valueOf(new Scanner(System.in).next());
		//jezeli liczba z zakresu
		if(liczba_spelnia_warunek(zczytana))
		{
		//Podaj ilosc czukanych $
			System.out.println("Podaj ilosc szukanych");
			szukane = Integer.valueOf(new Scanner(System.in).next());
			//sprawdz czy dobrze podal
			ilosc_odpowiedzi=szukane;
			while(szukane <= 0)
			{
				System.out.println("Podaj poprawna ilosc szukanych !");
				szukane = Integer.valueOf(new Scanner(System.in).next());
				ilosc_odpowiedzi=szukane;
			}
			
			// generuj
			try {
				tab=generuj(zczytana , szukane);
			} catch (FileNotFoundException e) {
				System.err.println("Nie utworzono pliku");
			} //generuj
			
		}
		return tab;
		
	}

	private static boolean liczba_spelnia_warunek(int zczytana) {
		if(zczytana >0 && zczytana <=100000000)
		return true;
		return false;
	}

	private static int[] generuj(int ilosc_liczb, int szukane) throws FileNotFoundException {
		//inicjalizacna
		int test=0;
		Set<Integer> wygrane;
		PrintWriter zapis= new PrintWriter("Liczby.txt");
		zapis.println("ilosc_szukanych/"+szukane+" ilosc_liczb/"+ilosc_liczb);
		int [] tab_liczb = new int[ilosc_liczb+1];
		Random generator= new Random();
		//generuje liczby i ustawia iterator
		wygrane=generuj_szukane(ilosc_liczb,szukane,generator);
		Iterator iterator = wygrane.iterator();
		Integer szukaj=(Integer) iterator.next();
		
	//	System.out.print("umiescilem na : ");
		for(int i =1 ; i <= ilosc_liczb ;i++)
		{	
			if(szukaj == i )
			{	
				//System.out.print(i+", ");//pozycja umieszczenia
				tab_liczb[i]=-100; test++;// w tablicy jest -100 xd
				zapis.println(i+":$");
				if(iterator.hasNext())
				szukaj=(Integer) iterator.next();
				
			}
			else
			{
				tab_liczb[i]=generator.nextInt(1000);
				zapis.println(i+":"+tab_liczb[i]);
			}
		
		}
		if(test==szukane)
		{
			System.out.println("Utworzono prawidlowo");
		}else{System.out.println("Blad przy wpisywaniu dolarow");}
		zapis.println("KONIEC");
		zapis.close();
		return tab_liczb;
	}

	private static Set generuj_szukane(int ilosc_liczb, int szukane, Random generator) {
		Set<Integer> wygrane=new TreeSet<Integer>();
		while (wygrane.size() != szukane)
		{
			wygrane.add(generator.nextInt(ilosc_liczb)+1);
		}
	//	pokarz_dolary(wygrane); // pogladowo gdzie powinny byc
		return wygrane;
	}

	private static void pokarz_dolary(Set<Integer> wygrane) {
		int licz=0;
		System.out.print("$ sa na miejscach: ");
		for (Integer n : wygrane) {
			licz++;
		    System.out.print(n+", ");//pozycja sa na miejscu
		}
		System.out.println("//"+licz);
		
	}
}
