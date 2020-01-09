package com.vipsamleti.springjpademo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user", catalog = "test")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    private String name;
    private String teamName;
    private Integer salary;

    @OneToMany(cascade =  CascadeType.ALL)
    @JoinColumn(name = "userId")
    private List<UserLog> userLogs;

    public User() {
    }

    public List<UserLog> getUserLogs() {
        return userLogs;
    }

    public void setUserLogs(List<UserLog> userLogs) {
        this.userLogs = userLogs;
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

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
