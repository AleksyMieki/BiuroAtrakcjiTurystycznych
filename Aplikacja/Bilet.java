package Aplikacja;

public class Bilet {

	private String email;
	private int numerBiletu;
	private Atrakcja atrakcja;
	private String dataAtrakcji;
	private String dataZakupu;

	public Bilet(String email, int numerBiletu, String nazwaAtrakcji, String dataAtrakcji, String lokalizacja, float cenaBiletu, String dataZakupu) {
		this.email = email;
		this.numerBiletu = numerBiletu;
		this.dataAtrakcji = dataAtrakcji;
		this.dataZakupu = dataZakupu;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumerBiletu() {
		return this.numerBiletu;
	}

	public void setNumerBiletu(int numerBiletu) {
		this.numerBiletu = numerBiletu;
	}

	public String getDataAtrakcji() {
		return this.dataAtrakcji;
	}

	public String getDataZakupu() {
		return this.dataZakupu;
	}

	public void setDataZakupu(String dataZakupu) {
		this.dataZakupu = dataZakupu;
	}

}