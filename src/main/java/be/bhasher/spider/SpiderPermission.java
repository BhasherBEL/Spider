package be.bhasher.spider;

public enum SpiderPermission {

	PREVENT_ALERT("spider.alert.prevent");

	private final String permission;

	SpiderPermission(final String permission){
		this.permission = permission;
	}

	public String getPermission(){
		return permission;
	}

}
