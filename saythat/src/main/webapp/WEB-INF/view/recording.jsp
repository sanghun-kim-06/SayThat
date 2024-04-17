<%@page import="vo.SignInVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
SignInVO vo = null;
if(session.getAttribute("user") == null){
	%>
	<script>
		<% System.out.println("잘못된 곳으로 왔습니다.");%>
		alert("로그인 후 다시 사용해주세요.");
		location.href="/";
	</script>
	<%
}else {
	vo = (SignInVO)session.getAttribute("user");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Say That</title>
</head>
<body>
<h2>Say That</h2>
<p>하지 못한 말을 해야한다! Say That 녹음 사이트입니다. <br></p>
<button id="recordBtn">녹음 시작</button> <button id="resetBtn">녹음초기화</button>
<br><br>
<audio controls>녹음된 소리를 재생할 audio 엘리먼트</audio>
<div id="sound-clips"></div>
<script>
  //엘리먼트 취득
  const $audioEl = document.querySelector("audio");
  const $recordBtn = document.querySelector("#recordBtn");
  const $soundClips = document.querySelector("#sound-clips");

  // 녹음중 상태 변수
  let isRecording = false;

  // MediaRecorder 변수 생성
  let mediaRecorder = null;

  // 녹음 데이터 저장 배열
  let audioArray = [];

  $recordBtn.onclick = async function () {
      if (!isRecording) {
          // 녹음 시작
          if (!mediaRecorder) {
              // 최초 녹음 시작
              const mediaStream = await navigator.mediaDevices.getUserMedia({audio: true});
              mediaRecorder = new MediaRecorder(mediaStream);

              mediaRecorder.ondataavailable = (event) => {
                  audioArray.push(event.data);
              };

              mediaRecorder.onstop = () => {
                  // 녹음 중지 시 녹음 데이터를 하나의 오디오 파일로 합침
                  const blob = new Blob(audioArray, {"type": "audio/ogg codecs=opus"});
                  const blobURL = window.URL.createObjectURL(blob);
                  $audioEl.src = blobURL;

                  // 녹음완료 버튼 생성
                  const endButton = document.createElement('button');
                  endButton.textContent = '녹음완료';
                  endButton.onclick = function() {
                      // uploadAudio(blob);
                      
                		// 기존에 입력 요소가 이미 추가되어 있다면 제거
                	    const existingInputs = document.querySelectorAll('.additional-input');
                	    existingInputs.forEach(input => {
                	        input.remove();
                	    });

                	    // 게시글 제목 입력 요소 생성 및 추가
                	    const titleInput = document.createElement('input');
                	    titleInput.setAttribute('type', 'text');
                	    titleInput.setAttribute('placeholder', '게시글 제목을 입력하세요');
                	    titleInput.classList.add('additional-input');
                	    $soundClips.appendChild(titleInput);

                	    // 사진 파일1 입력 요소 생성 및 추가
                	    const photoInput1 = document.createElement('input');
                	    photoInput1.setAttribute('type', 'file');
                	    photoInput1.setAttribute('accept', 'image/jpeg');
                	    photoInput1.classList.add('additional-input');
                	    $soundClips.appendChild(photoInput1);

                	    // 사진 파일2 입력 요소 생성 및 추가
                	    const photoInput2 = document.createElement('input');
                	    photoInput2.setAttribute('type', 'file');
                	    photoInput2.setAttribute('accept', 'image/jpeg');
                	    photoInput2.classList.add('additional-input');
                	    $soundClips.appendChild(photoInput2);
                	    
                	    const uploadButton = document.createElement('button');
                	    uploadButton.textContent = '등록하기';
                	    uploadButton.onclick = function() {
                            uploadAudio(blob);
                        };
                        $soundClips.appendChild(uploadButton);
                  };
                  $soundClips.appendChild(endButton);
              };
          }
          
          mediaRecorder.start();
          isRecording = true;
          $recordBtn.textContent = "녹음 중지";
      } else {
          // 녹음 중지
          mediaRecorder.stop();
          isRecording = false;
          $recordBtn.textContent = "녹음 시작";
      }
  };

  // 녹음 초기화 버튼 추가
  const $resetBtn = document.querySelector("#resetBtn");

  $resetBtn.onclick = function() {
      // 녹음 초기화
      if (mediaRecorder && !isRecording) {
          audioArray = []; // 녹음 데이터 배열을 초기화
          $audioEl.src = ""; // 오디오 소스를 초기화
          mediaRecorder = null; // MediaRecorder 인스턴스를 초기화
          $recordBtn.textContent = "녹음 시작";
          // 기존에 생성된 녹음완료 버튼이 있다면 제거
          const endButton = $soundClips.querySelector('button');
          if (endButton) {
              $soundClips.removeChild(endButton);
          }
      }
  }

  // 녹음 데이터를 서버로 업로드하는 함수
  function uploadAudio(blob) {
      const formData = new FormData();
      formData.append('audioFile', blob, 'recording.ogg');
      formData.append('userid', '<%=vo.getId() %>');
      
   	  // 게시글 제목 및 사진 파일 데이터 추가
      const titleInput = document.querySelector('input[type="text"].additional-input');
      const photoInputs = document.querySelectorAll('input[type="file"].additional-input');

      // 게시글 제목을 formData에 추가
      if (titleInput) {
          formData.append('title', titleInput.value);
      }

      var photoIndex = 1;
      console.log(photoIndex);
      // 사진 파일을 formData에 추가 (여러 파일을 가정)
      photoInputs.forEach((input, index) => {
          if (input.files[0]) { // 파일이 선택되었는지 확인
        	  console.log(index, `photo${index + 1}`, input.files[0]);
          	  var pname = 'photo' + (index + 1);
              formData.append(pname, input.files[0]);
              photoIndex = photoIndex + 1;
          }
      });
      photoIndex = 0;
      
      fetch('/recording', {
    	    method: 'POST',
    	    body: formData,
    	}).then(response => {
    	    if (response.ok) {
    	        console.log('Upload success');
    	        window.location.replace = '/postlist';
    	    } else {
    	        console.error('Upload failed');
    	    }
    	}).catch(error => {
    	    console.error('Error:', error);
    	});

  }
</script>



</body>
</html>