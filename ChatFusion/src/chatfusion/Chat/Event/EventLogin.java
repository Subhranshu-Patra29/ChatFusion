
package chatfusion.Chat.Event;

import chatfusion.Model.Model_Login;
import chatfusion.Model.Model_Register;

public interface EventLogin {
    public void login(Model_Login data);
    public void register(Model_Register data, EventMessage message);
    public void goToRegister();
    public void goBackToLogin();
}
