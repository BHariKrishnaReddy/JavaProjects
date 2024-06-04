package com.example.restfulWebService.restfulWebServices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restfulWebService.restfulWebServices.users.Users;

public interface UserRepository extends JpaRepository<Users,Integer> {

}
