package com.knowledgecenter.resumeportal;

import org.springframework.data.jpa.repository.JpaRepository;
import com.knowledgecenter.resumeportal.models.*;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByUserName(String userName);
    
}