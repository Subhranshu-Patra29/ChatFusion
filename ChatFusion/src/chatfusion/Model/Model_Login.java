package chatfusion.Model;

import org.json.JSONObject;

/**
 *
 * @author subha
 */
public class Model_Login {
    private String username;
    private String password;

    public Model_Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Model_Login() {
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

    public JSONObject toJSONObject() {
        try {
            JSONObject obj = new JSONObject();
            obj.put("username", username);
            obj.put("password", password);
            return obj;
        } catch (Exception e) {
            return null;
        }
    }
}
