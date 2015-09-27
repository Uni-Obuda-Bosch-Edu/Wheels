package SharedMemory;

public interface IWheels {
	
	/**
	 * A korm�ny �ll�sfoka a 0*-hoz viszony�tva
	 * @return
	 */
	double getKormanyAllasFok();
	
	/**
	 * A forgat�nyomat�k (r�viden: nyomat�k) 
	 * egy adott er�hat�s adott k�z�ppontra val� forgat�k�pess�g�t megad� fizikai mennyis�g. 
	 * Jele M. 
	 * A forgat�nyomat�k az F er� �s az O k�z�ppontt�l az er� t�mad�spontj�ba mutat� r vektor, 
	 * az er�kar vektori�lis szorzata.
	 * @return
	 */
	double getForgatoNyomatekN();
	
	/**
	 * Az �t �s a ker�k anyaga k�z�tti Tapad�si s�rl�d�si egy�tthat�, azaz m�
	 * @return
	 */
	double getTapadasiSurlodasiEgyutthatoUt();
	
/////////	
	/**
	 * A maxim�lis er� h�ny sz�zal�k�val f�kez a g�pj�rm�
	 * @return
	 */
	double getFekPozicioSzazalek();
	
	/**
	 * A j�rm� maxim�lis f�kez�ereje a forgat�nyomat�k ellen�ben
	 * @return
	 */
	double getFekezoeroMaxN();
	
	//VAGY:
	
	/**
	 * A ker�kt�rcs�ra hat� nyom�s
	 * @return
	 */
	double getFekHidraulikusNyomasN();
	
	/**
	 * A ker�kt�rcsa �s a f�kek k�z�tti tapad�si s�rl�d�si egy�tthat�
	 * @return
	 */
	double getTapadasiSurlodasiEgyutthatoFek();
//////////	
	
	
	/**
	 * 
	 * @return
	 */
	double gettengelySugaraCm();
	
	/**
	 * 
	 * @return
	 */
	double getkerekSugaraCm();
	
	/**
	 * 
	 * @return
	 */
	double getJarmuOssztomegKg();
	
	
}
