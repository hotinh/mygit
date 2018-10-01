package cn.cc.mp.wb.service.impl;

import cn.cc.mp.wb.dao.UserMapper;
import cn.cc.mp.wb.model.User;
import cn.cc.mp.wb.service.UserService;
import cn.cc.mp.wb.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/12/24.
 * @author Administrator
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public String saveOne(User user) {
        userMapper.insertSelective(user);
        return user.getId().toString();
    }
}
