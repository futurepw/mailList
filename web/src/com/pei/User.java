
package com.pei;
/**
 * Created by Administrator on 2017/4/22.
 */
public class User {
    private String Id;
    private String Name;
    private String Sex;
    private Integer Age;
    private String Telephone;
    private String Address;

    public User(String id, String name, String sex, Integer age, String telephone, String address) {
        Id = id;
        Name = name;
        Sex = sex;
        Age = age;
        Telephone = telephone;
        Address = address;
    }

    public User(String id, String name, String sex, Integer age, String telephone) {
        Id = id;
        Name = name;
        Sex = sex;
        Age = age;
        Telephone = telephone;
        Address = "";
    }

    public User(String id, String name, String sex, Integer age) {
        Id = id;
        Name = name;
        Sex = sex;
        Age = age;
        Telephone = "";
        Address = "";
    }

    public User() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", Sex='" + Sex + '\'' +
                ", Age=" + Age +
                ", Telephone='" + Telephone + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
