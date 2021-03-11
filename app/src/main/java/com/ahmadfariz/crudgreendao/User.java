package com.ahmadfariz.crudgreendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class User {
    @Id
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String address;
    @NotNull
    private String telp;

    public User() {
    }

    @Generated(hash = 292805443)
    public User(Long id, @NotNull String name, @NotNull String address,
            @NotNull String telp) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.telp = telp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }
}
