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
		// TODO - implement InterfejsUzytkownika.wyslijZapytanieDoPracownika
		throw new UnsupportedOperationException();
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

	private void podajNumerBIletu() {
		// TODO - implement InterfejsUzytkownika.podajNumerBIletu
		throw new UnsupportedOperationException();
	}

	private void podajTrescWiadomosci() {
		// TODO - implement InterfejsUzytkownika.podajTrescWiadomosci
		throw new UnsupportedOperationException();
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
						2. wyloguj
						""");

				wybor = scanner.nextInt();

				switch (wybor) {
					case 1:
						pracownikUI.zarzadzajAtrakcja(ui.czyZalogowany);
						break;
					case 2:
						ui.czyZalogowany = false;
						break;
					case 3:

						pracownikUI.zarzadzajZapytaniamiKlientow();
						break;

					case 4:
						break;

				}
			}
		}

	}

}