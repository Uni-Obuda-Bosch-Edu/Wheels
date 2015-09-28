package SharedMemory;

public interface IWheelsRet {
	
	 /**
	  * @return A jármû tengelyközéppontjának x koordinátája
	  */
	 double getTengelyKozeppontKoordinataX();
	 
	 /**
	  * @return A jármû tengelyközéppontjának y koordinátája
	  */
	 double getTengelyKozeppontKoordinataY();
	 
	 
	 /**
	  * @return A jármû mozgásvektorának (helyvektor) x koordinátáját, ahol a vektor hossza megadja a jármû sebességét 1:1 arányban kilométer/órában
	  */
	 double getMozgasVektorX();
	 
	 /**
	  * @return A jármû mozgásvektorának (helyvektor) y koordinátáját, ahol a vektor hossza megadja a jármû sebességét 1:1 arányban kilométer/órában
	  */
	 double getMozgasVektorY();
}
