package demo.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Created by 三千繁华 on 2017/10/16.14:05
 */
public class BaseAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;
    protected PrintWriter out;
    protected ServletContext application;

    @Override
    public void setServletRequest(HttpServletRequest arg0) {
        this.request = arg0;
        this.session = request.getSession();
        this.application = this.request.getServletContext();
    }

    @Override
    public void setServletResponse(HttpServletResponse arg0) {
        try {
            this.response = arg0;
            this.out = this.response.getWriter();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
