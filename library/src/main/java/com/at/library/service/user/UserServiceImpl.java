package com.at.library.service.user;

import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.at.library.dao.UserDao;
import com.at.library.dto.user.UserDTO;
import com.at.library.dto.user.UserPostDTO;
import com.at.library.exceptions.InvalidDataException;
import com.at.library.exceptions.UserNotFoundException;
import com.at.library.model.User;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	private static final String EMPTY = "";
	private static final String LIKE = "%";

	@Autowired
	private UserDao userDao;

	@Autowired
	private DozerBeanMapper mapper;

	@Override
	@Scheduled(cron = "0 0/1 * * * ?")
	public void penalize() {
		log.debug("Comienza el proceso de penalización de usuarios");
	}

	@Override
	@Scheduled(cron = "0 0/1 * * * ?")
	public void forgive() {
		log.debug("Comienza el proceso de comprobación de sanciones de usuarios");
	}

	@Override
	public List<UserDTO> findAll(final String name, final String dni) {
		return userDao.findByNameAndDni(likeParam(name), likeParam(dni));
	}

	private String likeParam(String param) {
		if (param != null) {
			return LIKE.concat(param).concat(LIKE);
		}
		return param;
	}

	@Override
	public UserDTO findUserDTOById(Integer id) throws UserNotFoundException {
		return transform(findUserById(id));
	}

	@Override
	public User findUserById(Integer id) throws UserNotFoundException {
		final User user = userDao.findOne(id);
		if (user != null && user.getDeleted() == null) {
			return user;
		}
		throw new UserNotFoundException();
	}

	@Override
	public UserDTO create(UserPostDTO u) throws InvalidDataException {
		if (validate(u)) {
			final User user = transform(u);
			user.setCreatedAt(new Date());
			return transform(userDao.save(user));
		}
		throw new InvalidDataException("Los datos del usuario no son correctos");
	}

	@Override
	public void delete(Integer id) throws UserNotFoundException {
		final User u = findUserById(id);
		u.setDeleted(new Date());
		userDao.save(u);
	}

	@Override
	public User transform(UserPostDTO u) {
		return mapper.map(u, User.class);
	}

	@Override
	public UserDTO transform(User u) {
		return mapper.map(u, UserDTO.class);
	}

	private Boolean validate(UserPostDTO u) {
		return u != null && u.getDni() != null && !u.getDni().equals(EMPTY) && u.getName() != null;
	}
}
