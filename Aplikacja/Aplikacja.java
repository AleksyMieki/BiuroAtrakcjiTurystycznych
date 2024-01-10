package Aplikacja;

import java.text.SimpleDateFormat;
import java.util.*;

public class Aplikacja {

	private static Aplikacja instance; // Statyczna instancja

	private ArrayList<Atrakcja> listaAtrakcji = new ArrayList<>();
	private ArrayList<Zgloszenie> listaZgloszen = new ArrayList<>();
	public KasaBiletowa kasaBiletowa = new KasaBiletowa();
	public MenedzerWiadomosci menedzerWiadomosci = new MenedzerWiadomosci();

	public static Aplikacja getInstance() {
		if (instance == null) {
			instance = new Aplikacja();
		}
		return instance;
	}

	private Aplikacja()
	{
		Dane dane = new Dane("piza",1,"aaa","aaa");
		Dane dane2 = new Dane("luwr",1,"aaa","aaa");
		Dane dane3 = new Dane("mona",1,"aaa","aaa");

		Zgloszenie zgloszenie = new Zgloszenie("zwrot biletu", "a@.pl",1,"tresc wiadomosci numer 1", "12.12.2023");
		Zgloszenie zgloszenie2 = new Zgloszenie("kiedy otwarcie", "a@.pl",2,"tresc wiadomosci numer 2", "12.12.2023");

		kasaBiletowa.kupBilet(listaAtrakcji.get(0));
		kasaBiletowa.kupBilet(listaAtrakcji.get(1));
		kasaBiletowa.kupBilet(listaAtrakcji.get(2));

		listaZgloszen.add(zgloszenie);
		listaZgloszen.add(zgloszenie2);
		listaAtrakcji.add(new Atrakcja(dane));
		listaAtrakcji.add(new Atrakcja(dane2));
		listaAtrakcji.add(new Atrakcja(dane3));
	}

	/**
	 *
	 * @param nazwa
	 */

	public Atrakcja wyszukajAtrakcje(String nazwa) {

		Atrakcja znalezionaAtrakcja = listaAtrakcji.stream()
				.filter(atrakcja -> nazwa.equals(atrakcja.getNazwa()))
				.findAny()
				.orElse(null);

		return znalezionaAtrakcja;
	}
	/**
	 *
	 * @param dane
	 */
	public boolean sprawdzPoprawnosc(Dane dane) {

		if(dane.getLokalizacja() == "luwr" || dane.getLokalizacja() == "Paryz") return true;

		return false;
	}

	public ArrayList<Zgloszenie> getListaZgloszen() {
		return this.listaZgloszen;
	}

	public void usunAtrakcje(Atrakcja atrakcja) {
		listaAtrakcji.remove(atrakcja);
	}


	public void edytujAtrakcje(Atrakcja atrakcja, Dane daneDoEdycji) {
		atrakcja.setNazwa(daneDoEdycji.getNazwa());
		atrakcja.setCena(daneDoEdycji.getCena());
		atrakcja.setDataAtrakcji(daneDoEdycji.getDataAtrakcji());
		atrakcja.setLokalizacja(daneDoEdycji.getLokalizacja());
	}

	public Zgloszenie getZgloszenieById(int id)
	{
		Zgloszenie znalezioneZgloszenie = listaZgloszen.stream()
				.filter(zgloszenie -> id == zgloszenie.getId())
				.findAny()
				.orElse(null);

		return znalezioneZgloszenie;
	}



	public void utworzZgloszenie(String email, String temat, String wiadomosc)
	{
		SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dataWyslania = data.format(new Date());

		Zgloszenie zgloszenie = new Zgloszenie(temat,email,listaZgloszen.size()+1 , wiadomosc ,dataWyslania);

		listaZgloszen.add(zgloszenie);

		menedzerWiadomosci.wyslijWiadomosc(zgloszenie);

	}

	/**
	 *
	 * @param atrybutyAtrakcji
	 */
	public void utworzAtrakcje(Dane atrybutyAtrakcji) {

		Atrakcja atrakcja = new Atrakcja(atrybutyAtrakcji.getNazwa(),atrybutyAtrakcji.getCena(),
				atrybutyAtrakcji.getDataAtrakcji(),atrybutyAtrakcji.getLokalizacja());

		listaAtrakcji.add(atrakcja);

	}

}