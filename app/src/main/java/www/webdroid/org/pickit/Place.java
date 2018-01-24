package www.webdroid.org.pickit;

import android.location.Address;

/**
 * Created by Blood_seeker on 1/24/2018.
 */

public class Place {
    private int Photograph ;
    private String name ;
    private String WorkingHours;
    private String PhoneNum;
    private int rate ;
    private String [] comments;
    private String Address ;
    private boolean DevelopersChoice;
    private Address locationAddress;

    public Place ()
    {

    }


    public Place(int photograph, String name, String workingHours, String phoneNum,
                 int rate, String[] comments, String address, boolean developersChoice,
                 android.location.Address locationAddress)
    {
        Photograph = photograph;
        this.name = name;
        WorkingHours = workingHours;
        PhoneNum = phoneNum;
        this.rate = rate;
        this.comments = comments;
        Address = address;
        DevelopersChoice = developersChoice;
        this.locationAddress = locationAddress;

    }

    public int getPhotograph() {
        return Photograph;
    }

    public void setPhotograph(int photograph) {
        Photograph = photograph;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkingHours() {
        return WorkingHours;
    }

    public void setWorkingHours(String workingHours) {
        WorkingHours = workingHours;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        PhoneNum = phoneNum;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public boolean isDevelopersChoice() {
        return DevelopersChoice;
    }

    public void setDevelopersChoice(boolean developersChoice) {
        DevelopersChoice = developersChoice;
    }

    public android.location.Address getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(android.location.Address locationAddress) {
        this.locationAddress = locationAddress;
    }
}
