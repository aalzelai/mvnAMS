package struts.action;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import domain.dao.DaoUserHibernate;
import domain.model.User;

public class LoginAction extends ActionSupport {

    /**
     * The username.
     */
    private String username;

    /**
     * The password.
     */
    private String password;

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
    private DaoUserHibernate userDao;

    /**
     * Constructor.
     */
    public LoginAction() {
    	userDao = new DaoUserHibernate();
	}

    /**
     * The function to execute.
     * @return how goes the execution.
     */
    public String execute() {
        /*System.out.println("Username: "+user.getUsername());
        System.out.println("Password: "+user.getPassword());
        if(user.getUsername()!=null && user.getPassword()!=null){

        }*/

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


    /**
     * Setter of the password.
     * @param password is the password
     */
    public void setPassword(final String password) {
        this.password = password;
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

