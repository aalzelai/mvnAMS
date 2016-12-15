package struts2.action;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import domain.dao.DaoUserHibernate;
import domain.model.User;

public class LoginAction extends ActionSupport {
    /**
     * j.
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private List<User> userList;
	private DaoUserHibernate userDao;
    
    public LoginAction() {
    	userDao = new DaoUserHibernate();
	}

 
    public String execute() {
 
		/*System.out.println("Username: "+user.getUsername());
		System.out.println("Password: "+user.getPassword());
		
		if(user.getUsername()!=null && user.getPassword()!=null){
			
		}*/
    	
    	userDao = new DaoUserHibernate();
    	
    	System.out.println("LLEGA 1");
    	
		userList = userDao.loadUser();
		
    	System.out.println("LLEGA 2");
    	
    	System.out.println("Hay " + userList.size() + " usuarios");

		return "success2";
		
		/*if(user != null){
			return "success1";
		}else{
			return "error";
		}*/

    	/*
    	System.out.println("user: "+this.username);
        if (this.username.equals("admin1")
                && this.password.equals("admin")) {
            return "success1";
        } else if(this.username.equals("admin2")
                && this.password.equals("admin")) {
        	return "success2";
        }else if(this.username.equals("admin3")
                && this.password.equals("admin")) {
        	return "success3";
        }else if(this.username.equals("admin4")
                && this.password.equals("admin")) {
        	return "success4";
        }
        else {
            addActionError(getText("error.login"));
            return "error";
        }
        */
    }
 
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public List<User> getUserList() {
		return userList;
	}


	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	
    
    
}

