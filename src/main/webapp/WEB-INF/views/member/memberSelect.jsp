<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberSelect</title>
</head>
<body>
<h3 class="page_title">내 정보 조회</h3>
<div><span class="label">아이디</span>  	<span class="label">${member.id}</span></div>
<div><span class="label">비밀번호</span>	<span class="label">${member.pass}</span></div>
<div><span class="label">직업</span>	 	<span class="label">${member.job}</span></div>
<div><span class="label">가입동기</span>	<span class="label">${member.reason}</span></div>
<div><span class="label">성별</span>		<span class="label">${member.gender}</span></div>
<div><span class="label">수신여부</span>	<span class="label">${member.mailYN}</span></div>
<button type="button" id="btnPage">목록으로</button>
<script>
	btnPage.addEventListener("click",goPage);
	function goPage() {
		//이전페이지이동 4가지 다 같음
		//history.go(-1);	
		//history.back;
		//location.href="memberAll.jsp";
		location.assign("memberAll.jsp");
	}
</script>
</body>
</html>