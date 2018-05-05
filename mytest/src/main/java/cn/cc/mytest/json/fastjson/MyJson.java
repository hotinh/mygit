package cn.cc.mytest.json.fastjson;

import com.alibaba.fastjson.*;

public class MyJson {
    public static void main(String[] args) {
        Person person = new Person();
        person.setId("1");
        person.setName("11");

        String jsonStr = JSON.toJSONString(person);
        System.out.println(jsonStr);

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        System.out.println(jsonObject.getString("id"));
        System.out.println(jsonObject.getString("name"));
    }

}
