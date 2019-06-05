package com.example.demo.models;

import javax.persistence.*;


@Entity
@Table(name = "blocklist")
public class BlockList {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String reason;

    public BlockList(){}

    public BlockList(User user, String reason) {
        this.user = user;
        this.reason = reason;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
