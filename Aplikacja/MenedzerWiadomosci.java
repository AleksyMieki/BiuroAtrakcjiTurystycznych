package Aplikacja;

import java.util.Locale;

public class MenedzerWiadomosci {

	public void wyslijWiadomosc(Zgloszenie zgloszenie, String wiadomosc) {

		System.out.println("wyslalem wiadomosc " + wiadomosc + " na zgloszenie o tym temacie: " + zgloszenie.getTemat());
	}

	public void wyslijWiadomosc(Zgloszenie wiadomosc)
	{

	}

	public boolean sprawdzenieMaila(String mail) {
		return true;
	}

	public boolean sprawdzenieTematu(String temat) {

		temat.toLowerCase(Locale.ROOT);

		if(temat.equals("zwrot biletu"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}