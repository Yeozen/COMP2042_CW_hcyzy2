# COMP2042_CW_hcyzy2
1. Yeo Zen (20416394)
2. Compile the code by making sure that in project structure (Intellij), the library has a target of the javafx-sdk-19/lib. Then run 'Main'.
3. "COMP2042YeoZen\javadoc\index.html"
4. a) Options to change the board size from 4x4 to 3x3 and 5x5.\
   b) Leaderboard display with permanent scores saved after closing the game\
   c) Restart button\
   d) Duplicate name check for leaderboard\
   e) Color changer for the game scene\
   f) Warning to enter name if user does not enter a name before playing the game\
   g) Fixed the random spawning and increasing score bug\
   h) Organised the files into Model, View and Controller folders to better follow the MVC principles
5. Duplicate check for leaderboard, if user chooses to restart and has a lower score than the first time, a duplicate will appear in the leaderboard.
6. a) Back to menu button on leaderboard, currently only has a 'close' button because could not
      figure out the fxml code (it was working a week before i swear).\
   b) The restart button was supposed to bring up the menu.fxml but it stopped working a week before (see above) so the alternative is ugly but it works.
7. LeaderboardController
8. a) MenuController (formerly Controller)\
   b) Account\
   c) Endgame\
   d) Gamescene
   
Unexpected problems:
The score and spawning bug were huge obstacles. The score bug was mainly just the score increasing whenever a key was pressed/held down even though no valid moves 
were being performed. This was fixed by calling the sumCellNumbersToScore method whenever isValidDesV/H was true instead of calling it everytime a key was pressed 
like in the original code.

The spawning bug was when blocks would spawn even when there was no addition OR movement of blocks in the user's current move. This was solved by adding 2 boolean 
values called add and movement, only when either value is true, then only a block can spawn. Add was detected whenever adder was called while movement was detected 
by comparing the past state of the board stored in an array with the current state. 
