package com.zh.dao;

import com.zh.Ob.book;
import com.zh.Ob.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface bookReposity extends JpaRepository<book,Integer> {
   List<book> findByName(String s);

}
