package com.spring.blog.dto;

import com.spring.blog.entities.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private int id;

    @NotEmpty
    @Size(min=4,message="Name should be min 4 chars")
    private String name;

    @Email(message = "Email address not valid")
    private String email;

    @NotEmpty
    @Size(min=4,max=10,message="Password should be min 4 chars and max 10 chars")
    private String password;

    private String about;

}
