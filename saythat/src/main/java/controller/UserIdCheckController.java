package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SayThatService;

public class UserIdCheckController implements Controller{
	@Override
	public String excute(HttpServletRequest req, HttpServletResponse resp) {
		SayThatService service = new SayThatService();
		String result = service.userIdCheck(req, resp);
		return result;
	}

}
