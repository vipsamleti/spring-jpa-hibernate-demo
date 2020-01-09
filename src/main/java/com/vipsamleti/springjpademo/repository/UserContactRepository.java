package com.vipsamleti.springjpademo.repository;

import com.vipsamleti.springjpademo.model.UserContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserContactRepository extends JpaRepository<UserContact, Integer> {
}
