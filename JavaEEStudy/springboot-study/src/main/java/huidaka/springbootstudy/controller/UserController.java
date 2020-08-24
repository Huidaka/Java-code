package huidaka.springbootstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    @ResponseBody
    public Map<String, String> login(){
        Map<String,String> map = new HashMap<>();
        map.put("bit","博哥");
        map.put("bit","汤老师");
        map.put("haha","fjasdkl");
        return map;
    }
}
