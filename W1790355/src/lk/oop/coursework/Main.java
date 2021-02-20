package lk.oop.coursework;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        Scanner scanner = new Scanner(System.in);

        //Displaying options in the CLI
        while (true) {

            System.out.println("----------Premier League Menu---------- \n");
            System.out.println("Press 1 to add a new football club  -: ");
            System.out.println("Press 2 to delete an existing club  -: ");
            System.out.println("Press 3 to display the statics of a selected club  -: ");
            System.out.println("Press 4 to display some of the statics of the clubs in a table  -: ");
            System.out.println("Press 5 to add a played match with the score & date  -: ");
            System.out.println("Press 6 to display the statics in a GUI  -: ");
            System.out.println("Press 9 to exit the programme  -:  \n");
            System.out.println("Enter here  -: ");

            try {
                String input = scanner.next();
                int input_2 = Integer.parseInt(input);

            switch (input_2) {

                case 1:
                    premierLeagueManager.addClub();
                    break;

                case 2:
                    premierLeagueManager.deleteClub();
                    break;

                case 3:
                    premierLeagueManager.displayStatics();
                    break;

                case 4:
                    premierLeagueManager.tableDisplaying();
                    break;

                case 5:
                    premierLeagueManager.addMatch();
                    break;

                case 6:
                    Interface.main(args);
                    break;

                case 9:
                    System.exit(0);

                default:
                    System.out.println("Please enter a correct input...");
                    break;
            }

        } catch (NumberFormatException numberFormatException) {
                System.out.println("Invalid input...!! Please enter a correct input...");

            }
        }
    }

}
