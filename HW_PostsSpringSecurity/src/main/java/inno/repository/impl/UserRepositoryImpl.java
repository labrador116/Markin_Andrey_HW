package inno.repository.impl;

import inno.model.User;
import inno.repository.UserRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 * Created by Andrey_pers on 27.11.2016.
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	EntityManager em;

	@Override
	public Long idByLogin(String login) {
		Query query= em.createQuery("SELECT user.id from User user where user.login=:login");
		query.setParameter("login",login);
		Long id=(Long)query.getSingleResult();
		return id;
	}

	@Override
	public boolean userAdd(User user) {
		em.persist(user);
		return true;
	}

	@Override
	public boolean userCheck(String login, String password) {
	Query query= em.createQuery("SELECT user.id from User user where user.login=:login");
		query.setParameter("login",login);
		Long id=(Long)query.getSingleResult();

		query=em.createQuery("SELECT user.password From User user Where user.id = :id");
		query.setParameter("id", id);
		String pass = (String)query.getSingleResult();

		if (password.equals(pass))
			return true;
		else
			return false;
	}
}
