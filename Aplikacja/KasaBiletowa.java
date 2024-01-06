package Aplikacja;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class KasaBiletowa {

	private ArrayList<Bilet> listaBiletow = new ArrayList<>();

	public KasaBiletowa()
	{
		Bilet bilet = new Bilet("a@gmail.com",1,"piza","2024-01-06 20:50:20","luwr",124,"10.10.2023");
		Bilet bilet2 = new Bilet("a@gmail.com",2,"piza","2024-01-07 20:49:10","luwr2",123,"11.10.2023");
		Bilet bilet3 = new Bilet("a@gmail.com",3,"piza","12.12.2023","luwr3",120,"12.10.2023");

		listaBiletow.add(bilet);
		listaBiletow.add(bilet2);
		listaBiletow.add(bilet3);

	}
	public boolean sprawdzDateWydarzenia(Bilet bilet) {

		SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dataNaBilecie = null;
		String dateString = data.format(new Date());
		Date teraz = null;

		try {
			dataNaBilecie = data.parse(bilet.getDataAtrakcji());

			teraz = data.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}


		long timeDifference = dataNaBilecie.getTime() - teraz.getTime();

		long roznicaDni = (timeDifference / (1000*60*60*24)) % 365;

		if(roznicaDni > 0)
		{
			System.out.println(bilet.getDataAtrakcji());
			System.out.println(dateString);

			return true;
		}

		return false;
	}

	public void zwrocBilet(Zgloszenie zgloszenie) {

		System.out.println("Zwrocono bilet o temacie " + zgloszenie.getTemat() + "zakupionego przez uzytkownika " + zgloszenie.getEmail() );

	}
	public void zwrocBilet(Bilet bilet) {

		listaBiletow.remove(bilet);

		System.out.println("Zwrocono bilet poprzez zwroc bilet" );

	}

	public void kupBilet(Atrakcja atrakcja) {
		SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = data.format(new Date());
		listaBiletow.add(new Bilet("a@gmail.com",listaBiletow.size()+1,atrakcja.getNazwa(),atrakcja.getCzasOtwarcia(),atrakcja.getLokalizacja(),atrakcja.getCena(),dateString));

	}

	public Bilet wyszukajBilet(int id) {

		Bilet znalezionyBilet = listaBiletow.stream()
				.filter(bilet -> id == bilet.getNumerBiletu())
				.findAny()
				.orElse(null);

		return znalezionyBilet;
	}

}