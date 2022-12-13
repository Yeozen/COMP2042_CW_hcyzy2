package com.example.demo;

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author Zen Yeo
 */
class AccountTest {

    /**
     * for this test method the expected output should vary based on the actual length of the text file, 'scores.txt'
     * so if there are 5 usernames and 5 scores, the expected output should be '10' lines.
     * @throws IOException
     */
    @Test
    void lengthOfFile() throws IOException {
        assertEquals(10, Account.lengthOfFile());
    }

    @Test
    void populateArray() throws IOException {
        Account.populateArray();
        FileReader fr = new FileReader("scores.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        boolean doesNotMatch = false;
        for (int i = 0; i < 10; i ++){
            for (int j = 0; j < 2; j++){
                line = br.readLine();
                if(line == null){
                    break;
                }
                if (!Objects.equals(line, Account.LeaderboardArray[i][j])){
                    doesNotMatch = true;
                    break;
                }
            }
        }
        assertFalse(doesNotMatch);
    }

    @Test
    void saveScore() {

    }

    @Test
    void sortArray() {

    }

    @Test
    void duplicateCheck() {

    }
}