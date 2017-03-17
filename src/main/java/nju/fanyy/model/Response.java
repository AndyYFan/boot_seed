package nju.fanyy.model;

/**
 * Created by fanyunyi on 2017/3/5.
 */
public class Response {
    private String responseMessage;

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Response(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
