package io.zipcoder.casino.utilities;

public class Output {
    Integer selection;
    Double walletAmount;
    String name;

    /**
     * Welcome
     * Get user name
     * Get user type (gambling/non)
     * Get user wallet amt (if gambler)
     * User Game Menu (includes all games)
     * User Game Menu (includes only non gambling games)
     * Quit casino goodbye
     */

    public static String printToScreen(String input){
        System.out.println(input);
        return input;
    }

    public String welcomeMenu(){
        String welc1 = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
        String welc2 = "~~~~ Welcome to the Casino ~~~~\n";
        String welc3 = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
        String printMe = welc1+welc2+welc3;
        printToScreen(printMe);
        return printMe;
    }

    public String getPlayerName(){
        name = Input.getStringInput("Enter your name:  ");
        return name;
    }

    public Boolean getPlayerType(){
        String line1 = "~~~~~~~~~~~ Press 1 to gamble today! ~~~~~~~~~~~~\n";
        String line2 = "~~~~ Press any other number to play it safe! ~~~~\n";
        selection = Input.getIntInput(line1 + line2);
        return selection == 1 ? true:false;
    }

    public Double getWalletAmount(){return walletAmount;}

    public Integer allGameOptions(){return selection;}

    public Integer nonGamblingOptions(){return selection;}

    public Boolean quitCasino(){return true;}

}
