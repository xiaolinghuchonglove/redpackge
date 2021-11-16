package com.zh.control;


import com.zh.Ob.JsonResult;
import com.zh.Ob.RedPackge;
import com.zh.dao.RedPackgeReposity;
import com.zh.services.DeleteService;
import com.zh.services.SendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@Slf4j
public class Control {
    @Resource
    private SendService SendService;
    @Resource
    private DeleteService DeletService;
    //发红包请求
    @PostMapping("SendPackge")
    public JsonResult SendPackge(@RequestParam String producer, @RequestParam int money) {
        return SendService.AddPackge(producer, money);
    }
    //删除请求
    @PostMapping("DeletPackge")
    public JsonResult DeletPackge(@RequestBody Map<String,Object> FrontJson){
        return DeletService.DeletPackge(FrontJson);

    }

}
