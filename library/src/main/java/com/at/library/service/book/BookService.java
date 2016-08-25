package com.at.library.service.book;

import java.util.List;

import com.at.library.dto.BookDTO;
import com.at.library.model.Book;

public interface BookService {

	/**
	 * Realiza la busqueda de todos los libros existentes
	 * 
	 * @return listado de libros
	 */
	List<BookDTO> findAll();

	/**
	 * Transfrma un libro en un libroDTO
	 * 
	 * @param book
	 * @return
	 */
	BookDTO transform(Book book);

	/**
	 * Transforma un libroDTO en un libro
	 * 
	 * @param book
	 * @return
	 */
	Book transform(BookDTO book);

	/**
	 * Busca por id
	 * 
	 * @param id
	 * @return
	 */
	BookDTO findById(Integer id);

	/**
	 * Crea un libro
	 * 
	 * @param book
	 * @return
	 */
	BookDTO create(BookDTO book);

	/**
	 * Modifica un libro
	 * 
	 * @param book
	 */
	void update(BookDTO book);

	/**
	 * Borra un libro
	 * 
	 * @param id
	 */
	void delete(Integer id);

}
