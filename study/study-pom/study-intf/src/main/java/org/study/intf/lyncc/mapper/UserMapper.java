package org.study.intf.lyncc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.study.intf.lyncc.entity.User;


public interface UserMapper{

	List<User> findAllUser();

	List<User> findByPage(@Param("limit")Integer limit,@Param("offset")Integer offset);

	Integer countAll();
	
 
}
