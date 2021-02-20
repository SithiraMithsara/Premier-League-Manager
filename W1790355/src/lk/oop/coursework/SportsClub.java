package lk.oop.coursework;

import java.io.Serializable;

public abstract class SportsClub implements Serializable {

    private String club_Name;
    private String location;

    //Constructors
    public SportsClub() {
    }

    public SportsClub(String club_Name, String location) {
        this.club_Name = club_Name;
        this.location = location;

    }

    //getters & setters
    public void setClub_Name(String club_Name) {
        this.club_Name = club_Name;

    }

    public String getClub_Name() {
        return club_Name;

    }

    public void setLocation(String location) {
        this.location = location;

    }

    public String getLocation() {
        return location;

    }

    @Override
    public String toString() {
        return "Sports Club Name = " + club_Name + ", Location = " + location;

    }

}
