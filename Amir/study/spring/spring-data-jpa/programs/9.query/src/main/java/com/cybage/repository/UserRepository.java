package com.cybage.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cybage.model.User;

@Repository
public interface UserRepository extends JpaRepository < User, Long > {
	@Query("select u from User u where u.emailAddress = ?1")
	User findByEmailAddress(String emailAddress);

	@Query("select u from User u where u.firstname like %?1")
	List < User > findByFirstnameEndsWith(String firstname);

	//native query with @Query
//	  @Query(value = "select * from users where first_name like %?1", nativeQuery = true)
//	    List < User > findByFirstnameEndsWith(String firstname);
//
//	    @Query(value = "SELECT * FROM USERS WHERE EMAIL_ADDRESS = ?1", nativeQuery = true)
//	    User findByEmailAddress(String emailAddress);
}