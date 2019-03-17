package be.bhasher.spider.utils.permission;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

public class CustomPermission {

	private final String nodeName;
	private final String path;
	private final String description;
	private final PermissionDefault permissionDefault;
	private Permission permission = null;
	private final ArrayList<CustomPermission> children = new ArrayList<>();

	public CustomPermission(final String nodeName){
		this(nodeName, "", Permission.DEFAULT_PERMISSION);
	}

	public CustomPermission(final String nodeName,final String description){
		this(nodeName, description, Permission.DEFAULT_PERMISSION);
	}

	public CustomPermission(final String nodeName,final PermissionDefault permissionDefault){
		this(nodeName, "", permissionDefault);
	}

	public CustomPermission(final String nodeName,final String description,final PermissionDefault permissionDefault){
		this(nodeName,nodeName,description,permissionDefault);
	}

	private CustomPermission(final String nodeName, final String path,final String description,final PermissionDefault permissionDefault){
		this.nodeName = nodeName;
		this.path = path;
		this.description = description;
		this.permissionDefault = permissionDefault;
	}

	public CustomPermission addChildren(final String nodeName){
		return addChildren(nodeName, "", permissionDefault);
	}

	public CustomPermission addChildren(final String nodeName,final String description){
		return addChildren(nodeName, description, permissionDefault);
	}

	public CustomPermission addChildren(final String nodeName,final PermissionDefault permissionDefault){
		return addChildren(nodeName, "", permissionDefault);
	}

	public CustomPermission addChildren(final String nodeName,final String description,final PermissionDefault permissionDefault){
		final CustomPermission child = new CustomPermission(nodeName, path+"."+nodeName, description, permissionDefault);
		children.add(child);
		return child;
	}

	public CustomPermission addLastChildren(final String nodeName){
		return addLastChildren(nodeName, "", permissionDefault);
	}

	public CustomPermission addLastChildren(final String nodeName,final String description){
		return addLastChildren(nodeName, description, permissionDefault);
	}

	public CustomPermission addLastChildren(final String nodeName,final PermissionDefault permissionDefault){
		return addLastChildren(nodeName, "", permissionDefault);
	}

	public CustomPermission addLastChildren(final String nodeName,final String description,final PermissionDefault permissionDefault){
		children.add(new CustomPermission(nodeName, path+"."+nodeName, description, permissionDefault));
		return this;
	}

	public Permission getPermission(){
		return permission;
	}

	public void build(){
		final Map<String, Boolean> stringChildren = new HashMap<>();
		for(final CustomPermission child : children){
			stringChildren.put(child.path, true);
			child.build();
		}
		this.permission = new Permission(path, description, permissionDefault, stringChildren);
	}

	public String getPath(){
		return path;
	}

	public String getNodeName() {
		return nodeName;
	}

	public ArrayList<CustomPermission> getChildren() {
		return children;
	}
}
