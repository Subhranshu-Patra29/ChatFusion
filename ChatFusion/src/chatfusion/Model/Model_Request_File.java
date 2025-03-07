package chatfusion.Model;

import org.json.JSONException;
import org.json.JSONObject;

public class Model_Request_File {
    
    private int fileID;
    private long currentLength;

    public int getFileID() {
        return fileID;
    }

    public void setFileID(int fileID) {
        this.fileID = fileID;
    }

    public long getCurrentLength() {
        return currentLength;
    }

    public void setCurrentLength(long currentLength) {
        this.currentLength = currentLength;
    }

    public Model_Request_File() {
    }

    public Model_Request_File(int fileID, long currentLength) {
        this.fileID = fileID;
        this.currentLength = currentLength;
    }
    
    public JSONObject toJSONObject() {
        try {
            JSONObject json = new JSONObject();
            json.put("fileID", fileID);
            json.put("currentLength", currentLength);
            return json;
        } catch (JSONException e) {
            return null;
        }
    }
}
