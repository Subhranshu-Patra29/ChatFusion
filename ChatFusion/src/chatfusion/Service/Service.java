package chatfusion.Service;

import chatfusion.Chat.Event.EventFileReceiver;
import chatfusion.Chat.Event.PublicEvent;
import chatfusion.Model.Model_File_Receiver;
import chatfusion.Model.Model_File_Sender;
import chatfusion.Model.Model_Receive_Message;
import chatfusion.Model.Model_Send_Message;
import chatfusion.Model.Model_User_Account;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Service {

    private static Service instance;
    private Socket client;
    private final int PORT_NUMBER = 9999;
    private final String IP = "localhost";
    private Model_User_Account user;
    private List<Model_File_Sender> fileSender;
    private List<Model_File_Receiver> fileReceiver;

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }

    private Service() {
        fileSender = new ArrayList<>();
        fileReceiver = new ArrayList<>();
    }

    public void startServer() {
        try {
            client = IO.socket("http://" + IP + ":" + PORT_NUMBER);
            client.on("list_user", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    //LIST USERS
                    List<Model_User_Account> users = new ArrayList<>();
                    for (Object o : os) {
                        Model_User_Account u = new Model_User_Account(o);
                        if (u.getUserID() != user.getUserID()) {
                            users.add(u);
                        }
                    }
                    PublicEvent.getInstance().getEventMenuLeft().newUser(users);
                }
            });
            client.on("user_status", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    int userID = (Integer) os[0];
                    boolean status = (Boolean) os[1];
                    if (status) {
                        //connect
                        PublicEvent.getInstance().getEventMenuLeft().userConnect(userID);
                    } else {
                        //disconnect
                        PublicEvent.getInstance().getEventMenuLeft().userDisconnect(userID);
                    }
                }
            });
            client.on("receive_ms", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    Model_Receive_Message message = new Model_Receive_Message(os[0]);
                    PublicEvent.getInstance().getEventChat().receiveMessage(message);
                }
            });
            client.open();
        } catch (URISyntaxException ex) {
            error(ex);
        }
    }

    private void error(Exception e) {
        System.out.println(e);
    }

    public static void setInstance(Service instance) {
        Service.instance = instance;
    }

    public void setClient(Socket client) {
        this.client = client;
    }

    public Socket getClient() {
        return client;
    }

    public int getPORT_NUMBER() {
        return PORT_NUMBER;
    }

    public String getIP() {
        return IP;
    }

    public Model_User_Account getUser() {
        return user;
    }

    public void setUser(Model_User_Account user) {
        this.user = user;
    }

    public Model_File_Sender addFile(File file, Model_Send_Message message) throws IOException {
        Model_File_Sender data = new Model_File_Sender(file, client, message);
        message.setFile(data);
        fileSender.add(data);
        if (fileSender.size() == 1) {
            data.initSend();
        }
        return data;
    }

    public void fileSendFinish(Model_File_Sender data) throws IOException {
        fileSender.remove(data);
        if (!fileSender.isEmpty()) {
            fileSender.get(0).initSend();
        }
    }
    
    public void fileReceiveFinish(Model_File_Receiver data) throws IOException {
        fileReceiver.remove(data);
        if(!fileReceiver.isEmpty()) {
            fileReceiver.get(0).initReceive();
        }
    }
    
    public void addFileReceiver(int fileID, EventFileReceiver event) throws IOException {
        Model_File_Receiver data = new Model_File_Receiver(fileID, client, event);
        fileReceiver.add(data);
        if(fileReceiver.size() == 1) {
            data.initReceive();
        }
    }
}
