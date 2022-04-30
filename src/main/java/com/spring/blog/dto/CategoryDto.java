package com.spring.blog.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private Integer categoryId;

    @NotBlank
    @Size(min=4 ,message="Min siz of categoryTitle is 4")
    private String categoryTitle;

    @Size(min=10 ,message="Min siz of categoryDescription is 10")
    private String categoryDescription;

}
