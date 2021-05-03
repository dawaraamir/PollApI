package com.dawar.pollapi.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name="VOTE_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name="OPTION_ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Option option;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }
}
