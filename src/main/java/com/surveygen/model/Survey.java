package com.surveygen.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="surveys")
public class Survey {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;

    @Column(name="requested")
    private int requested;

    @Column(name="responded")
    private int responded;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRequested() {
        return requested;
    }

    public void setRequested(int requested) {
        this.requested = requested;
    }

    public int getResponded() {
        return responded;
    }

    public void setResponded(int responded) {
        this.responded = responded;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "id=" + id +
                ", user=" + user +
                '}';
    }

}
