package be.bhasher.spider.alerts;

import org.bukkit.ChatColor;

public enum AlertForce {

	NONE("None",ChatColor.WHITE.toString()),
	POTENTIAL("Potential", ChatColor.YELLOW.toString()),
	SUSPECTED("Suspected", ChatColor.GOLD.toString()),
	PROVEN("Proven", ChatColor.RED.toString()),
	FLAGGED("Flagged", ChatColor.DARK_RED.toString()),
	CRITICAL("Critical", ChatColor.DARK_RED.toString()+ChatColor.BOLD.toString());

	private final String name;
	private final String color;

	AlertForce(final String name, final String color){
		this.name = name;
		this.color = color;
	}

	public String getName(){
		return name;
	}

	public String getColor(){
		return color;
	}

}
