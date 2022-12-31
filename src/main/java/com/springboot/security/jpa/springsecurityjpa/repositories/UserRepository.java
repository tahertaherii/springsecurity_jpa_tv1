package com.springboot.security.jpa.springsecurityjpa.repositories;

import com.springboot.security.jpa.springsecurityjpa.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<Users,Long> {

    public Optional<Users> findByUserName(String userName);
}
