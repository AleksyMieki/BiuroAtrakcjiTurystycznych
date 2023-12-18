package Prezentacja;

import Aplikacja.*;

import java.math.BigDecimal;
import java.util.Scanner;

public class InterfejsUzytkownika {

	private Dane dane;
	private boolean czyZalogowany = false;
	Aplikacja aplikacja = Aplikacja.getInstance();

	private void zaloguj() {

		Scanner scanner = new Scanner(System.in);
		String haslo = "";

		haslo = scanner.nextLine();

		if (haslo.equals("1234")) czyZalogowany = true;

	}

	protected Atrakcja wyszukajAtrakcje(String nazwa, boolean czyZalogowany) {

		Atrakcja atrakcja = aplikacja.wyszukajAtrakcje(nazwa,czyZalogowany);

		if(czyZalogowany && atrakcja != null)
		{
			System.out.println("atrakcja znaleziona dla pracownika");
			return atrakcja;
		}
		else if(atrakcja != null)
		{

			System.out.println("IMPLEMENTACJA KUP BILET");

			return atrakcja;
		}
		return null;

	}

	private void wyslijZapytanieDoPracownika() {
		Scanner scanner = new Scanner(System.in);
		String wiadomosc;

		do {
			System.out.println("Podaj swojego maila");
			wiadomosc = scanner.nextLine();
		}while(!aplikacja.getMenedzerWiadomosci().sprawdzenieMaila(wiadomosc));

		System.out.println("Podaj temat wiadomosci");

		if(aplikacja.getMenedzerWiadomosci().sprawdzenieTematu(scanner.nextLine()))
		{
			System.out.println("Podaj numer biletu");
			aplikacja.getKasaBiletowa().wyszukajBilet(podajNumerBIletu());
			//TODO finish this
		}
		else{

			System.out.println("Podaj tresc twojej wiadomosci");
			podajTrescWiadomosci();

		}

	}

	private void wyswietlDaneAtrakcji(Atrakcja atrakcja)
	{
		if(atrakcja != null) {
			System.out.println("OTO DANE ATRAKCJI");
			System.out.println(atrakcja.getNazwa());
			System.out.println(atrakcja.getCena());
			System.out.println(atrakcja.getCzasOtwarcia());
			System.out.println(atrakcja.getLokalizacja());
		}
		else{
			System.out.println("nie znaleziono atrakcji o podanej nazwie\n");
		}
	}

	private void podajMaila() {
		// TODO - implement InterfejsUzytkownika.podajMaila
		throw new UnsupportedOperationException();
	}

	private int podajNumerBIletu() {

		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();

	}

	private String podajTrescWiadomosci() {

		Scanner scanner = new Scanner(System.in);

		return scanner.nextLine();
	}

	private void podajTemat() {
		// TODO - implement InterfejsUzytkownika.podajTemat
		throw new UnsupportedOperationException();
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		InterfejsUzytkownika ui = new InterfejsUzytkownika();
		InterfejsPracownika pracownikUI = new InterfejsPracownika();

		int wybor = 0;

		while (true)
		{
			if(!ui.czyZalogowany) {

				System.out.println("""
						Dokonaj wyboru akcji
						1. Zaloguj 1234
						2. Wyszukaj Atrakcje
						3. Wyslij Zapytanie
						""");

				wybor = scanner.nextInt();

				switch (wybor) {
					case 1:

						System.out.println("podaj haslo\n");
						ui.zaloguj();
						break;

					case 2:

						scanner.nextLine();
						System.out.println("Podaj nazwe atrakcji");
						String nazwa = scanner.nextLine();

						Atrakcja atrakcja = ui.wyszukajAtrakcje(nazwa, ui.czyZalogowany);
						
						ui.wyswietlDaneAtrakcji(atrakcja);

						break;
					case 3:
						ui.wyslijZapytanieDoPracownika();
						break;
					case 4:
						break;
				}
			}
			else
			{
				System.out.println("""
						Dokonaj wyboru akcji
						1. Zarzadzaj Atrakcja
						2. Przegladaj zapytania uzytkownikow
						3. Zarzadzaj zapytaniami klientow
						4. wyloguj
						""");

				wybor = scanner.nextInt();

				switch (wybor) {
					case 1:
						pracownikUI.zarzadzajAtrakcja(ui.czyZalogowany);
						break;
					case 2:
						pracownikUI.przegladajZakupioneBilety();
						break;
					case 3:
						pracownikUI.zarzadzajZapytaniamiKlientow();
						break;
					case 4:
						ui.czyZalogowany = false;

						break;

				}
			}
		}

	}

}