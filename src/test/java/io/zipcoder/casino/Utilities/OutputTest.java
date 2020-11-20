package io.zipcoder.casino.Utilities;

import io.zipcoder.casino.utilities.Output;
import org.junit.Assert;

public class OutputTest {
//    private final InputStream systemIn = System.in;
//    private final PrintStream systemOut = System.out;
//
//    private ByteArrayInputStream testIn;
//    private ByteArrayOutputStream testOut;

//    @org.junit.Before
//    public void setUpOutput() {
//        testOut = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(testOut));
//    }
//
//    private void provideInput(String data) {
//        testIn = new ByteArrayInputStream(data.getBytes());
//        System.setIn(testIn);
//    }
//
//    private String getOutput() {
//        return testOut.toString();
//    }
//
//    @org.junit.After
//    public void restoreSystemInputOutput() {
//        System.setIn(systemIn);
//        System.setOut(systemOut);
//    }

    @org.junit.Test
    public void TestPrintToScreen() {
        Output output = new Output();
        //given
        String expected = "hello";
        //actual
        String actual = output.printToScreen(expected);
        //then
        Assert.assertEquals(expected, actual);
    }

    @org.junit.Test
    public void TestWelcomeMenu() {
        Output output = new Output();
        //given
        String expected = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n~~~~ Welcome to the Casino ~~~~\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
        //actual
        String actual = output.welcomeMenu();
        //then
        Assert.assertEquals(expected, actual);
    }

    @org.junit.Test
    public void TestGoodbye() {
        Output output = new Output();
        //given
        String expected = "Gambling problem? Help is within reach!\nCall 1-800-522-4700\nNational Gambling Hotline";
        //actual
        String actual = output.goodBye();
        //then
        Assert.assertEquals(expected, actual);
    }

    @org.junit.Test
//   // @RunWith(MockitoJUnitRunner.class)
    public void TestGetPlayerName() {
//        Output output = new Output();
//        final String testString = "SATANS TESTS";
//        provideInput(testString);
//
//        output.getPlayerName();
//        //SimpleProgram.main(new String[0]);
//
//        Assert.assertEquals(testString, getOutput());
    }
//        Output output = new Output();
//        Input input = new Input(System.in, System.out);
//
//        String expectedInput = "christine";
//        input.getStringInput(expectedInput);
//        System.setIn(new ByteArrayInputStream(expectedInput.getBytes()));
//
//        String actualInput = output.getPlayerName();
//        Assert.assertEquals(expectedInput, actualInput);

//        Output output = new Output();
//        Input input = mock(Input.class);
//        when(input.getIntInput("prompt")).thenReturn(1);
//        Boolean expected = true;
//        Boolean actual = output.getPlayerType();
//        Assert.assertEquals(,actual);


    @org.junit.Test
    public void TestIsGambler(){
//        Output output = new Output();
//        //given
//        String expected = "hello";
//        //actual
//        String actual = output.printToScreen(expected);
//        //then
//        Assert.assertEquals(expected,actual);
    }

    @org.junit.Test
    public void TestGetWalletAmount(){
//        Output output = new Output();
//        //given
//        String expected = "hello";
//        //actual
//        String actual = output.printToScreen(expected);
//        //then
//        Assert.assertEquals(expected,actual);
    }

    @org.junit.Test
    public void TestAllGameOptions(){
//        Output output = new Output();
//        //given
//        String expected = "hello";
//        //actual
//        String actual = output.printToScreen(expected);
//        //then
//        Assert.assertEquals(expected,actual);
    }

    @org.junit.Test
    public void TestNonGamblingOptions(){
//        Output output = new Output();
//        //given
//        String expected = "hello";
//        //actual
//        String actual = output.printToScreen(expected);
//        //then
//        Assert.assertEquals(expected,actual);
    }
}