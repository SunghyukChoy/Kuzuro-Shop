<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h3>카테고리</h3>

<ul>
	<li><a href="/shop/list?c=100&l=1">무기</a> <!-- /shop/list : 기본 경로 -->
		<!-- ?c=[번호1]&l=[번호2] : 구분자 --> <!--[번호1] : cateCode와 같은 숫자. [번호2] : 카테고리의 레벨. 숫자가 클수록 하위 카테고리 -->
		<ul class="low">
			<li><a href="/shop/list?c=101&l=2">돌격소총</a></li>
			<li><a href="/shop/list?c=102&l=2">기관단총</a></li>
			<li><a href="/shop/list?c=103&l=2">경기관총</a></li>
			<li><a href="/shop/list?c=104&l=2">산탄총</a></li>
			<li><a href="/shop/list?c=105&l=2">지정사수소총</a></li>
			<li><a href="/shop/list?c=106&l=2">저격소총총</a></li>
			<li><a href="/shop/list?c=107&l=2">기타</a></li>
		</ul></li>

	<li><a href="/shop/list?c=200&l=1">탄약</a></li>
	<li><a href="/shop/list?c=300&l=1">방어구</a></li>
	<li><a href="/shop/list?c=400&l=1">회복제</a></li>
</ul>