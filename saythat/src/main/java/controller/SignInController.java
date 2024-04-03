package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SayThatService;

public class SignInController implements Controller{
	@Override
	public String excute(HttpServletRequest req, HttpServletResponse resp) {
		if(req.getMethod().equals("POST")) {
			SayThatService service = new SayThatService();
			return service.signIn(req, resp);
		}else {
			return "signIn";
		}
	}

}
