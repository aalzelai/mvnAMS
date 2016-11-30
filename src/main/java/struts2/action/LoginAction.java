package struts2.action;
import com.opensymphony.xwork2.ActionSupport;

import domain.dao.UserFacade;
import domain.model.User;

public class LoginAction extends ActionSupport {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
    private String password;
 
    public String execute() {
 
    	User user = null;
		System.out.println("Username: "+username);
		System.out.println("Password: "+password);
		
		UserFacade uf = new UserFacade();
		if(username!=null && password!=null){
			user = uf.loadUser(username, password);
		}
			
		if(user != null){
			return "success1";
		}else{
			return "error";
		}
    	
    	
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
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
}

