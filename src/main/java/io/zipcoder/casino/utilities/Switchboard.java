package io.zipcoder.casino.utilities;

public class Switchboard {
    Output output = new Output();
    Input input = new Input();
    String name;
    Boolean isGambler;

    public Switchboard(){}

    public void runMenu(){
        output.welcomeMenu();
        name = output.getPlayerName();

    }

    public void getPlayerType(Integer selection){
        switch (selection){
            case 1:
        }
    }

    public void getBetAmountSorter(Integer selection){}

    public void blackJackOptionsSorter(Integer selection){}

    public void goFishOptionsSorter(Integer selection){}

    public void crapsOptionsSorter(Integer selection){}

    public void otherDiceGameOptionsSorter(Integer selection){}

}
