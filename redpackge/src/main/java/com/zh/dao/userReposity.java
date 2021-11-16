package com.zh.dao;

import com.zh.Ob.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface userReposity extends JpaRepository<user,Integer> {
    int deleteByName(String s);
//    根据书名查找user实体
    List<user> findByBooks_nameContaining(String s);

}
