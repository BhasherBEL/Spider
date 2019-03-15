package be.bhasher.spider.cheats;

import java.util.ArrayList;

import be.bhasher.spider.alerts.AlertType;
import be.bhasher.spider.player.SpiderPlayer;
import be.bhasher.spider.utils.Format;

public abstract class Cheat {

	protected final AlertType alertType;
	protected final SpiderPlayer sp;
	protected final ArrayList<Detection> previous;

	public Cheat(final SpiderPlayer sp, final AlertType alertType){
		this.alertType = alertType;
		this.previous = new ArrayList<>();
		this.sp = sp;
	}

	protected void addDetection(final Detection newDetection){
		previous.add(newDetection);
	}

	protected void prevent(final Detection newDetection){
		preventP(newDetection,"");
	}

	protected void prevent(final Detection newDetection, final String text){
		preventP(newDetection,", " + text);
	}

	private void preventP(final Detection newDetection, final String text){
		addDetection(newDetection);
		sp.alert(newDetection.getType(), "score: " + Format.round(newDetection.getScore(), 2) + text);
	}

	public void update(){
		if(isBypass()){
			return;
		}
	}

	protected abstract boolean isBypass();



}
