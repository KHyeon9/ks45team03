package ks45team03.rentravel.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/chat")
public class ChatController {
    
    @GetMapping("/chatRoomList")
    public String chatList(){

        return "user/chat/chatRoomList";
    }
    
    @GetMapping("/inChat")
    public String inChat(){

        return "user/chat/inChat";
    }
}