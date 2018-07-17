package Model;

import android.net.Uri;

public class UserModel {
    public static String userName;
    public static String mail;
    public static int phoneNumber;
    public static Uri photo;

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        UserModel.userName = userName;
    }

    public static String getMail() {
        return mail;
    }

    public static void setMail(String mail) {
        UserModel.mail = mail;
    }

    public static int getPhoneNumber() {
        return phoneNumber;
    }

    public static void setPhoneNumber(int phoneNumber) {
        UserModel.phoneNumber = phoneNumber;
    }

    public static Uri getPhoto() {
        return photo;
    }

    public static void setPhoto(Uri photo) {
        UserModel.photo = photo;
    }
}
