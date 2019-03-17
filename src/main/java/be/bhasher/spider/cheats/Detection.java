package be.bhasher.spider.cheats;

import be.bhasher.spider.alerts.CheatType;

public class Detection {

	private final CheatType type;
	private final long time;
	private final double score;

	public Detection(final CheatType type, final double score){
		this.type = type;
		this.score = score;
		time = System.currentTimeMillis();
	}

	public CheatType getType() {
		return type;
	}

	public long getTime(){
		return time;
	}

	public double getScore(){
		return score;
	}

}
