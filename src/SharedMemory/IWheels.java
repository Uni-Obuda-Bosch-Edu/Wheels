package SharedMemory;

public interface IWheels {
	
	/**
	 * A kormány állásfoka a 0*-hoz viszonyítva
	 * @return
	 */
	double getKormanyAllasFok();
	
	/**
	 * A forgatónyomaték (röviden: nyomaték) 
	 * egy adott erõhatás adott középpontra való forgatóképességét megadó fizikai mennyiség. 
	 * Jele M. 
	 * A forgatónyomaték az F erõ és az O középponttól az erõ támadáspontjába mutató r vektor, 
	 * az erõkar vektoriális szorzata.
	 * @return
	 */
	double getForgatoNyomatekN();
	
	/**
	 * Az út és a kerék anyaga közötti Tapadási súrlódási együttható, azaz mü
	 * @return
	 */
	double getTapadasiSurlodasiEgyutthatoUt();
	
/////////	
	/**
	 * A maximális erõ hány százalékával fékez a gépjármû
	 * @return
	 */
	double getFekPozicioSzazalek();
	
	/**
	 * A jármû maximális fékezõereje a forgatónyomaték ellenében
	 * @return
	 */
	double getFekezoeroMaxN();
	
	//VAGY:
	
	/**
	 * A keréktárcsára ható nyomás
	 * @return
	 */
	double getFekHidraulikusNyomasN();
	
	/**
	 * A keréktárcsa és a fékek közötti tapadási súrlódási együttható
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
