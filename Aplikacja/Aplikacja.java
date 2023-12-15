package Aplikacja;

import java.util.*;
import java.util.Scanner;

public class Aplikacja {

	private static Aplikacja instance; // Statyczna instancja

	private Collection<Atrakcja> listaAtrakcji = new ArrayList<>();
	private int indeksAtrakcji;
	private Atrakcja znalezionaAtrakcja;
	private Collection<Zgloszenie> listaZgloszen = new ArrayList<>();
	private KasaBiletowa kasaBiletowa;
	private MenedzerWiadomosci menedzerWiadomosci;
	private Atrakcja atrakcja;

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

		listaAtrakcji.add(new Atrakcja(dane));
		listaAtrakcji.add(new Atrakcja(dane2));
		listaAtrakcji.add(new Atrakcja(dane3));
	}
	public Atrakcja getAtrakcja() {
		return atrakcja;
	}

	/**
	 * 
	 * @param nazwa
	 * @param czyZalogowany
	 */

	public Atrakcja wyszukajAtrakcje(String nazwa, boolean czyZalogowany) {


		Atrakcja znalezionaAtrakcja = null;
		for (Atrakcja atrakcja : listaAtrakcji) {
			if (atrakcja.getNazwa().equals(nazwa)) {
				znalezionaAtrakcja = atrakcja;
				break;
			}
		}

		if(znalezionaAtrakcja != null) {
			return znalezionaAtrakcja;
		}
		return null;
	}
	public Zgloszenie getZgloszenieById(int id)
	{
		Zgloszenie znalezioneZgloszenie = null;
		for (Zgloszenie z : listaZgloszen) {
			if (z.getId() == id) {
				znalezioneZgloszenie = z;
				break;
			}
		}

		if(znalezioneZgloszenie != null) {
			return znalezioneZgloszenie;
		}
		return null;
	}
	/**
	 * 
	 * @param dane
	 */
	public boolean sprawdzPoprawnosc(Dane dane) {


		return false;
	}

	public Collection<Atrakcja> getListaAtrakcji() {
		return listaAtrakcji;
	}

	public Collection<Zgloszenie> getListaZgloszen() {
		return this.listaZgloszen;
	}

	public void usunAtrakcje(Atrakcja atrakcjaDoUsuniecia) {
		listaAtrakcji.removeIf(atrakcja -> atrakcja.getNazwa().equals(atrakcjaDoUsuniecia.getNazwa()));
	}

	public void edytujAtrakcje(Atrakcja atrakcja, Dane daneDoEdycji) {

		atrakcja.setNazwa(daneDoEdycji.getNazwa());
		atrakcja.setCena(daneDoEdycji.getCena());
		atrakcja.setCzasOtwarcia(daneDoEdycji.getCzasOtwarcia());
		atrakcja.setLokalizacja(daneDoEdycji.getLokalizacja());

	}

	/**
	 * 
	 * @param atrybutyAtrakcji
	 */
	public void utworzAtrakcje(Dane atrybutyAtrakcji) {

		Atrakcja nowaAtrakcja = new Atrakcja(atrybutyAtrakcji.getNazwa(),atrybutyAtrakcji.getCena(),atrybutyAtrakcji.getCzasOtwarcia(),atrybutyAtrakcji.getLokalizacja());
		listaAtrakcji.add(nowaAtrakcja);

		return;
	}
	public void zwrocBilet(Zgloszenie zgloszenie)
	{
		kasaBiletowa.zwrocBilet();
	}

	public MenedzerWiadomosci getMenedzerWiadomosci()
	{
		return menedzerWiadomosci;
	}
	public KasaBiletowa getKasaBiletowa()
	{
		return kasaBiletowa;
	}
}