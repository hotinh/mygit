package org.study.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.study.intf.lyncc.entity.User;
import org.study.intf.lyncc.mapper.UserMapper;
import org.study.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	public List<User> getAllUser() {
		return userMapper.findAllUser();
	}

	public List<User> findByPage(int limit, int offset) {
		return userMapper.findByPage(limit,offset);
	}

	public Integer findCount() {
		return userMapper.countAll();
	}

}
