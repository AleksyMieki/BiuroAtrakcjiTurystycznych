package Aplikacja;

import java.util.*;

public class KasaBiletowa {

	private Collection<Bilet> listaBiletow = new ArrayList<>();

	public KasaBiletowa()
	{
		Bilet bilet = new Bilet("a@gmail.com",1,"piza","12.12.2023","luwr",12,"10.10.2023");
		Bilet bilet2 = new Bilet("a@gmail.com",2,"piza","12.12.2023","luwr",12,"11.10.2023");
		Bilet bilet3 = new Bilet("a@gmail.com",3,"piza","12.12.2023","luwr",12,"12.10.2023");

		listaBiletow.add(bilet);
		listaBiletow.add(bilet2);
		listaBiletow.add(bilet3);

	}
	public boolean sprawdzDateWydarzenia(Bilet bilet) {

		if(bilet.getDataAtrakcji().equals("10.10.2023")) return true;
		return false;
	}

	public void zwrocBiletPrzezZgloszenie(Zgloszenie zgloszenie) {

		System.out.println("Zwrocono bilet o temacie " + zgloszenie.getTemat() + "zakupionego przez uzytkownika " + zgloszenie.getEmail() );

		return;
	}
	public void zwrocBilet(Bilet bilet) {

		System.out.println("Zwrocono bilet poprzez zwroc bilet" );

		return;
	}

	public void kubBilet() {
		// TODO - implement KasaBiletowa.kubBilet
		throw new UnsupportedOperationException();
	}

	public Bilet wyszukajBilet(int id) {

		Bilet znalezionyBilet = null;
		for (Bilet bilet : listaBiletow) {
			if (bilet.getNumerBiletu() == id) {
				znalezionyBilet = bilet;
				break;
			}
		}

		if(znalezionyBilet != null) return znalezionyBilet;
		return null;
	}

}