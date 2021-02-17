package com.cybage.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.sql.Insert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByAge(int age);
	List<User> findByActive(int active);
}