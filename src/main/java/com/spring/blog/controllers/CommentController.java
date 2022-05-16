package com.spring.blog.controllers;

import com.spring.blog.dto.CommentDto;
import com.spring.blog.entities.Comment;
import com.spring.blog.services.CommentService;
import com.spring.blog.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment, @PathVariable Integer postId) {
        CommentDto createdComment = this.commentService.createComment(comment, postId);
        return new ResponseEntity<CommentDto>(createdComment, HttpStatus.CREATED);

    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> createComment(@PathVariable Integer commentId) {
        this.commentService.deleteComment(commentId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Comment deleted successfully", true),
                HttpStatus.OK);

    }

}
