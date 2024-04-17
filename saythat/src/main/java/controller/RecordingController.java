package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import service.SayThatService;
import vo.RecordingVO;


public class RecordingController implements Controller{
	@Override
	public String excute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if(req.getMethod().equals("POST")) {
			System.out.println("포스트 요청이 왔어요,");
			// 요청이 multipart/form-data 인지 확인
	        if(ServletFileUpload.isMultipartContent(req)){
	        	SayThatService service = new SayThatService();
	        	RecordingVO vo = service.recordingUpload(req, resp);
	        	vo.setUserid(req.getParameter("userid"));
	        	vo.setTitle(req.getParameter("title"));
	        	Date now = new Date();
	        	java.sql.Date sqlDate = new java.sql.Date(now.getTime());
	        	vo.setUploadDate(sqlDate);
	        	
	        	
	        	service.recordingQueryInsert(vo);
	        	
	        } else {
	            req.setAttribute("message", "요청이 multipart/form-data가 아닙니다.");
	        }
			
			req.setAttribute("message", "업로드 성공?");
		}
		
		return "recording";
	}


}
