package com.vipsamleti.springjpademo.repository;

import com.vipsamleti.springjpademo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserJPARepository extends JpaRepository<User, Long> {

    User getByName(String name);
}
