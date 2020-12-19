package io.zipcoder.casino.Games.DiceGames;
import io.zipcoder.casino.GameSupplies.Dice;
import io.zipcoder.casino.Games.GamblingGameInterface;
import io.zipcoder.casino.Players.CrapsPlayer;
import io.zipcoder.casino.utilities.Input;
import io.zipcoder.casino.utilities.Output;
import io.zipcoder.casino.utilities.Switchboard;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Craps extends DiceGames implements GamblingGameInterface {
    private CrapsPlayer crapsPlayer;
    private Output output = new Output();
    private double currentWager = 0;
    boolean quit = false;
    public Scanner hold = new Scanner(System.in);
    public Dice dice = new Dice(2);
    Input input = new Input(System.in, System.out);
    Scanner scanner = new Scanner(System.in);

    public Craps(CrapsPlayer crapsPlayer) {
        this.crapsPlayer = crapsPlayer;
    }

    public void pause() {
        System.out.println("\nPlease press Enter to roll dice...");
        hold.nextLine();
    }

    public boolean playGame() {
        while (!quit) {
            output.printToScreen("\nWelcome to the Craps table " + crapsPlayer.getName() + "!\nLet's start the game! You want to roll a 7 or 11\n" +
                    "\nPress 1 to roll the Dice\n" +
                    "Press 2 to return to the Casino Floor\n" +
                    "--------------------------------------\n");
            int gameInput = input.getIntegerInput("Enter decision here->   ");
            try {
                if (gameInput == 1) {
                    takeBet();
                    output.printToScreen("\nFirst Roll! Let's hope for a 7 or 11");
                    rollDice();
                    break;
                } else if (gameInput == 2) {
                    output.printToScreen("\nEnjoy the rest of your day!");
                    quit = true;
                    return quit;
                } else {
                    output.printToScreen("\nIncorrect input. Please enter 1 or 2");
                }
            } catch (InputMismatchException e) {
                scanner.next();
                output.printToScreen("\nPlease enter a valid input");
            }
        }
        return quit;
    }
    public void takeBet() {
        double betInput = input.getDoubleInput("\nEnter the amount you would like to bet here -> ");
        if (betInput > crapsPlayer.getWallet()) {
            Output.printToScreen("\nYou do not have enough to cover that bet.");
            takeBet();
        } else {
            Output.printToScreen("Your bet is: $" + betInput);
            crapsPlayer.setWallet(crapsPlayer.getWallet() - betInput);
            setCurrentWager(betInput);
        }
    }
    public void setCurrentWager(double wager){ this.currentWager = wager; }
    public double getCurrentWager(){
        return this.currentWager;
    }
    public double payOut() {
        crapsPlayer.setWallet(crapsPlayer.getWallet() + (2 * getCurrentWager()));
        return 2 * getCurrentWager();
    }
    public void rollDice() {
        pause();
        Integer firstRoll = dice.tossAndSum(2);
        Output.printToScreen("\nDice sum: " + firstRoll);
        if (firstRoll == 7 || firstRoll == 11) {
            output.printToScreen("\nCongrats you win! Good roll!\nGame Over!");
            payOut();
            Output.printToScreen("Your current wallet balance is: " + crapsPlayer.getWallet());
        } else if (firstRoll == 2 || firstRoll == 3 || firstRoll == 12) {
            output.printToScreen("\nSorry you rolled a " + firstRoll + " you lose!");
            Output.printToScreen("Your current wallet balance is: " + crapsPlayer.getWallet() + "\nGame Over!");
        } else {
            Integer point = firstRoll; //4, 5, 6, 8, 9, 10 depending on roll
            output.printToScreen("\nNow you want to roll a " + point + " to win! You lose with 7 or 11.");
            nextRoll(firstRoll);
        }
    }

    public Boolean nextRoll(Integer number) {
        Integer point = number;
        boolean out = false;
        pause();
        Integer secondRoll = dice.tossAndSum(2);
        output.printToScreen("\nDice Sum: " + secondRoll);
        while (secondRoll != point && secondRoll != 7 && secondRoll != 11) {
            output.printToScreen("\nRoll again. You want to roll " + point + " still.");
            pause();
            secondRoll = dice.tossAndSum(2);
            output.printToScreen("\nYou rolled " + secondRoll);
        } if (secondRoll == 7 || secondRoll == 11) {
            output.printToScreen("\nSorry you rolled a " + secondRoll + " you lose!");
            Output.printToScreen("Your current wallet balance is: " + crapsPlayer.getWallet() + "\nGame Over!");
            out = true;
            //lose statement, wallet decrease
        } else if (secondRoll == point) {
            output.printToScreen("\nYou win! You rolled a " + secondRoll);
            out = true;
            payOut();
            Output.printToScreen("Your current wallet balance is: " + crapsPlayer.getWallet() + "\nGame Over!");
        }
        return out;
    }
}