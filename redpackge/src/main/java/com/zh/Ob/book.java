package com.zh.Ob;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "book_table")
@JsonIgnoreProperties(value = "hibernateLazyInitializer")
public class book {
    @Id
    @GeneratedValue
    int id;
    String name;
    @ManyToOne(cascade ={ CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    user user;

}
