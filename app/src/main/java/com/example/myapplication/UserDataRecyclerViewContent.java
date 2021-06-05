package com.example.myapplication;

public class UserDataRecyclerViewContent {
   private String dataTitle;
   private String userData;
   private int image;

    public UserDataRecyclerViewContent(String dataTitle1 , String userData1){

        dataTitle = dataTitle1;
        userData = userData1;
    }

    public UserDataRecyclerViewContent(int Image, String Title){
        image = Image;
        dataTitle = Title;
    }

    public String getDataTitle(){return dataTitle; }

    public String getUserData(){return userData;}

    public int getImage(){ return image;}

    public void setImage(int image){this.image = image;}

    public void setDataTitle(String dataTitle2){ this.dataTitle = dataTitle2;}

    public void setUserData(String userData2){this.userData = userData2;}
}
