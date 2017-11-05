package org.study.lyncc.web.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.study.intf.lyncc.entity.User;
import org.study.service.UserService;


@Controller
@RequestMapping(value="/user")
public class UserController {
	

	@Resource
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value="test")
	public List<User> getAllList(){
		List<User> users = userService.getAllUser();
		return users;
	}
	
	
	@RequestMapping(value="list")
	public String list(){
		return "list";
	}
	
	@ResponseBody
	@RequestMapping("/page")
	public Map<String, Object> page(@RequestParam Map<String, Object> requestMap){
		
		int limit = Integer.valueOf("" + requestMap.get("limit"));
		int offset = Integer.valueOf("" + requestMap.get("offset"));
		List<User> users = userService.findByPage(limit,offset);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", "success");
		resultMap.put("total", userService.findCount());
		resultMap.put("rows", users);
		
		return resultMap;
	}
	
	
}
