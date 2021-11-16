package com.zh.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class userBookservicesTest {
    @Autowired
    userBookservices a;
    @Test
    public void test(){

//        a.deletebook();
//        a.addbook();
//        a.deleteuser();
        a.findUser();
    }

}