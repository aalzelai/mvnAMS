package struts2.action;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
    private String username;
    private String password;
 
    public String execute() {
 
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

