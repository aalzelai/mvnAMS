package struts.action;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.dao.DaoUser;
import domain.model.User;


/**
 * Class LoginAction.
 * @author PBL5
 *
 */
public class LoginAction extends ActionSupport {

    /**
     * The user.
     */
    private User user;

    /**
     * The list of the users.
     */
    private List<User> userList;

    /**
     * The hibernate.
     */
    private DaoUser userDao;

    /**
     * Constructor.
     */
    public LoginAction() {
        userDao = new DaoUser();
    }

    /**
     * The function to execute.
     * @return how goes the execution.
     */
    public String execute() {
        System.out.println("Username: "+user.getUsername());
        System.out.println("Password: "+user.getPassword());
        if(user.getUsername()!=null && user.getPassword()!=null){
        	Object loggedUser = new User();
        	loggedUser = userDao.loadUser(user.getUsername(), user.getPassword());
        	
        	Map<String, Object> session = ActionContext.getContext().getSession();
        	HttpServletRequest request = ServletActionContext.getRequest();
        	
        	if(loggedUser != null){
        		session.put("user", loggedUser);
        		request.setAttribute("loginError", false);
        	}else{
        		request.setAttribute("loginError", true);
        	}
        }
        return "success";
    }
    
    public String removeUser(){
    	Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("user");
				
		return "success";
    }


    /**
     * Getter of the user.
     * @return the user.
     */
    public User getUser() {
        return user;
    }

    /**
     * Setter of the user.
     * @param user is the user.
     */
    public void setUser(final User user) {
        this.user = user;
    }


    /**
     * Getter of the list of the users.
     * @return the list of the users.
     */
    public List<User> getUserList() {
        return userList;
    }

    /**
     * Setter of the list of the users.
     * @param userList is the list of the users.
     */
    public void setUserList(final List<User> userList) {
        this.userList = userList;
    }
}

