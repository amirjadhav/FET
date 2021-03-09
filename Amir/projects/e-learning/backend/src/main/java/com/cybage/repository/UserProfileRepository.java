package com.cybage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Integer>{

}
