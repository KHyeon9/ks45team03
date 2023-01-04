package ks45team03.rentravel.user.controller;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import ks45team03.rentravel.dto.ChatMessage;
import ks45team03.rentravel.dto.ChatRoom;
import ks45team03.rentravel.dto.LoginInfo;
import ks45team03.rentravel.mapper.ChatMapper;
import ks45team03.rentravel.mapper.CommonNewCode;
import ks45team03.rentravel.user.service.ChatService;


@Controller
public class ChatController {
	
	private final ChatService chatService;
	private final ChatMapper chatMapper;
	private final CommonNewCode commonNewCode;
	
	public ChatController(ChatService chatService, ChatMapper chatMapper, CommonNewCode commonNewCode) {
		this.chatService = chatService;
		this.chatMapper = chatMapper;
		this.commonNewCode = commonNewCode;
	}
	
    @GetMapping("/chat")
    public String chat(Model model, @RequestParam(value="chatRoomCode") String chatRoomCode,HttpSession session){
    	
    	LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
    	List<ChatMessage> chatMessageList = chatService.getChatMessageList(chatRoomCode);
    	ChatRoom getChatRoomCode = chatMapper.getChatRoomCode(chatRoomCode);
    	
    	model.addAttribute("title","chat");
    	model.addAttribute("loginUser",loginUser);
    	model.addAttribute("chatMessageList",chatMessageList);
    	model.addAttribute("getChatRoomCode",getChatRoomCode);

    	return "user/chat/chat";
    }
    
	@ResponseBody
	@PostMapping("/addChatMessage")
	public void addChatMessage(@RequestBody ChatMessage chatMessage) {
		
		String chatMessageCode = commonNewCode.getCommonNewCode("tb_chat_message", "chat_message_code");
		chatMessage.setChatMessageCode(chatMessageCode);
		chatService.addChatMessage(chatMessage);
		
	}
	
	/**
	 * 방 페이지
	 * @return
	 */
	@GetMapping("/room")
	public String room(Model model,HttpSession session) {
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		String loginId = loginUser.getLoginId();
		List<ChatRoom> chatRoomList = chatService.getChatRoomList(loginId);
		
		model.addAttribute("title", "room");
		
		
		model.addAttribute("chatRoomList",chatRoomList);
		
		return "user/chat/room";
	}
	
	@PostMapping("/addChatRoom")
	public String addChatRoom(@RequestParam(value="userId") String userId,@RequestBody ChatRoom chatRoom,HttpSession session) {
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		String loginId = loginUser.getLoginId();
		
		String chatRoomCode = commonNewCode.getCommonNewCode("tb_chat_room", "chat_room_code");
		
		chatRoom.setChatRoomCode(chatRoomCode);
		chatRoom.setRenterId(loginId);
		chatRoom.setOwnerId(userId);
		
		chatService.addChatRoom(chatRoom);
		
		return "redirect:/room";
	}

	

	

}