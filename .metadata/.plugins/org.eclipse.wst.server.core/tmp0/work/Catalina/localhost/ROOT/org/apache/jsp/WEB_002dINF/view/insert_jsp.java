/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.43
 * Generated at: 2024-04-14 08:11:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class insert_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Say That</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h2>Say That</h2>\r\n");
      out.write("<p>하지 못한 말을 해야한다! Say That 녹음 사이트입니다. <br></p>\r\n");
      out.write("<button id=\"recordBtn\">녹음 시작</button>\r\n");
      out.write("<br><br>\r\n");
      out.write("<audio controls>녹음된 소리를 재생할 audio 엘리먼트</audio>\r\n");
      out.write("<div id=\"sound-clips\"></div>\r\n");
      out.write("  <script>\r\n");
      out.write("//엘리먼트 취득\r\n");
      out.write("  const $audioEl = document.querySelector(\"audio\");\r\n");
      out.write("  const $recordBtn = document.querySelector(\"#recordBtn\");\r\n");
      out.write("\r\n");
      out.write("  // 녹음중 상태 변수\r\n");
      out.write("  let isRecording = false;\r\n");
      out.write("\r\n");
      out.write("  // MediaRecorder 변수 생성\r\n");
      out.write("  let mediaRecorder = null;\r\n");
      out.write("\r\n");
      out.write("  // 녹음 데이터 저장 배열\r\n");
      out.write("  let audioArray = [];\r\n");
      out.write("\r\n");
      out.write("  $recordBtn.onclick = async function () {\r\n");
      out.write("      if (!isRecording) {\r\n");
      out.write("          // 녹음 시작\r\n");
      out.write("          if (!mediaRecorder) {\r\n");
      out.write("              // 최초 녹음 시작\r\n");
      out.write("              const mediaStream = await navigator.mediaDevices.getUserMedia({audio: true});\r\n");
      out.write("              mediaRecorder = new MediaRecorder(mediaStream);\r\n");
      out.write("\r\n");
      out.write("              mediaRecorder.ondataavailable = (event) => {\r\n");
      out.write("                  audioArray.push(event.data);\r\n");
      out.write("              };\r\n");
      out.write("\r\n");
      out.write("              mediaRecorder.onstop = () => {\r\n");
      out.write("                  // 녹음 중지 시 녹음 데이터를 하나의 오디오 파일로 합침\r\n");
      out.write("                  const blob = new Blob(audioArray, {\"type\": \"audio/ogg codecs=opus\"});\r\n");
      out.write("                  const blobURL = window.URL.createObjectURL(blob);\r\n");
      out.write("                  $audioEl.src = blobURL;\r\n");
      out.write("              };\r\n");
      out.write("          }\r\n");
      out.write("          \r\n");
      out.write("          mediaRecorder.start();\r\n");
      out.write("          isRecording = true;\r\n");
      out.write("          $recordBtn.textContent = \"녹음 중지\";\r\n");
      out.write("      } else {\r\n");
      out.write("          // 녹음 중지\r\n");
      out.write("          mediaRecorder.stop();\r\n");
      out.write("          isRecording = false;\r\n");
      out.write("          $recordBtn.textContent = \"녹음 시작\";\r\n");
      out.write("      }\r\n");
      out.write("  };\r\n");
      out.write("\r\n");
      out.write("  // 녹음 초기화 버튼 추가\r\n");
      out.write("  const $resetBtn = document.createElement(\"button\");\r\n");
      out.write("  $resetBtn.textContent = \"녹음 초기화\";\r\n");
      out.write("  document.body.appendChild($resetBtn);\r\n");
      out.write("\r\n");
      out.write("  $resetBtn.onclick = function() {\r\n");
      out.write("      // 녹음 초기화\r\n");
      out.write("      if (mediaRecorder && !isRecording) {\r\n");
      out.write("          audioArray = []; // 녹음 데이터 배열을 초기화\r\n");
      out.write("          $audioEl.src = \"\"; // 오디오 소스를 초기화\r\n");
      out.write("          mediaRecorder = null; // MediaRecorder 인스턴스를 초기화\r\n");
      out.write("          $recordBtn.textContent = \"녹음 시작\";\r\n");
      out.write("      }\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}