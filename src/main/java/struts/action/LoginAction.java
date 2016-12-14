package struts.action;
import com.opensymphony.xwork2.ActionSupport;

import domain.dao.UserFacade;
import domain.model.User;

/**
 * Class of the Structs2 of the project.
 * @author PBL5
 *
 */
public class LoginAction extends ActionSupport {
    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The username.
     */
    private String username;

    /**
     * The password.
     */
    private String password;


    /**
     * The function to execute.
     * @return how goes the execution.
     */
    public String execute() {

        User user = null;
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        UserFacade uf = new UserFacade();
        if (username != null && password != null) {
            user = uf.loadUser(username, password);
        }

        if (user != null) {
            return "success1";
        } else {
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

    /**
     * Getter of the username.
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter of the username.
     * @param username is the username
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * Getter of the password.
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter of the password.
     * @param password is the password
     */
    public void setPassword(final String password) {
        this.password = password;
    }
}

