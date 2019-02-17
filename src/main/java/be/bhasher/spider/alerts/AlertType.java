package be.bhasher.spider.alerts;

public enum AlertType {

	FLY("Fly"),
	HIGH_UMP("High Jump"),
	SPEEDHACK("Speed Hack");

	private final String name;

	AlertType(final String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

}
