package cn.cc.mytest.mybatis2.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.cc.mytest.mybatis2.beans.UserBean;
import cn.cc.mytest.mybatis2.mapper.UserMapper;
import cn.cc.mytest.mybatis2.tools.DBTools;

public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class); 
    
    public static void main(String[] args) {
//        insertUser();
        //deleteUser(1);
        selectUserById(1);
        //selectAllUser();
    }

    
    /**
     * 新增用户
     */
    private static boolean  insertUser(){
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        UserBean user = new UserBean("test01", "123456", 7000.0);
        try {
            int index=mapper.insertUser(user);
            boolean bool=index>0?true:false;
            logger.error("新增用户user对象:{},操作状态:{}",new Object[]{user,bool});
             session.commit();
             return bool;
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return false;
        }finally{            session.close();        }
    }
    
    
    /**
     * 删除用户
     * @param id 用户ID
     */
    private static boolean deleteUser(int id){
        SqlSession session=DBTools.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        try {
            int index=mapper.deleteUser(id); 
            boolean bool=index>0?true:false;
            logger.debug("根据用户id:{},操作状态{}",new Object[]{id,bool});
            session.commit(); 
            return bool;
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback(); 
            return false;
        }finally{            session.close();        }
    }
    
    
    /**
     * 根据id查询用户
     * @param id
     */
    private static void selectUserById(int id){
        SqlSession session=DBTools.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        try {
        UserBean user= mapper.selectUserById(id);
        logger.info("根据用户Id:{},查询用户信息:{}",new Object[]{id,user});
//        System.out.println(user);
        session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }finally{            session.close();        }
    }
    
    /**
     * 查询所有的用户
     */
    private static void selectAllUser(){
        SqlSession session=DBTools.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        try {
        List<UserBean> user=mapper.selectAllUser();
        logger.debug("获取所用的用户:{}",user);
        session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }finally{            session.close();        }
    }
}
