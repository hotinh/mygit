package cn.junety.alarm.web.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import cn.junety.alarm.base.entity.SysLog;

public interface SysLogDao {

	@Insert("insert into tb_sys_log "
			+ "(create_time, create_user, type, type_name, model_type, model_name, params, ip) "
			+ "values "
			+ "(#{createTime}, #{createUser}, #{type}, #{typeName}, #{modelType}, #{modelName}, #{params}, #{ip})")
	@Options(useGeneratedKeys=true, keyProperty="id")
	void save(SysLog sysLog);
}
