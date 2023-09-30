package com.springboot.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.crud.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
