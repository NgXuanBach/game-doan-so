<%@ page import="java.util.Random" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<body>
<%!
    int number = 1;
%>
<div style="text-align: center;">
    <h1 style="color:black">
        Game đoán số
    </h1>
    <h3>
        (Đoán số ngẫu nhiên trong khoảng [1-1000])
    </h3>
    <h2>${msg}</h2>
    <% String contextPath = request.getContextPath();%>
    <form action="<%=contextPath%>/index" method="post">
        <input type="number" name="number"/>
        <button type="submit" class="btn btn-primary">Đoán</button>
    </form>
</div>
<b style="font-size: 20px">Xếp hạng người chơi</b>
<table style="width:50%;border-collapse: collapse" ; border="1px solid">
    <tr>
        <td style="border: 1px solid;column-span:1">Xếp hạng</td>
        <td style="border: 1px solid;width:300px">Tên</td>
        <td style="border: 1px solid;width:100px">Số lần đoán</td>
        <td style="border: 1px solid;width:300px">Thời gian</td>
    </tr>
    <c:if test="${players!=null}">
        <% number = 1;%>
        <c:forEach var="temp" items="${players}">
            <tr>
                <td style="border: 1px solid;column-span:1"><%=number%>
                </td>
                <td style="border: 1px solid;width:300px">Player <%=number%>
                </td>
                <td style="border: 1px solid;width:100px">${temp.clickCount}</td>
                <td style="border: 1px solid;width:300px">${temp.getTimeDone()}</td>
            </tr>
            <%
                number++;
            %>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
<%--
    <%! %> : thẻ dùng để khai báo biến
    <% %> : thẻ dùng để xử lý logic code, thẻ đa năng
    <%= %>: thẻ xuất ra màn hình
 --%>