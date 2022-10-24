package com.ludo.tutoriales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ludo.tutoriales.dao.LibraryDao;
import com.ludo.tutoriales.dao.RoleDao;
import com.ludo.tutoriales.dao.UserDao;
import com.ludo.tutoriales.model.Book;
import com.ludo.tutoriales.model.Category;
import com.ludo.tutoriales.model.Role;
import com.ludo.tutoriales.model.User;
import com.ludo.tutoriales.other.Fecha;

@Service
public class ServicesImpl implements BookService, CategoryService, UserService, RoleService, UserDetailsService {

	@Autowired
	@Qualifier("bookDaoImpl")
	private LibraryDao bookDao;

	@Autowired
	@Qualifier("categoryDaoImpl")
	private LibraryDao categoryDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Override
	@Transactional(readOnly = true)
	public List<?> listBooks() {
		return bookDao.list();
	}

	@Override
	@Transactional
	public Long numBooks() {
		return bookDao.num();
	}

	@Override
	@Transactional
	public void save(Book book) {
		if (book.getId() > 0) {
			System.out.println("Actu de libro");
			book.setUpdatedAt(Fecha.getTimeStamp());
		} else {
			System.out.println("Creación de libro");
			book.setUpdatedAt(Fecha.getTimeStamp());
			book.setCreatedAt(Fecha.getTimeStamp());
		}
		bookDao.save(book);
	}

	@Override
	@Transactional
	public void deleteBook(long id) {
		bookDao.delete(id);
	}

	@Override
	@Transactional
	public Book getBook(long id) {
		Book book = (Book) bookDao.get(id);
		return book;
	}

	@Override
	@Transactional(readOnly = true)
	public List<?> listCategories() {
		return categoryDao.list();
	}

	@Override
	@Transactional
	public Long numCategories() {
		return categoryDao.num();
	}

	@Override
	@Transactional
	public void save(Category category) {
		if (category.getId() > 0) {
			System.out.println("Actu de categoría");
			category.setUpdatedAt(Fecha.getTimeStamp());
		} else {
			System.out.println("Creación de categoría");
			category.setUpdatedAt(Fecha.getTimeStamp());
			category.setCreatedAt(Fecha.getTimeStamp());
		}
		categoryDao.save(category);

	}

	@Override
	@Transactional
	public void deleteCategory(long id) {
		categoryDao.delete(id);

	}

	@Override
	@Transactional
	public Category getCategory(long id) {
		// TODO Auto-generated method stub
		return (Category) categoryDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<?> listUsers() {
		// TODO Auto-generated method stub
		return userDao.list();
	}

	@Override
	@Transactional(readOnly = true)
	public List<?> listWithBooks() {
		// TODO Auto-generated method stub
		return userDao.listWithBooks();
	}

	@Override
	@Transactional(readOnly = true)
	public List<?> findByEmail(Object email) {
		// TODO Auto-generated method stub
		return userDao.findByEmail(email);
	}

	@Override
	@Transactional
	public Long numUsers() {
		// TODO Auto-generated method stub
		return userDao.num();
	}

	@Override
	@Transactional
	public void save(User user) {
		User copiaUser = null;
		if (userDao.get(user.getUsername()) == null) {
			copiaUser = new User();
			copiaUser.setEnabled(true);
			copiaUser.setCreatedAt(Fecha.getTimeStamp());
		} else {
			copiaUser = userDao.get(user.getUsername());
			copiaUser.setEnabled(user.isEnabled());
		}
		copiaUser.setUpdatedAt(Fecha.getTimeStamp());
		copiaUser.setUsername(user.getUsername());
		// email
		copiaUser.setEmail(user.getEmail().toLowerCase());
		// surname
		copiaUser.setSurname(user.getSurname().toUpperCase());
		// name
		copiaUser.setName(user.getName().substring(0, 1).toUpperCase()
				+ user.getName().substring(1, user.getName().length()).toLowerCase());
		// password
		String encoded = new BCryptPasswordEncoder().encode(user.getPassword());
		copiaUser.setPassword(encoded);
		copiaUser.setConfirmPassword(encoded);

		userDao.save(copiaUser);
	}

	@Override
	@Transactional
	public void deleteUser(String username) {
		userDao.delete(username);

	}

	@Override
	@Transactional
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return userDao.get(username);
	}

	@Override
	@Transactional
	public void loanBooks(User user) {
		userDao.loanBooks(user);

	}

	@Override
	@Transactional
	public User getUserWithBooks(String username) {
		return userDao.getWithBooks(username);
	}

	@Override
	@Transactional
	public void save(Role role) {
		roleDao.save(role);

	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userDao.get(username);
		UserBuilder builder = null;

		if (user != null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.disabled(!user.isEnabled());
			builder.password(user.getPassword());
			String[] authorities = user.getRoles().stream().map(a -> a.getAuthority()).toArray(String[]::new);
			builder.authorities(authorities);

		} else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}

		return builder.build();

	}

}
