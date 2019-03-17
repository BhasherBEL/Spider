package be.bhasher.spider.alerts;

import org.bukkit.ChatColor;

/**
 * The strength of the alerts is used according to the {@link org.bukkit.entity.Player}'s score in the given cheat.
 */
public enum CheatLevel {

	NONE("None",ChatColor.WHITE.toString()),
	POTENTIAL("Potential", ChatColor.YELLOW.toString()),
	SUSPECTED("Suspected", ChatColor.GOLD.toString()),
	PROVEN("Proven", ChatColor.RED.toString()),
	FLAGGED("Flagged", ChatColor.DARK_RED.toString()),
	CRITICAL("Critical", ChatColor.DARK_RED.toString()+ChatColor.BOLD.toString());

	private final String name;
	private final String color;

	/**
	 * Setup an CheatLevel.
	 * @param name The name of the force.
	 * @param color The color code of the force.
	 */
	CheatLevel(final String name, final String color){
		this.name = name;
		this.color = color;
	}

	/**
	 * @return the name of the force.
	 */
	public String getName(){
		return name;
	}

	/**
	 * @return the color code of the force.
	 */
	public String getColor(){
		return color;
	}

}
