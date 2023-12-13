package Aplikacja;

public class Bilet {

	private String email;
	private int numerBiletu;
	private String nazwaAtrakcji;
	private String dataAtrakcji;
	private String lokalizacja;
	private String cenaBiletu;
	private String dataZakupu;

	/**
	 * 
	 * @param atrakcja
	 */
	public void utworzBilet(Atrakcja atrakcja) {
		// TODO - implement Bilet.utworzBilet
		throw new UnsupportedOperationException();
	}

	public String getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumerBiletu() {
		return this.numerBiletu;
	}

	/**
	 * 
	 * @param numerBiletu
	 */
	public void setNumerBiletu(int numerBiletu) {
		this.numerBiletu = numerBiletu;
	}

	public String getNazwaAtrakcji() {
		return this.nazwaAtrakcji;
	}

	/**
	 * 
	 * @param nazwaAtrakcji
	 */
	public void setNazwaAtrakcji(String nazwaAtrakcji) {
		this.nazwaAtrakcji = nazwaAtrakcji;
	}

	public String getDataAtrakcji() {
		return this.dataAtrakcji;
	}

	/**
	 * 
	 * @param dataAtrakcji
	 */
	public void setDataAtrakcji(String dataAtrakcji) {
		this.dataAtrakcji = dataAtrakcji;
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

	public String getCenaBiletu() {
		return this.cenaBiletu;
	}

	/**
	 * 
	 * @param cenaBiletu
	 */
	public void setCenaBiletu(String cenaBiletu) {
		this.cenaBiletu = cenaBiletu;
	}

	public String getDataZakupu() {
		return this.dataZakupu;
	}

	/**
	 * 
	 * @param dataZakupu
	 */
	public void setDataZakupu(String dataZakupu) {
		this.dataZakupu = dataZakupu;
	}

}