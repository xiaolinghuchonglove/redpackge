package com.zh.Ob;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Table(name = "user_table")
@JsonIgnoreProperties(value = "hibernateLazyInitializer")
@Entity
@Getter
@Setter
public class user {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToMany(mappedBy = "user",cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE})
//    必须是list，不能是arraylist
    private List<book> books;

    @Override
    @Transient
    @JsonIgnore
    public String toString() {
        return "user{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }

}
