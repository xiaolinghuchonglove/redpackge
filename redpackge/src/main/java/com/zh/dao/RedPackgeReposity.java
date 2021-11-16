package com.zh.dao;

import com.zh.Ob.RedPackge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedPackgeReposity extends JpaRepository<RedPackge,Integer> {
}
