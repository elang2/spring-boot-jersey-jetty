package com.sample.elan.impl.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.sample.elan.api.UserDto;
import com.sample.elan.impl.exception.DataNotFoundException;
import com.sample.elan.impl.service.UserService;

@Path("/user")
@Component
/**
 * Exposes REST service endpoints to retrieve and save user information.
 * 
 * @author elang2@gmail.com
 */
public class UserResource {

	@Autowired
	UserService userService;

	@GET
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserDto getUserById(@PathParam("userId") long userId) {

		UserDto userDto = null;
		try {
			userDto = userService.getUserById(userId);
		} catch (Exception e) {
			processException(e);
		}
		return userDto;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserDto> getUsersAgedBetween(@QueryParam("minAge") int minAge, @QueryParam("maxAge") int maxAge) {
		List<UserDto> userList = null;
		try {
			userList = userService.getUsersBetweenAge(minAge, maxAge);
		} catch (Exception e) {
			processException(e);
		}

		return userList;

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Long saveUser(@RequestBody UserDto userDto) {
		return userService.saveUser(userDto);
	}

	private void processException(Exception exception) {

		if (exception instanceof DataNotFoundException) {
			throw new NotFoundException();
		} else {
			throw new InternalServerErrorException();
		}

	}

}
