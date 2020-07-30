package com.spring.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.board.vo.BoardVo;

@Controller
public class BoardController {

	@RequestMapping("/")
	public String home() {

		return "home"; // home.jsp
		
	}

	@RequestMapping("/a")
	public String html() {
		return "redirect:/static/html/test01.html";
	}
	
	@RequestMapping("/b")
	public String html2() {
		return "redirect:/static/html/test02.html";
	}
	
	
	@RequestMapping("/ajax")
	public void ajax(String v, HttpServletResponse response)
	{
		String json = "{" + 
				"   \"id\" :\"한글\"," + 
				"   \"pass\" : \"1234\"," + 
				"   \"v\":\"" + v + "\"" + 
				"}";
		
		try {
			response.setContentType("application/json;charset = utf-8"); // 내가 너한테 보내는 것은 json이다 알겠냐? 
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// {"pass" : "blue" , "id" : "sky"}
	// @ResponseBody : java 객체 -> json 문자열 변경 
	
	@RequestMapping(value="/test1")
	@ResponseBody // 자바 객체를 json으로 바꿔 주는 것! 
	public Map<String, Object> test1(String id, String pass, String val)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pass", pass);
		map.put("email", val);
		return map;
	}
	
	@RequestMapping("/ajax2")
	@ResponseBody
	public Map<String, Object> test2() throws JsonProcessingException{
		Map<String, Object> map = new HashMap<String, Object>();
		// data 입력 
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		list.add(new BoardVo(1,"제목1","bada@naver.com"));
		list.add(new BoardVo(2,"제목2","bada@nate.com"));
		
		// Jackson Library 
		// java 객체 -> Json 
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonStr = mapper.writeValueAsString(list);
		System.out.println(jsonStr);
		
		
		return null;
		
	}
	
	
}
