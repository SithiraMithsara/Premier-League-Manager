package lk.oop.coursework;

public class FootballClub extends SportsClub {

    private int no_Of_Wins;
    private int no_Of_Defeats;
    private int no_Of_Draws;
    private int played_Matches = no_Of_Wins + no_Of_Defeats + no_Of_Draws;
    private int total_Points = (no_Of_Wins * 4) + no_Of_Draws;
    private int scored_Goals;
    private int received_Goals;
    private int goalDifference = scored_Goals - received_Goals;

    //Constructors
    public FootballClub() {
    }

    public FootballClub(String club_Name, String location, int no_Of_Wins, int no_Of_Defeats, int no_Of_Draws, int scored_Goals, int received_Goals) {
        super(club_Name, location);
        this.no_Of_Wins = no_Of_Wins;
        this.no_Of_Defeats = no_Of_Defeats;
        this.no_Of_Draws = no_Of_Draws;
        this.scored_Goals = scored_Goals;
        this.received_Goals = received_Goals;
    }

    //getters & setters
    public void setNo_Of_Wins(int no_Of_Wins) {
        this.no_Of_Wins = no_Of_Wins;

    }

    public int getno_Of_Wins() {
        return no_Of_Wins;

    }

    public void setNo_Of_Defeats(int no_Of_Defeats) {
        this.no_Of_Defeats = no_Of_Defeats;

    }

    public int getNo_Of_Defeats() {
        return no_Of_Defeats;

    }

    public void setNo_Of_Draws(int no_Of_Draws) {
        this.no_Of_Draws = no_Of_Draws;

    }

    public int getNo_Of_Draws() {
        return no_Of_Draws;

    }

    public void setplayed_Matches(int played_Matches) {
        this.played_Matches = played_Matches;

    }

    public int getplayed_Matches() {
        return (no_Of_Wins + no_Of_Defeats + no_Of_Draws);

    }

    public void settotal_Points(int total_Points) {
        this.total_Points = total_Points;

    }

    public int gettotal_Points() {
        return (no_Of_Wins * 4) + no_Of_Draws;

    }

    public void setScored_Goals(int scored_Goals) {
        this.scored_Goals = scored_Goals;

    }

    public int getScored_Goals() {
        return scored_Goals;

    }

    public void setReceived_Goals(int received_Goals) {
        this.received_Goals = received_Goals;

    }

    public int getReceived_Goals() {
        return received_Goals;

    }

    public void setGoalDifference(int goalDifference) {
        this.goalDifference = goalDifference;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    @Override
    public String toString() {
        return "Wins = " + no_Of_Wins + ", Defeats = " + no_Of_Defeats + ", Draws = " +
                no_Of_Draws + ", Played matches = " + played_Matches + ", Total Points = " + total_Points +
                "Goals Scored = " + scored_Goals + ", Goals Received = " + received_Goals;

    }
}
