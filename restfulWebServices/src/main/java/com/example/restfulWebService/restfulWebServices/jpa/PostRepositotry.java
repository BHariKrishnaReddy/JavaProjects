package com.example.restfulWebService.restfulWebServices.jpa;

import com.example.restfulWebService.restfulWebServices.users.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepositotry extends JpaRepository<Post,Integer> {

}

