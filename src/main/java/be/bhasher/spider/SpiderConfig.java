package be.bhasher.spider;

public class SpiderConfig {

	public static Double getTolerance(){
		return Spider.getInstance().getConfig().getDouble("cheat.tolerance");
	}

}
