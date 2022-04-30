package com.spring.blog.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    private String title;
    @Column(length = 1000)
    private String content;
    private String imageName;
    private Date createdDate;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;

}
