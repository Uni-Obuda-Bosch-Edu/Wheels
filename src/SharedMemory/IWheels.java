package SharedMemory;

public interface IWheels {

	/**
	 * A forgatónyomaték (röviden: nyomaték) egy adott erõhatás adott
	 * középpontra való forgatóképességét megadó fizikai mennyiség. Jele M. A
	 * forgatónyomaték az F erõ és az O középponttól az erõ támadáspontjába
	 * mutató r vektor, az erõkar vektoriális szorzata.
	 * 
	 * @return Jelenleg a meghajtó tengelyre (tengelyekre) ható forgatónyomaték (N-ban)
	 */
	double getForgatoNyomatekN();

	/**
	 * @return A jármû milyen kerékmeghajtású (elsõ, hátsó, össz)
	 */
	Meghajtas getKerekMeghajtas();

	/**
	 * @return Az út és a kerék anyaga közötti tapadási súrlódási együtthatót,
	 *         azaz mü-t
	 */
	double getTapadasiSurlodasiEgyutthatoUt();

	/**
	 * @return A fékpedál állását 0-100% ig
	 */
	double getFekAllas();
	
	/**
	 * @return A keréktárcsára a fékezõmû által gyakorolható maximum nyomást N-ban
	 */
	double getFekHidraulikusNyomasN();

	/**
	 * @return A keréktárcsa és a fékek közötti tapadási súrlódási együtthatót
	 */
	double getTapadasiSurlodasiEgyutthatoFek();

	/**
	 * @return A meghajtó tengely sugrát cenitméterben
	 */
	double gettengelySugaraCm();

	/**
	 * @return A kerekek sugarát centiméterben
	 */
	double getKerekSugaraCm();

	/**
	 * @return A kerekek szélességét centiméterben
	 */
	double getKerekSzelessegCm();

	/**
	 * @return A kormány állásfoka -100-tól +100%-ig
	 */
	double getKormanyAllasFok();

	/**
	 * @return A kerék maximális elfordulása a 0-hoz képest (0-90 fok)
	 */
	double getKereMaxSzog();

	/**
	 * @return A tengely hossza amelyen a két elülsõ kerék nyugszik
	 */
	double getTengelytávCm();

	/**
	 * @return A jármû össztömegét kilogramban
	 */
	double getJarmuOssztomegKg();

}
