package demo.ssh.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.opensymphony.xwork2.ActionContext;

import demo.ssh.dao.UserDao;
import demo.ssh.entity.User;
import demo.ssh.service.UserService;
import demo.ssh.util.DigestHelper;

@Service
public class UserServiceImpl implements UserService{

	//引入各种DAO
	@Autowired UserDao dao ;
	@Autowired SessionFactory fac;

	//BeforeMethod-AfterReturning
	public void save(User user) throws Exception {
		//检测IP是否北京
		//用户名是否存在
		//名字是否吉利
		//今天是否黄道吉日
		user.setPassword(DigestHelper.digest(user.getPassword(), DigestHelper.MD5));
		dao.save(user);
		
		//throw new RuntimeException("你瞅啥"); //Runtime异常会导致事务回滚

		
	}

}
