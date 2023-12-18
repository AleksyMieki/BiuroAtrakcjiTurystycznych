package Prezentacja;


import Aplikacja.Atrakcja;
import Aplikacja.Dane;
import Aplikacja.Zgloszenie;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class InterfejsPracownika extends InterfejsUzytkownika {

	/**
	 * 
	 * @param czyZalogowany
	 */
	public void zarzadzajAtrakcja(boolean czyZalogowany) {

		Scanner scanner = new Scanner(System.in);
		String nazwaAtrakcji;

		Atrakcja atrakcja;

		Dane dane;

		System.out.println("Podaj nazwe szukanej atrakcji");
		nazwaAtrakcji = scanner.nextLine();

		atrakcja = wyszukajAtrakcje(nazwaAtrakcji,czyZalogowany);

		if(atrakcja == null)
		{
			System.out.println("nie znaleziono atrakcji o podanej nazwie w bazie atrakcji");

			do {

				dane = podajDaneAtrakcji();

			}while(aplikacja.sprawdzPoprawnosc(dane));

			System.out.println("wprowadzono poprawne dane, tworze atrakcje");

			aplikacja.utworzAtrakcje(dane);

			System.out.println("Atrakcje utwozono pomyslnie");

			return;
		}
		if( atrakcja != null )
		{
			System.out.println("w bazie znaleziono taka atrakcje, czy chcesz ja teraz : \n1.usunac\n2.edytowac");

			switch (wybierzEdycjeLubUsuniecie())
			{
				case 1:
					if(potwierdzUsuniecie())
					{
						aplikacja.usunAtrakcje(atrakcja);
					}
					break;

				case 2:
					do {

						dane = podajDaneAtrakcji();

					}while(aplikacja.sprawdzPoprawnosc(dane));

					aplikacja.edytujAtrakcje(atrakcja, dane);
					System.out.println("Pomyslnie zmodyfikowano dane atrakcji");

					break;

				default:
					return;
			}
		}

		return;
	}

	public void przegladajZgloszenia() {

		Collection<Zgloszenie> lista = aplikacja.getListaZgloszen();
		wyswietlZapytania(lista);

	}

	private Dane podajDaneAtrakcji() {

		String nazwa;
		float cena;
		String godzina;
		String lokalizacja;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Podaj nazwe atrakcji:");
		nazwa = scanner.nextLine();

		System.out.println("Podaj cene atrakcji:");
		cena = scanner.nextFloat();
		scanner.nextLine();

		System.out.println("Podaj godzine atrakcji:");
		godzina = scanner.nextLine();

		System.out.println("Podaj lokalizacje atrakcji:");
		lokalizacja = scanner.nextLine();

		return new Dane(nazwa,cena,godzina,lokalizacja);

	}

	public void zarzadzajZapytaniamiKlientow() {

		Zgloszenie zgloszenie;
		int idZapytania = 0;

		idZapytania = podajIdZapytania();

		if(idZapytania == 0) return;

		zgloszenie = aplikacja.getZgloszenieById(idZapytania);

		if (zgloszenie == null) return;

		if(czyOdpowiedziecNaZapytanie(zgloszenie))
		{
			if(aplikacja.getMenedzerWiadomosci().sprawdzenieTematu(zgloszenie.getTemat()))
			{
				if(czyZwrocicBilet(zgloszenie))
				{
					aplikacja.getKasaBiletowa().zwrocBiletPrzezZgloszenie(zgloszenie);
					return;
				}
				else
				{
					return;
				}
			}
			else
			{
				System.out.println("Podaj wiadomosc do wyslania");
				String wiadomosc = podajWiadomosc();
				aplikacja.getMenedzerWiadomosci().wyslijWiadomosc(zgloszenie,wiadomosc);

				return;
			}

		}
		else{
			return;
		}

	}
	private int podajIdZapytania()
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println("podaj id szukanego zapytania : ");

		return scanner.nextInt();

	}

	private int wybierzEdycjeLubUsuniecie() {

		Scanner scanner = new Scanner(System.in);

		int wybor = scanner.nextInt();
		scanner.nextLine();

		return wybor;
	}
	private boolean potwierdzUsuniecie()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("czy na pewno chcesz usunac ta atrakcje z bazy dostepnych atrakcji(tak/nie)");
		String potwierdzenie;
		potwierdzenie = scanner.nextLine();

		if(potwierdzenie.equals("tak")) return true;
		else if (potwierdzenie.equals("nie")) return false;

		return false;
	}

	private void wyswietlZapytania(Collection<Zgloszenie> lista)
	{
		for (var v : lista) {
			System.out.println(v.getTrescWiadomosci());
			System.out.println(v.getId());
			System.out.println(v.getTemat());
			System.out.println();
		}
	}
	private boolean czyZwrocicBilet(Zgloszenie zgloszenie)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Czy zwrocic bilet?(tak/nie)");
		String potwierdzenie;

		System.out.println(zgloszenie.getTemat());
		System.out.println(zgloszenie.getEmail());
		System.out.println(zgloszenie.getTrescWiadomosci());
		System.out.println(zgloszenie.getDataWyslania());

		potwierdzenie = scanner.nextLine();

		if(potwierdzenie.equals("tak")) return true;
		if(potwierdzenie.equals("nie")) return false;

		return false;

	}
	private boolean czyOdpowiedziecNaZapytanie(Zgloszenie zgloszenie)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println(zgloszenie.getTemat());
		System.out.println(zgloszenie.getEmail());
		System.out.println(zgloszenie.getTrescWiadomosci());
		System.out.println(zgloszenie.getDataWyslania());
		System.out.println("Czy chcesz odpowiedziec na zgloszenie(tak/nie)");

		String potwierdzenie;
		potwierdzenie = scanner.nextLine();

		if(potwierdzenie.equals("tak")) return true;
		else if (potwierdzenie.equals("nie")) return false;

		return false;

	}

	private String podajWiadomosc()
	{
		Scanner scanner = new Scanner(System.in);


		return scanner.nextLine();
	}

}