package com.zh.services;

import com.zh.Ob.book;
import com.zh.Ob.user;
import com.zh.dao.bookReposity;
import com.zh.dao.userReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class userBookservices {
    @Autowired
    userReposity userDao;
    @Autowired
    bookReposity bookDao;

public void saveBookAndUser(){

    user user1=new user();
    user user2=new user();
    user1.setName("张");
    user2.setName("李");
//    先保存一的一端
    userDao.save(user1);
    userDao.save(user2);
    book book1=new book();
    book book2=new book();
    book book3=new book();
    book book4=new book();
    book1.setName("西游记");
    book2.setName("红楼梦");
    book3.setName("水壶");
    book4.setName("三国");
//    由维护端book设置关系
    book1.setUser(user1);
    book2.setUser(user2);
    book3.setUser(user2);
    book4.setUser(user2);

    ArrayList<book> books=new ArrayList<book>();
    books.add(book1);
    books.add(book2);
    books.add(book3);
    books.add(book4);
    bookDao.saveAll(books);





}
public void deletebook(){
   List<book> books= bookDao.findByName("sishen");
   bookDao.deleteAll(books);

}
    public void addbook(){

        book book1=new book();
        book1.setName("sishen");
        user user=new user();
        user.setName("tie");
        book1.setUser(user);
        bookDao.save(book1);

    }
    public void deleteuser(){
    userDao.deleteById(39);


    }
public void findUser(){
   List<user> users= userDao.findByBooks_nameContaining("红");
//   不能使用tostring,因为user.books属性咩有被加载，因为hibernate并没有建立关于book查询的连接
//    System.out.println(users.get(0).toString());
}
}



