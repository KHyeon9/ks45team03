package ks45team03.rentravel.user.controller;


import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ks45team03.rentravel.dto.Room;
import ks45team03.rentravel.dto.RoomInfo;


@Controller
public class ChatController {
    
    @GetMapping("/chatRoomList")
    public String chatList(){

        return "user/chat/chatRoomList";
    }
    
    @GetMapping("/inChat")
    public String inChat(){

        return "user/chat/inChat";
    }
    
	List<Room> roomList = new ArrayList<Room>();
	static int roomNumber = 0;
	
    @GetMapping("/chat")
    public String chat(Model model){
    	
    	model.addAttribute("title","chat");

        return "user/chat/chat";
    }
	/**
	 * 방 페이지
	 * @return
	 */
	@GetMapping("/room")
	public String room(Model model) {
		
		model.addAttribute("title", "room");
		
		return "user/chat/room";
	}
	
	/**
	 * 방 생성하기
	 * @param params
	 * @return
	 */
	@PostMapping("/createRoom")
	public @ResponseBody List<Room> createRoom(@RequestParam HashMap<Object, Object> params){
		String roomName = (String) params.get("roomName");
		if(roomName != null && !roomName.trim().equals("")) {
			Room room = new Room();
			room.setRoomNumber(++roomNumber);
			room.setRoomName(roomName);
			roomList.add(room);
		}
		return roomList;
	}
	
	/**
	 * 방 정보가져오기
	 * @param params
	 * @return
	 */
	@PostMapping("/getRoom")
	public @ResponseBody List<Room> getRoom(@RequestParam HashMap<Object, Object> params){
		return roomList;
	}
	
	/**
	 * 채팅방
	 * @return
	 */
	/*
	@GetMapping("/moveChating")
	public ModelAndView chating(@RequestParam HashMap<Object, Object> params) {
		ModelAndView mv = new ModelAndView();
		int roomNumber = Integer.parseInt((String) params.get("roomNumber"));
		
		List<Room> new_list = roomList.stream().filter(o->o.getRoomNumber()==roomNumber).collect(Collectors.toList());
		if(new_list != null && new_list.size() > 0) {
			mv.addObject("roomName", params.get("roomName"));
			mv.addObject("roomNumber", params.get("roomNumber"));
			mv.setViewName("chat");
		}else {
			mv.setViewName("room");
		}
		return mv;
	}
	*/
	
	@GetMapping("/moveChating")
	public String chating(@RequestParam HashMap<Object, Object> params, Model model) {
		
		int roomNumber = Integer.parseInt((String) params.get("roomNumber"));
		
		List<Room> new_list = roomList.stream()
									  .filter(o->o.getRoomNumber()==roomNumber)
									  .collect(Collectors.toList());
		
		
		if(new_list != null && new_list.size() > 0) {
			model.addAttribute("roomName", params.get("roomName"));
			model.addAttribute("roomNumber", params.get("roomNumber"));
			model.addAttribute("title","chat");
		}else {
			model.addAttribute("title","room");
		}
		return "user/chat/chat";
	}
}