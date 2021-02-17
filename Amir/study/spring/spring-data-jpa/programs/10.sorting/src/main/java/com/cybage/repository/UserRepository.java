package com.cybage.repository;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cybage.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	public List<User> findByHobby(String Hobby, Sort sort);
	
	List<User> findByHobbyOrderByNameAsc(String hobby);
		
	@Query("select u from User u order by u.name asc")
	public List<User> findUsersAsc();
	
	@Query("select u from User u order by u.name desc")
	public List<User> findUsersDesc();
	
	//with sort inside method of @Query
	@Query("select u from User u")
	public List<User> myMethodofSorting(Sort sort);
	
	//query using query generation and sorting
	public List<User> findByName(String name, Sort sort);
}