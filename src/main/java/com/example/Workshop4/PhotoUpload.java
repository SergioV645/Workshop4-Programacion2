package com.example.Workshop4;


import com.example.Workshop4.bean.ManageFile;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PhotoUpload", value = "/PhotoUpload")
@MultipartConfig
public class PhotoUpload extends HttpServlet {

    private ManageFile user;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ManageFile m= new ManageFile();
        m.setUserId(request.getParameter("userId"));
        m.setDate(request.getParameter("date"));
        m.setDescription(request.getParameter("description"));
        request.getParts();
        m.setPhoto(request.getPart("photoForm").getSubmittedFileName());
        m.saveUserInfo("user.txt");
        //String json= new Gson().toJson(m);
        //response.getWriter().println(m.saveUserInfo("user.txt"));
        response.sendRedirect("ShowPhotos.jsp");






        //response.getWriter().println(getServletContext().getRealPath(""));

        /*
        ArrayList<String> photosNames=new ArrayList<String>();
        for (Part part : request.getParts()) {
            if(part.getName().equals("photoForm")){
                photosNames.add(part.getSubmittedFileName());
            }
        }

        String[] auxP= new String[photosNames.size()];
        for (int i=0; i< auxP.length; i++) {
            auxP[i]= photosNames.get(i);
        }

        user= new ManageFile(request.getParameter("userId"), request.getParameter("description"), request.getParameter("date"), auxP);
        user.sedPhotosIds();


        request.setAttribute("userId", request.getParameter("userId"));
        request.setAttribute("description", request.getParameter("description"));
        request.setAttribute("date", request.getParameter("date"));
        int i=0;
        for (Part part : request.getParts()) {
            String attr= "photo"+String.valueOf(i);
            try{
                if(!part.getSubmittedFileName().equals(null)){
                    request.setAttribute(attr, part.getSubmittedFileName());
                    i=i+1;
                }
            }catch (Exception e){

            }
        }
        request.setAttribute("numberPhotos", i);
        */
        /*
        request.setAttribute("userId", user.userId);
        request.setAttribute("description", user.description);
        request.setAttribute("date", user.date);
        request.setAttribute("photosNames", user.photos);
        request.setAttribute("photosIds", user.photosId);
         */

        //request.getRequestDispatcher("ShowPhotos.jsp").forward(request, response);

        /*


        String uploadPath = getServletContext().getRealPath("") + File.separator + "fotos";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();
        ArrayList<String> absolutePath=new ArrayList<String>();

        for (Part part : request.getParts()) {
            String fileName = part.getSubmittedFileName();
            part.write(uploadPath + File.separator + fileName);
            absolutePath.add(uploadPath + File.separator + fileName);
        }
        for (String path: absolutePath) {
            try {
                //ImageIcon imgIcon = new ImageIcon(getBytes(path));
                //response.getWriter().println(imgIcon.getImage());
                response.getWriter().println("<img src=\""+path+"\" alt=\"nocargo\">");
            }catch (Exception e){
                response.getWriter().println(e.getMessage());
            }
        }
         */
    }

    private byte[] getBytes(String file){
        try{
            FileInputStream fis = new FileInputStream(file);
            byte[] byteArray = new byte[(int) file.length()];

            // Add the bytes from the file to the array
            for(int j = 0; j < byteArray.length; j++){
                byteArray[j] = (byte)fis.read();
                // Just to show the bytes are in the array.
                System.out.println(byteArray[j]);
            }
            return byteArray;
        }catch(IOException e){
            return null;
        }
    }
}
