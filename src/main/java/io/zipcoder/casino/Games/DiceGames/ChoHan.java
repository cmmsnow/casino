package io.zipcoder.casino.Games.DiceGames;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.Players.ChoHanPlayer;
import io.zipcoder.casino.utilities.Input;
import io.zipcoder.casino.utilities.Output;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChoHan extends DiceGames {
    private ChoHanPlayer choHanPlayer;
    private Output output = new Output();
    private boolean gameRuns = true;


    public ChoHan(ChoHanPlayer choHanPlayer){
        this.choHanPlayer = choHanPlayer;
    }

    Scanner scanner = new Scanner(System.in);

    public void startScreen() {
        output.printToScreen("\nWelcome to Cho Han " + choHanPlayer.getName() + "!");

        while (gameRuns){
            output.printToScreen("\nWould you like to play a game of Cho Han " + choHanPlayer.getName() + "?\n" +
                    "1 - Yes, play game of Cho Han\n" +
                    "2 - Quit Cho Han and return to Casino floor\n" +
                    "----------------------------------------------\n");
            int input = Input.getIntInput("Enter decision here -> ");

            try {
            } catch (InputMismatchException e) {
                scanner.next();
                output.printToScreen("\n" + "Sorry! Please try again and choose a valid option.");
            }

        }


        }

    }

