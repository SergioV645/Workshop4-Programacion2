package com.example.Workshop4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Autentication", value = "/Autentication")
public class Autentication extends HttpServlet {

    int photoID=0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("AutenticationForm.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie c = new Cookie("UserId", request.getParameter("userInput"));
        response.addCookie(c);
        photoID=photoID+1;
        Cookie c2= new Cookie("photoId", String.valueOf(photoID));
        response.addCookie(c2);
        response.sendRedirect("PhotoUpload.jsp");
    }
}
