package com.zh.services;

import com.zh.Ob.JsonResult;
import com.zh.Ob.ProcessType;
import com.zh.Ob.RedPackge;
import com.zh.Ob.Status;
import com.zh.dao.RedPackgeReposity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.*;
import java.util.Map;
@Service
public class SendService {
   private RedPackge RedPackge=new RedPackge();
    @Resource
    private RedPackgeReposity RedPackgeReposity;

    public SendService() {
    }
//插入数据到数据库并返回处理结果
    public JsonResult AddPackge(String producer,double money) {
//        System.out.println("nihao");
        RedPackge.setMoney(money);
        RedPackge.setProduer(producer);
        RedPackge.setAlive(true);
        RedPackgeReposity.save(RedPackge);
        return new JsonResult(Status.success, ProcessType.send,"红包发送成功",null);
    }

}


