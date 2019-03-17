package be.bhasher.spider.permission;

import org.bukkit.permissions.PermissionDefault;

import be.bhasher.spider.Spider;
import be.bhasher.spider.utils.permission.CustomPermission;

public class SpiderPermission {

	public static final CustomPermission spiderPermission = new CustomPermission("spider", Spider.langConfig.get("permission.description.spider"), PermissionDefault.OP);

	public static final CustomPermission preventPermission = spiderPermission.addChildren("prevent", Spider.langConfig.get("permission.description.spider.prevent"));
	public static final CustomPermission preventNoAutoBanPermission = preventPermission.addChildren("noautoban", Spider.langConfig.get("permission.description.spider.prevent.noautoban"));

	public static final CustomPermission checkPermission = spiderPermission.addChildren("check", Spider.langConfig.get("permission.description.spider.check"));
	public static final CustomPermission checkGlobalPermission = checkPermission.addChildren("global", Spider.langConfig.get("permission.description.spider.check.global"));
	public static final CustomPermission checkSpeedHackPermission = checkPermission.addChildren("speedhack", Spider.langConfig.get("permission.description.spider.check.speedhack"));

	public static final CustomPermission alertPermission = spiderPermission.addChildren("alert", Spider.langConfig.get("permission.description.spider.alert"));
	public static final CustomPermission alertSpeedhackPermission = alertPermission.addChildren("speedhack", Spider.langConfig.get("permission.description.spider.alert.speedhack"));

	public static final CustomPermission bypassPermission = spiderPermission.addChildren("bypass",Spider.langConfig.get("permission.description.spider.bypass"));
	public static final CustomPermission bypassSpeedHackPermission = bypassPermission.addChildren("speedhack", Spider.langConfig.get("permission.description.spider.bypass.speedhack"));

}
