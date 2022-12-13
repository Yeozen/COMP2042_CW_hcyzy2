package com.example.demo.Model;

import com.example.demo.Controller.MenuController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

import static com.example.demo.Model.GameScene.score;

/**
 * Account class that holds everything related to the users accounts and high scores
 */
public class Account {
    /**
     * A 2d array that holds 22 strings. Each username and high score is stored in such a way that they correspond to each other which
     * is important when sorting the scores. E.g. (username 1 and its score is both accessible by LeaderboardArray[0][0] and [0][1])
     */
    public static String[][] LeaderboardArray = new String[11][2];
    private static boolean isDuplicate = false;

    /**
     * getter method to obtain score from GameScene file
     * @return score from GameScene
     */
    private static long getScore() {
        return score;
    }

    /**
     * finds the length of the text file used to store usernames and scores
     * @return length of scores.txt
     * @throws IOException
     */
    public static int lengthOfFile() throws IOException {
        FileReader fr = new FileReader("scores.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        int lengthOfFile = 0;
        while ((line = br.readLine()) != null) {
            lengthOfFile++;
        }
        return lengthOfFile;
    }

    /**
     * reads the text file and inserts into the array so the data can be manipulated more easily
     * @throws IOException
     */
    public static void populateArray() throws IOException {
        FileReader fr = new FileReader("scores.txt");
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
    }

    /**
     * saves the latest score to the text file and calls upon the other methods to sort, find duplicates and rewrite the
     * text file with the correct order of username/high score.
     * @throws IOException
     */
    static void saveScore() throws IOException {
        FileWriter fw = new FileWriter("scores.txt", true);
        fw.append(MenuController.userName).append("\n").append(String.valueOf(getScore())).append("\n");
        fw.close();
        populateArray();
        duplicateCheck();
        sortArray();
        int lof = lengthOfFile();
        FileWriter sortedScores = new FileWriter("scores.txt");
        int arrayLimit = 0;
        if (isDuplicate) {
            arrayLimit += 1;
        }
        for (int i = 0; i < (lof/2) - arrayLimit; i++) {
            for (int j = 0; j < 2; j++) {
                if (LeaderboardArray[i][j] != null) {
                    sortedScores.write(LeaderboardArray[i][j] + "\n");
                }
            }
        }
        sortedScores.close();
    }

    /**
     * sorts the array via bubblesort
     * @throws IOException
     */
    static void sortArray() throws IOException {
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

    /**
     * checks for duplicate usernames in the current array, if there are, swap with the last element in the array
     * and just print out the array without the last element
     * @throws IOException
     */
    static void duplicateCheck() throws IOException {
        for (int i = 0; i < (lengthOfFile() / 2) - 1; i++) {
            if (Objects.equals(LeaderboardArray[i][0], MenuController.userName)){
                if (Integer.parseInt(LeaderboardArray[i][1]) < getScore()){
                    LeaderboardArray[i][1] = String.valueOf(getScore());
                    String tempScore = LeaderboardArray[((lengthOfFile() / 2) - 1)][1];
                    String tempName = LeaderboardArray[((lengthOfFile() / 2) - 1)][0];
                    LeaderboardArray[((lengthOfFile() / 2) - 1)][1] = LeaderboardArray[i][1];
                    LeaderboardArray[((lengthOfFile() / 2) - 1)][0] = LeaderboardArray[i][0];
                    LeaderboardArray[i][1] = tempScore;
                    LeaderboardArray[i][0] = tempName;
                }
                isDuplicate = true;
            }
        }
    }
}