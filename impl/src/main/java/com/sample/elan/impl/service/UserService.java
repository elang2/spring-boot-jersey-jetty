package com.sample.elan.impl.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.elan.api.UserDto;
import com.sample.elan.impl.exception.DataNotFoundException;
import com.sample.elan.impl.repository.UserRepository;
import com.sample.elan.impl.repository.model.User;

/**
 * Service layer acting as an interface between the REST endpoints and the persistence layer.
 * This layer contains the business logic and also any transformation that needs to be done.
 * 
 * @author elang2@gmail.com
 */
@Component
public class UserService {

	@Autowired
	UserRepository userRepository;

	/**
	 * Retrieve a user by userId
	 * 
	 * @param userId id of the user
	 * @return User data transfer object
	 */
	public UserDto getUserById(long userId) {
		User user = userRepository.findOne(userId);
		if (user == null) {
			throw new DataNotFoundException("Unable to find data for userId -" + userId);
		}
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		return userDto;
	}
	
	/**
	 * Saves the user information in the database and returns the id of the saved record
	 * 
	 * @param userDto a user data transfer object
	 * @return id of the saved user record
	 */
	@Transactional
	public Long saveUser(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		user = userRepository.save(user);
		return user.getUserId();
	}

	/**
	 * Retrieve a list of users who are aged between the provided min and max age
	 * 
	 * @param minAge minimum age of the user
	 * @param maxAge maximum age of the user
	 * @return List of user data transfer object
	 */
	public List<UserDto> getUsersBetweenAge(int minAge, int maxAge) {
		List<User> users = userRepository.findUsersBetweenAge(minAge, maxAge);
		final List<UserDto> userDtoList = new ArrayList<UserDto>();

		users.parallelStream().forEach(user -> {
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(user, userDto);
			userDtoList.add(userDto);
		});

		return userDtoList;

	}

}
