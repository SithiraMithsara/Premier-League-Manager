package lk.oop.coursework;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;


public class Interface extends Application {

    Scene sceneHistory;

    ArrayList<FootballClub> footballClubs;
    ArrayList<MatchInfo> matchInfo;

    ObservableList<Object> objectList = FXCollections.observableArrayList();
    ObservableList<Object> displayMatches = FXCollections.observableArrayList();
    ObservableList<Object> searchByDate = FXCollections.observableArrayList();

    PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
    TextField dateText, monthText, yearText;
    TableView<Object> played;
    int day, month, year;
    Image image;
    ImageView imageView, imageView_2;


    //Getting data from the file
    public ObservableList getDataFromFootballClubs() {
        try {
            FileInputStream fileInputStream = new FileInputStream("info.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            footballClubs = (ArrayList<FootballClub>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            System.out.println("");
        }
        objectList.clear();
        objectList.addAll(footballClubs);
        return (ObservableList) objectList;
    }


    //Getting data from the file
    public ObservableList getDataOfPlayedMatches() {
        try {
            FileInputStream fileInputStreamPlayedMatches = new FileInputStream("matchResults.ser");
            ObjectInputStream objectInputStreamPlayedMatches = new ObjectInputStream(fileInputStreamPlayedMatches);
            matchInfo = (ArrayList<MatchInfo>) objectInputStreamPlayedMatches.readObject();
            objectInputStreamPlayedMatches.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("");
        }
        displayMatches.clear();
        try {
            displayMatches.addAll(matchInfo);
        }catch (NullPointerException e) {
            System.out.println("");
        }return displayMatches;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        AnchorPane anchorPane = new AnchorPane();
        primaryStage.setTitle("Football Premier League");

        //Title Label
        Label welcomeLbl = new Label("Football Premier League");
        welcomeLbl.setLayoutX(1);
        welcomeLbl.setLayoutY(20);
        welcomeLbl.setPrefWidth(1200);
        welcomeLbl.setPrefHeight(60);
        welcomeLbl.setStyle("-fx-background-color: #b3e6ff; -fx-alignment:center; -fx-font-family: Castellar; -fx-font-size: 40; -fx-text-fill: #990012;");

        //Adding a Background Image
        image = new Image("file:football-background.jpg");
        imageView = new ImageView();
        imageView.setImage(image);
        imageView.setPreserveRatio(true);

        //Creating the table
        TableView tableView = new TableView();
        tableView.setPrefWidth(800);
        tableView.setLayoutX(150);
        tableView.setLayoutY(100);

        //Creating the table columns
        TableColumn<Object, String> column_1 = new TableColumn<>("Club Name");
        column_1.setCellValueFactory(new PropertyValueFactory<>("club_Name"));
        column_1.setPrefWidth(250);

        TableColumn<Object, Integer> column_2 = new TableColumn<>("Points");
        column_2.setCellValueFactory(new PropertyValueFactory<>("total_Points"));
        column_2.setPrefWidth(80);

        TableColumn<Object, Integer> column_3 = new TableColumn<>("Wins");
        column_3.setCellValueFactory(new PropertyValueFactory<>("no_Of_Wins"));
        column_3.setPrefWidth(80);

        TableColumn<Object, Integer> column_4 = new TableColumn<>("Defeats");
        column_4.setCellValueFactory(new PropertyValueFactory<>("no_Of_Defeats"));
        column_4.setPrefWidth(80);

        TableColumn<Object, Integer> column_5 = new TableColumn<>("Draws");
        column_5.setCellValueFactory(new PropertyValueFactory<>("no_Of_Draws"));
        column_5.setPrefWidth(80);

        TableColumn<Object, Integer> column_6 = new TableColumn<>("Played Matches");
        column_6.setCellValueFactory(new PropertyValueFactory<>("played_Matches"));
        column_6.setPrefWidth(120);

        TableColumn<Object, Integer> column_7 = new TableColumn<>("Scored Goals");
        column_7.setCellValueFactory(new PropertyValueFactory<>("scored_Goals"));
        column_7.setPrefWidth(105);

        TableColumn<Object, Integer> column_8 = new TableColumn<>("Received Goals");
        column_8.setCellValueFactory(new PropertyValueFactory<>("received_Goals"));
        column_8.setPrefWidth(110);


        //Sort the table by Scored Goals
        Button Sort1btn = new Button("Sort by Scored Goals");
        Sort1btn.setLayoutX(100);
        Sort1btn.setLayoutY(530);
        Sort1btn.setPrefSize(210, 30);
        Sort1btn.setStyle("-fx-background-color: #59E817; -fx-font: normal bold 17px 'Mali';");
        Sort1btn.setOnMouseEntered(event -> Sort1btn.setStyle("-fx-background-color: #5EFB6E; -fx-font: normal bold 17px 'Mali';"));
        Sort1btn.setOnMouseExited(event -> Sort1btn.setStyle("-fx-background-color: #59E817; -fx-font: normal bold 17px 'Mali';"));
        Sort1btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                column_7.setSortType(TableColumn.SortType.DESCENDING);
                tableView.getSortOrder().addAll(column_7);
            }
        });

        //Sort the table by Wins
        Button Sort2btn = new Button("Sort by Wins");
        Sort2btn.setLayoutX(400);
        Sort2btn.setLayoutY(530);
        Sort2btn.setPrefSize(140, 30);
        Sort2btn.setStyle("-fx-background-color: #59E817; -fx-font: normal bold 17px 'Mali';");
        Sort2btn.setOnMouseEntered(event -> Sort2btn.setStyle("-fx-background-color: #5EFB6E; -fx-font: normal bold 17px 'Mali';"));
        Sort2btn.setOnMouseExited(event -> Sort2btn.setStyle("-fx-background-color: #59E817; -fx-font: normal bold 17px 'Mali';"));
        Sort2btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                column_3.setSortType(TableColumn.SortType.DESCENDING);
                tableView.getSortOrder().addAll(column_3);
            }
        });

        //Sort the table by Points
        Button Sort3btn = new Button("Sort by Points");
        Sort3btn.setLayoutX(650);
        Sort3btn.setLayoutY(530);
        Sort3btn.setPrefSize(140, 30);
        Sort3btn.setStyle("-fx-background-color: #59E817; -fx-font: normal bold 17px 'Mali';");
        Sort3btn.setOnMouseEntered(event -> Sort3btn.setStyle("-fx-background-color: #5EFB6E; -fx-font: normal bold 17px 'Mali';"));
        Sort3btn.setOnMouseExited(event -> Sort3btn.setStyle("-fx-background-color: #59E817; -fx-font: normal bold 17px 'Mali';"));
        Sort3btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                column_2.setSortType(TableColumn.SortType.DESCENDING);
                tableView.getSortOrder().addAll(column_2);
            }
        });

        //Switch to other window
        Button DisplayBtn = new Button("Display Played Matches ➡");
        DisplayBtn.setLayoutX(900);
        DisplayBtn.setLayoutY(530);
        DisplayBtn.setPrefSize(240, 30);
        DisplayBtn.setStyle("-fx-background-color: #9E7BFF; -fx-font: normal bold 17px 'Mali';");
        DisplayBtn.setOnMouseEntered(event -> DisplayBtn.setStyle("-fx-background-color: #E0B0FF; -fx-font: normal bold 17px 'Mali';"));
        DisplayBtn.setOnMouseExited(event -> DisplayBtn.setStyle("-fx-background-color: #9E7BFF; -fx-font: normal bold 17px 'Mali';"));
        DisplayBtn.setOnAction(event -> primaryStage.setScene(sceneHistory));

        tableView.getColumns().addAll(column_1, column_2, column_3, column_4, column_5, column_6, column_7, column_8);
        tableView.setItems(getDataFromFootballClubs());

        anchorPane.getChildren().addAll(imageView, Sort1btn, Sort2btn, Sort3btn, welcomeLbl, DisplayBtn);
        anchorPane.getChildren().add(tableView);

        Scene scene = new Scene(anchorPane, 1200,600);
        primaryStage.setScene(scene);
        primaryStage.show();


        //Match result prompting window
        AnchorPane displayPane = new AnchorPane();

        //Played Match Label
        Label playedMatchLbl = new Label("Played Matches");
        playedMatchLbl.setLayoutX(1);
        playedMatchLbl.setLayoutY(20);
        playedMatchLbl.setPrefWidth(1200);
        playedMatchLbl.setPrefHeight(60);
        playedMatchLbl.setStyle("-fx-alignment:center; -fx-font-family: Castellar; -fx-font-size: 40; -fx-text-fill: #F4A896;");

        Label searchLabel = new Label("Type the date & search the match");
        searchLabel.setLayoutX(820);
        searchLabel.setLayoutY(100);
        searchLabel.setPrefWidth(350);
        searchLabel.setPrefHeight(30);
        searchLabel.setStyle("-fx-font: normal bold 22px 'Mali'; -fx-text-fill: #990012;");

        //Adding a Background Image
        image = new Image("file:football-background_2.jpg");
        imageView_2 = new ImageView();
        imageView_2.setImage(image);
        imageView_2.setPreserveRatio(true);

        //Creating the Table
        played = new TableView();
        played.setLayoutX(50);
        played.setLayoutY(100);
        played.setPrefWidth(720);
        played.setItems(getDataOfPlayedMatches());

        //Adding the Table Columns
        TableColumn<Object, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        dateColumn.setPrefWidth(90);

        TableColumn<Object, String> homeTeamColumn = new TableColumn<>("Home Team");
        homeTeamColumn.setCellValueFactory(new PropertyValueFactory<>("homeTeam"));
        homeTeamColumn.setPrefWidth(190);

        TableColumn<Object, String> homeTeamGoalColumn = new TableColumn<>("Home Team Goals");
        homeTeamGoalColumn.setCellValueFactory(new PropertyValueFactory<>("homeTeamGoals"));
        homeTeamGoalColumn.setPrefWidth(120);

        TableColumn<Object, String> awayTeamColumn = new TableColumn<>("Away Team");
        awayTeamColumn.setCellValueFactory(new PropertyValueFactory<>("awayTeam"));
        awayTeamColumn.setPrefWidth(190);

        TableColumn<Object, String> awayTeamGoalColumn = new TableColumn<>("Away Team Goals");
        awayTeamGoalColumn.setCellValueFactory(new PropertyValueFactory<>("awayTeamGoals"));
        awayTeamGoalColumn.setPrefWidth(120);

        Label dateLbl = new Label("Enter the Date  -:");
        dateLbl.setLayoutX(850);
        dateLbl.setLayoutY(160);
        dateLbl.setPrefWidth(400);
        dateLbl.setPrefHeight(30);
        dateLbl.setStyle("-fx-text-fill: white; -fx-font: normal bold 15px 'Mali';");

        Label monthLbl = new Label("Enter the Month  -:");
        monthLbl.setLayoutX(850);
        monthLbl.setLayoutY(260);
        monthLbl.setPrefWidth(400);
        monthLbl.setPrefHeight(30);
        monthLbl.setStyle("-fx-text-fill: white; -fx-font: normal bold 15px 'Mali';");

        Label yearLbl = new Label("Enter the Year  -:");
        yearLbl.setLayoutX(850);
        yearLbl.setLayoutY(360);
        yearLbl.setPrefWidth(400);
        yearLbl.setPrefHeight(30);
        yearLbl.setStyle("-fx-text-fill: white; -fx-font: normal bold 15px 'Mali';");

        dateText = new TextField();
        dateText.setLayoutX(930);
        dateText.setLayoutY(200);
        dateText.setPrefWidth(200);

        monthText = new TextField();
        monthText.setLayoutX(930);
        monthText.setLayoutY(300);
        monthText.setPrefWidth(200);

        yearText = new TextField("");
        yearText.setLayoutX(930);
        yearText.setLayoutY(400);
        yearText.setPrefWidth(200);

        //Search a random match by date
        Button SearchBtn = new Button("Search");
        SearchBtn.setLayoutX(920);
        SearchBtn.setLayoutY(470);
        SearchBtn.setPrefSize(80, 10);
        SearchBtn.setStyle("-fx-background-color: #59E817; -fx-font: normal bold 16px 'Mali';");
        SearchBtn.setOnMouseEntered(event -> SearchBtn.setStyle("-fx-background-color: #5EFB6E; -fx-font: normal bold 16px 'Mali';"));
        SearchBtn.setOnMouseExited(event -> SearchBtn.setStyle("-fx-background-color: #59E817; -fx-font: normal bold 16px 'Mali';"));
        SearchBtn.setOnAction(event -> searchByDate());

        //Generate a Random Match Button
        Button RandomBtn = new Button("Generate a Random Match");
        RandomBtn.setLayoutX(450);
        RandomBtn.setLayoutY(540);
        RandomBtn.setPrefSize(260, 20);
        RandomBtn.setStyle("-fx-background-color: #ffcc00; -fx-font: normal bold 16px 'Mali';");
        RandomBtn.setOnMouseEntered(event -> RandomBtn.setStyle("-fx-background-color: #ffd633; -fx-font: normal bold 16px 'Mali';"));
        RandomBtn.setOnMouseExited(event -> RandomBtn.setStyle("-fx-background-color: #ffcc00; -fx-font: normal bold 16px 'Mali';"));
        RandomBtn.setOnAction(event -> randomMatch());

        //Back Button
        Button BackBtn = new Button("⬅Back");
        BackBtn.setLayoutX(120);
        BackBtn.setLayoutY(540);
        BackBtn.setPrefSize(100, 20);
        BackBtn.setStyle("-fx-text-fill: white; -fx-background-color: #ff3333; -fx-font: normal bold 16px 'Mali';");
        BackBtn.setOnMouseEntered(event -> BackBtn.setStyle("-fx-text-fill: white; -fx-background-color: #4d94ff; -fx-font: normal bold 16px 'Mali';"));
        BackBtn.setOnMouseExited(event -> BackBtn.setStyle("-fx-text-fill: white; -fx-background-color: #ff3333; -fx-font: normal bold 16px 'Mali';"));
        BackBtn.setOnAction(event -> primaryStage.setScene(scene));

        //Clear Button
        Button clearBtn = new Button("Clear");
        clearBtn.setLayoutX(1060);
        clearBtn.setLayoutY(470);
        BackBtn.setPrefSize(80, 15);
        clearBtn.setStyle("-fx-background-color: #59E817; -fx-font: normal bold 16px 'Mali';");
        clearBtn.setOnMouseEntered(event -> clearBtn.setStyle("-fx-background-color: #5EFB6E; -fx-font: normal bold 16px 'Mali';"));
        clearBtn.setOnMouseExited(event -> clearBtn.setStyle("-fx-background-color: #59E817; -fx-font: normal bold 16px 'Mali';"));
        clearBtn.setOnAction(event -> clear());

        played.getColumns().addAll(dateColumn, homeTeamColumn, homeTeamGoalColumn, awayTeamColumn, awayTeamGoalColumn);
        displayPane.getChildren().addAll(imageView_2, playedMatchLbl, searchLabel, dateLbl, monthLbl, yearLbl, dateText, monthText, yearText,  BackBtn, RandomBtn, played, SearchBtn, clearBtn);

        sceneHistory = new Scene(displayPane, 1200, 600);

    }


    //clearing the table method
    public void clear() {
        dateText.setText("");
        monthText.setText("");
        yearText.setText("");
        played.setItems(getDataOfPlayedMatches());
    }


    //Searching a match by the date method
    public void searchByDate() {
        searchByDate.clear();

        try {
            year = Integer.parseInt(yearText.getText());
            month = Integer.parseInt(monthText.getText());
            day = Integer.parseInt(dateText.getText());

        } catch (Exception e) {
            System.out.println("Please enter a date");
        }
        for (MatchInfo playedMatches:matchInfo) {
            if (day == playedMatches.getDate().getDay() && month == playedMatches.getDate().getMonth() && year == playedMatches.getDate().getYear()) {
                searchByDate.add(playedMatches);

            }
        }
        played.setItems(searchByDate);
    }


    //Random match creating method
    void randomMatch() {
        premierLeagueManager.randomMatch();
        getDataFromFootballClubs();
        getDataOfPlayedMatches();
    }


    public static void main(String[] args) {
        launch(args);
    }
}