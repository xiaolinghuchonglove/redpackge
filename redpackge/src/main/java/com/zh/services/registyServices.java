package com.zh.services;

import com.zh.Ob.user;
import com.zh.dao.RedPackgeReposity;
import com.zh.dao.userReposity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SplittableRandom;

@Service
public class registyServices {
    @Resource
    private userReposity userReposity;

    public boolean rigistyService(Map<String, String> map) {
        user user = userReposity.findByName(map.get("name"));
        if (user == null || !user.getPassowrd().equals(map.get("password")))
            return false;
        else
            return true;
    }

}
