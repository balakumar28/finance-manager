package com.smfinance.datamodel.objects;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable
{
    @Id
    @GeneratedValue
    private String userId;
    private String name;
    private UserType type;
    private String mobile;
    private String mobile2;
    private String mail;
    private String city;
    private String address;
    
    public User()
    {
    }
    
    public User(String name, UserType type, String mobile, String mobile2, String mail, String city, String address)
    {
        this.name = name;
        this.type = type;
        this.mobile = mobile;
        this.mobile2 = mobile2;
        this.mail = mail;
        this.city = city;
        this.address = address;
    }
    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getMobile()
    {
        return mobile;
    }
    
    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }
    
    public String getMobile2()
    {
        return mobile2;
    }
    
    public void setMobile2(String mobile2)
    {
        this.mobile2 = mobile2;
    }
    
    public String getMail()
    {
        return mail;
    }
    
    public void setMail(String mail)
    {
        this.mail = mail;
    }
    
    public String getCity()
    {
        return city;
    }
    
    public void setCity(String city)
    {
        this.city = city;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    @Override
    public String toString()
    {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", mobile2='" + mobile2 + '\'' +
                ", mail='" + mail + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
