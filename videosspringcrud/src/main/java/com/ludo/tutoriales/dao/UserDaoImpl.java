package com.ludo.tutoriales.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ludo.tutoriales.model.Book;
import com.ludo.tutoriales.model.User;
import com.ludo.tutoriales.other.Fecha;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<?> list() {
		String sentencia;
		TypedQuery<?> query;
		sentencia = "from User u ORDER BY u.username";
		query = sessionFactory.getCurrentSession().createQuery(sentencia);
		return query.getResultList();
	}

	@Override
	public long num() {

		return ((long) sessionFactory.getCurrentSession().createQuery("SELECT COUNT(*) FROM User").uniqueResult());
	}

	@Override
	public void save(Object user) {
		if (get(((User) user).getUsername()) == null) {
			sessionFactory.getCurrentSession().persist(user);
		} else {
			sessionFactory.getCurrentSession().merge(user);
		}

	}

	@Override
	public void delete(String username) {
		User savedUserEntity = sessionFactory.getCurrentSession().find(User.class, username);
		sessionFactory.getCurrentSession().remove(savedUserEntity);

	}

	@Override
	public User get(String username) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, username);
		return user;
	}

	@Override
	public void loanBooks(@Valid User user) {
		// Qué lista tenemos?
		// Metemos la lista en una lista provisional
		List<Book> listaEnviada = user.getBooks();
		// Borramos la lista anterior
		// Eso provoca que se borré los registros de la BDD
		user.setBooks(new ArrayList<>());
		// Cargamos los libros enviados en una nueva lista
		for (Book book : listaEnviada) {
			// por cada elemento enviado en el fomr
			// hacemos una frase que usaremos para la consulta
			String sentencia = "from Book book where book.title = :title";
			// cargamos la session factory y la base de la frase, hacemos una consulta
			// para sacar un único libro
			Book loanedBookEntity = (Book) sessionFactory.getCurrentSession().createQuery(sentencia)
					.setParameter("title", book.getTitle()).uniqueResult();
			// añadimos dicho libro a la lista de libros que tiene nuestro usuario
			user.getBooks().add(loanedBookEntity);
		}
		// Grabamos
		user.setUpdatedAt(Fecha.getTimeStamp());
		sessionFactory.getCurrentSession().merge(user);
		// Sinronizamos la BDD
		sessionFactory.getCurrentSession().flush();

	}

}
