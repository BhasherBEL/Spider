package be.bhasher.spider.permission;

import org.bukkit.permissions.PermissionDefault;

import be.bhasher.spider.utils.permission.CustomPermission;

public class SpiderPermission {

	public static final CustomPermission spiderPermission = new CustomPermission("spider", "General permission for the Spider plugin", PermissionDefault.OP);

	public static final CustomPermission preventPermission = spiderPermission.addChildren("prevent", "General permission for sanctions");
	public static final CustomPermission preventNoAutoBanPermission = preventPermission.addChildren("noautoban", "Cannot be automatically banned");

	public static final CustomPermission checkPermission = spiderPermission.addChildren("check", "General permission for checks");
	public static final CustomPermission checkGlobalPermission = checkPermission.addChildren("global", "See details of the anticheat for a player");
	public static final CustomPermission checkSpeedHackPermission = checkPermission.addChildren("speedhack", "See details of the antispeedhack for a player");

	public static final CustomPermission alertPermission = spiderPermission.addChildren("alert", "Receive anticheat alerts");
	public static final CustomPermission alertSpeedhackPermission = alertPermission.addChildren("speedhack", "Receive speedhack alerts");

	public static final CustomPermission bypassPermission = spiderPermission.addChildren("bypass","General permission for bypass checks");
	public static final CustomPermission bypassSpeedHackPermission = bypassPermission.addChildren("speedhack", "Bypass speedhack verification");

}
