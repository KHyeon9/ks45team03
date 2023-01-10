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
import ks45team03.rentravel.dto.Pagination;
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
    	String loginId = loginUser.getLoginId();
    	List<ChatMessage> chatMessageList = chatService.getChatMessageList(chatRoomCode);
    	ChatRoom chatRoomInfo = chatMapper.getChatRoomCode(chatRoomCode);
    	
    	
    	model.addAttribute("title","chat");
    	model.addAttribute("loginUser",loginUser);
    	model.addAttribute("chatMessageList",chatMessageList);
    	model.addAttribute("chatRoomInfo",chatRoomInfo);

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
	public String room(Model model,HttpSession session, @RequestParam(defaultValue="1", required=false) int curPage) {
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		String loginId = loginUser.getLoginId();
		
		int chatRoomListCount = chatService.getChatRoomListCount(loginId);
		Pagination pagination = new Pagination(chatRoomListCount, curPage);
		
		int startIndex = pagination.getStartIndex();
		int pageSize = pagination.getPageSize();
		
		List<ChatRoom> chatRoomList = chatService.getChatRoomList(loginId,startIndex,pageSize);
		
		model.addAttribute("title", "채팅방 목록");
		
		model.addAttribute("loginUser",loginUser);
		model.addAttribute("chatRoomList",chatRoomList);
		model.addAttribute("pagination",pagination);
		
		return "user/chat/room";
	}
	
	@GetMapping("/addChatRoom")
	public String addChatRoom(@RequestParam(value="userId") String userId,ChatRoom chatRoom,HttpSession session) {
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		String loginId = loginUser.getLoginId();
		
		String chatRoomCode = commonNewCode.getCommonNewCode("tb_chat_room", "chat_room_code");
		
		chatRoom.setChatRoomCode(chatRoomCode);
		chatRoom.setRenterId(loginId);
		chatRoom.setOwnerId(userId);
		
		ChatRoom checkChatRoom = chatService.checkChatRoom(chatRoom);
		
		
		String redirectNewChatRoom = "";
		
		if(checkChatRoom != null) {
			String checkChatRoomCode = checkChatRoom.getChatRoomCode();
			
			redirectNewChatRoom = "redirect:/chat?chatRoomCode="+checkChatRoomCode;
		}else {
			chatService.addChatRoom(chatRoom);
			
			redirectNewChatRoom = "redirect:/chat?chatRoomCode="+chatRoomCode;
		}
		
		return redirectNewChatRoom;
	}
	
	@PostMapping("/removeChatRoom")
	public String removeChatRoom(String chatRoomCode, int curPage) {
		
		chatService.removeChatMessage(chatRoomCode);
		chatService.removeChatRoom(chatRoomCode);
		
		String redirectRoomCurPage = "redirect:/room?curPage="+curPage;
		
		return redirectRoomCurPage;
	}

}