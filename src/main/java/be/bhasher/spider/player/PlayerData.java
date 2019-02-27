package be.bhasher.spider.player;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import be.bhasher.spider.utils.block.BlockNature;
import be.bhasher.spider.utils.block.BlockUtils;

public class PlayerData {

	private final Player player;

	private Location location;
	private Block block;
	private Vector edgeDist;

	private boolean onGround;
	private boolean inLiquid;
	private boolean blockOnTop;
	private boolean onHalfBlock;
	private boolean onIce;
	private boolean inWeb;
	private boolean onClimbable;

	public PlayerData(final Player player) {
		this.player = player;
	}

	public void setAll() {
		location = player.getLocation() ;
		block = location.getBlock() ;
		setOnGround();
		setInLiquid();
	}

	private void setEdgeDist(){
		double xEdge = location.getX()%1;
		if(xEdge > 0.5){
			xEdge = 1-xEdge;
		}
		double yEdge = location.getY()%1;
		if(yEdge > 0.5){
			yEdge = 1-yEdge;
		}
		double zEdge = location.getZ()%1;
		if(zEdge > 0.5){
			zEdge = 1-zEdge;
		}
		edgeDist = new Vector(xEdge, yEdge, zEdge);
	}

	private void setOnGround() {
		onGround = player.isOnGround();
	}

	private void setInLiquid() {
		if(BlockNature.isLiquid(block) || BlockNature.isLiquid(player.getEyeLocation().getBlock())){
			inLiquid = true;
			return ;
		}
		for(int x=-1;x<=1;x++){
			for(int y=0;y<=1;y++){
				for(int z=-1;z<=1;z++){
					if(BlockNature.isLiquid(location.clone().add(x,y,z).getBlock())) {
						final Block liquidAdjBlock = location.clone().add(x,y,z).getBlock();
						final Vector componentDist = BlockUtils.getComponentDistance(liquidAdjBlock, location);
						if(componentDist.getX() < .2 && componentDist.getZ() < .2){
							inLiquid = true;
							return;
						}
					}
				}
			}
		}
		inLiquid = false;
	}

	public Vector getEdgeDist(){
		return edgeDist;
	}

	public boolean isOnGround() {
		return onGround;
	}

	public boolean isInLiquid() {
		return inLiquid;
	}
}
