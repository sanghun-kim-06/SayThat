package controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SayThatService;
import vo.SignUpVO;

public class SignUpController implements Controller{
	@Override
	public String excute(HttpServletRequest req, HttpServletResponse resp) {
		if(req.getMethod().equals("POST")) {
			SayThatService service = new SayThatService();
			SignUpVO vo = new SignUpVO();
			vo.setId(req.getParameter("id"));
			vo.setPassword(req.getParameter("password"));
			vo.setName(req.getParameter("name"));
			vo.setPhone(req.getParameter("phone"));
			System.out.println(req.getParameter("joindate"));
			vo.setJoindate(Date.valueOf(req.getParameter("joindate")));
			
			service.signUpInsert(vo);
			req.setAttribute("signUp_ok", "ok");
			
			return "index";
		}else {
			return "signUp";
		}
		
	}

}