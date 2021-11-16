package com.zh.Ob;

import javax.persistence.*;

@Table(name="packgetable")
@Entity
public class RedPackge {
    @Column(name="id",length = 20)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    @Column(name="producer",length = 20)
    private String Produer;
    @Column(name="alive" )
    private Boolean alive;
    @Column(name="money",length = 20)
    private Double money;

    public RedPackge() {
    }

    public RedPackge(Integer id, String produer, Boolean alive, Double money) {
        this.id = id;
        Produer = produer;
        this.alive = alive;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public String getProduer() {
        return Produer;
    }

    public Boolean getAlive() {
        return alive;
    }

    public Number getMoney() {
        return money;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProduer(String produer) {
        Produer = produer;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
