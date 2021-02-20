package lk.oop.coursework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.*;

public class PremierLeagueManager implements LeagueManager {

    Scanner scanner = new Scanner(System.in);

    //ArrayList 1
    ArrayList<FootballClub> footballClubs = new ArrayList<>();

    {
        try {
            FileInputStream input = new FileInputStream("info.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(input);
            footballClubs = (ArrayList<FootballClub>)objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("");
        }
    }

    //ArrayList 2
    ArrayList<MatchInfo> results = new ArrayList<>();

    {
        try {
            FileInputStream fileInputStream = new FileInputStream("matchResults.ser");
            ObjectInputStream objectInputStreamResults = new ObjectInputStream(fileInputStream);
            results = (ArrayList<MatchInfo>)objectInputStreamResults.readObject();
            objectInputStreamResults.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("");
        }
    }

    static void serialize(ArrayList<FootballClub> footballClubs) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("info.ser", false);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(footballClubs);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void serializeMatchInfo(ArrayList<MatchInfo> results) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("matchResults.ser", false);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(results);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        //Adding a New club Method
        @Override
        public void addClub () {

            System.out.println("If it is a School club, Press 1 \n" +
                    "If it is a University club, Press 2 \n");


            int choice = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter the name of the club  -: ");
            String clubName = scanner.nextLine();

            System.out.println("Enter the location of the club  -: ");
            String location = scanner.nextLine();

            System.out.println("Enter the number of wins  -: ");
            int wins = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter the number of defeats  -: ");
            int defeats = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter the number of draws  -: ");
            int draws = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter the number of scored goals  -: ");
            int scoredGoals = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter the number of received goals  -: ");
            int receivedGoals = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:

                    System.out.println("Please enter the name of your School  -: ");
                    String schoolName = scanner.nextLine();
                    System.out.println("Please enter the registration number of your School  -: ");
                    int SclRegNumber = Integer.parseInt(scanner.nextLine());

                    SchoolFootballClub schoolFootballClub = new SchoolFootballClub(clubName, location, wins, defeats,
                            draws, scoredGoals, receivedGoals, schoolName, SclRegNumber);
                    footballClubs.add(schoolFootballClub);
                    break;

                case 2:

                    System.out.println("Please enter the name of your University  -: ");
                    String universityName = scanner.nextLine();
                    System.out.println("Please enter the registration number of your University  -: ");
                    int UniRegNumber = Integer.parseInt(scanner.nextLine());

                    UniversityFootballClub universityFootballClub = new UniversityFootballClub(clubName, location, wins, defeats,
                            draws, scoredGoals, receivedGoals, universityName, UniRegNumber);
                    footballClubs.add(universityFootballClub);
                    break;

                default:
                    System.out.println("Please enter a correct input...!!");


            }
            serialize(footballClubs);
        }

        //Deleting a Club Method
        @Override
        public void deleteClub () {

            System.out.println("------------Delete a club from the league----------");
            System.out.println("\n");

            System.out.println("Please enter the name of the club -: ");
            String deleteClub = scanner.nextLine();

            for (FootballClub footballClub : footballClubs) {

                if (footballClub.getClub_Name().equals(deleteClub)) {
                    footballClubs.remove(footballClub);

                    System.out.println("The " + footballClub.getClub_Name() + " club is deleted successfully....!! \n");
                    return;
                }
            }
    }


        //Displaying the statics of a Selected Club Method
        @Override
        public void displayStatics () {

            System.out.println("------------Display the statics------------");
            System.out.println("\n");

            System.out.println("Please enter the name of the club -: ");
            String displayStatics = scanner.nextLine();

            for (FootballClub footballClub : footballClubs) {

                if (footballClub.getClub_Name().equals(displayStatics)) {
                    System.out.println(footballClub);

                    System.out.println("Club name  = " + footballClub.getClub_Name());
                    System.out.println("Number of wins  = " + footballClub.getno_Of_Wins());
                    System.out.println("Number of defeats  = " + footballClub.getNo_Of_Defeats());
                    System.out.println("Number of draws  = " + footballClub.getNo_Of_Draws());
                    System.out.println("Number of played matches  = " + footballClub.getplayed_Matches());
                    System.out.println("Number of total points  = " + footballClub.gettotal_Points());
                    System.out.println("Number of scored goals  = " + footballClub.getScored_Goals());
                    System.out.println("Number of received goals  = " + footballClub.getReceived_Goals());
                    System.out.println("\n");
                    return;
                }
            }
            System.out.println("Club name is incorrect... Please check & try again...!!");
        }


        //Displaying the statics of the all the clubs Method
        @Override
        public void tableDisplaying () {

            Comparator<FootballClub> sortByPoints = Comparator.comparing(FootballClub::gettotal_Points).thenComparing(FootballClub::getGoalDifference);
            footballClubs.sort(sortByPoints);
            Collections.reverse(footballClubs);

            System.out.println("********************************************************************************************************************************");
            System.out.printf("%-30s %-15s %-15s %-12s %-20s %-20s %-15s", "Club Name", "Wins", "Defeats", "Draws", "Scored Goals", "Received Goals", "Points");
            System.out.println();
            System.out.println("********************************************************************************************************************************");
            for (FootballClub footballClub : footballClubs) {
                System.out.format("%-30s %-15s %-15s %-12s %-20s %-20s %-15s", footballClub.getClub_Name(), footballClub.getno_Of_Wins(), footballClub.getNo_Of_Defeats(), footballClub.getNo_Of_Draws(), footballClub.getScored_Goals(), footballClub.getReceived_Goals(), footballClub.gettotal_Points());
                System.out.println();
            }
            System.out.println("********************************************************************************************************************************");
        }


        //Add a New match Method
        @Override
        public void addMatch () {

            int i = 1;

            for (SportsClub club : footballClubs) {
                System.out.println(i + ". " + club.getClub_Name());
                i++;
            }

            //getting the team names & scored goals
            System.out.println("Enter the number of Home Team  -:");
            int homeTeam = scanner.nextInt() - 1;

            System.out.println("Enter the goals scored by Home team  -:");
            int homeTeamGoals = scanner.nextInt();

            System.out.println("Enter the number of Away Team  -:");
            int awayTeam = scanner.nextInt() - 1;

            System.out.println("Enter the goals scored by Away team  -:");
            int awayTeamGoals = scanner.nextInt();

            footballClubs.get(homeTeam).setScored_Goals(footballClubs.get(homeTeam).getScored_Goals() + homeTeamGoals);
            footballClubs.get(homeTeam).setReceived_Goals(footballClubs.get(homeTeam).getReceived_Goals() + awayTeamGoals);
            footballClubs.get(awayTeam).setScored_Goals(footballClubs.get(awayTeam).getScored_Goals() + awayTeamGoals);
            footballClubs.get(awayTeam).setReceived_Goals(footballClubs.get(awayTeam).getReceived_Goals() + homeTeamGoals);

            //if home team wins
            if (homeTeamGoals > awayTeamGoals) {
                footballClubs.get(homeTeam).setNo_Of_Wins(footballClubs.get(homeTeam).getno_Of_Wins() + 1);
                footballClubs.get(awayTeam).setNo_Of_Defeats(footballClubs.get(awayTeam).getNo_Of_Defeats() + 1);

                //if away team wins
            } else if (homeTeamGoals < awayTeamGoals) {
                footballClubs.get(homeTeam).setNo_Of_Defeats(footballClubs.get(homeTeam).getNo_Of_Defeats() + 1);
                footballClubs.get(awayTeam).setNo_Of_Wins(footballClubs.get(awayTeam).getno_Of_Wins() + 1);

                //if the match is draw
            } else {
                footballClubs.get(homeTeam).setNo_Of_Draws(footballClubs.get(homeTeam).getNo_Of_Draws() + 1);
                footballClubs.get(awayTeam).setNo_Of_Draws(footballClubs.get(awayTeam).getNo_Of_Draws() + 1);

            }

            System.out.println("Enter the match played year -:");
            int year = scanner.nextInt();

            System.out.println("Enter the match played month -:");
            int month = scanner.nextInt();

            System.out.println("Enter the match played day -:");
            int day = scanner.nextInt();

            Date date = new Date(year, month, day);

            MatchInfo matchInfo = new MatchInfo(footballClubs.get(homeTeam).getClub_Name(), footballClubs.get(awayTeam).getClub_Name(), homeTeamGoals, awayTeamGoals, date);
            results.add(matchInfo);

            serialize(footballClubs);
            serializeMatchInfo(results);
        }

        //Generate a Random Match Method
        @Override
        public void randomMatch() {

            Random random = new Random();
            int homeTeam = random.nextInt(footballClubs.size());
            int awayTeam;
            do {
                awayTeam = random.nextInt(footballClubs.size());
            }
            while (homeTeam == awayTeam);

            int homeTeamGoals = random.nextInt(9);
            int awayTeamGoals = random.nextInt(9);

            footballClubs.get(homeTeam).setScored_Goals(footballClubs.get(homeTeam).getScored_Goals() + homeTeamGoals);
            footballClubs.get(homeTeam).setReceived_Goals(footballClubs.get(homeTeam).getReceived_Goals() + awayTeamGoals);
            footballClubs.get(awayTeam).setScored_Goals(footballClubs.get(awayTeam).getScored_Goals() + awayTeamGoals);
            footballClubs.get(awayTeam).setReceived_Goals(footballClubs.get(awayTeam).getReceived_Goals() + homeTeamGoals);

            //if home team wins
            if (homeTeamGoals > awayTeamGoals) {
                footballClubs.get(homeTeam).setNo_Of_Wins(footballClubs.get(homeTeam).getno_Of_Wins() + 1);
                footballClubs.get(awayTeam).setNo_Of_Defeats(footballClubs.get(awayTeam).getNo_Of_Defeats() + 1);

                //if away team wins
            } else if (homeTeamGoals < awayTeamGoals) {
                footballClubs.get(homeTeam).setNo_Of_Defeats(footballClubs.get(homeTeam).getNo_Of_Defeats() + 1);
                footballClubs.get(awayTeam).setNo_Of_Wins(footballClubs.get(awayTeam).getno_Of_Wins() + 1);

                //if the match is draw
            } else {
                footballClubs.get(homeTeam).setNo_Of_Draws(footballClubs.get(homeTeam).getNo_Of_Draws() + 1);
                footballClubs.get(awayTeam).setNo_Of_Draws(footballClubs.get(awayTeam).getNo_Of_Draws() + 1);

            }

            int year = random.nextInt(10) + 2015;
            int month = random.nextInt(11) + 1;
            int day = random.nextInt(30) + 1;
            Date date = new Date(year, month, day);

            MatchInfo matchInfo = new MatchInfo(footballClubs.get(homeTeam).getClub_Name(), footballClubs.get(awayTeam).getClub_Name(), homeTeamGoals, awayTeamGoals, date);
            results.add(matchInfo);

            serialize(footballClubs);
            serializeMatchInfo(results);

        }

    }
