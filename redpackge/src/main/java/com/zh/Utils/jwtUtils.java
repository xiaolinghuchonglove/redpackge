package com.zh.Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.cache.spi.entry.StandardCacheEntryImpl;
import org.hibernate.internal.util.StringHelper;

import java.security.SignatureException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
@Slf4j
public class jwtUtils {

//    秘钥
    private static  String key;
//    jwt建造类
    private static JWTCreator.Builder builder;
    static{

        key = "whxo321@77&jsj";
        builder = JWT.create();
    }

    /**
     * 获取token
     * @param map
     * @return
     */
    public static String getToken(Map<String,String> map){
//        对map中每队键值对加入payload
        map.forEach((key,value)->{
            builder.withClaim(key,value);
        });
        Calendar time01 =  Calendar.getInstance();
        time01.add(Calendar.SECOND, 90);
       Date time = time01.getTime();
        log.info(builder.withExpiresAt(time).sign(Algorithm.HMAC256(key)));
      return   builder.withExpiresAt(time).sign(Algorithm.HMAC256(key));

    }

    /**
     * 对token进行验证,验证有问题抛异常.
     * SignatureException 签名不一致异常
     * TokenExpiredException token过期异常
     * AlgorithmMismatchException 算法不匹配异常
     *  InvalidClaimException 失效的payload异常
     * 没有问题返回解码后的token;
     * @param token
     */
    public static DecodedJWT verify(String token){
        JWTVerifier check = JWT.require(Algorithm.HMAC256(key)).build();
//        创建解码后的 token对象
        DecodedJWT check02 = check.verify(token);
        return check02;

    }

    /**
     * 获取token中的payload
     * @param token
     * @param name
     * @return
     */
    public static String verify(String token, String name){
        JWTVerifier check = JWT.require(Algorithm.HMAC256(key)).build();
//        创建解码后的 token对象
        DecodedJWT check02 = check.verify(token);

        return check02.getClaim(name).asString();

    }

}
