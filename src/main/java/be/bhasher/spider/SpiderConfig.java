package be.bhasher.spider;

/**
 * Class managing the entire configuration.
 */
public class SpiderConfig {

	/**
	 * Get the tolerance from the config file.
	 * @return the tolerance.
	 */
	public static Double getTolerance(){
		return Spider.getInstance().getConfig().getDouble("cheat.tolerance");
	}

}
