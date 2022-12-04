package com.example.demo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;
<<<<<<< Updated upstream
import java.util.Collections;

public class Account implements Comparable<Account> {
    private long score = 0;
    private String userName ;
    private static ArrayList<Account> accounts = new ArrayList<>();

    public Account(String userName){
        this.userName=userName;
    }

    @Override
    public int compareTo(Account o) {
        return Long.compare(o.getScore(), score);
    }
=======
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

import static com.example.demo.GameScene.score;

public class Account {

    private String userName;
    private static ArrayList<Account> accounts = new ArrayList<>();
    public static String [][] LeaderboardArray  = new String[11][2];
    private Group root;
>>>>>>> Stashed changes

    public void addToScore(long score) {
        this.score += score;
    }

    private long getScore() {
        return score;
    }

    private String getUserName() {
        return userName;
    }

    static Account accountHaveBeenExist(String userName){
        for(Account account : accounts){
            if(account.getUserName().equals(userName)){
                return account;
            }
        }
        return null;

    }

<<<<<<< Updated upstream
    static Account makeNewAccount(String userName){
        Account account = new Account(userName);
        accounts.add(account);
        return account;
    }

=======
    static int lengthOfFile() throws IOException {
        FileReader fr = new FileReader("\\C:\\GitHub\\COMP2042_CW_hcyzy2\\src\\src\\main\\java\\com\\example\\demo\\scores.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        int lengthOfFile = 0;
        while ((line = br.readLine()) != null) {
            lengthOfFile++;
        }
        return lengthOfFile;
    }

    static void populateArray() throws IOException {
        FileReader fr = new FileReader("\\C:\\GitHub\\COMP2042_CW_hcyzy2\\src\\src\\main\\java\\com\\example\\demo\\scores.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        for (int i = 0; i < lengthOfFile()/2; i++) {
            for (int j = 0; j < 2; j++) {
                if ((line = br.readLine()) != null) {
                    LeaderboardArray[i][j] = line;
                }
            }
        }
        br.close();
        System.out.println(Arrays.deepToString(LeaderboardArray));
    }

    static void saveScore () throws IOException {
        FileWriter fw = new FileWriter("\\C:\\GitHub\\COMP2042_CW_hcyzy2\\src\\src\\main\\java\\com\\example\\demo\\scores.txt", true);
        FileReader fr = new FileReader("\\C:\\GitHub\\COMP2042_CW_hcyzy2\\src\\src\\main\\java\\com\\example\\demo\\scores.txt");
        BufferedReader br = new BufferedReader(fr);
        fw.append(Controller.userName).append("\n").append(String.valueOf(getScore())).append("\n");
        fw.close();
        populateArray();
        sortArray();
        FileWriter sortedScores = new FileWriter("\\C:\\GitHub\\COMP2042_CW_hcyzy2\\src\\src\\main\\java\\com\\example\\demo\\scores.txt");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 2; j++) {
                if (LeaderboardArray[i][j] != null){
                    sortedScores.write(LeaderboardArray[i][j]+"\n");
                    System.out.println(LeaderboardArray[i][j]);
                }
            }
        }
        sortedScores.close();
    }

    static void sortArray() throws IOException {
        for (int k = 0; k < (lengthOfFile()/2)-1; k++){
            for (int i = 0; i < (lengthOfFile()/2)-1; i++) {
                if (Integer.parseInt(LeaderboardArray[i][1]) < Integer.parseInt(LeaderboardArray[i+1][1])){
                    String tempScore = LeaderboardArray[i][1];
                    String tempName = LeaderboardArray[i][0];
                    LeaderboardArray[i][1] = LeaderboardArray[i+1][1];
                    LeaderboardArray[i][0] = LeaderboardArray[i+1][0];
                    LeaderboardArray[i+1][1] = tempScore;
                    LeaderboardArray[i+1][0] = tempName;
                }
            }
        }
    }

    void leaderboard(Scene leaderboardScene, Group root, Stage primaryStage) throws IOException {
        
        /*this.root = root;
        int vert = 100;
        int hori = 400;
        populateArray();
        Text titleText = new Text();
        root.getChildren().add(titleText);
        titleText.setText("LEADERBOARD");
        titleText.relocate(hori, vert-100);
        Text text1 = new Text();
        root.getChildren().add(text1);

        text1.setText("1. "+ LeaderboardArray[0][0]);
        text1.relocate(hori, vert);
        Text text2 = new Text();
        root.getChildren().add(text2);
        text2.setText(LeaderboardArray[0][1]);
        text2.relocate(hori+=100, vert);
        Text text3 = new Text();
        root.getChildren().add(text3);
        text3.setText("2. "+ LeaderboardArray[1][0]);
        text3.relocate(hori-=100, vert+=50);
        Text text4 = new Text();
        root.getChildren().add(text4);
        text4.setText(LeaderboardArray[1][1]);
        text4.relocate(hori+=100, vert);
        Text text5 = new Text();
        root.getChildren().add(text5);
        text5.setText("3. "+ LeaderboardArray[2][0]);
        text5.relocate(hori-=100, vert+=50);
        Text text6 = new Text();
        root.getChildren().add(text6);
        text6.setText(LeaderboardArray[2][1]);
        text6.relocate(hori+=100, vert);
        Text text7 = new Text();
        root.getChildren().add(text7);
        text7.setText("4. "+ LeaderboardArray[3][0]);
        text7.relocate(hori-=100, vert+=50);
        Text text8 = new Text();
        root.getChildren().add(text8);
        text8.setText(LeaderboardArray[3][1]);
        text8.relocate(hori+=100, vert);
        Text text9 = new Text();
        root.getChildren().add(text9);
        text9.setText("5. "+ LeaderboardArray[4][0]);
        text9.relocate(hori-=100, vert+=50);
        Text text10 = new Text();
        root.getChildren().add(text10);
        text10.setText(LeaderboardArray[4][1]);
        text10.relocate(hori+=100, vert);
        Text text11 = new Text();
        root.getChildren().add(text11);
        text11.setText("6. "+ LeaderboardArray[5][0]);
        text11.relocate(hori-=100, vert+=50);
        Text text12 = new Text();
        root.getChildren().add(text12);
        text12.setText(LeaderboardArray[5][1]);
        text12.relocate(hori+=100, vert);
        Text text13 = new Text();
        root.getChildren().add(text13);
        text13.setText("7. "+ LeaderboardArray[6][0]);
        text13.relocate(hori-=100, vert+=50);
        Text text14 = new Text();
        root.getChildren().add(text14);
        text14.setText(LeaderboardArray[6][1]);
        text14.relocate(hori+=100, vert);
        Text text15 = new Text();
        root.getChildren().add(text15);
        text15.setText("8. "+ LeaderboardArray[7][0]);
        text15.relocate(hori-=100, vert+=50);
        Text text16 = new Text();
        root.getChildren().add(text16);
        text16.setText(LeaderboardArray[7][1]);
        text16.relocate(hori+=100, vert);
        Text text17 = new Text();
        root.getChildren().add(text17);
        text17.setText("9. "+ LeaderboardArray[8][0]);
        text17.relocate(hori-=100, vert+=50);
        Text text18 = new Text();
        root.getChildren().add(text18);
        text18.setText(LeaderboardArray[8][1]);
        text18.relocate(hori+=100, vert);
        Text text19 = new Text();
        root.getChildren().add(text19);
        text19.setText("10. "+ LeaderboardArray[9][0]);
        text19.relocate(hori-=100, vert+=50);
        Text text20 = new Text();
        root.getChildren().add(text20);
        text20.setText(LeaderboardArray[9][1]);
        text20.relocate(hori+=100, vert);
        text1.setFont(Font.font(30));
        text2.setFont(Font.font(30));
        text3.setFont(Font.font(30));
        text4.setFont(Font.font(30));
        text5.setFont(Font.font(30));
        text6.setFont(Font.font(30));
        text7.setFont(Font.font(30));
        text8.setFont(Font.font(30));
        text9.setFont(Font.font(30));
        text10.setFont(Font.font(30));
        text11.setFont(Font.font(30));
        text12.setFont(Font.font(30));
        text13.setFont(Font.font(30));
        text14.setFont(Font.font(30));
        text15.setFont(Font.font(30));
        text16.setFont(Font.font(30));
        text17.setFont(Font.font(30));
        text18.setFont(Font.font(30));
        text19.setFont(Font.font(30));
        text20.setFont(Font.font(30));*/
    }
>>>>>>> Stashed changes
}
