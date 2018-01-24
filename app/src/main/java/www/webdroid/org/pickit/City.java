package www.webdroid.org.pickit;

import android.location.Address;

import java.util.ArrayList;

/**
 * Created by Blood_seeker on 1/24/2018.
 */

public class City {

    private String name ;
    private Address Location ;
    private ArrayList<Place> CityPlaces;

    public City ()
    {

    }
    public City(String name, Address location, ArrayList<Place> cityPlaces) {
        this.name = name;
        Location = location;
        CityPlaces = cityPlaces;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getLocation() {
        return Location;
    }

    public void setLocation(Address location) {
        Location = location;
    }

    public ArrayList<Place> getCityPlaces() {
        return CityPlaces;
    }

    public void setCityPlaces(ArrayList<Place> cityPlaces) {
        CityPlaces = cityPlaces;
    }
}
