package be.bhasher.spider;

/**
 * Class managing the entire configuration.
 */
public class SpiderConfig {

	/**
	 * Check if it is necessary to use the walkspeed.
	 * @return if using walkspeed.
	 */
	public static boolean isUsingWalkSpeed(){
		return Spider.getInstance().getConfig().getBoolean("cheat.speedhack.usingwalkspeed", true);
	}

	/**
	 * Check if it is necessary to use the walkspeed.
	 * @return if using walkspeed.
	 */
	public static boolean isDebugMode(){
		return Spider.getInstance().getConfig().getBoolean("debug", false);
	}

	/**
	 * Check if it is necessary to use the walkspeed.
	 * @return if using walkspeed.
	 */
	public static int getCheckTime(){
		return Spider.getInstance().getConfig().getInt("detection.time", 30);
	}

}
