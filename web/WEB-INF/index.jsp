<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title> Home </title>
</head>
<body>
<div class="container">
    <div class="card ">
        <div class="card-body text-center">
            <h1> Welcome to Salon  </h1>
            <button class="btn btn-primary p-2 mr-5 mt-3"> <a style="color: white" href="${pageContext.request.contextPath}/login"> Login </a> </button>
            <button class="btn btn-danger p-2 ml-5 mt-3"> <a style="color: white" href="${pageContext.request.contextPath}/register"> Register </a> </button>
        </div>
    </div>
</div>

</body>
</html>
