package com.bawei.lib_croe.user;

import android.util.Log;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

public
/**
 *作者：王先生
 *时间：2021/11/4 16:07
 *用途：
 */
@Entity
class Users {
    @Id(autoincrement = true)
    private Long User_id;
    private String name;
    private String pic;
    private int num;
    private int prices;
    private Boolean iRse;
    @Generated(hash = 1029238041)
    public Users(Long User_id, String name, String pic, int num, int prices,
            Boolean iRse) {
        this.User_id = User_id;
        this.name = name;
        this.pic = pic;
        this.num = num;
        this.prices = prices;
        this.iRse = iRse;
    }
    @Generated(hash = 2146996206)
    public Users() {
    }
    public Long getUser_id() {
        return this.User_id;
    }
    public void setUser_id(Long User_id) {
        this.User_id = User_id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPic() {
        return this.pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }
    public int getNum() {
        return this.num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public int getPrices() {
        return this.prices;
    }
    public void setPrices(int prices) {
        this.prices = prices;
    }
    public Boolean getIRse() {
        return this.iRse;
    }
    public void setIRse(Boolean iRse) {
        this.iRse = iRse;
    }
}
