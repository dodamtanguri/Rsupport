package com.example.Rsupport.contents.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorId;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "email", unique = true)
    private String email;


}
