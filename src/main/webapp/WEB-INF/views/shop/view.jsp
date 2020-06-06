<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>SHOP - VIEW</title>

<script src="/resources/jquery/jquery-3.3.1.min.js"></script>

<script>
							
							function replyList() {	// 함수로 묶음.	head 태그 내부로 옮김.						
							
								var gdsNum = ${view.gdsNum};
								/* $.getJSON : 비동기식으로 제이슨 데이터를 가져오는 메서드 */
								$.getJSON("/shop/view/replyList" + "?n=" + gdsNum, function(data){
									var str = "";
									
									$(data).each(function(){
										console.log(data);
										
										var regDate = new Date(this.regDate);
										regDate = regDate.toLocaleDateString("ko-US")
										
										str += "<li data-repNum='" + this.repNum + "'>"	// "<li data-gdsNum='" + this.gdsNum + "'>"
											 + "<div class='userInfo'>"
											 + "<span class='userName'>" + this.userName + "</span>"
											 + "<span class='date'>" + regDate + "</span>"
											 + "</div>"
											 + "<div class='replyContent'>" + this.repCon + "</div>"
											 
											 + "<c:if test='${member != null}'>"	
											 // member 세션에 값이 있다면(로그인 상태라면) 출력하고 비로그인이라면 버튼들을 출력하지 않는 조건문
											 
											 + "<div class='replyFooter'>"
											 + "<button type='button' class='modify' data-repNum='" + this.repNum + "'>M</button>"
											 + "<button type='button' class='delete' data-repNum='" + this.repNum + "'>D</button>"
											 + "</div>"
											 
											 + "</c:if>"
											 
											 + "</li>"
									});
									
									$("section.replyList ol").html(str);
								});		
								// http:///shop/view/replyList" + "?n=" + gdsNum 주소로 컨트롤러에 접속하여 데이터를 가져오고,
								// 그 데이터를 이용해 HTML코드를 조립하여 <ol> 태그에 추가하는 방식
							}
							</script>

<style>
body {
	margin: 0;
	padding: 0;
	font-family: '맑은 고딕', verdana;
}

a {
	color: #05f;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}

h1, h2, h3, h4, h5, h6 {
	margin: 0;
	padding: 0;
}

ul, lo, li {
	margin: 0;
	padding: 0;
	list-style: none;
}

/* ----------------------------- */
div#root {
	width: 900px;
	margin: 0 auto;
}

header#header {
	
}

nav#nav {
	
}

section#container {
	
}

section#content {
	float: right;
	width: 700px;
}

aside#aside {
	float: left;
	width: 180px;
}

section#container::after {
	content: "";
	display: block;
	clear: both;
}

footer#footer {
	background: #eee;
	padding: 20px;
}

/* ----------------------------- */
header#header div#header_box {
	text-align: center;
	padding: 30px 0;
}

header#header div#header_box h1 {
	font-size: 50px;
}

header#header div#header_box h1 a {
	color: #000;
}

nav#nav div#nav_box {
	font-size: 14px;
	padding: 10px;
	text-align: right;
}

nav#nav div#nav_box li {
	display: inline-block;
	margin: 0 10px;
}

nav#nav div#nav_box li a {
	color: #333;
}

section#container {
	
}

aside#aside h3 {
	font-size: 22px;
	margin-bottom: 20px;
	text-align: center;
}

aside#aside li {
	font-size: 16px;
	text-align: center;
}

aside#aside li a {
	color: #000;
	display: block;
	padding: 10px 0;
}

aside#aside li a:hover {
	text-decoration: none;
	background: #eee;
}

aside#aside li {
	position: relative;
}

aside#aside li:hover {
	background: #eee;
}

aside#aside li>ul.low {
	display: none;
	position: absolute;
	top: 0;
	left: 180px;
}

aside#aside li:hover>ul.low {
	display: block;
}

aside#aside li:hover>ul.low li a {
	background: #eee;
	border: 1px solid #eee;
}

aside#aside li:hover>ul.low li a:hover {
	background: #fff;
}

aside#aside li>ul.low li {
	width: 180px;
}

footer#footer {
	margin-top: 100px;
	border-radius: 50px 50px 0 0;
}

footer#footer div#footer_box {
	padding: 0 20px;
}
</style>
<style>
div.goods div.goodsImg {
	float: left;
	width: 350px;
}

div.goods div.goodsImg img {
	width: 350px;
	height: auto;
}

div.goods div.goodsInfo {
	float: right;
	width: 330px;
	font-size: 22px;
}

div.goods div.goodsInfo p {
	margin: 0 0 20px 0;
}

div.goods div.goodsInfo p span {
	display: inline-block;
	width: 100px;
	margin-right: 15px;
}

div.goods div.goodsInfo p.cartStock input {
	font-size: 22px;
	width: 50px;
	padding: 5px;
	margin: 0;
	border: 1px solid #eee;
}

div.goods div.goodsInfo p.cartStock button {
	font-size: 26px;
	border: none;
	background: none;
}

div.goods div.goodsInfo p.addToCart {
	text-align: right;
}

div.goods div.gdsDes {
	font-size: 18px;
	clear: both;
	padding-top: 30px;
}
</style>
<style>
section.replyForm {
	padding: 30px 0;
}

section.replyForm div.input_area {
	margin: 10px 0;
}

section.replyForm textarea {
	font-size: 16px;
	font-family: '맑은 고딕', verdana;
	padding: 10px;
	width: 500px;;
	height: 150px;
}

section.replyForm button {
	font-size: 20px;
	padding: 5px 10px;
	margin: 10px 0;
	background: #fff;
	border: 1px solid #ccc;
}

section.replyList {
	padding: 30px 0;
}

section.replyList ol {
	padding: 0;
	margin: 0;
}

section.replyList ol li {
	padding: 10px 0;
	border-bottom: 2px solid #eee;
}

section.replyList div.userInfo {
	
}

section.replyList div.userInfo .userName {
	font-size: 24px;
	font-weight: bold;
}

section.replyList div.userInfo .date {
	color: #999;
	display: inline-block;
	margin-left: 10px;
}

section.replyList div.replyContent {
	padding: 10px;
	margin: 20px 0;
}

section.replyList div.replyFooter button {
	font-size: 14px;
	border: 1px solid #999;
	background: none;
	margin-right: 10px;
}
</style>
<style>
div.replyModal {
	position: relative;
	z-index: 1;	/* 모달을 화면 제일 위로 나오게 함. z축 : 1 */
	display: none;	/* view 페이지에서 모달을 표시 안 함. */
}

div.modalBackground {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0.8);
	z-index: -1;
}

div.modalContent {
	position: fixed;
	top: 20%;
	left: calc(50% - 250px);
	width: 500px;
	height: 250px;
	padding: 20px 10px;
	background: #fff;
	border: 2px solid #666;
}

div.modalContent textarea {
	font-size: 16px;
	font-family: '맑은 고딕', verdana;
	padding: 10px;
	width: 500px;
	height: 200px;
}

div.modalContent button {
	font-size: 20px;
	padding: 5px 10px;
	margin: 10px 0;
	background: #fff;
	border: 1px solid #ccc;
}

div.modalContent button.modal_cancel {
	margin-left: 20px;
}
</style>
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

					<form role="form" method="post">
						<input type="hidden" name="gdsNum" value="${view.gdsNum }" />
					</form>

					<div class="goods">
						<div class="goodsImg">
							<img src="${view.gdsImg }" />
						</div>

						<div class="goodsInfo">
							<p class="gdsName">
								<span>상품명</span>${view.gdsName}</p>
							<p class="cateCode">
								<span>카테고리</span>${view.cateName}</p>
							<p class="gdsPrice">
								<span>가격</span>
								<fmt:formatNumber pattern="###,###,###"
									value="${view.gdsPrice }" />
								원
							</p>
							<p class="gdsStock">
								<span>재고</span>
								<fmt:formatNumber pattern="###,###,###"
									value="${view.gdsStock }" />
								EA
							</p>
							<p class="cartStock">
								<span>구입 수량</span>
								<button type="button" class="plus">+</button>
								<input type="number" class="numBox" min="1"
									max="${view.gdsStock }" value="1" readonly="readonly" />
								<button type="button" class="minus">-</button>

								<script>
									$(".plus").click(function(){
										var num = $(".numBox").val();
										var plusNum = Number(num) + 1;
										
										if(plusNum >= ${view.gdsStock}){
											$(".numBox").val(num);
										} else {
											$(".numBox").val(plusNum);
										}
									});
									
									$(".minus").click(function(){
										var num = $(".numBox").val();
										var minusNum = Number(num) - 1;
										
										if(minusNum <= 0) {
											$(".numBox").val(num);											
										} else {
											$(".numBox").val(minusNum);
										}
									});
								</script>
							</p>
							<p class="addToCart">
								<button type="button">카트에 담기</button>
							</p>
						</div>

						<div class="gdsDes">${view.gdsDes }</div>
					</div>

					<div id="reply">

						<c:if test="${member == null }">
							<p>
								소감을 남기시려면 <a href="/member/signin">로그인</a>해주세요
							</p>
						</c:if>

						<c:if test="${member != null}">
							<section class="replyForm">
								<form role="form" method="POST" autocomplete="off">

									<input type="hidden" name="gdsNum" id="gdsNum"
										value="${ view.gdsNum }">
									<!-- 상품 번호를 컨트롤러에 전달 -->
									<div class="inputArea">
										<textarea name="repCon" id="repCon"></textarea>
									</div>

									<div class="inputArea">
										<button type="button" id="reply_btn">소감 남기기</button>

										<script>
											$("#reply_btn").click(function(){
												var formObj = $(".replyForm form[role='form']");
												var gdsNum = $("#gdsNum").val();
												var repCon = $("#repCon").val();
												
												var data = {
														gdsNum : gdsNum,	// 키 : 값
														repCon : repCon
												};
												
												$.ajax({
													url : "/shop/view/registReply",	// 데이터가 전송될 주소
													type : "post",	// 타입
													data : data,	// 전송될 데이터
													success : function(){	// 데이터 전송 성공 시 실행할 함수
														replyList();	// 소감 작성 완료 시 소감 목록 다시 출력
														$("#repCon").val(""); // 소감 작성 후 textArea에 남는 소감 지우기
													}
												});
											});
										</script>
									</div>
								</form>
							</section>
						</c:if>

						<section class="replyList">
							<ol>
								<%-- <c:forEach items="${reply }" var="reply">
									<li>
										<div class="userInfo">
											<span class="userName">${reply.userName }</span> <span
												class="date"><fmt:formatDate
													value="${reply.repDate }" pattern="yyyy-MM-dd" /></span>
										</div>
										<div class="replyContent">${ reply.repCon }</div>
									</li>
								</c:forEach> --%>
							</ol>
							<script>
								replyList();
							</script>

							<script>
								
								$(document).on("click", ".modify", function(){	// 수정(M) 버튼 클릭 시 
									// $(".replyModal").attr("style", "display:block");	// 모달 보임
									$(".replyModal").fadeIn(200);	// 제이쿼리에 내장된 페이드 기능
									
									var repNum = $(this).attr("data-repNum");
									var repCon = $(this).parent().parent().children(".replyContent").text();
									
									$(".modal_repCon").val(repCon);
									$(".modal_modify_btn").attr("data-repNum", repNum);
								})
							
								$(document).on("click", ".delete", function(){
									
									var deleteConfirm = confirm("정말로 삭제하시겠습니까?");
									
									if(deleteConfirm) {
										
										var data = { repNum : $(this).attr("data-repNum")};
										
										$.ajax({
											url : "/shop/view/deleteReply",
											type : "post",
											data : data,
											success : function(result){
												if(result == 1) {	// 컨트롤러에서 받아온 값.
													replyList();	// 삭제 후 목록을 다시 불러옴
												} else {	// 받오온 값이 0이면 알림창 출력
													alert("작성자 본인만 삭제할 수 있습니다.")
												}
											},
											
											error : function(){	// 비로그인 시 모든 세션이 null이므로 에러 발생
												alert("로그인 하셔야합니다.")
											}
										});
									}
								});								
							</script>
						</section>

					</div>
				</section>

				<aside id="aside">
					<%@ include file="../include/aside.jsp"%>
				</aside>
			</div>
		</section>

		<footer id="footer">
			<div id="footer_box">
				<%@ include file="../include/footer.jsp"%>
			</div>
		</footer>
	</div>

	<div class="replyModal">

		<div class="modalContent">

			<div>
				<textarea class="modal_repCon" name="reply_repCon"></textarea>
			</div>

			<div>
				<button type="button" class="modal_modify_btn">수정</button>
				<button type="button" class="modal_cancel">취소</button>
			</div>

		</div>

		<div class="modalBackground"></div>

	</div>
	
	<script>
		$(".modal_cancel").click(function(){	// 모달에서 취소 버튼 클릭 시 모달 표시 안 함
			// $(".replyModal").attr("style", "display:none");
			$(".replyModal").fadeOut(200);
		});
	</script>
		
	<script>
		$(".modal_modify_btn").click(function(){
			var modifyConfirm = confirm("정말로 수정하시겠습니까?");
			
			if(modifyConfirm) {
				var data = {
						repNum : $(this).attr("data-repNum"),
						repCon : $(".modal_repCon").val()
				};	// ReplyVO 형태로 데이터 생성
				
				$.ajax({
					url : "/shop/view/modifyReply",
					type : "post",
					data : data,
					success : function(result) {
						
						// result의 값에 따라 동작
						if(result == 1) {
							replyList();	// 리스트 새로고침
							$(".replyModal").fadeOut(200);
						} else {
							alert("작성자 본인만 수정할 수 있습니다.")	// 본인이 아닌 경우
						}
					},
					
					error : function(){
						// 로그인 하지 않아서 에러가 발생한 경우
						alert("로그인 하셔야합니다.")
					}
				});
			}
		});		
	</script>
</body>
</html>
