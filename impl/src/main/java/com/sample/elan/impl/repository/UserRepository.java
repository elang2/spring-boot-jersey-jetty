package com.sample.elan.impl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sample.elan.impl.repository.model.User;

/**
 * Crud operations for User table
 * 
 * @author elang2@gmail.com
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	@Query("select u from User u where u.age between :minAge and :maxAge")
	List<User> findUsersBetweenAge(@Param("minAge") int minAge, @Param("maxAge") int maxAge);

}
