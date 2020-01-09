package com.vipsamleti.springjpademo.repository;

import com.vipsamleti.springjpademo.model.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserLogRepository extends JpaRepository<UserLog, Long> {
}
