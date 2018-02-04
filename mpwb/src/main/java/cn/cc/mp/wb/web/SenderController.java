/*package cn.cc.mp.wb.web;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.cc.mp.wb.common.rabbitmq.Sender;
import cn.cc.mp.wb.core.Result;
import cn.cc.mp.wb.core.ResultGenerator;
import cn.cc.mp.wb.model.User;
import cn.cc.mp.wb.service.UserService;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.amqp.core.Message;

@RestController("/amqp")
public class SenderController {

    @Autowired
    private Sender sender;
    
    @Resource
    private UserService userService;
    
    @GetMapping
    public Result sender() {
        List<User> list = userService.findAll();
        //String msg = new Date().toString();
        list.forEach(e -> {
            sender.send2(JSON.toJSONString(e));
        });
        return ResultGenerator.genSuccessResult();
    }
}
*/