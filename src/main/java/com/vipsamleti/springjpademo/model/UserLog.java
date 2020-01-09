package com.vipsamleti.springjpademo.model;

import javax.persistence.*;

@Entity
@Table(name = "user_log", catalog = "test")
public class UserLog {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String log;
    private long userId;

    public UserLog() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
