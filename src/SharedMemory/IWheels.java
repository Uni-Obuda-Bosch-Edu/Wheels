package SharedMemory;

public interface IWheels {

	/**
	 * A forgat�nyomat�k (r�viden: nyomat�k) egy adott er�hat�s adott
	 * k�z�ppontra val� forgat�k�pess�g�t megad� fizikai mennyis�g. Jele M. A
	 * forgat�nyomat�k az F er� �s az O k�z�ppontt�l az er� t�mad�spontj�ba
	 * mutat� r vektor, az er�kar vektori�lis szorzata.
	 * 
	 * @return Jelenleg a meghajt� tengelyre (tengelyekre) hat� forgat�nyomat�k (N-ban)
	 */
	double getForgatoNyomatekN();

	/**
	 * @return A j�rm� milyen ker�kmeghajt�s� (els�, h�ts�, �ssz)
	 */
	Meghajtas getKerekMeghajtas();

	/**
	 * @return Az �t �s a ker�k anyaga k�z�tti tapad�si s�rl�d�si egy�tthat�t,
	 *         azaz m�-t
	 */
	double getTapadasiSurlodasiEgyutthatoUt();

	/**
	 * @return A f�kped�l �ll�s�t 0-100% ig
	 */
	double getFekAllas();
	
	/**
	 * @return A ker�kt�rcs�ra a f�kez�m� �ltal gyakorolhat� maximum nyom�st N-ban
	 */
	double getFekHidraulikusNyomasN();

	/**
	 * @return A ker�kt�rcsa �s a f�kek k�z�tti tapad�si s�rl�d�si egy�tthat�t
	 */
	double getTapadasiSurlodasiEgyutthatoFek();

	/**
	 * @return A meghajt� tengely sugr�t cenitm�terben
	 */
	double gettengelySugaraCm();

	/**
	 * @return A kerekek sugar�t centim�terben
	 */
	double getKerekSugaraCm();

	/**
	 * @return A kerekek sz�less�g�t centim�terben
	 */
	double getKerekSzelessegCm();

	/**
	 * @return A korm�ny �ll�sfoka -100-t�l +100%-ig
	 */
	double getKormanyAllasFok();

	/**
	 * @return A ker�k maxim�lis elfordul�sa a 0-hoz k�pest (0-90 fok)
	 */
	double getKereMaxSzog();

	/**
	 * @return A tengely hossza amelyen a k�t el�ls� ker�k nyugszik
	 */
	double getTengelyt�vCm();

	/**
	 * @return A j�rm� �sszt�meg�t kilogramban
	 */
	double getJarmuOssztomegKg();

}
