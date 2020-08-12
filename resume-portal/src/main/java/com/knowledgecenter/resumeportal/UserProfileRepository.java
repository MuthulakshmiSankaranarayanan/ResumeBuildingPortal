package com.knowledgecenter.resumeportal;

import java.util.Optional;

import com.knowledgecenter.resumeportal.models.UserProfile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Integer>{
    Optional<UserProfile> findByUserName(String userName);
}