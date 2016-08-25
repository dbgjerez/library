package com.at.library.service.book;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.at.library.dao.BookDao;
import com.at.library.dto.BookDTO;
import com.at.library.model.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Autowired
	private DozerBeanMapper dozer;

	@Override
	public List<BookDTO> findAll() {
		final Iterable<Book> findAll = bookDao.findAll();
		final List<BookDTO> res = new ArrayList<>();
		findAll.forEach(b -> {
			final BookDTO bDTO = transform(b);
			res.add(bDTO);
		});
		return res;
	}

	@Override
	public BookDTO transform(Book book) {
		return dozer.map(book, BookDTO.class);
	}

	@Override
	public Book transform(BookDTO book) {
		return dozer.map(book, Book.class);
	}

	@Override
	public BookDTO findById(Integer id) {
		final Book b = bookDao.findOne(id);
		return transform(b);
	}

	@Override
	public BookDTO create(BookDTO bookDTO) {
		final Book book = transform(bookDTO);
		return transform(bookDao.save(book));
	}

	@Override
	public void update(BookDTO bookDTO) {
		final Book book = transform(bookDTO);
		bookDao.save(book);
	}

	@Override
	public void delete(Integer id) {
		bookDao.delete(id);
	}

}
