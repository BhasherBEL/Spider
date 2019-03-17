package be.bhasher.spider.cheats;

import java.util.ArrayList;

import be.bhasher.spider.Spider;
import be.bhasher.spider.SpiderConfig;
import be.bhasher.spider.alerts.CheatLevel;
import be.bhasher.spider.alerts.CheatType;
import be.bhasher.spider.permission.SpiderPermission;
import be.bhasher.spider.player.SpiderPlayer;
import be.bhasher.spider.utils.player.PlayerMessage;

public abstract class Cheat {

	protected final CheatType cheatType;
	protected final SpiderPlayer sp;
	protected final ArrayList<Detection> previous;
	public double score = 0;

	public Cheat(final SpiderPlayer sp, final CheatType cheatType){
		this.cheatType = cheatType;
		this.previous = new ArrayList<>();
		this.sp = sp;
	}

	protected void addDetection(final Detection newDetection){
		previous.add(newDetection);
	}

	/**
	 * Send a spider alert to the staff.
	 */
	public void preventTest(){
		if(score > 5000){
			//PlayerPunishment.autoBanPlayer(sp, cheatType.getName());
		}
		if(getLevel() != CheatLevel.NONE){
			int i = 0;
			for(final Detection oldDetection : previous){
				if(oldDetection.getType() == cheatType
						&& getLevel(oldDetection.getScore()) != CheatLevel.NONE
						&& oldDetection.getTime()+SpiderConfig.getCheckTime()*1000 >= System.currentTimeMillis()){
					i+=1;
				}
			}
			if(i>0){
				PlayerMessage.sendMessageWithPermission(SpiderPermission.alertPermission, Spider.HEADER + " " + getLevel().getColor() + sp.getPlayer().getName() + ": " + cheatType.getName() + " " + "(" + getLevel().getName().toUpperCase() + "x" + i + "/" + Math.round(score) + ")");
			}
		}
	}

	/**
	 * Get the {@link CheatLevel}.
	 * @return the {@link CheatLevel}.
	 */
	protected CheatLevel getLevel(){
		return getLevel(score);
	}


	private CheatLevel getLevel(final double score){
		if(score > 2000){
			return CheatLevel.CRITICAL;
		}else if(score > 1000){
			return CheatLevel.FLAGGED;
		}else if(score > 500){
			return CheatLevel.PROVEN;
		}else if(score > 200){
			return CheatLevel.SUSPECTED;
		}else if(score > 100){
			return CheatLevel.POTENTIAL;
		}else{
			return CheatLevel.NONE;
		}
	}

	public void update(){
		if(isBypass()){
			return;
		}
	}

	protected abstract boolean isBypass();



}
