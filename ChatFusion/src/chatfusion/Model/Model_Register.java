
package chatfusion.Model;

import org.json.JSONException;
import org.json.JSONObject;


public class Model_Register {
    private String username;
    private String phone_no;
    private String password;

    public Model_Register() {
    }
    
    public Model_Register(String username, String password, String phone_no) {
        this.username = username;
        this.password = password;
        this.phone_no = phone_no;
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
    
    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }
    
    public JSONObject toJSONObject() {
        try {
            JSONObject json = new JSONObject();
            json.put("username", username);
            json.put("phone_no", phone_no);
            json.put("password", password);
            return json;
        } catch (JSONException e) {
            return null;
        }
    }
}
