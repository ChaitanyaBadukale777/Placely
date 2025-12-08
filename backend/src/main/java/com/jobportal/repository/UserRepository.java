package com.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jobportal.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailAndPassword(String email, String password);
}
