package demo.ssh.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.ssh.dao.UserDao;
import demo.ssh.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory fac;

	@Override
	public void save(User user) throws Exception {
		fac.getCurrentSession().save(user);
	}

	@Override
	public void update(User user) throws Exception {
		fac.getCurrentSession().update(user);
	}

	@Override
	public void delete(User user) throws Exception {
		fac.getCurrentSession().delete(user);
	}

	@Override
	public User findById(String id) throws Exception {
		return (User) fac.getCurrentSession().get(User.class, id);
	}

	@Override
	public List<User> findAll() throws Exception {
		Query query = fac.getCurrentSession().createQuery("from User");
		return query.list();
	}

}
