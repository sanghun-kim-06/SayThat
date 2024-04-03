package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SayThatDao;
import vo.SignInVO;
import vo.SignUpVO;

public class SayThatService {
	SayThatDao dao = new SayThatDao();
	
	public String userIdCheck(HttpServletRequest req, HttpServletResponse resp) {
		String result = dao.userIdCheck(req, resp);
		return result;
	}

	public void signUpInsert(SignUpVO vo) {
		dao.signUpInsert(vo);
		
	}

	public String signIn(HttpServletRequest req, HttpServletResponse resp) {
		SignInVO vo = dao.signIn(req, resp);
		if(vo != null) {
			//로그인 인증 성공
			HttpSession session = req.getSession();
			session.setAttribute("user", vo);
			return "index";
		}else {
			//로그인 인증 실패
			req.setAttribute("loginError", "아이디 또는 비밀번호가 잘못되었습니다.");
			return "signIn";
		}
	}

}
