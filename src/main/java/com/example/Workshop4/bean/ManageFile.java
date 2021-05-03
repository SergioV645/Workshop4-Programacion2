package com.example.Workshop4.bean;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageFile implements Serializable {

    @Expose
    private String userId;
    @Expose
    private String description;
    @Expose
    private String date;
    @Expose
    private String photo;
    @Expose
    private String photoId;
    private String[] usersId;
    private String[] descriptions;
    private String[] dates;
    private String[] photos;
    private String[] photosId;
    private int numberOfUsers;
    private final String sep= ";";

    public ManageFile(){
    }

    public ManageFile(String userId, String description, String date, String photo) {
        this.userId = userId;
        this.description = description;
        this.date = date;
        this.photo = photo;
    }

    public String saveUserInfo(String path){
        try {
            File f= new File(path);
            FileWriter w= new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(w);
            Gson gson= new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
            gson.toJson(this, bw);
            bw.newLine();
            bw.close();
            w.close();
            return  f.getAbsolutePath();
        }catch(IOException e){
            return "error"+e.getMessage();
        }
    }
    public boolean createFile(String path){
        try{
            File f= new File(path);
            f.createNewFile();
            return true;
        }catch (IOException e){
            return false;
        }
    }

    public String getJsonFile(File f){
        try{
            Scanner sc= new Scanner(f);
            String json="";
            while(sc.hasNextLine()){
                json= sc.nextLine();
            }
            return json;
        }catch (FileNotFoundException e){
            return "ERROR: "+e.getMessage();
        }
    }

    public String getExtension(String path){
        String extension = "";

        int i = path.lastIndexOf('.');
        int p = Math.max(path.lastIndexOf('/'), path.lastIndexOf('\\'));

        if (i > p) {
            extension = path.substring(i+1);
        }
        return "."+extension;
    }

    public boolean renameFile(File old, File ne){
        try{
            Path source= Paths.get(old.getAbsolutePath());
            Path target= Paths.get(ne.getAbsolutePath());
            Files.move(source, target);
            return true;
        }catch(IOException e){
            return false;
            //return e.getMessage();
        }
    }

    public String setPId(String path){
        try{
            File f=new File(path);
            ManageFile m= new Gson().fromJson(getJsonFile(f), ManageFile.class);
            return String.valueOf(Integer.parseInt(m.getPhotoId())+1);
        }catch(Exception e){
            if(createFile(path)){
                return "1";
            }else{
                return "ERROR";
                //return "ERROR: " + e.getMessage();
            }
        }
    }

    public String getFile(String path){
        try{
            File f=new File(path);
            Scanner myReader = new Scanner(f);
            ArrayList<String> u= new ArrayList<String>();
            ArrayList<String> de= new ArrayList<String>();
            ArrayList<String> da= new ArrayList<String>();
            ArrayList<String> p= new ArrayList<String>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] d= data.split(";");
                u.add(d[0]);
                da.add(d[1]);
                de.add(d[2]);
                p.add(d[3]);
                setUsersId(convertArray(u));
                setDates(convertArray(da));
                setDescriptions(convertArray(de));
                setPhotos(convertArray(p));
            }
            numberOfUsers= u.size();
            return path;
        }catch (FileNotFoundException e){
            return "ERROR: "+e.getMessage();
        }
    }

    public String[] convertArray(ArrayList<String> a){
        String[] c= new String[a.size()];
        for (int i = 0; i < a.size(); i++) {
            c[i]= a.get(i);
        }
        return c;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhotos(int i) {
        return photos[i];
    }

    public void setPhotos(String[] photos) {
        this.photos = photos;
    }

    public String[] getPhotosId() {
        return photosId;
    }

    public void setPhotosId(String[] photosId) {
        this.photosId = photosId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUsersId(int i) {
        return usersId[i];
    }

    public void setUsersId(String[] usersId) {
        this.usersId = usersId;
    }

    public String getDescriptions(int i) {
        return descriptions[i];
    }

    public void setDescriptions(String[] descriptions) {
        this.descriptions = descriptions;
    }

    public String getDates(int i) {
        return dates[i];
    }

    public void setDates(String[] dates) {
        this.dates = dates;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }
}
