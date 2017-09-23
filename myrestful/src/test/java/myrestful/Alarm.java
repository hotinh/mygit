package myrestful;

/**
 * Created by caijt on 2017/1/28.
 */
public class Alarm {
    private Integer id;
    private Integer code;
    private String name;
    private Integer projectId;
    private Integer moduleId;
    private Integer groupId;
    private String routeKey;
    private String config;
    private Integer dhcUserId;
    
    private String groupName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getRouteKey() {
		return routeKey;
	}

	public void setRouteKey(String routeKey) {
		this.routeKey = routeKey;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public Integer getDhcUserId() {
		return dhcUserId;
	}

	public void setDhcUserId(Integer dhcUserId) {
		this.dhcUserId = dhcUserId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", projectId=" + projectId +
                ", moduleId=" + moduleId +
                ", groupId=" + groupId +
                ", routeKey='" + routeKey + '\'' +
                ", config='" + config + '\'' +
                ", dhcUserId=" + dhcUserId +
                '}';
    }
}
