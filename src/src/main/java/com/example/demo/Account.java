package com.example.demo;

import javafx.scene.Group;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static com.example.demo.GameScene.score;

public class Account {

    private String userName;
    private static ArrayList<Account> accounts = new ArrayList<>();
    public static String[][] LeaderboardArray = new String[11][2];
    private static boolean isDuplicate = false;

    private static long getScore() {
        return score;
    }

    private String getUserName() {
        return userName;
    }

    static Account accountHaveBeenExist(String userName) {
        for (Account account : accounts) {
            if (account.getUserName().equals(userName)) {
                return account;
            }
        }
        return null;

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
        for (int i = 0; i < lengthOfFile() / 2; i++) {
            for (int j = 0; j < 2; j++) {
                if ((line = br.readLine()) != null) {
                    LeaderboardArray[i][j] = line;
                }
            }
        }
        br.close();
        System.out.println(Arrays.deepToString(LeaderboardArray));
    }

    static void saveScore() throws IOException {
        FileWriter fw = new FileWriter("\\C:\\GitHub\\COMP2042_CW_hcyzy2\\src\\src\\main\\java\\com\\example\\demo\\scores.txt", true);
        fw.append(Controller.userName).append("\n").append(String.valueOf(getScore())).append("\n");
        fw.close();
        populateArray();
        duplicateCheck();
        sortArray();
        FileWriter sortedScores = new FileWriter("\\C:\\GitHub\\COMP2042_CW_hcyzy2\\src\\src\\main\\java\\com\\example\\demo\\scores.txt");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 2; j++) {
                if (LeaderboardArray[i][j] != null) {
                    sortedScores.write(LeaderboardArray[i][j] + "\n");
                    System.out.println(LeaderboardArray[i][j]);
                }
            }
        }
        sortedScores.close();
    }

    static void sortArray() throws IOException {
        if (isDuplicate) {
            for (int k = 0; k < (lengthOfFile() / 2) - 2; k++) {
                for (int i = 0; i < (lengthOfFile() / 2) - 2; i++) {
                    if (Integer.parseInt(LeaderboardArray[i][1]) < Integer.parseInt(LeaderboardArray[i + 1][1])) {
                        String tempScore = LeaderboardArray[i][1];
                        String tempName = LeaderboardArray[i][0];
                        LeaderboardArray[i][1] = LeaderboardArray[i + 1][1];
                        LeaderboardArray[i][0] = LeaderboardArray[i + 1][0];
                        LeaderboardArray[i + 1][1] = tempScore;
                        LeaderboardArray[i + 1][0] = tempName;
                    }
                }
            }
        } else {
            for (int k = 0; k < (lengthOfFile() / 2) - 1; k++) {
                for (int i = 0; i < (lengthOfFile() / 2) - 1; i++) {
                    if (Integer.parseInt(LeaderboardArray[i][1]) < Integer.parseInt(LeaderboardArray[i + 1][1])) {
                        String tempScore = LeaderboardArray[i][1];
                        String tempName = LeaderboardArray[i][0];
                        LeaderboardArray[i][1] = LeaderboardArray[i + 1][1];
                        LeaderboardArray[i][0] = LeaderboardArray[i + 1][0];
                        LeaderboardArray[i + 1][1] = tempScore;
                        LeaderboardArray[i + 1][0] = tempName;
                    }
                }
            }
        }
    }

    static boolean duplicateCheck() throws IOException {
        for (int i = 0; i < (lengthOfFile() / 2) - 1; i++) {
            if (Objects.equals(LeaderboardArray[i][0], Controller.userName)){
                if (Integer.parseInt(LeaderboardArray[i][1]) < getScore()){
                    LeaderboardArray[i][1] = String.valueOf(getScore());
                    isDuplicate = true;
                }
            }
        }
        return isDuplicate;
    }
}