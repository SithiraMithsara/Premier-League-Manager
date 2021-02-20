package lk.oop.coursework;

import java.io.Serializable;

public class Date implements Serializable {

    private int year;
    private int month;
    private int day;

    //Constructors
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    //Getters & Setters
    public int getYear() {
        return year;

    }

    public void setYear(int year) {
        this.year = year;

    }

    public int getMonth() {
        return month;

    }

    public void setMonth(int month) {
        this.month = month;

    }

    public int getDay() {
        return day;

    }

    public void setDay(int day) {
        this.day = day;

    }

    @Override
    public String toString() {
        return year + "/" + month + "/" + day;
    }
}
