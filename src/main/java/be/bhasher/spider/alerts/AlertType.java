package be.bhasher.spider.alerts;

/**
 * List of possible alerts to send against a {@link org.bukkit.entity.Player}.
 */
public enum AlertType {

	FLY("Fly"),
	HIGH_UMP("High Jump"),
	SPEEDHACK("Speed Hack");

	private final String name;

	/**
	 * Setup AlertType.
	 * @param name The name of the alert.
	 */
	AlertType(final String name){
		this.name = name;
	}

	/**
	 * @return The name of the alert.
	 */
	public String getName(){
		return name;
	}

}
