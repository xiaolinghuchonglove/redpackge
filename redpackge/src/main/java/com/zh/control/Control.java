package com.zh.control;


import com.zh.Ob.JsonResult;
import com.zh.Ob.ProcessType;
import com.zh.Ob.RedPackge;
import com.zh.Ob.Status;
import com.zh.Utils.jwtUtils;
import com.zh.dao.RedPackgeReposity;
import com.zh.services.DeleteService;
import com.zh.services.SendService;
import com.zh.services.registyServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@Slf4j
public class Control {
    @Resource
    private SendService SendService;
    @Resource
    private DeleteService DeletService;
    @Resource
    private registyServices registyServices;

    //发红包请求
    @PostMapping("SendPackge")
    public JsonResult SendPackge(@RequestParam String producer, @RequestParam int money) {
        return SendService.AddPackge(producer, money);
    }

    //删除请求
    @PostMapping("DeletPackge")
    public JsonResult DeletPackge(@RequestBody Map<String, Object> FrontJson) {
        return DeletService.DeletPackge(FrontJson);

    }

    @PostMapping("testPackge")
    public JsonResult testPackge(@RequestBody Map<String, Object> FrontJson) {
        return null;
    }

    @PostMapping("login")
    public JsonResult login(@RequestBody Map<String, String> FrontJson) throws Exception{
//        调用registySevice
        if (registyServices.rigistyService(FrontJson)) {
            //定义临时变量传递给jwtUtiles
            HashMap<String, String> temp = new HashMap<String, String>();
            Set<String> keys = FrontJson.keySet();
//            payload中去掉密码，生成token
            for (String key : keys)
                if (key != "password")
                    temp.put(key, FrontJson.get(key));
                String token = jwtUtils.getToken(temp);

            return new JsonResult(Status.success, ProcessType.get,"登录成功",token);
        }

        return new JsonResult(Status.hasRegisty, ProcessType.get,"登录失败，用户名或密码错误",null);

    }
    @PostMapping("/testtoken")
    public String testtoken(@RequestBody Map<String, String> FrontJson) throws Exception{
        System.out.println("aaaaaa");
       return "success";
    }

}
