package Prezentacja;


import Aplikacja.Atrakcja;
import Aplikacja.Dane;
import java.math.BigDecimal;
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
		if(atrakcja != null)
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

	/**
	 * 
	 * @param czyZalogowany
	 */
	private void przegladajZakupioneBilety(boolean czyZalogowany) {

		throw new UnsupportedOperationException();
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

	private void zarzadzajZapytaniamiKlientow() {
		// TODO - implement InterfejsPracownika.zarzadzajZapytaniamiKlientow
		throw new UnsupportedOperationException();
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
	private void podajDaneDoEdytcji() {
		// TODO - implement InterfejsPracownika.podajDaneDoEdytcji
		throw new UnsupportedOperationException();
	}

}