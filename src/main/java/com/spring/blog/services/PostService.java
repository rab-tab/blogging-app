package com.spring.blog.services;

import com.spring.blog.dto.PostDto;
import com.spring.blog.entities.Category;
import com.spring.blog.entities.Post;
import com.spring.blog.entities.User;
import com.spring.blog.exceptions.ResourceNotFoundException;
import com.spring.blog.repositories.CategoryRepository;
import com.spring.blog.repositories.PostRepository;
import com.spring.blog.repositories.UserRepository;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CategoryRepository categoryRepository;


    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User ", "userId", userId));
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category ID ", "categoryId", categoryId));
        Post post=modelMapper.map(postDto,Post.class);
        post.setUser(user);
        post.setCategory(category);
        post.setCreatedDate(new Date());
        post.setImageName("default.png");
        Post newPost= postRepository.save(post);
        return  this.modelMapper.map(newPost,PostDto.class);
    }

    public Post createPost1(Post post) {
        return postRepository.save(post);
    }


    public Post getPostById(Integer postId) {
        return postRepository.getById(postId);
    }

    public List<Post> retrieveAllPosts() {
        return postRepository.findAll();
    }

    public List<PostDto> getPostsByCategory(Integer categoryId) {
        Category category=categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category",
                "categoryId",categoryId));
        List<Post> posts=this.postRepository.findByCategory(category);
        List<PostDto> postDtos=posts.stream().map(post-> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    public List<PostDto> getPostsByUser(Integer userId) {
        User user=userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User",
                "userId",userId));

        List<Post> posts=this.postRepository.findByUser(user);
        List<PostDto> postDtos=posts.stream().map(post-> this.modelMapper.map(post,PostDto.class)).
                collect(Collectors.toList());
        return postDtos;

    }

    public List<Post> serachPosts(String keyword) {
        return new ArrayList<>();
    }
}
