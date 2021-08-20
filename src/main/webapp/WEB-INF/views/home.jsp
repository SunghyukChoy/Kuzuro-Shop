<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>

<link rel="stylesheet" href="/resources/css/home.css" />

</head>
<body>
  <div id="root">
    <header id="header">
      <div id="header_box">
        <%@ include file="include/header.jsp"%>
      </div>
    </header>

    <nav id="nav">
      <div id="nav_box">
        <%@ include file="include/nav.jsp"%>
      </div>
    </nav>

    <section id="container">
      <div id="container_box">
        <section id="content">본문 영역</section>

        <aside id="aside">
          <%@ include file="include/aside.jsp"%>
        </aside>
      </div>
    </section>

    <footer id="footer">
      <div id="footer_box">
        <%@ include file="include/footer.jsp"%>
      </div>
    </footer>
  </div>
</body>
</html>
