package lk.oop.coursework;

import java.io.Serializable;

public class MatchInfo implements Serializable {

    String homeTeam;
    String awayTeam;
    int homeTeamGoals;
    int awayTeamGoals;
    Date date;

    //Constructors
    public MatchInfo(String homeTeam, String awayTeam, int homeTeamGoals, int awayTeamGoals, Date date) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamGoals = homeTeamGoals;
        this.awayTeamGoals = awayTeamGoals;
        this.date = date;
    }

    //Getters & Setters
    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    public int getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public void setAwayTeamGoals(int awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Home Team = " + homeTeam + ", Away Team= " + awayTeam + ", Home Team Goals= " + homeTeamGoals +
                ", Away Team Goals= " + awayTeamGoals + ", Date = " + date;
    }
}
