<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <%--    <link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet">--%>
</head>
<body>
<div class="container">
    <h1 style="color: darkmagenta  ;margin-left: 350px" >Online Test Platform</h1>
    <div class="card">
        <div class="card-body">
            <form action="<%=request.getContextPath()%>/register" method="post">

                <div class="form-group row">
                    <label for="name" class="col-sm-2 col-form-label">Name</label>
                    <div class="col-sm-7">
                        <input type="text"
                               class="form-control"
                               id="name"
                               name="name"
                               placeholder="Enter name">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="userName" class="col-sm-2 col-form-label">User Name</label>
                    <div class="col-sm-7">
                        <input type="email"
                               class="form-control"
                               id="userName"
                               name="userName"
                               placeholder="Enter user name">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="password" class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-7">
                        <input
                                id="password"
                                type="password" class="form-control" name="password"
                                placeholder="Enter Password">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="password" class="col-sm-2 col-form-label">Pre Password</label>
                    <div class="col-sm-7">
                        <input
                                id="prePassword"
                                type="password" class="form-control" name="prePassword"
                                placeholder="Enter Password">
                    </div>
                </div>


                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>