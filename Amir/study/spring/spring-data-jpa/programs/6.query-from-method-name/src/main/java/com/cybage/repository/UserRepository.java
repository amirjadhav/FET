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
	
	Optional<User> findByLastnameAndFirstname(String lastname, String firstname );

	List<User> findByLastnameOrFirstname(String lastname, String firstname);

	List<User> findByStartDateBetween(Date date1, Date date2);

	List<User> findByAgeLessThan(int age);

	List<User> findByAgeLessThanEqual(int age);

	List<User> findByAgeGreaterThan(int age);

	List<User> findByAgeGreaterThanEqual(int age);

	List<User> findByStartDateAfter(Date date);

	List<User> findByStartDateBefore(Date date);

	List<User> findByAgeIsNull();

	List<User> findByFirstnameLike(String firstname);

	List<User> findByFirstnameNotLike(String firstname);

	Optional<User> findByFirstnameStartingWith(String firstname);

	List<User> findByFirstnameEndingWith(String firstname);

	List<User> findByFirstnameContaining(String firstname);

	Optional<User> findByAgeOrderByLastnameDesc(int age);

	List<User> findByLastnameNot(String lastname);

	List<User> findByAgeIn(Collection<Integer> ages);

	List<User> findByAgeNotIn(Collection<Integer> ages);

	List<User> findByActiveTrue();

	List<User> findByActiveFalse();

	List<User> findByFirstnameIgnoreCase(String firstname);	
}