package Model;

/**
 *
 * @author subha
 */
public class Model_User_Account {
    private int userID;
    private String username;
    private String gender;
    private String image;
    private boolean status;

    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public Model_User_Account(int userID, String username, String gender, String image, boolean status) {
        this.userID = userID;
        this.username = username;
        this.gender = gender;
        this.image = image;
        this.status = status;
    }

    public Model_User_Account() {
    }
    
}
