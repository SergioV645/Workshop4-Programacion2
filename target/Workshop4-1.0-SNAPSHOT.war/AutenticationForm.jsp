<%--
  Created by IntelliJ IDEA.
  User: Santi
  Date: 29/04/2021
  Time: 5:52 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
    <title>Autentication</title>
</head>
<body>
<div class="container">
    <br>
    <br>
    <div class="col align-self-center">
        <h3 class="text-center">Formulario de Autentificación jsp</h3>
        <div class="container">
            <form method="POST" action="Autentication">
                <div class="mb-3">
                    <label for="userInput" class="form-label">Usuario</label>
                    <input type="text" class="form-control" id="userInput" name="userInput" aria-describedby="emailHelp">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>