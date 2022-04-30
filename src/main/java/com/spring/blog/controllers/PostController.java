package com.spring.blog.controllers;

import com.spring.blog.dto.PostDto;
import com.spring.blog.entities.Post;
import com.spring.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,
                                           @PathVariable Integer userId,
                                           @PathVariable Integer categoryId) {
        PostDto createPost=postService.createPost(postDto,userId,categoryId);
        return new ResponseEntity<>(createPost, HttpStatus.CREATED);

    }
}
