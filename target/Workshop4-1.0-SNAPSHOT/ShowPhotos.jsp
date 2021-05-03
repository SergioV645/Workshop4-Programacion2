<%@ page import="com.example.Workshop4.bean.ManageFile" %><%--
  Created by IntelliJ IDEA.
  User: Santi
  Date: 30/04/2021
  Time: 5:18 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
    <title>Show Photos</title>
</head>
<body>
<jsp:useBean id = "user" class = "com.example.Workshop4.bean.ManageFile" />
    <% user.getFile("user.txt"); %>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">User Id</th>
            <th scope="col">Description</th>
            <th scope="col">Date</th>
            <th scope="col">Photo</th>
            <th scope="col">Photo Id</th>
        </tr>
        </thead>
        <tbody>
        <% for (int i=0; i<user.getNumberOfUsers(); i++){ %>
        <tr>
            <th scope="row"><% out.print(user.getUsersId(i));%></th>
            <td><% out.print(user.getDescriptions(i));%></td>
            <td><% out.print(user.getDates(i));%></td>
            <td><% out.print(user.getPhotos(i));%></td>
            <td><% out.print("ids?");%></td>
        </tr>
        <%}%>
        </tbody>
    </table>


</body>
</html>
