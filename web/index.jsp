<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>salon-for-pets</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body>
<div class="container">
    <h1 style="color: #0626ee  ;margin-left: 265px" >Welcome to Salon for pets</h1>

    <div class="card">
        <div class="card-body">
            <form action="<%=request.getContextPath()%>/" method="get">

                <a class="btn btn-outline-success btn-lg btn-block" href="${pageContext.request.contextPath}/register" role="button">Register</a>
                <a class="btn btn-outline-primary btn-lg btn-block" href="${pageContext.request.contextPath}/login" role="button">Login</a>


            </form>
        </div>
    </div>
</div>
</body>
</html>