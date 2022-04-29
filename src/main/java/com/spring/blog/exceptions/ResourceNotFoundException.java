package com.spring.blog.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    String resourceName;
    String fieldName;
    long fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue)
    {
        super(String.format("%s not found with %s :%s",resourceName,fieldName,fieldValue));
       // super("resource not found "+ resourceName);
        this.resourceName=resourceName;
        this.fieldName=fieldName;
        this.fieldValue=fieldValue;
    }

}
