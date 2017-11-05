package org.study.service;

import java.util.List;

import org.study.intf.lyncc.entity.User;

public interface UserService {

	List<User> getAllUser();

	List<User> findByPage(int limit, int offset);

	Integer findCount();

}
