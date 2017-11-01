package demo.ssh.service;

import demo.ssh.entity.User;
/**
 * 业务逻辑层接口
 * @author Master.Xia
 *
 */
public interface UserService {
	
	
	void save(User user) throws Exception;
	
	
}
