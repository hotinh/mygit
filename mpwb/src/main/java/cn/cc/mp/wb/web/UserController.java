package cn.cc.mp.wb.web;

import cn.cc.mp.wb.core.AbstractController;
import cn.cc.mp.wb.core.Result;
import cn.cc.mp.wb.core.ResultGenerator;
import cn.cc.mp.wb.core.ResultHelper;
import cn.cc.mp.wb.model.User;
import cn.cc.mp.wb.service.UserService;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example.Criteria;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
* Created by CodeGenerator on 2017/12/24.
*/
@RestController
@RequestMapping("/user")
public class UserController extends AbstractController {
    @Resource
    private UserService userService;

    @PostMapping()
    public Map<String, Object> add(@RequestBody User user) {
        String id = userService.saveOne(user);
        return ResultHelper.build("id", id);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        userService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody User user) {
        userService.update(user);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Object detail(@PathVariable Integer id) {
        User user = userService.findById(id);
        return user;
    }

    @GetMapping()
    public Map<String, Object> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        logger.info("{},{}", page, size);
        
        PageHelper.startPage(page, size);
        List<User> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        
//        return ResultGenerator.genSuccessResult(pageInfo);
        return ResultHelper.build("results", list, "totalCount", pageInfo.getTotal());
//        return null;
    }
    
    @PostMapping("/condition")
    public Result condition(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size, @RequestBody User user) {
        Condition condition = new Condition(User.class);
        Criteria criteria = condition.createCriteria();
        criteria.andCondition("username like '%" + user.getUsername() + "%'");
        condition.setOrderByClause("username desc");
        
        PageHelper.startPage(page, size);
        List<User> list = userService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
