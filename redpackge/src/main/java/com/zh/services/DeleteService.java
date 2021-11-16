package com.zh.services;

import com.zh.Ob.JsonResult;
import com.zh.Ob.ProcessType;
import com.zh.Ob.RedPackge;
import com.zh.Ob.Status;
import com.zh.dao.RedPackgeReposity;
import org.springframework.objenesis.instantiator.basic.DelegatingToExoticInstantiator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
@Service
public class DeleteService {
    private RedPackge RedPackge=new RedPackge();
    @Resource
    private RedPackgeReposity RedPackgeReposity;

    public DeleteService() {

    }
    public JsonResult DeletPackge(Map<String, Object> FrontJson){
        RedPackgeReposity.deleteById((Integer)FrontJson.get("id"));
        return new JsonResult(Status.success, ProcessType.delete,"删除成功",null);
    }
}
