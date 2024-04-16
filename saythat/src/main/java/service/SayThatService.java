package service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import common.DBUtils;
import dao.SayThatDao;
import vo.RecordingVO;
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
	
	public RecordingVO recordingUpload(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RecordingVO vo = new RecordingVO();
		try {
			//녹음 파일을 폴더에 저장하고, ID를 생성해서 vo에 저장.
			Part filePart = req.getPart("audioFile");
			String uniqueID = UUID.randomUUID().toString();
			String fileName = "file_" + uniqueID + ".ogg";
			String basePath = "D:\\saythatrecrding\\";
			String photobasePath = "D:\\saythatphoto\\";
			
			
			File fileSaveDir = new File(basePath);
			if(!fileSaveDir.exists()) {
				fileSaveDir.mkdir();
			}
			
			filePart.write(basePath + fileName);
			vo.setVoice(fileName);
			
			//녹음 파일을 폴더에 저장하고, ID를 생성해서 vo에 저장.
			Part photo1filePart = req.getPart("photo1");
			System.out.println("들어오는 값 1 : " + photo1filePart);
			if(photo1filePart != null) {
		
				String p1uniqueID = UUID.randomUUID().toString();
				String p1fileName = "file_" + p1uniqueID + ".jpg";
				photo1filePart.write(photobasePath + p1fileName);
				
				vo.setPhoto1(p1fileName);
	
			}
			
			Part photo2filePart = req.getPart("photo2");
			
			if(photo2filePart != null) {
		
				String p2uniqueID = UUID.randomUUID().toString();
				String p2fileName = "file_" + p2uniqueID + ".jpg";
				photo2filePart.write(photobasePath + p2fileName);
				
				vo.setPhoto2(p2fileName);

			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	public void recordingQueryInsert(RecordingVO vo) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int n =0;
		try {
			conn = DBUtils.getConnection();
			String sql = " INSERT INTO CONTENTS VALUES(contentsidplus.NEXTVAL, ?, ?, ?, ?, ?, ?, null) ";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUserid());
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getVoice());
			System.out.println("입력한 사진1 : "+ vo.getPhoto1());
			psmt.setString(4, vo.getPhoto1());
			System.out.println("입력한 사진2 : "+ vo.getPhoto2());

			psmt.setString(5, vo.getPhoto2());
			psmt.setDate(6, vo.getUploadDate());
			n = psmt.executeUpdate();
			if(n > 0) {
				return;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, psmt, rs);
		}
		
	}

}
