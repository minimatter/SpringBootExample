package exam.controller;

import exam.bean.User;
import exam.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/Login")
public class LoginInController {
    @RequestMapping("login")
    public String login(){
        return "loginIn/loginIn";
    }

/*
* 没有添加@Autowired注解时报错
* This application has no explicit mapping for
使用@Autowired时
1.Spring先去容器中寻找NewsSevice类型的bean（先不扫描newsService字段）

2.若找不到一个bean，会抛出异常

3.若找到一个NewsSevice类型的bean，自动匹配，并把bean装配到newsService中

4.若NewsService类型的bean有多个，则扫描后面newsService字段进行名字匹配，匹配成功后将bean装配到newsService中
* */
    @Autowired
    private IUserService userService;

    @ResponseBody
    @RequestMapping("/signIn")
    public String  signIn(String userName,String userPassWord){
        Map<String,Object> map=new HashMap<>();
        map.put("userName",userName);
        map.put("userPassWord",userPassWord);
/*
* 因为JAVA中String并非基本数据类型而是一个类, 变量名实际代表地址,
*==运算符只能够确定两个字符串是否放在同一个地址
* */
        if(userService.loginIn(map).equals("ture")){
            return " 成功";
        }else {
            return "失败";
        }

    }
}
