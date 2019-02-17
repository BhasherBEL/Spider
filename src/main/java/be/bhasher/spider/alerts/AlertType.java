package be.bhasher.spider.alerts;

public enum AlertType {

	FLY("Fly"),
	JUMP("Jump"),
	SPEEDHACK("Speed Hack");

	private final String name;

	AlertType(final String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

}
