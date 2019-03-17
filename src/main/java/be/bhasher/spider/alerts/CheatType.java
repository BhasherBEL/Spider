package be.bhasher.spider.alerts;

/**
 * List of possible alerts to send against a {@link org.bukkit.entity.Player}.
 */
public enum CheatType {

	FLY("Fly"),
	HIGH_UMP("High Jump"),
	SPEEDHACK("Speed Hack");

	private final String name;

	/**
	 * Setup CheatType.
	 * @param name The name of the alert.
	 */
	CheatType(final String name){
		this.name = name;
	}

	/**
	 * @return The name of the alert.
	 */
	public String getName(){
		return name;
	}

}
