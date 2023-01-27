package com.social.social.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Table(name = "post")
public class Post {
    @Id
    Long id;

    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) //user silindiğinde tüm postları silinsin
    @ManyToOne(fetch = FetchType.LAZY) //bir sürü postun tek bir user'a bağlı olması
    @JsonIgnore
    User user;

    String title;


    @Lob //varchar yerine text algılaması için
    @Column(columnDefinition = "text")
    String text;

}
