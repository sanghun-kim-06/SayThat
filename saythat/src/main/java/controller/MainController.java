package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController implements Controller {
	@Override
	public String excute(HttpServletRequest req, HttpServletResponse resp) {
		return "index";
	}
}