package demo.ssh.action;

import java.io.File;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.opensymphony.xwork2.ModelDriven;

import demo.ssh.entity.Book;
import demo.ssh.entity.User;
import demo.ssh.service.UserService;
import demo.ssh.util.ApplicationContextUtil;
import demo.ssh.util.MailUtil;
//所有的action都已经托管给Spring，所以才能在里面自动装配

@ParentPackage("app-default")
public class UserAction extends BaseAction implements ModelDriven<User>{
	
	@Autowired UserService userService;
	
	private User user = new User(); //ModelDriven不需要getset，但是需要实例化
	

	/**
	 * 注册用户
	 * 参数：username,password,email,ok,cc
	 */
	public String save() throws Exception {
		String ok = request.getParameter("ok");
		String cc = request.getParameter("cc"); //用户填写的验证码
		
		if(ok==null)return "register";
		if(!cc.equals(session.getAttribute("code")))return "register";
		
		userService.save(user);
		return "login";
	}
	public String test() throws Exception {
		ApplicationContext ctx = ApplicationContextUtil.getContext();
		Object obj = ctx.getBean("sessionFactory");
		System.out.println(obj);
		return null;
	}
	
	public String sendmail() throws Exception {
		
		ApplicationContextUtil.getContext().getBean(SessionFactory.class, "sessionFactory");
		
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		String c = request.getParameter("c");
		File f = new File("C:\\Users\\Master.Xia\\Pictures\\0.gif");
		MailUtil.send(a, b, c,f, true);

		response.getWriter().print("success-send-mail");
		return null;
	}


	@Override
	public User getModel() {
		return user;
	}
	
}
