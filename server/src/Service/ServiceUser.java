package Service;

import java.sql.*;

import Connection.DatabaseConnection;
import Model.Model_Client;
import Model.Model_Login;
import Model.Model_Message;
import Model.Model_Register;
import Model.Model_User_Account;

import java.util.ArrayList;
import java.util.List;

public class ServiceUser {

    private final Connection conn;

    //SQL QUERIES
    private final String LOGIN = "SELECT USERID, UA.USERNAME, GENDER, IMAGESTRING FROM USER JOIN USER_ACCOUNTS UA USING (USERID) WHERE USER.USERNAME = BINARY(?) AND USER.PASSWORD = BINARY(?) AND UA.STATUS = '1'";
    private final String SELECT_USER_ACCOUNT = "SELECT USERID, USERNAME, GENDER, IMAGESTRING FROM USER_ACCOUNTS WHERE STATUS = '1' AND USERID<>?";
    private final String CHECK_USER = "SELECT USERID FROM USER WHERE USERNAME = ? AND PHONE = ? LIMIT 1;";
    private final String insert_user = "INSERT INTO USER(USERNAME, PHONE, PASSWORD) VALUES(?,?,?)";
    private final String insert_user_account = "INSERT INTO USER_ACCOUNTS(USERID, USERNAME) VALUES(?,?)";

    public ServiceUser() {
        this.conn = DatabaseConnection.getInstance().getConnection();
    }

    public Model_Message register(Model_Register data) {
        Model_Message message = new Model_Message();
        try {
            conn.setAutoCommit(false);
            PreparedStatement p = conn.prepareStatement(CHECK_USER, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            p.setString(1, data.getUsername());
            p.setString(2, data.getPhone_no());
            ResultSet r = p.executeQuery();
            if (r.first()) {
                message.setAction(false);
                message.setMessage("User Record Already Exists");
            } else {
                message.setAction(true);
            }
            r.close();
            p.close();
            if (message.isAction()) {
                // Insert User Register
                p = conn.prepareStatement(insert_user, PreparedStatement.RETURN_GENERATED_KEYS);
                p.setString(1, data.getUsername());
                p.setString(2, data.getPhone_no());
                p.setString(3, data.getPassword());
                p.executeUpdate();
                r = p.getGeneratedKeys();
                r.first();
                int userID = r.getInt(1);
                r.close();
                p.close();
                // CREATE USER ACCOUNT
                p = conn.prepareStatement(insert_user_account);
                p.setInt(1, userID);
                p.setString(2, data.getUsername());
                p.execute();
                p.close();
                conn.commit();
                conn.setAutoCommit(true);
                message.setAction(true);
                message.setMessage("User registered successfully");
                message.setData(new Model_User_Account(userID, data.getUsername(), "", "",true));
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            message.setMessage("Record already exists");
        } catch (SQLException e) {
            System.out.println(e);
            message.setAction(false);
            message.setMessage("Server Error!");
            try {
                if (conn.getAutoCommit() == false) {
                    conn.rollback();
                    conn.setAutoCommit(true);
                }
            } catch (SQLException e1) {
            }
        }
        return message;
    }
    
    public Model_User_Account login(Model_Login login) throws SQLException {
        Model_User_Account data = null;
        PreparedStatement p = conn.prepareStatement(LOGIN, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
        p.setString(1, login.getUsername());
        p.setString(2, login.getPassword());
        ResultSet r = p.executeQuery();
        if(r.first()) {
            int userID = r.getInt(1);
            String username = r.getString(2);
            String gender = r.getString(3);
            String image = r.getString(4);
            data = new Model_User_Account(userID, username, gender, image, true);
        }
        r.close();
        p.close();
        return data;
    }
    private boolean checkUserStatus(int userID) {
        List<Model_Client> clients = Service.getInstance(null).getListClient();
        for(Model_Client c : clients) {
            if(c.getUser().getUserID() == userID) {
                return true;
            }
        }
        return false;
    }
    public List<Model_User_Account> getUser(int exitUser) throws SQLException {
        List<Model_User_Account> list = new ArrayList<>();
        PreparedStatement p = conn.prepareStatement(SELECT_USER_ACCOUNT);
        p.setInt(1, exitUser);
        ResultSet r = p.executeQuery();
        while(r.next()) {
            int userID = r.getInt(1);
            String username = r.getString(2);
            String gender = r.getString(3);
            String image = r.getString(4);
            list.add(new Model_User_Account(userID, username, gender, image, checkUserStatus(userID)));
        }
        r.close();
        p.close();
        return list;
    }
}
