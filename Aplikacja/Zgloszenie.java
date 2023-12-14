package Aplikacja;

public class Zgloszenie {

	private String temat;
	private String email;
	private int id;
	private String trescWiadomosci;
	private String dataWyslania;

	public void utworzZgloszenie() {
		// TODO - implement Zgloszenie.utworzZgloszenie
		throw new UnsupportedOperationException();
	}

	public String getDataWyslania() {
		return this.dataWyslania;
	}

	/**
	 * 
	 * @param dataWyslania
	 */
	public void setDataWyslania(String dataWyslania) {
		this.dataWyslania = dataWyslania;
	}

	public String getTemat() {
		return temat;
	}

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}

	public String getTrescWiadomosci() {
		return trescWiadomosci;
	}
}