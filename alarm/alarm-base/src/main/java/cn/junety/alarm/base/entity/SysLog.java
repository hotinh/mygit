package cn.junety.alarm.base.entity;

public class SysLog {

	private Long id;
	private Long createTime;
	private Integer createUser;
	private Integer type;
	private String typeName;
	private Integer modelType;
	private String modelName;
	private String params;
	private String ip;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	public Integer getCreateUser() {
		return createUser;
	}
	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getModelType() {
		return modelType;
	}
	public void setModelType(Integer modelType) {
		this.modelType = modelType;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@Override
	public String toString() {
		return "{" + 
				"id=" + id + 
				", createTime=" + createTime + 
				", createUser=" + createUser + 
				", type=" + type + 
				", typeName=" + typeName + 
				", modelType=" + modelType + 
				", modelName=" + modelName + 
				", params=" + params + 
				", ip=" + ip + 
				"}";
	}
	
}
