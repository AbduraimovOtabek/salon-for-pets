<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<html>
<head>
    <title>bid</title>
</head>
<body>
<div class="container">
    <div class="card">
        <div class="card-body">
            <h1 style="color: darkmagenta  ;margin-left: 350px">use the services</h1>

            <form action="<%=request.getContextPath()%>/bid" method="post">

                <div class="form-group row">
                    <label for="pet" class="col-sm-2 col-form-label">Pet</label>
                    <div class="col-sm-7">
                        <input type="text"
                               class="form-control"
                               id="pet"
                               name="pet"
                               placeholder="Enter pet">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="petName" class="col-sm-2 col-form-label">Pet Name</label>
                    <div class="col-sm-7">
                        <input type="text"
                               class="form-control"
                               id="petName"
                               name="petName"
                               placeholder="Enter pet name">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="petService" class="col-sm-2 col-form-label">Pet service</label>
                    <div class="col-sm-7">
                        <input type="text"
                               class="form-control"
                               id="petService"
                               name="petService"
                               placeholder="Enter petService">
                    </div>
                </div>
                <br>

                <button type="submit" class="btn btn-primary">Save</button>
                <%--                <button class="btn"><a href="${pageContext.request.contextPath}/payment">payment</a></button>--%>

            </form>
            <div>
                <div>
                    <br>
                    <a class="btn btn-primary"
                       href="${pageContext.request.contextPath}/cabinet" role="button">Cabinet</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
