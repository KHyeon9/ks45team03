package ks45team03.rentravel.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
	
	@GetMapping("/chatRoomList")
	public String reviewList(Model model) {
		model.addAttribute("title","채팅방 목록 화면");
		return "user/chat/chatRoomList";
	}
}
