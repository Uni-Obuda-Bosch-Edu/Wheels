package SharedMemory;

public interface IWheelsRet {
	
	 /**
	  * @return A j�rm� tengelyk�z�ppontj�nak x koordin�t�ja
	  */
	 double getTengelyKozeppontKoordinataX();
	 
	 /**
	  * @return A j�rm� tengelyk�z�ppontj�nak y koordin�t�ja
	  */
	 double getTengelyKozeppontKoordinataY();
	 
	 
	 /**
	  * @return A j�rm� mozg�svektor�nak (helyvektor) x koordin�t�j�t, ahol a vektor hossza megadja a j�rm� sebess�g�t 1:1 ar�nyban kilom�ter/�r�ban
	  */
	 double getMozgasVektorX();
	 
	 /**
	  * @return A j�rm� mozg�svektor�nak (helyvektor) y koordin�t�j�t, ahol a vektor hossza megadja a j�rm� sebess�g�t 1:1 ar�nyban kilom�ter/�r�ban
	  */
	 double getMozgasVektorY();
}
