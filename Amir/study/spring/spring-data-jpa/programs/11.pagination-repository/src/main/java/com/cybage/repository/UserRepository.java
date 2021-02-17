package com.cybage.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cybage.model.User;

@Repository
public interface UserRepository extends org.springframework.data.repository.Repository<User, Long>{

	Page<User> findAll(Pageable p);

	public List<User> findByHobby(String hobby, Pageable pr);
	public List<User> findByAge(int age, Pageable pr);
	
	//with query annotation
	@Query(value = "select * from user where name = :name", nativeQuery = true)
	public List<User> findByName(@Param("name")String name, Pageable pr);
}