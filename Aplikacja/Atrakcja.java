package Aplikacja;

import java.math.BigDecimal;

public class Atrakcja {

	private String nazwa;
	private float cena;
	private String czasOtwarcia;
	private String lokalizacja;

	/**
	 * @param nazwa
	 * @param cena
	 * @param czasOtwarcia
	 * @param lokalizacja
	 */
	//TODO uzywac tylko jednego konstruktora
	public Atrakcja(String nazwa, float cena, String czasOtwarcia, String lokalizacja) {
		this.nazwa = nazwa;
		this.cena = cena;
		this.czasOtwarcia = czasOtwarcia;
		this.lokalizacja = lokalizacja;
	}




	public String getNazwa() {
		return this.nazwa;
	}

	/**
	 * 
	 * @param nazwa
	 */
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public float getCena() {
		return this.cena;
	}

	/**
	 * 
	 * @param cena
	 */
	public void setCena(float cena) {
		this.cena = cena;
	}

	public String getCzasOtwarcia() {
		return this.czasOtwarcia;
	}

	/**
	 * 
	 * @param czasOtwarcia
	 */
	public void setCzasOtwarcia(String czasOtwarcia) {
		this.czasOtwarcia = czasOtwarcia;
	}

	public String getLokalizacja() {
		return this.lokalizacja;
	}

	/**
	 * 
	 * @param lokalizacja
	 */
	public void setLokalizacja(String lokalizacja) {
		this.lokalizacja = lokalizacja;
	}

	/**
	 * 
	 * @param nazwa
	 * @param cena
	 * @param czasOtwarcia
	 * @param lokalizacja
	 */

	/**
	 * 
	 * @param atrybutyAtrakcji
	 */
	public Atrakcja(Dane atrybutyAtrakcji) {
		this.nazwa = atrybutyAtrakcji.getNazwa();
		this.cena = atrybutyAtrakcji.getCena();
		this.czasOtwarcia = atrybutyAtrakcji.getCzasOtwarcia();
		this.lokalizacja = atrybutyAtrakcji.getLokalizacja();
	}

}