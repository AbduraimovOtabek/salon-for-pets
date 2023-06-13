<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Cabinet</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2 style="margin-right: 0px">Welcome to your dashboard</h2>

    <h4>Hi, <c:out value="${requestScope.get('currentUser').name}"/>
    </h4>
    <br>
    <br>
    <h4>
        <c:if test="${requestScope.get('currentUser').role == 'ADMIN'}">
            <a class="btn" href="${pageContext.request.contextPath}/list-users" role="button">Salon For Pets users</a>
        </c:if>

        <c:if test="${requestScope.get('currentUser').role == 'USER'}">
            <h4 style="color: darkolivegreen">See your assignment below </h4>
        </c:if>

    <h3>Name: <c:out value="${requestScope.get('currentUser').name}"/></h3>

<%--    <c:if test="${requestScope.get('currentUser').role == 'ADMIN'}">--%>
<%--        <br>--%>
<%--        <button class="btn"><a href="${pageContext.request.contextPath}/list-users">List of users</a></button>--%>
<%--        <button class="btn"><a href="${pageContext.request.contextPath}/list-bid">List of bids</a></button>--%>
<%--    </c:if>--%>

    <button class="btn"><a href="${pageContext.request.contextPath}/bid">Bid</a></button>
        <br>
        <br>
        <a class="btn" href="index.jsp" role="button">Log Out</a>

    </h4>
</div>


</body>
</html>