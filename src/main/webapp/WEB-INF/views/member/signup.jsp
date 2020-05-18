<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>SIGN UP</title>
</head>
<body>
	<div id="root">
		<header id="header">
			<div id="header_box">
				<%@ include file="../include/header.jsp"%>
			</div>
		</header>

		<nav id="nav">
			<div id="nav_box">
				<%@ include file="../include/nav.jsp"%>
			</div>
		</nav>

		<section id="container">
			<div id="container_box">
			
				<section id="content">
					<%-- RequestMethod 방식이 Post인 메서드로 양식을 제출. 
						form태그에 action 속성이 생략된 경우 자신의 url을 갖는 (/member/signup => MemberController.getSignup method) 매핑명으로 제출.--%>
					<form role="form" method="post" action="/member/signup" autocomplete="off">
						<div class="input_area">
							<label for="userId">아이디</label>
							<input type="email" id="userId" name="userId" placeholder="example@email.com" required="required" value="" />
							<%-- name 속성의 이름과 MemberVO의 필드명과 같아야 함. value 속성은 사용자가 입력한 값. 생략 가능. --%>
						</div>

						<div class="input_area">
							<label for="userPass">패스워드</label>
							<input type="password" id="userPass" name="userPass" required="required" value="" />
						</div>

						<div class="input_area">
							<label for="userName">닉네임</label>
							<input type="text" id="userName" name="userName" placeholder="닉네임을 입력해주세요" required="required" />
						</div>

						<div class="input_area">
							<label for="userPhon">연락처</label>
							<input type="text" id="userPhon" name="userPhon" placeholder="연락처를 입력해주세요" required="required" />
						</div>

						<button type="submit" id="signup_btn" name="signup_btn">회원가입</button>

					</form>
				</section>
		
			</div>
		</section>

		<footer id="footer">
			<div id="footer_box">
				<%@ include file="../include/footer.jsp"%>
			</div>
		</footer>
	</div>
</body>
</html>
