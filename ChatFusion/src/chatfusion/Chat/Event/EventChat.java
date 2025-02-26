package chatfusion.Chat.Event;

import chatfusion.Model.Model_Receive_Message;
import chatfusion.Model.Model_Send_Message;

public interface EventChat {

    public void sendMessage(Model_Send_Message data);

    public void receiveMessage(Model_Receive_Message data);
}
