<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Successful</title>
    <!-- Kutubxonalar -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h2>Registration Successful</h2>
    <p>Name: <%= request.getParameter("name") %></p>
    <p>Username: <%= request.getParameter("userName") %></p>
    <p>Password: <%= request.getParameter("password") %></p>
</div>
</body>
</html>