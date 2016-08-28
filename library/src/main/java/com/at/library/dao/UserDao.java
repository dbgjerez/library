package com.at.library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.at.library.dto.user.UserDTO;
import com.at.library.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

	@Query(value = "select new com.at.library.dto.user.UserDTO(u.id, u.dni, u.name) from User as u where (:name is null OR u.name like %:name%) AND (:dni is null OR u.dni like %:dni%)")
	List<UserDTO> findByNameAndDni(@Param(value = "name") String name, @Param(value = "dni") String dni);

}
