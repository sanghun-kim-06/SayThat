package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SayThatService;
import vo.RecordingVO;

public class PostListController implements Controller {

	@Override
	public String excute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		SayThatService service = new SayThatService();
		ArrayList<RecordingVO> list = service.postlist();
		req.setAttribute("list", list);
		return "postlist";
	}

}
