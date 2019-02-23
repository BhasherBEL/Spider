package be.bhasher.spider;

/**
 * Enum managing spider permissions.
 */
public enum SpiderPermission {

	PREVENT_ALERT("spider.alert.prevent"),
	NO_AUTO_BAN("spider.punishment.noautoban"),
	SEE_REASON("spider.punishment.seereason");

	private final String permission;

	/**
	 * Setup the permission.
	 * @param permission The permission.
	 */
	SpiderPermission(final String permission){
		this.permission = permission;
	}

	/**
	 * @return the permission.
	 */
	public String getPermission(){
		return permission;
	}

}
