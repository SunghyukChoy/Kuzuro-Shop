<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>ADMIN - GOODS LIST</title>

<script src="/resources/jquery/jquery-3.3.1.min.js"></script>

<link rel="stylesheet" href="/resources/bootstrap/bootstrap.min.css">
<link rel="stylesheet"
  href="/resources/bootstrap/bootstrap-theme.min.css">
<script src="/resources/bootstrap/bootstrap.min.js"></script>

<link rel="stylesheet" href="/resources/css/admin/goods/list.css" />

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
      <aside>
        <%@ include file="../include/aside.jsp"%>
      </aside>
      <div id="container_box">
        <!-- <h2>상품 목록</h2> -->
        <table>
          <thead>
            <tr>
              <th>번호</th>
              <th>이름</th>
              <th>카테고리</th>
              <th>가격</th>
              <th>수량</th>
              <th>등록날짜</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${ list }" var="list">
              <tr>
                <td><img src="${ list.gdsThumbImg }" /></td>
                <td><a href="/admin/goods/view?n=${ list.gdsNum }">${ list.gdsName }</a></td>
                <td>
                  <%-- ${ list.cateCode } --%> ${list.cateName }
                </td>
                <td><fmt:formatNumber value="${ list.gdsPrice }"
                    pattern="###,###,###">
                  </fmt:formatNumber></td>
                <td>${ list.gdsStock }</td>
                <td><fmt:formatDate value="${ list.gdsDate }"
                    pattern="yyyy-MM-dd"></fmt:formatDate></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
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