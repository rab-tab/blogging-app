package com.spring.blog.services;

import com.spring.blog.dto.CommentDto;
import com.spring.blog.entities.Comment;
import com.spring.blog.entities.Post;
import com.spring.blog.exceptions.ResourceNotFoundException;
import com.spring.blog.repositories.CommentRepository;
import com.spring.blog.repositories.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;

    //create comment , for which post ?
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        //get post with postId
        Post post=this.postRepository.findById(postId).orElseThrow(() -> new
                ResourceNotFoundException("POst not found", "PostId", postId));
        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);

        Comment savedComment=this.commentRepository.save(comment);
        return this.modelMapper.map(savedComment,CommentDto.class);
    }

    public void deleteComment(int commentId) {
            Comment com=this.commentRepository.findById(commentId).orElseThrow(() -> new
                    ResourceNotFoundException("Comment not found", "commentId", commentId));
            this.commentRepository.delete(com);
    }
}
