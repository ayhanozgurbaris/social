package com.social.social.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Table(name = "comment")
public class Comment {
    @Id
    Long id;


    @JoinColumn(name = "post_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) //user silindiğinde tüm postlar silinsin
    @ManyToOne(fetch = FetchType.LAZY) //bir sürü commentın tek bir post'a bağlı olması
    @JsonIgnore
    Post post;



    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) //user silindiğinde tüm commentlar silinsin
    @ManyToOne(fetch = FetchType.LAZY) //bir sürü commentın tek bir user'a bağlı olması
    @JsonIgnore
    User user;


    @Lob
    @Column(columnDefinition = "text")
    String text;
}
