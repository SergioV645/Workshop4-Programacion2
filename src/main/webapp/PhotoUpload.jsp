<%--
  Created by IntelliJ IDEA.
  User: Santi
  Date: 29/04/2021
  Time: 7:51 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
int photoId= 0;
%>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
    <title>Upload Photo</title>
</head>
<body>

<div class="container">
    <br>
    <p>Usuario identificado como: <% out.print(request.getCookies()[1].getValue()); %></p>
    <br>
    <br>
    <div class="container">
        <form id="form" class="" method="post" action="PhotoUpload" enctype="multipart/form-data">
            <div class="mb-3">
                <label for="photo" class="form-label">Escoga una foto: </label>
                <!--
                <input type="file" class="form-control" id="photo" name="photoForm" accept="image/x-png,image/jpeg" required multiple>
                -->
                <input type="file" class="form-control" id="photo" name="photoForm" accept="image/x-png,image/jpeg" required>
            </div>
            <div class="mb-3">
                <label for="description" class="form-label">Descripción: </label>
                <textarea id="description" name="description" class="form-control" form="form"></textarea>
                <%photoId=photoId+1;%>
                <input type="hidden" id="userId" name="userId" value="<%out.print(request.getCookies()[1].getValue());%>">
                <input type="hidden" id="photoId" name="photoId" value="<%out.print(request.getCookies()[2].getValue());%>">
                <input type="hidden" id="date" name="date" value="<%out.print(java.time.LocalDate.now());%>">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>
<script>
    function sendForm(){

    }
</script>
</body>
</html>
