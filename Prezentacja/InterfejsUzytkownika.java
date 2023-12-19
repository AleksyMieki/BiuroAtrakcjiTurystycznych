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

	private String podajNazwe() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	private boolean czyKupicBilet() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("""
						Czy kupić bilet?
						1. tak
						aby nie kupować biletu, wprowadź dowolny znak
						""");

		String wybor = scanner.nextLine();

		switch (wybor) {
			case "1": {
				return true;
			}
			default: {
				return false;
			}
		}
    }

	protected Atrakcja wyszukajAtrakcje(boolean czyZalogowany) {

		System.out.println("Podaj nazwę szukanej atrakcji:");

		String nazwa = podajNazwe();

		Atrakcja atrakcja = aplikacja.wyszukajAtrakcje(nazwa);

		if(atrakcja == null){
			return null;
		}

		if(czyZalogowany)
		{
			System.out.println("atrakcja znaleziona dla pracownika");
			return atrakcja;
		}

		if(czyKupicBilet())
		{
			System.out.println("IMPLEMENTACJA KUP BILET");;
		}

		return atrakcja;
	}

	private void wyslijZapytanieDoPracownika() {

		Bilet bilet;
		String wiadomosc;
		String email;
		String temat;
		int numerBiletu;

		do {
			System.out.println("Podaj swojego maila");
			email = podajMaila();
		}while(!aplikacja.getMenedzerWiadomosci().sprawdzenieMaila(email));

		System.out.println("Podaj temat wiadomosci(jesli chcesz zwrocic bilet wpisz zwrot biletu)");
		temat = podajTemat();

		if(aplikacja.getMenedzerWiadomosci().sprawdzenieTematu(temat))
		{
			System.out.println("Podaj numer biletu");

			numerBiletu = podajNumerBiletu();

			bilet = aplikacja.getKasaBiletowa().wyszukajBilet(numerBiletu);

			if(bilet == null )
			{
				System.out.println("nie istnieje taki bilet");
				return;
			}
			if(aplikacja.getKasaBiletowa().sprawdzDateWydarzenia(bilet)) {
				aplikacja.getKasaBiletowa().zwrocBilet(bilet);
				return;
			}

		}


			System.out.println("Podaj tresc twojej wiadomosci");
			wiadomosc = podajTrescWiadomosci();

			Zgloszenie zgloszenie = new Zgloszenie(temat,email,aplikacja.getListaZgloszen().size() + 1,wiadomosc,"12.12.2024");
			aplikacja.getListaZgloszen().add(zgloszenie);

			aplikacja.getMenedzerWiadomosci().wyslijWiadomosc(zgloszenie);

			System.out.println("twoje zgloszenie zostalo wyslane\n" + zgloszenie.getEmail() + "\n" + zgloszenie.getTemat() +"\n" + zgloszenie.getTrescWiadomosci());


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

	private String podajMaila() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	private String podajTemat()
	{
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	private int podajNumerBiletu() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	private String podajTrescWiadomosci() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
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

						Atrakcja atrakcja = ui.wyszukajAtrakcje(ui.czyZalogowany);
						
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
						pracownikUI.przegladajZgloszenia();
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