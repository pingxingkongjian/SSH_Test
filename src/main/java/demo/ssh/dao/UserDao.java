package demo.ssh.dao;

import java.util.List;

import demo.ssh.entity.User;

public interface UserDao {
	void save(User user) throws Exception;
	void update(User user) throws Exception;
	void delete(User user) throws Exception;
	User findById(String id) throws Exception;
	List findAll() throws Exception;
}
