package be.bhasher.spider.cheats;

import be.bhasher.spider.alerts.AlertType;

public class Detection {

	private final AlertType type;
	private final long time;
	private final double score;

	public Detection(final AlertType type, final double score){
		this.type = type;
		this.score = score;
		time = System.currentTimeMillis();
	}

	public AlertType getType() {
		return type;
	}

	public long getTime(){
		return time;
	}

	public double getScore(){
		return score;
	}

}
