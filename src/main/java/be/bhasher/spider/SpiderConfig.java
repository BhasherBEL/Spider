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
		return Spider.getInstance().getConfig().getBoolean("cheat.speedhack.usingwalkspeed");
	}

}
