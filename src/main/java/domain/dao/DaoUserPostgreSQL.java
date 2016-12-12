package domain.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domain.model.User;
import domain.model.UserPassenger;

/**
 * Conect the user with the database.
 * @author PBL5
 *
 */
public class DaoUserPostgreSQL implements DaoUser {

/**
 * The conector to the database.
 */
private Connection connection = null;
/**
 * Is were is going to be the query.
 */
private Statement statement = null;
/**
 * The ip of the server.
 */
private String serverName = "192.168.22.1";
/**
 * The name of the database.
 */
private String dataBaseName = "ams";
/**
 * The url of the database.
 */
private String url = "jdbc:postgresql://";
/**
 * The username to access the database.
 */
private String username = "postgres";
/**
 * The password to access the database.
 */
private String password = "root";
/**
 * Define the database connection route.
 */
private String connectionString = null;
/**
 * The port of the database.
 */
private String port = "5432";

/**
 * The constructor of DaoUserPostgreSQL.
 */
    public DaoUserPostgreSQL() {
        this.connectionString =
             url + serverName + ":" + port + "/" + dataBaseName;
    }

/**
 * Do he conection to the database.
 */
    private void connect() {

        try {
            Class.forName("org.postgresql.Driver");
            // Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(connectionString,
            username, password);
            statement = connection.createStatement();
        } catch (ClassNotFoundException e) {

        System.out.println("Connection Driver Error");
        } catch (SQLException e) {

        e.printStackTrace();
        System.out.println("Could Not Connect to DB");
        }
    }
/**
 * Disconect the conexion.
 */
    private void disconnect() {

      try {

        if (statement != null) {

          statement.clearWarnings();
          statement.close();
        }

        if (connection != null) {

          connection.clearWarnings();
          connection.close();
        }
      } catch (SQLException e) {

      System.out.println("Error disconnecting");
      }
}
/*
@Override
public boolean insertUser(User user) {
    connect();
    String sqlQuery = "insert into user values
                       (default, '"+ user.getUsername() +"',"
                       + " '"+ user.getPassword() +"',"
                       + " '"+ user.getFirstName() +"',"
                       + " '"+ user.getSecondName() +"',"
                       + " '"+ user.getEmail() +"');";

    try{
       Statement stm = connection.createStatement();
       stm.execute(sqlQuery);
    }catch(SQLException e){
    System.out.println(sqlQuery);
    e.printStackTrace();
    return false;
    }

    disconnect();
    return true;
    }
*/

/**
 * This function is used to see if the user matches.
 * @param introPassword is the password of the user.
 * @param introUsername is the username of the user.
 * @return the user
 */
    public User loadUser(final String introUsername,
                         final String introPassword) {
      User user = null;
      connect();
      ResultSet rs = null;
      String sqlQuery = "SELECT * FROM v_users "
                + "WHERE username='" + introUsername + "' "
                + "AND password='" + introPassword + "';";

      try {
         Statement stm = connection.createStatement();
         rs = stm.executeQuery(sqlQuery);
         if (rs.next()) {
            String userType =  rs.getString("description");

            try {
                switch (userType) {
                    case "Passenger":
                          user = loadUserPassenger(rs);
                         break;

                    case "Airline":
                    break;

                    case "Airport_Controller":
                    break;

                    default:
                    break;
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    System.out.println("Error query dinamica");
                }
            }
        } catch (SQLException e) {
          System.out.println(sqlQuery);
          e.printStackTrace();
          System.out.println("Error bad sql ");
        }
          disconnect();
          return user;
    }

/**
 * Use the resulset to obtain the user.
 * @param rs the return of the query
 * @return the user
 * @throws SQLException is the exception
 */
    public User loadUserPassenger(final ResultSet rs) throws SQLException {
        Statement stm = connection.createStatement();
        ResultSet userRs = null;
        String sqlQuery = "SELECT * FROM user_passenger WHERE id_user = "
                          + rs.getInt("id_user") + ";";

        userRs = stm.executeQuery(sqlQuery);
        if (userRs.next()) {
            return new UserPassenger(rs.getInt("id_user"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("description"),
                    userRs.getString("telephone"),
                    userRs.getString("email"));
        }
        return null;
    }

/*
    @Override
    public User loadUser(int userId) {
        User user = null;
        connect();
        ResultSet rs = null;
        String sqlQuery = "SELECT * FROM user "
               + "WHERE userId="+userId+";";

        try{
            Statement stm = connection.createStatement();
            rs = stm.executeQuery(sqlQuery);
            if(rs.next()){
                user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("first_name"));
                user.setSecondName(rs.getString("second_name"));
                user.setEmail(rs.getString("email"));
           }
        }catch(SQLException e){
           System.out.println(sqlQuery);
           e.printStackTrace();
           System.out.println("Error DaoLoginMysql exists select");
        }
        disconnect();
        return user;
    }

@Override
public ArrayList<User> loadUsers() {
    ArrayList<User> usuarios = new ArrayList<>();
    User user = null;
    connect();
    ResultSet rs = null;
    String sqlQuery = "SELECT * FROM user;";
    try{
       Statement stm = connection.createStatement();
       rs = stm.executeQuery(sqlQuery);
       while(rs.next()){
            user = new User();
            user.setUserId(rs.getInt("userId"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setFirstName(rs.getString("first_name"));
            user.setSecondName(rs.getString("second_name"));
            user.setEmail(rs.getString("email"));
            usuarios.add(user);
        }
        }catch(SQLException e){
            System.out.println(sqlQuery);
            e.printStackTrace();
            System.out.println("Error DaoLoginMysql exists select");
        }
        disconnect();
        return usuarios;
}


@Override
public boolean updateUser(User user) {
    connect();
    String sqlQuery = "update user set username = '"+ user.getUsername() +"', "
        + "password = '"+ user.getPassword() +"', "
        + "first_name = '"+ user.getFirstName() +"', "
        + "second_name = '"+ user.getSecondName() +"', "
        +" email = '"+ user.getEmail() +"' "
        + "where userId = "+ user.getUserId() +";";

        try{
            Statement stm = connection.createStatement();
            stm.executeUpdate(sqlQuery);
        }catch(SQLException e){
           System.out.println(sqlQuery);
           e.printStackTrace();
           return false;
        }

        disconnect();
        return true;
    }


@Override
public boolean deleteUser(int userId) {
    connect();
    String sqlQuery = "delete from user where userId = " + userId + ";";

    try{
        Statement stm = connection.createStatement();
        stm.executeUpdate(sqlQuery);
        }catch(SQLException e){
            System.out.println(sqlQuery);
            e.printStackTrace();
            return false;
        }

        disconnect();
        return true;
    }
*/
}
