package ks45team03.rentravel.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServletResponse;
import ks45team03.rentravel.mapper.CommonNewCode;

public class CommonController implements CommonNewCode {

	@Override
	public String getCommonNewCode(String tableName, String columName) {
		return null;
	}
	
	//로그인이 필요한 페이지에 로그인안하고 접근시 경고창 띄워주는 메서드
	public static void alertPlzLogin(HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<script language='javascript'>");
		out.println("alert('로그인이 필요한 페이지입니다')");
		out.println("</script>");

		out.flush();
	}
	
	public static void alertRemoveAccount(HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<script language='javascript'>");
		out.println("alert('탈퇴한 회원입니다.')");
		out.println("</script>");

		out.flush();
	}
}
