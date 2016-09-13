package com.at.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.at.library.dto.user.UserDTO;
import com.at.library.dto.user.UserPostDTO;
import com.at.library.exceptions.InvalidDataException;
import com.at.library.exceptions.UserNotFoundException;
import com.at.library.service.user.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserDTO findById(@PathVariable("id") Integer id) throws UserNotFoundException {
		return userService.findUserDTOById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<UserDTO> findAll(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "dni", required = false) String dni) throws UserNotFoundException {
		return userService.findAll(name, dni);
	}

	@RequestMapping(method = RequestMethod.POST)
	public UserDTO create(@RequestBody UserPostDTO u) throws InvalidDataException {
		return userService.create(u);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) throws UserNotFoundException {
		userService.delete(id);
	}

}
