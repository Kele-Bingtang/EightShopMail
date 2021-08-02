package com.eight.bean;

/**
 * @Author
 * @CreateTime 2021-07-16 10:38:19
 * @Version 1.0
 */
public class Account {

    private Integer id;
    private String name;
    private double money;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Account(Integer id, String name, double money) {

        this.id = id;
        this.name = name;
        this.money = money;
    }

    public Account() {

    }
}
