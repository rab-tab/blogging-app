package com.spring.blog.dto;

import com.spring.blog.entities.Category;
import com.spring.blog.entities.Comment;
import com.spring.blog.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private String title;
    private String content;
    private String imageName;
    private Date createdDate;
    private CategoryDto categoryDto;
    private UserDto user;
    private Set<Comment> comments=new HashSet<>();



}
