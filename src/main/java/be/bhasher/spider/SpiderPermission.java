package be.bhasher.spider;

/**
 * Enum managing spider permissions.
 */
public enum SpiderPermission {

	PREVENT_ALERT("spider.alert.prevent");

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
