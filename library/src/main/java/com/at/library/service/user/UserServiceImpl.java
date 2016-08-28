package com.at.library.service.user;

import java.util.Date;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.at.library.dao.UserDao;
import com.at.library.dto.user.UserDTO;
import com.at.library.dto.user.UserPostDTO;
import com.at.library.exceptions.InvalidDataException;
import com.at.library.exceptions.UserNotFoundException;
import com.at.library.model.User;

@Service
public class UserServiceImpl implements UserService {

	private static final String EMPTY = "";

	@Autowired
	private UserDao userDao;

	@Autowired
	private DozerBeanMapper mapper;

	public UserDTO findUserDTOById(Integer id) throws UserNotFoundException {
		return transform(findUserById(id));
	}

	public User findUserById(Integer id) throws UserNotFoundException {
		final User user = userDao.findOne(id);
		if (user != null && user.getDeleted() == null) {
			return user;
		}
		throw new UserNotFoundException();
	}

	public UserDTO create(UserPostDTO u) throws InvalidDataException {
		if (validate(u)) {
			final User user = transform(u);
			user.setCreatedAt(new Date());
			return transform(userDao.save(user));
		}
		throw new InvalidDataException("Los datos del usuario no son correctos");
	}

	public void delete(Integer id) throws UserNotFoundException {
		final User u = findUserById(id);
		u.setDeleted(new Date());
		userDao.save(u);
	}

	public User transform(UserPostDTO u) {
		return mapper.map(u, User.class);
	}

	public UserDTO transform(User u) {
		return mapper.map(u, UserDTO.class);
	}

	private Boolean validate(UserPostDTO u) {
		return u != null && u.getDni() != null && !u.getDni().equals(EMPTY) && u.getName() != null;
	}
}
