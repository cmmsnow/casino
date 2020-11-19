package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Input;
import io.zipcoder.casino.utilities.Output;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;

public class OutputTest {
    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void TestPrintToScreen(){
        Output output = new Output();
        //given
        String expected = "hello";
        //actual
        String actual = output.printToScreen(expected);
        //then
        Assert.assertEquals(expected,actual);
    }

    @org.junit.Test
    public void TestWelcomeMenu(){
        Output output = new Output();
        //given
        String expected = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n~~~~ Welcome to the Casino ~~~~\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
        //actual
        String actual = output.welcomeMenu();
        //then
        Assert.assertEquals(expected,actual);
    }

    @org.junit.Test
    @RunWith(MockitoJUnitRunner.class)
    public void TestGetPlayerName() {
        Output output = new Output();
        Input input = mock(Input.class);
        when(input.getIntInput("prompt")).thenReturn(1);
        Boolean expected = true;
        Boolean actual = output.getPlayerType();
        Assert.assertEquals(,actual);
    }

    /*@org.junit.Test
    public void TestIsGambler(){
        Output output = new Output();
        //given
        String expected = "hello";
        //actual
        String actual = output.printToScreen(expected);
        //then
        Assert.assertEquals(expected,actual);
    }

    /*@org.junit.Test
    public void TestGetWalletAmount(){
        Output output = new Output();
        //given
        String expected = "hello";
        //actual
        String actual = output.printToScreen(expected);
        //then
        Assert.assertEquals(expected,actual);
    }

    /*@org.junit.Test
    public void TestAllGameOptions(){
        Output output = new Output();
        //given
        String expected = "hello";
        //actual
        String actual = output.printToScreen(expected);
        //then
        Assert.assertEquals(expected,actual);
    }

    /*@org.junit.Test
    public void TestNonGamblingOptions(){
        Output output = new Output();
        //given
        String expected = "hello";
        //actual
        String actual = output.printToScreen(expected);
        //then
        Assert.assertEquals(expected,actual);
    }*/

    @org.junit.Test
    public void TestGoodbye(){
        Output output = new Output();
        //given
        String expected = "Gambling problem? Help is within reach!\nCall 1-800-522-4700\nNational Gambling Hotline";
        //actual
        String actual = output.goodBye();
        //then
        Assert.assertEquals(expected,actual);
    }
}
