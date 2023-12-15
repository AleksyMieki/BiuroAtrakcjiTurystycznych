package Aplikacja;

public class MenedzerWiadomosci {

	public void wyslijWiadomosc(Zgloszenie zgloszenie, String wiadomosc) {

		System.out.println("wyslalem wiadomosc " + wiadomosc + " na zgloszenie o tym temacie: " + zgloszenie.getTemat());
	}

	public boolean sprawdzenieMaila(String mail) {
		return true;
	}

	public boolean sprawdzenieTematu(String temat) {

		if(temat.equals("Zwrot biletu"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}