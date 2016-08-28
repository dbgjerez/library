package com.at.library.service.user;

import java.util.List;

import com.at.library.dto.user.UserDTO;
import com.at.library.dto.user.UserPostDTO;
import com.at.library.exceptions.InvalidDataException;
import com.at.library.exceptions.UserNotFoundException;
import com.at.library.model.User;

public interface UserService {

	/**
	 * Transforma un user en UserDTO
	 * 
	 * @param u
	 * @return
	 */
	UserDTO transform(User u);

	/**
	 * Transforma de DTO de creación en un usuario
	 * 
	 * @param u
	 * @return
	 */
	User transform(UserPostDTO u);

	/**
	 * Realiza el borrado lógico de un usuario
	 * 
	 * @param id
	 * @throws UserNotFoundException
	 */
	void delete(Integer id) throws UserNotFoundException;

	/**
	 * Da de alta un usuario en l sistema
	 * 
	 * @param u
	 * @return
	 * @throws InvalidDataException
	 */
	UserDTO create(UserPostDTO u) throws InvalidDataException;

	/**
	 * Busca un usuario por id
	 * 
	 * @param id
	 * @return
	 * @throws UserNotFoundException
	 */
	User findUserById(Integer id) throws UserNotFoundException;

	/**
	 * Devuelve un usuarioDTO buscado a través de su id
	 * 
	 * @param id
	 * @return
	 * @throws UserNotFoundException
	 */
	UserDTO findUserDTOById(Integer id) throws UserNotFoundException;

	/**
	 * Busca todos los usuarios que contengan en su nombre name o en su dni dni
	 * 
	 * @param name
	 * @param dni
	 * @return
	 */
	List<UserDTO> findAll(String name, String dni);

}
