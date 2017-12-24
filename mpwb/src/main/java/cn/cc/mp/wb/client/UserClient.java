package cn.cc.mp.wb.client;

import cn.cc.mp.wb.model.User;

public interface UserClient {

    String add(User user);
    
    String del(User user);
    
    String update(User user);
    
    String list(User user);
    
    String detail(User user);
}
