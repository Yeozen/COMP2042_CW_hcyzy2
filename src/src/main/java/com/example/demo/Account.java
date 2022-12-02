package com.example.demo;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import static com.example.demo.GameScene.score;

public class Account implements Comparable<Account> {
    private String userName;
    private static ArrayList<Account> accounts = new ArrayList<>();
    public static String [][] LeaderboardArray  = new String[11][2];

    public Account(String userName){
        this.userName=userName;
    }

    @Override
    public int compareTo(Account o) {
        return Long.compare(o.getScore(), score);
    }

    private static long getScore() {
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

    static Account makeNewAccount(String userName){
        Account account = new Account(userName);
        accounts.add(account);
        return account;
    }

    static void checkAccount(){
        HashMap<String,Long> matrix = new HashMap<>();
        if (accountHaveBeenExist(Controller.userName) == null){
            makeNewAccount(Controller.userName);
            matrix.put(Controller.userName, getScore());
        } else {
            matrix.put(String.valueOf(matrix.get(Controller.userName)), getScore());

        }
        System.out.println(matrix);
    }

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

    public void leaderboardShow(Scene endGameScene, Group root, Stage primaryStage, long score) {
        Account.checkAccount();
        Text text = new Text("GAME OVER");
        text.relocate(250, 250);
        text.setFont(Font.font(80));
        root.getChildren().add(text);
    }
}
