<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>ADMIN - GOODS VIEW</title>

<script src="/resources/jquery/jquery-3.3.1.min.js"></script>

<link rel="stylesheet" href="/resources/bootstrap/bootstrap.min.css">
<link rel="stylesheet"
  href="/resources/bootstrap/bootstrap-theme.min.css">
<script src="/resources/bootstrap/bootstrap.min.js"></script>

<link rel="stylesheet" href="/resources/css/admin/goods/view.css" />

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
        <h2>상품 조회</h2>

        <form role="form" method="post" autocomplete="off">

          <input type="hidden" name="n" value="${goods.gdsNum }" />

          <div class="inputArea">
            <label>1차 분류</label> <span class="category1"></span> <label>2차
              분류</label> <span class="category2">${goods.cateCode}</span>
          </div>

          <div class="inputArea">
            <label for="gdsName">상품명</label> <span>${goods.gdsName}</span>
          </div>

          <div class="inputArea">
            <label for="gdsPrice">상품가격</label> <span><fmt:formatNumber
                value="${goods.gdsPrice}" pattern="###,###,###" /></span>
          </div>

          <div class="inputArea">
            <label for="gdsStock">상품수량</label> <span>${goods.gdsStock}</span>
          </div>

          <div class="inputArea">
            <label for="gdsDes">상품소개</label>
            <div class="gdsDes">${ goods.gdsDes }</div>
          </div>

          <div class="inputArea">
            <label for="gdsImg">이미지</label>
            <p>원본 이미지</p>
            <img src="${goods.gdsImg }" class="oriImg" />

            <p>썸네일</p>
            <img src="${goods.gdsThumbImg }" class="thumbImg" />
          </div>

          <div class="inputArea">
            <button type="button" id="modify_Btn"
              class="btn btn-warning">수정</button>
            <button type="button" id="delete_Btn" class="btn btn-danger">삭제</button>

            <script>
                          var formObj = $("form[role='form']");

                          $("#modify_Btn").click(function() {
                            formObj.attr("action", "/admin/goods/modify");
                            formObj.attr("method", "get")
                            formObj.submit();

                          });

                          $("#delete_Btn").click(function() {

                            var con = confirm("정말로 삭제하시겠습니까?");

                            if (con) {
                              formObj.attr("action", "/admin/goods/delete");
                              formObj.submit();
                            }

                          });
                        </script>
          </div>

        </form>
      </div>
    </section>

    <footer id="footer">
      <div id="footer_box">
        <%@ include file="../include/footer.jsp"%>
      </div>
    </footer>
  </div>

  <script>
      // 컨트롤러에서 데이터 받기
      var jsonData = JSON.parse('${category}');
      console.log(jsonData);

      var cate1Arr = new Array();
      var cate1Obj = new Object();

      // 1차 분류 셀렉트 박스에 삽입할 데이터 준비
      for (var i = 0; i < jsonData.length; i++) {

        if (jsonData[i].level == "1") {
          cate1Obj = new Object(); //초기화
          cate1Obj.cateCode = jsonData[i].cateCode;
          cate1Obj.cateName = jsonData[i].cateName;
          cate1Arr.push(cate1Obj);
        }
      }

      // 1차 분류 셀렉트 박스에 데이터 삽입
      var cate1Select = $("select.category1")

      for (var i = 0; i < cate1Arr.length; i++) {
        cate1Select.append("<option value='" + cate1Arr[i].cateCode + "'>"
            + cate1Arr[i].cateName + "</option>");
      }

      $(document)
          .on(
              "change",
              "select.category1",
              function() {

                var cate2Arr = new Array();
                var cate2Obj = new Object();

                // 2차 분류 셀렉트 박스에 삽입할 데이터 준비
                for (var i = 0; i < jsonData.length; i++) {

                  if (jsonData[i].level == "2") {
                    cate2Obj = new Object(); //초기화
                    cate2Obj.cateCode = jsonData[i].cateCode;
                    cate2Obj.cateName = jsonData[i].cateName;
                    cate2Obj.cateCodeRef = jsonData[i].cateCodeRef;

                    cate2Arr.push(cate2Obj);
                  }
                }

                var cate2Select = $("select.category2");

                /*
                for(var i = 0; i < cate2Arr.length; i++) {
                  cate2Select.append("<option value='" + cate2Arr[i].cateCode + "'>"
                       + cate2Arr[i].cateName + "</option>");
                }
                 */

                cate2Select.children().remove();

                $("option:selected", this)
                    .each(
                        function() {

                          var selectVal = $(this).val();

                          cate2Select
                              .append("<option value='" + selectVal + "'>전체</option>");

                          for (var i = 0; i < cate2Arr.length; i++) {
                            if (selectVal == cate2Arr[i].cateCodeRef) {
                              cate2Select
                                  .append("<option value='" + cate2Arr[i].cateCode + "'>"
                                      + cate2Arr[i].cateName + "</option>");
                            }
                          }

                        });

              });
    </script>
</body>
</html>