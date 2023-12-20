package Aplikacja;

public class Dane {

	private String nazwa;
	private float cena;
	private String czasOtwarcia;
	private String lokalizacja;

	/**
	 * 
	 * @param nazwa
	 * @param cena
	 * @param czasOtwarcia
	 * @param lokalizacja
	 */
	public Dane(String nazwa, float cena, String czasOtwarcia, String lokalizacja) {
		// TODO - implement Dane.Dane
		this.nazwa = nazwa;
		this.cena = cena;
		this.czasOtwarcia = czasOtwarcia;
		this.lokalizacja = lokalizacja;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public float getCena() {
		return this.cena;
	}

	public String getCzasOtwarcia() {
		return this.czasOtwarcia;
	}

	public String getLokalizacja() {
		return this.lokalizacja;
	}

}