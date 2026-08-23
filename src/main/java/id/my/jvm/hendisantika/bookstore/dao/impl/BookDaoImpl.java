package id.my.jvm.hendisantika.bookstore.dao.impl;

import java.util.List;

import jakarta.persistence.criteria.CriteriaQuery;

import id.my.jvm.hendisantika.bookstore.dao.BookDao;
import id.my.jvm.hendisantika.bookstore.model.Book;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveBook(Book book) {
		getSession().merge(book);

	}

	public List<Book> listBooks() {
		CriteriaQuery<Book> criteria = getSession().getCriteriaBuilder().createQuery(Book.class);
		criteria.from(Book.class);
		return getSession().createQuery(criteria).getResultList();
	}

	public Book getBook(Long id) {
		return getSession().find(Book.class, id);
	}

	public void deleteBook(Long id) {

		Book book = getBook(id);

		if (null != book) {
			getSession().remove(book);
		}

	}

	private Session getSession() {
		Session sess = getSessionFactory().getCurrentSession();
		if (sess == null) {
			sess = getSessionFactory().openSession();
		}
		return sess;
	}

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
