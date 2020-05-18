<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>SIGN IN</title>
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
					<form role="form" method="post" autocomplete="off">					
						<div class="input_area">
							<label for="userId">아이디</label>
							<input type="email" id="userId" name="userId" placeholder="example@email.com" required="required" />
														
						</div>

						<div class="input_area">
							<label for="userPass">패스워드</label>
							<input type="password" id="userPass" name="userPass" required="required" />
						</div>						

						<button type="submit" id="signin_btn" name="signin_btn">로그인</button>
						
						<c:if test="${ msg == false }">
							<p style="color:#f00;">아이디가 존재하지 않습니다.</p>
						</c:if>
						
						<c:if test="${ msgPass == false }">
							<p style="color:#f00;">패스워드가 일치하지 않습니다.</p>
						</c:if>

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
