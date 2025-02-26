package chatfusion.Chat.Event;

import chatfusion.Model.Model_Message;

public interface EventMessage {
    public void callMessage(Model_Message message);
}
