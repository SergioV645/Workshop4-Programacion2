package com.example.Workshop4.bean;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ManageFile implements Serializable {

    private String userId;
    private String description;
    private String date;
    private String photo;
    private String[] usersId;
    private String[] descriptions;
    private String[] dates;
    private String[] photos;
    private String[] photosId;
    private int numberOfUsers;
    private String path;
    private final String sep= ";";

    public ManageFile(){
    }

    public String saveUserInfo(String path){
        try {
            this.path=path;
            File f= new File(path);
            FileWriter w= new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(w);
            if(f.createNewFile()){
                bw.write(getUserId()+sep+getDate()+sep+getDescription()+sep+getPhoto());
            }else{
                bw.write(getUserId()+sep+getDate()+sep+getDescription()+sep+getPhoto());
            }
            bw.newLine();
            bw.close();
            w.close();
            return  f.getAbsolutePath();
        }catch(IOException e){
            return "error"+e.getMessage();
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

    public void sedPhotosIds(){
        photosId= new String[photos.length];
        for (int i = 0; i < photos.length; i++) {
            photosId[i]= String.valueOf(i+1);
        }
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
}
