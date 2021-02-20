package lk.oop.coursework;

public class SchoolFootballClub extends FootballClub {

    private String school_Name;
    private int school_Reg_No;

    //Constructors
    public SchoolFootballClub(String club_Name, String location, int no_Of_Wins, int no_Of_Defeats, int no_Of_Draws, int scored_Goals, int received_Goals, String school_Name, int school_Reg_No) {
        super(club_Name, location, no_Of_Wins, no_Of_Defeats, no_Of_Draws, scored_Goals, received_Goals);
        this.school_Name = school_Name;
        this.school_Reg_No = school_Reg_No;
    }

    public SchoolFootballClub(){

    }

    //getters & setters
    public void setSchool_Name(String school_Name) {
        this.school_Name = school_Name;

    }

    public String getSchool_Name() {
        return school_Name;

    }

    public void setSchool_Reg_No(int school_Reg_No) {
        this.school_Reg_No = school_Reg_No;

    }

    public int getReg_No() {
        return school_Reg_No;
    }


    @Override
    public String toString() {
        return "School Name = " + school_Name +
                "\nSchool Registration Number = " + school_Reg_No;
    }
}
