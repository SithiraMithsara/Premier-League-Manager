package lk.oop.coursework;

public class UniversityFootballClub extends FootballClub {

    private String university_Name;
    private int university_Reg_No;

    //Constructors
    public UniversityFootballClub(String club_Name, String location, int no_Of_Wins, int no_Of_Defeats, int no_Of_Draws, int scored_Goals, int received_Goals, String university_Name, int university_Reg_No) {
        super(club_Name, location, no_Of_Wins, no_Of_Defeats, no_Of_Draws, scored_Goals, received_Goals);
        this.university_Name = university_Name;
        this.university_Reg_No = university_Reg_No;
    }

    public UniversityFootballClub() {

    }

    //Getters & Setters
    public void setUniversity_Name(String university_Name) {
        this.university_Name = university_Name;

    }

    public String getUniversity_Name() {
        return university_Name;

    }

    public void setUniversity_Reg_No(int university_Reg_No) {
        this.university_Reg_No = university_Reg_No;

    }

    public int getUniversity_Reg_No() {
        return university_Reg_No;

    }

    @Override
    public String toString() {
        return "University Name  = " + university_Name +
                "\nUniversity Registration Number  = " + university_Reg_No;

    }
}
