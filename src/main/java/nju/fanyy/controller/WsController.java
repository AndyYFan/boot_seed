package nju.fanyy.controller;

import nju.fanyy.model.Message;
import nju.fanyy.model.Response;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by fanyunyi on 2017/3/5.
 */

@Controller
public class WsController {
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public Response say(Message message) throws Exception{
        Thread.sleep(3000);
        return new Response("welcome" + message.getName()+" !");
    }
}
